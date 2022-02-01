package com.tencent.mobileqq.activity;

import aduo;
import android.os.Message;
import aseu;
import bkgm;

public class ChatHistoryEmotionView$1
  implements Runnable
{
  public ChatHistoryEmotionView$1(aduo paramaduo) {}
  
  public void run()
  {
    Object localObject = aduo.a(this.this$0).a(aduo.a(this.this$0), aduo.a(this.this$0), false);
    localObject = aduo.a(this.this$0).obtainMessage(1, localObject);
    aduo.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.1
 * JD-Core Version:    0.7.0.1
 */