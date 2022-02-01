package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;

@Keep
public abstract interface AdCanvasDownloadListenerAdapter
{
  public abstract IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
  
  public abstract void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
  
  public abstract void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */