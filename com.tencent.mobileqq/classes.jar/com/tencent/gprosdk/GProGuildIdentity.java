package com.tencent.gprosdk;

public final class GProGuildIdentity
{
  final long mAppid;
  final String mOrgID;
  final String mWorldID;
  
  public GProGuildIdentity(long paramLong, String paramString1, String paramString2)
  {
    this.mAppid = paramLong;
    this.mOrgID = paramString1;
    this.mWorldID = paramString2;
  }
  
  public long getAppid()
  {
    return this.mAppid;
  }
  
  public String getOrgID()
  {
    return this.mOrgID;
  }
  
  public String getWorldID()
  {
    return this.mWorldID;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildIdentity{mAppid=");
    localStringBuilder.append(this.mAppid);
    localStringBuilder.append(",mOrgID=");
    localStringBuilder.append(this.mOrgID);
    localStringBuilder.append(",mWorldID=");
    localStringBuilder.append(this.mWorldID);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildIdentity
 * JD-Core Version:    0.7.0.1
 */