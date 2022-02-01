package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class QLogReporter
{
  static final SimpleDateFormat a = new SimpleDateFormat("yy.MM.dd");
  private static volatile QLogReporter b = null;
  
  public static QLogReporter a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QLogReporter();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void b()
  {
    if (new GregorianCalendar().get(11) < 2) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qlog_reporter", 0);
    long l1 = System.currentTimeMillis();
    long l2 = localSharedPreferences.getLong("LastLogSizeReportTime", 0L);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l2);
    String str = a.format(localCalendar.getTime());
    localCalendar.setTimeInMillis(l1);
    if (str.equals(a.format(localCalendar.getTime()))) {
      return;
    }
    ThreadManager.executeOnSubThread(new QLogReporter.1(this, localSharedPreferences, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.QLogReporter
 * JD-Core Version:    0.7.0.1
 */