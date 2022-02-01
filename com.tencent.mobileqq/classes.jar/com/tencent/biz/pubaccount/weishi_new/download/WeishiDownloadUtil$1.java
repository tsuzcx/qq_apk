package com.tencent.biz.pubaccount.weishi_new.download;

import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class WeishiDownloadUtil$1
  extends WSDownloadListenerWrapper
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (WeishiDownloadUtil.b()) {
      return;
    }
    WeishiDownloadUtil.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    WSLog.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      int i = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), i, 3, 2, 0, WeishiDownloadUtil.c());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    WSLog.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      paramInt2 = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), paramInt2, 3, 2, 0, WeishiDownloadUtil.c());
      WSLog.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      WeishiDownloadUtil.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    WeishiDownloadUtil.a();
    int i = WeishiDownloadUtil.a();
    int j = WeishiDownloadUtil.b();
    if (WeishiDownloadUtil.b())
    {
      if (WeishiDownloadUtil.d()) {
        WSLog.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      WeishiDownloadUtil.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    WSLog.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (WeishiDownloadUtil.a(paramDownloadInfo)) {
      WeishiDownloadUtil.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        WSLog.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    WSLog.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */