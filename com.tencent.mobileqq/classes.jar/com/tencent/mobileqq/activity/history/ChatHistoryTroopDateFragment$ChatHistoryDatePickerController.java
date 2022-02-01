package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerController;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.qphone.base.util.QLog;

public class ChatHistoryTroopDateFragment$ChatHistoryDatePickerController
  implements DatePickerController
{
  CalendarDay a;
  CalendarDay b;
  
  public ChatHistoryTroopDateFragment$ChatHistoryDatePickerController(ChatHistoryTroopDateFragment paramChatHistoryTroopDateFragment, CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
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
    String str = this.c.s;
    ChatHistoryBubbleListForTroopFragment.a(this.c.getBaseActivity(), str, paramMessageRecord, -1, 3);
    ReportController.b(this.c.t, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_clk", 0, 0, this.c.s, "", "", "");
    str = ChatHistoryTroopDateFragment.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clickDay: CalendarDay");
    localStringBuilder.append(paramCalendarDay);
    localStringBuilder.append(" | MessageRecord:");
    localStringBuilder.append(paramMessageRecord);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
  {
    if (!ChatHistoryTroopDateFragment.a(this.c, paramInt1, paramInt2)) {
      this.c.a(paramInt1, paramInt2);
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
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment.ChatHistoryDatePickerController
 * JD-Core Version:    0.7.0.1
 */