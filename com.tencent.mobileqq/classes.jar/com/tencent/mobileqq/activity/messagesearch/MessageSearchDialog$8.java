package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView;

class MessageSearchDialog$8
  implements AdapterView.OnItemLongClickListener
{
  MessageSearchDialog$8(MessageSearchDialog paramMessageSearchDialog) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramAdapterView = MessageSearchDialog.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLongClick, position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i(paramAdapterView, 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter)
    {
      paramAdapterView = this.a;
      paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = ((MessageItem)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131365311, HardCodeUtil.a(2131706697), 2130838903);
      paramAdapterView.a(2131367180, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
      localObject = this.a;
      ((MessageSearchDialog)localObject).jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramAdapterView, MessageSearchDialog.a((MessageSearchDialog)localObject), new MessageSearchDialog.8.1(this, paramView));
      return true;
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */