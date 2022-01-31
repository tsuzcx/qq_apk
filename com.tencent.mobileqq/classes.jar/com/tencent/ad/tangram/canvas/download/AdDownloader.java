package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import android.util.Pair;
import java.lang.ref.WeakReference;

@Keep
public enum AdDownloader
{
  INSTANCE;
  
  private WeakReference<AdDownloaderAdapter> adapter;
  
  private AdDownloader() {}
  
  private static AdDownloaderAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdDownloaderAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static IAdDownloader getDownloader()
  {
    AdDownloaderAdapter localAdDownloaderAdapter = getAdapter();
    if (localAdDownloaderAdapter != null) {
      return localAdDownloaderAdapter.getDownloader();
    }
    return null;
  }
  
  public static int getProgress(Object paramObject)
  {
    AdDownloaderAdapter localAdDownloaderAdapter = getAdapter();
    if (localAdDownloaderAdapter != null) {
      return localAdDownloaderAdapter.getProgress(paramObject);
    }
    return 0;
  }
  
  public static boolean isCurrentPkgTask(Pair<String, String> paramPair, Object paramObject)
  {
    AdDownloaderAdapter localAdDownloaderAdapter = getAdapter();
    if (localAdDownloaderAdapter != null) {
      return localAdDownloaderAdapter.isCurrentPkgTask(paramPair, paramObject);
    }
    return false;
  }
  
  public static void setAdapter(WeakReference<AdDownloaderAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdDownloader
 * JD-Core Version:    0.7.0.1
 */