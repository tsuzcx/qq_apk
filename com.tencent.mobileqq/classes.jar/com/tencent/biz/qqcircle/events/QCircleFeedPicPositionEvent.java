package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class QCircleFeedPicPositionEvent
  extends SimpleBaseEvent
{
  public String mFeedId;
  public int mPicPosition;
  
  public QCircleFeedPicPositionEvent(String paramString, int paramInt)
  {
    this.mFeedId = paramString;
    this.mPicPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent
 * JD-Core Version:    0.7.0.1
 */