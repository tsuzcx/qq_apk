package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

class ChatHistoryC2CFileFragment$1
  implements Runnable
{
  ChatHistoryC2CFileFragment$1(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {}
    for (LinkedHashMap localLinkedHashMap = ChatHistoryC2CFileFragment.a(this.this$0);; localLinkedHashMap = ChatHistoryC2CFileFragment.b(this.this$0))
    {
      ThreadManager.getUIHandler().post(new ChatHistoryC2CFileFragment.1.1(this, localLinkedHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.1
 * JD-Core Version:    0.7.0.1
 */