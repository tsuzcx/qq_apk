package com.tencent.mobileqq.app.proxy;

import amcg;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class ProxyManager$2
  implements Runnable
{
  ProxyManager$2(ProxyManager paramProxyManager) {}
  
  public void run()
  {
    ProxyManager.a(this.this$0, System.currentTimeMillis());
    while (!this.this$0.a) {
      synchronized (ProxyManager.a(this.this$0))
      {
        try
        {
          this.this$0.c();
          ProxyManager.a(this.this$0).wait(ProxyManager.a());
          ThreadRegulator.a().b();
          if (((!ProxyManager.a(this.this$0).isEmpty()) || (ProxyManager.a(this.this$0).a().size() > 0)) && (ProxyManager.a(this.this$0)))
          {
            this.this$0.d();
            ProxyManager.a(this.this$0).c();
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
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManager.2
 * JD-Core Version:    0.7.0.1
 */