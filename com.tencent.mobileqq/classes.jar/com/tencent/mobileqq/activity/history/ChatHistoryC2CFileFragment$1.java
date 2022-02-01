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
    LinkedHashMap localLinkedHashMap;
    if (this.a) {
      localLinkedHashMap = this.this$0.b();
    } else {
      localLinkedHashMap = this.this$0.a();
    }
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryC2CFileFragment.1.1(this, localLinkedHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.1
 * JD-Core Version:    0.7.0.1
 */