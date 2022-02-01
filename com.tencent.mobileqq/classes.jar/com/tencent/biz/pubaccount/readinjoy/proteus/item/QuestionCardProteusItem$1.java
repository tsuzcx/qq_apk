package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSuperTopicClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QuestionCardProteusItem$1
  implements View.OnClickListener
{
  QuestionCardProteusItem$1(QuestionCardProteusItem paramQuestionCardProteusItem, IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    OnSuperTopicClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), this.jdField_a_of_type_AndroidContentContext);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    String str1 = String.valueOf(RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), this.jdField_a_of_type_Int));
    String str2 = RIJTransMergeKanDianReport.a(localArticleInfo.mAlgorithmID, RIJFeedsType.a(localArticleInfo), 70, 0, 0, NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext), str1, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str1, "0X8009355", "0X8009355", 0, 0, localArticleInfo.mFeedId + "", String.valueOf(localArticleInfo.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str2, false);
    ReadinjoyReportUtils.a(localArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.QuestionCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */