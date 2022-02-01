package com.tencent.component.network.downloader.impl.ipc;

import android.content.Context;
import com.tencent.component.network.downloader.Downloader;

public class DownloaderProxyManager
{
  private static Downloader sCommonDownloader;
  private static Downloader sImageDownloader;
  
  public static Downloader getCommonDownloader(Context paramContext)
  {
    Downloader localDownloader = sCommonDownloader;
    if (localDownloader != null) {
      return localDownloader;
    }
    try
    {
      if (sCommonDownloader != null)
      {
        paramContext = sCommonDownloader;
        return paramContext;
      }
      sCommonDownloader = new DownloaderProxy(paramContext, "common_proxy", 2);
      paramContext = sCommonDownloader;
      return paramContext;
    }
    finally {}
  }
  
  public static Downloader getImageDownloader(Context paramContext)
  {
    Downloader localDownloader = sImageDownloader;
    if (localDownloader != null) {
      return localDownloader;
    }
    try
    {
      if (sImageDownloader != null)
      {
        paramContext = sImageDownloader;
        return paramContext;
      }
      sImageDownloader = new DownloaderProxy(paramContext, "image_proxy", 1);
      paramContext = sImageDownloader;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxyManager
 * JD-Core Version:    0.7.0.1
 */