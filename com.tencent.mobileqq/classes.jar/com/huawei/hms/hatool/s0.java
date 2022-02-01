package com.huawei.hms.hatool;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public abstract class s0
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
      label30:
      break label30;
    }
    y.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
    return 0L;
  }
  
  public static Pair<String, String> a(String paramString)
  {
    if (!"_default_config_tag".equals(paramString))
    {
      Object localObject2 = paramString.split("-");
      Object localObject1;
      if (localObject2.length > 2)
      {
        localObject1 = localObject2[(localObject2.length - 1)];
        int i = localObject1.length();
        localObject2 = paramString.substring(0, paramString.length() - i - 1);
        paramString = localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2[0];
        paramString = localObject2[1];
      }
      return new Pair(localObject1, paramString);
    }
    return new Pair(paramString, "");
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "alltype";
          }
          return "diffprivacy";
        }
        return "preins";
      }
      return "maint";
    }
    return "oper";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ("_default_config_tag".equals(paramString1)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ("_default_config_tag".equals(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("_default_config_tag#");
      paramString1.append(paramString3);
      return paramString1.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static Set<String> a(Set<String> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() != 0))
    {
      HashSet localHashSet = new HashSet();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if (!"_default_config_tag".equals(str))
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("-");
          ((StringBuilder)localObject1).append("oper");
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append("maint");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("-");
          localStringBuilder.append("diffprivacy");
          str = localStringBuilder.toString();
          localHashSet.add(localObject1);
          localHashSet.add(localObject2);
          localHashSet.add(str);
        }
        else
        {
          localHashSet.add("_default_config_tag");
        }
      }
      return localHashSet;
    }
    return new HashSet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.s0
 * JD-Core Version:    0.7.0.1
 */