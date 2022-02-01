package com.tencent.gdtad.api.interstitial;

import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

final class GdtInterstitialAd$IPCHandlerForClose
  implements AdIPCManager.Handler
{
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    String str;
    if ((paramParams != null) && (paramParams.isValid()) && (paramParams.bundle != null))
    {
      str = paramParams.bundle.getString("TRACE_ID");
      if (paramParams.bundle != null)
      {
        localObject = GdtInterstitialManager.a().a(str);
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          GdtInterstitialNotifyReg.c(BaseApplication.getContext(), ((GdtInterstitialFragment)((WeakReference)localObject).get()).a(), ((GdtInterstitialFragment)((WeakReference)localObject).get()).a());
          localResult.success = true;
          AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialAd.IPCHandlerForClose.1(this, str), 0, 2000L);
        }
      }
    }
    Object localObject = null;
    if (paramParams != null) {
      str = paramParams.getAction();
    } else {
      str = null;
    }
    if (paramParams != null) {
      localObject = paramParams.getToProcessName();
    }
    GdtLog.b("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", new Object[] { str, localObject, Boolean.valueOf(localResult.success) }));
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose
 * JD-Core Version:    0.7.0.1
 */