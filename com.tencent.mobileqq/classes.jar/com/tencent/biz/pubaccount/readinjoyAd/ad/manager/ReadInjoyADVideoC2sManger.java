package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashSet;

public class ReadInjoyADVideoC2sManger
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, IVideoPlayManager paramIVideoPlayManager)
  {
    if (paramIVideoPlayManager == null) {
      return;
    }
    VideoPlayParam localVideoPlayParam = paramIVideoPlayManager.a();
    paramIVideoPlayManager = paramIVideoPlayManager.a();
    if ((paramIVideoPlayManager != null) && (localVideoPlayParam != null) && ((localVideoPlayParam.a instanceof AdvertisementInfo)))
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localVideoPlayParam.a;
      if (paramInt >= localAdvertisementInfo.mC2SReportTriggerTime / 1000) {
        a(paramIVideoPlayManager, localAdvertisementInfo, localVideoPlayParam);
      }
    }
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramActivity != null))
    {
      if (paramAdvertisementInfo == null) {
        return false;
      }
      if (((paramVideoPlayParam.a instanceof AdvertisementInfo)) && (paramVideoPlayParam.b) && (!a.contains(paramAdvertisementInfo.mAdTraceId)) && (paramAdvertisementInfo.mC2SVideoPlayUrl != null) && (paramAdvertisementInfo.mC2SVideoPlayUrl.size() > 0))
      {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramActivity).a(27).b(3).a(paramAdvertisementInfo));
        a.add(paramAdvertisementInfo.mAdTraceId);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADVideoC2sManger
 * JD-Core Version:    0.7.0.1
 */