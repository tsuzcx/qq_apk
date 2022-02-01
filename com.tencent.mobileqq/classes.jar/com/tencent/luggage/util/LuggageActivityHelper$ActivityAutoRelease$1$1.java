package com.tencent.luggage.util;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

class LuggageActivityHelper$ActivityAutoRelease$1$1
  implements LifecycleObserver
{
  LuggageActivityHelper$ActivityAutoRelease$1$1(LuggageActivityHelper.ActivityAutoRelease.1 param1) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void cleanUp()
  {
    this.a.b.cleanUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.1.1
 * JD-Core Version:    0.7.0.1
 */