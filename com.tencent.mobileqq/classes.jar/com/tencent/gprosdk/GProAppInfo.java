package com.tencent.gprosdk;

import java.util.ArrayList;

public final class GProAppInfo
{
  final String mAppDescription;
  final String mAppName;
  final long mAppid;
  final String mIconUrl;
  final ArrayList<String> mPreViewList;
  
  public GProAppInfo(long paramLong, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList)
  {
    this.mAppid = paramLong;
    this.mIconUrl = paramString1;
    this.mAppName = paramString2;
    this.mAppDescription = paramString3;
    this.mPreViewList = paramArrayList;
  }
  
  public String getAppDescription()
  {
    return this.mAppDescription;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public long getAppid()
  {
    return this.mAppid;
  }
  
  public String getIconUrl()
  {
    return this.mIconUrl;
  }
  
  public ArrayList<String> getPreViewList()
  {
    return this.mPreViewList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProAppInfo{mAppid=");
    localStringBuilder.append(this.mAppid);
    localStringBuilder.append(",mIconUrl=");
    localStringBuilder.append(this.mIconUrl);
    localStringBuilder.append(",mAppName=");
    localStringBuilder.append(this.mAppName);
    localStringBuilder.append(",mAppDescription=");
    localStringBuilder.append(this.mAppDescription);
    localStringBuilder.append(",mPreViewList=");
    localStringBuilder.append(this.mPreViewList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProAppInfo
 * JD-Core Version:    0.7.0.1
 */