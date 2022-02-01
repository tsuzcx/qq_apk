package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;

public abstract interface OnPatchPlayListener
{
  public abstract void a(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void b(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener
 * JD-Core Version:    0.7.0.1
 */