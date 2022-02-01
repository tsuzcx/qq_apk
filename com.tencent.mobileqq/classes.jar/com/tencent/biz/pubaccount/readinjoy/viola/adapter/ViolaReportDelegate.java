package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ViolaReportDelegate
  implements IReportDelegate
{
  public static String a;
  public HashMap<String, String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ViolaReportDelegate";
  }
  
  public ViolaReportDelegate()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private JSONObject a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
    try
    {
      localJSONObject.put(ViolaEnvironment.COMMON_UIN, ReadInJoyUtils.a());
      localJSONObject.put(ViolaEnvironment.COMMON_NET, Integer.toString(ReadInJoyUtils.a(BaseApplication.getContext())));
      localJSONObject.put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.e());
      localJSONObject.put(ViolaEnvironment.COMMON_QQ_VERSION, "8.5.5");
      localJSONObject.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      String str2 = ViolaEnvironment.COMMON_BIZ;
      if (TextUtils.isEmpty(str1)) {}
      for (str1 = paramString;; str1 = paramString + "&offlineVersion=" + HtmlOffline.a(str1))
      {
        localJSONObject.put(str2, URLEncoder.encode(str1));
        localJSONObject.put(ViolaEnvironment.COMMON_PLATFORM, "0");
        localJSONObject.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ViolaAccessHelper.a));
        if (!TextUtils.isEmpty(paramString)) {
          localJSONObject.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
        }
        localJSONObject.put(ViolaEnvironment.COMMON_RELEASE, "1");
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initCommonDataJson Exception:" + paramString.getMessage());
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ViolaReportDelegate.2(this), 8, null, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.post(new ViolaReportDelegate.1(this, paramString, paramInt), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) && (paramString2.equals(this.jdField_a_of_type_JavaUtilHashMap.get(paramString1)))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    }
  }
  
  public void addReportData(String paramString1, String paramString2)
  {
    if ((ViolaEnvironment.KEY_SO.equals(paramString1)) && (ViolaEnvironment.SO_START.equals(paramString2)))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 2)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void dropFrameMonitor(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a(paramString, false);
      return;
    }
    DropFrameMonitor.a().a(paramString);
  }
  
  public HashMap<String, String> getBaseReportData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = Uri.parse(paramString).getQueryParameter("v_bid");
      str2 = ViolaEnvironment.COMMON_BIZ;
      if (!TextUtils.isEmpty(str1)) {
        break label168;
      }
    }
    label168:
    for (String str1 = paramString;; str1 = paramString + "&offlineVersion=" + HtmlOffline.a(str1))
    {
      localHashMap.put(str2, URLEncoder.encode(str1));
      localHashMap.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
      localHashMap.put(ViolaEnvironment.COMMON_UIN, ReadInJoyUtils.a());
      localHashMap.put(ViolaEnvironment.COMMON_NET, Integer.toString(ReadInJoyUtils.a(BaseApplication.getContext())));
      localHashMap.put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.e());
      localHashMap.put(ViolaEnvironment.COMMON_QQ_VERSION, "8.5.5");
      localHashMap.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      localHashMap.put(ViolaEnvironment.COMMON_PLATFORM, "0");
      localHashMap.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ViolaAccessHelper.a));
      localHashMap.put(ViolaEnvironment.COMMON_RELEASE, "1");
      localHashMap.put(ViolaEnvironment.COMMON_APPLICATION, "1");
      return localHashMap;
    }
  }
  
  public void reportData(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(ViolaEnvironment.COMMON_UIN)) {
        this.jdField_a_of_type_JavaUtilHashMap.putAll(getBaseReportData(paramString));
      }
      paramString = ViolaUtils.copyMap(this.jdField_a_of_type_JavaUtilHashMap);
      if (!paramString.isEmpty()) {
        RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, paramString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void reportHttpData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    RIJStatisticCollectorReport.b(ReadInJoyUtils.a(), true, paramHashMap);
  }
  
  public void reportJsError(boolean paramBoolean, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("error_msg", paramString);
      localJSONObject.put("is_renderJs", paramBoolean);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AC69", "0X800AC69", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void reportNVProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "reportPageProcessNew Exception:" + paramString1.getMessage());
    }
  }
  
  public void reportNativeVueError(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error", paramString1);
      localJSONObject.put("url", paramString2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800B08D", "0X800B08D", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "reportNativeVueError: " + paramString1.getMessage());
      }
    }
  }
  
  public void reportPageProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        RIJStatisticCollectorReport.a(ReadInJoyUtils.a(), true, paramString3);
        a();
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "reportPageProcessNew Exception:" + paramString1.getMessage());
    }
  }
  
  public void reportRunningData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    RIJStatisticCollectorReport.c(ReadInJoyUtils.a(), true, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate
 * JD-Core Version:    0.7.0.1
 */