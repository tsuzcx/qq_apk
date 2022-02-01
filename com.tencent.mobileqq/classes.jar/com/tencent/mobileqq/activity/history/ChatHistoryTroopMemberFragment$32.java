package com.tencent.mobileqq.activity.history;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;

class ChatHistoryTroopMemberFragment$32
  implements DialogInterface.OnDismissListener
{
  ChatHistoryTroopMemberFragment$32(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.bn.postDelayed(new ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.32
 * JD-Core Version:    0.7.0.1
 */