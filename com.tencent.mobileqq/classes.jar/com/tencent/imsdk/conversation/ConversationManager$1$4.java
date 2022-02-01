package com.tencent.imsdk.conversation;

import java.util.List;

class ConversationManager$1$4
  implements Runnable
{
  ConversationManager$1$4(ConversationManager.1 param1, List paramList) {}
  
  public void run()
  {
    if (ConversationManager.access$100(this.this$1.this$0) != null) {
      ConversationManager.access$100(this.this$1.this$0).onNewConversation(this.val$conversationList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationManager.1.4
 * JD-Core Version:    0.7.0.1
 */