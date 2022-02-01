package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rr.g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "productId", "", "deviceId", "", "kotlin.jvm.PlatformType", "username", "token", "hostAppId", "extraData", "callback"}, k=3, mv={1, 1, 16})
final class d$d
  implements b.a
{
  d$d(CountDownLatch paramCountDownLatch, AtomicReference paramAtomicReference) {}
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!af.c(paramString3))
    {
      this.a.countDown();
      this.b.set(g.a(Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4, paramString5));
    }
    else
    {
      this.a.countDown();
    }
    this.b.set(g.a(Integer.valueOf(-1), "", "", "", "", ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.d.d
 * JD-Core Version:    0.7.0.1
 */