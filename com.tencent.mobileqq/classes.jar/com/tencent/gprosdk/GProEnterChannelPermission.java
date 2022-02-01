package com.tencent.gprosdk;

public final class GProEnterChannelPermission
{
  final boolean mAllowEnter;
  final boolean mAllowLive;
  final String mDisallowLiveReason;
  final String mDisallowReason;
  
  public GProEnterChannelPermission(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    this.mAllowEnter = paramBoolean1;
    this.mDisallowReason = paramString1;
    this.mAllowLive = paramBoolean2;
    this.mDisallowLiveReason = paramString2;
  }
  
  public boolean getAllowEnter()
  {
    return this.mAllowEnter;
  }
  
  public boolean getAllowLive()
  {
    return this.mAllowLive;
  }
  
  public String getDisallowLiveReason()
  {
    return this.mDisallowLiveReason;
  }
  
  public String getDisallowReason()
  {
    return this.mDisallowReason;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProEnterChannelPermission{mAllowEnter=");
    localStringBuilder.append(this.mAllowEnter);
    localStringBuilder.append(",mDisallowReason=");
    localStringBuilder.append(this.mDisallowReason);
    localStringBuilder.append(",mAllowLive=");
    localStringBuilder.append(this.mAllowLive);
    localStringBuilder.append(",mDisallowLiveReason=");
    localStringBuilder.append(this.mDisallowLiveReason);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProEnterChannelPermission
 * JD-Core Version:    0.7.0.1
 */