package com.tencent.luggage.wxa.lk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class c$1
  extends c.c
{
  public void c()
  {
    super.c();
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "onDestroy");
    this.a.b().unregisterReceiver((BroadcastReceiver)c.j(this.a));
    c.f().remove(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.1
 * JD-Core Version:    0.7.0.1
 */