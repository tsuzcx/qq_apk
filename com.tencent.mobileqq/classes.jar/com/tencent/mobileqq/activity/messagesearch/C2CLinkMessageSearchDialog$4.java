package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class C2CLinkMessageSearchDialog$4
  implements View.OnClickListener
{
  C2CLinkMessageSearchDialog$4(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick, id = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 2131365311)
    {
      if ((i == 2131367180) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg;
        Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        localIntent.putExtra("forward_type", -3);
        localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        localIntent.putExtra("is_need_show_sources", false);
        ForwardBaseOption.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      }
    }
    else if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null) {
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem.a.msg);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */