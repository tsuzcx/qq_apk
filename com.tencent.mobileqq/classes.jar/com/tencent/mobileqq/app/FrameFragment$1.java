package com.tencent.mobileqq.app;

import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class FrameFragment$1
  implements Runnable
{
  FrameFragment$1(FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a == null) {
        this.this$0.a = ((Vibrator)this.this$0.getActivity().getSystemService("vibrator"));
      }
      this.this$0.a.vibrate(20L);
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