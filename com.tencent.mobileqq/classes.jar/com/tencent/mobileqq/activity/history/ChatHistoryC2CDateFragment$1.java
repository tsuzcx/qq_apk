package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import mqq.os.MqqHandler;

class ChatHistoryC2CDateFragment$1
  implements Runnable
{
  ChatHistoryC2CDateFragment$1(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = new CalendarDay(this.a, this.b, 1);
    int i = CalendarDay.getDaysInMonth(this.a, this.b);
    Object localObject2 = new CalendarDay(this.a, this.b, i);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(((CalendarDay)localObject1).getTimeInMillis());
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(((CalendarDay)localObject2).getTimeInMillis());
    localObject2 = ((MessageRoamManager)this.this$0.getBaseActivity().app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b(localCalendar, (Calendar)localObject1);
    localCalendar = (Calendar)localCalendar.clone();
    ArrayList localArrayList = new ArrayList(31);
    i = 0;
    for (;;)
    {
      if ((!localCalendar.before(localObject1)) && (!localCalendar.equals(localObject1)))
      {
        if (localArrayList.size() > 0) {
          ThreadManager.getUIHandler().post(new ChatHistoryC2CDateFragment.1.1(this, localArrayList));
        }
        return;
      }
      if (((BitSet)localObject2).get(i))
      {
        MessageRecord localMessageRecord = new MessageRecord();
        localMessageRecord.time = (localCalendar.getTimeInMillis() / 1000L);
        localArrayList.add(localMessageRecord);
      }
      localCalendar.add(5, 1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.1
 * JD-Core Version:    0.7.0.1
 */