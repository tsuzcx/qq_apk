package com.tencent.mobileqq.activity.history;

import android.os.Handler;

class ChatHistoryTroopMemberFragment$27
  implements Runnable
{
  ChatHistoryTroopMemberFragment$27(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void run()
  {
    if ((this.this$0.d == 1) || (this.this$0.d == 11) || (this.this$0.d == 16))
    {
      Object localObject = this.this$0;
      localObject = ((ChatHistoryTroopMemberFragment)localObject).a(((ChatHistoryTroopMemberFragment)localObject).c);
      this.this$0.b.sendMessage(this.this$0.b.obtainMessage(1, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.27
 * JD-Core Version:    0.7.0.1
 */