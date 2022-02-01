package com.tencent.biz.qqcircle.flutter;

import android.os.Build;
import android.os.Looper;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class QCircleFlutterUtils
{
  private static volatile boolean b = false;
  private static volatile boolean c = false;
  private static final String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleHostConstants.AppConstants.SDCARD_ROOT());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    d = localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "QQCirSearchDetailWidget");
    localHashMap.put("type", "launch");
    localHashMap.put("errorCode", String.valueOf(paramInt));
    HostDataTransUtils.reportStatisticPerformance(LoginData.a().c(), "qcircle_flutter_report", true, 0L, 0L, localHashMap, null);
  }
  
  public static boolean a()
  {
    if (!b)
    {
      QLog.w("QCircleFlutterUtils", 1, "[isFlutterPreloaded] not preloaded");
      a(5);
    }
    return b;
  }
  
  public static boolean b()
  {
    if (c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCircleFlutterUtils", 2, "[isFlutterEnabled] already enabled");
      }
      a(0);
      return true;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      if (!QCircleConfigHelper.v())
      {
        QLog.w("QCircleFlutterUtils", 1, "[isFlutterEnabled] master switch off");
        a(1);
        return false;
      }
      int i = QCircleConfigHelper.a("QZoneSetting", "flutter_memory_heap_limit", Integer.valueOf(104857600)).intValue();
      StringBuilder localStringBuilder;
      if (Runtime.getRuntime().maxMemory() < i)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isFlutterEnable] heap limit not supported, heap=");
        localStringBuilder.append(Runtime.getRuntime().maxMemory());
        QLog.w("QCircleFlutterUtils", 1, localStringBuilder.toString());
        a(2);
        return false;
      }
      if (QCircleConfigHelper.a("QZoneSetting", "flutter_disable_models", "").contains(Build.MODEL))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isFlutterEnable] model not supported, ");
        localStringBuilder.append(Build.MODEL);
        QLog.w("QCircleFlutterUtils", 1, localStringBuilder.toString());
        a(4);
        return false;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isFlutterEnabled] enabled, cost=");
        localStringBuilder.append(l2 - l1);
        QLog.d("QCircleFlutterUtils", 2, localStringBuilder.toString());
      }
      a(0);
      c = true;
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleFlutterUtils", 1, "[isFlutterEnabled] ", localException);
      a(6);
    }
    return false;
  }
  
  public static void c()
  {
    if ((!a) && (Looper.myLooper() == Looper.getMainLooper())) {
      throw new AssertionError();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFlutterUtils", 2, "[preloadFlutter] ");
    }
    if ((QCircleHostConstants._AppSetting.isDebugVersion()) && (HostFileUtils.fileExists(d))) {
      b = true;
    }
    if (b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCircleFlutterUtils", 2, "[preloadFlutter] already preloaded");
      }
      return;
    }
    if (!b())
    {
      QLog.w("QCircleFlutterUtils", 1, "[preloadFlutter] flutter not enabled");
      return;
    }
    HostStaticInvokeHelper.installQFlutter(new QCircleFlutterUtils.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils
 * JD-Core Version:    0.7.0.1
 */