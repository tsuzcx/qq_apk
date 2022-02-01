package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReportUtils
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private static final String a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getAccount();
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static void a()
  {
    ThreadManagerV2.executeOnFileThread(new ReportUtils.1());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo)
  {
    String str = "0";
    if (SimpleUIUtil.a()) {
      str = "1";
    }
    for (;;)
    {
      a(paramQQAppInterface, paramString, paramSessionInfo, str);
      return;
      if (StudyModeManager.a()) {
        str = "2";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, SessionInfo paramSessionInfo, String paramString2)
  {
    String str = "";
    if (paramSessionInfo != null) {}
    try
    {
      if (paramSessionInfo.a == 3000) {
        str = "2";
      }
      for (;;)
      {
        paramSessionInfo = NetConnInfoCenter.getServerTimeMillis() + "";
        if (QLog.isColorLevel()) {
          QLog.i("ReportUtils", 2, String.format("opName: %s__d1: %s__d2: %s__d3: %s", new Object[] { paramString1, str, paramSessionInfo, paramString2 }));
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramString1, 0, 0, str, paramSessionInfo, paramString2, "");
        return;
        if (paramSessionInfo.a == 1) {
          str = "1";
        } else {
          str = "0";
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ReportUtils", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if ((!paramMap.containsKey("A8")) && (BaseApplicationImpl.getApplication() != null)) {
        paramMap.put("A8", a(BaseApplicationImpl.getApplication().peekAppRuntime()));
      }
      if (!paramMap.containsKey("plat")) {
        paramMap.put("plat", "android");
      }
      if (!paramMap.containsKey("version")) {
        paramMap.put("version", "8.5.5");
      }
    }
    UserAction.onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, true, true);
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    a(paramString1, paramString2, a(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ReportUtils
 * JD-Core Version:    0.7.0.1
 */