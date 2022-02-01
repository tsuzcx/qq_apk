package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.imcore.proxy.db.ThreadRegulatorProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class BaseProxyManager$1
  implements Runnable
{
  BaseProxyManager$1(BaseProxyManager paramBaseProxyManager) {}
  
  public void run()
  {
    BaseProxyManager.access$002(this.this$0, System.currentTimeMillis());
    while (!this.this$0.isDestroyed)
    {
      try
      {
        synchronized (this.this$0.msgQueueLock)
        {
          BaseProxyManager.access$100(this.this$0);
          this.this$0.msgQueueLock.wait(BaseProxyManager.access$200());
        }
        if (!this.this$0.msgQueue.isEmpty()) {}
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MsgProxy", 2, "writeRunable Exception:", localException);
        }
        ThreadRegulatorProxy.checkInNextBusiness();
      }
      if ((BaseProxyManager.access$300(this.this$0).getQueue().size() > 0) && (this.this$0.isSaveDBAtOnce()))
      {
        this.this$0.transSaveToDatabase();
        BaseProxyManager.access$300(this.this$0).transSaveToDatabase();
        continue;
        throw localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxyManager.1
 * JD-Core Version:    0.7.0.1
 */