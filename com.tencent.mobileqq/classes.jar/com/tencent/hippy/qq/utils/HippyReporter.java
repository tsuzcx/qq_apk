package com.tencent.hippy.qq.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyReporter
{
  public static final String HIPPY_REPORT_APP_KEY = "0DOU0VN8VA4YJXF0";
  public static final int OPEN_RESULT_MODULE_INVALID = -4;
  public static final int OPEN_RESULT_NO_JSBUNDLE = -2;
  public static final int OPEN_RESULT_NO_SO = -3;
  public static final int OPEN_RESULT_SUCCESS = 0;
  public static final int OPEN_RESULT_SWITCH_OFF = -1;
  public static final int OPER_TYPE_CHECK_UPDATE = 5;
  public static final int OPER_TYPE_GAMECENTER = 9;
  public static final int OPER_TYPE_JS_EXCEPTION = 1;
  public static final int OPER_TYPE_LOAD_CRASH = 7;
  public static final int OPER_TYPE_LOAD_HIPPY = 3;
  public static final int OPER_TYPE_LOAD_MODULE_JS_EXCEPTION = 4;
  public static final int OPER_TYPE_LOAD_PAGE_TIMEOUT = 6;
  public static final int OPER_TYPE_LOAD_STEP_TIMEOUT = 8;
  public static final int OPER_TYPE_NATIVE_EXCEPTION = 2;
  public static final int OPER_TYPE_PREDOWNLOAD_HIPPY = 12;
  public static final int OPER_TYPE_PRELOAD_HIPPY = 10;
  public static final int OPER_TYPE_SSO_CHECK_UPDATE = 11;
  private static final String TAG = "HippyReporter";
  private static HippyReporter sInstance;
  
  private void baseReport(JSONArray paramJSONArray, HashMap<String, String> paramHashMap)
  {
    if (paramJSONArray == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramJSONArray == null) {
          break label184;
        }
        localObject = localJSONObject;
        getReportHeadData((JSONObject)localObject, paramHashMap);
        if (paramJSONArray != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("head", localJSONObject);
          ((JSONObject)localObject).put("body", paramJSONArray);
          ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).reportHippy((JSONObject)localObject);
        }
        if (paramHashMap != null)
        {
          paramJSONArray = (String)paramHashMap.remove("eventCode");
          localObject = (String)paramHashMap.remove("uin");
          if (!TextUtils.isEmpty(paramJSONArray)) {
            QQBeaconReport.a("0DOU0VN8VA4YJXF0", (String)localObject, paramJSONArray, true, paramHashMap, true);
          }
          if (QLog.isColorLevel())
          {
            paramJSONArray = new StringBuilder();
            paramJSONArray.append("baseReport data:");
            paramJSONArray.append(paramHashMap);
            QLog.i("HippyReporter", 2, paramJSONArray.toString());
            return;
          }
        }
      }
      catch (Throwable paramJSONArray)
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("baseReport e:");
        paramHashMap.append(paramJSONArray);
        QLog.e("HippyReporter", 1, paramHashMap.toString());
      }
      return;
      label184:
      Object localObject = null;
    }
  }
  
  public static AppInterface getAppInterface()
  {
    return ((IHippyUtils)QRoute.api(IHippyUtils.class)).getAppInterface();
  }
  
  public static HippyReporter getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new HippyReporter();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  protected static void getReportHeadData(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    try
    {
      Object localObject2 = AppConstants.NET_TYPE_NAME[0];
      int i = HttpUtil.getNetWorkType();
      Object localObject1 = localObject2;
      if (i < AppConstants.NET_TYPE_NAME.length)
      {
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = AppConstants.NET_TYPE_NAME[i];
        }
      }
      localObject2 = "";
      Object localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject3 != null) {
        localObject2 = ((AppRuntime)localObject3).getAccount();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(DeviceInfoUtil.i());
      ((StringBuilder)localObject3).append("*");
      ((StringBuilder)localObject3).append(DeviceInfoUtil.j());
      localObject3 = ((StringBuilder)localObject3).toString();
      if (paramJSONObject != null)
      {
        paramJSONObject.put("mobile_model", Build.MODEL);
        paramJSONObject.put("manufacturer", Build.BRAND);
        paramJSONObject.put("os_ver", Build.VERSION.SDK_INT);
        paramJSONObject.put("cpu_bit", 32);
        paramJSONObject.put("qq_ver", DeviceInfoUtil.a(MobileQQ.getContext()));
        paramJSONObject.put("is_public", 1);
        paramJSONObject.put("resolution", localObject3);
        paramJSONObject.put("net", localObject1);
        paramJSONObject.put("uin", localObject2);
      }
      if (paramMap != null)
      {
        paramMap.put("cpu_bit", String.valueOf(32));
        paramMap.put("qq_ver", DeviceInfoUtil.a(MobileQQ.getContext()));
        paramMap.put("is_public", String.valueOf(1));
        paramMap.put("resolution", localObject3);
        paramMap.put("net", localObject1);
        paramMap.put("uin", localObject2);
      }
      localObject3 = ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getLibraryVersions();
      if ((localObject3 != null) && (((HashMap)localObject3).size() > 0))
      {
        localObject1 = new JSONObject();
        localObject2 = new StringBuilder();
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue());
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).append('&');
          }
          ((StringBuilder)localObject2).append((String)localEntry.getKey());
          ((StringBuilder)localObject2).append('=');
          ((StringBuilder)localObject2).append((String)localEntry.getValue());
        }
        if (paramJSONObject != null) {
          paramJSONObject.put("hippy_info", localObject1);
        }
        if (paramMap != null)
        {
          paramMap.put("hippy_info", ((StringBuilder)localObject2).toString());
          return;
        }
      }
    }
    catch (Throwable paramJSONObject)
    {
      paramMap = new StringBuilder();
      paramMap.append("getReportHeadData error:");
      paramMap.append(paramJSONObject);
      QLog.e("HippyReporter", 1, paramMap.toString());
    }
  }
  
  public static void reportToDengTa(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = new HashMap();
      }
      getReportHeadData(null, (Map)localObject);
      QQBeaconReport.a("0DOU0VN8VA4YJXF0", (String)((Map)localObject).remove("uin"), paramString, true, (Map)localObject, paramBoolean);
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("baseReport eventCode:");
        paramMap.append(paramString);
        paramMap.append(" data:");
        paramMap.append(localObject);
        QLog.i("HippyReporter", 2, paramMap.toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramMap = new StringBuilder();
      paramMap.append("baseReport e:");
      paramMap.append(paramString);
      QLog.e("HippyReporter", 1, paramMap.toString());
    }
  }
  
  protected String getExceptionMessage(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramException != null)
    {
      localStringBuilder.append(paramException.toString());
      if (paramException.getStackTrace() != null)
      {
        paramException = paramException.getStackTrace();
        int i = 0;
        while ((i < paramException.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramException[i].toString());
          i += 1;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  protected String operTypeToEventCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 12: 
      return "hippy_predownload";
    case 11: 
      return "hippy_js_update";
    case 10: 
      return "hippy_preload";
    case 9: 
      return "hippy_gamecenter_enter";
    case 8: 
      return "hippy_step_timeout";
    case 7: 
      return "hippy_load_crash";
    case 6: 
      return "hippy_open_timeout";
    case 5: 
      return "hippy_js_update_old";
    case 4: 
      return "hippy_loadmodule_js_error";
    case 3: 
      return "hippy_open";
    case 2: 
      return "hippy_sdk_error";
    }
    return "hippy_js_error";
  }
  
  public void reportCheckUpdate(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int i = paramInt2;
    if (paramInt2 > 0) {
      i = paramInt2 * -1 - 10000;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong * -1L;
    }
    for (;;)
    {
      try
      {
        paramInt2 = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString1);
        if (i == 0)
        {
          paramLong = l;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("page", paramString1);
          ((JSONObject)localObject).put("page_ver", paramInt2);
          ((JSONObject)localObject).put("ret", paramLong);
          ((JSONObject)localObject).put("oper_type", paramInt1);
          ((JSONObject)localObject).put("errmsg", paramString2);
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(localObject);
          localObject = new HashMap();
          ((HashMap)localObject).put("page", paramString1);
          ((HashMap)localObject).put("page_ver", String.valueOf(paramInt2));
          ((HashMap)localObject).put("ret", String.valueOf(paramLong));
          ((HashMap)localObject).put("eventCode", operTypeToEventCode(paramInt1));
          ((HashMap)localObject).put("errmsg", paramString2);
          ((HashMap)localObject).put("totaltime", String.valueOf(l));
          baseReport(localJSONArray, (HashMap)localObject);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("reportCheckUpdate e:");
        paramString2.append(paramString1);
        QLog.e("HippyReporter", 1, paramString2.toString());
        return;
      }
      paramLong = i;
    }
  }
  
  public void reportException(String paramString, int paramInt1, int paramInt2, Exception paramException)
  {
    if (paramException != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("page", paramString);
        ((JSONObject)localObject2).put("page_ver", paramInt1);
        ((JSONObject)localObject2).put("ret", 0);
        ((JSONObject)localObject2).put("oper_type", paramInt2);
        ((JSONObject)localObject2).put("errmsg", getExceptionMessage(paramException));
        Object localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("page", paramString);
        ((HashMap)localObject2).put("page_ver", String.valueOf(paramInt1));
        ((HashMap)localObject2).put("ret", String.valueOf(0));
        ((HashMap)localObject2).put("oper_type", operTypeToEventCode(paramInt2));
        ((HashMap)localObject2).put("errmsg", getExceptionMessage(paramException));
        baseReport((JSONArray)localObject1, (HashMap)localObject2);
        localObject1 = (IHippyUtils)QRoute.api(IHippyUtils.class);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramInt2);
        CaughtExceptionReportProxy.e(((IHippyUtils)localObject1).createHippyException(((StringBuilder)localObject2).toString(), paramException), null);
        return;
      }
      catch (Throwable paramString)
      {
        paramException = new StringBuilder();
        paramException.append("reportException e:");
        paramException.append(paramString);
        QLog.e("HippyReporter", 1, paramException.toString());
      }
    }
  }
  
  public void reportGameCenterHippy(int paramInt)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", paramInt);
      ((JSONObject)localObject).put("oper_type", 9);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("ret", String.valueOf(paramInt));
      ((HashMap)localObject).put("eventCode", operTypeToEventCode(9));
      baseReport(localJSONArray, (HashMap)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGameCenterHippy e:");
      ((StringBuilder)localObject).append(localThrowable);
      QLog.e("HippyReporter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportHippyLoadResult(int paramInt1, String paramString, int paramInt2, HashMap<String, Object> paramHashMap, HashMap<String, Long> paramHashMap1)
  {
    int i;
    Object localObject1;
    label86:
    boolean bool1;
    label116:
    boolean bool2;
    label146:
    label173:
    long l;
    label206:
    JSONObject localJSONObject;
    Object localObject2;
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0) && (paramHashMap != null) && (paramHashMap.size() > 0))
    {
      label416:
      label439:
      try
      {
        if (!paramHashMap.containsKey("ret")) {
          break label647;
        }
        i = ((Integer)paramHashMap.get("ret")).intValue();
      }
      catch (Throwable paramString) {}
      if (!paramHashMap.containsKey("errMsg")) {
        break label668;
      }
      localObject1 = (String)paramHashMap.get("errMsg");
      if (!paramHashMap.containsKey("isPreload")) {
        break label674;
      }
      bool1 = ((Boolean)paramHashMap.get("isPreload")).booleanValue();
      if (!paramHashMap.containsKey("isPredraw")) {
        break label680;
      }
      bool2 = ((Boolean)paramHashMap.get("isPredraw")).booleanValue();
      if (!paramHashMap.containsKey("from")) {
        break label686;
      }
      paramHashMap = (String)paramHashMap.get("from");
      l = 0L;
      if (!paramHashMap1.containsKey("total")) {
        break label692;
      }
      l = ((Long)paramHashMap1.get("total")).longValue();
      break label692;
      localJSONObject = new JSONObject();
      localJSONObject.put("page", paramString);
      String str = "total";
      localJSONObject.put("page_ver", paramInt2);
      localJSONObject.put("ret", l);
      localJSONObject.put("oper_type", paramInt1);
      localJSONObject.put("errmsg", localObject1);
      localJSONObject.put("from", paramHashMap);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("isPreload", bool1);
      ((JSONObject)localObject2).put("isPredraw", bool2);
      localJSONObject.put("oper_data", localObject2);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("page", paramString);
      ((HashMap)localObject2).put("page_ver", String.valueOf(paramInt2));
      ((HashMap)localObject2).put("ret", String.valueOf(l));
      ((HashMap)localObject2).put("eventCode", operTypeToEventCode(paramInt1));
      ((HashMap)localObject2).put("errmsg", localObject1);
      ((HashMap)localObject2).put("from", paramHashMap);
      if (!bool1) {
        break label708;
      }
      paramInt1 = 1;
      ((HashMap)localObject2).put("isPreload", String.valueOf(paramInt1));
      if (!bool2) {
        break label713;
      }
      paramInt1 = 1;
      ((HashMap)localObject2).put("isPredraw", String.valueOf(paramInt1));
      paramHashMap = new JSONObject();
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      paramString = str;
    }
    for (;;)
    {
      if (paramHashMap1.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap1.next();
        if (!paramString.equals(((Map.Entry)localObject1).getKey()))
        {
          paramHashMap.put((String)((Map.Entry)localObject1).getKey(), ((Long)((Map.Entry)localObject1).getValue()).longValue());
          ((HashMap)localObject2).put(((Map.Entry)localObject1).getKey(), ((Long)((Map.Entry)localObject1).getValue()).toString());
        }
      }
      else
      {
        localJSONObject.put("cost_list", paramHashMap);
        paramString = new JSONArray();
        paramString.put(localJSONObject);
        try
        {
          baseReport(paramString, (HashMap)localObject2);
          return;
        }
        catch (Throwable paramString) {}
        paramHashMap = new StringBuilder();
        paramHashMap.append("reportHippyLoadResult e:");
        paramHashMap.append(paramString);
        QLog.e("HippyReporter", 1, paramHashMap.toString());
        return;
        return;
        label647:
        i = -1;
        int j = i;
        if (i <= 0) {
          break;
        }
        j = i * -1;
        break;
        label668:
        localObject1 = null;
        break label86;
        label674:
        bool1 = false;
        break label116;
        label680:
        bool2 = false;
        break label146;
        label686:
        paramHashMap = null;
        break label173;
        label692:
        if (j == 0) {
          break label206;
        }
        l = j;
        break label206;
        label708:
        paramInt1 = 0;
        break label416;
        label713:
        paramInt1 = 0;
        break label439;
      }
    }
  }
  
  public void reportOper(String paramString, int paramInt1, int paramInt2)
  {
    reportOper(paramString, paramInt1, paramInt2, 0, null);
  }
  
  public void reportOper(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("page", paramString1);
      ((JSONObject)localObject).put("page_ver", paramInt1);
      ((JSONObject)localObject).put("ret", paramInt3);
      ((JSONObject)localObject).put("oper_type", paramInt2);
      ((JSONObject)localObject).put("errmsg", paramString2);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("page", paramString1);
      ((HashMap)localObject).put("page_ver", String.valueOf(paramInt1));
      ((HashMap)localObject).put("ret", String.valueOf(paramInt3));
      ((HashMap)localObject).put("oper_type", operTypeToEventCode(paramInt2));
      ((HashMap)localObject).put("errmsg", paramString2);
      baseReport(localJSONArray, (HashMap)localObject);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportOper e:");
      paramString2.append(paramString1);
      QLog.e("HippyReporter", 1, paramString2.toString());
    }
  }
  
  public void reportPreDownloadOper(String paramString1, int paramInt1, int paramInt2, int paramInt3, JSONObject paramJSONObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("page", paramString1);
      ((JSONObject)localObject).put("page_ver", paramInt1);
      ((JSONObject)localObject).put("ret", paramInt3);
      ((JSONObject)localObject).put("oper_type", paramInt2);
      ((JSONObject)localObject).put("errmsg", paramString2);
      ((JSONObject)localObject).put("oper_data", paramJSONObject);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("page", paramString1);
      ((HashMap)localObject).put("page_ver", String.valueOf(paramInt1));
      ((HashMap)localObject).put("ret", String.valueOf(paramInt3));
      ((HashMap)localObject).put("eventCode", operTypeToEventCode(paramInt2));
      ((HashMap)localObject).put("errmsg", paramString2);
      if (paramJSONObject == null) {
        paramString1 = "";
      } else {
        paramString1 = paramJSONObject.toString();
      }
      ((HashMap)localObject).put("oper_data", paramString1);
      baseReport(localJSONArray, (HashMap)localObject);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("[reportPreDownloadOper] body:");
        paramString1.append(localJSONArray.toString());
        QLog.d("HippyReporter", 2, paramString1.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("reportOper e:");
      paramJSONObject.append(paramString1);
      QLog.e("HippyReporter", 1, paramJSONObject.toString());
    }
  }
  
  public void reportStepCrash(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", 0);
      ((JSONObject)localObject).put("oper_type", 7);
      paramString = new JSONArray();
      paramString.put(localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("ret", String.valueOf(0));
      ((HashMap)localObject).put("eventCode", operTypeToEventCode(7));
      baseReport(paramString, (HashMap)localObject);
      return;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportCrash e:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("HippyReporter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportStepTimeOut(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", 0);
      ((JSONObject)localObject).put("oper_type", 8);
      paramString = new JSONArray();
      paramString.put(localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("ret", String.valueOf(0));
      ((HashMap)localObject).put("eventCode", operTypeToEventCode(8));
      baseReport(paramString, (HashMap)localObject);
      return;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportCrash e:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("HippyReporter", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyReporter
 * JD-Core Version:    0.7.0.1
 */