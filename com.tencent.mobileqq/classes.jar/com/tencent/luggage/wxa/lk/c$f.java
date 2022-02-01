package com.tencent.luggage.wxa.lk;

import android.nfc.Tag;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$f
  implements Runnable
{
  c$f(c paramc, Function1 paramFunction1, String paramString1, String paramString2, com.tencent.luggage.wxa.ll.a parama) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    localObject1 = c.i((c)localObject1);
    if (localObject1 == null) {
      ((Function1)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
    }
    if (localObject1 != null)
    {
      localObject2 = this.a;
      Object localObject3 = this.c;
      localObject2 = this.b;
      localObject3 = (b)b.i.a().get(localObject3);
      if (localObject3 == null) {
        ((Function1)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 != null)
      {
        localObject2 = ((b)localObject3).c();
        if (localObject2 == null)
        {
          this.b.invoke(new e.a(13024, "function not support"));
          return;
        }
        ((a)localObject2).a((Tag)localObject1, this.d, this.e, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.f
 * JD-Core Version:    0.7.0.1
 */