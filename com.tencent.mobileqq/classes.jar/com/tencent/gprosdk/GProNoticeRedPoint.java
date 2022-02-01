package com.tencent.gprosdk;

public final class GProNoticeRedPoint
{
  final int mCount;
  final int mExpireTs;
  final int mType;
  
  public GProNoticeRedPoint(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mType = paramInt1;
    this.mCount = paramInt2;
    this.mExpireTs = paramInt3;
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public int getExpireTs()
  {
    return this.mExpireTs;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProNoticeRedPoint{mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mCount=");
    localStringBuilder.append(this.mCount);
    localStringBuilder.append(",mExpireTs=");
    localStringBuilder.append(this.mExpireTs);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProNoticeRedPoint
 * JD-Core Version:    0.7.0.1
 */