package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.app.BizTroopObserver;

class ChatHistoryTroopAllFragment$7
  extends BizTroopObserver
{
  ChatHistoryTroopAllFragment$7(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment) {}
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.7
 * JD-Core Version:    0.7.0.1
 */