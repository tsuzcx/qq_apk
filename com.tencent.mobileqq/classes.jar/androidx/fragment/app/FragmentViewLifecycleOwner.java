package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class FragmentViewLifecycleOwner
  implements LifecycleOwner
{
  private LifecycleRegistry mLifecycleRegistry = null;
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    initialize();
    return this.mLifecycleRegistry;
  }
  
  void handleLifecycleEvent(@NonNull Lifecycle.Event paramEvent)
  {
    this.mLifecycleRegistry.handleLifecycleEvent(paramEvent);
  }
  
  void initialize()
  {
    if (this.mLifecycleRegistry == null) {
      this.mLifecycleRegistry = new LifecycleRegistry(this);
    }
  }
  
  boolean isInitialized()
  {
    return this.mLifecycleRegistry != null;
  }
  
  void setCurrentState(@NonNull Lifecycle.State paramState)
  {
    this.mLifecycleRegistry.setCurrentState(paramState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentViewLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */