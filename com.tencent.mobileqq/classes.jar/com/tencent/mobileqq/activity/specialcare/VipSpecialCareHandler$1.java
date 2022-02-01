package com.tencent.mobileqq.activity.specialcare;

import amdi;
import amdj;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(amdi paramamdi) {}
  
  public void run()
  {
    amdi.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    amdi.a(this.this$0).start();
    Looper localLooper = amdi.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    amdi.a(this.this$0, new amdj(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */