package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract interface BaseActivityLifecycleCallbacks
{
  public abstract void doOnActivityCreate(Activity paramActivity, Bundle paramBundle);
  
  public abstract void doOnActivityDestroyed(Activity paramActivity);
  
  public abstract void doOnActivityOnStart(Activity paramActivity);
  
  public abstract void doOnActivityPause(Activity paramActivity);
  
  public abstract void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void doOnActivityPostPaused(Activity paramActivity);
  
  public abstract void doOnActivityPostResumed(Activity paramActivity);
  
  public abstract void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void doOnActivityPrePaused(Activity paramActivity);
  
  public abstract void doOnActivityPreResumed(Activity paramActivity);
  
  public abstract void doOnActivityResume(Activity paramActivity);
  
  public abstract void doOnActivityStopped(Activity paramActivity);
  
  public abstract void doOnNewIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean);
  
  public abstract void onAccountChanged(Activity paramActivity);
  
  public abstract void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean);
  
  public abstract void onPostThemeChanged(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */