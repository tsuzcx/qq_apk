package androidx.activity;

import androidx.activity.contextaware.ContextAwareHelper;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

class ComponentActivity$4
  implements LifecycleEventObserver
{
  ComponentActivity$4(ComponentActivity paramComponentActivity) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_DESTROY)
    {
      this.this$0.mContextAwareHelper.clearAvailableContext();
      if (!this.this$0.isChangingConfigurations()) {
        this.this$0.getViewModelStore().clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity.4
 * JD-Core Version:    0.7.0.1
 */