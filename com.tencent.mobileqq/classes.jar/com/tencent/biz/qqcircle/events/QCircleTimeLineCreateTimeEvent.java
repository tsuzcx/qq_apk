package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleTimeLineCreateTimeEvent
  extends SimpleBaseEvent
{
  public long mFeedCreateTime;
  
  public QCircleTimeLineCreateTimeEvent(long paramLong)
  {
    this.mFeedCreateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleTimeLineCreateTimeEvent
 * JD-Core Version:    0.7.0.1
 */