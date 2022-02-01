package com.tencent.gprosdk;

public final class GProAnchorInfo
{
  final String mAnchorIcon;
  final String mAnchorName;
  final int mIdVerifyTimestamp;
  final long mTinyId;
  
  public GProAnchorInfo(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    this.mAnchorName = paramString1;
    this.mAnchorIcon = paramString2;
    this.mIdVerifyTimestamp = paramInt;
    this.mTinyId = paramLong;
  }
  
  public String getAnchorIcon()
  {
    return this.mAnchorIcon;
  }
  
  public String getAnchorName()
  {
    return this.mAnchorName;
  }
  
  public int getIdVerifyTimestamp()
  {
    return this.mIdVerifyTimestamp;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAnchorInfo{mAnchorName=");
    localStringBuilder.append(this.mAnchorName);
    localStringBuilder.append(",mAnchorIcon=");
    localStringBuilder.append(this.mAnchorIcon);
    localStringBuilder.append(",mIdVerifyTimestamp=");
    localStringBuilder.append(this.mIdVerifyTimestamp);
    localStringBuilder.append(",mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAnchorInfo
 * JD-Core Version:    0.7.0.1
 */