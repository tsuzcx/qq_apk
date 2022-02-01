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
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = ((MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131365448, HardCodeUtil.a(2131706675), 2130839050);
      paramAdapterView.a(2131367398, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramAdapterView, MessageSearchDialog.a(this.a), new MessageSearchDialog.8.1(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */