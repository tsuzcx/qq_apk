package com.tencent.falco.base.libapi.qqsdk;

public abstract interface QQLoginCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed(QQLoginInfo paramQQLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQLoginCallback
 * JD-Core Version:    0.7.0.1
 */