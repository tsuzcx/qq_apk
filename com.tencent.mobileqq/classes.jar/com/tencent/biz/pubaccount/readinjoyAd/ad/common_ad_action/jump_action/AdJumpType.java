package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.qroute.QRoute;

public class AdJumpType
{
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (b(paramAdvertisementInfo))
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.c == 0) {
        return 3;
      }
      return 4;
    }
    if (c(paramAdvertisementInfo)) {
      return 5;
    }
    if (a(paramAdvertisementInfo)) {
      return 2;
    }
    if (d(paramAdvertisementInfo)) {
      return 6;
    }
    if (e(paramAdvertisementInfo)) {
      return 7;
    }
    if (f(paramAdvertisementInfo)) {
      return 8;
    }
    if (g(paramAdvertisementInfo)) {
      return 9;
    }
    return 1;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAdvertisementInfo.mChannelID == 0L)
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdExtParam(paramAdvertisementInfo, "AdsIconText"))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.isSoftAd());
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(paramAdvertisementInfo);
  }
  
  private static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mImaxShowAdType == 1001) || (paramAdvertisementInfo.mImaxShowAdType == 1002)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.mAdvertisementExtInfo == null) {
        return false;
      }
      bool1 = bool2;
      if (5001 == paramAdvertisementInfo.mAdvertisementExtInfo.i) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return e(paramAdvertisementInfo);
  }
  
  private static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.AdJumpType
 * JD-Core Version:    0.7.0.1
 */