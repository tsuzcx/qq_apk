package com.tencent.biz.subscribe.event;

public class PraisedUpdateEvents
  extends SimpleBaseEvent
{
  public int mPraisedNum;
  public int mPraisedStatus;
  public String mTargetFeedId;
  
  public PraisedUpdateEvents(String paramString, int paramInt1, int paramInt2)
  {
    this.mPraisedStatus = paramInt1;
    this.mTargetFeedId = paramString;
    this.mPraisedNum = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.PraisedUpdateEvents
 * JD-Core Version:    0.7.0.1
 */