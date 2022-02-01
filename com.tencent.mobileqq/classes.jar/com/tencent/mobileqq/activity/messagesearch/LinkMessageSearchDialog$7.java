package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class LinkMessageSearchDialog$7
  implements AdapterView.OnItemClickListener
{
  LinkMessageSearchDialog$7(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("LinkMessageSearchDialog", 2, paramAdapterView.toString());
    }
    if (this.a.o.getCount() > 0)
    {
      if (paramInt <= 0) {
        return;
      }
      paramAdapterView = (MessageItem)this.a.o.getItem(paramInt - 1);
      if (paramAdapterView == null) {
        return;
      }
      this.a.l = paramAdapterView.b;
      if (QLog.isColorLevel())
      {
        paramAdapterView = new StringBuilder();
        paramAdapterView.append("onItemClick, mRecordCount = ");
        paramAdapterView.append(this.a.k);
        paramAdapterView.append(",needSearchInCloud:");
        paramAdapterView.append(this.a.m);
        QLog.i("LinkMessageSearchDialog", 2, paramAdapterView.toString());
      }
      paramView = null;
    }
    try
    {
      Object localObject = GroupUtil.a(this.a.l.msgData);
      paramAdapterView = paramView;
      if (localObject != null) {
        paramAdapterView = (TroopLinkElement)localObject;
      }
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        paramAdapterView = paramView;
      }
    }
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.a.c, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.url);
      this.a.c.startActivity(paramView);
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */