package com.tencent.falco.base.libapi.activitylife;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract interface ActivityLifeService
  extends ServiceBaseInterface
{
  public abstract void addAppStatusListener(AppStatusListener paramAppStatusListener);
  
  public abstract void addAppStatusListenerByWeakRef(AppStatusListener paramAppStatusListener);
  
  public abstract void finishAllActivity();
  
  public abstract Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks();
  
  public abstract List<WeakReference<Activity>> getAliveActivityList();
  
  public abstract Activity getTopActivity();
  
  public abstract void removeAppStatusListener(AppStatusListener paramAppStatusListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.activitylife.ActivityLifeService
 * JD-Core Version:    0.7.0.1
 */