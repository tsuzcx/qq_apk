package androidx.lifecycle;

import androidx.annotation.NonNull;

class LiveData$LifecycleBoundObserver
  extends LiveData<T>.ObserverWrapper
  implements LifecycleEventObserver
{
  @NonNull
  final LifecycleOwner mOwner;
  
  LiveData$LifecycleBoundObserver(LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super T> paramObserver)
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
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    paramLifecycleOwner = this.mOwner.getLifecycle().getCurrentState();
    if (paramLifecycleOwner == Lifecycle.State.DESTROYED)
    {
      this.this$0.removeObserver(this.mObserver);
      return;
    }
    paramEvent = null;
    while (paramEvent != paramLifecycleOwner)
    {
      activeStateChanged(shouldBeActive());
      Lifecycle.State localState = this.mOwner.getLifecycle().getCurrentState();
      paramEvent = paramLifecycleOwner;
      paramLifecycleOwner = localState;
    }
  }
  
  boolean shouldBeActive()
  {
    return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveData.LifecycleBoundObserver
 * JD-Core Version:    0.7.0.1
 */