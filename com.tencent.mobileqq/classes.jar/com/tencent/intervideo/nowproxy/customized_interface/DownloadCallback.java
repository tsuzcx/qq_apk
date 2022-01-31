package com.tencent.intervideo.nowproxy.customized_interface;

public abstract interface DownloadCallback
{
  public abstract void onDownloadCancel();
  
  public abstract void onDownloadError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onDownloadSuccess(String paramString);
  
  public abstract void onProgress(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
 * JD-Core Version:    0.7.0.1
 */