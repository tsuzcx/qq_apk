package com.tencent.mobileqq.activity;

import acip;
import android.os.Message;
import apvx;
import bhow;

public class ChatHistoryEmotionView$1
  implements Runnable
{
  public ChatHistoryEmotionView$1(acip paramacip) {}
  
  public void run()
  {
    Object localObject = acip.a(this.this$0).a(acip.a(this.this$0), acip.a(this.this$0), false);
    localObject = acip.a(this.this$0).obtainMessage(1, localObject);
    acip.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.1
 * JD-Core Version:    0.7.0.1
 */