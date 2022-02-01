package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  int mActiveCount = 0;
  private boolean mChangingActiveState;
  private volatile Object mData;
  final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap();
  volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new LiveData.1(this);
  private int mVersion;
  
  public LiveData()
  {
    this.mData = NOT_SET;
    this.mVersion = -1;
  }
  
  public LiveData(T paramT)
  {
    this.mData = paramT;
    this.mVersion = 0;
  }
  
  static void assertMainThread(String paramString)
  {
    if (ArchTaskExecutor.getInstance().isMainThread()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void considerNotify(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (!paramLiveData.mActive) {
      return;
    }
    if (!paramLiveData.shouldBeActive())
    {
      paramLiveData.activeStateChanged(false);
      return;
    }
    int i = paramLiveData.mLastVersion;
    int j = this.mVersion;
    if (i >= j) {
      return;
    }
    paramLiveData.mLastVersion = j;
    paramLiveData.mObserver.onChanged(this.mData);
  }
  
  @MainThread
  void changeActiveCounter(int paramInt)
  {
    i = this.mActiveCount;
    this.mActiveCount = (paramInt + i);
    if (this.mChangingActiveState) {
      return;
    }
    this.mChangingActiveState = true;
    for (;;)
    {
      try
      {
        if (i == this.mActiveCount) {
          continue;
        }
        if ((i != 0) || (this.mActiveCount <= 0)) {
          continue;
        }
        paramInt = 1;
      }
      finally
      {
        int j;
        this.mChangingActiveState = false;
        continue;
        throw localObject;
        continue;
        paramInt = 0;
        continue;
        i = 0;
        continue;
      }
      if ((i <= 0) || (this.mActiveCount != 0)) {
        continue;
      }
      i = 1;
      j = this.mActiveCount;
      if (paramInt != 0) {
        onActive();
      } else if (i != 0) {
        onInactive();
      }
      i = j;
    }
    this.mChangingActiveState = false;
  }
  
  void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    do
    {
      this.mDispatchInvalidated = false;
      LiveData<T>.ObserverWrapper localLiveData;
      if (paramLiveData != null)
      {
        considerNotify(paramLiveData);
        localLiveData = null;
      }
      else
      {
        SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mObservers.iteratorWithAdditions();
        do
        {
          localLiveData = paramLiveData;
          if (!localIteratorWithAdditions.hasNext()) {
            break;
          }
          considerNotify((LiveData.ObserverWrapper)((Map.Entry)localIteratorWithAdditions.next()).getValue());
        } while (!this.mDispatchInvalidated);
        localLiveData = paramLiveData;
      }
      paramLiveData = localLiveData;
    } while (this.mDispatchInvalidated);
    this.mDispatchingValue = false;
  }
  
  @Nullable
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != NOT_SET) {
      return localObject;
    }
    return null;
  }
  
  int getVersion()
  {
    return this.mVersion;
  }
  
  public boolean hasActiveObservers()
  {
    return this.mActiveCount > 0;
  }
  
  public boolean hasObservers()
  {
    return this.mObservers.size() > 0;
  }
  
  @MainThread
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super T> paramObserver)
  {
    assertMainThread("observe");
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
      return;
    }
    LiveData.LifecycleBoundObserver localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, paramLifecycleOwner, paramObserver);
    paramObserver = (LiveData.ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localLifecycleBoundObserver);
    if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  @MainThread
  public void observeForever(@NonNull Observer<? super T> paramObserver)
  {
    assertMainThread("observeForever");
    LiveData.AlwaysActiveObserver localAlwaysActiveObserver = new LiveData.AlwaysActiveObserver(this, paramObserver);
    paramObserver = (LiveData.ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if (!(paramObserver instanceof LiveData.LifecycleBoundObserver))
    {
      if (paramObserver != null) {
        return;
      }
      localAlwaysActiveObserver.activeStateChanged(true);
      return;
    }
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.mDataLock)
      {
        if (this.mPendingData == NOT_SET)
        {
          i = 1;
          this.mPendingData = paramT;
          if (i == 0) {
            return;
          }
          ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
          return;
        }
      }
      int i = 0;
    }
  }
  
  @MainThread
  public void removeObserver(@NonNull Observer<? super T> paramObserver)
  {
    assertMainThread("removeObserver");
    paramObserver = (LiveData.ObserverWrapper)this.mObservers.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.detachObserver();
    paramObserver.activeStateChanged(false);
  }
  
  @MainThread
  public void removeObservers(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((LiveData.ObserverWrapper)localEntry.getValue()).isAttachedTo(paramLifecycleOwner)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  @MainThread
  protected void setValue(T paramT)
  {
    assertMainThread("setValue");
    this.mVersion += 1;
    this.mData = paramT;
    dispatchingValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */