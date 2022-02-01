package com.tencent.luggage.wxa.cx;

import android.app.Activity;
import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.or.n;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class m$b
  implements Runnable
{
  m$b(m paramm, d paramd) {}
  
  public final void run()
  {
    c localc = this.b.W();
    Object localObject = localc;
    if (!(localc instanceof n)) {
      localObject = null;
    }
    localObject = (n)localObject;
    if (localObject != null) {
      localObject = ((n)localObject).u();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed()))
    {
      this.a.a((Activity)localObject);
      return;
    }
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.m.b
 * JD-Core Version:    0.7.0.1
 */