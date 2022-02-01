package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$13
  implements View.OnClickListener
{
  TroopMemberListActivity$13(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c = false;
    this.a.t = "";
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.d != 22) {
      this.a.b.setVisibility(0);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.13
 * JD-Core Version:    0.7.0.1
 */