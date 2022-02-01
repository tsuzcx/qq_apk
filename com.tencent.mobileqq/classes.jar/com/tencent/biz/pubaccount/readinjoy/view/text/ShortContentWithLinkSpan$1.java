package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

final class ShortContentWithLinkSpan$1
  extends PressedSpan
{
  ShortContentWithLinkSpan$1(int paramInt1, int paramInt2, int paramInt3, String paramString, ArticleInfo paramArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(@NonNull View paramView)
  {
    RIJJumpUtils.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clickArea = 11;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_JavaLangString, "-1");
      RIJFrameworkReportManager.a(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.ShortContentWithLinkSpan.1
 * JD-Core Version:    0.7.0.1
 */