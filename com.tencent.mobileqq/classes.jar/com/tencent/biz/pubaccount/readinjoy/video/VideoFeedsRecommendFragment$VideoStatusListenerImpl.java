package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.VideoAdTimeReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class VideoFeedsRecommendFragment$VideoStatusListenerImpl
  implements VideoFeedsPlayManager.VideoStatusListener
{
  private VideoFeedsRecommendFragment$VideoStatusListenerImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, false);
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      VideoFeedsRecommendFragment.a(this.a).g();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c))
    {
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam);
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool;
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      bool = VideoFeedsRecommendFragment.a(this.a).c();
      VideoFeedsPlayActivity.a("video play completion!, in weishi mode! interrupted weishi ad");
      if (!bool) {}
    }
    do
    {
      do
      {
        return;
        VideoFeedsPlayActivity.a("video play completion!, move to next position");
        bool = VideoFeedsRecommendFragment.d(this.a);
        if (VideoFeedsRecommendFragment.a(this.a))
        {
          if (bool)
          {
            VideoFeedsRecommendFragment.a(this.a).b();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.d(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (NativeAdUtils.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.f(this.a)) && (NetworkUtil.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).b())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new VideoFeedsRecommendFragment.VideoStatusListenerImpl.1(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, true);
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void d(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if ((VideoPreloadStrategyConoller.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper)) && (ReadInJoyHelper.x(VideoFeedsRecommendFragment.a(this.a))) && (paramVideoPlayParam == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof BaseVideoItemHolder))
      {
        localObject = (BaseVideoItemHolder)localObject;
        if (((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) {
        break label319;
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataVideoAdTimeReportData.a <= 0L) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataVideoAdTimeReportData.a = VideoFeedsRecommendFragment.a(this.a).a();
      }
      VideoFeedsRecommendFragment.a(this.a).f();
    }
    for (;;)
    {
      if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        VideoFeedsRecommendFragment.a(this.a).a(paramVideoPlayParam);
      }
      return;
      label319:
      VideoFeedsRecommendFragment.a(this.a).a();
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString))) {
        VideoFeedsRecommendFragment.a(this.a).b(0);
      } else {
        VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
      }
    }
  }
  
  public void e(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void f(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void g(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.VideoStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */