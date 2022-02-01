package androidx.lifecycle;

import android.app.Activity;
import androidx.annotation.NonNull;

class ProcessLifecycleOwner$3$1
  extends EmptyActivityLifecycleCallbacks
{
  ProcessLifecycleOwner$3$1(ProcessLifecycleOwner.3 param3) {}
  
  public void onActivityPostResumed(@NonNull Activity paramActivity)
  {
    this.this$1.this$0.activityResumed();
  }
  
  public void onActivityPostStarted(@NonNull Activity paramActivity)
  {
    this.this$1.this$0.activityStarted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwner.3.1
 * JD-Core Version:    0.7.0.1
 */