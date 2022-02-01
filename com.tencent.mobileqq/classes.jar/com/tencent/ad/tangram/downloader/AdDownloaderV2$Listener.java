package com.tencent.ad.tangram.downloader;

import android.support.annotation.Keep;

@Keep
public abstract interface AdDownloaderV2$Listener
{
  public abstract void onStatusChanged(String paramString, int paramInt);
  
  public abstract void onStatusChanged(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.downloader.AdDownloaderV2.Listener
 * JD-Core Version:    0.7.0.1
 */