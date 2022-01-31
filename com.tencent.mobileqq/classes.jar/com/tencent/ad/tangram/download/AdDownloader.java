package com.tencent.ad.tangram.download;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdDownloader
{
  INSTANCE;
  
  public static final int CONFIG_ONLY_SDK = 0;
  public static final String DOWNLOAD_SOURCE_AD = "biz_src_ads";
  private WeakReference<AdDownloaderAdapter> adapter;
  
  private AdDownloader() {}
  
  private static AdDownloaderAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdDownloaderAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static Object getDownloader()
  {
    AdDownloaderAdapter localAdDownloaderAdapter = getAdapter();
    if (localAdDownloaderAdapter != null) {
      return localAdDownloaderAdapter;
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdDownloaderAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.download.AdDownloader
 * JD-Core Version:    0.7.0.1
 */