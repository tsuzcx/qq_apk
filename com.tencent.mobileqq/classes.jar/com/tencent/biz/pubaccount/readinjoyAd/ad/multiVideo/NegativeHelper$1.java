package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class NegativeHelper$1
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    QQToast.a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper), 0, 2131695178, 0).a();
    if ((paramObject != null) && ((paramObject instanceof DislikeInfo))) {}
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramView = "";
      paramInt = 0;
      paramObject = "";
      if (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        if (localDislikeInfo == null) {
          break label230;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (paramInt == paramArrayList.size() - 1) {
          break label233;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      label230:
      label233:
      for (;;)
      {
        paramInt += 1;
        break;
        NativeAdUtils.a(new AdReportData().a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)).a(3).b(5).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramObject).b(paramView));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper.1
 * JD-Core Version:    0.7.0.1
 */