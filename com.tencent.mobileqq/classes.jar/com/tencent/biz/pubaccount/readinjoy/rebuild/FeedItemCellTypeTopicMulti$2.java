package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class FeedItemCellTypeTopicMulti$2
  implements View.OnClickListener
{
  FeedItemCellTypeTopicMulti$2(FeedItemCellTypeTopicMulti paramFeedItemCellTypeTopicMulti, ArticleInfo paramArticleInfo, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void onClick(View paramView)
  {
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCellTypeTopicMulti.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.b);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.a);
      localJSONObject.put("kandian_mode", "" + RIJAppSetting.a());
      localJSONObject.put("tab_source", "" + RIJTransMergeKanDianReport.a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008277", "0X8008277", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeTopicMulti.2
 * JD-Core Version:    0.7.0.1
 */