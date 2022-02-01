package com.tencent.mobileqq.activity.aio;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;

public class TimestampReporter
{
  private static ArraySet<Long> a = new ArraySet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (!a.contains(Long.valueOf(paramMessageRecord.uniseq)))
    {
      a.add(Long.valueOf(paramMessageRecord.uniseq));
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A52B", "0X800A52B", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a.add(Long.valueOf(paramMessageRecord.uniseq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.TimestampReporter
 * JD-Core Version:    0.7.0.1
 */