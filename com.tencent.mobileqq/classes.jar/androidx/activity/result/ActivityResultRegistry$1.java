package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class ActivityResultRegistry$1
  implements LifecycleEventObserver
{
  ActivityResultRegistry$1(ActivityResultRegistry paramActivityResultRegistry, ActivityResultCallback paramActivityResultCallback, ActivityResultContract paramActivityResultContract, ActivityResult paramActivityResult) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (Lifecycle.Event.ON_START.equals(paramEvent)) {
      this.val$callback.onActivityResult(this.val$contract.parseResult(this.val$pendingResult.getResultCode(), this.val$pendingResult.getData()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultRegistry.1
 * JD-Core Version:    0.7.0.1
 */