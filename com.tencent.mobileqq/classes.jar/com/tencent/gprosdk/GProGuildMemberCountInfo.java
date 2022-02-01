package com.tencent.gprosdk;

public final class GProGuildMemberCountInfo
{
  final long mAdminCount;
  final String mErrMsg;
  final long mGuildId;
  final boolean mIsFromServer;
  final long mMaxCount;
  final long mNormalCount;
  final int mResult;
  final long mRobotCount;
  
  public GProGuildMemberCountInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean, int paramInt, String paramString)
  {
    this.mGuildId = paramLong1;
    this.mMaxCount = paramLong2;
    this.mNormalCount = paramLong3;
    this.mAdminCount = paramLong4;
    this.mRobotCount = paramLong5;
    this.mIsFromServer = paramBoolean;
    this.mResult = paramInt;
    this.mErrMsg = paramString;
  }
  
  public long getAdminCount()
  {
    return this.mAdminCount;
  }
  
  public String getErrMsg()
  {
    return this.mErrMsg;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public boolean getIsFromServer()
  {
    return this.mIsFromServer;
  }
  
  public long getMaxCount()
  {
    return this.mMaxCount;
  }
  
  public long getNormalCount()
  {
    return this.mNormalCount;
  }
  
  public int getResult()
  {
    return this.mResult;
  }
  
  public long getRobotCount()
  {
    return this.mRobotCount;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildMemberCountInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mMaxCount=");
    localStringBuilder.append(this.mMaxCount);
    localStringBuilder.append(",mNormalCount=");
    localStringBuilder.append(this.mNormalCount);
    localStringBuilder.append(",mAdminCount=");
    localStringBuilder.append(this.mAdminCount);
    localStringBuilder.append(",mRobotCount=");
    localStringBuilder.append(this.mRobotCount);
    localStringBuilder.append(",mIsFromServer=");
    localStringBuilder.append(this.mIsFromServer);
    localStringBuilder.append(",mResult=");
    localStringBuilder.append(this.mResult);
    localStringBuilder.append(",mErrMsg=");
    localStringBuilder.append(this.mErrMsg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildMemberCountInfo
 * JD-Core Version:    0.7.0.1
 */