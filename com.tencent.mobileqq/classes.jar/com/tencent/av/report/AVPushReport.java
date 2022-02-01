package com.tencent.av.report;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.HttpUtil.SimpleHttpPostTask;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AVPushReport
{
  private static HttpUtil.SimpleHttpPostTask a;
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAvReportPush : rspType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",rspBody = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AVPushReport", 2, ((StringBuilder)localObject).toString());
    }
    if (a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVPushReport", 2, "ReportTask is running.");
      }
    }
    else
    {
      if (a()) {
        localObject = "https://play.mobile.qq.com/avreport_test/cgi-bin/report";
      } else {
        localObject = "https://play.mobile.qq.com/avreport/cgi-bin/report";
      }
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("attach");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", paramVideoAppInterface.getLongAccountUin());
        localJSONObject.put("skey", paramVideoAppInterface.k());
        localJSONObject.put("qqversion", "8.8.17");
        localJSONObject.put("time", System.currentTimeMillis());
        if (paramString != null) {
          localJSONObject.put("attach", paramString);
        }
      }
      catch (JSONException paramVideoAppInterface)
      {
        paramVideoAppInterface.printStackTrace();
      }
      a = new AVPushReport.1((String)localObject, localJSONObject.toString(), null);
      a.execute(new Void[0]);
    }
  }
  
  public static boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.AVPushReport
 * JD-Core Version:    0.7.0.1
 */