package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

final class JumpAdUtils$1
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  JumpAdUtils$1(Context paramContext, BaseData paramBaseData, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
      ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    }
    if (((QQAppInterface)ReadInJoyUtils.a() != null) && (paramArrayList != null))
    {
      paramObject = "";
      paramView = "";
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        if (localDislikeInfo == null) {
          break label269;
        }
        paramObject = paramObject + localDislikeInfo.jdField_a_of_type_Long;
        paramView = paramView + localDislikeInfo.jdField_a_of_type_JavaLangString;
        if (paramInt == paramArrayList.size() - 1) {
          break label272;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
    }
    label269:
    label272:
    for (;;)
    {
      paramInt += 1;
      break;
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(3).b(NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(ReadInJoyBottomAdVideoUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)).a(paramObject).b(paramView).d(NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData)));
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, this.jdField_a_of_type_AndroidContentContext.getString(2131699745), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils.1
 * JD-Core Version:    0.7.0.1
 */