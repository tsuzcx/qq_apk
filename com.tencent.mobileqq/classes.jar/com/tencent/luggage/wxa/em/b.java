package com.tencent.luggage.wxa.em;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.o.a;
import com.tencent.mm.plugin.appbrand.page.o.d;
import com.tencent.mm.plugin.appbrand.page.o.h;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public class b
  extends com.tencent.luggage.wxa.dz.a
  implements o.a
{
  private final com.tencent.luggage.wxa.ds.c a;
  
  public b(Context paramContext, com.tencent.luggage.wxa.ed.d paramd)
  {
    super(paramContext, paramd);
    super.setDelegate(this);
    this.a = new com.tencent.luggage.wxa.ds.c(this);
    o();
  }
  
  public b(Context paramContext, com.tencent.luggage.wxa.ed.d paramd, o.a parama)
  {
    super(paramContext, paramd);
    super.setDelegate(parama);
    this.a = new com.tencent.luggage.wxa.ds.c(this);
    o();
  }
  
  private void o()
  {
    this.a.a(1);
    this.a.a(true);
  }
  
  @Nullable
  public m a(String paramString, bg parambg, @NonNull o paramo, @NonNull Callable<m> paramCallable)
  {
    return null;
  }
  
  protected o.h a(m paramm1, m paramm2)
  {
    o.h localh = super.a(paramm1, paramm2);
    this.a.a(paramm1, paramm2);
    return localh;
  }
  
  public o.h a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg, @NonNull String paramString, boolean paramBoolean)
  {
    paramString = super.a(paramm1, paramm2, parambg, paramString, paramBoolean);
    this.a.a(paramm1, paramm2, parambg);
    return paramString;
  }
  
  public u a(@NonNull o paramo)
  {
    return new c(com.tencent.luggage.wxa.eu.c.class);
  }
  
  public void a(@Nullable m paramm1, @NonNull m paramm2, @NonNull bg parambg)
  {
    super.a(paramm1, paramm2, parambg);
    this.a.b(paramm1, paramm2, parambg);
  }
  
  public void a(String paramString)
  {
    com.tencent.mm.plugin.appbrand.keylogger.d.a(getAppId(), com.tencent.luggage.wxa.oy.a.H);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(getAppId(), com.tencent.luggage.wxa.oy.a.I);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(getAppId(), com.tencent.luggage.wxa.oy.a.J);
    super.a(paramString);
    com.tencent.mm.plugin.appbrand.keylogger.d.b(getAppId(), com.tencent.luggage.wxa.oy.a.J);
    com.tencent.mm.plugin.appbrand.keylogger.d.b(getAppId(), com.tencent.luggage.wxa.oy.a.I);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(@NonNull String paramString, @NonNull bg parambg, @NonNull o paramo, @NonNull o.d paramd)
  {
    getRuntime().am().a(paramString, new b.1(this, paramd));
    return true;
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.b
 * JD-Core Version:    0.7.0.1
 */