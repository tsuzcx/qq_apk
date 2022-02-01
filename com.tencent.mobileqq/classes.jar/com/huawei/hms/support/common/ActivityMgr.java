package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public final class ActivityMgr
  implements Application.ActivityLifecycleCallbacks
{
  public static final ActivityMgr INST = new ActivityMgr();
  private WeakReference<Activity> a;
  
  private static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getName() + '@' + Integer.toHexString(paramObject.hashCode());
  }
  
  public Activity getCurrentActivity()
  {
    if (this.a == null)
    {
      HMSLog.i("ActivityMgr", "mCurrentActivity is " + this.a);
      return null;
    }
    HMSLog.i("ActivityMgr", "mCurrentActivity.get() is " + this.a.get());
    return (Activity)this.a.get();
  }
  
  public void init(Application paramApplication)
  {
    HMSLog.d("ActivityMgr", "init");
    if (paramApplication == null)
    {
      HMSLog.w("ActivityMgr", "init failed for app is null");
      return;
    }
    paramApplication.unregisterActivityLifecycleCallbacks(INST);
    paramApplication.registerActivityLifecycleCallbacks(INST);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    HMSLog.d("ActivityMgr", "onCreated:" + a(paramActivity));
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    HMSLog.d("ActivityMgr", "onResumed:" + a(paramActivity));
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    HMSLog.d("ActivityMgr", "onStarted:" + a(paramActivity));
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.common.ActivityMgr
 * JD-Core Version:    0.7.0.1
 */