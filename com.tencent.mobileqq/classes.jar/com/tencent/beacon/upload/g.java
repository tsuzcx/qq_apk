package com.tencent.beacon.upload;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.a.b.d.a;
import com.tencent.beacon.a.f;
import com.tencent.beacon.event.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  private Context a = null;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      com.tencent.beacon.d.a.c("com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    Object localObject1;
    Object localObject2;
    int i;
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        localObject1 = com.tencent.beacon.a.b.b.a(this.a).e();
        if (localObject1 == null)
        {
          com.tencent.beacon.d.a.c("imposible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          localObject2 = new com.tencent.beacon.b.e.a();
          ((com.tencent.beacon.b.e.a)localObject2).a(new com.tencent.beacon.e.a(paramArrayOfByte));
          if (localObject1 == null)
          {
            i = 0;
            if (i == 0) {
              continue;
            }
            if (paramBoolean)
            {
              com.tencent.beacon.d.a.e("update common strategy should save ", new Object[0]);
              localObject2 = this.a;
              if (paramArrayOfByte != null)
              {
                localObject3 = new com.tencent.beacon.a.b.g();
                ((com.tencent.beacon.a.b.g)localObject3).a(paramInt);
                ((com.tencent.beacon.a.b.g)localObject3).a(paramArrayOfByte);
                f.a((Context)localObject2, (com.tencent.beacon.a.b.g)localObject3);
              }
            }
            com.tencent.beacon.d.a.e("com strategy changed notify! ", new Object[0]);
            paramArrayOfByte = com.tencent.beacon.a.b.b.a(this.a);
            paramArrayOfByte.a((com.tencent.beacon.a.b.d)localObject1);
            if (!paramBoolean) {
              continue;
            }
            paramArrayOfByte.b();
            paramArrayOfByte = null;
            localObject1 = o.d();
            if (localObject1 != null) {
              paramArrayOfByte = ((o)localObject1).a;
            }
            if ((paramArrayOfByte == null) || (!paramArrayOfByte.x())) {
              continue;
            }
            paramInt = com.tencent.beacon.a.b.a(this.a, "today_success_strategy_query_times");
            com.tencent.beacon.a.b.a(this.a, "today_success_strategy_query_times", paramInt + 1);
            com.tencent.beacon.a.b.a(this.a, "last_success_strategy_query_time", System.currentTimeMillis());
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.beacon.d.a.a(paramArrayOfByte);
          com.tencent.beacon.d.a.d("error to common strategy!", new Object[0]);
          return;
        }
      }
    }
    int k = 0;
    if (!((com.tencent.beacon.b.e.a)localObject2).c.equals(((com.tencent.beacon.a.b.d)localObject1).b()))
    {
      com.tencent.beacon.d.a.b("strategy url changed to: %s", new Object[] { ((com.tencent.beacon.b.e.a)localObject2).c });
      k = 1;
      ((com.tencent.beacon.a.b.d)localObject1).a(((com.tencent.beacon.b.e.a)localObject2).c);
    }
    if (((com.tencent.beacon.b.e.a)localObject2).b != ((com.tencent.beacon.a.b.d)localObject1).c())
    {
      com.tencent.beacon.d.a.b("QueryPeriod changed to: %d", new Object[] { Integer.valueOf(((com.tencent.beacon.b.e.a)localObject2).b) });
      k = 1;
      ((com.tencent.beacon.a.b.d)localObject1).a(((com.tencent.beacon.b.e.a)localObject2).b);
    }
    Object localObject3 = ((com.tencent.beacon.b.e.a)localObject2).a;
    label371:
    Object localObject4;
    int n;
    label415:
    label444:
    int m;
    boolean bool;
    label515:
    int j;
    if (localObject1 == null)
    {
      i = 0;
      break label1249;
      localObject2 = ((com.tencent.beacon.b.e.a)localObject2).d;
      if (localObject1 == null)
      {
        i = 0;
        break label1260;
      }
    }
    else
    {
      i = 0;
      if (localObject3 != null)
      {
        localObject4 = ((com.tencent.beacon.a.b.d)localObject1).e();
        if (localObject4 == null) {
          break label1249;
        }
        n = 0;
        i = 0;
        if (n >= ((SparseArray)localObject4).size()) {
          break label1249;
        }
        d.a locala = (d.a)((SparseArray)localObject4).valueAt(n);
        Iterator localIterator = ((ArrayList)localObject3).iterator();
        if (!localIterator.hasNext()) {
          break label1284;
        }
        Object localObject5 = (com.tencent.beacon.b.e.d)localIterator.next();
        m = i;
        if (((com.tencent.beacon.b.e.d)localObject5).a != locala.e()) {
          break label1271;
        }
        com.tencent.beacon.d.a.a("server module strategy mid: %d", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
        if (((com.tencent.beacon.b.e.d)localObject5).b != 1) {
          break label1278;
        }
        bool = true;
        if (locala.a() != bool)
        {
          com.tencent.beacon.d.a.b("mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a), Boolean.valueOf(bool) });
          i = 1;
          locala.a(bool);
        }
        j = i;
        if (!locala.b().equals(((com.tencent.beacon.b.e.d)localObject5).c))
        {
          com.tencent.beacon.d.a.b("mid: %d , url changed: %s", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a), ((com.tencent.beacon.b.e.d)localObject5).c });
          j = 1;
          locala.a(((com.tencent.beacon.b.e.d)localObject5).c);
        }
        if (((com.tencent.beacon.b.e.d)localObject5).a != 1)
        {
          i = j;
          if (((com.tencent.beacon.b.e.d)localObject5).a != 2) {}
        }
        else
        {
          if ((locala.c() == null) || (((com.tencent.beacon.b.e.d)localObject5).d == null)) {
            break label943;
          }
          i = j;
          if (!locala.c().equals(((com.tencent.beacon.b.e.d)localObject5).d))
          {
            com.tencent.beacon.d.a.b("mid: %d , detail changed...", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
            i = 1;
            locala.a(((com.tencent.beacon.b.e.d)localObject5).d);
            com.tencent.beacon.a.b.b.a(this.a).a(((com.tencent.beacon.b.e.d)localObject5).a, ((com.tencent.beacon.b.e.d)localObject5).d);
          }
        }
        j = i;
        if (((com.tencent.beacon.b.e.d)localObject5).a == 1)
        {
          if ((locala.d() == null) || (((com.tencent.beacon.b.e.d)localObject5).e == null)) {
            break label1023;
          }
          if (!locala.d().equals(((com.tencent.beacon.b.e.d)localObject5).e))
          {
            label784:
            com.tencent.beacon.d.a.b("mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
            i = 1;
            locala.a(f.a(((com.tencent.beacon.b.e.d)localObject5).e));
          }
          label820:
          if ((locala.f() == null) || (((com.tencent.beacon.b.e.d)localObject5).g == null)) {
            break label1042;
          }
          j = i;
          if (locala.f().equals(((com.tencent.beacon.b.e.d)localObject5).g)) {}
        }
        label1042:
        for (;;)
        {
          label858:
          com.tencent.beacon.d.a.b("mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
          j = 1;
          locala.b(f.a(((com.tencent.beacon.b.e.d)localObject5).g));
          label943:
          label1023:
          do
          {
            m = j;
            if (((com.tencent.beacon.b.e.d)localObject5).a != 2) {
              break label1271;
            }
            com.tencent.beacon.d.a.b("mid: %d , SpeedMonitorStrategy", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
            localObject5 = ((com.tencent.beacon.b.e.d)localObject5).f;
            m = j;
            break label1271;
            i = j;
            if (((com.tencent.beacon.b.e.d)localObject5).d == null) {
              break;
            }
            i = j;
            if (locala.c() != null) {
              break;
            }
            com.tencent.beacon.d.a.b("mid: %d , detail changed...", new Object[] { Byte.valueOf(((com.tencent.beacon.b.e.d)localObject5).a) });
            i = 1;
            locala.a(((com.tencent.beacon.b.e.d)localObject5).d);
            com.tencent.beacon.a.b.b.a(this.a).a(((com.tencent.beacon.b.e.d)localObject5).a, ((com.tencent.beacon.b.e.d)localObject5).d);
            break;
            if (locala.d() != null) {
              break label784;
            }
            if (((com.tencent.beacon.b.e.d)localObject5).e == null) {
              break label820;
            }
            break label784;
            if (locala.f() != null) {
              break label858;
            }
            j = i;
          } while (((com.tencent.beacon.b.e.d)localObject5).g == null);
        }
      }
      localObject3 = ((com.tencent.beacon.a.b.d)localObject1).e();
      if (localObject3 == null) {
        break label1249;
      }
      m = ((SparseArray)localObject3).size();
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if (j < m)
      {
        localObject4 = (d.a)((SparseArray)localObject3).valueAt(j);
        if (!((d.a)localObject4).a()) {
          break label1293;
        }
        com.tencent.beacon.d.a.b("mid: %d , server not response strategy, sdk local close it!", new Object[] { Integer.valueOf(((d.a)localObject4).e()) });
        i = 1;
        ((d.a)localObject4).a(false);
        break label1293;
        k = 0;
        if ((localObject2 != null) && (((com.tencent.beacon.a.b.d)localObject1).d() != null))
        {
          i = k;
          if (!((Map)localObject2).equals(((com.tencent.beacon.a.b.d)localObject1).d()))
          {
            ((com.tencent.beacon.a.b.d)localObject1).a((Map)localObject2);
            i = 1;
          }
        }
        else
        {
          i = k;
          if (localObject2 != null)
          {
            i = k;
            if (((com.tencent.beacon.a.b.d)localObject1).d() == null)
            {
              ((com.tencent.beacon.a.b.d)localObject1).a((Map)localObject2);
              i = 1;
            }
          }
        }
      }
      label1249:
      label1260:
      while (i == 0)
      {
        i = j;
        break;
        do
        {
          j = k;
          break;
        } while (i == 0);
        j = 1;
        break label371;
      }
      i = 1;
      break;
      label1271:
      i = m;
      break label444;
      label1278:
      bool = false;
      break label515;
      label1284:
      n += 1;
      break label415;
      label1293:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.g
 * JD-Core Version:    0.7.0.1
 */