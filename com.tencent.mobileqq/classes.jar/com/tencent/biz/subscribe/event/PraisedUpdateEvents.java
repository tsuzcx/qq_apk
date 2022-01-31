package com.tencent.biz.subscribe.event;

public class PraisedUpdateEvents
  extends SimpleBaseEvent
{
  public int mPraisedStatus;
  public String mTargetFeedId;
  
  public PraisedUpdateEvents(String paramString, int paramInt)
  {
    this.mPraisedStatus = paramInt;
    this.mTargetFeedId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.PraisedUpdateEvents
 * JD-Core Version:    0.7.0.1
 */