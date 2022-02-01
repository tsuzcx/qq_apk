package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ChatSettingForTroop$57
  implements Runnable
{
  ChatSettingForTroop$57(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
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
      this.this$0.a = DialogUtil.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      ChatSettingForTroop.57.1 local1 = new ChatSettingForTroop.57.1(this);
      this.this$0.a.setPositiveButton(2131691144, local1);
      this.this$0.a.setNegativeButton(2131690800, local1);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.57
 * JD-Core Version:    0.7.0.1
 */