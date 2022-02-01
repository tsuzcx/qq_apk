package com.tencent.falco.base.floatwindow.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class FloatWindowLifecycle$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (paramActivity != null) {
      FloatWindowLifecycle.access$008();
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (paramActivity != null) {
      FloatWindowLifecycle.access$010();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.lifecycle.FloatWindowLifecycle.1
 * JD-Core Version:    0.7.0.1
 */