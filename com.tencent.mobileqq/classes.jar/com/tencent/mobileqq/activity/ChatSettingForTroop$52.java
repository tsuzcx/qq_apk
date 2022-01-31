package com.tencent.mobileqq.activity;

import aalj;
import android.app.Activity;
import android.content.res.Resources;
import babr;
import bafb;

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
      this.this$0.a = babr.a(this.this$0, 230);
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131654578));
      aalj localaalj = new aalj(this);
      this.this$0.a.setPositiveButton(2131625463, localaalj);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.52
 * JD-Core Version:    0.7.0.1
 */