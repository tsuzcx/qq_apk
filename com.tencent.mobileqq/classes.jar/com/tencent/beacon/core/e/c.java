package com.tencent.beacon.core.e;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  public static String a(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label23;
      }
      str1 = str2;
    }
    label23:
    do
    {
      return str1;
      if (!e(paramString.trim())) {
        break;
      }
      paramString = paramString.trim();
      str1 = paramString;
    } while (paramString.length() <= 16);
    return paramString.substring(0, 16);
    d.i("[core] channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    String str = b(paramString, paramMap);
    paramMap = str;
    if (str.length() > 46080)
    {
      paramString = "[event] eventName: " + paramString + " params > 45K";
      com.tencent.beacon.core.d.i.a().a("104", paramString);
      i.a(paramString);
      paramMap = null;
    }
    return paramMap;
  }
  
  public static String a(Map<String, String> paramMap)
  {
    return b(null, paramMap);
  }
  
  public static String b(String paramString)
  {
    Object localObject;
    if (j.b(paramString)) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = paramString.replace('|', '_').trim();
      if (str.length() == 0)
      {
        d.b("[core] eventName is invalid!! eventName length == 0!", new Object[0]);
        return null;
      }
      if (!e(str)) {
        break;
      }
      localObject = str;
    } while (str.length() <= 128);
    d.i("[core] eventName length should be less than 128! eventName:" + paramString, new Object[0]);
    return str.substring(0, 128);
    d.b("[core] eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
    return null;
  }
  
  public static String b(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (((Set)localObject).size() > 50) {
      d.i("[core] map size should <= 50!", new Object[0]);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = ((Set)localObject).iterator();
    String str2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        int i = str2.trim().length();
        if ((i > 0) && (e(str2)))
        {
          String str1 = str2.trim();
          localObject = str1;
          if (i > 64)
          {
            str1 = str1.substring(0, 64);
            localObject = str1;
            if (paramString != null)
            {
              com.tencent.beacon.core.d.i.a().a("102", "[event] eventName: " + paramString + ", key: " + str2 + " should be less than 64!");
              localObject = str1;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append(((String)localObject).replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
          localStringBuilder1.append("=");
          localObject = (String)paramMap.get(str2);
          if (localObject == null) {
            continue;
          }
          localObject = ((String)localObject).trim();
          if (((String)localObject).length() <= 10240) {
            break label474;
          }
          localStringBuilder2.append(str2).append(",");
          localObject = ((String)localObject).substring(0, 10240);
        }
      }
    }
    label474:
    for (;;)
    {
      localStringBuilder1.append(((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
      break;
      d.i("[core] '%s' should be ASCII code in 32-126!", new Object[] { str2 });
      if (paramString == null) {
        break;
      }
      com.tencent.beacon.core.d.i.a().a("102", "[event] eventName: " + paramString + ", key: " + str2 + " should be ASCII code in 32-126!");
      break;
      if (!localStringBuilder2.toString().isEmpty())
      {
        paramString = "[event] eventName: " + paramString + ", key: " + localStringBuilder2.toString() + "'s value > 10K.";
        com.tencent.beacon.core.d.i.a().a("103", paramString);
        i.a(paramString);
      }
      paramString = "";
      if (localStringBuilder1.length() > 0) {
        paramString = localStringBuilder1.substring(1);
      }
      localStringBuilder1.setLength(0);
      return paramString;
    }
  }
  
  public static String c(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "DefaultPageID";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 50);
    return paramString.substring(0, 50);
  }
  
  public static String d(String paramString)
  {
    String str = paramString.replace('|', '_').trim();
    if (e(str))
    {
      if (str.length() < 5) {
        d.i("[core] userID length should < 5!", new Object[0]);
      }
      paramString = str;
      if (str.length() > 128) {
        paramString = str.substring(0, 128);
      }
      return paramString;
    }
    d.i("[core] userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
  }
  
  public static boolean e(String paramString)
  {
    boolean bool = true;
    int i = paramString.length();
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.c
 * JD-Core Version:    0.7.0.1
 */