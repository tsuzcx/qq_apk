package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GdtDownloadListenerAdapter
  implements AdCanvasDownloadListenerAdapter
{
  private List<IAdDownloader.Callback> a = new CopyOnWriteArrayList();
  
  public IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)((Iterator)localObject).next();
        if (((localCallback instanceof GdtDownloadListener)) && (((GdtDownloadListener)localCallback).a() == paramAdAppDownloadManager)) {
          return localCallback;
        }
      }
    }
    return null;
  }
  
  public void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (paramAdAppDownloadManager == null) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)((Iterator)localObject).next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */