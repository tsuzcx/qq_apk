package com.tencent.mobileqq.activity.specialcare;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

class VipSpecialCareHandler$1
  implements Runnable
{
  VipSpecialCareHandler$1(VipSpecialCareHandler paramVipSpecialCareHandler) {}
  
  public void run()
  {
    VipSpecialCareHandler.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    VipSpecialCareHandler.a(this.this$0).start();
    Looper localLooper = VipSpecialCareHandler.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    VipSpecialCareHandler.a(this.this$0, new VipSpecialCareHandler.1.1(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */