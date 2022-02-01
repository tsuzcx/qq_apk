package com.tencent.mobileqq.activity;

import adtb;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ChatSettingForTroop$62
  implements Runnable
{
  ChatSettingForTroop$62(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
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
      this.this$0.a = bhdj.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      adtb localadtb = new adtb(this);
      this.this$0.a.setPositiveButton(2131691037, localadtb);
      this.this$0.a.setNegativeButton(2131690697, localadtb);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.62
 * JD-Core Version:    0.7.0.1
 */