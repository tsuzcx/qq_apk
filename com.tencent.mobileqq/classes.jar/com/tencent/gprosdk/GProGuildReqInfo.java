package com.tencent.gprosdk;

public final class GProGuildReqInfo
{
  final long mChannelChangeSeq;
  final long mGuildChangeSeq;
  final long mGuildId;
  
  public GProGuildReqInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mGuildId = paramLong1;
    this.mGuildChangeSeq = paramLong2;
    this.mChannelChangeSeq = paramLong3;
  }
  
  public long getChannelChangeSeq()
  {
    return this.mChannelChangeSeq;
  }
  
  public long getGuildChangeSeq()
  {
    return this.mGuildChangeSeq;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildReqInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mGuildChangeSeq=");
    localStringBuilder.append(this.mGuildChangeSeq);
    localStringBuilder.append(",mChannelChangeSeq=");
    localStringBuilder.append(this.mChannelChangeSeq);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildReqInfo
 * JD-Core Version:    0.7.0.1
 */