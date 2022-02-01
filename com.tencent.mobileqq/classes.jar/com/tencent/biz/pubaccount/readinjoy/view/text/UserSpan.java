package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;

public class UserSpan
  extends PressedSpan
{
  private final long jdField_a_of_type_Long;
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private final String jdField_a_of_type_JavaLangString;
  
  public UserSpan(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public UserSpan(long paramLong, String paramString, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null)) {}
    ArticleInfo localArticleInfo;
    String str;
    do
    {
      return;
      QLog.d("UserSpan", 1, new Object[] { "openPersonUrl, uin = ", Long.valueOf(paramLong) });
      ReadInJoyUtils.a(paramContext, ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      str = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_JavaLangString, localArticleInfo, paramLong);
      if (ReadinjoyReportUtils.a(localArticleInfo.mChannelID)) {}
      for (paramContext = "0X800935C"; TextUtils.equals(this.jdField_a_of_type_JavaLangString, "3"); paramContext = "0X8007BA3")
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
        RIJFrameworkReportManager.b(localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "5"))
      {
        if (CmpCtxt.a(localArticleInfo))
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
          RIJFrameworkReportManager.b(localArticleInfo, (int)localArticleInfo.mChannelID);
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localArticleInfo.mSubscribeID, paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str, false);
        return;
      }
    } while (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "2"));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
  }
  
  public void onClick(View paramView)
  {
    a(this.jdField_a_of_type_Long, paramView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.UserSpan
 * JD-Core Version:    0.7.0.1
 */