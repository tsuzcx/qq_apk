package com.tencent.mobileqq.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

class PeakAppCrashReporter$2
  implements Application.ActivityLifecycleCallbacks
{
  PeakAppCrashReporter$2(PeakAppCrashReporter paramPeakAppCrashReporter) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramActivity.getIntent() != null))
    {
      if (paramActivity.getIntent().hasExtra("VIDEO_STORY_FROM_TYPE"))
      {
        PeakAppCrashReporter.a(this.a, paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1));
        paramBundle = new StringBuilder();
        paramBundle.append("onActivityCreated, crashReportEntry == ");
        paramBundle.append(PeakAppCrashReporter.a(this.a));
        QLog.d("PeakAppCrashReporter", 2, paramBundle.toString());
      }
      paramBundle = new Date();
      PeakAppCrashReporter.b(this.a).append(paramActivity.getClass().getSimpleName());
      PeakAppCrashReporter.b(this.a).append(": ");
      PeakAppCrashReporter.b(this.a).append(paramBundle.toString());
      PeakAppCrashReporter.b(this.a).append(", ");
      paramActivity = this.a;
      paramActivity.a(PeakAppCrashReporter.b(paramActivity).toString(), PeakAppCrashReporter.a(this.a));
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppCrashReporter.2
 * JD-Core Version:    0.7.0.1
 */