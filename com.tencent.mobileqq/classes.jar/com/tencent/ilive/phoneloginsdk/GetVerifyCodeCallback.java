package com.tencent.ilive.phoneloginsdk;

public abstract interface GetVerifyCodeCallback
{
  public static final int ILLEGAL_PHONE_NUMBER = -3;
  public static final int INFO_LOSS = -2;
  public static final int PHONE_NOT_BIND = -1;
  
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.phoneloginsdk.GetVerifyCodeCallback
 * JD-Core Version:    0.7.0.1
 */