package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;

public class QCircleCommentPraiseUpdateEvent
  extends SimpleBaseEvent
{
  public String mCommentId;
  public String mFeedId;
  public int mPraisedNum;
  public int mPraisedStatus;
  public String mReplyId;
  public int mType;
  
  public QCircleCommentPraiseUpdateEvent(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    this.mType = paramInt1;
    this.mPraisedStatus = paramInt2;
    this.mFeedId = paramString1;
    this.mCommentId = paramString2;
    this.mReplyId = paramString3;
    this.mPraisedNum = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent
 * JD-Core Version:    0.7.0.1
 */