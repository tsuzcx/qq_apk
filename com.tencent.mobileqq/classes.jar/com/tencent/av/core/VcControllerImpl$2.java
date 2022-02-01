package com.tencent.av.core;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class VcControllerImpl$2
  implements Runnable
{
  VcControllerImpl$2(VcControllerImpl paramVcControllerImpl, long paramLong, int paramInt) {}
  
  public void run()
  {
    QLog.d("VcControllerImpl", 1, "closeVideo start.");
    ??? = this.this$0;
    VcControllerImpl.access$002((VcControllerImpl)???, ((VcControllerImpl)???).close(this.a, this.b));
    ThreadManager.getUIHandler().removeCallbacks(VcControllerImpl.access$400(this.this$0));
    VcControllerImpl.access$202(this.this$0, -1);
    VcControllerImpl.access$102(this.this$0, null);
    VcControllerImpl.access$500(this.this$0).a(this.a);
    ??? = new StringBuilder();
    ((StringBuilder)???).append("closeVideo end. mCloseResult = ");
    ((StringBuilder)???).append(VcControllerImpl.access$000(this.this$0));
    QLog.d("VcControllerImpl", 1, ((StringBuilder)???).toString());
    synchronized (VcControllerImpl.access$600(this.this$0))
    {
      VcControllerImpl.access$600(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */