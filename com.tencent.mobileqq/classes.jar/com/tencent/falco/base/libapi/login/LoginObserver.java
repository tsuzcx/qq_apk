package com.tencent.falco.base.libapi.login;

public abstract interface LoginObserver
{
  public abstract void onLoginFail();
  
  public abstract void onLoginSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginObserver
 * JD-Core Version:    0.7.0.1
 */