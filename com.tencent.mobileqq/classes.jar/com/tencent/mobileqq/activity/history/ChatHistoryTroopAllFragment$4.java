package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryTroopAllFragment$4
  implements Runnable
{
  ChatHistoryTroopAllFragment$4(ChatHistoryTroopAllFragment paramChatHistoryTroopAllFragment, int paramInt) {}
  
  public void run()
  {
    List localList = this.this$0.v.getMessageFacade().b(this.this$0.s, 1, this.this$0.x, 20);
    if (localList != null) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopAllFragment.4.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment.4
 * JD-Core Version:    0.7.0.1
 */