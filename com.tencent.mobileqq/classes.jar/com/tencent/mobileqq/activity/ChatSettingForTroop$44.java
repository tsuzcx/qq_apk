package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ChatSettingForTroop$44
  implements View.OnClickListener
{
  ChatSettingForTroop$44(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_actionsheet_click cancel", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.44
 * JD-Core Version:    0.7.0.1
 */