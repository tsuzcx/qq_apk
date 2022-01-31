package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class QCircleDoublePraiseAnimationEvent
  extends SimpleBaseEvent
{
  public int mFeedPos;
  public int mPageType;
  public String mTargetFeedId;
  
  public QCircleDoublePraiseAnimationEvent(String paramString, int paramInt1, int paramInt2)
  {
    this.mTargetFeedId = paramString;
    this.mPageType = paramInt1;
    this.mFeedPos = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent
 * JD-Core Version:    0.7.0.1
 */