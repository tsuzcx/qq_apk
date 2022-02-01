package com.tencent.mobileqq.activity;

import acyr;
import android.os.Message;
import argi;
import bjng;

public class ChatHistoryEmotionView$3
  implements Runnable
{
  public ChatHistoryEmotionView$3(acyr paramacyr) {}
  
  public void run()
  {
    Object localObject = acyr.a(this.this$0).a(acyr.a(this.this$0), acyr.a(this.this$0), false);
    localObject = acyr.a(this.this$0).obtainMessage(1, localObject);
    ((Message)localObject).arg1 = 1;
    acyr.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
 * JD-Core Version:    0.7.0.1
 */