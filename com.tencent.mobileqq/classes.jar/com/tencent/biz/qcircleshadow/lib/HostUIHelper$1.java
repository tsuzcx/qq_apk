package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class HostUIHelper$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      HostUIHelper.access$102(new WeakReference(paramActivity));
      paramBundle = HostUIHelper.access$200().iterator();
      while (paramBundle.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)paramBundle.next()).onEnvironmentCreated(paramActivity);
      }
      HostUIHelper.access$300(paramActivity);
    }
    QLog.d("HostUIHelper", 1, "onActivityCreated");
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$200().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentDestroy(paramActivity);
      }
      if ((HostUIHelper.access$100() != null) && (HostUIHelper.access$100().get() != null) && (paramActivity.hashCode() == ((Context)HostUIHelper.access$100().get()).hashCode())) {
        HostUIHelper.access$500();
      }
    }
    if ((HostUIHelper.isContextShadowActivity(paramActivity)) && (HostUIHelper.access$400() != null) && (HostUIHelper.access$400().get() == paramActivity)) {
      HostUIHelper.access$402(null);
    }
    QLog.d("HostUIHelper", 1, "onActivityDestroyed");
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$200().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentPause(paramActivity);
      }
      if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getBooleanExtra("key_is_auto_close_host", false))) {
        HostUIHelper.closeHostEnvironment();
      }
    }
    QLog.d("HostUIHelper", 1, "onActivityPaused");
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$200().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentResume(paramActivity);
      }
    }
    if (HostUIHelper.isContextShadowActivity(paramActivity)) {
      HostUIHelper.access$402(new WeakReference(paramActivity));
    }
    QLog.d("HostUIHelper", 1, "onActivityResumed");
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$200().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentStarted(paramActivity);
      }
    }
    QLog.d("HostUIHelper", 1, "onActivityStarted");
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$200().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentStop(paramActivity);
      }
    }
    QLog.d("HostUIHelper", 1, "onActivityStopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostUIHelper.1
 * JD-Core Version:    0.7.0.1
 */