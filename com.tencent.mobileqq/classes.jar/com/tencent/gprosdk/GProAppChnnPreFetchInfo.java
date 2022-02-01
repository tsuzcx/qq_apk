package com.tencent.gprosdk;

public final class GProAppChnnPreFetchInfo
{
  final long mChannelId;
  final long mGuildId;
  final String mSeq;
  
  public GProAppChnnPreFetchInfo(long paramLong1, long paramLong2, String paramString)
  {
    this.mGuildId = paramLong1;
    this.mChannelId = paramLong2;
    this.mSeq = paramString;
  }
  
  public long getChannelId()
  {
    return this.mChannelId;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public String getSeq()
  {
    return this.mSeq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAppChnnPreFetchInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(",mSeq=");
    localStringBuilder.append(this.mSeq);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAppChnnPreFetchInfo
 * JD-Core Version:    0.7.0.1
 */