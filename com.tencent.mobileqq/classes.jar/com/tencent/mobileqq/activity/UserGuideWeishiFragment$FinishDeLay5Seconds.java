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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserGuideWeishiFragment", 2, "FinishDeLay5Seconds");
        }
        ((Activity)localObject).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment.FinishDeLay5Seconds
 * JD-Core Version:    0.7.0.1
 */