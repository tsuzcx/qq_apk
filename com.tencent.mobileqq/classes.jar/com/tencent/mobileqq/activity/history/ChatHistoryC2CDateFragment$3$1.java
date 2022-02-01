package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryC2CDateFragment$3$1
  implements Runnable
{
  ChatHistoryC2CDateFragment$3$1(ChatHistoryC2CDateFragment.3 param3) {}
  
  public void run()
  {
    if ((ChatHistoryC2CDateFragment.a(this.a.a) != null) && (this.a.a.s != null))
    {
      this.a.a.s.getProxyManager().transSaveToDatabase();
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(ChatHistoryC2CDateFragment.a(this.a.a).getTimeInMillis());
      ((Calendar)localObject).add(5, 1);
      long l1 = ChatHistoryC2CDateFragment.a(this.a.a).getTimeInMillis() / 1000L;
      long l2 = ((Calendar)localObject).getTimeInMillis() / 1000L;
      localObject = ChatHistoryC2CDateFragment.c(this.a.a).a(ChatHistoryC2CDateFragment.b(this.a.a), l1, l2);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (MessageRecord)((List)localObject).get(0);
        if (this.a.a.getBaseActivity() != null) {
          ChatHistoryActivity.a(this.a.a.getBaseActivity(), ChatHistoryC2CDateFragment.b(this.a.a), ChatHistoryC2CDateFragment.d(this.a.a), ChatHistoryC2CDateFragment.e(this.a.a), ((MessageRecord)localObject).time, ((MessageRecord)localObject).shmsgseq, 0);
        }
      }
      else
      {
        QLog.e(ChatHistoryC2CDateFragment.b(), 2, "msgList is empty");
        ThreadManager.getUIHandler().post(new ChatHistoryC2CDateFragment.3.1.1(this));
      }
      ChatHistoryC2CDateFragment.a(this.a.a, null);
      return;
    }
    QLog.e(ChatHistoryC2CDateFragment.b(), 2, "click day is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.3.1
 * JD-Core Version:    0.7.0.1
 */