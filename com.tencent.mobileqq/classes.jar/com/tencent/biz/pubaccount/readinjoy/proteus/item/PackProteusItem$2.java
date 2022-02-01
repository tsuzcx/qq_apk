package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnHorizontalSubArticleClick;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PackProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  PackProteusItem$2(PackProteusItem paramPackProteusItem, List paramList, ArticleInfo paramArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      QLog.i("PackProteusItem", 1, "[onItemClick] position overflow, position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
      paramTemplateBean = (BaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a().a().a(paramTemplateBean, paramViewBase.getNativeView(), paramInt, paramInt);
      return;
    }
    catch (Exception paramViewBase)
    {
      QLog.e("PackProteusItem", 1, "[onItemClick], e = " + paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PackProteusItem.2
 * JD-Core Version:    0.7.0.1
 */