package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.widget.SimpleFeedbackPopupWindow.Callback;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class ReadInJoyPicWaterFallFragment$4
  implements SimpleFeedbackPopupWindow.Callback
{
  ReadInJoyPicWaterFallFragment$4(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = GalleryReportedUtils.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      GalleryReportedUtils.ReportData localReportData = new GalleryReportedUtils.ReportData(paramBaseArticleInfo);
      localReportData.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localReportData.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localReportData.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localReportData.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localReportData.b = "0X8009A79";
      localReportData.c = "0X8009A79";
      GalleryReportedUtils.a(localReportData);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.a);
      localJSONObject.put("kandian_mode", RIJAppSetting.a());
      localJSONObject.put("feeds_type", "" + RIJFeedsType.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", ReadinjoyReportUtils.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", HardCodeUtil.a(2131713092), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.4
 * JD-Core Version:    0.7.0.1
 */