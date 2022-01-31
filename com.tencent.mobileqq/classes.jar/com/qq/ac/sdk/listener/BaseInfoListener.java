package com.qq.ac.sdk.listener;

import com.qq.ac.sdk.bean.BaseResponse;

public abstract interface BaseInfoListener
{
  public abstract void onFailure(int paramInt);
  
  public abstract void onResponse(String paramString);
  
  public abstract BaseResponse onSyncResponse(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.listener.BaseInfoListener
 * JD-Core Version:    0.7.0.1
 */