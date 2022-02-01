package com.tencent.mobileqq.activity.messagesearch;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

class LinkMessageSearchDialog$8
  implements AdapterView.OnItemLongClickListener
{
  LinkMessageSearchDialog$8(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onLongClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("LinkMessageSearchDialog", 2, paramAdapterView.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.8
 * JD-Core Version:    0.7.0.1
 */