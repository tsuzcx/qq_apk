package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class AdDownloadStateQueryUtil
{
  private static ConcurrentHashMap<String, SoftReference<ADVideoAppDownloadData>> a = new ConcurrentHashMap();
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback)
  {
    if (paramAdvertisementInfo != null)
    {
      if (paramValueCallback == null) {
        return;
      }
      paramValueCallback = new AdDownloadStateQueryUtil.1(new SoftReference(paramValueCallback));
      ThreadManagerV2.getUIHandlerV2().postDelayed(new AdDownloadStateQueryUtil.2(paramAdvertisementInfo, paramValueCallback), 100L);
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (paramDownloadInfo.l != null)
    {
      File localFile = new File(paramDownloadInfo.l);
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramDownloadInfo.a(4);
        paramDownloadInfo.f = 100;
        return;
      }
    }
    if (paramDownloadInfo.a() == 4)
    {
      if (ADBaseAppDownloadManager.a(BaseApplicationImpl.getContext(), paramDownloadInfo.e))
      {
        paramDownloadInfo.a(4);
        paramDownloadInfo.f = 100;
        return;
      }
      paramDownloadInfo.a(1);
      paramDownloadInfo.f = 0;
      return;
    }
    if ((paramDownloadInfo.f == 0) && (paramDownloadInfo.a() != 1))
    {
      paramDownloadInfo.a(1);
      return;
    }
    if ((paramDownloadInfo.f == 100) && (paramDownloadInfo.a() != 4)) {
      paramDownloadInfo.a(4);
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback)
  {
    ThreadManagerV2.excute(new AdDownloadStateQueryUtil.3(paramAdvertisementInfo, paramValueCallback), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil
 * JD-Core Version:    0.7.0.1
 */