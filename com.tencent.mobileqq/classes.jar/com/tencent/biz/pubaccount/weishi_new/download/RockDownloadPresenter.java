package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import android.text.TextUtils;
import apdf;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import mqq.util.WeakReference;
import umu;
import unj;
import unq;
import uvr;
import uya;
import uyo;

public class RockDownloadPresenter
{
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private RockDownloadListener jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  
  private RockDownloadListener a(Activity paramActivity, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener = new RockDownloadPresenter.1(this, this, new WeakReference(paramRockDownloadListenerWrapper), paramActivity);
    }
    return this.jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  }
  
  public static String a()
  {
    return "https://weseeugg.qq.com/download?channelid=204002177";
  }
  
  public RockDownloadInfo a()
  {
    int i = umu.a().c();
    String str2 = umu.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a();
    }
    return new RockDownloadInfo("biz_src_jc_gzh_weishi", "weishi_gzh", "com.tencent.weishi", str1, i);
  }
  
  public void a(Activity paramActivity, RockDownloadInfo paramRockDownloadInfo, int paramInt, WSDownloadParams paramWSDownloadParams, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if ((paramActivity != null) && (paramInt == 3)) {
      unj.a(paramActivity);
    }
    if (unq.c())
    {
      uya.d("RockDownloader", "已有正在下载的任务，不响应");
      return;
    }
    WSDownloadParams localWSDownloadParams = paramWSDownloadParams;
    if (paramWSDownloadParams == null) {
      localWSDownloadParams = new WSDownloadParams();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = localWSDownloadParams;
    uvr.a(localWSDownloadParams, 1);
    WSPublicAccReport.getInstance().reportDownload(localWSDownloadParams.mEventId, paramInt, 1, 1, 0);
    if (paramInt == 1)
    {
      apdf.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
      uya.d("RockDownloader", "执行预下载Rock下载 " + paramRockDownloadInfo.toString());
      return;
    }
    uyo.b(localWSDownloadParams.mScheme);
    apdf.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
    uya.d("RockDownloader", "执行可call起安装Rock下载 " + paramRockDownloadInfo.toString());
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo)
  {
    boolean bool = apdf.a(paramRockDownloadInfo);
    if (bool)
    {
      uya.b("RockDownloader", "rockdownload deleteSuccess");
      return bool;
    }
    if (paramRockDownloadInfo.realVersionCode == 333)
    {
      uya.b("RockDownloader", "rockdownload 模拟 deleteFail");
      return bool;
    }
    uya.b("RockDownloader", "rockdownload deleteFail");
    return bool;
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    boolean bool = apdf.b(paramRockDownloadInfo);
    int i = unq.b();
    if (bool)
    {
      uya.d("RockDownloader", "rockdownload installSuccess,eventType = " + i);
      uvr.a(paramInt, 1);
      WSPublicAccReport.getInstance().reportDownload(unq.a(), i, 2, 1, 1);
      return bool;
    }
    uya.d("RockDownloader", "rockdownload installFail,eventType = " + i);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter
 * JD-Core Version:    0.7.0.1
 */