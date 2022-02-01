package com.tencent.intervideo.nowproxy.common.login;

public abstract class LoginObserver
{
  public static final int SOURCE_LOGIN = 1;
  public static final int SOURCE_UPDATE = 2;
  
  public void doLogin() {}
  
  public void onGetNowTicket(int paramInt1, int paramInt2, NowLoginInfo paramNowLoginInfo) {}
  
  public void onLoginDataInvalid(int paramInt) {}
  
  public void onNoLogin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.login.LoginObserver
 * JD-Core Version:    0.7.0.1
 */