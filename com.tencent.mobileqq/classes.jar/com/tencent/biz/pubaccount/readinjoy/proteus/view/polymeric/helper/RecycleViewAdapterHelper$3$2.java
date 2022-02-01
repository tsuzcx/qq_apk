package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class RecycleViewAdapterHelper$3$2
  implements ViewBase.OnClickListener
{
  RecycleViewAdapterHelper$3$2(RecycleViewAdapterHelper.3 param3) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ProteusSupportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper) != null) && (this.a.jdField_a_of_type_Int < RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper).size()))
    {
      RIJJumpUtils.a(RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper).getContext(), (BaseArticleInfo)RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    ReadInJoyUtils.a(RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3.2
 * JD-Core Version:    0.7.0.1
 */