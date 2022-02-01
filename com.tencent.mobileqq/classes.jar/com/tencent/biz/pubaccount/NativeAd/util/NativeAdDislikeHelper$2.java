package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class NativeAdDislikeHelper$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  NativeAdDislikeHelper$2(NativeAdDislikeHelper paramNativeAdDislikeHelper, AdvertisementInfo paramAdvertisementInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onUninterestConfirm");
    }
    paramView = ReadInJoyUtils.a();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper) != null))
    {
      localObject = (ReadInJoyLogicManager)NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (((ReadInJoyLogicManager)localObject).a() != null) {
        ((ReadInJoyLogicManager)localObject).a().a(Long.valueOf(paramView).longValue(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.makeDislikeParam(paramArrayList, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mArticleID)));
      }
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label364;
      }
    }
    label358:
    label361:
    label364:
    for (long l = ((DislikeInfo)paramObject).jdField_a_of_type_Long;; l = 0L)
    {
      paramObject = "";
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (DislikeInfo)paramArrayList.get(i);
        if (localObject == null) {
          break label358;
        }
        paramObject = paramObject + ((DislikeInfo)localObject).jdField_a_of_type_Long;
        paramView = paramView + ((DislikeInfo)localObject).jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label361;
        }
        paramObject = paramObject + ",";
        paramView = paramView + ",";
      }
      for (;;)
      {
        i += 1;
        break;
        NativeAdUtils.a(new AdReportData().a(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper)).a(3).b(10).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l).a(paramObject).b(paramView));
        QQToast.a(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper), -1, NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getString(2131699745), 0).b(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getResources().getDimensionPixelSize(2131299166));
        NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper.2
 * JD-Core Version:    0.7.0.1
 */