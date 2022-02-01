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
      paramAdapterView = MessageSearchDialog.m;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLongClick, position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i(paramAdapterView, 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.b.getAdapter() == this.a.n)
    {
      paramAdapterView = this.a;
      paramAdapterView.j = ((MessageItem)paramAdapterView.n.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131431492, HardCodeUtil.a(2131904548), 2130839057);
      paramAdapterView.a(2131433636, this.a.c.getString(2131889668), 2130839066);
      localObject = this.a;
      ((MessageSearchDialog)localObject).i = BubbleContextMenu.a(paramView, paramAdapterView, MessageSearchDialog.b((MessageSearchDialog)localObject), new MessageSearchDialog.8.1(this, paramView));
      return true;
    }
    paramAdapterView = this.a.o;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */