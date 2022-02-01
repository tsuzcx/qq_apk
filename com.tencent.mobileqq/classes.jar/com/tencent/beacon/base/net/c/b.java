package com.tencent.beacon.base.net.c;

import android.text.TextUtils;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.base.util.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  public static String a = "https://otheve.beacon.qq.com/analytics/upload";
  public static String b = "https://othstr.beacon.qq.com/analytics/upload";
  public static String c = "oth.eve.mdt.qq.com";
  public static String d = "oth.str.mdt.qq.com";
  private static boolean e = false;
  
  public static String a(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return "";
      }
      if (paramString.contains("https")) {
        str = "https://";
      } else {
        str = "http://";
      }
      int i = paramString.indexOf(str);
      if (i == -1) {
        return paramString;
      }
      int j = paramString.indexOf("/", str.length());
      String str = paramString.substring(i + str.length(), j);
      i = str.indexOf(":");
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
      return paramString;
    }
    return "";
  }
  
  public static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return c;
    }
    return a;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      d = paramString1;
      b = b.replace("othstr.beacon.qq.com", paramString1);
      e = true;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      c = paramString2;
      a = a.replace("otheve.beacon.qq.com", paramString2);
      e = true;
    }
  }
  
  public static String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return d;
    }
    return b;
  }
  
  public static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (e) {
        return;
      }
      c = paramString;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
    Matcher localMatcher = ((Pattern)localObject).matcher(paramString1);
    localObject = ((Pattern)localObject).matcher(paramString2);
    if ((localMatcher.matches()) && (((Matcher)localObject).matches()))
    {
      d = paramString1;
      b = b.replace("othstr.beacon.qq.com", paramString1);
      c = paramString2;
      a = a.replace("otheve.beacon.qq.com", paramString2);
      c.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", new Object[] { d, b, c, a });
      return;
    }
    e.a("[event url] set report ip is not valid IP address!");
  }
  
  public static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (e) {
        return;
      }
      a = paramString;
    }
  }
  
  public static void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (e) {
        return;
      }
      d = paramString;
    }
  }
  
  public static void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (e) {
        return;
      }
      b = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.c.b
 * JD-Core Version:    0.7.0.1
 */