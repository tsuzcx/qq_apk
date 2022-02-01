package com.tencent.biz.videostory;

import java.util.TimerTask;

final class EventControlUtils$1
  extends TimerTask
{
  EventControlUtils$1(EventControlUtils.OnDebounceListener paramOnDebounceListener) {}
  
  public void run()
  {
    EventControlUtils.OnDebounceListener localOnDebounceListener = this.a;
    if (localOnDebounceListener != null) {
      localOnDebounceListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.EventControlUtils.1
 * JD-Core Version:    0.7.0.1
 */