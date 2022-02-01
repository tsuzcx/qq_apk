package com.tencent.gprosdk;

public final class GProGuildJoin
{
  final String mAvatar;
  final long mGuildId;
  final int mIsMember;
  final String mJoinSig;
  final String mName;
  final long mUserId;
  final int mUserType;
  
  public GProGuildJoin(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2)
  {
    this.mGuildId = paramLong1;
    this.mName = paramString1;
    this.mAvatar = paramString2;
    this.mJoinSig = paramString3;
    this.mUserId = paramLong2;
    this.mUserType = paramInt1;
    this.mIsMember = paramInt2;
  }
  
  public String getAvatar()
  {
    return this.mAvatar;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public int getIsMember()
  {
    return this.mIsMember;
  }
  
  public String getJoinSig()
  {
    return this.mJoinSig;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getUserId()
  {
    return this.mUserId;
  }
  
  public int getUserType()
  {
    return this.mUserType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildJoin{mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(",mAvatar=");
    localStringBuilder.append(this.mAvatar);
    localStringBuilder.append(",mJoinSig=");
    localStringBuilder.append(this.mJoinSig);
    localStringBuilder.append(",mUserId=");
    localStringBuilder.append(this.mUserId);
    localStringBuilder.append(",mUserType=");
    localStringBuilder.append(this.mUserType);
    localStringBuilder.append(",mIsMember=");
    localStringBuilder.append(this.mIsMember);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildJoin
 * JD-Core Version:    0.7.0.1
 */