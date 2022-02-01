package com.tencent.hippy.qq.api;

public abstract interface IUpdateListener
{
  public abstract void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract void onUpdateSuccess(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IUpdateListener
 * JD-Core Version:    0.7.0.1
 */