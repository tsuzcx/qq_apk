package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class ASPluginDownloadManager$1
  implements Downloader.DownloadListener
{
  ASPluginDownloadManager$1(ASPluginDownloadManager paramASPluginDownloadManager, ASPluginDownloadManager.DownloadEnty paramDownloadEnty) {}
  
  public void onDownloadCanceled(String paramString)
  {
    ASPluginDownloadManager.a(this.b, false);
    if (ASPluginDownloadManager.a(this.b).size() > 0)
    {
      ASPluginDownloadManager.DownloadEnty localDownloadEnty = (ASPluginDownloadManager.DownloadEnty)ASPluginDownloadManager.a(this.b).get(0);
      ASPluginDownloadManager.a(this.b).remove(0);
      ASPluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    ASPluginDownloadManager.a(this.b, false);
    if (ASPluginDownloadManager.a(this.b).size() > 0)
    {
      ASPluginDownloadManager.DownloadEnty localDownloadEnty = (ASPluginDownloadManager.DownloadEnty)ASPluginDownloadManager.a(this.b).get(0);
      ASPluginDownloadManager.a(this.b).remove(0);
      ASPluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.a.e != null) {
      this.a.e.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    ASPluginDownloadManager.a(this.b, false);
    if (ASPluginDownloadManager.a(this.b).size() > 0)
    {
      ASPluginDownloadManager.DownloadEnty localDownloadEnty = (ASPluginDownloadManager.DownloadEnty)ASPluginDownloadManager.a(this.b).get(0);
      ASPluginDownloadManager.a(this.b).remove(0);
      ASPluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASPluginDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */