package com.tencent.ilive.base.event.core;

import androidx.lifecycle.Observer;

class EventImpl$2
  implements Runnable
{
  EventImpl$2(EventImpl paramEventImpl, Observer paramObserver, Object paramObject) {}
  
  public void run()
  {
    this.val$cb.onChanged(this.val$evtObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.event.core.EventImpl.2
 * JD-Core Version:    0.7.0.1
 */