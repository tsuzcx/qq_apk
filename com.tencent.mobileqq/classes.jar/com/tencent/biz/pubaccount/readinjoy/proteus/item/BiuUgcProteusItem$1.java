package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BiuUgcProteusItem$1
  implements View.OnClickListener
{
  BiuUgcProteusItem$1(BiuUgcProteusItem paramBiuUgcProteusItem, ArticleInfo paramArticleInfo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (RIJItemViewType.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (int i = 3;; i = 2)
    {
      RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, false, 2, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuUgcProteusItem.1
 * JD-Core Version:    0.7.0.1
 */