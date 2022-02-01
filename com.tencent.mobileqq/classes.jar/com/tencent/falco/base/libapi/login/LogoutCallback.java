package com.tencent.falco.base.libapi.login;

public abstract interface LogoutCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSucceed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LogoutCallback
 * JD-Core Version:    0.7.0.1
 */