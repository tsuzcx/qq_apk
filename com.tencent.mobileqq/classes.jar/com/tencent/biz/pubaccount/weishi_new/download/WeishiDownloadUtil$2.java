package com.tencent.biz.pubaccount.weishi_new.download;

import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class WeishiDownloadUtil$2
  extends WSDownloadListenerWrapper
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!WeishiDownloadUtil.b()) {
      return;
    }
    WeishiDownloadUtil.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    WSLog.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      int i = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), i, 3, 2, 0, WeishiDownloadUtil.c());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    WSLog.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      paramInt2 = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), paramInt2, 3, 2, 0, WeishiDownloadUtil.c());
      WSLog.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      WeishiDownloadUtil.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    WeishiDownloadUtil.a();
    WSLog.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = WeishiDownloadUtil.a();
    int j = WeishiDownloadUtil.b();
    if (j != 3)
    {
      WSLog.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!WeishiDownloadUtil.b())
    {
      WSLog.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    WeishiDownloadUtil.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo)) {
      WeishiDownloadUtil.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!WeishiDownloadUtil.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    WSLog.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */