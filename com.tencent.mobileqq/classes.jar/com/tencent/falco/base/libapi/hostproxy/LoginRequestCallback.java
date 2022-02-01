package com.tencent.falco.base.libapi.hostproxy;

import com.tencent.falco.base.libapi.login.LoginRequest;

public abstract interface LoginRequestCallback
{
  public abstract void onGetFail();
  
  public abstract void onGetSuccess(LoginRequest paramLoginRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.LoginRequestCallback
 * JD-Core Version:    0.7.0.1
 */