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
    return "MediaSdkInitInfo:[isEnv=" + this.isEnv + ";sdkAppID=" + this.sdkAppID + ";sdkAccountType=" + this.sdkAccountType + ";selfUin=" + this.selfUin + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RtcInitParam
 * JD-Core Version:    0.7.0.1
 */