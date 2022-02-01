package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ReportFragment$LifecycleCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle) {}
  
  public void onActivityDestroyed(@NonNull Activity paramActivity) {}
  
  public void onActivityPaused(@NonNull Activity paramActivity) {}
  
  public void onActivityPostCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_CREATE);
  }
  
  public void onActivityPostResumed(@NonNull Activity paramActivity)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_RESUME);
  }
  
  public void onActivityPostStarted(@NonNull Activity paramActivity)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_START);
  }
  
  public void onActivityPreDestroyed(@NonNull Activity paramActivity)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_DESTROY);
  }
  
  public void onActivityPrePaused(@NonNull Activity paramActivity)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_PAUSE);
  }
  
  public void onActivityPreStopped(@NonNull Activity paramActivity)
  {
    ReportFragment.dispatch(paramActivity, Lifecycle.Event.ON_STOP);
  }
  
  public void onActivityResumed(@NonNull Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(@NonNull Activity paramActivity, @NonNull Bundle paramBundle) {}
  
  public void onActivityStarted(@NonNull Activity paramActivity) {}
  
  public void onActivityStopped(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ReportFragment.LifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */