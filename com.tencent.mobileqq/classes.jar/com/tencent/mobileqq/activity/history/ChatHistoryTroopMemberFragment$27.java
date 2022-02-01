package com.tencent.mobileqq.activity.history;

import android.os.Handler;

class ChatHistoryTroopMemberFragment$27
  implements Runnable
{
  ChatHistoryTroopMemberFragment$27(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void run()
  {
    if ((this.this$0.az == 1) || (this.this$0.az == 11) || (this.this$0.az == 16))
    {
      Object localObject = this.this$0;
      localObject = ((ChatHistoryTroopMemberFragment)localObject).f(((ChatHistoryTroopMemberFragment)localObject).w);
      this.this$0.bn.sendMessage(this.this$0.bn.obtainMessage(1, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.27
 * JD-Core Version:    0.7.0.1
 */