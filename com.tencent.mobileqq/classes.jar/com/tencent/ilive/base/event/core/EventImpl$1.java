package com.tencent.ilive.base.event.core;

import androidx.lifecycle.Observer;

class EventImpl$1
  implements Runnable
{
  EventImpl$1(EventImpl paramEventImpl, Observer paramObserver, Object paramObject) {}
  
  public void run()
  {
    this.val$cb.onChanged(this.val$eventObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.event.core.EventImpl.1
 * JD-Core Version:    0.7.0.1
 */