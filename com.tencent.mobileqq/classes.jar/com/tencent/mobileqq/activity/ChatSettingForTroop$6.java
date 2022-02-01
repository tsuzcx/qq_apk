package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatSettingForTroop$6
  implements View.OnClickListener
{
  ChatSettingForTroop$6(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    TroopUtils.a(this.a, this.a.a, this.a.app);
    TroopReportor.a("Grp_set_new", "grpData_admin", "tipoff_click", 0, 0, new String[] { this.a.a.troopUin });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.6
 * JD-Core Version:    0.7.0.1
 */