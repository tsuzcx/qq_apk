package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class BaseProxyManager$1
  implements Runnable
{
  BaseProxyManager$1(BaseProxyManager paramBaseProxyManager) {}
  
  public void run()
  {
    BaseProxyManager.access$002(this.this$0, System.currentTimeMillis());
    while (!this.this$0.isDestroyed) {
      synchronized (this.this$0.msgQueueLock)
      {
        try
        {
          BaseProxyManager.access$100(this.this$0);
          this.this$0.msgQueueLock.wait(BaseProxyManager.access$200());
          IMCoreProxyRoute.ThreadRegulator.checkInNextBusiness();
          if (((!this.this$0.msgQueue.isEmpty()) || (BaseProxyManager.access$300(this.this$0).getQueue().size() > 0)) && (BaseProxyManager.access$400(this.this$0)))
          {
            this.this$0.transSaveToDatabase();
            BaseProxyManager.access$300(this.this$0).transSaveToDatabase();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MsgProxy", 2, "writeRunable Exception:", localException);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxyManager.1
 * JD-Core Version:    0.7.0.1
 */