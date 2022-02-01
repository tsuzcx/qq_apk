package com.tencent.luggage.wxa.lk;

import android.nfc.tech.TagTechnology;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$j
  implements Runnable
{
  c$j(c paramc, Function1 paramFunction1, String paramString, int paramInt) {}
  
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
      localObject2 = this.c;
      localObject3 = this.b;
      localObject2 = (b)b.i.a().get(localObject2);
      if (localObject2 == null) {
        ((Function1)localObject3).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject2 != null)
      {
        if (!((b)localObject2).a("setTimeout", new Class[] { Integer.TYPE }))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setTimeout, ");
          ((StringBuilder)localObject1).append(((b)localObject2).a());
          ((StringBuilder)localObject1).append(".setTimeout is not supported");
          o.d("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject1).toString());
          this.b.invoke(new e.a(13024, "function not support"));
          return;
        }
        localObject3 = this.a;
        localObject3 = this.b;
      }
    }
    try
    {
      localObject1 = Reflect.on(((b)localObject2).b()).call("get", new Object[] { localObject1 }).get();
      if (localObject1 != null)
      {
        localObject1 = (TagTechnology)localObject1;
        break label265;
      }
      throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
    }
    catch (Exception localException2)
    {
      label244:
      break label244;
    }
    ((Function1)localObject3).invoke(new e.a(13015, "unavailable tech"));
    localObject1 = null;
    label265:
    if (localObject1 != null) {
      try
      {
        Reflect.on(localObject1).call("setTimeout", new Object[] { Integer.valueOf(this.d) });
        this.b.invoke(new e.b(Unit.INSTANCE));
        return;
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setTimeout failed since ");
        ((StringBuilder)localObject2).append(c.a(this.a, (Throwable)localException1));
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject2).toString());
        this.b.invoke(new e.a(13017, "system internal error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.j
 * JD-Core Version:    0.7.0.1
 */