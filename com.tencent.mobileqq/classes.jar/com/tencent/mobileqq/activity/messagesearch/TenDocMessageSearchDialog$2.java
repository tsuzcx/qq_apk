package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.view.View;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class TenDocMessageSearchDialog$2
  implements AdapterView.OnItemClickListener
{
  TenDocMessageSearchDialog$2(TenDocMessageSearchDialog paramTenDocMessageSearchDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("TenDocMessageSearchDialog", 2, paramAdapterView.toString());
    }
    if (TenDocMessageSearchDialog.a(this.a).getCount() > 0)
    {
      if (paramInt <= 0) {
        return;
      }
      paramAdapterView = (MessageItem)TenDocMessageSearchDialog.a(this.a).getItem(paramInt - 1);
      if ((paramAdapterView != null) && (paramAdapterView.b != null))
      {
        paramAdapterView = paramAdapterView.b;
        paramView = new StringBuilder();
        paramView.append("jump to mr: ");
        paramView.append(paramAdapterView.msgseq);
        paramView.append(" ");
        paramView.append(paramAdapterView.shmsgseq);
        QLog.d("TenDocMessageSearchDialog", 4, paramView.toString());
        if (UinTypeUtil.h(this.a.g.a)) {
          ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.c, this.a.g.b, paramAdapterView.shmsgseq, 0, 2);
        } else {
          ChatHistoryActivity.a((Activity)this.a.c, this.a.g.b, this.a.g.a, this.a.g.w, paramAdapterView.time, paramAdapterView.shmsgseq, 0);
        }
        ReportController.b(this.a.f, "dc00898", "", "", "0X800A175", "0X800A175", TenDocMessageSearchDialog.b(this.a), 0, "", "", "s_qq_history_tab", "");
        this.a.a(true);
        return;
      }
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("null item: ");
      paramAdapterView.append(paramInt);
      QLog.e("TenDocMessageSearchDialog", 2, paramAdapterView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog.2
 * JD-Core Version:    0.7.0.1
 */