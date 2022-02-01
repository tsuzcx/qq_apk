package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatSettingForTroop$41
  implements View.OnClickListener
{
  ChatSettingForTroop$41(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "setTroopUinTextViewClickListener onClick");
    }
    ChatSettingForTroop.p(this.a);
    TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_click", 0, 0, new String[] { this.a.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.41
 * JD-Core Version:    0.7.0.1
 */