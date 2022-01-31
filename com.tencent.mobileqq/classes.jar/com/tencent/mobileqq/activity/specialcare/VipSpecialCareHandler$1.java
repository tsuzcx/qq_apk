package com.tencent.mobileqq.activity.specialcare;

import akbj;
import akbk;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(akbj paramakbj) {}
  
  public void run()
  {
    akbj.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    akbj.a(this.this$0).start();
    Looper localLooper = akbj.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    akbj.a(this.this$0, new akbk(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */