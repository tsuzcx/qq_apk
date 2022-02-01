package com.tencent.mobileqq.activity.shortvideo;

public abstract interface EncodeVideoTask$ResultListener
{
  public abstract void onEncodeSuccess(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public abstract void onError(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener
 * JD-Core Version:    0.7.0.1
 */