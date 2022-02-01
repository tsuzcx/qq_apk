package com.tencent.luggage.wxa.lk;

import android.nfc.tech.TagTechnology;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$g
  implements Runnable
{
  c$g(c paramc, Function1 paramFunction1, String paramString) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    localObject1 = c.i((c)localObject1);
    if (localObject1 == null) {
      ((Function1)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
    }
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = this.a;
      localObject3 = this.c;
      localObject2 = this.b;
      localObject3 = (b)b.i.a().get(localObject3);
      if (localObject3 == null) {
        ((Function1)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject3 != null)
      {
        if (b.h == localObject3)
        {
          this.b.invoke(new e.a(13024, "function not support"));
          return;
        }
        localObject2 = this.a;
        localObject2 = this.b;
      }
    }
    try
    {
      localObject1 = Reflect.on(((b)localObject3).b()).call("get", new Object[] { localObject1 }).get();
      if (localObject1 != null)
      {
        localObject1 = (TagTechnology)localObject1;
        break label213;
      }
      throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
    }
    catch (Exception localException2)
    {
      label192:
      break label192;
    }
    ((Function1)localObject2).invoke(new e.a(13015, "unavailable tech"));
    localObject1 = null;
    label213:
    if (localObject1 != null) {
      try
      {
        localObject1 = (Integer)Reflect.on(localObject1).call("getMaxTransceiveLength").get();
        localObject2 = this.b;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "length");
        ((Function1)localObject2).invoke(new e.b(localObject1));
        return;
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getMaxTransceiveLength failed since ");
        ((StringBuilder)localObject2).append(c.a(this.a, (Throwable)localException1));
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject2).toString());
        this.b.invoke(new e.a(13017, "system internal error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.g
 * JD-Core Version:    0.7.0.1
 */