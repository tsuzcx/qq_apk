package com.tencent.featuretoggle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
  
  public static long a(String paramString)
  {
    try
    {
      long l = a.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static String a()
  {
    try
    {
      String str = a.format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(String paramString, long paramLong)
  {
    return new SimpleDateFormat(paramString, Locale.CHINA).format(new Date(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.TimeUtil
 * JD-Core Version:    0.7.0.1
 */