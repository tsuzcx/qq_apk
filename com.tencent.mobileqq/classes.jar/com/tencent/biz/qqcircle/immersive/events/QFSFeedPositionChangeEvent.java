package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSFeedPositionChangeEvent
  extends SimpleBaseEvent
{
  private int mPosition;
  
  public QFSFeedPositionChangeEvent(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent
 * JD-Core Version:    0.7.0.1
 */