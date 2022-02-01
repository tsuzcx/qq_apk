package com.huawei.hms.framework.network.grs.d;

import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static Map<String, d.a> a = new ConcurrentHashMap(16);
  
  public static d.a a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("map size of get is before:");
    localStringBuilder.append(a.size());
    Logger.v("RequestUtil", localStringBuilder.toString());
    paramString = (d.a)a.get(paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("map size of get is after:");
    localStringBuilder.append(a.size());
    Logger.v("RequestUtil", localStringBuilder.toString());
    return paramString;
  }
  
  public static void a(String paramString, d.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("map size of put is before:");
    localStringBuilder.append(a.size());
    Logger.v("RequestUtil", localStringBuilder.toString());
    a.put(paramString, parama);
    paramString = new StringBuilder();
    paramString.append("map size of put is after:");
    paramString.append(a.size());
    Logger.v("RequestUtil", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.d
 * JD-Core Version:    0.7.0.1
 */