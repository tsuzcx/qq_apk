package androidx.core.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.NonNull;

final class ActivityRecreator$LifecycleCheckCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  Object currentlyRecreatingToken;
  private Activity mActivity;
  private boolean mDestroyed = false;
  private boolean mStarted = false;
  private boolean mStopQueued = false;
  
  ActivityRecreator$LifecycleCheckCallbacks(@NonNull Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mDestroyed = true;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((this.mDestroyed) && (!this.mStopQueued) && (!this.mStarted) && (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, paramActivity)))
    {
      this.mStopQueued = true;
      this.currentlyRecreatingToken = null;
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (this.mActivity == paramActivity) {
      this.mStarted = true;
    }
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks
 * JD-Core Version:    0.7.0.1
 */