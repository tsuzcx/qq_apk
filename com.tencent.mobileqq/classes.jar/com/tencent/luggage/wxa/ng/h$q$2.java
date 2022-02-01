package com.tencent.luggage.wxa.ng;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "devicesCount", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$q$2
  extends Lambda
  implements Function1<Integer, Unit>
{
  h$q$2(h.q paramq)
  {
    super(1);
  }
  
  public final void a(int paramInt)
  {
    int i;
    if (this.a.b) {
      i = 4;
    } else {
      i = 2;
    }
    c localc = h.e(this.a.a);
    if (localc != null) {
      localc.a(paramInt, i);
    }
    h.d(this.a.a).e().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.q.2
 * JD-Core Version:    0.7.0.1
 */