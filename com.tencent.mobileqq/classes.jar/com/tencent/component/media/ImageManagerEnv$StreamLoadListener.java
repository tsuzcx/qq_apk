package com.tencent.component.media;

public abstract interface ImageManagerEnv$StreamLoadListener
{
  public abstract void onDownloadCanceled(String paramString1, String paramString2);
  
  public abstract void onDownloadFailed(String paramString1, String paramString2);
  
  public abstract void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onDownloadSucceed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.ImageManagerEnv.StreamLoadListener
 * JD-Core Version:    0.7.0.1
 */