package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePersonInfoNumUpdateEvent
  extends SimpleBaseEvent
{
  public final int hashCode;
  public final QCirclePersonInfoNumUpdateEvent.PersonNumInfo numInfo;
  
  public QCirclePersonInfoNumUpdateEvent(int paramInt, QCirclePersonInfoNumUpdateEvent.PersonNumInfo paramPersonNumInfo)
  {
    this.hashCode = paramInt;
    this.numInfo = paramPersonNumInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePersonInfoNumUpdateEvent
 * JD-Core Version:    0.7.0.1
 */