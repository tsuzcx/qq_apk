package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import java.util.ArrayList;
import java.util.HashSet;

public class ReadInjoyADVideoC2sManger
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager == null) {}
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localVideoPlayParam = paramVideoPlayManager.a();
        paramVideoPlayManager = paramVideoPlayManager.a();
      } while ((paramVideoPlayManager == null) || (localVideoPlayParam == null) || (!(localVideoPlayParam.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localVideoPlayParam.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramVideoPlayManager, localAdvertisementInfo, localVideoPlayParam);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramVideoPlayParam.a instanceof AdvertisementInfo)) || (!paramVideoPlayParam.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    NativeAdUtils.a(new AdReportData().a(paramActivity).a(27).b(3).a(paramAdvertisementInfo));
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADVideoC2sManger
 * JD-Core Version:    0.7.0.1
 */