package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedVoiceEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_CLOSE_VOICE = 1;
  public static final int EVENT_OPEN_VOICE = 2;
  private int mEvent;
  
  public QCircleFeedVoiceEvent(int paramInt)
  {
    this.mEvent = paramInt;
  }
  
  public int getEvent()
  {
    return this.mEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedVoiceEvent
 * JD-Core Version:    0.7.0.1
 */