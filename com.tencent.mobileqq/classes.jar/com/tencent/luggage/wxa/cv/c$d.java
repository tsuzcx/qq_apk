package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qw.hf;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$d
  implements Runnable
{
  c$d(Function2 paramFunction2, j paramj, String paramString) {}
  
  public final void run()
  {
    Function2 localFunction2 = this.a;
    if (localFunction2 != null)
    {
      Object localObject = this.b.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "req.ReqUrl");
      localObject = ((hf)localObject).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "req.ReqUrl.string");
      localFunction2.invoke(localObject, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.c.d
 * JD-Core Version:    0.7.0.1
 */