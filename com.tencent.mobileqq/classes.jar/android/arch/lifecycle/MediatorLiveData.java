package android.arch.lifecycle;

import android.arch.core.internal.SafeIterableMap;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T>
  extends MutableLiveData<T>
{
  private SafeIterableMap<LiveData<?>, MediatorLiveData.Source<?>> mSources = new SafeIterableMap();
  
  @MainThread
  public <S> void addSource(@NonNull LiveData<S> paramLiveData, @NonNull Observer<S> paramObserver)
  {
    MediatorLiveData.Source localSource = new MediatorLiveData.Source(paramLiveData, paramObserver);
    paramLiveData = (MediatorLiveData.Source)this.mSources.putIfAbsent(paramLiveData, localSource);
    if ((paramLiveData == null) || (paramLiveData.mObserver == paramObserver)) {
      if (paramLiveData == null) {
        break label50;
      }
    }
    label50:
    while (!hasActiveObservers())
    {
      return;
      throw new IllegalArgumentException("This source was already added with the different observer");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.arch.lifecycle.MediatorLiveData
 * JD-Core Version:    0.7.0.1
 */