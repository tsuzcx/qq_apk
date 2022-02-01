package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GdtDownloadListenerAdapter
  implements AdCanvasDownloadListenerAdapter
{
  private List<IAdDownloader.Callback> a = new CopyOnWriteArrayList();
  
  public IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if (((localCallback instanceof GdtDownloadListener)) && (((GdtDownloadListener)localCallback).a() == paramAdAppDownloadManager)) {
          return localCallback;
        }
      }
    }
    return null;
  }
  
  public void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a == null) || (paramAdAppDownloadManager == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if ((localCallback instanceof GdtDownloadListener))
        {
          AdAppDownloadManager localAdAppDownloadManager = ((GdtDownloadListener)localCallback).a();
          if ((localAdAppDownloadManager != null) && (localAdAppDownloadManager == paramAdAppDownloadManager)) {
            this.a.remove(localCallback);
          }
        }
      }
    }
  }
  
  public void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a != null) && (paramAdAppDownloadManager != null))
    {
      GdtDownloadListener localGdtDownloadListener = new GdtDownloadListener();
      localGdtDownloadListener.a(paramAdAppDownloadManager);
      this.a.add(localGdtDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */