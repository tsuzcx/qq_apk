package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.Arrays;

class AdExposeFreshManager$CacheAd
{
  long a = System.currentTimeMillis();
  long b;
  double c;
  AdvertisementInfo d;
  VideoInfo e;
  AdData f;
  
  public AdExposeFreshManager$CacheAd(AdvertisementInfo paramAdvertisementInfo)
  {
    this.d = paramAdvertisementInfo;
    this.b = paramAdvertisementInfo.mAdAid;
    this.c = paramAdvertisementInfo.ecpm;
  }
  
  public AdExposeFreshManager$CacheAd(AdData paramAdData)
  {
    this(paramAdData.j);
    this.f = paramAdData;
  }
  
  public AdExposeFreshManager$CacheAd(VideoInfo paramVideoInfo)
  {
    this.e = paramVideoInfo;
    this.b = paramVideoInfo.as.G;
    this.c = paramVideoInfo.as.az;
  }
  
  public boolean a()
  {
    return this.b != 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (CacheAd)paramObject;
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new long[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager.CacheAd
 * JD-Core Version:    0.7.0.1
 */