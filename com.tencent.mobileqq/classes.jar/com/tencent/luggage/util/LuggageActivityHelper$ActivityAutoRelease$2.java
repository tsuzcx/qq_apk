package com.tencent.luggage.util;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

final class LuggageActivityHelper$ActivityAutoRelease$2
  implements LifecycleObserver
{
  LuggageActivityHelper$ActivityAutoRelease$2(LuggageActivityHelper paramLuggageActivityHelper) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void cleanUp()
  {
    this.a.cleanUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.2
 * JD-Core Version:    0.7.0.1
 */