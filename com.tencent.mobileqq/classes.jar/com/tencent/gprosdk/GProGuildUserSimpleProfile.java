package com.tencent.gprosdk;

public final class GProGuildUserSimpleProfile
{
  int mAvatarSizeFlag;
  long mAvatarTimeStamp;
  String mAvatarUrl;
  int mClientId;
  String mDesc;
  String mNick;
  long mTinyId;
  
  public GProGuildUserSimpleProfile(long paramLong1, String paramString1, int paramInt1, long paramLong2, String paramString2, int paramInt2, String paramString3)
  {
    this.mTinyId = paramLong1;
    this.mAvatarUrl = paramString1;
    this.mAvatarSizeFlag = paramInt1;
    this.mAvatarTimeStamp = paramLong2;
    this.mNick = paramString2;
    this.mClientId = paramInt2;
    this.mDesc = paramString3;
  }
  
  public int getAvatarSizeFlag()
  {
    return this.mAvatarSizeFlag;
  }
  
  public long getAvatarTimeStamp()
  {
    return this.mAvatarTimeStamp;
  }
  
  public String getAvatarUrl()
  {
    return this.mAvatarUrl;
  }
  
  public int getClientId()
  {
    return this.mClientId;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public String getNick()
  {
    return this.mNick;
  }
  
  public long getTinyId()
  {
    return this.mTinyId;
  }
  
  public void setAvatarSizeFlag(int paramInt)
  {
    this.mAvatarSizeFlag = paramInt;
  }
  
  public void setAvatarTimeStamp(long paramLong)
  {
    this.mAvatarTimeStamp = paramLong;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.mAvatarUrl = paramString;
  }
  
  public void setClientId(int paramInt)
  {
    this.mClientId = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.mDesc = paramString;
  }
  
  public void setNick(String paramString)
  {
    this.mNick = paramString;
  }
  
  public void setTinyId(long paramLong)
  {
    this.mTinyId = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProGuildUserSimpleProfile{mTinyId=");
    localStringBuilder.append(this.mTinyId);
    localStringBuilder.append(",mAvatarUrl=");
    localStringBuilder.append(this.mAvatarUrl);
    localStringBuilder.append(",mAvatarSizeFlag=");
    localStringBuilder.append(this.mAvatarSizeFlag);
    localStringBuilder.append(",mAvatarTimeStamp=");
    localStringBuilder.append(this.mAvatarTimeStamp);
    localStringBuilder.append(",mNick=");
    localStringBuilder.append(this.mNick);
    localStringBuilder.append(",mClientId=");
    localStringBuilder.append(this.mClientId);
    localStringBuilder.append(",mDesc=");
    localStringBuilder.append(this.mDesc);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProGuildUserSimpleProfile
 * JD-Core Version:    0.7.0.1
 */