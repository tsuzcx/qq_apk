package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class C2CMessageSearchDialog$7
  implements AdapterView.OnItemClickListener
{
  C2CMessageSearchDialog$7(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("C2CMessageSearchDialog", 2, paramAdapterView.toString());
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
        QLog.i("C2CMessageSearchDialog", 2, paramAdapterView.toString());
      }
      ChatHistoryActivity.a((Activity)this.a.c, this.a.g.b, this.a.g.a, this.a.g.w, this.a.l.time, this.a.l.shmsgseq, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */