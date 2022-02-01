package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnSubRegionClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PgcProteusItem$4
  implements View.OnClickListener
{
  PgcProteusItem$4(PgcProteusItem paramPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    OnSubRegionClickListener localOnSubRegionClickListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(paramView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcProteusItem.4
 * JD-Core Version:    0.7.0.1
 */