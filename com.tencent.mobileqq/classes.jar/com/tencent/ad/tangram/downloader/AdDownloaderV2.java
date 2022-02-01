package com.tencent.ad.tangram.downloader;

import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import java.lang.ref.WeakReference;

@Keep
public enum AdDownloaderV2
{
  INSTANCE;
  
  private WeakReference<AdDownloaderAdapterV2> adapter;
  
  private AdDownloaderV2() {}
  
  private AdDownloaderAdapterV2 getAdapter()
  {
    WeakReference localWeakReference = this.adapter;
    if (localWeakReference != null) {
      return (AdDownloaderAdapterV2)localWeakReference.get();
    }
    return null;
  }
  
  public int getProgressOnFileThread(String paramString)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      return localAdDownloaderAdapterV2.getProgressOnFileThread(paramString);
    }
    return -2147483648;
  }
  
  public void init()
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.init();
    }
  }
  
  public void installDownload(String paramString)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.installDownload(paramString);
    }
  }
  
  public boolean isDownloadedOnFileThread(String paramString)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      return localAdDownloaderAdapterV2.isDownloadedOnFileThread(paramString);
    }
    return false;
  }
  
  public void pauseDownload(String paramString)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.pauseDownload(paramString);
    }
  }
  
  public void registerListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.registerListener(paramWeakReference);
    }
  }
  
  public void setAdapter(WeakReference<AdDownloaderAdapterV2> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
  
  public void startDownload(String paramString, Ad paramAd, Bundle paramBundle)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.startDownload(paramString, paramAd, paramBundle);
    }
  }
  
  public void unregisterListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference)
  {
    AdDownloaderAdapterV2 localAdDownloaderAdapterV2 = getAdapter();
    if (localAdDownloaderAdapterV2 != null) {
      localAdDownloaderAdapterV2.unregisterListener(paramWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.downloader.AdDownloaderV2
 * JD-Core Version:    0.7.0.1
 */