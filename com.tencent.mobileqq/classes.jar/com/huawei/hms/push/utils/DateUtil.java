package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil
{
  public static String parseMilliSecondToString(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    try
    {
      paramLong = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(paramLong);
      return paramLong;
    }
    catch (Exception paramLong)
    {
      HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", paramLong);
    }
    return null;
  }
  
  public static long parseUtcToMillisecond(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    String str = paramString.substring(0, paramString.indexOf("."));
    paramString = paramString.substring(paramString.indexOf("."));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 4));
    localStringBuilder.append("Z");
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localSimpleDateFormat.parse(localStringBuilder.toString()).getTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.utils.DateUtil
 * JD-Core Version:    0.7.0.1
 */