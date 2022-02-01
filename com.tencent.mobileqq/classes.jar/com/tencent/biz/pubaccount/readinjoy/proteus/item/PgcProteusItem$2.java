package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class PgcProteusItem$2
  implements ViewBase.OnClickListener
{
  PgcProteusItem$2(PgcProteusItem paramPgcProteusItem, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    PgcProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click gallery comment for jumping to gallery articleinfo = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() + " position = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem.2
 * JD-Core Version:    0.7.0.1
 */