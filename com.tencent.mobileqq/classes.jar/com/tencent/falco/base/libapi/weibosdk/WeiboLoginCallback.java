package com.tencent.falco.base.libapi.weibosdk;

public abstract interface WeiboLoginCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed(WeiboLoginInfo paramWeiboLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.weibosdk.WeiboLoginCallback
 * JD-Core Version:    0.7.0.1
 */