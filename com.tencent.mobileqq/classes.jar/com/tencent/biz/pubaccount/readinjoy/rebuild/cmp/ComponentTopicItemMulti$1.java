package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentTopicItemMulti$1
  implements View.OnClickListener
{
  ComponentTopicItemMulti$1(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = ComponentTopicItemMulti.a(this.a);
    ReadInJoyUtils.a(this.a.getContext(), this.a.a.b);
    String str1 = ReadinjoyReportUtils.b(ComponentTopicItemMulti.a(this.a));
    String str2 = RIJTransMergeKanDianReport.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, RIJFeedsType.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, NetworkUtil.h(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, str1, str1, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str2, false);
    RIJFrameworkReportManager.c(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti.1
 * JD-Core Version:    0.7.0.1
 */