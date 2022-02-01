package com.tencent.falco.base.libapi.wxsdk;

public abstract interface WxLoginCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed(WxLoginInfo paramWxLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.wxsdk.WxLoginCallback
 * JD-Core Version:    0.7.0.1
 */