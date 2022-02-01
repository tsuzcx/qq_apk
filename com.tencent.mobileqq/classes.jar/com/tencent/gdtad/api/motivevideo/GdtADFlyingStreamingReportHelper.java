package com.tencent.gdtad.api.motivevideo;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdABTest;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForVideoReward;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.ReportCallback;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class GdtADFlyingStreamingReportHelper
{
  private static volatile GdtADFlyingStreamingReportHelper jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtADFlyingStreamingReportHelper;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public static GdtADFlyingStreamingReportHelper a()
  {
    if (jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtADFlyingStreamingReportHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtADFlyingStreamingReportHelper == null) {
        jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtADFlyingStreamingReportHelper = new GdtADFlyingStreamingReportHelper();
      }
      return jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtADFlyingStreamingReportHelper;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected long a(long paramLong)
  {
    return NetConnInfoCenter.servetTimeSecondInterv * 1000L + paramLong;
  }
  
  public String a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {}
    do
    {
      return "";
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } while (localObject == null);
    return ((AppRuntime)localObject).getAccount();
  }
  
  protected JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      localJSONObject.put("app", String.valueOf(this.b));
      localJSONObject.put("pkg", localBaseApplicationImpl.getPackageName());
      localJSONObject.put("sv", "8.5.5");
      localJSONObject.put("av", "8.5.5");
      localJSONObject.put("sdk_st", 2);
      localJSONObject.put("ov", String.valueOf(Build.VERSION.RELEASE));
      localJSONObject.put("os", 2);
      localJSONObject.put("mn", DeviceInfoUtil.i());
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtADFlyingStreamingReportHelper", 1, "buildParams", localThrowable);
    }
    return localJSONObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, null, null);
  }
  
  public void a(GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    if ((paramGdtMotiveVideoModel != null) && (paramGdtMotiveVideoModel.a() != null))
    {
      paramGdtMotiveVideoModel = paramGdtMotiveVideoModel.a();
      this.jdField_a_of_type_JavaLangString = paramGdtMotiveVideoModel.getTraceId();
      this.c = paramGdtMotiveVideoModel.getPosId();
      this.d = String.valueOf(paramGdtMotiveVideoModel.getAId());
    }
    this.b = String.valueOf(AppSetting.a());
  }
  
  public boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null)
    {
      QLog.i("GdtADFlyingStreamingReportHelper", 1, "isABTestByUIN context is null");
      return false;
    }
    localObject = AdSettingsUtil.INSTANCE.getSettingsCache(((BaseApplicationImpl)localObject).getApplicationContext());
    if (localObject == null)
    {
      QLog.i("GdtADFlyingStreamingReportHelper", 1, "isABTestByUIN settings is null");
      return false;
    }
    return AdABTest.isABTestByUIN(a(), ((gdt_settings.Settings)localObject).settingsForVideoReward.abTest);
  }
  
  public boolean a(long paramLong, GdtReportForAntiSpam.ReportCallback paramReportCallback)
  {
    return a(paramLong, null, paramReportCallback);
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    return a(paramLong, paramJSONObject, null);
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject, GdtReportForAntiSpam.ReportCallback paramReportCallback)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("GdtADFlyingStreamingReportHelper", 2, "reportADEvent no report");
      }
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("GdtADFlyingStreamingReportHelper", 1, "reportADEvent traceId is empty");
      return false;
    }
    JSONObject localJSONObject1 = a();
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
      localJSONObject2.put("ts", a(System.currentTimeMillis()));
      localJSONObject2.put("ei", paramLong);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject2.put("biz", localJSONObject3);
      localJSONObject3.put("traceid", this.jdField_a_of_type_JavaLangString);
      localJSONObject3.put("pid", this.c);
      localJSONObject3.put("aid", this.d);
      if (paramJSONObject != null) {
        localJSONObject2.put("ext", paramJSONObject);
      }
      localJSONArray.put(localJSONObject2);
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        QLog.e("GdtADFlyingStreamingReportHelper", 1, "reportADEvent buildParams", paramJSONObject);
      }
    }
    QLog.i("GdtADFlyingStreamingReportHelper", 1, "reportADEvent " + localJSONObject1.toString());
    GdtReportForAntiSpam.a(localJSONObject1, paramReportCallback);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtADFlyingStreamingReportHelper
 * JD-Core Version:    0.7.0.1
 */