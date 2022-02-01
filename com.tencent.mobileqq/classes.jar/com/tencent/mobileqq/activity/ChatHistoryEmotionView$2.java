package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.emotionintegrate.EmotionDataManager;
import com.tencent.util.WeakReferenceHandler;

class ChatHistoryEmotionView$2
  implements Runnable
{
  ChatHistoryEmotionView$2(ChatHistoryEmotionView paramChatHistoryEmotionView) {}
  
  public void run()
  {
    Object localObject = ChatHistoryEmotionView.a(this.this$0).a(ChatHistoryEmotionView.a(this.this$0), ChatHistoryEmotionView.a(this.this$0), true);
    localObject = ChatHistoryEmotionView.a(this.this$0).obtainMessage(1, localObject);
    ChatHistoryEmotionView.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.2
 * JD-Core Version:    0.7.0.1
 */