package com.tencent.ilive.base.event;

import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;

public class PageEvent
{
  public <T extends PageEventInterface> void addObserver(Class<T> paramClass, Observer<T> paramObserver)
  {
    LiveEventBus.get(paramClass.getSimpleName(), paramClass).observeForever(paramObserver);
  }
  
  public void post(PageEventInterface paramPageEventInterface)
  {
    LiveEventBus.get(paramPageEventInterface.getClass().getSimpleName()).post(paramPageEventInterface);
  }
  
  public <T extends PageEventInterface> void removeObserver(Class<T> paramClass, Observer<T> paramObserver)
  {
    LiveEventBus.get(paramClass.getSimpleName(), paramClass).removeObserver(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.event.PageEvent
 * JD-Core Version:    0.7.0.1
 */