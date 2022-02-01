package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatSettingForTroop$7
  implements View.OnClickListener
{
  ChatSettingForTroop$7(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    ChatSettingForTroop.d(this.a);
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.7
 * JD-Core Version:    0.7.0.1
 */