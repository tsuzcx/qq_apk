package com.tencent.component.network.downloader;

public abstract interface Downloader$DownloadListener
{
  public abstract void onDownloadCanceled(String paramString);
  
  public abstract void onDownloadFailed(String paramString, DownloadResult paramDownloadResult);
  
  public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  
  public abstract void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.Downloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */