package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "DELIVER", "it", "", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class b$a<T>
  implements e.c<Boolean>
{
  b$a(b paramb, Object paramObject, com.tencent.luggage.wxa.ro.b paramb1) {}
  
  public final void a(Boolean paramBoolean)
  {
    paramBoolean = b.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTerminate appId:");
    localStringBuilder.append(b.b(this.a));
    o.d(paramBoolean, localStringBuilder.toString());
    b.a(this.a, this.b, t.d.f, t.c.c, null, 8, null);
    this.c.a(new Object[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.b.a
 * JD-Core Version:    0.7.0.1
 */