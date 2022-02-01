package com.tencent.gprosdk;

public final class GProClientPresence
{
  final String mBigIcon;
  final int mClientId;
  final String mClientName;
  final String mDetails;
  final long mEndTimeStamp;
  final long mPartyMax;
  final long mPartySize;
  final String mRole;
  final long mStartTimeStamp;
  final String mState;
  
  public GProClientPresence(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, long paramLong3, long paramLong4)
  {
    this.mClientId = paramInt;
    this.mClientName = paramString1;
    this.mBigIcon = paramString2;
    this.mState = paramString3;
    this.mDetails = paramString4;
    this.mPartySize = paramLong1;
    this.mPartyMax = paramLong2;
    this.mRole = paramString5;
    this.mStartTimeStamp = paramLong3;
    this.mEndTimeStamp = paramLong4;
  }
  
  public String getBigIcon()
  {
    return this.mBigIcon;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public String getClientName()
  {
    return this.mClientName;
  }
  
  public String getDetails()
  {
    return this.mDetails;
  }
  
  public long getEndTimeStamp()
  {
    return this.mEndTimeStamp;
  }
  
  public long getPartyMax()
  {
    return this.mPartyMax;
  }
  
  public long getPartySize()
  {
    return this.mPartySize;
  }
  
  public String getRole()
  {
    return this.mRole;
  }
  
  public long getStartTimeStamp()
  {
    return this.mStartTimeStamp;
  }
  
  public String getState()
  {
    return this.mState;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientPresence{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mClientName=");
    localStringBuilder.append(this.mClientName);
    localStringBuilder.append(",mBigIcon=");
    localStringBuilder.append(this.mBigIcon);
    localStringBuilder.append(",mState=");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(",mDetails=");
    localStringBuilder.append(this.mDetails);
    localStringBuilder.append(",mPartySize=");
    localStringBuilder.append(this.mPartySize);
    localStringBuilder.append(",mPartyMax=");
    localStringBuilder.append(this.mPartyMax);
    localStringBuilder.append(",mRole=");
    localStringBuilder.append(this.mRole);
    localStringBuilder.append(",mStartTimeStamp=");
    localStringBuilder.append(this.mStartTimeStamp);
    localStringBuilder.append(",mEndTimeStamp=");
    localStringBuilder.append(this.mEndTimeStamp);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProClientPresence
 * JD-Core Version:    0.7.0.1
 */