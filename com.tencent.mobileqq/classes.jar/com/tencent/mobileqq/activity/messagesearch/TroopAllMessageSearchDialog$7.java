package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class TroopAllMessageSearchDialog$7
  implements AdapterView.OnItemClickListener
{
  TroopAllMessageSearchDialog$7(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog) {}
  
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
        paramView = new StringBuilder();
        paramView.append("onItemClick, mRecordCount = ");
        paramView.append(this.a.k);
        paramView.append(",needSearchInCloud:");
        paramView.append(this.a.m);
        QLog.i("LinkMessageSearchDialog", 2, paramView.toString());
      }
      paramView = this.a.g.b;
      ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.c, paramView, paramAdapterView.b.shmsgseq, -1, 2);
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */