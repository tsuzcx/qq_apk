package com.tencent.mobileqq.activity.specialcare;

import aikb;
import aikc;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(aikb paramaikb) {}
  
  public void run()
  {
    aikb.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    aikb.a(this.this$0).start();
    Looper localLooper = aikb.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    aikb.a(this.this$0, new aikc(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */