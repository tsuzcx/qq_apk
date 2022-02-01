package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.widget.SimpleFeedbackPopupWindow;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ReadInJoyPicWaterFallFragment$NormalViewHolder$2
  implements View.OnClickListener
{
  ReadInJoyPicWaterFallFragment$NormalViewHolder$2(ReadInJoyPicWaterFallFragment.NormalViewHolder paramNormalViewHolder, ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPicWaterFallFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment).a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.a());
    Object localObject = GalleryReportedUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a(), 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.a(), (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    try
    {
      ((JSONObject)localObject).put("card_type", 8);
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localReportData.e = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID);
      localReportData.f = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId);
      localReportData.g = ((JSONObject)localObject).toString();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a != null) {
        localReportData.a = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localReportData.b = "0X8009A78";
      localReportData.c = "0X8009A78";
      GalleryReportedUtils.a(localReportData);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment.a());
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.a);
      ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
      ((JSONObject)localObject).put("feeds_type", "1008");
      ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyPicWaterFallFragment$NormalViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
      localObject = ((JSONObject)localObject).toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", (String)localObject, false);
    }
    catch (Exception localException)
    {
      label308:
      break label308;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.NormalViewHolder.2
 * JD-Core Version:    0.7.0.1
 */