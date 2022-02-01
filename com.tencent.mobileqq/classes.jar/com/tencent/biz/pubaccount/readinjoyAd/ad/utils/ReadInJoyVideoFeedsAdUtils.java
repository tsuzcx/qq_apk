package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class ReadInJoyVideoFeedsAdUtils
{
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return null;
    }
    return NativeAdUtils.a(paramVideoAdInfo, Integer.valueOf(5), Integer.valueOf(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils
 * JD-Core Version:    0.7.0.1
 */