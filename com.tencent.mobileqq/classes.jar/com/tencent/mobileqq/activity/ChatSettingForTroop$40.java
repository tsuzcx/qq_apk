package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$40
  implements Runnable
{
  ChatSettingForTroop$40(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null) {
      localTroopManager.a(this.this$0.a.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.40
 * JD-Core Version:    0.7.0.1
 */