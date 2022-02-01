package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;

public class ServiceLifecycleDispatcher
{
  private final Handler mHandler;
  private ServiceLifecycleDispatcher.DispatchRunnable mLastDispatchRunnable;
  private final LifecycleRegistry mRegistry;
  
  public ServiceLifecycleDispatcher(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    this.mRegistry = new LifecycleRegistry(paramLifecycleOwner);
    this.mHandler = new Handler();
  }
  
  private void postDispatchRunnable(Lifecycle.Event paramEvent)
  {
    if (this.mLastDispatchRunnable != null) {
      this.mLastDispatchRunnable.run();
    }
    this.mLastDispatchRunnable = new ServiceLifecycleDispatcher.DispatchRunnable(this.mRegistry, paramEvent);
    this.mHandler.postAtFrontOfQueue(this.mLastDispatchRunnable);
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mRegistry;
  }
  
  public void onServicePreSuperOnBind()
  {
    postDispatchRunnable(Lifecycle.Event.ON_START);
  }
  
  public void onServicePreSuperOnCreate()
  {
    postDispatchRunnable(Lifecycle.Event.ON_CREATE);
  }
  
  public void onServicePreSuperOnDestroy()
  {
    postDispatchRunnable(Lifecycle.Event.ON_STOP);
    postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onServicePreSuperOnStart()
  {
    postDispatchRunnable(Lifecycle.Event.ON_START);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ServiceLifecycleDispatcher
 * JD-Core Version:    0.7.0.1
 */