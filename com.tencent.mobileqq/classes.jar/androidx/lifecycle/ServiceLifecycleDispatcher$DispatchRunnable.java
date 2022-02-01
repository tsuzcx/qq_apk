package androidx.lifecycle;

import androidx.annotation.NonNull;

class ServiceLifecycleDispatcher$DispatchRunnable
  implements Runnable
{
  final Lifecycle.Event mEvent;
  private final LifecycleRegistry mRegistry;
  private boolean mWasExecuted = false;
  
  ServiceLifecycleDispatcher$DispatchRunnable(@NonNull LifecycleRegistry paramLifecycleRegistry, Lifecycle.Event paramEvent)
  {
    this.mRegistry = paramLifecycleRegistry;
    this.mEvent = paramEvent;
  }
  
  public void run()
  {
    if (!this.mWasExecuted)
    {
      this.mRegistry.handleLifecycleEvent(this.mEvent);
      this.mWasExecuted = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ServiceLifecycleDispatcher.DispatchRunnable
 * JD-Core Version:    0.7.0.1
 */