package com.tencent.biz.videostory;

import java.util.TimerTask;

final class EventControlUtils$2
  extends TimerTask
{
  public void run()
  {
    EventControlUtils.OnDebounceListener localOnDebounceListener = this.a;
    if (localOnDebounceListener != null) {
      localOnDebounceListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.EventControlUtils.2
 * JD-Core Version:    0.7.0.1
 */