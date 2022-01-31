package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.b.c;
import com.tencent.beacon.core.d.d;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  public static RDBean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString2 == null) {
      return null;
    }
    com.tencent.beacon.core.b.b localb = com.tencent.beacon.core.b.b.a(UserAction.mContext);
    if (localb == null)
    {
      com.tencent.beacon.core.d.b.d("[event] BeaconInfo is null!", new Object[0]);
      return null;
    }
    String str3 = UserAction.getUserID(paramString1);
    long l = com.tencent.beacon.core.d.i.a(localb.i());
    String str2 = localb.h();
    String str1 = d.c(paramContext);
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      int j = 0;
      int i = j;
      if (EventStrategyBean.getInstance().isTidyEventFields())
      {
        i = j;
        if (!paramString2.startsWith("rqd_")) {
          i = 1;
        }
      }
      paramMap = c.a(paramContext);
      if (i == 0)
      {
        localHashMap.put("A1", str3);
        str3 = UserAction.getQQ();
        if ((str3 != null) && (!str3.equals(""))) {
          localHashMap.put("QQ", str3);
        }
        localHashMap.put("A141", paramMap.f());
        localHashMap.put("A143", paramMap.h());
        localHashMap.put("A2", paramMap.a());
        localHashMap.put("A4", paramMap.c());
        localHashMap.put("A6", paramMap.b());
        localHashMap.put("A7", paramMap.d());
        localHashMap.put("A3", QimeiSDK.getInstance().getQimeiInternal());
        localHashMap.put("A23", localb.a(paramString1));
        localHashMap.put("A31", paramMap.e());
        localHashMap.put("A67", com.tencent.beacon.core.b.a.i(paramContext));
        localHashMap.put("A76", com.tencent.beacon.core.b.a.a());
        if (!localHashMap.containsKey("A95")) {
          localHashMap.put("A95", com.tencent.beacon.core.b.a.d(paramContext));
        }
        if (!paramBoolean2) {
          break label575;
        }
      }
      label575:
      for (paramString1 = "Y";; paramString1 = "N")
      {
        localHashMap.put("A99", paramString1);
        paramContext = com.tencent.beacon.core.c.i.a(paramContext).c();
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = ((com.tencent.beacon.core.c.j)paramContext.get(0)).getEventSerialNumber(paramString2);
          if (paramContext != null) {
            localHashMap.put("A100", paramContext);
          }
        }
        if (!"".equals(localb.k())) {
          localHashMap.put("A113", localb.k());
        }
        paramContext = new RDBean();
        paramContext.setEN(paramString2);
        paramContext.setTM(l);
        paramContext.setTP("UA");
        paramContext.setEMap(localHashMap);
        paramContext.setImmediatelyUpload(paramBoolean3);
        paramContext.setApn(str1);
        paramContext.setSrcIp(str2);
        paramContext.setEventResult(paramBoolean1);
        paramContext.setElapse(paramLong1);
        paramContext.setSize(paramLong2);
        return paramContext;
      }
    }
  }
  
  public static EventRecord a(RDBean paramRDBean)
  {
    if ((paramRDBean == null) || (!"UA".equals(paramRDBean.getTP()))) {}
    Map localMap;
    do
    {
      return null;
      localMap = paramRDBean.getEMap();
    } while (localMap == null);
    try
    {
      EventRecord localEventRecord = new EventRecord();
      localEventRecord.eventName = paramRDBean.getEN();
      localEventRecord.eventTime = paramRDBean.getTM();
      if (paramRDBean.getApn() != null)
      {
        str = paramRDBean.getApn();
        localEventRecord.apn = str;
        if (paramRDBean.getSrcIp() == null) {
          break label127;
        }
      }
      label127:
      for (String str = paramRDBean.getSrcIp();; str = localEventRecord.srcIp)
      {
        localEventRecord.srcIp = str;
        localEventRecord.cosumeTime = paramRDBean.getElapse();
        localEventRecord.eventResult = paramRDBean.isEventResult();
        localEventRecord.packageSize = paramRDBean.getSize();
        localEventRecord.eventValue = com.tencent.beacon.core.d.a.a(localMap);
        return localEventRecord;
        str = localEventRecord.apn;
        break;
      }
      return null;
    }
    catch (Throwable paramRDBean)
    {
      com.tencent.beacon.core.d.b.a(paramRDBean);
      com.tencent.beacon.core.d.b.d(paramRDBean.getMessage(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.event.j
 * JD-Core Version:    0.7.0.1
 */