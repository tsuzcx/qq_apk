package com.tencent.mobileqq.activity;

import acne;
import android.os.Message;
import aqag;
import bhtd;

public class ChatHistoryEmotionView$3
  implements Runnable
{
  public ChatHistoryEmotionView$3(acne paramacne) {}
  
  public void run()
  {
    Object localObject = acne.a(this.this$0).a(acne.a(this.this$0), acne.a(this.this$0), false);
    localObject = acne.a(this.this$0).obtainMessage(1, localObject);
    ((Message)localObject).arg1 = 1;
    acne.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView.3
 * JD-Core Version:    0.7.0.1
 */