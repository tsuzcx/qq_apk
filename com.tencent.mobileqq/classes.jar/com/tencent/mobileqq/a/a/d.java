package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static void a()
  {
    long l = SystemClock.elapsedRealtime();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (d.a)((Map.Entry)localObject).getValue();
      if (l - ((d.a)localObject).c > 480000L)
      {
        a.remove(str);
        a((d.a)localObject, false);
      }
    }
  }
  
  private static void a(d.a parama, boolean paramBoolean)
  {
    if ((parama != null) && (parama.g > 0L) && (parama.h > 0L) && (parama.g < parama.h) && (MsfService.core.getStatReporter() != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      localHashMap.put("ssoSeq", "" + parama.b);
      localHashMap.put("msgSeq", "" + parama.d);
      localHashMap.put("fromUin", parama.e);
      localHashMap.put("toUin", parama.f);
      localHashMap.put("onsectime", "" + parama.g);
      localHashMap.put("normaltime", "" + parama.h);
      MsfService.core.getStatReporter().a("OneSecEffect", paramBoolean, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg)
  {
    int k = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool2 = false;
    long l2 = -1L;
    Object localObject2 = paramToServiceMsg.getAttributes();
    Object localObject1;
    if (((Map)localObject2).containsKey("msgtype"))
    {
      localObject1 = ((Map)localObject2).get("msgtype");
      if (localObject1 == null) {}
    }
    for (int i = ((Integer)localObject1).intValue();; i = -1)
    {
      boolean bool1 = bool2;
      if (((Map)localObject2).containsKey("resend_by_user"))
      {
        localObject1 = ((Map)localObject2).get("resend_by_user");
        bool1 = bool2;
        if (localObject1 != null) {
          bool1 = ((Boolean)localObject1).booleanValue();
        }
      }
      int j = k;
      if (((Map)localObject2).containsKey("retryIndex"))
      {
        localObject1 = ((Map)localObject2).get("retryIndex");
        j = k;
        if (localObject1 != null) {
          j = ((Integer)localObject1).intValue();
        }
      }
      long l1 = l2;
      if (((Map)localObject2).containsKey("msgSeq"))
      {
        localObject1 = ((Map)localObject2).get("msgSeq");
        l1 = l2;
        if (localObject1 != null) {
          l1 = ((Long)localObject1).longValue();
        }
      }
      if (((Map)localObject2).containsKey("fromUin"))
      {
        localObject1 = ((Map)localObject2).get("fromUin");
        if (localObject1 == null) {}
      }
      for (localObject1 = (String)localObject1;; localObject1 = null)
      {
        if (((Map)localObject2).containsKey("uin"))
        {
          localObject2 = ((Map)localObject2).get("uin");
          if (localObject2 == null) {}
        }
        for (localObject2 = (String)localObject2; (i == -1000) && (!bool1) && (j <= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)); localObject2 = null)
        {
          d.a locala = new d.a(null);
          locala.a = paramToServiceMsg.getUin();
          locala.b = paramToServiceMsg.getRequestSsoSeq();
          locala.c = SystemClock.elapsedRealtime();
          locala.d = l1;
          locala.e = ((String)localObject1);
          locala.f = ((String)localObject2);
          a.put((String)localObject1 + (String)localObject2 + l1, locala);
          return;
        }
        break;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = null;
    int k = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) || (!paramFromServiceMsg.isSuccess())) {
      return;
    }
    boolean bool2 = false;
    long l2 = -1L;
    Object localObject2 = paramToServiceMsg.getAttributes();
    if (((Map)localObject2).containsKey("msgtype"))
    {
      paramToServiceMsg = ((Map)localObject2).get("msgtype");
      if (paramToServiceMsg == null) {}
    }
    for (int i = ((Integer)paramToServiceMsg).intValue();; i = -1)
    {
      boolean bool1 = bool2;
      if (((Map)localObject2).containsKey("resend_by_user"))
      {
        paramToServiceMsg = ((Map)localObject2).get("resend_by_user");
        bool1 = bool2;
        if (paramToServiceMsg != null) {
          bool1 = ((Boolean)paramToServiceMsg).booleanValue();
        }
      }
      int j = k;
      if (((Map)localObject2).containsKey("retryIndex"))
      {
        paramToServiceMsg = ((Map)localObject2).get("retryIndex");
        j = k;
        if (paramToServiceMsg != null) {
          j = ((Integer)paramToServiceMsg).intValue();
        }
      }
      long l1 = l2;
      if (((Map)localObject2).containsKey("msgSeq"))
      {
        paramToServiceMsg = ((Map)localObject2).get("msgSeq");
        l1 = l2;
        if (paramToServiceMsg != null) {
          l1 = ((Long)paramToServiceMsg).longValue();
        }
      }
      if (((Map)localObject2).containsKey("fromUin"))
      {
        paramToServiceMsg = ((Map)localObject2).get("fromUin");
        if (paramToServiceMsg == null) {}
      }
      for (paramToServiceMsg = (String)paramToServiceMsg;; paramToServiceMsg = null)
      {
        paramFromServiceMsg = localObject1;
        if (((Map)localObject2).containsKey("uin"))
        {
          localObject2 = ((Map)localObject2).get("uin");
          paramFromServiceMsg = localObject1;
          if (localObject2 != null) {
            paramFromServiceMsg = (String)localObject2;
          }
        }
        if ((i != -1000) || (bool1) || (j > 0) || (TextUtils.isEmpty(paramToServiceMsg)) || (TextUtils.isEmpty(paramFromServiceMsg))) {
          break;
        }
        paramToServiceMsg = paramToServiceMsg + paramFromServiceMsg + l1;
        paramFromServiceMsg = (d.a)a.get(paramToServiceMsg);
        if (paramFromServiceMsg == null) {
          break;
        }
        a.remove(paramToServiceMsg);
        if (paramFromServiceMsg.g <= 0L) {
          break;
        }
        paramFromServiceMsg.h = SystemClock.elapsedRealtime();
        a(paramFromServiceMsg, true);
        return;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    Object localObject1 = null;
    int k = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool2 = false;
    long l2 = -1L;
    Object localObject2 = paramToServiceMsg.getAttributes();
    if (((Map)localObject2).containsKey("msgtype"))
    {
      paramToServiceMsg = ((Map)localObject2).get("msgtype");
      if (paramToServiceMsg == null) {}
    }
    for (int i = ((Integer)paramToServiceMsg).intValue();; i = -1)
    {
      boolean bool1 = bool2;
      if (((Map)localObject2).containsKey("resend_by_user"))
      {
        paramToServiceMsg = ((Map)localObject2).get("resend_by_user");
        bool1 = bool2;
        if (paramToServiceMsg != null) {
          bool1 = ((Boolean)paramToServiceMsg).booleanValue();
        }
      }
      int j = k;
      if (((Map)localObject2).containsKey("retryIndex"))
      {
        paramToServiceMsg = ((Map)localObject2).get("retryIndex");
        j = k;
        if (paramToServiceMsg != null) {
          j = ((Integer)paramToServiceMsg).intValue();
        }
      }
      long l1 = l2;
      if (((Map)localObject2).containsKey("msgSeq"))
      {
        paramToServiceMsg = ((Map)localObject2).get("msgSeq");
        l1 = l2;
        if (paramToServiceMsg != null) {
          l1 = ((Long)paramToServiceMsg).longValue();
        }
      }
      if (((Map)localObject2).containsKey("fromUin"))
      {
        paramToServiceMsg = ((Map)localObject2).get("fromUin");
        if (paramToServiceMsg == null) {}
      }
      for (paramToServiceMsg = (String)paramToServiceMsg;; paramToServiceMsg = null)
      {
        paramFromServiceMsg = localObject1;
        if (((Map)localObject2).containsKey("uin"))
        {
          localObject2 = ((Map)localObject2).get("uin");
          paramFromServiceMsg = localObject1;
          if (localObject2 != null) {
            paramFromServiceMsg = (String)localObject2;
          }
        }
        if ((i != -1000) || (bool1) || (j > 0) || (TextUtils.isEmpty(paramToServiceMsg)) || (TextUtils.isEmpty(paramFromServiceMsg))) {
          break;
        }
        paramToServiceMsg = paramToServiceMsg + paramFromServiceMsg + l1;
        paramFromServiceMsg = (d.a)a.get(paramToServiceMsg);
        if (paramFromServiceMsg == null) {
          break;
        }
        if (paramBoolean)
        {
          if (paramFromServiceMsg.h <= 0L)
          {
            paramFromServiceMsg.g = SystemClock.elapsedRealtime();
            return;
          }
          a.remove(paramToServiceMsg);
          return;
        }
        a.remove(paramToServiceMsg);
        if (paramFromServiceMsg.g <= 0L) {
          break;
        }
        if (paramFromServiceMsg.h <= 0L) {
          paramFromServiceMsg.h = SystemClock.elapsedRealtime();
        }
        a(paramFromServiceMsg, true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.d
 * JD-Core Version:    0.7.0.1
 */