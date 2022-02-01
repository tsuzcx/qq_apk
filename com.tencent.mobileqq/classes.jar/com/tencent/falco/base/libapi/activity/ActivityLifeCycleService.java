package com.tencent.falco.base.libapi.activity;

import android.app.Activity;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface ActivityLifeCycleService
  extends ServiceBaseInterface
{
  public abstract void onActivityCreated(Activity paramActivity);
  
  public abstract void onActivityDestroyed();
  
  public abstract void onActivityPaused();
  
  public abstract void onActivityResumed();
  
  public abstract void onActivityStarted();
  
  public abstract void onActivityStopped();
  
  public abstract void onFinish();
  
  public abstract void onWindowFocusChanged(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.activity.ActivityLifeCycleService
 * JD-Core Version:    0.7.0.1
 */