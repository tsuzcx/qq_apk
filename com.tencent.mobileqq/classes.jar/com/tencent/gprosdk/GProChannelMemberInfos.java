package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProChannelMemberInfos
{
  final int mChannelMemberCount;
  final int mChannelMemberMax;
  final long mChannleId;
  final ArrayList<GProUser> mMemberList;
  
  public GProChannelMemberInfos(long paramLong, int paramInt1, int paramInt2, ArrayList<GProUser> paramArrayList)
  {
    this.mChannleId = paramLong;
    this.mChannelMemberMax = paramInt1;
    this.mChannelMemberCount = paramInt2;
    this.mMemberList = paramArrayList;
  }
  
  public int getChannelMemberCount()
  {
    return this.mChannelMemberCount;
  }
  
  public int getChannelMemberMax()
  {
    return this.mChannelMemberMax;
  }
  
  public long getChannleId()
  {
    return this.mChannleId;
  }
  
  public ArrayList<GProUser> getMemberList()
  {
    return this.mMemberList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannelMemberInfos{mChannleId=");
    localStringBuilder.append(this.mChannleId);
    localStringBuilder.append(",mChannelMemberMax=");
    localStringBuilder.append(this.mChannelMemberMax);
    localStringBuilder.append(",mChannelMemberCount=");
    localStringBuilder.append(this.mChannelMemberCount);
    localStringBuilder.append(",mMemberList=");
    localStringBuilder.append(this.mMemberList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProChannelMemberInfos
 * JD-Core Version:    0.7.0.1
 */