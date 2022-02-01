package com.tencent.ilivesdk.pluginloaderservice.utils;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;

public class LogUtil
{
  private static LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private static String jdField_a_of_type_JavaLangString = "%s";
  
  public static void a()
  {
    jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = null;
  }
  
  public static void a(String paramString, LogInterface paramLogInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | %s");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramLogInterface;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
    if (localLogInterface != null) {
      localLogInterface.d(String.format(jdField_a_of_type_JavaLangString, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
    if (localLogInterface != null) {
      localLogInterface.i(String.format(jdField_a_of_type_JavaLangString, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
    if (localLogInterface != null) {
      localLogInterface.e(String.format(jdField_a_of_type_JavaLangString, new Object[] { paramString1 }), paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.utils.LogUtil
 * JD-Core Version:    0.7.0.1
 */