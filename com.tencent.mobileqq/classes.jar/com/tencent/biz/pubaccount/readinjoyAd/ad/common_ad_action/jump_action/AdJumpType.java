package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;

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
    if (paramAdvertisementInfo == null) {}
    while ((paramAdvertisementInfo.mChannelID != 0L) || (!TextUtils.isEmpty(ReadinJoyActionUtil.a(paramAdvertisementInfo, "AdsIconText")))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.isSoftAd());
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return FastWeqAdUtils.a(paramAdvertisementInfo);
  }
  
  private static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((paramAdvertisementInfo.mImaxShowAdType != 1001) && (paramAdvertisementInfo.mImaxShowAdType != 1002)) {
      return false;
    }
    return true;
  }
  
  private static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo == null)) {}
    while (5001 != paramAdvertisementInfo.mAdvertisementExtInfo.i) {
      return false;
    }
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.AdJumpType
 * JD-Core Version:    0.7.0.1
 */