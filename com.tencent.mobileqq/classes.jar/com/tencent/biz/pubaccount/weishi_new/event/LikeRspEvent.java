package com.tencent.biz.pubaccount.weishi_new.event;

public class LikeRspEvent
  extends WSSimpleBaseEvent
{
  public static final int REQUEST_POST_DING_FAILED = 4302;
  public static final int REQUEST_POST_DING_SUCCESS = 4301;
  private String feedId;
  private boolean isFromRsp;
  private int position;
  private String posterId;
  private int rpsStatus;
  private int rspIsDing;
  
  public LikeRspEvent(String paramString1, String paramString2, int paramInt)
  {
    this.posterId = paramString1;
    this.feedId = paramString2;
    this.position = paramInt;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getPosterId()
  {
    return this.posterId;
  }
  
  public int getRpsStatus()
  {
    return this.rpsStatus;
  }
  
  public int getRspIsDing()
  {
    return this.rspIsDing;
  }
  
  public boolean isFromRsp()
  {
    return this.isFromRsp;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
  
  public void setFromRsp(boolean paramBoolean)
  {
    this.isFromRsp = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setPosterId(String paramString)
  {
    this.posterId = paramString;
  }
  
  public void setRpsStatus(int paramInt)
  {
    this.rpsStatus = paramInt;
  }
  
  public void setRspIsDing(int paramInt)
  {
    this.rspIsDing = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent
 * JD-Core Version:    0.7.0.1
 */