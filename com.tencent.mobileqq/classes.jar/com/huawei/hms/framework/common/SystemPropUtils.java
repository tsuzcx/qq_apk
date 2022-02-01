package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class SystemPropUtils
{
  private static final String TAG = "SystemPropUtils";
  
  public static String getProperty(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      try
      {
        paramString3 = Class.forName(paramString3);
        paramString1 = (String)paramString3.getMethod(paramString1, new Class[] { String.class, String.class }).invoke(paramString3, new Object[] { paramString2, paramString4 });
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Logger.e(TAG, "getProperty catch exception: ", paramString1);
        return paramString4;
      }
    }
    Logger.w(TAG, "reflect class for method has exception.");
    return paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.SystemPropUtils
 * JD-Core Version:    0.7.0.1
 */