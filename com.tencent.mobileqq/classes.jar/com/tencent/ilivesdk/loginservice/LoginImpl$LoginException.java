package com.tencent.ilivesdk.loginservice;

class LoginImpl$LoginException
  extends Exception
{
  final int errorCode;
  final String errorMessage;
  
  LoginImpl$LoginException(LoginImpl paramLoginImpl, int paramInt, String paramString)
  {
    super(paramLoginImpl.toString());
    this.errorCode = paramInt;
    this.errorMessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl.LoginException
 * JD-Core Version:    0.7.0.1
 */