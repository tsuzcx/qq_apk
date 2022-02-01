package com.tencent.imsdk.common;

import java.util.Map;

public abstract interface HttpClient$HttpRequestListener
{
  public abstract void onCompleted(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte);
  
  public abstract void onProgress(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.HttpClient.HttpRequestListener
 * JD-Core Version:    0.7.0.1
 */