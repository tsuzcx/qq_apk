package com.tencent.component.media.image;

public abstract interface ImageLoader$ImageDownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString);
  
  public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.ImageDownloadListener
 * JD-Core Version:    0.7.0.1
 */