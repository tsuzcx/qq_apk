package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.kandian.biz.feeds.api.IArticleInfoHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper) != null))
    {
      paramView = (IReadInJoyLogicManager)NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (paramView.getReadInJoyLogicEngine() != null)
      {
        paramView = paramView.getReadInJoyLogicEngine();
        l1 = Long.valueOf((String)localObject1).longValue();
        localObject1 = (IArticleInfoHelper)QRoute.api(IArticleInfoHelper.class);
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        paramView.a(l1, ((IArticleInfoHelper)localObject1).makeDislikeParam((AbsBaseArticleInfo)localObject2, paramArrayList, String.valueOf(((AdvertisementInfo)localObject2).mArticleID)));
      }
      long l2 = 0L;
      long l1 = l2;
      if (paramObject != null)
      {
        l1 = l2;
        if ((paramObject instanceof DislikeInfo)) {
          l1 = ((DislikeInfo)paramObject).jdField_a_of_type_Long;
        }
      }
      Object localObject2 = "";
      localObject1 = localObject2;
      int i = 0;
      while (i < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(i);
        paramObject = localObject1;
        paramView = (View)localObject2;
        if (localDislikeInfo != null)
        {
          paramView = new StringBuilder();
          paramView.append((String)localObject2);
          paramView.append(localDislikeInfo.jdField_a_of_type_Long);
          localObject2 = paramView.toString();
          paramView = new StringBuilder();
          paramView.append((String)localObject1);
          paramView.append(localDislikeInfo.jdField_a_of_type_JavaLangString);
          localObject1 = paramView.toString();
          paramObject = localObject1;
          paramView = (View)localObject2;
          if (i != paramArrayList.size() - 1)
          {
            paramView = new StringBuilder();
            paramView.append((String)localObject2);
            paramView.append(",");
            paramView = paramView.toString();
            paramObject = new StringBuilder();
            paramObject.append((String)localObject1);
            paramObject.append(",");
            paramObject = paramObject.toString();
          }
        }
        i += 1;
        localObject1 = paramObject;
        localObject2 = paramView;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper)).a(3).b(10).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(l1).a((String)localObject2).b((String)localObject1));
    }
    QQToast.a(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper), -1, NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getString(2131699886), 0).b(NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).getResources().getDimensionPixelSize(2131299168));
    NativeAdDislikeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilNativeAdDislikeHelper).dismiss();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdDislikeHelper.2
 * JD-Core Version:    0.7.0.1
 */