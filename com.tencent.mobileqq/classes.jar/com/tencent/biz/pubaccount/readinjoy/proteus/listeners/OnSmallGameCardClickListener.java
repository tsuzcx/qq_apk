package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.CoreReport;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

public class OnSmallGameCardClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private int b;
  private int c;
  
  public OnSmallGameCardClickListener(IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1113: 
    default: 
      return 0;
    case 1114: 
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    int k = this.jdField_a_of_type_Int;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    int i;
    if (localArticleInfo != null)
    {
      if (!localArticleInfo.hasChannelInfo()) {
        break label158;
      }
      i = localArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(localArticleInfo.mArticleFriendLikeText)) {
        break label163;
      }
    }
    label158:
    label163:
    for (int j = 0;; j = 1)
    {
      String str = RIJFeedsType.b(localArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", localArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(localArticleInfo.mFeedId), Long.toString(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(localArticleInfo.mAlgorithmID, RIJFeedsType.a(localArticleInfo), k, i, j, NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext), str, localArticleInfo.mStrCircleId, localArticleInfo.innerUniqueID, RIJFeedsType.d(localArticleInfo), localArticleInfo), false);
      ReadinjoyReportUtils.CoreReport.a(localArticleInfo, k);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo == null)) {
      return;
    }
    String str2 = "";
    String str1 = "";
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    switch (this.c)
    {
    default: 
      paramViewBase = str2;
    case 1119: 
    case 1118: 
    case 1117: 
    case 1116: 
    case 1113: 
    case 1114: 
    case 1115: 
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramViewBase)) && (!TextUtils.isEmpty(str1)) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramViewBase, 2103, null)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnSmallGameCardClickListener", 0, "mini game url error jump by appid url = " + paramViewBase);
          }
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, str1, null, null, null, null, 2103, null);
        }
        a();
        return;
        ReadInJoyAdUtils.a(localArticleInfo, this.jdField_a_of_type_AndroidContentContext, this.b);
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo.t)) {
          break;
        }
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo.t);
        NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g(), 5040702, true);
        return;
        NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g(), 5040703, true);
        AdMiniGameGuideManager.a.a(localArticleInfo.mSmallMiniGameInfo.j);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo.r)) {
          break;
        }
        ((ReadInjoyImageView)paramViewBase).mSrc = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo.r;
        ((ReadInjoyImageView)paramViewBase).loadImage(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSmallMiniGameInfo.r);
        return;
        NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g(), this.b, 1);
        paramViewBase = localArticleInfo.mSmallMiniGameInfo.b(this.b);
        str1 = localArticleInfo.mSmallMiniGameInfo.a(this.b);
        continue;
        int i = a(this.c);
        NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g(), i, 1);
        paramViewBase = localArticleInfo.mSmallMiniGameInfo.b(i);
        str1 = localArticleInfo.mSmallMiniGameInfo.a(i);
      }
    }
    AdReportExtData.Builder localBuilder = new AdReportExtData.Builder().a(501L).b(50101L).c(5010105L).d(9L);
    if (localArticleInfo.mSmallMiniGameInfo.a()) {}
    for (paramViewBase = "3";; paramViewBase = "2")
    {
      paramViewBase = localBuilder.h(paramViewBase).i(String.valueOf(this.b)).a();
      NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo.mSmallMiniGameInfo.a);
      paramViewBase = str2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSmallGameCardClickListener
 * JD-Core Version:    0.7.0.1
 */