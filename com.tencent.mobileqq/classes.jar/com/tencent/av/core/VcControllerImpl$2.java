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
    VcControllerImpl.access$002(this.this$0, this.this$0.close(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int));
    ThreadManager.getUIHandler().removeCallbacks(VcControllerImpl.access$300(this.this$0));
    VcControllerImpl.access$202(this.this$0, -1);
    VcControllerImpl.access$102(this.this$0, null);
    QLog.d("VcControllerImpl", 1, "closeVideo end. mCloseResult = " + VcControllerImpl.access$000(this.this$0));
    synchronized (VcControllerImpl.access$400(this.this$0))
    {
      VcControllerImpl.access$400(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */