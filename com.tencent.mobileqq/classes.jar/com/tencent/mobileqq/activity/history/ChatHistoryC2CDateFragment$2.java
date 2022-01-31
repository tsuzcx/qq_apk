package com.tencent.mobileqq.activity.history;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ChatHistoryC2CDateFragment$2
  implements Runnable
{
  ChatHistoryC2CDateFragment$2(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtime();
    int n = CalendarDay.getDaysInMonth(this.a, this.b);
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int k = 0;
    int j = 0;
    while (i <= n)
    {
      MessageRecord localMessageRecord = ChatHistoryC2CDateFragment.a(this.this$0, this.a, this.b, i);
      int m = k + 1;
      k = j;
      if (localMessageRecord != null)
      {
        k = j + 1;
        localArrayList.add(localMessageRecord);
      }
      i += 1;
      j = k;
      k = m;
    }
    if (localArrayList.size() > 0) {
      ThreadManager.getUIHandler().post(new ChatHistoryC2CDateFragment.2.1(this, localArrayList));
    }
    long l2 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.i(ChatHistoryC2CDateFragment.b(), 2, String.format("queryDB count: %d | message count: %d | cost time %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.2
 * JD-Core Version:    0.7.0.1
 */