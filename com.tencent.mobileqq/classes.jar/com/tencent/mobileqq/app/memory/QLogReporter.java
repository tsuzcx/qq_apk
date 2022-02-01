package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class QLogReporter
{
  private static volatile QLogReporter jdField_a_of_type_ComTencentMobileqqAppMemoryQLogReporter = null;
  static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy.MM.dd");
  
  public static QLogReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryQLogReporter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppMemoryQLogReporter == null) {
          jdField_a_of_type_ComTencentMobileqqAppMemoryQLogReporter = new QLogReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqAppMemoryQLogReporter;
  }
  
  public void a()
  {
    if (new GregorianCalendar().get(11) < 2) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qlog_reporter", 0);
    long l1 = System.currentTimeMillis();
    long l2 = localSharedPreferences.getLong("LastLogSizeReportTime", 0L);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l2);
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime());
    localCalendar.setTimeInMillis(l1);
    if (str.equals(jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime()))) {
      return;
    }
    ThreadManager.executeOnSubThread(new QLogReporter.1(this, localSharedPreferences, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.QLogReporter
 * JD-Core Version:    0.7.0.1
 */