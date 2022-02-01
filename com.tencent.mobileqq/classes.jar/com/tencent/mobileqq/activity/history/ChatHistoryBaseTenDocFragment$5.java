package com.tencent.mobileqq.activity.history;

import android.os.Message;
import mqq.os.MqqHandler;

class ChatHistoryBaseTenDocFragment$5
  implements Runnable
{
  ChatHistoryBaseTenDocFragment$5(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void run()
  {
    MqqHandler localMqqHandler = ChatHistoryBaseTenDocFragment.b(this.this$0);
    ChatHistoryBaseTenDocFragment localChatHistoryBaseTenDocFragment = this.this$0;
    localMqqHandler.obtainMessage(1234, ChatHistoryBaseTenDocFragment.a(localChatHistoryBaseTenDocFragment, ChatHistoryBaseTenDocFragment.g(localChatHistoryBaseTenDocFragment))).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.5
 * JD-Core Version:    0.7.0.1
 */