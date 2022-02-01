package com.tencent.gprosdk;

public final class GProChannelPresenceItemInfo
{
  final int mJumpType;
  final String mJumpUrl;
  final String mText;
  
  public GProChannelPresenceItemInfo(String paramString1, String paramString2, int paramInt)
  {
    this.mText = paramString1;
    this.mJumpUrl = paramString2;
    this.mJumpType = paramInt;
  }
  
  public int getJumpType()
  {
    return this.mJumpType;
  }
  
  public String getJumpUrl()
  {
    return this.mJumpUrl;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannelPresenceItemInfo{mText=");
    localStringBuilder.append(this.mText);
    localStringBuilder.append(",mJumpUrl=");
    localStringBuilder.append(this.mJumpUrl);
    localStringBuilder.append(",mJumpType=");
    localStringBuilder.append(this.mJumpType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProChannelPresenceItemInfo
 * JD-Core Version:    0.7.0.1
 */