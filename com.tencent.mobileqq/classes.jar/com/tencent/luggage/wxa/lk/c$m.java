package com.tencent.luggage.wxa.lk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c$m
  extends BroadcastReceiver
{
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = ((Number)Integer.valueOf(paramIntent.getIntExtra("android.nfc.extra.ADAPTER_STATE", -1))).intValue();
      if (-1 == i)
      {
        o.c("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is invalid");
        return;
      }
      boolean bool;
      if (3 == i) {
        bool = true;
      } else {
        bool = false;
      }
      paramContext = new StringBuilder();
      paramContext.append("onReceive#sysNfcSwitchToggleListener, isNFCEnabled: ");
      paramContext.append(bool);
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", paramContext.toString());
      if (!bool)
      {
        c.a(this.a).set(false);
        c.a(this.a, false);
      }
    }
    else
    {
      paramContext = (m)this;
      o.c("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.m
 * JD-Core Version:    0.7.0.1
 */