package androidx.lifecycle;

abstract class LiveData$ObserverWrapper
{
  boolean mActive;
  int mLastVersion = -1;
  final Observer<? super T> mObserver;
  
  LiveData$ObserverWrapper(Observer<? super T> paramObserver)
  {
    Object localObject;
    this.mObserver = localObject;
  }
  
  void activeStateChanged(boolean paramBoolean)
  {
    if (paramBoolean == this.mActive) {
      return;
    }
    this.mActive = paramBoolean;
    LiveData localLiveData = this.this$0;
    int i;
    if (this.mActive) {
      i = 1;
    } else {
      i = -1;
    }
    localLiveData.changeActiveCounter(i);
    if (this.mActive) {
      this.this$0.dispatchingValue(this);
    }
  }
  
  void detachObserver() {}
  
  boolean isAttachedTo(LifecycleOwner paramLifecycleOwner)
  {
    return false;
  }
  
  abstract boolean shouldBeActive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveData.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */