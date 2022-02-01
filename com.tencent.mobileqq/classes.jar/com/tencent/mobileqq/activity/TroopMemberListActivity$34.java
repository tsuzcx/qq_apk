package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$34
  implements View.OnClickListener
{
  TroopMemberListActivity$34(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    localObject = paramView.findViewById(2131380459);
    if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)((View)localObject).getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        localObject = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.getItem(i);
        this.a.a((TroopMemberListActivity.ATroopMember)localObject);
        if ((this.a.jdField_b_of_type_AndroidAppDialog != null) && (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_b_of_type_AndroidAppDialog.dismiss();
        }
        if (this.a.d != 11) {
          break;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        break;
      }
      localObject = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.getItem(i);
      this.a.a((TroopMemberListActivity.ATroopMember)localObject);
      if (this.a.d == 11) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.a.d != 18) {
        break;
      }
      ReportController.b(this.a.app, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.jdField_b_of_type_JavaLangString, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.34
 * JD-Core Version:    0.7.0.1
 */