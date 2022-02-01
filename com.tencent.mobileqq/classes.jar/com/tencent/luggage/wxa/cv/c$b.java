package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qw.bt;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.hf;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$b
  implements Runnable
{
  c$b(c paramc, j paramj, Function2 paramFunction2, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject1 = c.a(this.a);
    Object localObject2 = this.b.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "req.ReqUrl");
    localObject2 = ((hf)localObject2).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "req.ReqUrl.string");
    localObject1 = (bt)((k)localObject1).a((String)localObject2, this.b.m).b((gt)this.b, bt.class);
    c.a(this.a, (bt)localObject1, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.c.b
 * JD-Core Version:    0.7.0.1
 */