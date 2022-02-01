package com.tencent.gdtad.basics.motivevideo.report;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.ReportCallback;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class GdtADFlyingStreamingReportHelper
{
  private static volatile GdtADFlyingStreamingReportHelper f;
  private String a;
  private String b;
  private String c;
  private String d;
  private int e = 0;
  
  public static GdtADFlyingStreamingReportHelper a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new GdtADFlyingStreamingReportHelper();
        }
      }
      finally {}
    }
    return f;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, null, null);
  }
  
  public void a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.d() != null))
    {
      paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.d();
      this.a = paramGdtMotiveVideoModel.getTraceId();
      this.c = paramGdtMotiveVideoModel.getPosId();
      this.d = String.valueOf(paramGdtMotiveVideoModel.getAId());
    }
    this.b = String.valueOf(AppSetting.d());
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    return a(paramLong, paramJSONObject, null);
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject, GdtReportForAntiSpam.ReportCallback paramReportCallback)
  {
    if (TextUtils.isEmpty(this.a))
    {
      QLog.i("GdtADFlyingStreamingReportHelper", 1, "reportADEvent traceId is empty");
      return false;
    }
    JSONObject localJSONObject1 = d();
    if (localJSONObject1 == null)
    {
      QLog.i("GdtADFlyingStreamingReportHelper", 1, "reportADEvent local param is null");
      return false;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONObject1.put("events", localJSONArray);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("seq", 1);
      localJSONObject2.put("ts", b(System.currentTimeMillis()));
      localJSONObject2.put("ei", paramLong);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject2.put("biz", localJSONObject3);
      localJSONObject3.put("traceid", this.a);
      localJSONObject3.put("pid", this.c);
      localJSONObject3.put("aid", this.d);
      if (paramJSONObject != null) {
        localJSONObject2.put("ext", paramJSONObject);
      }
      localJSONArray.put(localJSONObject2);
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("GdtADFlyingStreamingReportHelper", 1, "reportADEvent buildParams", paramJSONObject);
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("reportADEvent ");
    paramJSONObject.append(localJSONObject1.toString());
    QLog.i("GdtADFlyingStreamingReportHelper", 1, paramJSONObject.toString());
    GdtReportForAntiSpam.a(localJSONObject1, paramReportCallback);
    return true;
  }
  
  public int b()
  {
    return this.e;
  }
  
  protected long b(long paramLong)
  {
    return paramLong + NetConnInfoCenter.servetTimeSecondInterv * 1000L;
  }
  
  public void c()
  {
    this.a = null;
    this.b = null;
    this.e = 0;
  }
  
  protected JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("app", String.valueOf(this.b));
      localJSONObject.put("pkg", MobileQQ.sMobileQQ.getPackageName());
      localJSONObject.put("sv", "8.8.17");
      localJSONObject.put("av", "8.8.17");
      localJSONObject.put("sdk_st", 9);
      localJSONObject.put("ov", String.valueOf(Build.VERSION.RELEASE));
      localJSONObject.put("os", 2);
      localJSONObject.put("mn", DeviceInfoUtil.u());
      localJSONObject.put("lid", e());
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtADFlyingStreamingReportHelper", 1, "buildParams", localThrowable);
    }
    return localJSONObject;
  }
  
  public String e()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null) {
      return "";
    }
    return localAppRuntime.getAccount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper
 * JD-Core Version:    0.7.0.1
 */