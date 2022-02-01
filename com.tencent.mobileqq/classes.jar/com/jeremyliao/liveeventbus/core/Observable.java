package com.jeremyliao.liveeventbus.core;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

public abstract interface Observable<T>
{
  public abstract void broadcast(T paramT);
  
  public abstract void broadcast(T paramT, boolean paramBoolean);
  
  public abstract void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver);
  
  public abstract void observeForever(@NonNull Observer<T> paramObserver);
  
  public abstract void observeSticky(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver);
  
  public abstract void observeStickyForever(@NonNull Observer<T> paramObserver);
  
  public abstract void post(T paramT);
  
  public abstract void postDelay(LifecycleOwner paramLifecycleOwner, T paramT, long paramLong);
  
  public abstract void postDelay(T paramT, long paramLong);
  
  public abstract void postOrderly(T paramT);
  
  public abstract void removeObserver(@NonNull Observer<T> paramObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.core.Observable
 * JD-Core Version:    0.7.0.1
 */