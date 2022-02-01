package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.IReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdViewUtil;", "", "()V", "setVideoData", "", "videoView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/IReadInJoyArticleBottomVideoView;", "info", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyAdViewUtil
{
  public static final ReadInJoyAdViewUtil a = new ReadInJoyAdViewUtil();
  
  @JvmStatic
  public static final void a(@Nullable IReadInJoyArticleBottomVideoView paramIReadInJoyArticleBottomVideoView, @Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if ((paramIReadInJoyArticleBottomVideoView instanceof ReadInJoyArticleBottomVideoView))
    {
      AdModuleVideo localAdModuleVideo = new AdModuleVideo();
      localAdModuleVideo.r = paramAdvertisementInfo.mAdImg;
      localAdModuleVideo.p = paramAdvertisementInfo.mAdVideoUrl;
      ProteusBannerVideoItemData localProteusBannerVideoItemData = new ProteusBannerVideoItemData();
      localProteusBannerVideoItemData.a = false;
      localProteusBannerVideoItemData.c = paramAdvertisementInfo.mAdVideoFileSize;
      localProteusBannerVideoItemData.b = true;
      localProteusBannerVideoItemData.G = paramAdvertisementInfo.mAdVideoUrl;
      paramIReadInJoyArticleBottomVideoView = (ReadInJoyArticleBottomVideoView)paramIReadInJoyArticleBottomVideoView;
      paramIReadInJoyArticleBottomVideoView.setVisibility(0);
      paramIReadInJoyArticleBottomVideoView.a(localAdModuleVideo, paramAdvertisementInfo, localProteusBannerVideoItemData, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdViewUtil
 * JD-Core Version:    0.7.0.1
 */