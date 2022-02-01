package com.tencent.mobileqq.activity;

import adpd;
import android.os.Message;
import asko;
import bkys;

public class ChatHistoryEmotionView$3
  implements Runnable
{
  public ChatHistoryEmotionView$3(adpd paramadpd) {}
  
  public void run()
  {
    Object localObject = adpd.a(this.this$0).a(adpd.a(this.this$0), adpd.a(this.this$0), false);
    localObject = adpd.a(this.this$0).obtainMessage(1, localObject);
    ((Message)localObject).arg1 = 1;
    adpd.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
 * JD-Core Version:    0.7.0.1
 */