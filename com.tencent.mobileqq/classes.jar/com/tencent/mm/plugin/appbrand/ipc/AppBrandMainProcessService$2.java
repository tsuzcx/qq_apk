package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class AppBrandMainProcessService$2
  extends a.a
{
  AppBrandMainProcessService$2(AppBrandMainProcessService paramAppBrandMainProcessService) {}
  
  public void a(Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.setData(paramBundle);
    AppBrandMainProcessService.a(this.a).send(localMessage);
  }
  
  public void a(IBinder paramIBinder, String paramString)
  {
    AppBrandMainProcessService.2.1 local1 = new AppBrandMainProcessService.2.1(this, paramString, paramIBinder);
    try
    {
      paramIBinder.linkToDeath(local1, 0);
      AppBrandMainProcessService.b(this.a).put(paramString, local1);
      AppBrandMainProcessService.b(paramString);
      return;
    }
    catch (Exception paramIBinder)
    {
      o.b("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramIBinder });
    }
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = AppBrandMainProcessService.a(paramBundle, false);
    if (paramBundle != null) {
      paramBundle.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */