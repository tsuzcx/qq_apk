package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class NativeCommentView$2
  extends PressedSpan
{
  NativeCommentView$2(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3, ArticleInfo paramArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.a.a.a(), 4, false, 7, false);
    RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.a.a.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView.2
 * JD-Core Version:    0.7.0.1
 */