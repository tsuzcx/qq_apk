package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "", "()V", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "getAdData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "setAdData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getAdInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setAdInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "getVideoData", "()Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "setVideoData", "(Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;)V", "videoReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;", "getVideoReportData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;", "setVideoReportData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoAdReportData;)V", "initModule", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoModule
{
  @Nullable
  private AdModuleVideo a;
  @Nullable
  private AdvertisementInfo b;
  @Nullable
  private ProteusBannerVideoItemData c;
  @NotNull
  private VideoAdReportData d = new VideoAdReportData();
  
  @Nullable
  public final AdvertisementInfo a()
  {
    return this.b;
  }
  
  public final void a(@Nullable AdModuleVideo paramAdModuleVideo)
  {
    this.a = paramAdModuleVideo;
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    this.b = paramAdvertisementInfo;
  }
  
  public final void a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    this.c = paramProteusBannerVideoItemData;
  }
  
  @Nullable
  public final ProteusBannerVideoItemData b()
  {
    return this.c;
  }
  
  @NotNull
  public final VideoAdReportData c()
  {
    return this.d;
  }
  
  public final void d()
  {
    this.a = ((AdModuleVideo)null);
    this.b = ((AdvertisementInfo)null);
    this.c = ((ProteusBannerVideoItemData)null);
    this.d.c(1);
    this.d.d(0);
    this.d.a(0);
    this.d.b(0);
    this.d.g(0);
    this.d.e(1);
    this.d.f(1);
    this.d.h(0);
    this.d.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoModule
 * JD-Core Version:    0.7.0.1
 */