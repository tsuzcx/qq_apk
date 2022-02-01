package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CMessageSearchDialog$4
  implements View.OnClickListener
{
  C2CMessageSearchDialog$4(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null)
      {
        ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem.a.msg);
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("forward_type", -1);
          localBundle.putString("forward_text", this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem.a.msg);
          Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          localIntent.putExtras(localBundle);
          ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 21);
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "OnClickListener, setMessageItems");
          }
          this.a.c = false;
          C2CMessageSearchDialog.a(this.a).setVisibility(8);
          C2CMessageSearchDialog.a(this.a, 0, null);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(C2CMessageSearchDialog.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
          this.a.b = 1;
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Clk_cloudtips", 0, 0, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */