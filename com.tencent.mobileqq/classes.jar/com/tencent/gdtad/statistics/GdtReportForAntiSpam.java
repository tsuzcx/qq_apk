package com.tencent.gdtad.statistics;

import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public final class GdtReportForAntiSpam
{
  public static void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      if (paramJSONObject.length() <= 0) {
        return;
      }
      try
      {
        paramJSONObject.put("ct", System.currentTimeMillis());
      }
      catch (Throwable localThrowable)
      {
        GdtLog.d("GdtReportForAntiSpam", "reportAntiSpamForClick", localThrowable);
      }
      b(paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, GdtReportForAntiSpam.ReportCallback paramReportCallback)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      if (paramJSONObject.length() <= 0) {
        return;
      }
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.2(arrayOfByte, paramReportCallback, paramJSONObject), 4);
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      if (paramJSONObject.length() <= 0) {
        return;
      }
      try
      {
        paramJSONObject.put("cn_t", AdNet.getType(BaseApplication.getContext()));
      }
      catch (Throwable localThrowable)
      {
        GdtLog.d("GdtReportForAntiSpam", "receiveReportForAntiSpamOnReportServer", localThrowable);
      }
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      AdThreadManager.INSTANCE.post(new GdtReportForAntiSpam.1(arrayOfByte, paramJSONObject), 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReportForAntiSpam
 * JD-Core Version:    0.7.0.1
 */