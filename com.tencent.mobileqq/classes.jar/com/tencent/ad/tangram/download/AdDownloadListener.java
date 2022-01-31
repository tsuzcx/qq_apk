package com.tencent.ad.tangram.download;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdDownloadListener
{
  INSTANCE;
  
  private WeakReference<AdDownloadListenerAdapter> adapter;
  
  private AdDownloadListener() {}
  
  private static AdDownloadListenerAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdDownloadListenerAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static Object getDownloadListener()
  {
    AdDownloadListenerAdapter localAdDownloadListenerAdapter = getAdapter();
    if (localAdDownloadListenerAdapter != null) {
      return localAdDownloadListenerAdapter;
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdDownloadListenerAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.download.AdDownloadListener
 * JD-Core Version:    0.7.0.1
 */