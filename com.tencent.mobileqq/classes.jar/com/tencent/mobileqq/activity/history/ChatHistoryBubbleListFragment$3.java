package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryBubbleListFragment$3
  implements Runnable
{
  ChatHistoryBubbleListFragment$3(ChatHistoryBubbleListFragment paramChatHistoryBubbleListFragment, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a == 1) {
      localObject = this.this$0.c;
    } else {
      localObject = this.this$0.b;
    }
    Object localObject = this.this$0.f.getMessageFacade().b((String)localObject, this.this$0.a, this.this$0.h, 20);
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryBubbleListFragment.3.1(this, (List)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment.3
 * JD-Core Version:    0.7.0.1
 */