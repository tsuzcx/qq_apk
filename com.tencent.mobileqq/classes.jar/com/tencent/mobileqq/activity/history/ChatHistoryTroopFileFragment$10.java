package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class ChatHistoryTroopFileFragment$10
  implements Runnable
{
  ChatHistoryTroopFileFragment$10(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void run()
  {
    if (this.this$0.getBaseActivity() != null)
    {
      if (this.this$0.getBaseActivity().isFinishing()) {
        return;
      }
      ChatHistoryTroopFileFragment.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.10
 * JD-Core Version:    0.7.0.1
 */