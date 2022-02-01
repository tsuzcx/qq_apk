package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;

class ChatHistoryTroopMemberFragment$43
  extends TroopSettingObserver
{
  ChatHistoryTroopMemberFragment$43(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.w.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new ChatHistoryTroopMemberFragment.43.1(this, paramString2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.43
 * JD-Core Version:    0.7.0.1
 */