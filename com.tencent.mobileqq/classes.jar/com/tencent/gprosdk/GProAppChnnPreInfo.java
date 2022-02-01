package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProAppChnnPreInfo
{
  final long mAppid;
  final long mChannelId;
  final ArrayList<GProChannelPresenceInfo> mChnnPreList;
  final String mChnnPreSeq;
  final long mGuildId;
  final GProJoinCondition mJoinCondition;
  final int mJumpType;
  final String mJumpUrl;
  final int mNextTimeStamp;
  final int mResult;
  final String mText;
  
  public GProAppChnnPreInfo(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString1, int paramInt2, String paramString2, ArrayList<GProChannelPresenceInfo> paramArrayList, String paramString3, int paramInt3, GProJoinCondition paramGProJoinCondition)
  {
    this.mGuildId = paramLong1;
    this.mChannelId = paramLong2;
    this.mAppid = paramLong3;
    this.mResult = paramInt1;
    this.mJumpUrl = paramString1;
    this.mJumpType = paramInt2;
    this.mText = paramString2;
    this.mChnnPreList = paramArrayList;
    this.mChnnPreSeq = paramString3;
    this.mNextTimeStamp = paramInt3;
    this.mJoinCondition = paramGProJoinCondition;
  }
  
  public long getAppid()
  {
    return this.mAppid;
  }
  
  public long getChannelId()
  {
    return this.mChannelId;
  }
  
  public ArrayList<GProChannelPresenceInfo> getChnnPreList()
  {
    return this.mChnnPreList;
  }
  
  public String getChnnPreSeq()
  {
    return this.mChnnPreSeq;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public GProJoinCondition getJoinCondition()
  {
    return this.mJoinCondition;
  }
  
  public int getJumpType()
  {
    return this.mJumpType;
  }
  
  public String getJumpUrl()
  {
    return this.mJumpUrl;
  }
  
  public int getNextTimeStamp()
  {
    return this.mNextTimeStamp;
  }
  
  public int getResult()
  {
    return this.mResult;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAppChnnPreInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChannelId=");
    localStringBuilder.append(this.mChannelId);
    localStringBuilder.append(",mAppid=");
    localStringBuilder.append(this.mAppid);
    localStringBuilder.append(",mResult=");
    localStringBuilder.append(this.mResult);
    localStringBuilder.append(",mJumpUrl=");
    localStringBuilder.append(this.mJumpUrl);
    localStringBuilder.append(",mJumpType=");
    localStringBuilder.append(this.mJumpType);
    localStringBuilder.append(",mText=");
    localStringBuilder.append(this.mText);
    localStringBuilder.append(",mChnnPreList=");
    localStringBuilder.append(this.mChnnPreList);
    localStringBuilder.append(",mChnnPreSeq=");
    localStringBuilder.append(this.mChnnPreSeq);
    localStringBuilder.append(",mNextTimeStamp=");
    localStringBuilder.append(this.mNextTimeStamp);
    localStringBuilder.append(",mJoinCondition=");
    localStringBuilder.append(this.mJoinCondition);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAppChnnPreInfo
 * JD-Core Version:    0.7.0.1
 */