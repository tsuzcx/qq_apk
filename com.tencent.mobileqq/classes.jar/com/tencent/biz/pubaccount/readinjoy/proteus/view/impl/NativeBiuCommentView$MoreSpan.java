package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class NativeBiuCommentView$MoreSpan
  extends PressedSpan
{
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public NativeBiuCommentView$MoreSpan(NativeBiuCommentView paramNativeBiuCommentView, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (RIJItemViewType.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 5, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    if (RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext();
      if ((paramView instanceof Activity)) {
        RIJJumpUtils.b(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6);
      }
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      return;
    }
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */