package com.tencent.ad.tangram.downloader;

import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdDownloaderAdapterV2
{
  public abstract int getProgressOnFileThread(String paramString);
  
  public abstract void init();
  
  public abstract void installDownload(String paramString);
  
  public abstract boolean isDownloadedOnFileThread(String paramString);
  
  public abstract void pauseDownload(String paramString);
  
  public abstract void registerListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference);
  
  public abstract void startDownload(String paramString, Ad paramAd, Bundle paramBundle);
  
  public abstract void unregisterListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
 * JD-Core Version:    0.7.0.1
 */