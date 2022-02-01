package com.tencent.gprosdk;

public final class GProEnterChannleInfoResult
{
  final int mAppId;
  final boolean mDefaultMute;
  final boolean mGlobalMute;
  final byte[] mPKey;
  final byte[] mTrtcSig;
  
  public GProEnterChannleInfoResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mTrtcSig = paramArrayOfByte1;
    this.mPKey = paramArrayOfByte2;
    this.mAppId = paramInt;
    this.mDefaultMute = paramBoolean1;
    this.mGlobalMute = paramBoolean2;
  }
  
  public int getAppId()
  {
    return this.mAppId;
  }
  
  public boolean getDefaultMute()
  {
    return this.mDefaultMute;
  }
  
  public boolean getGlobalMute()
  {
    return this.mGlobalMute;
  }
  
  public byte[] getPKey()
  {
    return this.mPKey;
  }
  
  public byte[] getTrtcSig()
  {
    return this.mTrtcSig;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProEnterChannleInfoResult{mTrtcSig=");
    localStringBuilder.append(this.mTrtcSig);
    localStringBuilder.append(",mPKey=");
    localStringBuilder.append(this.mPKey);
    localStringBuilder.append(",mAppId=");
    localStringBuilder.append(this.mAppId);
    localStringBuilder.append(",mDefaultMute=");
    localStringBuilder.append(this.mDefaultMute);
    localStringBuilder.append(",mGlobalMute=");
    localStringBuilder.append(this.mGlobalMute);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProEnterChannleInfoResult
 * JD-Core Version:    0.7.0.1
 */