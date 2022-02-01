package com.tencent.luggage.wxa.lk;

import android.nfc.tech.TagTechnology;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$n
  implements Runnable
{
  c$n(c paramc, Function1 paramFunction1, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    localObject1 = c.i((c)localObject1);
    if (localObject1 == null) {
      ((Function1)localObject2).invoke(new e.a(13013, "NFC tag has not been discovered"));
    }
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject2 = this.a;
      localObject3 = this.c;
      localObject2 = this.b;
      localObject4 = (b)b.i.a().get(localObject3);
      if (localObject4 == null) {
        ((Function1)localObject2).invoke(new e.a(13014, "invalid tech"));
      }
      if (localObject4 != null)
      {
        if (b.h == localObject4)
        {
          this.b.invoke(new e.a(13024, "function not support"));
          return;
        }
        localObject2 = this.a;
        localObject3 = this.b;
        localObject2 = null;
      }
    }
    try
    {
      localObject1 = Reflect.on(((b)localObject4).b()).call("get", new Object[] { localObject1 }).get();
      if (localObject1 != null)
      {
        localObject1 = (TagTechnology)localObject1;
        break label220;
      }
      throw ((Throwable)new IllegalArgumentException("Required value was null.".toString()));
    }
    catch (Exception localException2)
    {
      label199:
      break label199;
    }
    ((Function1)localObject3).invoke(new e.a(13015, "unavailable tech"));
    localObject1 = null;
    label220:
    if (localObject1 != null) {
      try
      {
        localObject3 = (byte[])Reflect.on(localObject1).call("transceive", new Object[] { this.d }).get();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("transceive, rspData: ");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = Arrays.toString((byte[])localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.util.Arrays.toString(this)");
        }
        ((StringBuilder)localObject4).append((String)localObject1);
        o.e("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject4).toString());
        localObject1 = this.b;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "rspData");
        ((Function1)localObject1).invoke(new e.b(localObject3));
        return;
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("transceive failed since ");
        ((StringBuilder)localObject2).append(c.a(this.a, (Throwable)localException1));
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject2).toString());
        this.b.invoke(new e.a(13017, "system internal error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.n
 * JD-Core Version:    0.7.0.1
 */