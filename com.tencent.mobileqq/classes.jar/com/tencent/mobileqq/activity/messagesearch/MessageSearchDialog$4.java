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
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (i)
      {
      default: 
        break;
      case 2131365448: 
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((MessageItem)localObject).a.msg);
        break;
      case 2131367398: 
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", -1);
        localBundle.putString("forward_text", ((MessageItem)localObject).a.msg);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        ForwardBaseOption.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */