package com.tencent.mobileqq.app;

import android.app.Activity;
import axrn;
import mqq.util.WeakReference;

class BaseActivity2$LogActivityOnCreateRunnalbe
  implements Runnable
{
  private WeakReference<Activity> a;
  
  public BaseActivity2$LogActivityOnCreateRunnalbe(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void run()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity != null) {
      axrn.a(localActivity).a(localActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.LogActivityOnCreateRunnalbe
 * JD-Core Version:    0.7.0.1
 */