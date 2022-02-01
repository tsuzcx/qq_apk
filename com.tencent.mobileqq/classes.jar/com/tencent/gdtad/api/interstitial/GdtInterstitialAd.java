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
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import com.tencent.gdtad.util.GdtManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class GdtInterstitialAd
{
  private AdIPCManager.Callback jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback = new GdtInterstitialAd.1(this);
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public GdtInterstitialAd(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = paramGdtInterstitialParams;
    GdtManager.a().a(paramContext, null);
    GdtInterstitialPreDownloader.a().b(paramContext);
  }
  
  private GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  public void a(Activity paramActivity)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      GdtLog.b("GdtInterstitialAd", String.format("close %b", new Object[] { Boolean.valueOf(bool) }));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.b)
        {
          bool = false;
        }
        else if (a() == null)
        {
          bool = false;
        }
        else
        {
          this.b = true;
          Bundle localBundle = new Bundle();
          localBundle.putString("IPC_ACTION", "ipc_interstitial_close");
          localBundle.putString("IPC_TO_PROCESS_NAME", AdProcessManager.INSTANCE.getWebProcessName());
          localBundle.putString("TRACE_ID", a().a());
          AdIPCManager.INSTANCE.send(paramActivity, new AdIPCManager.Params(localBundle), new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Callback));
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    GdtLog.b("GdtInterstitialAd", "onClose");
    if (paramIntent == null) {}
    while ((GdtInterstitialStatus)paramIntent.getParcelableExtra("interstitialStatus") != null) {
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) {
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a = paramJSONObject;
    }
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (a() != null)) {
      return a().b();
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = 1;
    }
    for (;;)
    {
      GdtLog.b("GdtInterstitialAd", String.format("show %d", new Object[] { Integer.valueOf(i) }));
      GdtReporterForAnalysis.a(paramActivity, a(), i);
      if (i != 0) {
        break;
      }
      return true;
      if (!a())
      {
        i = 1;
      }
      else
      {
        int j = GdtInterstitialFragment.a(paramActivity, a());
        i = j;
        if (j == 0)
        {
          this.jdField_a_of_type_Boolean = true;
          i = 0;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialAd
 * JD-Core Version:    0.7.0.1
 */