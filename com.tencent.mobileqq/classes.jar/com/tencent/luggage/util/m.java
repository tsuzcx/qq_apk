package com.tencent.luggage.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class m
{
  public static String a(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return "";
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() >= 0))
    {
      if (paramString2.length() < 0) {
        return false;
      }
      if (paramString2.length() > paramString1.length()) {
        return false;
      }
      if (paramString2.equalsIgnoreCase(paramString1.substring(0, paramString2.length()))) {
        return true;
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf('?');
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static Map<String, String> c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    int i = paramString.indexOf('?');
    if (i < 0) {
      return localHashMap;
    }
    i += 1;
    int j = paramString.lastIndexOf('&');
    int k = paramString.lastIndexOf('#');
    if (k < 0) {
      paramString = paramString.substring(i, paramString.length());
    } else if (k > j)
    {
      if (i > k) {
        paramString = paramString.substring(i, paramString.length());
      } else {
        paramString = paramString.substring(i, k);
      }
    }
    else {
      paramString = paramString.substring(i, paramString.length());
    }
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    j = 0;
    int m = paramString.length();
    for (;;)
    {
      int n = paramString.indexOf('&', j);
      if (n != -1) {
        i = n;
      } else {
        i = m;
      }
      int i1 = paramString.indexOf('=', j);
      if (i1 <= i)
      {
        k = i1;
        if (i1 != -1) {}
      }
      else
      {
        k = i;
      }
      String str2 = Uri.decode(paramString.substring(j, k));
      String str1;
      if (k == i) {
        str1 = "";
      } else {
        str1 = paramString.substring(k + 1, i);
      }
      localHashMap.put(str2, str1);
      if (n == -1) {
        break;
      }
      j = n + 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.m
 * JD-Core Version:    0.7.0.1
 */