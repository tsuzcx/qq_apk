package com.tencent.component.network.downloader.impl.ipc;

import android.content.Context;
import com.tencent.component.network.downloader.Downloader;

public class DownloaderProxyManager
{
  private static Downloader sCommonDownloader;
  private static Downloader sImageDownloader;
  
  public static Downloader getCommonDownloader(Context paramContext)
  {
    if (sCommonDownloader != null) {
      return sCommonDownloader;
    }
    try
    {
      if (sCommonDownloader != null)
      {
        paramContext = sCommonDownloader;
        return paramContext;
      }
    }
    finally {}
    sCommonDownloader = new DownloaderProxy(paramContext, "common_proxy", 2);
    paramContext = sCommonDownloader;
    return paramContext;
  }
  
  public static Downloader getImageDownloader(Context paramContext)
  {
    if (sImageDownloader != null) {
      return sImageDownloader;
    }
    try
    {
      if (sImageDownloader != null)
      {
        paramContext = sImageDownloader;
        return paramContext;
      }
    }
    finally {}
    sImageDownloader = new DownloaderProxy(paramContext, "image_proxy", 1);
    paramContext = sImageDownloader;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxyManager
 * JD-Core Version:    0.7.0.1
 */