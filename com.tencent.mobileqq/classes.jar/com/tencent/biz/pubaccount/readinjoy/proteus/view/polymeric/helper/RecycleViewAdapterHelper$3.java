package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSmallGameCardClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class RecycleViewAdapterHelper$3
  implements ViewFactory.FoundClickableViewListener
{
  RecycleViewAdapterHelper$3(RecycleViewAdapterHelper paramRecycleViewAdapterHelper, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper) != null) {
      paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.1(this));
    }
    do
    {
      return;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        return;
      case 1039: 
        paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.3(this));
        return;
      case 1041: 
        paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.2(this));
        return;
      case 1134: 
        paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.4(this));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper.a.a() == null));
    paramViewBase.setOnClickListener(new OnSmallGameCardClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper.a, RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper).getContext(), 1116, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper.a.e(), this.jdField_a_of_type_Int));
    return;
    RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper, 3, paramViewBase, this.jdField_a_of_type_Int);
    return;
    RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper, 1, paramViewBase, this.jdField_a_of_type_Int);
    return;
    RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericHelperRecycleViewAdapterHelper, 2, paramViewBase, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.3
 * JD-Core Version:    0.7.0.1
 */