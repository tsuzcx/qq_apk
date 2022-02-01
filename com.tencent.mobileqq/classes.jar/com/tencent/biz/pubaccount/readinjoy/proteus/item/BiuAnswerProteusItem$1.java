package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BiuAnswerProteusItem$1
  implements View.OnClickListener
{
  BiuAnswerProteusItem$1(BiuAnswerProteusItem paramBiuAnswerProteusItem, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(View paramView)
  {
    RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), 0, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BiuAnswerProteusItem.1
 * JD-Core Version:    0.7.0.1
 */