package android.arch.lifecycle;

import android.support.annotation.NonNull;

class LiveData$LifecycleBoundObserver
  extends LiveData<T>.ObserverWrapper
  implements GenericLifecycleObserver
{
  @NonNull
  final LifecycleOwner mOwner;
  
  LiveData$LifecycleBoundObserver(@NonNull LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver)
  {
    super(paramLifecycleOwner, localObserver);
    this.mOwner = paramObserver;
  }
  
  void detachObserver()
  {
    this.mOwner.getLifecycle().removeObserver(this);
  }
  
  boolean isAttachedTo(LifecycleOwner paramLifecycleOwner)
  {
    return this.mOwner == paramLifecycleOwner;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
    {
      this.this$0.removeObserver(this.mObserver);
      return;
    }
    activeStateChanged(shouldBeActive());
  }
  
  boolean shouldBeActive()
  {
    return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.lifecycle.LiveData.LifecycleBoundObserver
 * JD-Core Version:    0.7.0.1
 */