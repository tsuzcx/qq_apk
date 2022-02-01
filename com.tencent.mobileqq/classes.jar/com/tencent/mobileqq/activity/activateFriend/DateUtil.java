package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil
{
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return "";
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd");
  }
  
  private static boolean a(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE);
    return paramString.format(localDate).equals(paramString.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.DateUtil
 * JD-Core Version:    0.7.0.1
 */