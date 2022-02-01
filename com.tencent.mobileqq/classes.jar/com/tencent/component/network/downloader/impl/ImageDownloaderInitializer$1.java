package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.Config;
import okhttp3.Request.Builder;
import org.apache.http.HttpRequest;

final class ImageDownloaderInitializer$1
  implements DownloadPreprocessStrategy
{
  ImageDownloaderInitializer$1(Downloader paramDownloader) {}
  
  public DownloadPreprocessStrategy.DownloadPool downloadPool(String paramString1, String paramString2)
  {
    if (Config.shouldUseHttp2(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.HTTP2;
    }
    if (ImageDownloaderInitializer.access$000(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC1;
    }
    paramString1 = this.val$downloader.getKeepAliveStrategy();
    if ((paramString1 != null) && (paramString1.supportKeepAlive(paramString2))) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC;
    }
    return DownloadPreprocessStrategy.DownloadPool.COMMON;
  }
  
  public void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt)
  {
    if ((paramHttpRequest != null) && (paramString2 != null) && (ImageDownloaderInitializer.access$100(paramString2)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("uin=o");
      paramString1.append(Config.getCurrentUin());
      paramString1.append(";");
      paramHttpRequest.addHeader("Cookie", paramString1.toString());
    }
  }
  
  public String prepareUrl(String paramString)
  {
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ImageDownloaderInitializer.1
 * JD-Core Version:    0.7.0.1
 */