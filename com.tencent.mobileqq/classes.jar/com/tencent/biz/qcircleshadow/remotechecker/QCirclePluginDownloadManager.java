package com.tencent.biz.qcircleshadow.remotechecker;

import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;
import mqq.app.MobileQQ;

public class QCirclePluginDownloadManager
{
  private static volatile QCirclePluginDownloadManager a;
  private Downloader b = null;
  private Context c = MobileQQ.sMobileQQ;
  private Vector<QCirclePluginDownloadManager.DownloadEnty> d = new Vector();
  private QCirclePluginDownloadManager.DownloadEnty e;
  private boolean f;
  
  public static QCirclePluginDownloadManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCirclePluginDownloadManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean a(QCirclePluginDownloadManager.DownloadEnty paramDownloadEnty)
  {
    try
    {
      if (this.f)
      {
        if (paramDownloadEnty.a) {
          this.d.add(0, paramDownloadEnty);
        } else {
          this.d.add(paramDownloadEnty);
        }
        return true;
      }
      if (paramDownloadEnty.g != null)
      {
        if (b().download(paramDownloadEnty.g, paramDownloadEnty.d))
        {
          this.e = paramDownloadEnty;
          this.f = true;
          return true;
        }
        return false;
      }
      if (b().download(paramDownloadEnty.c, paramDownloadEnty.b, paramDownloadEnty.d, paramDownloadEnty.f))
      {
        this.e = paramDownloadEnty;
        this.f = true;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private Downloader b()
  {
    try
    {
      if (this.b != null)
      {
        localObject1 = this.b;
        return localObject1;
      }
      Object localObject1 = null;
      try
      {
        Downloader localDownloader = DownloaderFactory.getInstance(this.c).getCommonDownloader();
        localObject1 = localDownloader;
        localDownloader.enableResumeTransfer();
        localObject1 = localDownloader;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.b = ((Downloader)localObject1);
      if (this.b != null)
      {
        localObject1 = this.b;
        return localObject1;
      }
      throw new RuntimeException("no downloader available");
    }
    finally {}
  }
  
  public final boolean a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = new QCirclePluginDownloadManager.DownloadEnty(this);
    localDownloadEnty.b = paramString2;
    localDownloadEnty.c = paramString1;
    localDownloadEnty.d = paramBoolean1;
    localDownloadEnty.a = paramBoolean2;
    localDownloadEnty.e = paramDownloadListener;
    localDownloadEnty.f = new QCirclePluginDownloadManager.1(this, localDownloadEnty);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(localDownloadEnty.f);
      localDownloadEnty.g = paramDownloadRequest;
    }
    return a(localDownloadEnty);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */