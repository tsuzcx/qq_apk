package com.heytap.msp.push.callback;

public abstract interface ICallBackResultService
{
  public abstract void onGetNotificationStatus(int paramInt1, int paramInt2);
  
  public abstract void onGetPushStatus(int paramInt1, int paramInt2);
  
  public abstract void onRegister(int paramInt, String paramString);
  
  public abstract void onSetPushTime(int paramInt, String paramString);
  
  public abstract void onUnRegister(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.callback.ICallBackResultService
 * JD-Core Version:    0.7.0.1
 */