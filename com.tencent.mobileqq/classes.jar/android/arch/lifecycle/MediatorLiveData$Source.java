package android.arch.lifecycle;

import android.support.annotation.Nullable;

class MediatorLiveData$Source<V>
  implements Observer<V>
{
  final LiveData<V> mLiveData;
  final Observer<V> mObserver;
  int mVersion = -1;
  
  MediatorLiveData$Source(LiveData<V> paramLiveData, Observer<V> paramObserver)
  {
    this.mLiveData = paramLiveData;
    this.mObserver = paramObserver;
  }
  
  public void onChanged(@Nullable V paramV)
  {
    if (this.mVersion != this.mLiveData.getVersion())
    {
      this.mVersion = this.mLiveData.getVersion();
      this.mObserver.onChanged(paramV);
    }
  }
  
  void plug()
  {
    this.mLiveData.observeForever(this);
  }
  
  void unplug()
  {
    this.mLiveData.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.MediatorLiveData.Source
 * JD-Core Version:    0.7.0.1
 */