package androidx.lifecycle;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ProcessLifecycleOwner$3
  extends EmptyActivityLifecycleCallbacks
{
  ProcessLifecycleOwner$3(ProcessLifecycleOwner paramProcessLifecycleOwner) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 29) {
      ReportFragment.get(paramActivity).setProcessListener(this.this$0.mInitializationListener);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    this.this$0.activityPaused();
  }
  
  public void onActivityPreCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    paramActivity.registerActivityLifecycleCallbacks(new ProcessLifecycleOwner.3.1(this));
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.this$0.activityStopped();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwner.3
 * JD-Core Version:    0.7.0.1
 */