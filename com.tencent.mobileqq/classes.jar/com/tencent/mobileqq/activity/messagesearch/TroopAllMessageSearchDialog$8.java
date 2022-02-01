package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class TroopAllMessageSearchDialog$8
  implements AdapterView.OnItemLongClickListener
{
  TroopAllMessageSearchDialog$8(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onLongClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("LinkMessageSearchDialog", 2, paramAdapterView.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.getCount() > 0)
    {
      if (paramInt <= 0) {
        return true;
      }
      paramAdapterView = (MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.getItem(paramInt - 1);
      if (paramAdapterView == null) {
        return true;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = paramAdapterView;
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131365311, HardCodeUtil.a(2131714963), 2130838903);
      paramAdapterView.a(2131367180, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
      TroopAllMessageSearchDialog localTroopAllMessageSearchDialog = this.a;
      localTroopAllMessageSearchDialog.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramAdapterView, TroopAllMessageSearchDialog.a(localTroopAllMessageSearchDialog), new TroopAllMessageSearchDialog.8.1(this, paramView));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */