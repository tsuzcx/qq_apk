package com.tencent.map.sdk.a;

import java.text.SimpleDateFormat;

public final class nl
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    if (paramString2 != null) {
      return paramString2.equals(paramString1);
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
    } while (i <= 0);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nl
 * JD-Core Version:    0.7.0.1
 */