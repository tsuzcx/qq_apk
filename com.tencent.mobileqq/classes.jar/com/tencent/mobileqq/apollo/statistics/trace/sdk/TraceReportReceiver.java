package com.tencent.mobileqq.apollo.statistics.trace.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class TraceReportReceiver
{
  public static void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    try
    {
      if (!TraceReportInstance.a()) {
        return;
      }
      int i = paramBundle.getInt("featureId");
      String str = paramBundle.getString("featureKey");
      if ("action_init_trace".equals(paramString))
      {
        i = paramBundle.getInt("appId", -1);
        paramString = paramBundle.getString("currentAccount", null);
        if ((i >= 0) && (!TextUtils.isEmpty(paramString)))
        {
          paramString = new TraceConfig.Builder().a(i).a(paramString).a();
          TraceReportInstance.a().a(paramString);
          return;
        }
        TraceReportInstance.a().a(null);
        QLog.d("[cmshow][TraceReport]", 2, new Object[] { "TraceReportReceiver init trace error! appId: ", Integer.valueOf(i), ", currentAccount:", paramString });
        return;
      }
      if ("action_begin_trace".equals(paramString))
      {
        TraceReportInstance.a().a(i, str, paramBundle);
        return;
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
      if ("action_enable_trace".equals(paramString))
      {
        boolean bool = paramBundle.getBoolean("enable");
        TraceReportInstance.a().a(i, bool);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow][TraceReport]", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver
 * JD-Core Version:    0.7.0.1
 */