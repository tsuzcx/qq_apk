package com.tencent.gprosdk;

public final class GProSourceId
{
  final int mEntranceId;
  final String mSourceId;
  final String mSubSourceId;
  
  public GProSourceId(String paramString1, String paramString2, int paramInt)
  {
    this.mSourceId = paramString1;
    this.mSubSourceId = paramString2;
    this.mEntranceId = paramInt;
  }
  
  public int getEntranceId()
  {
    return this.mEntranceId;
  }
  
  public String getSourceId()
  {
    return this.mSourceId;
  }
  
  public String getSubSourceId()
  {
    return this.mSubSourceId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSourceId{mSourceId=");
    localStringBuilder.append(this.mSourceId);
    localStringBuilder.append(",mSubSourceId=");
    localStringBuilder.append(this.mSubSourceId);
    localStringBuilder.append(",mEntranceId=");
    localStringBuilder.append(this.mEntranceId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProSourceId
 * JD-Core Version:    0.7.0.1
 */