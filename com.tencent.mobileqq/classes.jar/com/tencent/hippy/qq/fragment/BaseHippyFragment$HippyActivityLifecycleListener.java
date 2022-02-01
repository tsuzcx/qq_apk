package com.tencent.hippy.qq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract interface BaseHippyFragment$HippyActivityLifecycleListener
{
  public abstract void onActivityCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract void onActivityPaused(Activity paramActivity);
  
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onActivityResumed(Activity paramActivity);
  
  public abstract void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityStarted(Activity paramActivity);
  
  public abstract void onActivityStopped(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.BaseHippyFragment.HippyActivityLifecycleListener
 * JD-Core Version:    0.7.0.1
 */