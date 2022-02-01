package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LinkMessageSearchDialog$4
  implements View.OnClickListener
{
  LinkMessageSearchDialog$4(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick, id = ");
      ((StringBuilder)localObject1).append(i);
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2;
    switch (i)
    {
    default: 
      break;
    case 2131377047: 
    case 2131377048: 
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      localObject1 = this.a;
      ((LinkMessageSearchDialog)localObject1).c = false;
      LinkMessageSearchDialog.a((LinkMessageSearchDialog)localObject1).setVisibility(8);
      LinkMessageSearchDialog.a(this.a, 0, null);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchLinkMessageResultAdapter.a(LinkMessageSearchDialog.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchLinkMessageResultAdapter.notifyDataSetChanged();
      this.a.b = 1;
      break;
    case 2131367180: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null)
      {
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem.a;
        if ((localObject2 instanceof MessageForText)) {
          localObject2 = (MessageForText)localObject2;
        }
      }
      break;
    }
    try
    {
      localObject2 = GroupUtil.a(((MessageForText)localObject2).msgData);
      if (localObject2 != null) {
        localObject1 = (TroopLinkElement)localObject2;
      }
      localObject2 = new Bundle();
      if (localObject1 != null)
      {
        ((Bundle)localObject2).putString("image_url_remote", ((TroopLinkElement)localObject1).url);
        ((Bundle)localObject2).putString("detail_url", ((TroopLinkElement)localObject1).iconUrl);
        ((Bundle)localObject2).putString("title", ((TroopLinkElement)localObject1).title);
        ((Bundle)localObject2).putString("desc", ((TroopLinkElement)localObject1).title);
        ((Bundle)localObject2).putString("req_create_time", ((TroopLinkElement)localObject1).timeSecond);
      }
      localObject1 = StructMsgFactory.a((Bundle)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject1).getBytes());
      ForwardBaseOption.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, 21);
    }
    catch (Exception localException)
    {
      break label415;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem != null) {
      ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem.a.msg);
    }
    label415:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.4
 * JD-Core Version:    0.7.0.1
 */