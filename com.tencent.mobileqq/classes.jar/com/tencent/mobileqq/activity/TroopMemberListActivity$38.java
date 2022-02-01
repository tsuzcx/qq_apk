package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopMemberListActivity$38
  implements View.OnClickListener
{
  TroopMemberListActivity$38(TroopMemberListActivity paramTroopMemberListActivity, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberMngHandlerName());
    if (localObject != null)
    {
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mTroopUin), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mMyTroopRole;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mTroopUin, str, (String)localObject, "");
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.constructProgressDialog();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.mProgressDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.38
 * JD-Core Version:    0.7.0.1
 */