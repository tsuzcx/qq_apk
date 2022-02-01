package com.tencent.gprosdk;

public final class GProSourceInfo
{
  final String mFlagId;
  final String mOpenId;
  final String mSceneId;
  final long mSourceApp;
  
  public GProSourceInfo(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.mSourceApp = paramLong;
    this.mSceneId = paramString1;
    this.mOpenId = paramString2;
    this.mFlagId = paramString3;
  }
  
  public String getFlagId()
  {
    return this.mFlagId;
  }
  
  public String getOpenId()
  {
    return this.mOpenId;
  }
  
  public String getSceneId()
  {
    return this.mSceneId;
  }
  
  public long getSourceApp()
  {
    return this.mSourceApp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSourceInfo{mSourceApp=");
    localStringBuilder.append(this.mSourceApp);
    localStringBuilder.append(",mSceneId=");
    localStringBuilder.append(this.mSceneId);
    localStringBuilder.append(",mOpenId=");
    localStringBuilder.append(this.mOpenId);
    localStringBuilder.append(",mFlagId=");
    localStringBuilder.append(this.mFlagId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProSourceInfo
 * JD-Core Version:    0.7.0.1
 */