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
  public WeakReference<Activity> a;
  
  public static String a(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return localStringBuilder.toString();
  }
  
  public Activity getCurrentActivity()
  {
    if (this.a == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCurrentActivity is ");
      localStringBuilder.append(this.a);
      HMSLog.i("ActivityMgr", localStringBuilder.toString());
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCurrentActivity.get() is ");
    localStringBuilder.append(this.a.get());
    HMSLog.i("ActivityMgr", localStringBuilder.toString());
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
    paramBundle = new StringBuilder();
    paramBundle.append("onCreated:");
    paramBundle.append(a(paramActivity));
    HMSLog.d("ActivityMgr", paramBundle.toString());
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumed:");
    localStringBuilder.append(a(paramActivity));
    HMSLog.d("ActivityMgr", localStringBuilder.toString());
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStarted:");
    localStringBuilder.append(a(paramActivity));
    HMSLog.d("ActivityMgr", localStringBuilder.toString());
    this.a = new WeakReference(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.common.ActivityMgr
 * JD-Core Version:    0.7.0.1
 */