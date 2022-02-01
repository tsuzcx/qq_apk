package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedVideoCurrentTimeEvent
  extends SimpleBaseEvent
{
  private long mCurrentTime;
  
  public QCircleFeedVideoCurrentTimeEvent(long paramLong)
  {
    this.mCurrentTime = paramLong;
  }
  
  public long getCurrentTime()
  {
    return this.mCurrentTime;
  }
  
  public void setCurrentTime(long paramLong)
  {
    this.mCurrentTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent
 * JD-Core Version:    0.7.0.1
 */