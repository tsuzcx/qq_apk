package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class j$g<T>
  implements Action1<Long>
{
  j$g(j paramj) {}
  
  public final void a(Long paramLong)
  {
    o.b("MicroMsg.VideoCast.VideoCastDeviceManager", "search time out");
    this.a.e().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j.g
 * JD-Core Version:    0.7.0.1
 */