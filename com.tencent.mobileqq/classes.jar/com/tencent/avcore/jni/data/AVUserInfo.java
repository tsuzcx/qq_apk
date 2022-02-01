package com.tencent.avcore.jni.data;

public class AVUserInfo
{
  public static final int MIC_AUTH_NONE = 2;
  public static final int MIC_AUTH_OFF = 1;
  public static final int MIC_AUTH_ON = 0;
  public long account = 0L;
  public int accountType = 0;
  public int micAuthByAdmin = 2;
  public String openId = null;
  public int pstnStatus = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVUserInfo{account=");
    localStringBuilder.append(this.account);
    localStringBuilder.append(", openId=[");
    localStringBuilder.append(this.openId);
    localStringBuilder.append(']');
    localStringBuilder.append(", accountType=");
    localStringBuilder.append(this.accountType);
    localStringBuilder.append(", pstnStatus=");
    localStringBuilder.append(this.pstnStatus);
    localStringBuilder.append(", micAuthByAdmin=");
    localStringBuilder.append(this.micAuthByAdmin);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.data.AVUserInfo
 * JD-Core Version:    0.7.0.1
 */