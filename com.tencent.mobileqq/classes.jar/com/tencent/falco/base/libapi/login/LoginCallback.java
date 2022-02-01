package com.tencent.falco.base.libapi.login;

public abstract interface LoginCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed(LoginInfo paramLoginInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginCallback
 * JD-Core Version:    0.7.0.1
 */