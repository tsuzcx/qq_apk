package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ProteusSupportUtil$1$1
  implements ViewBase.OnClickListener
{
  ProteusSupportUtil$1$1(ProteusSupportUtil.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity() != null)
    {
      ProteusSupportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getCurActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil.1.1
 * JD-Core Version:    0.7.0.1
 */