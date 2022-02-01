package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

class TroopInfoActivity$28
  implements View.OnClickListener
{
  TroopInfoActivity$28(TroopInfoActivity paramTroopInfoActivity, XListView paramXListView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.b = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.28
 * JD-Core Version:    0.7.0.1
 */