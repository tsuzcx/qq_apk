package com.tencent.luggage.wxa.lk;

import android.nfc.tech.TagTechnology;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$h
  implements Runnable
{
  c$h(c paramc, Function1 paramFunction1, String paramString) {}
  
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
        break label183;
      }
      throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
    }
    catch (Exception localException2)
    {
      label162:
      break label162;
    }
    ((Function1)localObject2).invoke(new e.a(13015, "unavailable tech"));
    localObject1 = null;
    label183:
    if (localObject1 != null) {
      try
      {
        this.b.invoke(new e.b(Boolean.valueOf(((TagTechnology)localObject1).isConnected())));
        return;
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("check isConnected failed since ");
        ((StringBuilder)localObject2).append(localException1);
        o.d("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject2).toString());
        this.b.invoke(new e.a(13017, "system internal error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.h
 * JD-Core Version:    0.7.0.1
 */