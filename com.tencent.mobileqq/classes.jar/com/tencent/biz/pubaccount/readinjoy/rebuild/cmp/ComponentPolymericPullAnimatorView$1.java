package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ComponentPolymericPullAnimatorView$1
  implements View.OnClickListener
{
  ComponentPolymericPullAnimatorView$1(ComponentPolymericPullAnimatorView paramComponentPolymericPullAnimatorView, ArticleInfo paramArticleInfo, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericPullAnimatorView.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.d);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + "";
    if (RIJFeedsType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (String str1 = "1";; str1 = "2")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982B", "0X800982B", 0, 0, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId + "", this.jdField_a_of_type_OrgJsonJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView.1
 * JD-Core Version:    0.7.0.1
 */