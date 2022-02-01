package com.tencent.avgame.gameroom.video;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class AVGameLaunchWebHelper$2
  implements Application.ActivityLifecycleCallbacks
{
  AVGameLaunchWebHelper$2(AVGameLaunchWebHelper paramAVGameLaunchWebHelper) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == AVGameLaunchWebHelper.a(this.a))
    {
      AVGameLaunchWebHelper.c(this.a);
      this.a.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == AVGameLaunchWebHelper.a(this.a)) {
      AVGameLaunchWebHelper.b(this.a);
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper.2
 * JD-Core Version:    0.7.0.1
 */