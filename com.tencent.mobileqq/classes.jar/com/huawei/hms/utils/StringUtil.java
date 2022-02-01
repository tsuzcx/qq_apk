package com.huawei.hms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
  public static String addByteForNum(String paramString, int paramInt, char paramChar)
  {
    int i = paramString.length();
    if (i == paramInt) {
      return paramString;
    }
    if (i > paramInt) {
      return paramString.substring(i - paramInt);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    while (i < paramInt)
    {
      localStringBuffer.append(paramChar);
      i += 1;
    }
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  public static boolean checkVersion(String paramString)
  {
    return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(paramString).find();
  }
  
  public static int convertVersion2Integer(String paramString)
  {
    if (checkVersion(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length < 3) {
        return 0;
      }
      int j = Integer.parseInt(paramString[0]) * 10000000 + Integer.parseInt(paramString[1]) * 100000 + Integer.parseInt(paramString[2]) * 1000;
      int i = j;
      if (paramString.length == 4) {
        i = j + Integer.parseInt(paramString[3]);
      }
      return i;
    }
    return 0;
  }
  
  public static String objDesc(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */