package com.tencent.biz.pubaccount.weishi_new.event;

public class WSDramaFollowEvent
  extends WSSimpleBaseEvent
{
  public static final int STATUS_FOLLOW = 1;
  public static final int STATUS_UNFOLLOW = 0;
  private String dramaId;
  private int status;
  
  public WSDramaFollowEvent(String paramString, int paramInt)
  {
    this.dramaId = paramString;
    this.status = paramInt;
  }
  
  public String getDramaId()
  {
    return this.dramaId;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDramaId(String paramString)
  {
    this.dramaId = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent
 * JD-Core Version:    0.7.0.1
 */