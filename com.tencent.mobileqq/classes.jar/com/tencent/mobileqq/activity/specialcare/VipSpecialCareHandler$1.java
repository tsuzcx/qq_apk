package com.tencent.mobileqq.activity.specialcare;

import akfy;
import akfz;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(akfy paramakfy) {}
  
  public void run()
  {
    akfy.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    akfy.a(this.this$0).start();
    Looper localLooper = akfy.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    akfy.a(this.this$0, new akfz(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */