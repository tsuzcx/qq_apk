package com.tencent.mobileqq.activity;

import adby;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ChatSettingForTroop$51
  implements Runnable
{
  ChatSettingForTroop$51(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
    }
    do
    {
      return;
      this.this$0.a = bfur.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      adby localadby = new adby(this);
      this.this$0.a.setPositiveButton(2131690952, localadby);
      this.this$0.a.setNegativeButton(2131690620, localadby);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */