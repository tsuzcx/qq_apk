package com.tencent.mobileqq.activity.specialcare;

import alfm;
import alfn;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(alfm paramalfm) {}
  
  public void run()
  {
    alfm.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    alfm.a(this.this$0).start();
    Looper localLooper = alfm.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    alfm.a(this.this$0, new alfn(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */