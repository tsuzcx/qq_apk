package com.tencent.falco.base.libapi.hostproxy;

public abstract interface HostLoginInterface
{
  public abstract void onGetLoginRequestInfo(LoginRequestCallback paramLoginRequestCallback);
  
  public abstract void onLoginInvalid();
  
  public abstract void onQQConnectLogin(LoginResultCallback paramLoginResultCallback);
  
  public abstract void onReLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.HostLoginInterface
 * JD-Core Version:    0.7.0.1
 */