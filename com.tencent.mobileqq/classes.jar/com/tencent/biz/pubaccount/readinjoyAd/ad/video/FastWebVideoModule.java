package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "", "()V", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "getAdData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "setAdData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getAdInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setAdInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "getVideoData", "()Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "setVideoData", "(Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;)V", "videoReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;", "getVideoReportData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;", "setVideoReportData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;)V", "initModule", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoModule
{
  @Nullable
  private AdModuleVideo jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo;
  @Nullable
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  @Nullable
  private ProteusBannerVideoItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
  @NotNull
  private VideoAdReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData = new VideoAdReportData();
  
  @Nullable
  public final AdvertisementInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  }
  
  @Nullable
  public final ProteusBannerVideoItemData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
  }
  
  @NotNull
  public final VideoAdReportData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = ((AdModuleVideo)null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData = ((ProteusBannerVideoItemData)null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.c(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.d(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.b(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.g(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.e(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.f(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.h(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoVideoAdReportData.a(false);
  }
  
  public final void a(@Nullable AdModuleVideo paramAdModuleVideo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdModuleAdModuleVideo = paramAdModuleVideo;
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public final void a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData = paramProteusBannerVideoItemData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoModule
 * JD-Core Version:    0.7.0.1
 */