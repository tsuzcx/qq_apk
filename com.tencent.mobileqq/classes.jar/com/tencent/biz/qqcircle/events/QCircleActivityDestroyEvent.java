package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleActivityDestroyEvent
  extends SimpleBaseEvent
{
  private int mContextHash;
  
  public QCircleActivityDestroyEvent(int paramInt)
  {
    this.mContextHash = paramInt;
  }
  
  public int getContextHash()
  {
    return this.mContextHash;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleActivityDestroyEvent
 * JD-Core Version:    0.7.0.1
 */