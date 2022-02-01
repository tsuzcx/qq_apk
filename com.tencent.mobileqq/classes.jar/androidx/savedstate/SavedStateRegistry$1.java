package androidx.savedstate;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;

class SavedStateRegistry$1
  implements GenericLifecycleObserver
{
  SavedStateRegistry$1(SavedStateRegistry paramSavedStateRegistry) {}
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_START)
    {
      this.this$0.mAllowingSavingState = true;
      return;
    }
    if (paramEvent == Lifecycle.Event.ON_STOP) {
      this.this$0.mAllowingSavingState = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.savedstate.SavedStateRegistry.1
 * JD-Core Version:    0.7.0.1
 */