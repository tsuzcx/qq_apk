package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DoubleVideoProteusItem$4
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$4(DoubleVideoProteusItem paramDoubleVideoProteusItem, IReadInJoyModel paramIReadInJoyModel, int paramInt, BaseArticleInfo paramBaseArticleInfo, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    TemplateBean localTemplateBean2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mProteusTemplateBean;
    TemplateBean localTemplateBean1 = localTemplateBean2;
    if (localTemplateBean2 == null) {
      localTemplateBean1 = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
    }
    if (localTemplateBean1 != null)
    {
      paramViewBase = DoubleVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemDoubleVideoProteusItem, localTemplateBean1, paramViewBase);
      if (ReadInJoyAdUtils.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        ReadInJoyAdUtils.a((ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.g());
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a(false, (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem.4
 * JD-Core Version:    0.7.0.1
 */