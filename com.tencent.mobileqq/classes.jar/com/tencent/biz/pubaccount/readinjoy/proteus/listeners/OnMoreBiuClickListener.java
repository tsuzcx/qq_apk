package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.util.NetworkState;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class OnMoreBiuClickListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnMoreBiuClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = 1;
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("algorithm_id", paramArticleInfo.mAlgorithmID);
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.a);
        ((JSONObject)localObject2).put("feeds_type", paramInt);
        ((JSONObject)localObject2).put("time", System.currentTimeMillis());
        ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
        if (!NetworkState.isWifiConn()) {
          continue;
        }
        paramInt = 2;
        ((JSONObject)localObject2).put("network_type", paramInt);
        ((JSONObject)localObject2).put("feeds_source", RIJFeedsType.b(paramArticleInfo));
        ((JSONObject)localObject2).put("imei", ReadInJoyUtils.b());
        ((JSONObject)localObject2).put("imsi", ReadInJoyUtils.c());
        if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)) {
          ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
        }
        ((JSONObject)localObject2).put("comment", paramArticleInfo.mSocialFeedInfo.d);
        if (ReadInJoyHelper.z(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          continue;
        }
        paramInt = i;
        ((JSONObject)localObject2).put("reddot_style", paramInt);
        ((JSONObject)localObject2).put("tab_source", RIJTransMergeKanDianReport.a());
        ((JSONObject)localObject2).put("kandian_mode", "" + RIJAppSetting.a());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
        continue;
      }
      if ((!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        continue;
      }
      localObject2 = "0";
      str2 = "0X8009492";
      if (paramArticleInfo.mChannelID == 70L) {
        str2 = "0X8009488";
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.b(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mExtraBiuBriefInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnMoreBiuClickListener
 * JD-Core Version:    0.7.0.1
 */