package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class g$g<T>
  implements e.a<Object>
{
  g$g(List paramList, g.c paramc, g.h paramh) {}
  
  public final void a(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doCgi::onInterrupt Err=");
      paramObject = (a)paramObject;
      ((StringBuilder)localObject).append(paramObject.b());
      ((StringBuilder)localObject).append(", ErrCode=");
      ((StringBuilder)localObject).append(paramObject.c());
      ((StringBuilder)localObject).append(", ErrMsg=");
      ((StringBuilder)localObject).append(paramObject.d());
      ((StringBuilder)localObject).append(", queue.size=");
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(", reason=");
      ((StringBuilder)localObject).append(this.b);
      o.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", ((StringBuilder)localObject).toString());
      localObject = ((Iterable)this.a).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        g.d locald = (g.d)((Iterator)localObject).next();
        if (!g.a(g.a).a(locald)) {
          this.c.a(locald.b(), locald);
        } else {
          i += 1;
        }
      }
      if (i > 0) {
        g.a(g.a, 1074, 0, i);
      }
      this.c.a(paramObject.c(), paramObject.d());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doCgi::onInterrupt get unknown error(");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(')');
    o.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.g
 * JD-Core Version:    0.7.0.1
 */