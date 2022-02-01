package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentTopicItemSingle$1
  implements View.OnClickListener
{
  ComponentTopicItemSingle$1(ComponentTopicItemSingle paramComponentTopicItemSingle, TopicRecommendFeedsInfo.TopicRecommendInfo paramTopicRecommendInfo) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.a();
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = localArticleInfo;
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.b);
    String str1 = RIJTransMergeKanDianReport.a(localArticleInfo.mAlgorithmID, RIJFeedsType.a(localArticleInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e(), 0, 0, NetworkUtil.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.getContext()), localArticleInfo.mSubscribeID, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    String str2 = ReadinjoyReportUtils.b(localArticleInfo.mChannelID);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localArticleInfo.mSubscribeID, str2, str2, 0, 0, localArticleInfo.mFeedId + "", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.a), String.valueOf(localArticleInfo.mAlgorithmID), str1, false);
    RIJFrameworkReportManager.c(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle.a.a.e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle.1
 * JD-Core Version:    0.7.0.1
 */