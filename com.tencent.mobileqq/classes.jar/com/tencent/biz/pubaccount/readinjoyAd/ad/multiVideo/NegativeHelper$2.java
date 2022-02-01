package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.IAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class NegativeHelper$2
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  NegativeHelper$2(NegativeHelper paramNegativeHelper, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      QQToast.a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper), 0, 2131695178, 0).a();
      if (NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper) != null) {
        NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper).d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label401;
      }
    }
    label395:
    label398:
    label401:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramView = "";
      paramInt = 0;
      paramObject = "";
      if (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        if (localDislikeInfo == null) {
          break label395;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (paramInt == paramArrayList.size() - 1) {
          break label398;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f = l;
          paramArrayList = NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper))) {
            NativeAdUtils.a(new AdReportData().a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)).a(3).b(10).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramObject).b(paramView));
          }
        }
        else
        {
          return;
        }
        NativeAdUtils.a(new AdReportData().a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)).a(3).b(5).a(paramArrayList).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.f).a(paramObject).b(paramView));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper.2
 * JD-Core Version:    0.7.0.1
 */