package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.b);
      localHashMap.put("ssoSeq", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.d);
      localHashMap.put("msgSeq", localStringBuilder.toString());
      localHashMap.put("fromUin", parama.e);
      localHashMap.put("toUin", parama.f);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.g);
      localHashMap.put("onsectime", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.h);
      localHashMap.put("normaltime", localStringBuilder.toString());
      MsfService.core.getStatReporter().a("OneSecEffect", paramBoolean, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg)
  {
    if ((!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (!"0".equals(paramToServiceMsg.getUin())) && (!a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))))
    {
      if (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) {
        return;
      }
      boolean bool2 = false;
      long l2 = -1L;
      Object localObject2 = paramToServiceMsg.getAttributes();
      boolean bool1 = ((Map)localObject2).containsKey("msgtype");
      int k = -1;
      if (bool1)
      {
        localObject1 = ((Map)localObject2).get("msgtype");
        if (localObject1 != null)
        {
          i = ((Integer)localObject1).intValue();
          break label113;
        }
      }
      int i = -1;
      label113:
      bool1 = bool2;
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
        if (localObject1 != null)
        {
          localObject1 = (String)localObject1;
          break label287;
        }
      }
      Object localObject1 = null;
      label287:
      if (((Map)localObject2).containsKey("uin"))
      {
        localObject2 = ((Map)localObject2).get("uin");
        if (localObject2 != null)
        {
          localObject2 = (String)localObject2;
          break label328;
        }
      }
      localObject2 = null;
      label328:
      if ((i == -1000) && (!bool1) && (j <= 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        d.a locala = new d.a(null);
        locala.a = paramToServiceMsg.getUin();
        locala.b = paramToServiceMsg.getRequestSsoSeq();
        locala.c = SystemClock.elapsedRealtime();
        locala.d = l1;
        locala.e = ((String)localObject1);
        locala.f = ((String)localObject2);
        paramToServiceMsg = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(l1);
        paramToServiceMsg.put(localStringBuilder.toString(), locala);
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (!"0".equals(paramToServiceMsg.getUin())) && ("MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())))
    {
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      boolean bool2 = false;
      long l2 = -1L;
      Object localObject = paramToServiceMsg.getAttributes();
      boolean bool1 = ((Map)localObject).containsKey("msgtype");
      int k = -1;
      if (bool1)
      {
        paramToServiceMsg = ((Map)localObject).get("msgtype");
        if (paramToServiceMsg != null)
        {
          i = ((Integer)paramToServiceMsg).intValue();
          break label102;
        }
      }
      int i = -1;
      label102:
      bool1 = bool2;
      if (((Map)localObject).containsKey("resend_by_user"))
      {
        paramToServiceMsg = ((Map)localObject).get("resend_by_user");
        bool1 = bool2;
        if (paramToServiceMsg != null) {
          bool1 = ((Boolean)paramToServiceMsg).booleanValue();
        }
      }
      int j = k;
      if (((Map)localObject).containsKey("retryIndex"))
      {
        paramToServiceMsg = ((Map)localObject).get("retryIndex");
        j = k;
        if (paramToServiceMsg != null) {
          j = ((Integer)paramToServiceMsg).intValue();
        }
      }
      long l1 = l2;
      if (((Map)localObject).containsKey("msgSeq"))
      {
        paramToServiceMsg = ((Map)localObject).get("msgSeq");
        l1 = l2;
        if (paramToServiceMsg != null) {
          l1 = ((Long)paramToServiceMsg).longValue();
        }
      }
      bool2 = ((Map)localObject).containsKey("fromUin");
      StringBuilder localStringBuilder = null;
      if (bool2)
      {
        paramToServiceMsg = ((Map)localObject).get("fromUin");
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = (String)paramToServiceMsg;
          break label271;
        }
      }
      paramToServiceMsg = null;
      label271:
      paramFromServiceMsg = localStringBuilder;
      if (((Map)localObject).containsKey("uin"))
      {
        localObject = ((Map)localObject).get("uin");
        paramFromServiceMsg = localStringBuilder;
        if (localObject != null) {
          paramFromServiceMsg = (String)localObject;
        }
      }
      if ((i == -1000) && (!bool1) && (j <= 0) && (!TextUtils.isEmpty(paramToServiceMsg)))
      {
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append(l1);
        paramToServiceMsg = localStringBuilder.toString();
        paramFromServiceMsg = (d.a)a.get(paramToServiceMsg);
        if (paramFromServiceMsg != null)
        {
          a.remove(paramToServiceMsg);
          if (paramFromServiceMsg.g <= 0L) {
            return;
          }
          paramFromServiceMsg.h = SystemClock.elapsedRealtime();
          a(paramFromServiceMsg, true);
        }
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (!"0".equals(paramToServiceMsg.getUin())))
    {
      if (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd())) {
        return;
      }
      boolean bool2 = false;
      long l2 = -1L;
      Object localObject = paramToServiceMsg.getAttributes();
      boolean bool1 = ((Map)localObject).containsKey("msgtype");
      int k = -1;
      if (bool1)
      {
        paramToServiceMsg = ((Map)localObject).get("msgtype");
        if (paramToServiceMsg != null)
        {
          i = ((Integer)paramToServiceMsg).intValue();
          break label95;
        }
      }
      int i = -1;
      label95:
      bool1 = bool2;
      if (((Map)localObject).containsKey("resend_by_user"))
      {
        paramToServiceMsg = ((Map)localObject).get("resend_by_user");
        bool1 = bool2;
        if (paramToServiceMsg != null) {
          bool1 = ((Boolean)paramToServiceMsg).booleanValue();
        }
      }
      int j = k;
      if (((Map)localObject).containsKey("retryIndex"))
      {
        paramToServiceMsg = ((Map)localObject).get("retryIndex");
        j = k;
        if (paramToServiceMsg != null) {
          j = ((Integer)paramToServiceMsg).intValue();
        }
      }
      long l1 = l2;
      if (((Map)localObject).containsKey("msgSeq"))
      {
        paramToServiceMsg = ((Map)localObject).get("msgSeq");
        l1 = l2;
        if (paramToServiceMsg != null) {
          l1 = ((Long)paramToServiceMsg).longValue();
        }
      }
      bool2 = ((Map)localObject).containsKey("fromUin");
      StringBuilder localStringBuilder = null;
      if (bool2)
      {
        paramToServiceMsg = ((Map)localObject).get("fromUin");
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = (String)paramToServiceMsg;
          break label267;
        }
      }
      paramToServiceMsg = null;
      label267:
      paramFromServiceMsg = localStringBuilder;
      if (((Map)localObject).containsKey("uin"))
      {
        localObject = ((Map)localObject).get("uin");
        paramFromServiceMsg = localStringBuilder;
        if (localObject != null) {
          paramFromServiceMsg = (String)localObject;
        }
      }
      if ((i == -1000) && (!bool1) && (j <= 0) && (!TextUtils.isEmpty(paramToServiceMsg)))
      {
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append(l1);
        paramToServiceMsg = localStringBuilder.toString();
        paramFromServiceMsg = (d.a)a.get(paramToServiceMsg);
        if (paramFromServiceMsg != null)
        {
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
            return;
          }
          if (paramFromServiceMsg.h <= 0L) {
            paramFromServiceMsg.h = SystemClock.elapsedRealtime();
          }
          a(paramFromServiceMsg, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.d
 * JD-Core Version:    0.7.0.1
 */