package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class VideoFeedsShareController$9
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoFeedsShareController$9(VideoFeedsShareController paramVideoFeedsShareController, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = ReadInJoyUtils.a();
    AdvertisementInfo localAdvertisementInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.makeDislikeParam(paramArrayList, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g));
      localAdvertisementInfo = NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label352;
      }
    }
    label346:
    label349:
    label352:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramObject = "";
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(i);
        if (localDislikeInfo == null) {
          break label346;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label349;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        i += 1;
        break;
        NativeAdUtils.a(new AdReportData().a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController)).a(3).b(10).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(l).a(paramObject).b(paramView));
        QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), -1, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).getString(2131699745), 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).getResources().getDimensionPixelSize(2131299166));
        VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.9
 * JD-Core Version:    0.7.0.1
 */