package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class GdtMotiveVideoDialog$5
  implements Application.ActivityLifecycleCallbacks
{
  GdtMotiveVideoDialog$5(GdtMotiveVideoDialog paramGdtMotiveVideoDialog) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.e(this.a)) {
      GdtMotiveVideoDialog.c(this.a).m();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.e(this.a)) {
      GdtMotiveVideoDialog.c(this.a).k();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.e(this.a)) {
      GdtMotiveVideoDialog.c(this.a).l();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.5
 * JD-Core Version:    0.7.0.1
 */