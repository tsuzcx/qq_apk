package com.tencent.mobileqq.activity;

import aarr;
import android.os.Message;
import aodv;
import bfob;

public class ChatHistoryEmotionView$3
  implements Runnable
{
  public ChatHistoryEmotionView$3(aarr paramaarr) {}
  
  public void run()
  {
    Object localObject = aarr.a(this.this$0).a(aarr.a(this.this$0), aarr.a(this.this$0), false);
    localObject = aarr.a(this.this$0).obtainMessage(1, localObject);
    ((Message)localObject).arg1 = 1;
    aarr.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
 * JD-Core Version:    0.7.0.1
 */