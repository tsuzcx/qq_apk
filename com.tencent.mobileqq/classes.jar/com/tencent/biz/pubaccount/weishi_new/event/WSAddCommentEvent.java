package com.tencent.biz.pubaccount.weishi_new.event;

public class WSAddCommentEvent
  extends WSSimpleBaseEvent
{
  private long commentNum;
  private String feedId;
  private int position;
  
  public WSAddCommentEvent(String paramString, int paramInt, long paramLong)
  {
    this.feedId = paramString;
    this.position = paramInt;
    this.commentNum = paramLong;
  }
  
  public long getCommentNum()
  {
    return this.commentNum;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void setCommentNum(long paramLong)
  {
    this.commentNum = paramLong;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent
 * JD-Core Version:    0.7.0.1
 */