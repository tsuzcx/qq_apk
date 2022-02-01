package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSPageSelectEvent
  extends SimpleBaseEvent
{
  public int mSelectPosition;
  
  public QFSPageSelectEvent(int paramInt)
  {
    this.mSelectPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent
 * JD-Core Version:    0.7.0.1
 */