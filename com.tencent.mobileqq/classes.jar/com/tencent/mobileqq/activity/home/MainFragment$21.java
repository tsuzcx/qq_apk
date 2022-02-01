package com.tencent.mobileqq.activity.home;

import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class MainFragment$21
  implements Runnable
{
  MainFragment$21(MainFragment paramMainFragment) {}
  
  public void run()
  {
    try
    {
      if (MainFragment.a(this.this$0) == null) {
        MainFragment.a(this.this$0, (Vibrator)this.this$0.getActivity().getSystemService("vibrator"));
      }
      MainFragment.a(this.this$0).vibrate(20L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MainFragment", 2, "Vibrator exception.");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.21
 * JD-Core Version:    0.7.0.1
 */