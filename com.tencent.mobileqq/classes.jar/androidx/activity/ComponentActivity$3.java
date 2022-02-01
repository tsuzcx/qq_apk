package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

class ComponentActivity$3
  implements LifecycleEventObserver
{
  ComponentActivity$3(ComponentActivity paramComponentActivity) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if ((paramEvent == Lifecycle.Event.ON_DESTROY) && (!this.this$0.isChangingConfigurations())) {
      this.this$0.getViewModelStore().clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.activity.ComponentActivity.3
 * JD-Core Version:    0.7.0.1
 */