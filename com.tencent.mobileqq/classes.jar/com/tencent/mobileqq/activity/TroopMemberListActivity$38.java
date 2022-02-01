package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopMemberListActivity$38
  implements View.OnClickListener
{
  TroopMemberListActivity$38(TroopMemberListActivity paramTroopMemberListActivity, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    String str;
    if (localObject != null)
    {
      ((TroopHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
      str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label153;
      }
    }
    label153:
    for (localObject = "0";; localObject = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, str, (String)localObject, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidAppDialog.show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.38
 * JD-Core Version:    0.7.0.1
 */