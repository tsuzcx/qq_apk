package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleUndoPushUpdateEvent
  extends SimpleBaseEvent
{
  public String mTargetFeedId;
  
  public QCircleUndoPushUpdateEvent(String paramString)
  {
    this.mTargetFeedId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent
 * JD-Core Version:    0.7.0.1
 */