package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class GdtMotiveVideoDialog$4
  implements Application.ActivityLifecycleCallbacks
{
  GdtMotiveVideoDialog$4(GdtMotiveVideoDialog paramGdtMotiveVideoDialog) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.a(this.a)) {
      GdtMotiveVideoDialog.a(this.a).j();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.a(this.a)) {
      GdtMotiveVideoDialog.a(this.a).h();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == GdtMotiveVideoDialog.a(this.a)) {
      GdtMotiveVideoDialog.a(this.a).i();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoDialog.4
 * JD-Core Version:    0.7.0.1
 */