package com.tencent.luggage.wxa.nq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jz.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static Map<String, c> a = new ConcurrentHashMap();
  private static Map<String, com.tencent.luggage.wxa.qy.c> b = new HashMap();
  private static ArrayList<String> c = new ArrayList();
  private static Map<String, Boolean> d = new ConcurrentHashMap();
  
  public static void a(String paramString)
  {
    o.d("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    a.clear();
    b.a(paramString);
    d.put(paramString, Boolean.valueOf(true));
  }
  
  public static void a(String paramString, c paramc)
  {
    a.put(paramString, paramc);
  }
  
  public static void a(String paramString, com.tencent.luggage.wxa.qy.c paramc)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      return;
    }
    if (paramc == null)
    {
      o.b("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      return;
    }
    if (b.containsKey(paramString)) {
      d(paramString);
    }
    o.e("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    b.put(paramString, paramc);
    if (!c.contains(paramString)) {
      c.add(paramString);
    }
    com.tencent.luggage.wxa.qy.a.a.a(paramc);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    d.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void b(String paramString)
  {
    o.d("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.b(paramString);
    a.clear();
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.luggage.wxa.qy.c)b.remove(localObject);
      if (localObject != null) {
        com.tencent.luggage.wxa.qy.a.a.c((com.tencent.luggage.wxa.qy.c)localObject);
      }
    }
    b.clear();
    c.clear();
    d.remove(paramString);
  }
  
  public static c c(String paramString)
  {
    return (c)a.get(paramString);
  }
  
  public static void d(String paramString)
  {
    if (!b.containsKey(paramString))
    {
      o.b("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      return;
    }
    o.e("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    c.remove(paramString);
    paramString = (com.tencent.luggage.wxa.qy.c)b.remove(paramString);
    if (paramString != null) {
      com.tencent.luggage.wxa.qy.a.a.c(paramString);
    }
  }
  
  public static boolean e(String paramString)
  {
    if (!d.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)d.get(paramString)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nq.a
 * JD-Core Version:    0.7.0.1
 */