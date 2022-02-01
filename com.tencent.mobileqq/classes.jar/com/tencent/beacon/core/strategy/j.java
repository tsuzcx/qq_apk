package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.event.EventStrategyBean;
import com.tencent.beacon.core.protocol.strategy.CommonStrategy;
import com.tencent.beacon.core.protocol.strategy.ModuleStrategy;
import com.tencent.beacon.core.wup.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class j
  implements g
{
  private Context a = null;
  
  public j(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a()
  {
    Object localObject = EventStrategyBean.getInstance();
    if ((localObject != null) && (((EventStrategyBean)localObject).isStrategyQuerySuccessDaxMax()))
    {
      localObject = f.a(this.a);
      int i = ((f)localObject).a("today_success_strategy_query_times", 0);
      ((f)localObject).b().a("today_success_strategy_query_times", Integer.valueOf(i + 1)).a("last_success_strategy_query_time", Long.valueOf(System.currentTimeMillis())).a();
    }
  }
  
  private boolean a(Map<String, String> paramMap, c paramc)
  {
    boolean bool = true;
    if (paramc == null) {
      return false;
    }
    if ((paramMap != null) && (paramc.e() != null))
    {
      if (paramMap.equals(paramc.e())) {
        break label58;
      }
      paramc.a(paramMap);
    }
    for (;;)
    {
      return bool;
      if ((paramMap != null) && (paramc.e() == null)) {
        paramc.a(paramMap);
      } else {
        label58:
        bool = false;
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      com.tencent.beacon.core.e.d.i("[strategy] com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        c localc = StrategyQueryModule.getInstance(this.a).getStrategy();
        if (localc == null)
        {
          com.tencent.beacon.core.e.d.i("[strategy] impossible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          CommonStrategy localCommonStrategy = new CommonStrategy();
          localCommonStrategy.readFrom(new a(paramArrayOfByte));
          StrategyQueryModule localStrategyQueryModule = StrategyQueryModule.getInstance(this.a);
          com.tencent.beacon.core.e.d.a("[strategy] -> common strategy: %s", new Object[] { localCommonStrategy });
          boolean bool = a(localCommonStrategy, localc);
          if (bool)
          {
            if (paramBoolean)
            {
              com.tencent.beacon.core.e.d.e("[strategy] update common strategy should save ", new Object[0]);
              d.a(this.a, paramInt, paramArrayOfByte);
            }
            localStrategyQueryModule.notifyStrategyChanged(localc);
          }
          if (paramBoolean)
          {
            localStrategyQueryModule.setAtLeastAComQuerySuccess(true);
            a();
            return;
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.beacon.core.e.d.a(paramArrayOfByte);
          com.tencent.beacon.core.e.d.b("[strategy] error to common strategy!", new Object[0]);
        }
      }
    }
  }
  
  protected boolean a(CommonStrategy paramCommonStrategy, c paramc)
  {
    boolean bool2 = true;
    if ((paramCommonStrategy == null) || (paramc == null))
    {
      bool2 = false;
      return bool2;
    }
    if (!paramCommonStrategy.url.equals(paramc.c()))
    {
      com.tencent.beacon.core.e.d.a("[strategy] url changed to: %s", new Object[] { paramCommonStrategy.url });
      paramc.c(paramCommonStrategy.url);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramCommonStrategy.queryInterval != paramc.i())
      {
        com.tencent.beacon.core.e.d.a("[strategy] QueryPeriod changed to: %d", new Object[] { Integer.valueOf(paramCommonStrategy.queryInterval) });
        paramc.c(paramCommonStrategy.queryInterval);
        bool1 = true;
      }
      if (a(paramCommonStrategy.moduleList, paramc)) {
        bool1 = true;
      }
      if (a(paramCommonStrategy.cloudParas, paramc)) {
        break;
      }
      return bool1;
    }
  }
  
  protected boolean a(ArrayList<ModuleStrategy> paramArrayList, c paramc)
  {
    if (paramc == null) {
      return false;
    }
    int i;
    boolean bool1;
    boolean bool2;
    label122:
    int j;
    if (paramArrayList != null)
    {
      paramc = paramc.f();
      if (paramc != null)
      {
        i = 0;
        bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          if (i >= paramc.size()) {
            break;
          }
          b localb = (b)paramc.valueAt(i);
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            ModuleStrategy localModuleStrategy = (ModuleStrategy)localIterator.next();
            if (localModuleStrategy.mId == localb.e())
            {
              com.tencent.beacon.core.e.d.d("[strategy] server module strategy mid: %d", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
              if (localModuleStrategy.onOff == 1)
              {
                bool2 = true;
                if (localb.f() != bool2)
                {
                  com.tencent.beacon.core.e.d.a("[strategy] mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(localModuleStrategy.mId), Boolean.valueOf(bool2) });
                  localb.a(bool2);
                  bool1 = true;
                }
                bool2 = bool1;
                if (!localb.d().equals(localModuleStrategy.url))
                {
                  com.tencent.beacon.core.e.d.a("[strategy] mid: %d , url changed: %s", new Object[] { Byte.valueOf(localModuleStrategy.mId), localModuleStrategy.url });
                  localb.a(localModuleStrategy.url);
                  bool2 = true;
                }
                j = localModuleStrategy.mId;
                if (j != 1)
                {
                  bool1 = bool2;
                  if (j != 2) {}
                }
                else
                {
                  if ((localb.a() == null) || (localModuleStrategy.detail == null)) {
                    break label557;
                  }
                  bool1 = bool2;
                  if (!localb.a().equals(localModuleStrategy.detail))
                  {
                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                    localb.a(localModuleStrategy.detail);
                    StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
                    bool1 = true;
                  }
                }
                label347:
                bool2 = bool1;
                if (localModuleStrategy.mId == 1)
                {
                  if ((localb.b() == null) || (localModuleStrategy.preventEventCode == null)) {
                    break label638;
                  }
                  if (!com.tencent.beacon.core.e.b.a(localb.b(), localModuleStrategy.preventEventCode))
                  {
                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                    localb.a(com.tencent.beacon.core.e.b.a(localModuleStrategy.preventEventCode));
                    bool1 = true;
                  }
                  label429:
                  if ((localb.c() == null) || (localModuleStrategy.sampleEvent == null)) {
                    break label694;
                  }
                  bool2 = bool1;
                  if (!com.tencent.beacon.core.e.b.a(localb.c(), localModuleStrategy.sampleEvent))
                  {
                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                    localb.b(com.tencent.beacon.core.e.b.a(localModuleStrategy.sampleEvent));
                    bool2 = true;
                  }
                }
              }
              for (;;)
              {
                byte b = localModuleStrategy.mId;
                bool1 = bool2;
                if (b != 2) {
                  break;
                }
                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SpeedMonitorStrategy", new Object[] { Byte.valueOf(b) });
                localb.a(localModuleStrategy.sms);
                bool1 = bool2;
                break;
                bool2 = false;
                break label122;
                label557:
                bool1 = bool2;
                if (localModuleStrategy.detail == null) {
                  break label347;
                }
                bool1 = bool2;
                if (localb.a() != null) {
                  break label347;
                }
                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                localb.a(localModuleStrategy.detail);
                StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
                bool1 = true;
                break label347;
                label638:
                if ((localb.b() == null) && (localModuleStrategy.preventEventCode == null)) {
                  break label429;
                }
                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                localb.a(com.tencent.beacon.core.e.b.a(localModuleStrategy.preventEventCode));
                bool1 = true;
                break label429;
                label694:
                if (localb.c() == null)
                {
                  bool2 = bool1;
                  if (localModuleStrategy.sampleEvent == null) {}
                }
                else
                {
                  com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
                  localb.b(com.tencent.beacon.core.e.b.a(localModuleStrategy.sampleEvent));
                  bool2 = true;
                }
              }
            }
          }
          i += 1;
        }
      }
    }
    else
    {
      paramArrayList = paramc.f();
      if (paramArrayList != null)
      {
        j = paramArrayList.size();
        bool1 = false;
        i = 0;
        bool2 = bool1;
        if (i >= j) {
          break label852;
        }
        paramc = (b)paramArrayList.valueAt(i);
        if (!paramc.f()) {
          break label855;
        }
        com.tencent.beacon.core.e.d.a("[strategy] mid: %d , server not response strategy, sdk local close it!", new Object[] { Integer.valueOf(paramc.e()) });
        paramc.a(false);
        bool1 = true;
      }
    }
    label852:
    label855:
    for (;;)
    {
      i += 1;
      break;
      bool2 = false;
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.j
 * JD-Core Version:    0.7.0.1
 */