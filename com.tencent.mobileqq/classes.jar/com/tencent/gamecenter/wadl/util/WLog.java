package com.tencent.gamecenter.wadl.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class WLog
{
  private static String a(String paramString)
  {
    Object localObject = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (!paramString.startsWith("##@"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("##@");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, a(paramString2));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, a(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.WLog
 * JD-Core Version:    0.7.0.1
 */