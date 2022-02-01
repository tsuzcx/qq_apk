package com.tencent.luggage.wxa.cx;

import android.content.Context;
import com.tencent.luggage.wxa.nl.j.a;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "err", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class i$b$3
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  i$b$3(i.b paramb)
  {
    super(2);
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    i.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("waitForPkgList onError(");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(')');
    com.tencent.luggage.wxa.qz.o.b("Luggage.SubProcessGetCodePkgNew", ((StringBuilder)localObject).toString());
    if ((d.a.b(this.a.d)) && (j.a.h.a() == paramInt))
    {
      i.a(this.a.a, this.a.d);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(r.a().getString(2131886878));
      localStringBuilder.append(' ');
      localStringBuilder.append(paramInt);
      localStringBuilder.append(',');
      if (paramString != null) {
        localObject = paramString;
      } else {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      t.a((Runnable)new i.b.3.1(localStringBuilder.toString()));
    }
    if (this.a.h.get()) {
      d.a(this.a.b, a.r, "", "", this.a.i, af.d());
    } else {
      d.a(this.a.b, a.q, "", "", this.a.i, af.d());
    }
    com.tencent.luggage.wxa.dc.o.c(this.a.b).a((e.c)new i.b.3.2(this, paramInt, paramString)).a((e.a)new i.b.3.3(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.i.b.3
 * JD-Core Version:    0.7.0.1
 */