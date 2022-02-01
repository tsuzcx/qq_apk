package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.savedstate.SavedStateRegistry;

class SavedStateHandleController$1
  implements LifecycleEventObserver
{
  SavedStateHandleController$1(Lifecycle paramLifecycle, SavedStateRegistry paramSavedStateRegistry) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_START)
    {
      this.val$lifecycle.removeObserver(this);
      this.val$registry.runOnNextRecreation(SavedStateHandleController.OnRecreation.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController.1
 * JD-Core Version:    0.7.0.1
 */