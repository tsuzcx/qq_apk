package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import java.util.List;

class ChatHistoryTroopMemberFragment$43$1$1
  implements Runnable
{
  ChatHistoryTroopMemberFragment$43$1$1(ChatHistoryTroopMemberFragment.43.1 param1, ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember) {}
  
  public void run()
  {
    this.b.b.a.d(this.b.a);
    synchronized (this.b.b.a.getActivity())
    {
      this.b.b.a.J.add(this.a);
      this.b.b.a.bn.sendEmptyMessage(9);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.43.1.1
 * JD-Core Version:    0.7.0.1
 */