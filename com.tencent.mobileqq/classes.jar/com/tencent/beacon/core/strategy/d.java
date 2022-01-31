package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.c.g;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.event.EventStrategyBean;
import com.tencent.beacon.core.protocol.strategy.CommonStrategy;
import com.tencent.beacon.core.protocol.strategy.ModuleStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements g
{
  private Context a = null;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      com.tencent.beacon.core.d.b.c("[strategy] com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    a locala;
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        locala = StrategyQueryModule.getInstance(this.a).getStrategy();
        if (locala == null)
        {
          com.tencent.beacon.core.d.b.c("[strategy] impossible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          localObject1 = new CommonStrategy();
          ((CommonStrategy)localObject1).readFrom(new com.tencent.beacon.core.wup.a(paramArrayOfByte));
          StrategyQueryModule localStrategyQueryModule = StrategyQueryModule.getInstance(this.a);
          com.tencent.beacon.core.d.b.b("[strategy] -> common strategy: %s", new Object[] { localObject1 });
          if (locala == null)
          {
            i = 0;
            if (i != 0)
            {
              if (paramBoolean)
              {
                com.tencent.beacon.core.d.b.e("[strategy] update common strategy should save ", new Object[0]);
                b.a(this.a, paramInt, paramArrayOfByte);
              }
              localStrategyQueryModule.notifyStrategyChanged(locala);
            }
            if (!paramBoolean) {
              continue;
            }
            localStrategyQueryModule.setAtLeastAComQuerySuccess(true);
            paramArrayOfByte = EventStrategyBean.getInstance();
            if ((paramArrayOfByte == null) || (!paramArrayOfByte.isStrategyQuerySuccessDaxMax())) {
              continue;
            }
            paramArrayOfByte = c.a(this.a);
            paramInt = paramArrayOfByte.a("today_success_strategy_query_times");
            paramArrayOfByte.a().a("today_success_strategy_query_times", Integer.valueOf(paramInt + 1)).a("last_success_strategy_query_time", Long.valueOf(System.currentTimeMillis())).b();
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.beacon.core.d.b.a(paramArrayOfByte);
          com.tencent.beacon.core.d.b.d("[strategy] error to common strategy!", new Object[0]);
          return;
        }
      }
    }
    int k = 0;
    if (!((CommonStrategy)localObject1).url.equals(locala.b()))
    {
      com.tencent.beacon.core.d.b.b("[strategy] url changed to: %s", new Object[] { ((CommonStrategy)localObject1).url });
      k = 1;
      locala.a(((CommonStrategy)localObject1).url);
    }
    if (((CommonStrategy)localObject1).queryInterval != locala.c())
    {
      com.tencent.beacon.core.d.b.b("[strategy] QueryPeriod changed to: %d", new Object[] { Integer.valueOf(((CommonStrategy)localObject1).queryInterval) });
      k = 1;
      locala.a(((CommonStrategy)localObject1).queryInterval);
    }
    Object localObject2 = ((CommonStrategy)localObject1).moduleList;
    label344:
    Object localObject3;
    int n;
    label388:
    int j;
    label421:
    int m;
    boolean bool;
    if (locala == null)
    {
      i = 0;
      break label1225;
      localObject1 = ((CommonStrategy)localObject1).cloudParas;
      if (locala == null)
      {
        i = 0;
        break label1236;
      }
    }
    else
    {
      i = 0;
      if (localObject2 != null)
      {
        localObject3 = locala.e();
        if (localObject3 == null) {
          break label1225;
        }
        n = 0;
        i = 0;
        j = i;
        if (n >= ((SparseArray)localObject3).size()) {
          break label1221;
        }
        a.a locala1 = (a.a)((SparseArray)localObject3).valueAt(n);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label1260;
        }
        ModuleStrategy localModuleStrategy = (ModuleStrategy)localIterator.next();
        m = i;
        if (localModuleStrategy.mId != locala1.e()) {
          break label1247;
        }
        com.tencent.beacon.core.d.b.a("[strategy] server module strategy mid: %d", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
        if (localModuleStrategy.onOff != 1) {
          break label1254;
        }
        bool = true;
        label492:
        if (locala1.a() != bool)
        {
          com.tencent.beacon.core.d.b.b("[strategy] mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(localModuleStrategy.mId), Boolean.valueOf(bool) });
          i = 1;
          locala1.a(bool);
        }
        j = i;
        if (!locala1.b().equals(localModuleStrategy.url))
        {
          com.tencent.beacon.core.d.b.b("[strategy] mid: %d , url changed: %s", new Object[] { Byte.valueOf(localModuleStrategy.mId), localModuleStrategy.url });
          j = 1;
          locala1.a(localModuleStrategy.url);
        }
        if (localModuleStrategy.mId != 1)
        {
          i = j;
          if (localModuleStrategy.mId != 2) {}
        }
        else
        {
          if ((locala1.c() == null) || (localModuleStrategy.detail == null)) {
            break label914;
          }
          i = j;
          if (!locala1.c().equals(localModuleStrategy.detail))
          {
            com.tencent.beacon.core.d.b.b("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala1.a(localModuleStrategy.detail);
            StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
          }
        }
        j = i;
        if (localModuleStrategy.mId == 1)
        {
          if ((locala1.d() == null) || (localModuleStrategy.preventEventCode == null)) {
            break label994;
          }
          if (!locala1.d().equals(localModuleStrategy.preventEventCode))
          {
            label761:
            com.tencent.beacon.core.d.b.b("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala1.a(i.a(localModuleStrategy.preventEventCode));
          }
          label798:
          if ((locala1.f() == null) || (localModuleStrategy.sampleEvent == null)) {
            break label1013;
          }
          j = i;
          if (locala1.f().equals(localModuleStrategy.sampleEvent)) {}
        }
        for (;;)
        {
          label836:
          com.tencent.beacon.core.d.b.b("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
          j = 1;
          locala1.b(i.a(localModuleStrategy.sampleEvent));
          label914:
          label994:
          label1013:
          do
          {
            m = j;
            if (localModuleStrategy.mId != 2) {
              break label1247;
            }
            com.tencent.beacon.core.d.b.b("[strategy] mid: %d , SpeedMonitorStrategy", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            m = j;
            break label1247;
            i = j;
            if (localModuleStrategy.detail == null) {
              break;
            }
            i = j;
            if (locala1.c() != null) {
              break;
            }
            com.tencent.beacon.core.d.b.b("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala1.a(localModuleStrategy.detail);
            StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
            break;
            if (locala1.d() != null) {
              break label761;
            }
            if (localModuleStrategy.preventEventCode == null) {
              break label798;
            }
            break label761;
            if (locala1.f() != null) {
              break label836;
            }
            j = i;
          } while (localModuleStrategy.sampleEvent == null);
        }
      }
      localObject2 = locala.e();
      if (localObject2 == null) {
        break label1225;
      }
      n = ((SparseArray)localObject2).size();
      m = 0;
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (m < n)
      {
        localObject3 = (a.a)((SparseArray)localObject2).valueAt(m);
        if (!((a.a)localObject3).a()) {
          break label1269;
        }
        com.tencent.beacon.core.d.b.b("[strategy] mid: %d , server not response strategy, sdk local close it!", new Object[] { Integer.valueOf(((a.a)localObject3).e()) });
        i = 1;
        ((a.a)localObject3).a(false);
        break label1269;
        k = 0;
        if ((localObject1 != null) && (locala.d() != null))
        {
          i = k;
          if (!((Map)localObject1).equals(locala.d()))
          {
            locala.a((Map)localObject1);
            i = 1;
          }
        }
        else
        {
          i = k;
          if (localObject1 != null)
          {
            i = k;
            if (locala.d() == null)
            {
              locala.a((Map)localObject1);
              i = 1;
            }
          }
        }
      }
      label1221:
      label1225:
      label1236:
      while (i == 0)
      {
        i = j;
        break;
        do
        {
          j = k;
          break;
          i = j;
        } while (i == 0);
        j = 1;
        break label344;
      }
      i = 1;
      break;
      label1247:
      i = m;
      break label421;
      label1254:
      bool = false;
      break label492;
      label1260:
      n += 1;
      break label388;
      label1269:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.d
 * JD-Core Version:    0.7.0.1
 */