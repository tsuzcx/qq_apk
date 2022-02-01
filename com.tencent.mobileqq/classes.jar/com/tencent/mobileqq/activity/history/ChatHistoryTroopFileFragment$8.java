package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BaseActivity;

class ChatHistoryTroopFileFragment$8
  implements Runnable
{
  ChatHistoryTroopFileFragment$8(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (this.this$0.getBaseActivity() != null)
    {
      if (this.this$0.getBaseActivity().isFinishing()) {
        return;
      }
      ChatHistoryTroopFileFragment.a(this.this$0, this.a);
      ChatHistoryTroopFileFragment.b(this.this$0, this.b);
      ChatHistoryTroopFileFragment.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.8
 * JD-Core Version:    0.7.0.1
 */