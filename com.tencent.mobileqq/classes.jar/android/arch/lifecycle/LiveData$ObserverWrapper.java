package android.arch.lifecycle;

abstract class LiveData$ObserverWrapper
{
  boolean mActive;
  int mLastVersion = -1;
  final Observer<T> mObserver;
  
  LiveData$ObserverWrapper(Observer<T> paramObserver)
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
    if (LiveData.access$300(this.this$0) == 0)
    {
      i = 1;
      localLiveData = this.this$0;
      k = LiveData.access$300(localLiveData);
      if (!this.mActive) {
        break label121;
      }
    }
    for (;;)
    {
      LiveData.access$302(localLiveData, j + k);
      if ((i != 0) && (this.mActive)) {
        this.this$0.onActive();
      }
      if ((LiveData.access$300(this.this$0) == 0) && (!this.mActive)) {
        this.this$0.onInactive();
      }
      if (!this.mActive) {
        break;
      }
      LiveData.access$400(this.this$0, this);
      return;
      i = 0;
      break label28;
      label121:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.lifecycle.LiveData.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */