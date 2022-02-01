package com.tencent.mobileqq.activity;

import aedq;
import android.os.Message;
import asui;
import blhq;

public class ChatHistoryEmotionView$3
  implements Runnable
{
  public ChatHistoryEmotionView$3(aedq paramaedq) {}
  
  public void run()
  {
    Object localObject = aedq.a(this.this$0).a(aedq.a(this.this$0), aedq.a(this.this$0), false);
    localObject = aedq.a(this.this$0).obtainMessage(1, localObject);
    ((Message)localObject).arg1 = 1;
    aedq.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
 * JD-Core Version:    0.7.0.1
 */