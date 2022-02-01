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
  CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  CalendarDay b;
  
  public ChatHistoryTroopDateFragment$ChatHistoryDatePickerController(ChatHistoryTroopDateFragment paramChatHistoryTroopDateFragment, CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay1;
    this.b = paramCalendarDay2;
  }
  
  public CalendarDay a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay == null) {
      return new CalendarDay(System.currentTimeMillis());
    }
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  }
  
  public void a(CalendarDay paramCalendarDay, MessageRecord paramMessageRecord)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment.jdField_b_of_type_JavaLangString;
    ChatHistoryBubbleListForTroopFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment.getActivity(), str, paramMessageRecord, -1, 3);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment.jdField_b_of_type_JavaLangString, "", "", "");
    QLog.i(ChatHistoryTroopDateFragment.b(), 1, "clickDay: CalendarDay" + paramCalendarDay + " | MessageRecord:" + paramMessageRecord);
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, int paramInt1, int paramInt2)
  {
    if (!ChatHistoryTroopDateFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment, paramInt1, paramInt2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopDateFragment.a(paramInt1, paramInt2);
    }
  }
  
  public CalendarDay b()
  {
    if (this.b == null)
    {
      CalendarDay localCalendarDay = new CalendarDay(System.currentTimeMillis());
      return new CalendarDay(localCalendarDay.year + 1, localCalendarDay.month, localCalendarDay.month);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment.ChatHistoryDatePickerController
 * JD-Core Version:    0.7.0.1
 */