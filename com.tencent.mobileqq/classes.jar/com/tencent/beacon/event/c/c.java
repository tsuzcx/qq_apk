package com.tencent.beacon.event.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.e;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.pack.EventRecordV2;
import com.tencent.beacon.pack.RequestPackageV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public static int a(EventType paramEventType)
  {
    if ((paramEventType != EventType.NORMAL) && (paramEventType != EventType.DT_NORMAL))
    {
      if ((paramEventType != EventType.REALTIME) && (paramEventType == EventType.DT_REALTIME)) {}
      return 1;
    }
    return 0;
  }
  
  private static EventRecordV2 a(EventBean paramEventBean)
  {
    if (paramEventBean == null) {
      return null;
    }
    EventRecordV2 localEventRecordV2 = new EventRecordV2();
    localEventRecordV2.appKey = paramEventBean.getAppKey();
    Object localObject = paramEventBean.getApn();
    String str = "";
    if (localObject != null) {
      localObject = paramEventBean.getApn();
    } else {
      localObject = "";
    }
    localEventRecordV2.apn = ((String)localObject);
    localObject = str;
    if (paramEventBean.getSrcIp() != null) {
      localObject = paramEventBean.getSrcIp();
    }
    localEventRecordV2.srcIp = ((String)localObject);
    localEventRecordV2.eventCode = paramEventBean.getEventCode();
    localEventRecordV2.valueType = paramEventBean.getValueType();
    localEventRecordV2.mapValue = paramEventBean.getEventValue();
    localEventRecordV2.byteValue = paramEventBean.getByteValue();
    localEventRecordV2.eventTime = paramEventBean.getEventTime();
    localEventRecordV2.eventResult = paramEventBean.getEventResult();
    localEventRecordV2.eventType = paramEventBean.getEventType();
    localEventRecordV2.reserved = paramEventBean.getReserved();
    return localEventRecordV2;
  }
  
  public static RequestPackageV2 a(List<EventBean> paramList)
  {
    RequestPackageV2 localRequestPackageV2 = new RequestPackageV2();
    localRequestPackageV2.appVersion = b.a();
    localRequestPackageV2.common = a();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EventRecordV2 localEventRecordV2 = a((EventBean)paramList.next());
      if (localEventRecordV2 != null) {
        localArrayList.add(localEventRecordV2);
      }
    }
    localRequestPackageV2.events = localArrayList;
    paramList = com.tencent.beacon.a.c.c.d();
    localRequestPackageV2.mainAppKey = paramList.f();
    localRequestPackageV2.model = Build.MODEL;
    localRequestPackageV2.osVersion = f.p().z();
    localRequestPackageV2.packageName = b.b();
    localRequestPackageV2.platformId = paramList.g();
    localRequestPackageV2.sdkId = paramList.h();
    localRequestPackageV2.sdkVersion = paramList.i();
    localRequestPackageV2.reserved = "";
    return localRequestPackageV2;
  }
  
  public static String a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return "unknown";
      }
      if (f(paramString.trim()))
      {
        localObject = paramString.trim();
        paramString = (String)localObject;
        if (((String)localObject).length() > 16) {
          paramString = ((String)localObject).substring(0, 16);
        }
        return paramString;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[core] channelID should be Numeric! channelID:");
      ((StringBuilder)localObject).append(paramString);
      com.tencent.beacon.base.util.c.e(((StringBuilder)localObject).toString(), new Object[0]);
    }
    return "unknown";
  }
  
  private static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    f localf = f.p();
    Object localObject = com.tencent.beacon.a.c.c.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localf.v());
    localHashMap.put("A31", localStringBuilder.toString());
    localHashMap.put("A67", b.c(((com.tencent.beacon.a.c.c)localObject).c()));
    localHashMap.put("A76", b.d());
    localHashMap.put("A89", localf.a(((com.tencent.beacon.a.c.c)localObject).c()));
    localHashMap.put("A52", String.valueOf(localf.F()));
    if (localf.q()) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localHashMap.put("A58", localObject);
    localHashMap.put("A12", localf.r());
    localHashMap.put("A17", localf.B());
    localHashMap.put("A10", Build.MODEL);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(localf.m());
    localHashMap.put("A2", ((StringBuilder)localObject).toString());
    localHashMap.put("A4", localf.o());
    localHashMap.put("A6", localf.s());
    localHashMap.put("A7", localf.e());
    localHashMap.put("A20", localf.I());
    localHashMap.put("A69", localf.J());
    localHashMap.put("A60", localf.I());
    localHashMap.put("A9", Build.BRAND);
    return localHashMap;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {}
      return true;
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (e.a.get())
      {
        d.b().a("101", "eventCode == null");
        e.a("eventCode == null");
      }
      return "";
    }
    String str = paramString.replace('|', '_').trim();
    if (f(str))
    {
      localObject = str;
      if (str.length() > 128)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" length > 128.");
        paramString = ((StringBuilder)localObject).toString();
        d.b().a("101", paramString);
        e.a(paramString);
        localObject = str.substring(0, 128);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" is not ASCII");
    paramString = ((StringBuilder)localObject).toString();
    d.b().a("101", paramString);
    e.a(paramString);
    return "";
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      return str;
    }
    return "DefaultPageID";
  }
  
  public static String d(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return "10000";
      }
      Object localObject = paramString.replace('|', '_').trim();
      if (f((String)localObject))
      {
        if (((String)localObject).length() < 5) {
          com.tencent.beacon.base.util.c.e("[core] userID length should < 5!", new Object[0]);
        }
        if (((String)localObject).length() > 128) {
          return ((String)localObject).substring(0, 128);
        }
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[core] userID should be ASCII code in 32-126! userID:");
      ((StringBuilder)localObject).append(paramString);
      com.tencent.beacon.base.util.c.e(((StringBuilder)localObject).toString(), new Object[0]);
    }
    return "10000";
  }
  
  public static BeaconModule e(String paramString)
  {
    return (BeaconModule)Class.forName(paramString).newInstance();
  }
  
  private static boolean f(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c.c
 * JD-Core Version:    0.7.0.1
 */