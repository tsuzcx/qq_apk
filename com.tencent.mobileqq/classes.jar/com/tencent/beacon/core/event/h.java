package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.core.strategy.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class h
{
  private Context a;
  private String b;
  private Map<String, String> c = null;
  public boolean d;
  private final Object e = new Object();
  private n f = null;
  private n g = null;
  private String h = "10000";
  
  public h(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.f = new c(paramContext, this);
    this.g = new q(paramContext, this);
  }
  
  public Map<String, String> a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 20))
    {
      if (this.c == null) {
        this.c = new HashMap();
      }
      this.c.putAll(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    n localn = c();
    if (localn != null) {
      localn.a(paramBoolean);
    }
    localn = e();
    if (localn != null) {
      localn.a(paramBoolean);
    }
    this.d = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!TunnelModule.isModuleAble())
    {
      com.tencent.beacon.core.e.d.b("[module] this module not ready!", new Object[0]);
      return;
    }
    if (paramBoolean2) {
      com.tencent.beacon.core.e.d.a("doUploadRecentCommonData, upload all db", new Object[0]);
    }
    synchronized (this.e)
    {
      int i = d();
      boolean bool = true;
      int j = 0;
      for (;;)
      {
        if ((bool) && (i > 0) && (j <= 100) && ((paramBoolean2) || (j == 0))) {
          try
          {
            if (k.a(this.a) != null)
            {
              e locale = new e(this.a, this.b);
              locale.b(paramBoolean1);
              bool = k.a(this.a).a(locale);
            }
            j += 1;
            i = d();
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.core.e.d.b("[event] up common error: %s", new Object[] { localThrowable.toString() });
            com.tencent.beacon.core.e.d.a(localThrowable);
          }
        }
      }
      return;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str = com.tencent.beacon.core.e.c.b(paramString);
    if (str == null)
    {
      i.a(this.a).a("101", paramString);
      return false;
    }
    com.tencent.beacon.core.e.d.d("[event] UserEvent: %s, %b, %d, %d, %b, %b", new Object[] { str, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if (EventStrategyBean.getInstance().isInPreventEventCode(str))
    {
      com.tencent.beacon.core.e.d.b("[event] '%s' is not allowed in strategy (false).", new Object[] { str });
      return false;
    }
    if ((!paramBoolean1) || (EventStrategyBean.getInstance().isUploadByRate(str)))
    {
      if (!paramBoolean2) {
        break label197;
      }
      paramString = e();
    }
    while (paramString != null)
    {
      paramMap = s.a(this.a, this.b, str, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      if (paramMap == null)
      {
        com.tencent.beacon.core.e.d.b("[event] RDBean:%s is null, return false!", new Object[] { str });
        return false;
        com.tencent.beacon.core.e.d.b("[event] '%s' is sampled by svr rate (false).", new Object[] { str });
        return false;
        label197:
        paramString = c();
      }
      else
      {
        return paramString.a(paramMap);
      }
    }
    return false;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  public n c()
  {
    return this.f;
  }
  
  public int d()
  {
    if (this.d) {
      return t.a(this.a, this.b);
    }
    return -1;
  }
  
  public n e()
  {
    return this.g;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public void g()
  {
    this.f.a();
    this.g.a();
  }
  
  public void h()
  {
    a(false, true);
  }
  
  public void i()
  {
    for (;;)
    {
      try
      {
        Object localObject = StrategyQueryModule.getInstance(this.a).getStrategy();
        if (localObject == null) {
          return;
        }
        localObject = ((com.tencent.beacon.core.strategy.c)localObject).b(1);
        if ((localObject != null) && (EventStrategyBean.getInstance() != null))
        {
          Set localSet = ((b)localObject).b();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setPreventEventCode(localSet);
          }
          localSet = ((b)localObject).c();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setSampleEvent(localSet);
          }
        }
        if ((!this.d) || (localObject == null)) {
          break;
        }
        i = d();
        if (i > 0)
        {
          i = 1;
          if (i == 0) {
            return;
          }
          com.tencent.beacon.core.e.d.e("[event] asyn up module %d", new Object[] { Integer.valueOf(1) });
          com.tencent.beacon.core.a.d.a().a(new g(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.e.d.a(localThrowable);
        com.tencent.beacon.core.e.d.b("[event] common query end error %s", new Object[] { localThrowable.toString() });
        return;
      }
      int i = 0;
    }
    com.tencent.beacon.core.e.d.b("[event] module is disable", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.h
 * JD-Core Version:    0.7.0.1
 */