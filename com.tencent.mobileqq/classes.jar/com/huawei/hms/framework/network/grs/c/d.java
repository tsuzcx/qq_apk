package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static Map<String, d.a> a = new ConcurrentHashMap(16);
  
  public static d.a a(String paramString)
  {
    Logger.v("RequestUtil", "map size of get is before:" + a.size());
    paramString = (d.a)a.get(paramString);
    Logger.v("RequestUtil", "map size of get is after:" + a.size());
    return paramString;
  }
  
  public static void a(String paramString, d.a parama)
  {
    Logger.v("RequestUtil", "map size of put is before:" + a.size());
    a.put(paramString, parama);
    Logger.v("RequestUtil", "map size of put is after:" + a.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.d
 * JD-Core Version:    0.7.0.1
 */