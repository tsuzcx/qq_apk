package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import java.util.Arrays;

class AdExposeFreshManager$CacheAd
{
  double jdField_a_of_type_Double;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  long b;
  
  public AdExposeFreshManager$CacheAd(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.b = paramVideoInfo.a.e;
    this.jdField_a_of_type_Double = paramVideoInfo.a.jdField_a_of_type_Double;
  }
  
  public AdExposeFreshManager$CacheAd(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.b = paramAdvertisementInfo.mAdAid;
    this.jdField_a_of_type_Double = paramAdvertisementInfo.ecpm;
  }
  
  public AdExposeFreshManager$CacheAd(AdData paramAdData)
  {
    this(paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
  }
  
  public boolean a()
  {
    return this.b != 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CacheAd)paramObject;
    } while (this.b == paramObject.b);
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new long[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager.CacheAd
 * JD-Core Version:    0.7.0.1
 */