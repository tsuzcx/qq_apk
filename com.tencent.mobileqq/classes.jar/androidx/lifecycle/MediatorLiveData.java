package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T>
  extends MutableLiveData<T>
{
  private SafeIterableMap<LiveData<?>, MediatorLiveData.Source<?>> mSources = new SafeIterableMap();
  
  @MainThread
  public <S> void addSource(@NonNull LiveData<S> paramLiveData, @NonNull Observer<? super S> paramObserver)
  {
    MediatorLiveData.Source localSource = new MediatorLiveData.Source(paramLiveData, paramObserver);
    paramLiveData = (MediatorLiveData.Source)this.mSources.putIfAbsent(paramLiveData, localSource);
    if ((paramLiveData != null) && (paramLiveData.mObserver != paramObserver)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {}
    while (!hasActiveObservers()) {
      return;
    }
    localSource.plug();
  }
  
  @CallSuper
  protected void onActive()
  {
    Iterator localIterator = this.mSources.iterator();
    while (localIterator.hasNext()) {
      ((MediatorLiveData.Source)((Map.Entry)localIterator.next()).getValue()).plug();
    }
  }
  
  @CallSuper
  protected void onInactive()
  {
    Iterator localIterator = this.mSources.iterator();
    while (localIterator.hasNext()) {
      ((MediatorLiveData.Source)((Map.Entry)localIterator.next()).getValue()).unplug();
    }
  }
  
  @MainThread
  public <S> void removeSource(@NonNull LiveData<S> paramLiveData)
  {
    paramLiveData = (MediatorLiveData.Source)this.mSources.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.unplug();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.MediatorLiveData
 * JD-Core Version:    0.7.0.1
 */