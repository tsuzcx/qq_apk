package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.Arrays;

class AdExposeFreshManager$CacheAd
{
  double jdField_a_of_type_Double;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  AdData jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData;
  VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  long b;
  
  public AdExposeFreshManager$CacheAd(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.b = paramAdvertisementInfo.mAdAid;
    this.jdField_a_of_type_Double = paramAdvertisementInfo.ecpm;
  }
  
  public AdExposeFreshManager$CacheAd(AdData paramAdData)
  {
    this(paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData = paramAdData;
  }
  
  public AdExposeFreshManager$CacheAd(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    this.b = paramVideoInfo.a.e;
    this.jdField_a_of_type_Double = paramVideoInfo.a.jdField_a_of_type_Double;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager.CacheAd
 * JD-Core Version:    0.7.0.1
 */