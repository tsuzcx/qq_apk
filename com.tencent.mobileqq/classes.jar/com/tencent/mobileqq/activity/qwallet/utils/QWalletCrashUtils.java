package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QWalletCrashUtils
{
  public static void a(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = BaseApplicationImpl.sApplication.getClassLoader();
      if (localClassLoader == null) {
        return;
      }
      Class localClass = localClassLoader.loadClass("cooperation.qwallet.plugin.QWalletPluginProxyActivity");
      long l = localClass.getField("sReporteSeq").getLong(localClass);
      if (l > 0L)
      {
        localClassLoader.loadClass("com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil").getMethod("endReport", new Class[] { Long.TYPE, String.class, String.class, Integer.TYPE, String.class }).invoke(null, new Object[] { Long.valueOf(l), "crash", null, Integer.valueOf(668815), paramString });
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletCrashUtils
 * JD-Core Version:    0.7.0.1
 */