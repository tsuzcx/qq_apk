package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerController;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class ChatHistoryC2CDateFragment$ChatHistoryDatePickerController
  implements DatePickerController
{
  CalendarDay a;
  CalendarDay b;
  
  public ChatHistoryC2CDateFragment$ChatHistoryDatePickerController(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment, CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.a = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public CalendarDay a()
  {
    CalendarDay localCalendarDay2 = this.a;
    CalendarDay localCalendarDay1 = localCalendarDay2;
    if (localCalendarDay2 == null) {
      localCalendarDay1 = new CalendarDay(System.currentTimeMillis());
    }
    return localCalendarDay1;
  }
  
  public void a(CalendarDay paramCalendarDay, MessageRecord paramMessageRecord)
  {
    if (ChatHistoryC2CDateFragment.c(this.c).a())
    {
      localObject = this.c;
      ((ChatHistoryC2CDateFragment)localObject).a(((ChatHistoryC2CDateFragment)localObject).getString(2131916807), new ChatHistoryC2CDateFragment.CancelDialogListener(this.c));
      ChatHistoryC2CDateFragment.a(this.c, paramCalendarDay);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramCalendarDay.getTimeInMillis());
      ChatHistoryC2CDateFragment.c(this.c).d((Calendar)localObject);
    }
    else
    {
      ChatHistoryC2CDateFragment.b(this.c);
      ChatHistoryActivity.a(this.c.getBaseActivity(), ChatHistoryC2CDateFragment.b(this.c), ChatHistoryC2CDateFragment.d(this.c), ChatHistoryC2CDateFragment.e(this.c), paramMessageRecord.time, paramMessageRecord.shmsgseq, 0);
    }
    Object localObject = ChatHistoryC2CDateFragment.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clickDay: CalendarDay");
    localStringBuilder.append(paramCalendarDay);
    localStringBuilder.append(" | MessageRecord:");
    localStringBuilder.append(paramMessageRecord);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void a(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.a = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
  {
    if (!ChatHistoryC2CDateFragment.a(this.c, paramInt1, paramInt2))
    {
      if (this.c.z)
      {
        this.c.a(paramInt1, paramInt2);
        return;
      }
      this.c.b(paramInt1, paramInt2);
    }
  }
  
  public CalendarDay b()
  {
    CalendarDay localCalendarDay = this.b;
    if (localCalendarDay == null)
    {
      localCalendarDay = new CalendarDay(System.currentTimeMillis());
      return new CalendarDay(localCalendarDay.year + 1, localCalendarDay.month, localCalendarDay.month);
    }
    return localCalendarDay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.ChatHistoryDatePickerController
 * JD-Core Version:    0.7.0.1
 */