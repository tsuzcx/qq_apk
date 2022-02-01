package com.tencent.biz.qqcircle.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishMediaDeleteEvent
  extends SimpleBaseEvent
{
  public int position;
  
  public QCirclePublishMediaDeleteEvent(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.event.QCirclePublishMediaDeleteEvent
 * JD-Core Version:    0.7.0.1
 */