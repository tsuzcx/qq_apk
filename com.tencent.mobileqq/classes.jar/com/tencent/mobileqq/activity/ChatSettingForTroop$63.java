package com.tencent.mobileqq.activity;

import adtc;
import android.app.Activity;
import android.content.res.Resources;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ChatSettingForTroop$63
  implements Runnable
{
  ChatSettingForTroop$63(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131719602));
      adtc localadtc = new adtc(this);
      this.this$0.a.setPositiveButton(2131691037, localadtc);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.63
 * JD-Core Version:    0.7.0.1
 */