package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class GdtInterstitialAd
  implements IGdtInterstitialAd
{
  private GdtInterstitialParams a;
  private boolean b = false;
  private boolean c = false;
  private AdIPCManager.Callback d = new GdtInterstitialAd.1(this);
  
  public GdtInterstitialAd(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.a = paramGdtInterstitialParams;
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(paramContext, new InitGdtContextParams());
    GdtInterstitialPreDownloader.a().b(paramContext);
  }
  
  private GdtInterstitialParams b()
  {
    return this.a;
  }
  
  public void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    GdtLog.b("GdtInterstitialAd", "onClose");
    if (paramIntent == null) {
      return;
    }
    paramActivity = (GdtInterstitialStatus)paramIntent.getParcelableExtra("interstitialStatus");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    GdtInterstitialParams localGdtInterstitialParams = this.a;
    if (localGdtInterstitialParams != null) {
      localGdtInterstitialParams.c = paramJSONObject;
    }
  }
  
  public boolean a()
  {
    if ((!this.b) && (b() != null)) {
      return b().b();
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = Looper.getMainLooper();
    boolean bool = false;
    int i;
    if ((localLooper1 != localLooper2) || (!a()))
    {
      i = 1;
    }
    else
    {
      i = GdtInterstitialFragment.a(paramActivity, b());
      if (i == 0)
      {
        this.b = true;
        i = 0;
      }
    }
    GdtLog.b("GdtInterstitialAd", String.format("show %d", new Object[] { Integer.valueOf(i) }));
    GdtAnalysisHelperForInterstitial.a(paramActivity, b(), i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b(Activity paramActivity)
  {
    boolean bool;
    if ((Looper.myLooper() == Looper.getMainLooper()) && (this.b) && (!this.c) && (b() != null))
    {
      this.c = true;
      Bundle localBundle = new Bundle();
      localBundle.putString("IPC_ACTION", "ipc_interstitial_close");
      localBundle.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
      localBundle.putString("TRACE_ID", b().c());
      AdIPCManager.INSTANCE.send(paramActivity, new AdIPCManager.Params(localBundle), new WeakReference(this.d));
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialAd", String.format("close %b", new Object[] { Boolean.valueOf(bool) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd
 * JD-Core Version:    0.7.0.1
 */