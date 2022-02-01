package com.tencent.gdtad.adapter;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.Iterator;
import java.util.List;

class GdtDownloaderAdapterV2$3
  implements DownloadListener
{
  GdtDownloaderAdapterV2$3(GdtDownloaderAdapterV2 paramGdtDownloaderAdapterV2) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    GdtLog.b("GdtDownloaderAdapterV2", String.format("installSucceed packageName:%s", new Object[] { paramString2 }));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadCancel\n%s", new Object[] { paramDownloadInfo }));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadError errorCode:%d errorMsg:%s state:%d\n%s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramDownloadInfo }));
    GdtDownloaderAdapterV2.a(this.a, paramDownloadInfo.d, 7);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadFinish\n%s", new Object[] { paramDownloadInfo }));
    GdtDownloaderAdapterV2.a(this.a, paramDownloadInfo.d, 8, 100);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadPause\n%s", new Object[] { paramDownloadInfo }));
    GdtDownloaderAdapterV2.a(this.a, paramDownloadInfo.d, 7);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (localDownloadInfo != null)
      {
        GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadUpdate\n%s", new Object[] { localDownloadInfo }));
        GdtDownloaderAdapterV2.a(this.a, localDownloadInfo.d, 6, localDownloadInfo.t);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    GdtLog.b("GdtDownloaderAdapterV2", String.format("onDownloadWait\n%s", new Object[] { paramDownloadInfo }));
    GdtDownloaderAdapterV2.a(this.a, paramDownloadInfo.d, 5);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    GdtLog.b("GdtDownloaderAdapterV2", String.format("packageReplaced packageName:%s", new Object[] { paramString2 }));
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    GdtLog.b("GdtDownloaderAdapterV2", String.format("uninstallSucceed packageName:%s", new Object[] { paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloaderAdapterV2.3
 * JD-Core Version:    0.7.0.1
 */