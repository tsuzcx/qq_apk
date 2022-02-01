package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$21
  implements View.OnClickListener
{
  TroopMemberListActivity$21(TroopMemberListActivity paramTroopMemberListActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b);
    localIntent.putExtra("param_from", 15);
    localIntent.putExtra("param_seq_days", TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    localIntent.putExtra("param_seq_name", TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.startActivityForResult(localIntent, 4);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, "" + this.b, "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.21
 * JD-Core Version:    0.7.0.1
 */