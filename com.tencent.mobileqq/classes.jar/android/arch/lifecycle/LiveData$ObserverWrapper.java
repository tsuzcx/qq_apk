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
    if (paramBoolean == this.mActive) {
      return;
    }
    this.mActive = paramBoolean;
    int i = LiveData.access$300(this.this$0);
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    LiveData localLiveData = this.this$0;
    int k = LiveData.access$300(localLiveData);
    if (!this.mActive) {
      j = -1;
    }
    LiveData.access$302(localLiveData, k + j);
    if ((i != 0) && (this.mActive)) {
      this.this$0.onActive();
    }
    if ((LiveData.access$300(this.this$0) == 0) && (!this.mActive)) {
      this.this$0.onInactive();
    }
    if (this.mActive) {
      LiveData.access$400(this.this$0, this);
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
 * Qualified Name:     android.arch.lifecycle.LiveData.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */