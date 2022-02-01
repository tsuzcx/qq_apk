package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QFSShowFeedDebugEvent
  extends SimpleBaseEvent
{
  private final boolean mShowFeedInfo;
  
  public QFSShowFeedDebugEvent(boolean paramBoolean)
  {
    this.mShowFeedInfo = paramBoolean;
  }
  
  public boolean isShowFeedInfo()
  {
    return this.mShowFeedInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.event.QFSShowFeedDebugEvent
 * JD-Core Version:    0.7.0.1
 */