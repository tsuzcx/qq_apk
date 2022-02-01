package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.d.l;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.IccIdJNI;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.core.info.g;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s
{
  public static RDBean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return a(paramContext, paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static RDBean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString2 == null) {
      return null;
    }
    g localg = g.b(UserAction.mContext);
    if (localg == null)
    {
      d.b("[event] BeaconInfo is null!", new Object[0]);
      return null;
    }
    Object localObject = UserAction.getUserID(paramString1);
    long l = b.b(localg.j());
    String str2 = localg.d();
    String str1 = com.tencent.beacon.core.e.e.b(paramContext);
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
        if (!b.a(paramString2)) {
          i = 1;
        }
      }
      paramMap = com.tencent.beacon.core.info.c.a(paramContext);
      com.tencent.beacon.core.info.e locale = com.tencent.beacon.core.info.e.d(paramContext);
      if (i == 0)
      {
        localHashMap.put("A1", "" + (String)localObject);
        localObject = paramMap.k();
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          localHashMap.put("QQ", "" + (String)localObject);
        }
        localHashMap.put("A32", IccIdJNI.a());
        localHashMap.put("A141", QimeiSDK.getInstance().getBeaconIdInfo(paramContext));
        localHashMap.put("A143", paramMap.j());
        localHashMap.put("A2", "" + paramMap.c());
        localHashMap.put("A4", paramMap.e());
        localHashMap.put("A6", paramMap.f());
        localHashMap.put("A7", paramMap.a());
        localObject = QimeiSDK.getInstance().getQimei(paramContext);
        if ((localObject != null) && (((Qimei)localObject).getQimeiMap() != null)) {
          localHashMap.putAll(((Qimei)localObject).getQimeiMap());
        }
        localHashMap.put("A23", localg.b(paramString1));
        localHashMap.put("A31", "" + paramMap.b());
        localHashMap.put("A67", a.c(paramContext));
        localHashMap.put("A76", a.a());
        localHashMap.put("A89", locale.c(paramContext));
        localHashMap.put("A52", "" + locale.n(paramContext));
        if (!locale.i()) {
          break label888;
        }
        paramMap = "Y";
        localHashMap.put("A58", paramMap);
        localHashMap.put("A12", locale.j());
        localHashMap.put("A17", locale.m(paramContext));
        localHashMap.put("A20", locale.p(paramContext));
        localHashMap.put("A69", locale.q(paramContext));
        localHashMap.put("A60", locale.o(paramContext));
        if (!localHashMap.containsKey("A95")) {
          localHashMap.put("A95", a.a(paramContext));
        }
        if (!paramBoolean2) {
          break label896;
        }
      }
      label896:
      for (paramMap = "Y";; paramMap = "N")
      {
        localHashMap.put("A99", paramMap);
        localHashMap.put("A34", l + "");
        paramContext = k.a(paramContext).d();
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = (l)paramContext.get(0);
          paramString1 = paramContext.getEventSerialNumber(paramString1, paramString2, paramBoolean2);
          if (paramString1 != null) {
            localHashMap.put("A100", paramString1);
          }
          if (!localHashMap.containsKey("A88")) {
            localHashMap.put("A88", paramContext.getAppFirstInstallTime());
          }
        }
        if (!"".equals(localg.l())) {
          localHashMap.put("A113", localg.l());
        }
        paramContext = new RDBean();
        paramContext.setEN("" + paramString2);
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
        label888:
        paramMap = "N";
        break;
      }
    }
  }
  
  public static EventRecord a(RDBean paramRDBean)
  {
    if ((paramRDBean == null) || (!"UA".equals(paramRDBean.getTP()))) {}
    for (;;)
    {
      return null;
      Map localMap = paramRDBean.getEMap();
      if (localMap == null) {
        continue;
      }
      try
      {
        EventRecord localEventRecord = new EventRecord();
        localEventRecord.eventName = paramRDBean.getEN();
        localEventRecord.eventTime = paramRDBean.getTM();
        if (paramRDBean.getApn() != null)
        {
          str = paramRDBean.getApn();
          label64:
          localEventRecord.apn = str;
          if (paramRDBean.getSrcIp() == null) {
            break label139;
          }
        }
        label139:
        for (String str = paramRDBean.getSrcIp();; str = localEventRecord.srcIp)
        {
          localEventRecord.srcIp = str;
          localEventRecord.cosumeTime = paramRDBean.getElapse();
          localEventRecord.eventResult = paramRDBean.isEventResult();
          localEventRecord.packageSize = paramRDBean.getSize();
          localEventRecord.eventValue = com.tencent.beacon.core.e.c.a(paramRDBean.getEN(), localMap);
          if (localEventRecord.eventValue == null) {
            break;
          }
          return localEventRecord;
          str = localEventRecord.apn;
          break label64;
        }
        return null;
      }
      catch (Throwable paramRDBean)
      {
        d.a(paramRDBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.s
 * JD-Core Version:    0.7.0.1
 */