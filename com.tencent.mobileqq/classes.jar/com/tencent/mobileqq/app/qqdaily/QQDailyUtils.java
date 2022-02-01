package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.Map;
import org.json.JSONObject;

public class QQDailyUtils
{
  public static final int a = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  private static long b = 0L;
  
  public static int a(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return DisplayUtil.a(paramContext, paramInt);
  }
  
  private static long a()
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = b;
    if ((l2 != 0L) && (86400L + l2 > l1)) {
      return l2;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    l1 = localCalendar.getTimeInMillis() / 1000L;
    b = l1;
    return l1;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}");
    paramString = localStringBuilder.toString();
    try
    {
      paramString = new JSONObject(paramString).get("metaData").toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQDailyUtils", 2, paramString, new Object[0]);
      }
    }
    return "";
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong > a();
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    boolean bool2 = false;
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      String str1 = (String)paramMap.get("appname");
      String str2 = (String)paramMap.get("appview");
      String str3 = (String)paramMap.get("appversion");
      paramMap = (String)paramMap.get("metaData");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("appName: ");
        localStringBuilder.append(str1);
        localStringBuilder.append("\nappView: ");
        localStringBuilder.append(str2);
        localStringBuilder.append("\nappVersion: ");
        localStringBuilder.append(str3);
        localStringBuilder.append("\nmetaData: ");
        localStringBuilder.append(paramMap);
        QLog.d("QQDailyUtils", 2, localStringBuilder.toString());
      }
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str2))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(str3))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramMap)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyUtils", 2, "param is null");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyUtils
 * JD-Core Version:    0.7.0.1
 */