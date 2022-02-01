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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq onDownloadCancel info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.c("WeishiDownloadUtil", localStringBuilder.toString());
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      int i = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), i, 3, 2, 0, WeishiDownloadUtil.c());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq onDownloadError info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.a();
      paramInt2 = WeishiDownloadUtil.b();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.a(), paramInt2, 3, 2, 0, WeishiDownloadUtil.c());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" errorCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(paramString);
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      WeishiDownloadUtil.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    WeishiDownloadUtil.a();
    int i = WeishiDownloadUtil.a();
    int j = WeishiDownloadUtil.b();
    if (WeishiDownloadUtil.b()) {
      if (WeishiDownloadUtil.d())
      {
        WSLog.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
      else
      {
        paramDownloadInfo = new StringBuilder();
        paramDownloadInfo.append("这是qq的监听器，不响应qzone. onDownloadFinish eventId:");
        paramDownloadInfo.append(i);
        paramDownloadInfo.append(",eventType:");
        paramDownloadInfo.append(j);
        WSLog.d("WeishiDownloadUtil", paramDownloadInfo.toString());
        return;
      }
    }
    WeishiDownloadUtil.a(paramDownloadInfo, i, j, "QQ");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq onDownloadPause info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq onDownloadUpdate progress = ");
        localStringBuilder.append(localDownloadInfo.f);
        localStringBuilder.append(", url = ");
        localStringBuilder.append(localDownloadInfo.d);
        WSLog.c("WeishiDownloadUtil", localStringBuilder.toString());
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq onDownloadWait info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq packageReplaced appid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", packageName = ");
    localStringBuilder.append(paramString2);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */