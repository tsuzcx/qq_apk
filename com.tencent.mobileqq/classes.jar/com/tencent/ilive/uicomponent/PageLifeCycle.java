package com.tencent.ilive.uicomponent;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public abstract interface PageLifeCycle
  extends LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public abstract void onActivityCreate(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public abstract void onActivityDestroy(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public abstract void onActivityPause(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public abstract void onActivityResume(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public abstract void onActivityStart(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public abstract void onActivityStop(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
  public abstract void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.PageLifeCycle
 * JD-Core Version:    0.7.0.1
 */