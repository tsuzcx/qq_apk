package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$46
  implements Runnable
{
  ChatSettingForTroop$46(ChatSettingForTroop paramChatSettingForTroop, TroopManager paramTroopManager) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.a.b(this.this$0.a.troopUin, this.this$0.app.getCurrentAccountUin());
    if (localTroopMemberInfo != null)
    {
      this.this$0.a.troopColorNick = localTroopMemberInfo.troopColorNick;
      this.this$0.a.troopColorNickId = localTroopMemberInfo.troopColorNickId;
      this.this$0.a.troopCard = localTroopMemberInfo.troopnick;
      this.this$0.runOnUiThread(new ChatSettingForTroop.46.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.46
 * JD-Core Version:    0.7.0.1
 */