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
    if (!WeishiDownloadUtil.f()) {
      return;
    }
    WeishiDownloadUtil.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone onDownloadCancel info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.c("WeishiDownloadUtil", localStringBuilder.toString());
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.h();
      int i = WeishiDownloadUtil.e();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), i, 3, 2, 0, WeishiDownloadUtil.k());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone onDownloadError info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    if (WeishiDownloadUtil.a(paramDownloadInfo))
    {
      WeishiDownloadUtil.h();
      paramInt2 = WeishiDownloadUtil.e();
      WSPublicAccReport.getInstance().reportDownload(WeishiDownloadUtil.d(), paramInt2, 3, 2, 0, WeishiDownloadUtil.k());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone  errorCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(paramString);
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
      WeishiDownloadUtil.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    WeishiDownloadUtil.h();
    WSLog.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = WeishiDownloadUtil.d();
    int j = WeishiDownloadUtil.e();
    if (j != 3)
    {
      WSLog.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!WeishiDownloadUtil.f())
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("这是Qzone的监听器，不响应qq onDownloadFinish eventId:");
      paramDownloadInfo.append(i);
      paramDownloadInfo.append(",eventType:");
      paramDownloadInfo.append(j);
      WSLog.d("WeishiDownloadUtil", paramDownloadInfo.toString());
      return;
    }
    WeishiDownloadUtil.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone onDownloadPause info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    if (WeishiDownloadUtil.a(paramDownloadInfo)) {
      WeishiDownloadUtil.h();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!WeishiDownloadUtil.f()) {
      return;
    }
    if (paramList != null) {
      paramList.size();
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone onDownloadWait info = ");
    localStringBuilder.append(paramDownloadInfo);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone packageReplaced appid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", packageName = ");
    localStringBuilder.append(paramString2);
    WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */