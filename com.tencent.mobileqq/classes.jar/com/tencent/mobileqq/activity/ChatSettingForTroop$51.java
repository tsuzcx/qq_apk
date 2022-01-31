package com.tencent.mobileqq.activity;

import aauw;
import bbdj;
import bbgu;

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
      this.this$0.a = bbdj.a(this.this$0, 230);
      this.this$0.a.setMessage(this.a);
      aauw localaauw = new aauw(this);
      this.this$0.a.setPositiveButton(2131691035, localaauw);
      this.this$0.a.setNegativeButton(2131690596, localaauw);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */