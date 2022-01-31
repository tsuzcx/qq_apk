package android.arch.lifecycle;

class LifecycleRegistry$ObserverWithState
{
  GenericLifecycleObserver mLifecycleObserver;
  Lifecycle.State mState;
  
  LifecycleRegistry$ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState)
  {
    this.mLifecycleObserver = Lifecycling.getCallback(paramLifecycleObserver);
    this.mState = paramState;
  }
  
  void dispatchEvent(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    Lifecycle.State localState = LifecycleRegistry.getStateAfter(paramEvent);
    this.mState = LifecycleRegistry.min(this.mState, localState);
    this.mLifecycleObserver.onStateChanged(paramLifecycleOwner, paramEvent);
    this.mState = localState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleRegistry.ObserverWithState
 * JD-Core Version:    0.7.0.1
 */