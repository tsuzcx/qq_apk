package com.tencent.avcore.jni.data;

public class AVUserInfo
{
  public static final int MIC_AUTH_NONE = 2;
  public static final int MIC_AUTH_OFF = 1;
  public static final int MIC_AUTH_ON = 0;
  public long account;
  public int accountType;
  public int micAuthByAdmin = 2;
  public String openId;
  public int pstnStatus;
  
  public String toString()
  {
    return "AVUserInfo{account=" + this.account + ", openId=[" + this.openId + ']' + ", accountType=" + this.accountType + ", pstnStatus=" + this.pstnStatus + ", micAuthByAdmin=" + this.micAuthByAdmin + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avcore.jni.data.AVUserInfo
 * JD-Core Version:    0.7.0.1
 */