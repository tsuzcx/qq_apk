package com.tencent.ilive.opensdk.params;

public class RtcInitParam
{
  public int isEnv = 0;
  public int sdkAccountType = 0;
  public int sdkAppID = 0;
  public long selfUin = 0L;
  
  public RtcInitParam()
  {
    this.isEnv = 0;
    this.sdkAppID = 0;
    this.sdkAccountType = 0;
    this.selfUin = 0L;
  }
  
  public RtcInitParam(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.isEnv = paramInt1;
    this.sdkAppID = paramInt2;
    this.sdkAccountType = paramInt3;
    this.selfUin = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MediaSdkInitInfo:[isEnv=");
    localStringBuilder.append(this.isEnv);
    localStringBuilder.append(";sdkAppID=");
    localStringBuilder.append(this.sdkAppID);
    localStringBuilder.append(";sdkAccountType=");
    localStringBuilder.append(this.sdkAccountType);
    localStringBuilder.append(";selfUin=");
    localStringBuilder.append(this.selfUin);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RtcInitParam
 * JD-Core Version:    0.7.0.1
 */