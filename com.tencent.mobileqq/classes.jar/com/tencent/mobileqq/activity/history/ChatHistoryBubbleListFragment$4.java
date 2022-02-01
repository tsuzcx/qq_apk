package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$4
  implements Runnable
{
  ChatHistoryBubbleListFragment$4(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a == 1) {
      localObject = this.this$0.c;
    } else {
      localObject = this.this$0.b;
    }
    Object localObject = this.this$0.f.getMessageFacade().a((String)localObject, this.this$0.a, this.this$0.g, 20);
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.4.1(this, (List)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.4
 * JD-Core Version:    0.7.0.1
 */