package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.o;

final class AppBrandMainProcessService$3
  extends Handler
{
  AppBrandMainProcessService$3(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = AppBrandMainProcessService.a(paramMessage.getData(), false);
    if (paramMessage == null) {
      return;
    }
    b localb = AppBrandMainProcessService.c(paramMessage.d());
    if (localb == null)
    {
      o.b("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramMessage.d() });
      return;
    }
    AppBrandMainProcessService.a(paramMessage, localb);
    localb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.3
 * JD-Core Version:    0.7.0.1
 */