package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryTroopMemberFragment$28
  extends TroopGiftCallback
{
  ChatHistoryTroopMemberFragment$28(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList error");
    }
    ChatHistoryTroopMemberFragment.a(this.a, true);
    if (ChatHistoryTroopMemberFragment.k(this.a))
    {
      paramString = this.a.bn.obtainMessage(12, null);
      this.a.bn.sendMessage(paramString);
    }
  }
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onGetGiftMemberList");
    }
    ChatHistoryTroopMemberFragment.a(this.a, paramArrayOfLong1);
    ChatHistoryTroopMemberFragment.b(this.a, paramArrayOfLong2);
    ChatHistoryTroopMemberFragment.c(this.a, paramArrayOfLong3);
    ChatHistoryTroopMemberFragment.a(this.a, true);
    if (ChatHistoryTroopMemberFragment.k(this.a))
    {
      paramArrayOfLong1 = this.a.bn.obtainMessage(12, null);
      this.a.bn.sendMessage(paramArrayOfLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.28
 * JD-Core Version:    0.7.0.1
 */