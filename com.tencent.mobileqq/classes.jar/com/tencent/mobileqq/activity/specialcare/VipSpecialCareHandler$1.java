package com.tencent.mobileqq.activity.specialcare;

import aijz;
import aika;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(aijz paramaijz) {}
  
  public void run()
  {
    aijz.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    aijz.a(this.this$0).start();
    Looper localLooper = aijz.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    aijz.a(this.this$0, new aika(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */