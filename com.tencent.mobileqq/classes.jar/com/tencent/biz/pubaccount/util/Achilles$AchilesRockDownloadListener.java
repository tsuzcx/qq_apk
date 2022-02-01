package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

class Achilles$AchilesRockDownloadListener
  extends RockDownloadListener
{
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download cancel: " + paramRockDownloadInfo);
    if (paramRockDownloadInfo != null) {
      Achilles.a(false, paramRockDownloadInfo.getPackageName(), -1, "");
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    QLog.d("Achilles", 1, "download fail: " + paramString + " " + paramInt + " " + paramRockDownloadInfo);
    if (paramRockDownloadInfo != null)
    {
      if (paramInt == 10010) {
        ThreadManager.getFileThreadHandler().postDelayed(Achilles.a(), 10000L);
      }
    }
    else {
      return;
    }
    Achilles.a(false, paramRockDownloadInfo.getPackageName(), paramInt, paramString);
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "downloadInfo: " + paramRockDownloadInfo);
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    QLog.d("Achilles", 2, "download process: " + paramRockDownloadInfo + " process: " + paramInt);
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download start: " + paramRockDownloadInfo);
    Achilles.a().put(paramRockDownloadInfo.getPackageName(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download success: " + paramRockDownloadInfo);
    if (paramRockDownloadInfo != null) {
      Achilles.a(true, paramRockDownloadInfo.getPackageName(), 0, "");
    }
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download wait: " + paramRockDownloadInfo);
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download permission denied: " + paramRockDownloadInfo);
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    QLog.d("Achilles", 1, "download permission permitted: " + paramRockDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Achilles.AchilesRockDownloadListener
 * JD-Core Version:    0.7.0.1
 */