package com.tencent.luggage.wxa.lk;

import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$o
  implements Runnable
{
  c$o(c paramc, Function1 paramFunction1, NdefMessage paramNdefMessage) {}
  
  public final void run()
  {
    Object localObject2 = this.a;
    Object localObject1 = this.b;
    localObject2 = c.i((c)localObject2);
    if (localObject2 == null) {
      ((Function1)localObject1).invoke(new e.a(13013, "NFC tag has not been discovered"));
    }
    if (localObject2 != null)
    {
      localObject1 = Ndef.get((Tag)localObject2);
      if (localObject1 == null)
      {
        this.b.invoke(new e.a(13015, "unavailable tech"));
        return;
      }
      try
      {
        ((Ndef)localObject1).writeNdefMessage(this.c);
        this.b.invoke(new e.b(Unit.INSTANCE));
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("writeNdefMessage failed since ");
        ((StringBuilder)localObject2).append(localException);
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject2).toString());
        this.b.invoke(new e.a(13017, "system internal error"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.o
 * JD-Core Version:    0.7.0.1
 */