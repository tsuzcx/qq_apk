package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ac$b
  implements Runnable
{
  ac$b(ac paramac, b paramb, int paramInt) {}
  
  public final void run()
  {
    Object localObject = this.b;
    if ((localObject instanceof u)) {
      localObject = (u)localObject;
    } else if ((localObject instanceof h)) {
      localObject = ((h)localObject).v();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((u)localObject).aB();
      this.b.a(this.c, this.a.b("ok"));
      return;
    }
    ((Function0)new ac.b.1(this)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ac.b
 * JD-Core Version:    0.7.0.1
 */