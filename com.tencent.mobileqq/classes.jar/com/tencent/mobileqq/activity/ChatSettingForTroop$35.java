package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$35
  implements Runnable
{
  ChatSettingForTroop$35(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
    if (localTroopManager != null) {
      localTroopManager.a(this.this$0.a.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.35
 * JD-Core Version:    0.7.0.1
 */