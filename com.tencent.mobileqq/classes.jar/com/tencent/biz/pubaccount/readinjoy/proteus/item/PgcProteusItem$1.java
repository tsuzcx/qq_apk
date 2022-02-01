package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PgcProteusItem$1
  implements View.OnClickListener
{
  PgcProteusItem$1(PgcProteusItem paramPgcProteusItem, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PgcProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PgcProteusItem", 2, "click bottom bar for jumping to gallery articleinfo = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() + " position = " + this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem.1
 * JD-Core Version:    0.7.0.1
 */