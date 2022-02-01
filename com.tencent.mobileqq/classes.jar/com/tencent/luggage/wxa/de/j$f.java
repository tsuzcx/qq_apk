package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "isSuccess", "", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$f
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  j$f(j paramj, a parama, int paramInt, String paramString, b.y paramy, AtomicReference paramAtomicReference, Class paramClass, CountDownLatch paramCountDownLatch)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<anonymous parameter 1>");
    if (paramBoolean)
    {
      this.a.a(this.b);
      this.a.b(this.b);
      paramString = this.a.a(this.c, this.d, this.e, this.b);
      j.a(this.a, paramString, (c)new j.f.1(this));
      return;
    }
    this.f.set(null);
    this.h.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.f
 * JD-Core Version:    0.7.0.1
 */