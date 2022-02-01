package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class UserGuideWeishiFragment$FinishDeLay5Seconds
  implements Runnable
{
  private WeakReference<Activity> a;
  
  UserGuideWeishiFragment$FinishDeLay5Seconds(WeakReference<Activity> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void run()
  {
    if (this.a != null)
    {
      Activity localActivity = (Activity)this.a.get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserGuideWeishiFragment", 2, "FinishDeLay5Seconds");
        }
        localActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment.FinishDeLay5Seconds
 * JD-Core Version:    0.7.0.1
 */