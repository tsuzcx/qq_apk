package com.tencent.gprosdk;

public final class GProNoticeText
{
  final String mContent;
  final long mLinkId;
  final int mType;
  
  public GProNoticeText(int paramInt, String paramString, long paramLong)
  {
    this.mType = paramInt;
    this.mContent = paramString;
    this.mLinkId = paramLong;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public long getLinkId()
  {
    return this.mLinkId;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProNoticeText{mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mContent=");
    localStringBuilder.append(this.mContent);
    localStringBuilder.append(",mLinkId=");
    localStringBuilder.append(this.mLinkId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProNoticeText
 * JD-Core Version:    0.7.0.1
 */