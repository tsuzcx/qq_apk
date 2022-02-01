package com.tencent.beacon.core.c.a;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.i;
import com.tencent.beacon.core.e.j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  public static String a = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
  public static String b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
  public static String c = "oth.eve.mdt.qq.com";
  public static String d = "oth.str.mdt.qq.com";
  
  public static String a(String paramString)
  {
    return "http://" + paramString + "/analytics/upload";
  }
  
  public static String a(boolean paramBoolean, String paramString)
  {
    d.a("[event url] getStrategyUrl, isHttpMode: %s, httpUrl: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (j.b(paramString))
    {
      if (paramBoolean) {
        return b;
      }
      return d;
    }
    if (paramBoolean) {
      return paramString;
    }
    return b(paramString);
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    d.a("[event url] getRequestUrl, isHttpMode: %s, isRealtimeTest: %s, httpUrl: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString });
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return "http://183.36.108.226:8080/analytics/upload";
      }
      return "183.36.108.226";
    }
    if (j.b(paramString))
    {
      if (paramBoolean1) {
        return a;
      }
      return c;
    }
    if (paramBoolean1) {
      return paramString;
    }
    return b(paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
    Matcher localMatcher = ((Pattern)localObject).matcher(paramString1);
    localObject = ((Pattern)localObject).matcher(paramString2);
    if ((!localMatcher.matches()) || (!((Matcher)localObject).matches()))
    {
      i.a("[event url] set report ip is not valid IP address!");
      return;
    }
    d = paramString1;
    b = b.replace("oth.str.mdt.qq.com", paramString1);
    c = paramString2;
    a = a.replace("oth.eve.mdt.qq.com", paramString2);
    d.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", new Object[] { d, b, c, a });
  }
  
  private static String b(String paramString)
  {
    String str1;
    if ((paramString == null) || ("".equals(paramString)))
    {
      str1 = "";
      return str1;
    }
    if (paramString.contains("https")) {}
    for (String str2 = "https://";; str2 = "http://")
    {
      int i = paramString.indexOf(str2);
      str1 = paramString;
      if (i == -1) {
        break;
      }
      int j = paramString.indexOf(":", str2.length());
      return paramString.substring(str2.length() + i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c.a.b
 * JD-Core Version:    0.7.0.1
 */