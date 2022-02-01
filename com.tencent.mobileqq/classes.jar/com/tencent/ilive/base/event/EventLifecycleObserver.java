package com.tencent.ilive.base.event;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.Map;

public class EventLifecycleObserver
  implements LifecycleObserver
{
  private static final String TAG = "EventLifecycleObserver";
  private EventManger eventManger;
  private LifecycleOwner lifecycleOwner;
  
  public EventLifecycleObserver(LifecycleOwner paramLifecycleOwner, EventManger paramEventManger)
  {
    this.lifecycleOwner = paramLifecycleOwner;
    this.eventManger = paramEventManger;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void onCreate()
  {
    Log.w("EventLifecycleObserver", "onCreate: ");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    Log.w("EventLifecycleObserver", "onDestroy: ");
    this.eventManger.getEventMap().remove(this.lifecycleOwner);
    this.lifecycleOwner.getLifecycle().removeObserver(this);
    this.lifecycleOwner = null;
    this.eventManger = null;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onPause()
  {
    Log.w("EventLifecycleObserver", "onPause: ");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onResume()
  {
    Log.w("EventLifecycleObserver", "onResume: ");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onStart()
  {
    Log.w("EventLifecycleObserver", "onStart: ");
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onStop()
  {
    Log.w("EventLifecycleObserver", "onStop: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.event.EventLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */