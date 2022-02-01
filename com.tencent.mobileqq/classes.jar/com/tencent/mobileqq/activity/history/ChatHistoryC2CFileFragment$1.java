package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.LinkedHashMap;

class ChatHistoryC2CFileFragment$1
  implements Runnable
{
  ChatHistoryC2CFileFragment$1(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {}
    for (LinkedHashMap localLinkedHashMap = this.this$0.b();; localLinkedHashMap = this.this$0.a())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryC2CFileFragment.1.1(this, localLinkedHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.1
 * JD-Core Version:    0.7.0.1
 */