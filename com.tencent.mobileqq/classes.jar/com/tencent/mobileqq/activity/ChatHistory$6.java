package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;

class ChatHistory$6
  implements DialogInterface.OnDismissListener
{
  ChatHistory$6(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.offsetTopAndBottom(-this.b);
    this.c.setVisibility(0);
    this.a.startAnimation(this.d);
    paramDialogInterface = (MessageSearchDialog)paramDialogInterface;
    int i = paramDialogInterface.c();
    boolean bool = paramDialogInterface.f();
    ChatHistory.a(this.e, i);
    if (bool)
    {
      this.e.leftView.setText(this.e.getString(2131887625));
      return;
    }
    paramDialogInterface = this.e.getIntent().getExtras().getString("leftViewText");
    this.e.leftView.setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.6
 * JD-Core Version:    0.7.0.1
 */