package com.tencent.mm.opensdk.diffdev;

public enum OAuthErrCode
{
  private int code;
  
  static
  {
    WechatAuth_Err_NormalErr = new OAuthErrCode("WechatAuth_Err_NormalErr", 1, -1);
    WechatAuth_Err_NetworkErr = new OAuthErrCode("WechatAuth_Err_NetworkErr", 2, -2);
    WechatAuth_Err_JsonDecodeErr = new OAuthErrCode("WechatAuth_Err_JsonDecodeErr", 3, -3);
    WechatAuth_Err_Cancel = new OAuthErrCode("WechatAuth_Err_Cancel", 4, -4);
    WechatAuth_Err_Timeout = new OAuthErrCode("WechatAuth_Err_Timeout", 5, -5);
    OAuthErrCode localOAuthErrCode = new OAuthErrCode("WechatAuth_Err_Auth_Stopped", 6, -6);
    WechatAuth_Err_Auth_Stopped = localOAuthErrCode;
    $VALUES = new OAuthErrCode[] { WechatAuth_Err_OK, WechatAuth_Err_NormalErr, WechatAuth_Err_NetworkErr, WechatAuth_Err_JsonDecodeErr, WechatAuth_Err_Cancel, WechatAuth_Err_Timeout, localOAuthErrCode };
  }
  
  private OAuthErrCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OAuthErrCode:");
    localStringBuilder.append(this.code);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.OAuthErrCode
 * JD-Core Version:    0.7.0.1
 */