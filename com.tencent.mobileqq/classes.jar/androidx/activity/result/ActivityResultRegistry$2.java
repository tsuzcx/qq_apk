package androidx.activity.result;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class ActivityResultRegistry$2
  implements LifecycleEventObserver
{
  ActivityResultRegistry$2(ActivityResultRegistry paramActivityResultRegistry, String paramString) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (Lifecycle.Event.ON_DESTROY.equals(paramEvent)) {
      this.this$0.unregister(this.val$key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.2
 * JD-Core Version:    0.7.0.1
 */