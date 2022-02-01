package com.tencent.gprosdk;

public final class GProInviteInfo
{
  final String mBase64Avatar;
  final long mChnId;
  final long mGuildId;
  final String mJoinSig;
  final String mName;
  final String mNickName;
  
  public GProInviteInfo(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mGuildId = paramLong1;
    this.mChnId = paramLong2;
    this.mName = paramString1;
    this.mBase64Avatar = paramString2;
    this.mJoinSig = paramString3;
    this.mNickName = paramString4;
  }
  
  public String getBase64Avatar()
  {
    return this.mBase64Avatar;
  }
  
  public long getChnId()
  {
    return this.mChnId;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public String getJoinSig()
  {
    return this.mJoinSig;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getNickName()
  {
    return this.mNickName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProInviteInfo{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mChnId=");
    localStringBuilder.append(this.mChnId);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mBase64Avatar=");
    localStringBuilder.append(this.mBase64Avatar);
    localStringBuilder.append(",mJoinSig=");
    localStringBuilder.append(this.mJoinSig);
    localStringBuilder.append(",mNickName=");
    localStringBuilder.append(this.mNickName);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProInviteInfo
 * JD-Core Version:    0.7.0.1
 */