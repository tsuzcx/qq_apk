package com.tencent.livesdk.accountengine;

public abstract interface UserInitStateCallback
{
  public abstract void onAvInitFail();
  
  public abstract void onAvInitSucceed();
  
  public abstract void onLoginFail(int paramInt);
  
  public abstract void onLoginSucceed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserInitStateCallback
 * JD-Core Version:    0.7.0.1
 */