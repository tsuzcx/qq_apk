package androidx.lifecycle;

class LifecycleRegistry$ObserverWithState
{
  LifecycleEventObserver mLifecycleObserver;
  Lifecycle.State mState;
  
  LifecycleRegistry$ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState)
  {
    this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(paramLifecycleObserver);
    this.mState = paramState;
  }
  
  void dispatchEvent(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    Lifecycle.State localState = paramEvent.getTargetState();
    this.mState = LifecycleRegistry.min(this.mState, localState);
    this.mLifecycleObserver.onStateChanged(paramLifecycleOwner, paramEvent);
    this.mState = localState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LifecycleRegistry.ObserverWithState
 * JD-Core Version:    0.7.0.1
 */