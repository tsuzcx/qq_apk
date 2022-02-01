package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$61
  implements Runnable
{
  ChatSettingForTroop$61(ChatSettingForTroop paramChatSettingForTroop, TroopManager paramTroopManager) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.a.b(this.this$0.a.troopUin, this.this$0.app.getCurrentAccountUin());
    this.this$0.a(localTroopMemberInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.61
 * JD-Core Version:    0.7.0.1
 */