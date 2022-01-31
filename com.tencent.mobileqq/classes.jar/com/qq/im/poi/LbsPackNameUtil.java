package com.qq.im.poi;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class LbsPackNameUtil
{
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString) <= 18) {
      return paramString;
    }
    while (a(paramString) > 18) {
      paramString = paramString.substring(0, paramString.length() - 1);
    }
    return paramString + "...";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!paramString2.startsWith(paramString1)) {
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString2 = paramString2.substring(paramString1.length(), paramString2.length());
    localStringBuilder.append(a(paramString1)).append(paramString2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackNameUtil
 * JD-Core Version:    0.7.0.1
 */