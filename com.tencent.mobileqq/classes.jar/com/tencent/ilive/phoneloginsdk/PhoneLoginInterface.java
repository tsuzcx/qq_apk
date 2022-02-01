package com.tencent.ilive.phoneloginsdk;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface PhoneLoginInterface
  extends ServiceBaseInterface
{
  public abstract void getLoginResult(String paramString1, String paramString2, PhoneLoginCallback paramPhoneLoginCallback);
  
  public abstract void getVerifyCode(String paramString, GetVerifyCodeCallback paramGetVerifyCodeCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.phoneloginsdk.PhoneLoginInterface
 * JD-Core Version:    0.7.0.1
 */