package com.tencent.luggage.wxa.lk;

import android.nfc.NfcAdapter;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.lm.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onPause", "", "type", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$PauseType;", "onResume", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c$i
  extends c.c
{
  public void a(@Nullable c.d paramd)
  {
    super.a(paramd);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "onPause");
    if (c.a(this.a).getAndSet(false))
    {
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", "onPause, isNFCDiscovering");
      try
      {
        o.d("MicroMsg.AppBrand.NFCReadWriteManager", "disableForegroundDispatch");
        paramd = a.a();
        if (paramd != null) {
          paramd.disableForegroundDispatch(this.a.b());
        }
      }
      catch (Exception paramd)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disableForegroundDispatch failed since ");
        localStringBuilder.append(paramd);
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
      }
      c.a(this.a, true);
    }
  }
  
  public void b()
  {
    super.b();
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "onResume");
    if (c.e(this.a))
    {
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, isNFCDiscoverySticky");
      if ((this.a.b() instanceof com.tencent.luggage.wxa.lh.c)) {
        ((com.tencent.luggage.wxa.lh.c)this.a.b()).a();
      }
      NfcAdapter localNfcAdapter = a.a();
      if ((localNfcAdapter != null) && (true == localNfcAdapter.isEnabled()))
      {
        try
        {
          o.d("MicroMsg.AppBrand.NFCReadWriteManager", "enableForegroundDispatch");
          localNfcAdapter = a.a();
          if (localNfcAdapter != null) {
            localNfcAdapter.enableForegroundDispatch(this.a.b(), c.b(this.a), c.d(), c.e());
          }
          c.a(this.a).set(true);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("enableForegroundDispatch failed since ");
          localStringBuilder.append(localException);
          o.c("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
        }
        c.a(this.a, false);
        return;
      }
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", "onResume, nfc is not enabled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.i
 * JD-Core Version:    0.7.0.1
 */