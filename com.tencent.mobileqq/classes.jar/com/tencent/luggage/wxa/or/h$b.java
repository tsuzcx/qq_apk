package com.tencent.luggage.wxa.or;

import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.pd.t.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"}, k=3, mv={1, 1, 16})
final class h$b
  implements t.b
{
  h$b(h paramh) {}
  
  public final void a(t.a parama1, t.a parama2)
  {
    boolean bool = h.a(this.a);
    parama1 = h.b(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFourOrientationsChange, newOrientation: ");
    ((StringBuilder)localObject).append(parama2);
    ((StringBuilder)localObject).append(", isSystemOrientationLocked: ");
    ((StringBuilder)localObject).append(bool);
    o.e(parama1, ((StringBuilder)localObject).toString());
    if ((!bool) && (h.c(this.a) != parama2))
    {
      parama1 = ((Iterable)h.d(this.a)).iterator();
      while (parama1.hasNext())
      {
        localObject = (i)parama1.next();
        Intrinsics.checkExpressionValueIsNotNull(parama2, "newOrientation");
        ((i)localObject).a(parama2);
      }
      parama1 = this.a;
      Intrinsics.checkExpressionValueIsNotNull(parama2, "newOrientation");
      h.a(parama1, parama2);
    }
    parama1 = this.a;
    Intrinsics.checkExpressionValueIsNotNull(parama2, "newOrientation");
    h.b(parama1, parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.h.b
 * JD-Core Version:    0.7.0.1
 */