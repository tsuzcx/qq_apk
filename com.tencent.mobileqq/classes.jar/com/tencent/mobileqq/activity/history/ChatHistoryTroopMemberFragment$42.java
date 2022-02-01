package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;

class ChatHistoryTroopMemberFragment$42
  extends TroopRobotObserver
{
  ChatHistoryTroopMemberFragment$42(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (this.a.ai.troopuin != null))
    {
      if (!paramString1.equals(this.a.ai.troopuin)) {
        return;
      }
      this.a.d(paramString2);
      this.a.bn.sendMessage(this.a.bn.obtainMessage(9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.42
 * JD-Core Version:    0.7.0.1
 */