package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.model.QueryTask.Query;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.vas.troopkeyword.EntryStatus;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;

class ChatSettingForTroop$10
  implements QueryTask.Query<Void, EntryStatus>
{
  ChatSettingForTroop$10(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public EntryStatus a(Void paramVoid)
  {
    return TroopKeywordManager.a(this.a.app).a(this.a.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.10
 * JD-Core Version:    0.7.0.1
 */