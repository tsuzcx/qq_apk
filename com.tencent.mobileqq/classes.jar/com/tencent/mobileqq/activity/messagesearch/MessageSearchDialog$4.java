package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MessageSearchDialog$4
  implements View.OnClickListener
{
  MessageSearchDialog$4(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = MessageSearchDialog.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick, id = ");
      ((StringBuilder)localObject2).append(i);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.a.j;
    if (this.a.j != null) {
      if (i != 2131431492)
      {
        if (i == 2131433636)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("forward_type", -1);
          ((Bundle)localObject1).putString("forward_text", ((MessageItem)localObject2).b.msg);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ForwardBaseOption.a((Activity)this.a.c, (Intent)localObject2, 21);
        }
      }
      else {
        ((ClipboardManager)this.a.c.getSystemService("clipboard")).setText(((MessageItem)localObject2).b.msg);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */