package com.tencent.beacon.base.net.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.e;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.RequestPackage;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;

public final class d
{
  private static Map<String, String> a;
  
  public static RequestPackage a(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString)
  {
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    f localf = f.p();
    RequestPackage localRequestPackage = new RequestPackage();
    localRequestPackage.model = Build.MODEL;
    localRequestPackage.osVersion = localf.z();
    localRequestPackage.platformId = localc.g();
    localRequestPackage.appkey = paramString;
    localRequestPackage.appVersion = b.a();
    localRequestPackage.sdkId = localc.h();
    localRequestPackage.sdkVersion = localc.i();
    localRequestPackage.cmd = paramInt;
    localRequestPackage.encryType = 3;
    localRequestPackage.zipType = 2;
    localRequestPackage.sBuffer = paramArrayOfByte;
    localRequestPackage.reserved = b(paramMap);
    return localRequestPackage;
  }
  
  public static Map<String, String> a()
  {
    try
    {
      if (a == null)
      {
        a = new HashMap(4);
        a.put("wup_version", "3.0");
        a.put("TYPE_COMPRESS", String.valueOf(2));
        a.put("encr_type", "rsapost");
        localObject1 = g.b();
        if (localObject1 != null) {
          a.put("bea_key", ((g)localObject1).d());
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  @Nullable
  public static Map<String, String> a(String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = (String)localEntry.getKey();
      int j = paramMap.trim().length();
      Object localObject1;
      Object localObject2;
      if ((j > 0) && (a(paramMap)))
      {
        localObject1 = paramMap.trim();
        paramMap = (Map<String, String>)localObject1;
        if (j > 64)
        {
          paramMap = ((String)localObject1).substring(0, 64);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[event] eventName: ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(", key: ");
          ((StringBuilder)localObject1).append(paramMap);
          ((StringBuilder)localObject1).append(" should be less than 64!");
          localObject1 = ((StringBuilder)localObject1).toString();
          com.tencent.beacon.a.b.d.b().a("102", (String)localObject1);
          e.a((String)localObject1);
        }
        localObject2 = paramMap.replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
        paramMap = (String)localEntry.getValue();
        if (paramMap == null) {
          paramMap = "";
        } else {
          paramMap = paramMap.trim();
        }
        localObject1 = paramMap;
        if (paramMap.length() > 10240)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[event] eventName: ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(", key: ");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("'s value > 10K.");
          localObject1 = ((StringBuilder)localObject1).toString();
          com.tencent.beacon.a.b.d.b().a("103", (String)localObject1);
          e.a((String)localObject1);
          localObject1 = paramMap.substring(0, 10240);
        }
        paramMap = ((String)localObject1).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D");
        localHashMap.put(localObject2, paramMap);
        i += ((String)localObject2).length() + paramMap.length();
      }
      else
      {
        com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", new Object[] { paramMap });
        localObject1 = com.tencent.beacon.a.b.d.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[event] eventName: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", key: ");
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append(" should be ASCII code in 32-126!");
        ((com.tencent.beacon.a.b.d)localObject1).a("102", ((StringBuilder)localObject2).toString());
      }
    }
    if (i > 46080)
    {
      paramMap = new StringBuilder();
      paramMap.append("[event] eventName: ");
      paramMap.append(paramString);
      paramMap.append(" params > 45K");
      paramString = paramMap.toString();
      com.tencent.beacon.a.b.d.b().a("104", paramString);
      e.a(paramString);
      return null;
    }
    return localHashMap;
  }
  
  public static void a(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fixBeaconInfo, serverTime: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",ip: ");
    ((StringBuilder)localObject).append(paramString);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = com.tencent.beacon.a.c.c.d();
    ((com.tencent.beacon.a.c.c)localObject).b(paramString);
    ((com.tencent.beacon.a.c.c)localObject).a(paramLong - new Date().getTime());
  }
  
  private static void a(String paramString1, String paramString2)
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "update strategy sid: %s, max_time: %s", new Object[] { paramString1, paramString2 });
    g.b().a(paramString1, paramString2);
  }
  
  public static boolean a(String paramString)
  {
    int i = paramString.length();
    boolean bool = true;
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
  
  public static boolean a(Map<String, List<String>> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    if (paramMap.containsKey("encrypt-status"))
    {
      com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
      return false;
    }
    if ((paramMap.containsKey("session_id")) && (paramMap.containsKey("max_time")))
    {
      List localList2 = (List)paramMap.get("session_id");
      List localList1 = (List)paramMap.get("max_time");
      String str = null;
      if (localList2 != null) {
        paramMap = (String)localList2.get(0);
      } else {
        paramMap = null;
      }
      if (localList1 != null) {
        str = (String)localList1.get(0);
      }
      if ((paramMap != null) && (str != null)) {
        a(paramMap, str);
      }
    }
    return true;
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static NetworkInfo b()
  {
    Object localObject = com.tencent.beacon.a.c.c.d().c();
    try
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.a(localThrowable);
    }
    return null;
  }
  
  public static String b(Map<String, String> paramMap)
  {
    String str1 = "";
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str2 = (String)((Map.Entry)localObject).getKey();
      if ((str2.trim().length() > 0) && (a(str2)))
      {
        str2 = str2.trim();
        localStringBuilder.append("&");
        localStringBuilder.append(str2.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        localStringBuilder.append("=");
        localObject = (String)((Map.Entry)localObject).getValue();
        if (localObject != null) {
          localStringBuilder.append(((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        }
      }
      else
      {
        com.tencent.beacon.base.util.c.e("[core] '%s' should be ASCII code in 32-126!", new Object[] { str2 });
      }
    }
    paramMap = str1;
    if (localStringBuilder.length() > 0) {
      paramMap = localStringBuilder.substring(1);
    }
    return paramMap;
  }
  
  public static String c()
  {
    Object localObject1 = b();
    if (localObject1 == null) {
      return "unknown";
    }
    if (((NetworkInfo)localObject1).getType() == 1) {
      return "wifi";
    }
    Object localObject2 = ((NetworkInfo)localObject1).getExtraInfo();
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 64) {
        localObject1 = ((String)localObject2).substring(0, 64);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  public static void c(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.containsKey("encrypt-status")) {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "parse response header fail! cause by svr encrypt error!", new Object[0]);
      }
      if ((paramMap.containsKey("session_id")) && (paramMap.containsKey("max_time"))) {
        a((String)paramMap.get("session_id"), (String)paramMap.get("max_time"));
      }
    }
  }
  
  public static boolean d()
  {
    NetworkInfo localNetworkInfo = b();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.c.d
 * JD-Core Version:    0.7.0.1
 */