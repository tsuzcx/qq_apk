package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnTopicRecommendHeaderClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnTopicRecommendHeaderClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderClickListener", 2, "business url is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)) {}
    for (Object localObject = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.a.get(0);; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (localObject == null))
      {
        QLog.d("OnTopicRecommendHeaderClickListener", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", localObject });
        return;
      }
      String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
      localActivityURIRequest.extra().putString("url", str);
      QRoute.startUri(localActivityURIRequest, null);
      str = RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localObject = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject).a + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      RIJFrameworkReportManager.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (i != 79)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderClickListener
 * JD-Core Version:    0.7.0.1
 */