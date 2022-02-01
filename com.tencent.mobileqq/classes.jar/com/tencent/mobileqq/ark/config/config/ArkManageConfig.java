package com.tencent.mobileqq.ark.config.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ArkManageConfig
{
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("DialogConfig", 1, "getArkBoolConfig, dictConfigJsonString is empty");
      return false;
    }
    paramJSONObject = paramJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getArkBoolConfig, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("=%s");
      QLog.i("DialogConfig", 1, String.format(localStringBuilder.toString(), new Object[] { paramJSONObject }));
      return paramJSONObject.equals("true");
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("getArkBoolConfig, ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" is empty");
    QLog.i("DialogConfig", 1, paramJSONObject.toString());
    return false;
  }
  
  public static String b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      QLog.e("DialogConfig", 1, "getArkStringConfig, json is empty");
      return "";
    }
    paramJSONObject = paramJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getArkStringConfig, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("=%s");
      QLog.i("DialogConfig", 1, String.format(localStringBuilder.toString(), new Object[] { paramJSONObject }));
      return paramJSONObject;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("getArkStringConfig, ");
    paramJSONObject.append(paramString);
    paramJSONObject.append(" is empty");
    QLog.i("DialogConfig", 1, paramJSONObject.toString());
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.ArkManageConfig
 * JD-Core Version:    0.7.0.1
 */