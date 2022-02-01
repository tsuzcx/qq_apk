package com.tencent.mm.plugin.appbrand.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class AppBrandMainProcessService$2$1
  implements IBinder.DeathRecipient
{
  AppBrandMainProcessService$2$1(AppBrandMainProcessService.2 param2, String paramString, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    IBinder.DeathRecipient localDeathRecipient = (IBinder.DeathRecipient)AppBrandMainProcessService.b(this.c.a).get(this.a);
    if (localDeathRecipient == null) {
      return;
    }
    this.b.unlinkToDeath(localDeathRecipient, 0);
    AppBrandMainProcessService.b(this.c.a).remove(this.a);
    AppBrandMainProcessService.a(this.a);
    o.b("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2.1
 * JD-Core Version:    0.7.0.1
 */