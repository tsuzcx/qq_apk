package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.common.app.BaseApplicationImpl;
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
      localClassLoader.loadClass("cooperation.qwallet.plugin.QWalletPluginProxyActivity").getMethod("handleNoCatchCrash", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return;
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