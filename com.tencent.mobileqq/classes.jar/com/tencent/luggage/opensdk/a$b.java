package com.tencent.luggage.opensdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.rm.a;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class a$b
  implements a.a
{
  private final com.tencent.luggage.wxa.iu.b a;
  private final c.a b = new a.b.1(this);
  private final ConcurrentSkipListSet<Runnable> c = new ConcurrentSkipListSet(new a.b.2(this));
  
  private a$b(com.tencent.luggage.wxa.iu.b paramb)
  {
    this.a = paramb;
    if (this.a.q() != null) {
      this.a.q().al().a(this.b);
    }
  }
  
  @Nullable
  public <T extends com.tencent.luggage.wxa.ba.b> T a(Class<T> paramClass)
  {
    return this.a.a(paramClass);
  }
  
  public com.tencent.luggage.wxa.jx.m a(String paramString)
  {
    return this.a.d(paramString);
  }
  
  public String a()
  {
    return this.a.getAppId();
  }
  
  public void a(a parama)
  {
    this.a.q().a(parama);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.c.add(paramRunnable);
  }
  
  @Nullable
  public String b()
  {
    return this.a.getContext().getClass().getName();
  }
  
  public boolean c()
  {
    return true;
  }
  
  @Nullable
  public Context d()
  {
    return this.a.getContext();
  }
  
  public void e()
  {
    if (this.a.q() != null) {
      this.a.q().al().b(this.b);
    }
    this.c.clear();
  }
  
  public int f()
  {
    return this.a.q().B().G;
  }
  
  public String g()
  {
    try
    {
      String str = this.a.q().C().getCurrentUrl();
      return str;
    }
    catch (Exception localException)
    {
      label16:
      break label16;
    }
    return "";
  }
  
  public String h()
  {
    try
    {
      String str = this.a.q().C().getCurrentPage().getCurrentPageView().aD();
      return str;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    return "";
  }
  
  public com.tencent.luggage.wxa.iu.b i()
  {
    return this.a;
  }
  
  public void j()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.a.b
 * JD-Core Version:    0.7.0.1
 */