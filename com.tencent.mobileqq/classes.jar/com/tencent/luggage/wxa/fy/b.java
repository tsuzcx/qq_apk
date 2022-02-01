package com.tencent.luggage.wxa.fy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.op.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public abstract class b<PipInfoProvider extends c>
{
  @Nullable
  private f a(u paramu)
  {
    paramu = paramu.q();
    if (paramu == null)
    {
      o.c(a(), "handlePipInfo, null == runtime");
      return null;
    }
    paramu = paramu.aR();
    if (paramu == null)
    {
      o.c(a(), "handlePipInfo, null == pipManager");
      return null;
    }
    return paramu;
  }
  
  @Nullable
  public static u d(a parama)
  {
    parama = parama.g();
    if (!(parama instanceof u))
    {
      o.c("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandPageView", new Object[] { parama });
      if (!(parama instanceof h))
      {
        o.c("MicroMsg.AppBrand.PipPluginHandlerCommons", "getPageView, component(%s) is not AppBrandService", new Object[] { parama });
        return null;
      }
      return ((h)parama).v();
    }
    return (u)parama;
  }
  
  @NonNull
  protected abstract String a();
  
  public void a(@NonNull a parama)
  {
    o.d(a(), "removePipId");
    parama = d(parama);
    if (parama == null) {
      return;
    }
    f localf = a(parama);
    if (localf == null) {
      return;
    }
    localf.a(parama, c());
  }
  
  public void a(@NonNull a parama, @NonNull String paramString)
  {
    o.d(a(), "handlePipInfo");
    u localu = d(parama);
    if (localu == null)
    {
      o.c(a(), "handlePipInfo, null == pageView");
      return;
    }
    m localm = localu.T();
    if (localm == null)
    {
      o.c(a(), "handlePipInfo, null == page");
      return;
    }
    f localf = a(localu);
    if (localf == null)
    {
      o.c(a(), "handlePipInfo, null == pipManager");
      return;
    }
    localf.a(localu);
    Object localObject = parama.d();
    if (localObject == null)
    {
      o.c(a(), "handlePipInfo, null == dataJsonObj");
      return;
    }
    parama = d();
    localObject = parama.a(((JSONObject)localObject).toString());
    if (localObject == null)
    {
      o.c(a(), "handlePipInfo, null == pipExtra");
      return;
    }
    paramString = new com.tencent.luggage.wxa.op.c(localf.b(), localm.getCurrentUrl(), paramString);
    localf.a(localu, c(), b(), (com.tencent.luggage.wxa.lp.b)localObject, parama.a(), parama.b(), parama.c(), paramString);
  }
  
  protected abstract int b();
  
  public boolean b(@NonNull a parama)
  {
    o.d(a(), "exitPip");
    parama = d(parama);
    if (parama == null) {
      return false;
    }
    parama = a(parama);
    if (parama == null) {
      return false;
    }
    return parama.a(b());
  }
  
  @NonNull
  protected abstract String c();
  
  public boolean c(@Nullable a parama)
  {
    o.d(a(), "amIPipPlayer");
    if (parama == null) {
      return false;
    }
    parama = d(parama);
    if (parama == null) {
      return false;
    }
    parama = a(parama);
    if (parama == null) {
      return false;
    }
    return parama.a(c());
  }
  
  @NonNull
  protected abstract PipInfoProvider d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.b
 * JD-Core Version:    0.7.0.1
 */