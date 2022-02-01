package com.tencent.mobileqq.activity.history;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ChatHistoryTroopDateFragment$1
  implements Runnable
{
  ChatHistoryTroopDateFragment$1(ChatHistoryTroopDateFragment paramChatHistoryTroopDateFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    int n = CalendarDay.getDaysInMonth(this.a, this.b);
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int m = 0;
    int k;
    for (int i = 0; j <= n; i = k)
    {
      MessageRecord localMessageRecord = ChatHistoryTroopDateFragment.a(this.this$0, this.a, this.b, j);
      m += 1;
      k = i;
      if (localMessageRecord != null)
      {
        k = i + 1;
        localArrayList.add(localMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        String str = ChatHistoryTroopDateFragment.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFirstMessageByDate: ");
        localStringBuilder.append(ChatHistoryTroopDateFragment.b(this.this$0, this.a, this.b + 1, j));
        localStringBuilder.append(" | result: ");
        localStringBuilder.append(localMessageRecord);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      j += 1;
    }
    if (localArrayList.size() > 0) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopDateFragment.1.1(this, localArrayList));
    }
    l = SystemClock.elapsedRealtime() - l;
    TroopTechReportUtils.a("chat_history", "query_month_cost", String.valueOf(l), String.valueOf(m), String.valueOf(i), "");
    if (QLog.isColorLevel()) {
      QLog.i(ChatHistoryTroopDateFragment.a(), 2, String.format("queryDB count: %d | message count: %d | cost time %d ", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(l) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment.1
 * JD-Core Version:    0.7.0.1
 */