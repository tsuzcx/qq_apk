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
    if (this.a.o.getCount() > 0)
    {
      if (paramInt <= 0) {
        return true;
      }
      paramAdapterView = (MessageItem)this.a.o.getItem(paramInt - 1);
      if (paramAdapterView == null) {
        return true;
      }
      this.a.j = paramAdapterView;
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131431492, HardCodeUtil.a(2131912459), 2130839057);
      paramAdapterView.a(2131433636, this.a.c.getString(2131889668), 2130839066);
      TroopAllMessageSearchDialog localTroopAllMessageSearchDialog = this.a;
      localTroopAllMessageSearchDialog.i = BubbleContextMenu.a(paramView, paramAdapterView, TroopAllMessageSearchDialog.c(localTroopAllMessageSearchDialog), new TroopAllMessageSearchDialog.8.1(this, paramView));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */