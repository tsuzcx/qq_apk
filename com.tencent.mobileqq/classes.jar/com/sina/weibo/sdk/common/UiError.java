package com.sina.weibo.sdk.common;

public class UiError
{
  public int errorCode;
  public String errorDetail;
  public String errorMessage;
  
  public UiError(int paramInt, String paramString1, String paramString2)
  {
    this.errorCode = paramInt;
    this.errorMessage = paramString1;
    this.errorDetail = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.common.UiError
 * JD-Core Version:    0.7.0.1
 */