package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.nl.g;
import com.tencent.luggage.wxa.qw.ar;
import com.tencent.luggage.wxa.qw.ld;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "DELIVER", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckDemoInfoResponse;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class a$a<T>
  implements e.c<ar>
{
  a$a(a parama, Object paramObject, com.tencent.luggage.wxa.ro.b paramb) {}
  
  public final void a(ar paramar)
  {
    Object localObject1 = a.a(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onTerminate ErrCode[");
    ((StringBuilder)localObject2).append(paramar.a.a);
    ((StringBuilder)localObject2).append(']');
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    int i = paramar.a.a;
    if (i == 0)
    {
      if (paramar.b)
      {
        localObject1 = (CharSequence)paramar.d;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = (CharSequence)paramar.c;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i == 0) {
            ac.a().a(a.b(this.a), 2, paramar.c, paramar.d);
          }
        }
      }
      localObject1 = (CharSequence)paramar.h;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        g.a().a(a.b(this.a), 2, paramar.h);
      }
      a.a(this.a, this.b, t.d.e, t.c.c, null, 8, null);
      this.c.a(new Object[] { this.b });
      return;
    }
    if (i == com.tencent.luggage.wxa.dc.b.a.c())
    {
      a.a(this.a, this.b, t.d.e, t.c.d, "MM_ERR_BIZ_USER_NOT_IN_WHITE_LIST");
      this.c.a(new com.tencent.luggage.wxa.cy.b(3, null, 2, null));
      return;
    }
    if (i == com.tencent.luggage.wxa.dc.b.a.b())
    {
      a.a(this.a, this.b, t.d.e, t.c.d, "MM_ERR_BIZ_DEMO_HAS_BEEN_DELETED");
      this.c.a(new com.tencent.luggage.wxa.cy.b(4, null, 2, null));
      return;
    }
    paramar = this.a;
    localObject1 = this.b;
    localObject2 = t.d.e;
    t.c localc = t.c.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ERR_NETWORK:UNKNOWN(");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    a.a(paramar, localObject1, (t.d)localObject2, localc, localStringBuilder.toString());
    paramar = this.c;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("UNKNOWN(");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(')');
    paramar.a(new com.tencent.luggage.wxa.cy.b(1, ((StringBuilder)localObject1).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.a.a
 * JD-Core Version:    0.7.0.1
 */