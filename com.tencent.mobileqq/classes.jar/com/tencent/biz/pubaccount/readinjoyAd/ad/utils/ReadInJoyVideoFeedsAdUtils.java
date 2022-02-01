package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyVideoFeedsAdUtils
{
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return null;
    }
    return ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo, Integer.valueOf(5), Integer.valueOf(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils
 * JD-Core Version:    0.7.0.1
 */