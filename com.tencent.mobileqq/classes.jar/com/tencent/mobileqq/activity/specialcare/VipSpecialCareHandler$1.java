package com.tencent.mobileqq.activity.specialcare;

import alyx;
import alyy;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(alyx paramalyx) {}
  
  public void run()
  {
    alyx.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    alyx.a(this.this$0).start();
    Looper localLooper = alyx.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    alyx.a(this.this$0, new alyy(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */