package com.tencent.gprosdk;

public final class GProNoticeCover
{
  final long mLinkId;
  final int mType;
  final String mUrl;
  
  public GProNoticeCover(int paramInt, long paramLong, String paramString)
  {
    this.mType = paramInt;
    this.mLinkId = paramLong;
    this.mUrl = paramString;
  }
  
  public long getLinkId()
  {
    return this.mLinkId;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProNoticeCover{mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mLinkId=");
    localStringBuilder.append(this.mLinkId);
    localStringBuilder.append(",mUrl=");
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProNoticeCover
 * JD-Core Version:    0.7.0.1
 */