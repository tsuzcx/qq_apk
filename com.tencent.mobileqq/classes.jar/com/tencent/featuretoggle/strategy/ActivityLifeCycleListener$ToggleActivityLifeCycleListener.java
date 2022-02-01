package com.tencent.featuretoggle.strategy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
class ActivityLifeCycleListener$ToggleActivityLifeCycleListener
  implements Application.ActivityLifecycleCallbacks
{
  private ActivityLifeCycleListener$ToggleActivityLifeCycleListener(ActivityLifeCycleListener paramActivityLifeCycleListener) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    TogglePageStrategy.a().b(paramActivity, paramActivity.getLocalClassName());
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    TogglePageStrategy.a().a(paramActivity, paramActivity.getLocalClassName());
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.ActivityLifeCycleListener.ToggleActivityLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */