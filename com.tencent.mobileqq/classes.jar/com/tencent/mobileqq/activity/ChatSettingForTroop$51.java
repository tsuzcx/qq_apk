package com.tencent.mobileqq.activity;

import aegx;
import bhlq;
import bhpc;

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
      this.this$0.a = bhlq.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      aegx localaegx = new aegx(this);
      this.this$0.a.setPositiveButton(2131690912, localaegx);
      this.this$0.a.setNegativeButton(2131690580, localaegx);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */