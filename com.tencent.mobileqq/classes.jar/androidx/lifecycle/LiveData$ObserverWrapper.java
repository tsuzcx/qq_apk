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
    int j = 1;
    if (paramBoolean == this.mActive) {
      return;
    }
    this.mActive = paramBoolean;
    int i;
    label28:
    LiveData localLiveData;
    int k;
    if (this.this$0.mActiveCount == 0)
    {
      i = 1;
      localLiveData = this.this$0;
      k = localLiveData.mActiveCount;
      if (!this.mActive) {
        break label120;
      }
    }
    for (;;)
    {
      localLiveData.mActiveCount = (j + k);
      if ((i != 0) && (this.mActive)) {
        this.this$0.onActive();
      }
      if ((this.this$0.mActiveCount == 0) && (!this.mActive)) {
        this.this$0.onInactive();
      }
      if (!this.mActive) {
        break;
      }
      this.this$0.dispatchingValue(this);
      return;
      i = 0;
      break label28;
      label120:
      j = -1;
    }
  }
  
  void detachObserver() {}
  
  boolean isAttachedTo(LifecycleOwner paramLifecycleOwner)
  {
    return false;
  }
  
  abstract boolean shouldBeActive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.LiveData.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */