package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.jx.az;
import com.tencent.luggage.wxa.jx.ba;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.e.b;
import com.tencent.magicbrush.e.d;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

class a$c
  implements e.b, e.d
{
  private a$c(a parama) {}
  
  public void a()
  {
    a.f(this.a);
  }
  
  public void a(@NotNull String paramString)
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
    com.tencent.luggage.wxa.ed.d locald = ((c)this.a.y()).i();
    if ((locald == null) || (locald.i() == null) || (locald.i().b)) {
      a.a(this.a, paramString);
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    o.b("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
    Object localObject = (s)((c)this.a.y()).getJsRuntime().a(s.class);
    if (paramInt == ((s)localObject).e().d())
    {
      az.a(((c)this.a.y()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { k.a(paramString1), k.a(paramString2) }), 0);
      return;
    }
    localObject = ((s)localObject).a(paramInt);
    if (localObject != null)
    {
      ba.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { k.a(paramString1), k.a(paramString2) }), 0);
      return;
    }
    throw new IllegalStateException("j2v8 not follow the pattern");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.c
 * JD-Core Version:    0.7.0.1
 */