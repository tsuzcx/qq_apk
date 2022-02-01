package com.tencent.component.media;

import com.tencent.component.media.image.ImageDownloadInfo;

public abstract interface ImageManagerEnv$ImageDownloaderListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString, ImageDownloadInfo paramImageDownloadInfo);
  
  public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString1, String paramString2, boolean paramBoolean, ImageDownloadInfo paramImageDownloadInfo);
  
  public abstract void onStreamProgress(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
 * JD-Core Version:    0.7.0.1
 */