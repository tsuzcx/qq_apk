package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.hippy.qq.update.sign.Base64Util;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OnCommentClickListener
  extends OnSocialOperationListener
{
  private VafContext a;
  
  public OnCommentClickListener(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    super(paramArticleInfo, paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
  
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniqueKey", paramBaseArticleInfo.innerUniqueID);
      localJSONObject.put("source", 3);
      localJSONObject.put("feedsID", "");
      localJSONObject.put("adTag", 1);
      localJSONObject.put("title", Base64Util.encode(paramBaseArticleInfo.mTitle.getBytes()));
      localJSONObject.put("sourceName", paramBaseArticleInfo.getSubscribeName());
      localJSONObject.put("picUrl", paramBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("duration", paramBaseArticleInfo.mVideoDuration);
      localJSONObject.put("articleID", paramBaseArticleInfo.mArticleID);
      localJSONObject.put("isAwesome", paramBaseArticleInfo.hasAwesome);
      localJSONObject.put("jumpType", paramBaseArticleInfo.mJumpType);
      localJSONObject.put("recommendSeq", paramBaseArticleInfo.mRecommendSeq);
      return localJSONObject;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.d("OnCommentClickListener", 1, "buildNativeCommentJson fail");
    }
    return localJSONObject;
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    if ((RIJItemViewType.a(paramArticleInfo)) || (RIJItemViewType.b(paramArticleInfo)))
    {
      if (!TextUtils.isEmpty(paramArticleInfo.commentJumpUrl)) {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.commentJumpUrl);
      }
      while ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        return;
      }
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, true);
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
    {
      str2 = RIJTransMergeKanDianReport.a(paramArticleInfo);
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!RIJFeedsType.l(paramArticleInfo)) && (!RIJFeedsType.m(paramArticleInfo))) {
        RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      ViolaBizUtils.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), 0);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 36) {
        break;
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity));
    RIJJumpUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 8);
    return;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.d > 0) && (!ReadinJoyActionUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      QLog.d("OnCommentClickListener", 1, "jumpUrl");
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    QLog.d("OnCommentClickListener", 1, "openCommentComponent");
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, 9, HardCodeUtil.a(2131707816), null, false, null, false, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnCommentClickListener
 * JD-Core Version:    0.7.0.1
 */