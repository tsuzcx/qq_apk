package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ChatHistoryTroopMemberFragment$39
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$39(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_MNG_HANDLER);
    if (localObject != null)
    {
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.o;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_JavaLangString, str, (String)localObject, "");
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.x();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_c_of_type_AndroidAppDialog.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.39
 * JD-Core Version:    0.7.0.1
 */