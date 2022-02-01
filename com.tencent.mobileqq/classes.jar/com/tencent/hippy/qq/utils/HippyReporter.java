package com.tencent.hippy.qq.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyReporter
{
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
  
  private void baseReport(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("head", getReportHeadData());
        localJSONObject.put("body", paramJSONArray);
        QLog.i("HippyReporter", 1, "baseReport data:" + localJSONObject);
        paramJSONArray = GameCenterUnissoHandler.a();
        if (paramJSONArray != null)
        {
          paramJSONArray.a(localJSONObject);
          return;
        }
      }
      catch (Throwable paramJSONArray)
      {
        QLog.e("HippyReporter", 1, "baseReport e:" + paramJSONArray);
      }
    }
  }
  
  public static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface)) {
          return (AppInterface)localObject;
        }
      }
      else if ((localObject instanceof AppInterface))
      {
        return (AppInterface)localObject;
      }
    }
    return null;
  }
  
  public static HippyReporter getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new HippyReporter();
      }
      return sInstance;
    }
    finally {}
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
  
  protected JSONObject getReportHeadData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mobile_model", Build.MODEL);
      localJSONObject.put("manufacturer", Build.BRAND);
      localJSONObject.put("os_ver", Build.VERSION.SDK_INT);
      localJSONObject.put("cpu_bit", 32);
      localJSONObject.put("qq_ver", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
      localJSONObject.put("is_public", 1);
      localJSONObject.put("resolution", DeviceInfoUtil.i() + "*" + DeviceInfoUtil.j());
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
      localJSONObject.put("net", localObject1);
      localObject2 = HippyQQLibraryManager.getInstance().getLibraryVersions();
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject1 = new JSONObject();
        localObject2 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue());
        }
        localJSONObject.put("hippy_info", localObject1);
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject1 != null)
      {
        localJSONObject.put("uin", ((AppRuntime)localObject1).getAccount());
        return localJSONObject;
      }
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
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
    if (paramLong < 0L) {
      paramLong = -1L * paramLong;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("page", paramString1);
        localJSONObject.put("page_ver", UpdateSetting.getInstance().getModuleVersion(paramString1));
        if (i == 0)
        {
          localJSONObject.put("ret", paramLong);
          localJSONObject.put("oper_type", paramInt1);
          localJSONObject.put("errmsg", paramString2);
          paramString1 = new JSONArray();
          paramString1.put(localJSONObject);
          baseReport(paramString1);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("HippyReporter", 1, "reportCheckUpdate e:" + paramString1);
        return;
      }
      paramLong = i;
    }
  }
  
  public void reportException(String paramString, int paramInt1, int paramInt2, Exception paramException)
  {
    if ((paramException == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page", paramString);
      localJSONObject.put("page_ver", paramInt1);
      localJSONObject.put("ret", 0);
      localJSONObject.put("oper_type", paramInt2);
      localJSONObject.put("errmsg", getExceptionMessage(paramException));
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
      baseReport(localJSONArray);
      CaughtExceptionReport.a(new QQHippyException(paramString + "_" + paramInt1 + "_" + paramInt2, paramException));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("HippyReporter", 1, "reportException e:" + paramString);
    }
  }
  
  public void reportGameCenterHippy(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("oper_type", 9);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
      baseReport(localJSONArray);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HippyReporter", 1, "reportGameCenterHippy e:" + localThrowable);
    }
  }
  
  public void reportHippyLoadResult(int paramInt1, String paramString, int paramInt2, HashMap<String, Object> paramHashMap, HashMap<String, Long> paramHashMap1)
  {
    if ((paramHashMap1 == null) || (paramHashMap1.size() <= 0) || (paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return;
    }
    for (;;)
    {
      int i;
      String str;
      JSONObject localJSONObject;
      try
      {
        if (!paramHashMap.containsKey("ret")) {
          break label421;
        }
        i = ((Integer)paramHashMap.get("ret")).intValue();
      }
      catch (Throwable paramString)
      {
        QLog.e("HippyReporter", 1, "reportHippyLoadResult e:" + paramString);
        return;
      }
      if (paramHashMap.containsKey("errMsg"))
      {
        str = (String)paramHashMap.get("errMsg");
        if (paramHashMap.containsKey("isPreload"))
        {
          bool1 = ((Boolean)paramHashMap.get("isPreload")).booleanValue();
          if (!paramHashMap.containsKey("isPredraw")) {
            break label439;
          }
          bool2 = ((Boolean)paramHashMap.get("isPredraw")).booleanValue();
          if (!paramHashMap.containsKey("from")) {
            break label445;
          }
          paramHashMap = (String)paramHashMap.get("from");
          l = 0L;
          if (paramHashMap1.containsKey("total")) {
            l = ((Long)paramHashMap1.get("total")).longValue();
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("page", paramString);
          localJSONObject.put("page_ver", paramInt2);
          if (i != 0) {
            break label451;
          }
          localJSONObject.put("ret", l);
          localJSONObject.put("oper_type", paramInt1);
          localJSONObject.put("errmsg", str);
          localJSONObject.put("from", paramHashMap);
          paramString = new JSONObject();
          paramString.put("isPreload", bool1);
          paramString.put("isPredraw", bool2);
          localJSONObject.put("oper_data", paramString);
          paramString = new JSONObject();
          paramHashMap = paramHashMap1.entrySet().iterator();
          if (!paramHashMap.hasNext()) {
            break label459;
          }
          paramHashMap1 = (Map.Entry)paramHashMap.next();
          if ("total".equals(paramHashMap1.getKey())) {
            continue;
          }
          paramString.put((String)paramHashMap1.getKey(), ((Long)paramHashMap1.getValue()).longValue());
          continue;
          label421:
          i = -1;
          break label493;
        }
      }
      else
      {
        str = null;
        continue;
      }
      boolean bool1 = false;
      continue;
      label439:
      boolean bool2 = false;
      continue;
      label445:
      paramHashMap = null;
      continue;
      label451:
      long l = i;
      continue;
      label459:
      localJSONObject.put("cost_list", paramString);
      paramString = new JSONArray();
      paramString.put(localJSONObject);
      baseReport(paramString);
      label493:
      while (i <= 0) {
        break;
      }
      i *= -1;
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page", paramString1);
      localJSONObject.put("page_ver", paramInt1);
      localJSONObject.put("ret", paramInt3);
      localJSONObject.put("oper_type", paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("errmsg", paramString2);
      }
      paramString1 = new JSONArray();
      paramString1.put(localJSONObject);
      baseReport(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("HippyReporter", 1, "reportOper e:" + paramString1);
    }
  }
  
  public void reportPreDownloadOper(String paramString1, int paramInt1, int paramInt2, int paramInt3, JSONObject paramJSONObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("page", paramString1);
        localJSONObject.put("page_ver", paramInt1);
        localJSONObject.put("ret", paramInt3);
        localJSONObject.put("oper_type", paramInt2);
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("errmsg", paramString2);
        }
        if (paramJSONObject != null) {
          localJSONObject.put("oper_data", paramJSONObject);
        }
        paramString1 = new JSONArray();
        paramString1.put(localJSONObject);
        baseReport(paramString1);
        if (QLog.isColorLevel())
        {
          QLog.d("HippyReporter", 2, "[reportPreDownloadOper] body:" + paramString1.toString());
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("HippyReporter", 1, "reportOper e:" + paramString1);
      }
    }
  }
  
  public void reportStepCrash(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("oper_type", 7);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      baseReport(localJSONArray);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("HippyReporter", 1, "reportCrash e:" + paramString);
    }
  }
  
  public void reportStepTimeOut(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("ret", 0);
      paramString.put("oper_type", 8);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      baseReport(localJSONArray);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("HippyReporter", 1, "reportCrash e:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyReporter
 * JD-Core Version:    0.7.0.1
 */