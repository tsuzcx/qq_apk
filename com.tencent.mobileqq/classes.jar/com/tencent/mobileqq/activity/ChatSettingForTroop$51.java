package com.tencent.mobileqq.activity;

import aali;
import babr;
import bafb;

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
      this.this$0.a = babr.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      aali localaali = new aali(this);
      this.this$0.a.setPositiveButton(2131625463, localaali);
      this.this$0.a.setNegativeButton(2131625035, localaali);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */