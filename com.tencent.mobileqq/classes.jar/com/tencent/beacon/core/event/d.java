package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.a.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class d
{
  public boolean a;
  private Context b;
  private String c;
  private Map<String, String> d = null;
  private final Object e = new Object();
  private g f = null;
  private g g = null;
  private String h = "10000";
  
  public d(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
    this.f = new a(paramContext, this);
    this.g = new h(paramContext, this);
  }
  
  private int i()
  {
    if (this.a) {
      return k.a(this.b, this.c);
    }
    return -1;
  }
  
  public final g a()
  {
    return this.f;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 20))
    {
      if (this.d == null) {
        this.d = new HashMap();
      }
      this.d.putAll(paramMap);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    g localg = this.f;
    if (localg != null) {
      localg.a(paramBoolean);
    }
    localg = this.g;
    if (localg != null) {
      localg.a(paramBoolean);
    }
    this.a = paramBoolean;
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (com.tencent.beacon.core.d.h.a(paramString)) {
      paramString = null;
    }
    Object localObject;
    while (paramString == null)
    {
      return false;
      String str = paramString.replace('|', '_').trim();
      if (str.length() == 0)
      {
        com.tencent.beacon.core.d.b.d("[core] eventName is invalid!! eventName length == 0!", new Object[0]);
        paramString = null;
      }
      else if (com.tencent.beacon.core.d.a.b(str))
      {
        localObject = str;
        if (str.length() > 128)
        {
          com.tencent.beacon.core.d.b.c("[core] eventName length should be less than 128! eventName:" + paramString, new Object[0]);
          localObject = str.substring(0, 128);
        }
        paramString = (String)localObject;
      }
      else
      {
        com.tencent.beacon.core.d.b.d("[core] eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
        paramString = null;
      }
    }
    com.tencent.beacon.core.d.b.a("[event] UserEvent: %s, %b, %d, %d, %b, %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if (EventStrategyBean.getInstance().isInPreventEventCode(paramString))
    {
      com.tencent.beacon.core.d.b.d("[event] '%s' is not allowed in strategy (false).", new Object[] { paramString });
      return false;
    }
    if ((!paramBoolean1) || (EventStrategyBean.getInstance().isUploadByRate(paramString))) {
      if (paramBoolean2) {
        localObject = this.g;
      }
    }
    while (localObject != null)
    {
      paramString = j.a(this.b, this.c, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      if (paramString == null)
      {
        com.tencent.beacon.core.d.b.d("[event] RDBean is null, return false!", new Object[0]);
        return false;
        localObject = this.f;
      }
      else
      {
        return ((g)localObject).a(paramString);
        com.tencent.beacon.core.d.b.d("[event] '%s' is sampled by svr rate (false).", new Object[] { paramString });
        return false;
      }
    }
    return false;
  }
  
  public final g b()
  {
    return this.g;
  }
  
  public final void b(String paramString)
  {
    this.h = paramString;
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (!TunnelModule.isModuleAble())
    {
      com.tencent.beacon.core.d.b.d("[module] this module not ready!", new Object[0]);
      return false;
    }
    synchronized (this.e)
    {
      int i = i();
      if (i > 0) {
        try
        {
          if (i.a(this.b) != null)
          {
            b localb = new b(this.b, this.c);
            localb.a(paramBoolean);
            i.a(this.b).a(localb);
          }
          return true;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.core.d.b.d("[event] up common error: %s", new Object[] { localThrowable.toString() });
          com.tencent.beacon.core.d.b.a(localThrowable);
        }
      }
      return false;
    }
  }
  
  public final void c()
  {
    synchronized (this.e)
    {
      int i = i();
      int j = 20;
      while ((i > 0) && (j > 0))
      {
        j -= 1;
        com.tencent.beacon.core.d.b.a("[db] -> upload db events, [%d] need to upload.", new Object[] { Integer.valueOf(i) });
        if (!b(false)) {
          return;
        }
        i = i();
      }
      return;
    }
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        Object localObject = StrategyQueryModule.getInstance(this.b).getStrategy();
        if (localObject == null) {
          return;
        }
        localObject = ((com.tencent.beacon.core.strategy.a)localObject).b(1);
        if ((localObject != null) && (EventStrategyBean.getInstance() != null))
        {
          Set localSet = ((a.a)localObject).d();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setPreventEventCode(localSet);
          }
          localSet = ((a.a)localObject).f();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setSampleEvent(localSet);
          }
        }
        if ((!this.a) || (localObject == null)) {
          break;
        }
        if (i() > 0)
        {
          i = 1;
          if (i == 0) {
            return;
          }
          com.tencent.beacon.core.d.b.e("[event] asyn up module %d", new Object[] { Integer.valueOf(1) });
          com.tencent.beacon.core.a.b.b().a(new d.1(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.d.b.a(localThrowable);
        com.tencent.beacon.core.d.b.d("[event] common query end error %s", new Object[] { localThrowable.toString() });
        return;
      }
      int i = 0;
    }
    com.tencent.beacon.core.d.b.d("[event] module is disable", new Object[0]);
  }
  
  public final void e()
  {
    this.f.c();
    this.g.c();
  }
  
  public final String f()
  {
    return this.c;
  }
  
  public final Map<String, String> g()
  {
    return this.d;
  }
  
  public final String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.event.d
 * JD-Core Version:    0.7.0.1
 */