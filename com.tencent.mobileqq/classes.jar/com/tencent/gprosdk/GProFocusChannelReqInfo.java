package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProFocusChannelReqInfo
{
  final ArrayList<Long> mChannleIds;
  final long mGuildId;
  
  public GProFocusChannelReqInfo(long paramLong, ArrayList<Long> paramArrayList)
  {
    this.mGuildId = paramLong;
    this.mChannleIds = paramArrayList;
  }
  
  public ArrayList<Long> getChannleIds()
  {
    return this.mChannleIds;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProFocusChannelReqInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChannleIds=");
    localStringBuilder.append(this.mChannleIds);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProFocusChannelReqInfo
 * JD-Core Version:    0.7.0.1
 */