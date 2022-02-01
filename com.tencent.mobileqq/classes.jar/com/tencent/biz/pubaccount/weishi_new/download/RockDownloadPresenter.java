package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import android.text.TextUtils;
import aqgj;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import mqq.util.WeakReference;
import vau;
import vbj;
import vbq;
import vkf;
import vmp;
import vnd;

public class RockDownloadPresenter
{
  private WSDownloadParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams;
  private RockDownloadListener jdField_a_of_type_ComTencentMobileqqBigbrotherRockDownloaderRockDownloadListener;
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene;
    }
    return 1;
  }
  
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
    int i = vau.a().c();
    String str2 = vau.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a();
    }
    return new RockDownloadInfo("biz_src_jc_gzh_weishi", "weishi_gzh", "com.tencent.weishi", str1, i);
  }
  
  public void a(Activity paramActivity, RockDownloadInfo paramRockDownloadInfo, int paramInt, WSDownloadParams paramWSDownloadParams, RockDownloadListenerWrapper paramRockDownloadListenerWrapper)
  {
    if ((paramActivity != null) && (paramInt == 3)) {
      vbj.a(paramActivity);
    }
    if (vbq.c())
    {
      vmp.d("RockDownloader", "已有正在下载的任务，不响应");
      return;
    }
    WSDownloadParams localWSDownloadParams = paramWSDownloadParams;
    if (paramWSDownloadParams == null) {
      localWSDownloadParams = new WSDownloadParams();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams = localWSDownloadParams;
    vkf.a(localWSDownloadParams, 1);
    WSPublicAccReport.getInstance().reportDownload(localWSDownloadParams.mEventId, paramInt, 1, 1, 0, localWSDownloadParams.mScene);
    if (paramInt == 1)
    {
      aqgj.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
      vmp.d("RockDownloader", "执行预下载Rock下载 " + paramRockDownloadInfo.toString());
      return;
    }
    vnd.b(localWSDownloadParams.mScheme);
    aqgj.a(paramRockDownloadInfo, a(paramActivity, paramRockDownloadListenerWrapper));
    vmp.d("RockDownloader", "执行可call起安装Rock下载 " + paramRockDownloadInfo.toString());
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo)
  {
    boolean bool = aqgj.a(paramRockDownloadInfo);
    if (bool)
    {
      vmp.b("RockDownloader", "rockdownload deleteSuccess");
      return bool;
    }
    if (paramRockDownloadInfo.realVersionCode == 333)
    {
      vmp.b("RockDownloader", "rockdownload 模拟 deleteFail");
      return bool;
    }
    vmp.b("RockDownloader", "rockdownload deleteFail");
    return bool;
  }
  
  public boolean a(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    boolean bool = aqgj.b(paramRockDownloadInfo);
    int i = vbq.b();
    if (bool)
    {
      vmp.d("RockDownloader", "rockdownload installSuccess,eventType = " + i);
      vkf.a(paramInt, 1);
      WSPublicAccReport.getInstance().reportDownload(vbq.a(), i, 2, 1, 1, a());
      return bool;
    }
    vmp.d("RockDownloader", "rockdownload installFail,eventType = " + i);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter
 * JD-Core Version:    0.7.0.1
 */