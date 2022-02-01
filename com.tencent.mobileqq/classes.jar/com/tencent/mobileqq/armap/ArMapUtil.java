package com.tencent.mobileqq.armap;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArMapUtil
{
  static SimpleDateFormat a;
  static SimpleDateFormat b;
  public static boolean c = false;
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    long l1;
    try
    {
      l1 = a.parse(paramString).getTime();
    }
    catch (Exception localException)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArMapUtil", 2, "", localException);
        l1 = l2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data2Millis, date = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",millis = ");
      localStringBuilder.append(l1);
      QLog.d("ArMapUtil", 2, localStringBuilder.toString());
    }
    return l1;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    MobileQQ localMobileQQ = paramAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("sp_ar_map");
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil
 * JD-Core Version:    0.7.0.1
 */