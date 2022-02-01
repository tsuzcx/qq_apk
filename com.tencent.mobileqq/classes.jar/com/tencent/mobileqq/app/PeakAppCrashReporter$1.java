package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class PeakAppCrashReporter$1
  implements Application.ActivityLifecycleCallbacks
{
  PeakAppCrashReporter$1(PeakAppCrashReporter paramPeakAppCrashReporter) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    PeakAppCrashReporter.a(this.a).append(paramActivity.getClass().getSimpleName());
    PeakAppCrashReporter.a(this.a).append(", ");
    paramActivity = this.a;
    paramActivity.a(PeakAppCrashReporter.a(paramActivity).toString());
    QLog.d("PeakAppCrashReporter", 2, PeakAppCrashReporter.a(this.a).toString());
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppCrashReporter.1
 * JD-Core Version:    0.7.0.1
 */