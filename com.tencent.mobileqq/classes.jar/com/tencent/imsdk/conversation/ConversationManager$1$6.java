package com.tencent.imsdk.conversation;

class ConversationManager$1$6
  implements Runnable
{
  ConversationManager$1$6(ConversationManager.1 param1, long paramLong) {}
  
  public void run()
  {
    if (ConversationManager.access$100(this.this$1.this$0) != null) {
      ConversationManager.access$100(this.this$1.this$0).onTotalUnreadMessageCountChanged(this.val$totalUnreadCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationManager.1.6
 * JD-Core Version:    0.7.0.1
 */