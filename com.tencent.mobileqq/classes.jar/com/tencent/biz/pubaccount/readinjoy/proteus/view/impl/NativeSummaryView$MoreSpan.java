package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class NativeSummaryView$MoreSpan
  extends PressedSpan
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public NativeSummaryView$MoreSpan(NativeSummaryView paramNativeSummaryView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if ((RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext() instanceof Activity)))
    {
      RIJJumpUtils.b((Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (RIJItemViewType.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (int i = 2;; i = 3)
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */