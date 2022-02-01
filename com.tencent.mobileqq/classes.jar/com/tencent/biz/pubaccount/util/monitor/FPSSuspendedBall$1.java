package com.tencent.biz.pubaccount.util.monitor;

import android.view.WindowManager;

class FPSSuspendedBall$1
  implements Runnable
{
  FPSSuspendedBall$1(FPSSuspendedBall paramFPSSuspendedBall, WindowManager paramWindowManager) {}
  
  public void run()
  {
    try
    {
      this.a.addView(this.this$0, FPSSuspendedBall.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall.1
 * JD-Core Version:    0.7.0.1
 */