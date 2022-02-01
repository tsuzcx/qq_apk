package com.tencent.luggage.wxa.lh;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

class h$2
  implements Application.ActivityLifecycleCallbacks
{
  private boolean b = false;
  
  h$2(h paramh) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityPaused");
    a.a.c();
    this.b = true;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityResumed");
    if (this.b)
    {
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo onActivityResumed isPaused and do checLogic");
      this.b = false;
      a.a.a();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.h.2
 * JD-Core Version:    0.7.0.1
 */