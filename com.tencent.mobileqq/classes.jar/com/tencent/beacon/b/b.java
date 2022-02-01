package com.tencent.beacon.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class b
  implements Application.ActivityLifecycleCallbacks
{
  public void a(Activity paramActivity)
  {
    com.tencent.beacon.a.c.b.d = true;
    paramActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.b.b
 * JD-Core Version:    0.7.0.1
 */