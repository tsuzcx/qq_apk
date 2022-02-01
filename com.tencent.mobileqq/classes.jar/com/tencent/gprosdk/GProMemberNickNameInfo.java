package com.tencent.gprosdk;

public final class GProMemberNickNameInfo
{
  final String mName;
  final long mTinyId;
  
  public GProMemberNickNameInfo(long paramLong, String paramString)
  {
    this.mTinyId = paramLong;
    this.mName = paramString;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProMemberNickNameInfo{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProMemberNickNameInfo
 * JD-Core Version:    0.7.0.1
 */