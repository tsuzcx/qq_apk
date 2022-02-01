package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$1
  implements Runnable
{
  ChatHistoryBubbleListFragment$1(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment) {}
  
  public void run()
  {
    if (this.this$0.a == 1) {
      localObject = this.this$0.c;
    } else {
      localObject = this.this$0.b;
    }
    Object localObject = this.this$0.f.getMessageFacade().a((String)localObject, this.this$0.a, 9223372036854775807L, 20);
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.1.1(this, (List)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.1
 * JD-Core Version:    0.7.0.1
 */