package com.tencent.luggage.wxa.lk;

import android.nfc.NfcAdapter;
import com.tencent.luggage.wxa.lm.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$k
  implements Runnable
{
  c$k(c paramc, Function1 paramFunction1) {}
  
  public final void run()
  {
    if (c.a(this.a).get())
    {
      this.b.invoke(new e.a(13021, "NFC discovery already started"));
      return;
    }
    try
    {
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
      NfcAdapter localNfcAdapter = a.a();
      if (localNfcAdapter == null) {
        Intrinsics.throwNpe();
      }
      localNfcAdapter.enableForegroundDispatch(this.a.b(), c.b(this.a), c.d(), c.e());
      c.c(this.a);
      this.b.invoke(new e.b(Unit.INSTANCE));
      c.a(this.a).set(true);
      c.d(this.a);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableForegroundDispatch failed since ");
      localStringBuilder.append(localException);
      o.c("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
      this.b.invoke(new e.a(13017, "system internal error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.k
 * JD-Core Version:    0.7.0.1
 */