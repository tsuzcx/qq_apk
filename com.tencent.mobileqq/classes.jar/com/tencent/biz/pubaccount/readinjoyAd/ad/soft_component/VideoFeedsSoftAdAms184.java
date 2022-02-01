package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;

public class VideoFeedsSoftAdAms184
{
  private static int a(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    if (paramAdvertisementSoftInfo == null) {
      return 0;
    }
    if ((!TextUtils.isEmpty(paramAdvertisementSoftInfo.K)) && (paramAdvertisementSoftInfo.K.equals("material_left_right"))) {
      return 1;
    }
    return 0;
  }
  
  public static int a(VideoInfo paramVideoInfo, Activity paramActivity)
  {
    if (paramVideoInfo == null) {
      return 0;
    }
    paramVideoInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.mAdvertisementSoftInfo == null) {
        return 0;
      }
      if (a(paramVideoInfo.mAdvertisementSoftInfo) == 1) {
        return AIOUtils.b(255.0F, paramActivity.getResources());
      }
      return AIOUtils.b(215.0F, paramActivity.getResources());
    }
    return 0;
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool2 = false;
    if (paramVideoInfo == null) {
      return false;
    }
    paramVideoInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    boolean bool1 = bool2;
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.mAdvertisementSoftInfo == null) {
        return false;
      }
      if ((paramVideoInfo.mAdvertisementSoftInfo.c == 0) && (paramVideoInfo.mAdMaterialId == 184)) {
        return true;
      }
      bool1 = bool2;
      if (paramVideoInfo.mAdvertisementSoftInfo.c == 0)
      {
        bool1 = bool2;
        if (paramVideoInfo.mAdMaterialId == 65)
        {
          bool1 = bool2;
          if (a(paramVideoInfo.mAdvertisementSoftInfo) == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static int b(VideoInfo paramVideoInfo, Activity paramActivity)
  {
    if (paramVideoInfo == null) {
      return 0;
    }
    paramVideoInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.mAdvertisementSoftInfo == null) {
        return 0;
      }
      return AIOUtils.b(106.0F, paramActivity.getResources());
    }
    return 0;
  }
  
  public static int c(VideoInfo paramVideoInfo, Activity paramActivity)
  {
    if (paramVideoInfo == null) {
      return 0;
    }
    paramVideoInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.mAdvertisementSoftInfo == null) {
        return 0;
      }
      if (a(paramVideoInfo.mAdvertisementSoftInfo) == 1) {
        return AIOUtils.b(160.0F, paramActivity.getResources());
      }
      return AIOUtils.b(120.0F, paramActivity.getResources());
    }
    return 0;
  }
  
  public static int d(VideoInfo paramVideoInfo, Activity paramActivity)
  {
    if (paramVideoInfo == null) {
      return 0;
    }
    paramVideoInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.mAdvertisementSoftInfo == null) {
        return 0;
      }
      return AIOUtils.b(90.0F, paramActivity.getResources());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdAms184
 * JD-Core Version:    0.7.0.1
 */