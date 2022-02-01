package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ChatSettingForTroop$58
  implements Runnable
{
  ChatSettingForTroop$58(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131720180));
      ChatSettingForTroop.58.1 local1 = new ChatSettingForTroop.58.1(this);
      this.this$0.a.setPositiveButton(2131691144, local1);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.58
 * JD-Core Version:    0.7.0.1
 */