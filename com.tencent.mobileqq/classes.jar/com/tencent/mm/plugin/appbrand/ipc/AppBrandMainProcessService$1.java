package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

class AppBrandMainProcessService$1
  extends Handler
{
  AppBrandMainProcessService$1(AppBrandMainProcessService paramAppBrandMainProcessService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = AppBrandMainProcessService.a(paramMessage.getData(), true);
    if (paramMessage != null) {
      f.a.a(new AppBrandMainProcessService.1.1(this, paramMessage), "MicroMsg.AppBrandMainProcessService");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.1
 * JD-Core Version:    0.7.0.1
 */