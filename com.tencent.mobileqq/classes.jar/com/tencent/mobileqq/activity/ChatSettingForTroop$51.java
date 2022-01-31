package com.tencent.mobileqq.activity;

import aclu;
import bdcd;
import bdfq;

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
      this.this$0.a = bdcd.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      aclu localaclu = new aclu(this);
      this.this$0.a.setPositiveButton(2131691088, localaclu);
      this.this$0.a.setNegativeButton(2131690648, localaclu);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */