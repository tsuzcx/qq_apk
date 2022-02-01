package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class HostUIHelper$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      paramBundle = HostUIHelper.access$100().iterator();
      while (paramBundle.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)paramBundle.next()).onEnvironmentCreated(paramActivity);
      }
      HostUIHelper.access$200(paramActivity);
    }
    QLog.d("HostUIHelper", 1, "onActivityCreated");
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$100().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentDestroy(paramActivity);
      }
    }
    if (HostUIHelper.access$300() == paramActivity) {
      HostUIHelper.access$302(null);
    }
    QLog.d("HostUIHelper", 1, "onActivityDestroyed");
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$100().iterator();
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
      Iterator localIterator = HostUIHelper.access$100().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentResume(paramActivity);
      }
    }
    HostUIHelper.access$302(paramActivity);
    QLog.d("HostUIHelper", 1, "onActivityResumed");
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Iterator localIterator = HostUIHelper.access$100().iterator();
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
      Iterator localIterator = HostUIHelper.access$100().iterator();
      while (localIterator.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)localIterator.next()).onEnvironmentStop(paramActivity);
      }
    }
    QLog.d("HostUIHelper", 1, "onActivityStopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostUIHelper.1
 * JD-Core Version:    0.7.0.1
 */