package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

class MessageSearchDialog$7
  implements AdapterView.OnItemClickListener
{
  MessageSearchDialog$7(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = MessageSearchDialog.m;
      paramView = new StringBuilder();
      paramView.append("onItemClick, position = ");
      paramView.append(paramInt);
      QLog.i(paramAdapterView, 2, paramView.toString());
    }
    paramAdapterView = this.a.b.getAdapter();
    if (paramAdapterView == this.a.n)
    {
      paramAdapterView = (MessageItem)this.a.n.getItem(paramInt);
      this.a.l = paramAdapterView.b;
      paramView = this.a;
      paramView.k = paramView.f.getMessageFacade().c(this.a.g.b, this.a.g.a, paramAdapterView.b);
      if (QLog.isColorLevel())
      {
        paramAdapterView = MessageSearchDialog.m;
        paramView = new StringBuilder();
        paramView.append("onItemClick, mRecordCount = ");
        paramView.append(this.a.k);
        QLog.i(paramAdapterView, 2, paramView.toString());
      }
      this.a.a(true);
      this.a.dismiss();
      return;
    }
    if (paramAdapterView == this.a.o)
    {
      paramAdapterView = (HistoryItem)this.a.o.getItem(paramInt);
      paramView = this.a;
      paramView.q = false;
      paramView.d.setText(paramAdapterView.a);
      this.a.d.setSelection(paramAdapterView.a.length());
      this.a.d.requestFocus();
      ((InputMethodManager)this.a.d.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.m, 2, "onItemClick, unknown data type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */