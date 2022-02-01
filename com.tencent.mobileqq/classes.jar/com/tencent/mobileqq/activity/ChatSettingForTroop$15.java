package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatSettingForTroop$15
  implements ActionSheet.OnButtonClickListener
{
  ChatSettingForTroop$15(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
    }
    paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if ((NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getApp().getApplicationContext())) && (paramView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131692166, 0);
      paramView.j(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (paramView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694510, 1500);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692165, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.15
 * JD-Core Version:    0.7.0.1
 */