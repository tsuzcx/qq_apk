package com.tencent.gprosdk;

public final class GProMember
{
  final String mName;
  final long mTinyId;
  
  public GProMember(long paramLong, String paramString)
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
    localStringBuilder.append("GProMember{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProMember
 * JD-Core Version:    0.7.0.1
 */