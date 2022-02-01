package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.text.TextUtils;
import ardl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import pfh;
import pha;
import pjy;

public final class KBPDUtils$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null)
    {
      QLog.i("KBPreDownloadUtils", 1, "[run]  won't download since context is null");
      return;
    }
    try
    {
      if (ardl.a("com.tencent.reading", (Context)localObject))
      {
        QLog.i("KBPreDownloadUtils", 1, "won't download since app is already installed.");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("KBPreDownloadUtils", 1, "[run] ", localException);
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      AppNetConnInfo.registerConnectionChangeReceiver((Context)localObject, pfh.a());
      QLog.i("KBPreDownloadUtils", 1, "won't download since wifi not connected. register NetInfoHandler");
      return;
    }
    if (!pfh.a(pha.a(), "sp_key_enable_pre_download"))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since predownload is disabled");
      return;
    }
    String str = pfh.a(pha.a(), "sp_key_kb_download_url");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("KBPreDownloadUtils", 1, "won't download since url is null");
      return;
    }
    if (pfh.a((Context)localObject))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since current apk is up to date");
      return;
    }
    pfh.b();
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = "101480433";
    ((DownloadInfo)localObject).g = 2;
    ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString = str;
    ((DownloadInfo)localObject).e = "com.tencent.reading";
    ((DownloadInfo)localObject).h = "ANDROIDQQ.QNREADING";
    ((DownloadInfo)localObject).a = false;
    ((DownloadInfo)localObject).i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    ((DownloadInfo)localObject).jdField_d_of_type_Boolean = false;
    ((DownloadInfo)localObject).m = "biz_src_feeds_kandian";
    pfh.a(System.currentTimeMillis());
    pjy.a().a(pfh.a());
    pjy.a().a((DownloadInfo)localObject);
    QLog.d("KBPreDownloadUtils", 2, "[maybePDKB] startDownload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.1
 * JD-Core Version:    0.7.0.1
 */