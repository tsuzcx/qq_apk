package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.login.LoginInfo;

public abstract interface SdkLoginCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed(LoginInfo paramLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.SdkLoginCallback
 * JD-Core Version:    0.7.0.1
 */