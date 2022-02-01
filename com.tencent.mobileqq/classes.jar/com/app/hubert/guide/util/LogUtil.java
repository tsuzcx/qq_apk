package com.app.hubert.guide.util;

import android.text.TextUtils;
import java.util.Locale;

public class LogUtil
{
  private static final int NONE = 8;
  public static final int level = 8;
  private static final String tagPrefix = "NewbieGuide";
  
  public static void d(String paramString) {}
  
  public static void d(String paramString, Throwable paramThrowable) {}
  
  public static void e(String paramString) {}
  
  public static void e(String paramString, Throwable paramThrowable) {}
  
  private static String generateTag()
  {
    Object localObject = java.lang.Thread.currentThread().getStackTrace()[4];
    String str = ((StackTraceElement)localObject).getClassName();
    str = str.substring(str.lastIndexOf(".") + 1);
    localObject = String.format(Locale.CHINA, "%s.%s(L:%d)", new Object[] { str, ((StackTraceElement)localObject).getMethodName(), Integer.valueOf(((StackTraceElement)localObject).getLineNumber()) });
    if (TextUtils.isEmpty("NewbieGuide")) {
      return localObject;
    }
    return "NewbieGuide:" + (String)localObject;
  }
  
  public static void i(String paramString) {}
  
  public static void i(String paramString, Throwable paramThrowable) {}
  
  public static void v(String paramString) {}
  
  public static void v(String paramString, Throwable paramThrowable) {}
  
  public static void w(String paramString) {}
  
  public static void w(String paramString, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.app.hubert.guide.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */