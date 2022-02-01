package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class C2CMessageSearchDialog$8
  implements AdapterView.OnItemLongClickListener
{
  C2CMessageSearchDialog$8(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new QQCustomMenu();
    paramAdapterView.a(2131365448, HardCodeUtil.a(2131701360), 2130839050);
    paramAdapterView.a(2131367398, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramAdapterView, C2CMessageSearchDialog.a(this.a), new C2CMessageSearchDialog.8.1(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */