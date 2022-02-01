package com.tencent.falco.base.libapi.downloader;

public abstract interface IDownLoaderListener
{
  public abstract void onDownloadStateChanged(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void onFail(int paramInt, String paramString1, String paramString2);
  
  public abstract void onProgress(String paramString, long paramLong, int paramInt1, int paramInt2);
  
  public abstract void onSuccess(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.downloader.IDownLoaderListener
 * JD-Core Version:    0.7.0.1
 */