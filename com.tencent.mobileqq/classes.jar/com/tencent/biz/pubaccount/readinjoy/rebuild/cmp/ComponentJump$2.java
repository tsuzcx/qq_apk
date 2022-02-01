package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class ComponentJump$2
  implements View.OnClickListener
{
  ComponentJump$2(ComponentJump paramComponentJump, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoName, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoType, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.hasChannelInfo()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelInfoId;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feeds_channel_entrance", i);
      localObject = ((JSONObject)localObject).toString();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", (String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump.2
 * JD-Core Version:    0.7.0.1
 */