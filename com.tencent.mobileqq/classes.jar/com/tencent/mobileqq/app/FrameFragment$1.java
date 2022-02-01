package com.tencent.mobileqq.app;

import android.os.Vibrator;
import com.tencent.qphone.base.util.QLog;

class FrameFragment$1
  implements Runnable
{
  FrameFragment$1(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.T == null) {
        this.this$0.T = ((Vibrator)this.this$0.C().getSystemService("vibrator"));
      }
      this.this$0.T.vibrate(20L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FrameActivity", 2, "Vibrator exception.");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment.1
 * JD-Core Version:    0.7.0.1
 */