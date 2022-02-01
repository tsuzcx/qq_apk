package com.tencent.gprosdk;

public final class GProMsgRouttingHead
{
  final long mChannelId;
  final long mFromTinyid;
  final long mFromUin;
  final long mGuildCode;
  final long mGuildId;
  
  public GProMsgRouttingHead(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.mGuildId = paramLong1;
    this.mChannelId = paramLong2;
    this.mFromUin = paramLong3;
    this.mFromTinyid = paramLong4;
    this.mGuildCode = paramLong5;
  }
  
  public long getChannelId()
  {
    return this.mChannelId;
  }
  
  public long getFromTinyid()
  {
    return this.mFromTinyid;
  }
  
  public long getFromUin()
  {
    return this.mFromUin;
  }
  
  public long getGuildCode()
  {
    return this.mGuildCode;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProMsgRouttingHead{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(",mFromUin=");
    localStringBuilder.append(this.mFromUin);
    localStringBuilder.append(",mFromTinyid=");
    localStringBuilder.append(this.mFromTinyid);
    localStringBuilder.append(",mGuildCode=");
    localStringBuilder.append(this.mGuildCode);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProMsgRouttingHead
 * JD-Core Version:    0.7.0.1
 */