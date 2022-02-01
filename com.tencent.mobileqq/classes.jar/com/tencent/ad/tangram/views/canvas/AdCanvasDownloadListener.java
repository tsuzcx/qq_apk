package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdCanvasDownloadListener
{
  INSTANCE;
  
  private WeakReference<AdCanvasDownloadListenerAdapter> adapter;
  
  private AdCanvasDownloadListener() {}
  
  private static AdCanvasDownloadListenerAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (AdCanvasDownloadListenerAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager != null) {}
    try
    {
      AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter = getAdapter();
      if (localAdCanvasDownloadListenerAdapter != null)
      {
        paramAdAppDownloadManager = localAdCanvasDownloadListenerAdapter.getDownloadListener(paramAdAppDownloadManager);
        return paramAdAppDownloadManager;
      }
      return null;
    }
    finally {}
  }
  
  public static void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager == null) {
      return;
    }
    AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter = getAdapter();
    if (localAdCanvasDownloadListenerAdapter != null) {
      localAdCanvasDownloadListenerAdapter.removeDownloadListener(paramAdAppDownloadManager);
    }
  }
  
  public static void setAdapter(AdCanvasDownloadListenerAdapter paramAdCanvasDownloadListenerAdapter)
  {
    INSTANCE.adapter = new WeakReference(paramAdCanvasDownloadListenerAdapter);
  }
  
  public static void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager == null) {
      return;
    }
    AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter = getAdapter();
    if (localAdCanvasDownloadListenerAdapter != null) {
      localAdCanvasDownloadListenerAdapter.setDownloadListener(paramAdAppDownloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListener
 * JD-Core Version:    0.7.0.1
 */