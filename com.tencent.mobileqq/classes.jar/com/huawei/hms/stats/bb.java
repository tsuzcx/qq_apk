package com.huawei.hms.stats;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public abstract class bb
{
  public static long a(String paramString, long paramLong)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.getDefault());
      paramLong = paramString.parse(paramString.format(Long.valueOf(paramLong))).getTime();
      return paramLong;
    }
    catch (ParseException paramString)
    {
      af.c("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
    }
    return 0L;
  }
  
  public static Pair<String, String> a(String paramString)
  {
    if (!"_default_config_tag".equals(paramString))
    {
      Object localObject = paramString.split("-");
      if (localObject.length > 2)
      {
        localObject = localObject[(localObject.length - 1)];
        int i = ((String)localObject).length();
        paramString = paramString.substring(0, paramString.length() - i - 1);
      }
      for (;;)
      {
        return new Pair(paramString, localObject);
        paramString = localObject[0];
        localObject = localObject[1];
      }
    }
    return new Pair(paramString, "");
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "alltype";
    case 2: 
      return "preins";
    case 1: 
      return "maint";
    case 3: 
      return "diffprivacy";
    }
    return "oper";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ("_default_config_tag".equals(paramString1)) {
      return paramString1;
    }
    return paramString1 + "-" + paramString2;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ("_default_config_tag".equals(paramString1)) {
      return "_default_config_tag#" + paramString3;
    }
    return paramString1 + "-" + paramString2 + "#" + paramString3;
  }
  
  public static Set<String> a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {
      return new HashSet();
    }
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str3 = (String)paramSet.next();
      if (!"_default_config_tag".equals(str3))
      {
        String str1 = str3 + "-" + "oper";
        String str2 = str3 + "-" + "maint";
        str3 = str3 + "-" + "diffprivacy";
        localHashSet.add(str1);
        localHashSet.add(str2);
        localHashSet.add(str3);
      }
      else
      {
        localHashSet.add("_default_config_tag");
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bb
 * JD-Core Version:    0.7.0.1
 */