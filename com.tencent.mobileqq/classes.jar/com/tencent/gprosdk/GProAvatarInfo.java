package com.tencent.gprosdk;

public final class GProAvatarInfo
{
  final long mTinyId;
  final String mUrl;
  final int mUrlFlag;
  final int mUrlTs;
  
  public GProAvatarInfo(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this.mTinyId = paramLong;
    this.mUrl = paramString;
    this.mUrlFlag = paramInt1;
    this.mUrlTs = paramInt2;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public int getUrlFlag()
  {
    return this.mUrlFlag;
  }
  
  public int getUrlTs()
  {
    return this.mUrlTs;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAvatarInfo{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mUrl=");
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append(",mUrlFlag=");
    localStringBuilder.append(this.mUrlFlag);
    localStringBuilder.append(",mUrlTs=");
    localStringBuilder.append(this.mUrlTs);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAvatarInfo
 * JD-Core Version:    0.7.0.1
 */