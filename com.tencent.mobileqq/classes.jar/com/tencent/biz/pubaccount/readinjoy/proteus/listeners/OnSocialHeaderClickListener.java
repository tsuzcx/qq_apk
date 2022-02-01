package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class OnSocialHeaderClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnSocialHeaderClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (i == 76) || (i == 78) || (i == 77) || (RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clickArea = 6;
      PGCShortContentUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      RIJFrameworkReportManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    }
    for (;;)
    {
      VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("card").e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID).g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.dtReportBackendInfo).b("list").a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).a("14").b(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.dtReportContentType)).c("click_contentid").a().a());
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 36)
      {
        RIJJumpUtils.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6);
      }
      else if (RIJItemViewType.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        paramViewBase = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID).getBytes(), 2);
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
      }
      else
      {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderClickListener
 * JD-Core Version:    0.7.0.1
 */