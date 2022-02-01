package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;

class KBPDUtils$NetInfoHandler
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetMobile2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(KBPDUtils.a());
    KBPDUtils.a();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onNetNone2Wifi] ");
    AppNetConnInfo.unregisterNetInfoHandler(KBPDUtils.a());
    KBPDUtils.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2Mobile] pause download");
    DownloadManager.a().a("101480433");
  }
  
  public void onNetWifi2None()
  {
    QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2None] pause download");
    DownloadManager.a().a("101480433");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */