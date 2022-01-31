package com.tencent.mobileqq.activity;

import aclv;
import android.app.Activity;
import android.content.res.Resources;
import bdcd;
import bdfq;

public class ChatSettingForTroop$52
  implements Runnable
{
  ChatSettingForTroop$52(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131721024));
      aclv localaclv = new aclv(this);
      this.this$0.a.setPositiveButton(2131691088, localaclv);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.52
 * JD-Core Version:    0.7.0.1
 */