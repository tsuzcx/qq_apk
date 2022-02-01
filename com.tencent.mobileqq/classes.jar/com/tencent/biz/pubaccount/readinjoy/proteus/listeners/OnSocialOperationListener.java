package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OnSocialOperationListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  OnSocialOperationListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramArticleInfo.mSocialFeedInfo;
      ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
      localReportInfo.mServerContext = paramArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mOperation = paramInt;
      if (localObject != null)
      {
        localFeedsReportData.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
            if (localObject != null) {
              localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(paramArticleInfo);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    label28:
    label40:
    int i;
    label59:
    int j;
    label73:
    long l;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID))
    {
      if (!RIJItemViewType.a(paramArticleInfo)) {
        break label300;
      }
      paramString1 = paramArticleInfo.mSubscribeID;
      if (localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList == null) {
        break label330;
      }
      i = localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.size();
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)) {
        break label335;
      }
      j = 0;
      int k = localSocializeFeedsInfo.jdField_b_of_type_Int;
      int m = localSocializeFeedsInfo.d;
      int n = localSocializeFeedsInfo.f;
      paramString1 = RIJTransMergeKanDianReport.a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramString1, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n).a();
      l = paramArticleInfo.mArticleID;
      if ((!RIJFeedsType.c(paramArticleInfo)) && (!RIJFeedsType.d(paramArticleInfo)) && (!RIJFeedsType.f(paramArticleInfo)) && (!RIJFeedsType.g(paramArticleInfo))) {
        break label401;
      }
      l = paramArticleInfo.businessId;
    }
    label401:
    for (;;)
    {
      if ((RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
      {
        if (!RIJItemViewType.o(paramArticleInfo)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
        }
        if ((RIJFeedsType.l(paramArticleInfo)) || (RIJFeedsType.m(paramArticleInfo))) {
          break;
        }
        RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
        paramString2 = paramString1;
        break label28;
        label300:
        paramString1 = "" + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        break label40;
        label330:
        i = 0;
        break label59;
        label335:
        j = 1;
        break label73;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
      return;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    a(paramArticleInfo);
    a(paramArticleInfo, a());
  }
  
  protected abstract int a();
  
  protected abstract void a(ArticleInfo paramArticleInfo);
  
  protected abstract void a(ViewBase paramViewBase);
  
  public final void onClick(ViewBase paramViewBase)
  {
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    a(paramViewBase);
    c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    InteraActionReportUtils.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialOperationListener
 * JD-Core Version:    0.7.0.1
 */