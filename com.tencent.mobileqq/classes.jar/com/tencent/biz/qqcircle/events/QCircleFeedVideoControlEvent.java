package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedVideoControlEvent
  extends SimpleBaseEvent
{
  private boolean mIsPlay;
  
  public QCircleFeedVideoControlEvent(boolean paramBoolean)
  {
    this.mIsPlay = paramBoolean;
  }
  
  public boolean isPlay()
  {
    return this.mIsPlay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent
 * JD-Core Version:    0.7.0.1
 */