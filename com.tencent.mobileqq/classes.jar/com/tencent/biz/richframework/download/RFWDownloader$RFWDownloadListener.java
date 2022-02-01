package com.tencent.biz.richframework.download;

public abstract interface RFWDownloader$RFWDownloadListener
{
  public abstract void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2);
  
  public abstract void onRspCallback(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
 * JD-Core Version:    0.7.0.1
 */