package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.text.TextUtils;
import anet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import olj;
import onk;
import oqc;

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
      if (anet.a("com.tencent.reading", (Context)localObject))
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
      AppNetConnInfo.registerConnectionChangeReceiver((Context)localObject, olj.a());
      QLog.i("KBPreDownloadUtils", 1, "won't download since wifi not connected. register NetInfoHandler");
      return;
    }
    if (!olj.a(onk.a(), "sp_key_enable_pre_download"))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since predownload is disabled");
      return;
    }
    String str = olj.a(onk.a(), "sp_key_kb_download_url");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("KBPreDownloadUtils", 1, "won't download since url is null");
      return;
    }
    if (olj.a((Context)localObject))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since current apk is up to date");
      return;
    }
    olj.b();
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
    olj.a(System.currentTimeMillis());
    oqc.a().a(olj.a());
    oqc.a().a((DownloadInfo)localObject);
    QLog.d("KBPreDownloadUtils", 2, "[maybePDKB] startDownload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.1
 * JD-Core Version:    0.7.0.1
 */