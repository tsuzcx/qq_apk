package com.tencent.luggage.wxa.fu;

import android.app.Application;
import android.content.Context;
import com.tencent.luggage.util.o;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.bb.a.b;
import com.tencent.luggage.wxa.dc.s;
import com.tencent.luggage.wxa.dc.x;
import com.tencent.luggage.wxa.de.d;
import com.tencent.luggage.wxa.de.l;
import com.tencent.luggage.wxa.fj.g;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.r.a;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/process/WxaProcessStartup;", "Lcom/tencent/luggage/wxaapi/internal/process/CommonProcessStartup;", "()V", "TAG", "", "initialize", "", "context", "Landroid/content/Context;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
  extends a
{
  public static final h a = new h();
  
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    super.a(paramContext);
    if ((paramContext instanceof Application))
    {
      paramContext = (Application)paramContext;
    }
    else
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {
        break label204;
      }
      paramContext = (Application)paramContext;
    }
    r.a((r.a)h.a.a);
    com.tencent.luggage.wxa.fi.a.a.a(paramContext);
    Context localContext = (Context)paramContext;
    com.tencent.luggage.wxa.bb.a.a((a.b)new h.b(paramContext, localContext));
    com.tencent.luggage.wxa.standalone_open_runtime.app.b.a.a(paramContext);
    String str = r.c();
    Intrinsics.checkExpressionValueIsNotNull(str, "MMApplicationContext.getProcessName()");
    new com.tencent.luggage.wxa.ec.a(str).g();
    com.tencent.luggage.wxa.fv.i.a.a(paramContext);
    e.a(d.class, (com.tencent.luggage.wxa.ba.b)l.a);
    s.a.a((com.tencent.luggage.wxa.ob.b)l.a);
    x.a(paramContext);
    com.tencent.luggage.wxa.ft.b.a.a(paramContext);
    com.tencent.luggage.wxa.fv.a.h();
    com.tencent.luggage.wxa.dd.i.a.a(true);
    com.tencent.luggage.wxa.pe.a.a.a(localContext);
    com.tencent.luggage.wxa.standalone_open_runtime.app.c.a.a(paramContext);
    com.tencent.luggage.wxa.ev.c.a();
    g.b.b();
    com.tencent.luggage.wxa.iq.a.a((com.tencent.luggage.wxa.io.b)h.c.a);
    e.a(com.tencent.luggage.wxa.ng.b.class, (com.tencent.luggage.wxa.ba.b)new o());
    return;
    label204:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.h
 * JD-Core Version:    0.7.0.1
 */