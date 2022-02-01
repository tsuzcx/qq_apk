package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GdtReporter
{
  private static final String PARAM_KEY_PS = "ps";
  private static final String PARAM_VALUE_THREE = "3";
  private static final String PARAM_VALUE_TWO = "2";
  public static final int REPORT_DEEP_LINK_SUCCESS = 137;
  public static final int REPORT_OPEN_MAIN_PAGE = 138;
  private static final String TAG = "GdtReporter";
  
  @Deprecated
  public static void doCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GdtCgiReportRunnable(paramString), 2, null, false);
    GdtLog.b("GDT_CGI_REPORT", paramString);
  }
  
  public static void doExposeCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    GdtADFlyingStreamingReportHelper.a().a(1020008L);
    GdtCgiReportRunnable localGdtCgiReportRunnable = new GdtCgiReportRunnable(paramString);
    localGdtCgiReportRunnable.a(new GdtReporter.1());
    ThreadManager.post(localGdtCgiReportRunnable, 2, null, false);
    GdtLog.b("GDT_CGI_REPORT", paramString);
  }
  
  public static void reportPlayFail(GdtMotiveVideoModel paramGdtMotiveVideoModel, int paramInt1, int paramInt2)
  {
    if (paramGdtMotiveVideoModel == null)
    {
      QLog.i("GdtReporter", 1, "reportPlayFail fail,model is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    String str1;
    if ((paramInt1 != 1101) && (paramInt1 != 1103))
    {
      double d = paramInt2;
      Double.isNaN(d);
      if ((int)(d / 1000000.0D) != 14) {
        str1 = "3";
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ps", str1);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportPlayFail error:");
        localStringBuilder.append(localException);
        QLog.i("GdtReporter", 1, localStringBuilder.toString());
      }
      AdThreadManager.INSTANCE.post(new GdtReporter.2(paramGdtMotiveVideoModel, localJSONObject), 4);
      return;
      String str2 = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter
 * JD-Core Version:    0.7.0.1
 */