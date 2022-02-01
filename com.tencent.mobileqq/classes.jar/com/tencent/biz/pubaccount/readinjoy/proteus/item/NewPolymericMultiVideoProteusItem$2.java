package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnHorizontalSubArticleClick;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

class NewPolymericMultiVideoProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  NewPolymericMultiVideoProteusItem$2(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, ArticleInfo paramArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("NewPolymericMultiVideoProteusItem", 1, "position : " + paramInt);
    NewPolymericMultiVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNewPolymericMultiVideoProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramViewBase.getNativeView(), paramInt, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NewPolymericMultiVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */