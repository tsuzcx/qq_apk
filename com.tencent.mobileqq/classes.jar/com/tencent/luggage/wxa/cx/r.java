package com.tencent.luggage.wxa.cx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;

public class r
{
  public final String a;
  private final com.tencent.luggage.wxa.nn.a b;
  private boolean c = false;
  
  public r(@NonNull com.tencent.luggage.wxa.nn.a parama)
  {
    this.b = parama;
    this.a = p.a(parama);
    t.a.a(this.a, parama);
  }
  
  @Nullable
  private static String b(@Nullable hf paramhf)
  {
    if (paramhf == null) {
      return null;
    }
    return paramhf.toString();
  }
  
  public com.tencent.luggage.wxa.ro.d<c> a()
  {
    o.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "start() %d, %s", new Object[] { Integer.valueOf(hashCode()), this.b });
    t.a.a(this.a, t.d.b, t.c.b);
    String str = this.b.b;
    com.tencent.mm.plugin.appbrand.keylogger.d.a(str, com.tencent.luggage.wxa.oy.a.b);
    long l = af.d();
    return h.a().b(new r.3(this, str)).b(new r.2(this)).b(new r.1(this, str, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r
 * JD-Core Version:    0.7.0.1
 */