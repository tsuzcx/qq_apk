package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class QCirclePraiseUpdateEvent
  extends SimpleBaseEvent
{
  public int mPraisedNum;
  public int mPraisedStatus;
  public String mTargetFeedId;
  
  public QCirclePraiseUpdateEvent(String paramString, int paramInt1, int paramInt2)
  {
    this.mPraisedStatus = paramInt1;
    this.mTargetFeedId = paramString;
    this.mPraisedNum = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent
 * JD-Core Version:    0.7.0.1
 */