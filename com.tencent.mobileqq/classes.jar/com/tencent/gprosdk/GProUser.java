package com.tencent.gprosdk;

public final class GProUser
{
  int mChnRole;
  GProClientIdentity mClientIdentity;
  GProClientPresence mClientPresence;
  byte[] mCookie;
  long mGuildId;
  boolean mGuildMute;
  boolean mInBlack;
  long mJoinTime;
  String mMemberName;
  String mNickName;
  int mPlatform;
  int mRobotType;
  long mTinyId;
  int mType;
  
  public GProUser(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, long paramLong3, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, byte[] paramArrayOfByte, GProClientIdentity paramGProClientIdentity, GProClientPresence paramGProClientPresence)
  {
    this.mTinyId = paramLong1;
    this.mGuildId = paramLong2;
    this.mMemberName = paramString1;
    this.mNickName = paramString2;
    this.mType = paramInt1;
    this.mJoinTime = paramLong3;
    this.mRobotType = paramInt2;
    this.mChnRole = paramInt3;
    this.mGuildMute = paramBoolean1;
    this.mInBlack = paramBoolean2;
    this.mPlatform = paramInt4;
    this.mCookie = paramArrayOfByte;
    this.mClientIdentity = paramGProClientIdentity;
    this.mClientPresence = paramGProClientPresence;
  }
  
  public int getChnRole()
  {
    return this.mChnRole;
  }
  
  public GProClientIdentity getClientIdentity()
  {
    return this.mClientIdentity;
  }
  
  public GProClientPresence getClientPresence()
  {
    return this.mClientPresence;
  }
  
  public byte[] getCookie()
  {
    return this.mCookie;
  }
  
  public long getGuildId()
  {
    return this.mGuildId;
  }
  
  public boolean getGuildMute()
  {
    return this.mGuildMute;
  }
  
  public boolean getInBlack()
  {
    return this.mInBlack;
  }
  
  public long getJoinTime()
  {
    return this.mJoinTime;
  }
  
  public String getMemberName()
  {
    return this.mMemberName;
  }
  
  public String getNickName()
  {
    return this.mNickName;
  }
  
  public int getPlatform()
  {
    return this.mPlatform;
  }
  
  public int getRobotType()
  {
    return this.mRobotType;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void setChnRole(int paramInt)
  {
    this.mChnRole = paramInt;
  }
  
  public void setClientIdentity(GProClientIdentity paramGProClientIdentity)
  {
    this.mClientIdentity = paramGProClientIdentity;
  }
  
  public void setClientPresence(GProClientPresence paramGProClientPresence)
  {
    this.mClientPresence = paramGProClientPresence;
  }
  
  public void setCookie(byte[] paramArrayOfByte)
  {
    this.mCookie = paramArrayOfByte;
  }
  
  public void setGuildId(long paramLong)
  {
    this.mGuildId = paramLong;
  }
  
  public void setGuildMute(boolean paramBoolean)
  {
    this.mGuildMute = paramBoolean;
  }
  
  public void setInBlack(boolean paramBoolean)
  {
    this.mInBlack = paramBoolean;
  }
  
  public void setJoinTime(long paramLong)
  {
    this.mJoinTime = paramLong;
  }
  
  public void setMemberName(String paramString)
  {
    this.mMemberName = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.mNickName = paramString;
  }
  
  public void setPlatform(int paramInt)
  {
    this.mPlatform = paramInt;
  }
  
  public void setRobotType(int paramInt)
  {
    this.mRobotType = paramInt;
  }
  
  public void setTinyId(long paramLong)
  {
    this.mTinyId = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProUser{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mGuildId=");
    localStringBuilder.append(this.mGuildId);
    localStringBuilder.append(",mMemberName=");
    localStringBuilder.append(this.mMemberName);
    localStringBuilder.append(",mNickName=");
    localStringBuilder.append(this.mNickName);
    localStringBuilder.append(",mType=");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(",mJoinTime=");
    localStringBuilder.append(this.mJoinTime);
    localStringBuilder.append(",mRobotType=");
    localStringBuilder.append(this.mRobotType);
    localStringBuilder.append(",mChnRole=");
    localStringBuilder.append(this.mChnRole);
    localStringBuilder.append(",mGuildMute=");
    localStringBuilder.append(this.mGuildMute);
    localStringBuilder.append(",mInBlack=");
    localStringBuilder.append(this.mInBlack);
    localStringBuilder.append(",mPlatform=");
    localStringBuilder.append(this.mPlatform);
    localStringBuilder.append(",mCookie=");
    localStringBuilder.append(this.mCookie);
    localStringBuilder.append(",mClientIdentity=");
    localStringBuilder.append(this.mClientIdentity);
    localStringBuilder.append(",mClientPresence=");
    localStringBuilder.append(this.mClientPresence);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProUser
 * JD-Core Version:    0.7.0.1
 */