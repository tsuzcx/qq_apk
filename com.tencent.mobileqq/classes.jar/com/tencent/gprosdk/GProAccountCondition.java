package com.tencent.gprosdk;

public final class GProAccountCondition
{
  final long mClientId;
  final boolean mIsNeedAuth;
  
  public GProAccountCondition(long paramLong, boolean paramBoolean)
  {
    this.mClientId = paramLong;
    this.mIsNeedAuth = paramBoolean;
  }
  
  public long getClientId()
  {
    return this.mClientId;
  }
  
  public boolean getIsNeedAuth()
  {
    return this.mIsNeedAuth;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAccountCondition{mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mIsNeedAuth=");
    localStringBuilder.append(this.mIsNeedAuth);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAccountCondition
 * JD-Core Version:    0.7.0.1
 */