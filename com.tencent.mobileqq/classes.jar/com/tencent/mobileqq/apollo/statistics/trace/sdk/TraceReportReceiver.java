package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class TraceReportReceiver
{
  public static void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      String str;
      for (;;)
      {
        return;
        try
        {
          if (TraceReportInstance.a())
          {
            i = paramBundle.getInt("featureId");
            str = paramBundle.getString("featureKey");
            if ("action_begin_trace".equals(paramString))
            {
              TraceReportInstance.a().a(i, str, paramBundle);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TraceReport", 1, paramString, new Object[0]);
          return;
        }
      }
      if ("action_end_trace".equals(paramString))
      {
        TraceReportInstance.a().b(i, str, paramBundle);
        return;
      }
      if ("action_report_span".equals(paramString))
      {
        TraceReportInstance.a().c(i, str, paramBundle);
        return;
      }
      if ("action_update_trace".equals(paramString))
      {
        TraceReportInstance.a().a(i, paramBundle);
        return;
      }
    } while (!"action_enable_trace".equals(paramString));
    boolean bool = paramBundle.getBoolean("enable");
    TraceReportInstance.a().a(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver
 * JD-Core Version:    0.7.0.1
 */