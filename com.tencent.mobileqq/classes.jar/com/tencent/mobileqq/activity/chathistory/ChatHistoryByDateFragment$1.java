package com.tencent.mobileqq.activity.chathistory;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ChatHistoryByDateFragment$1
  implements Runnable
{
  ChatHistoryByDateFragment$1(ChatHistoryByDateFragment paramChatHistoryByDateFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    int i = 0;
    int m = CalendarDay.getDaysInMonth(this.a, this.b);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 1;
    MessageRecord localMessageRecord;
    if (k <= m)
    {
      localMessageRecord = ChatHistoryByDateFragment.a(this.this$0, this.a, this.b, k);
      if (localMessageRecord == null) {
        break label244;
      }
      i += 1;
      localArrayList.add(localMessageRecord);
    }
    label244:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatHistoryByDateFragment.a(), 2, "getFirstMessageByDate: " + ChatHistoryByDateFragment.a(this.this$0, this.a, this.b + 1, k) + " | result: " + localMessageRecord);
      }
      k += 1;
      j += 1;
      break;
      if (localArrayList.size() > 0) {
        ThreadManager.getUIHandler().post(new ChatHistoryByDateFragment.1.1(this, localArrayList));
      }
      l = SystemClock.elapsedRealtime() - l;
      TroopTechReportUtils.a("chat_history", "query_month_cost", String.valueOf(l), String.valueOf(j), String.valueOf(i), "");
      if (QLog.isColorLevel()) {
        QLog.i(ChatHistoryByDateFragment.a(), 2, String.format("queryDB count: %d | message count: %d | cost time %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryByDateFragment.1
 * JD-Core Version:    0.7.0.1
 */