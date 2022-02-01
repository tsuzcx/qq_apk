package com.tencent.biz.qqcircle.launchbean;

public class QCircleLikeBean
  extends QCircleInitBean
{
  private int count;
  private String likeId;
  private int requestType;
  private long time;
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getLikeId()
  {
    return this.likeId;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setLikeId(String paramString)
  {
    this.likeId = paramString;
  }
  
  public void setRequestType(int paramInt)
  {
    this.requestType = paramInt;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launchbean.QCircleLikeBean
 * JD-Core Version:    0.7.0.1
 */