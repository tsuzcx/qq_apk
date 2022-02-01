package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class GdtInterstitialManager
{
  private static volatile GdtInterstitialManager a;
  private volatile boolean b = false;
  private GdtInterstitialNotifyReg c = new GdtInterstitialNotifyReg();
  private GdtAppReceiver d = new GdtAppReceiver();
  private volatile GdtArkApp e;
  private Map<String, WeakReference<GdtInterstitialFragment>> f = new HashMap();
  
  private GdtInterstitialManager(GdtArkApp paramGdtArkApp)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.e = paramGdtArkApp;
  }
  
  public static GdtInterstitialManager a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          GdtArkApp localGdtArkApp = new GdtArkApp();
          localGdtArkApp.a = "com.tencent.tangram.interstitial";
          localGdtArkApp.b = "Index";
          localGdtArkApp.c = "1.0.0.1";
          a = new GdtInterstitialManager(localGdtArkApp);
        }
      }
      finally {}
    }
    return a;
  }
  
  WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.f.containsKey(paramString))) {
      return null;
    }
    return (WeakReference)this.f.get(paramString);
  }
  
  boolean a(String paramString, WeakReference<GdtInterstitialFragment> paramWeakReference)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!this.f.containsKey(paramString)) && (paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      this.f.put(paramString, paramWeakReference);
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
    return bool;
  }
  
  public void b()
  {
    GdtLog.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.b) }));
    if (this.b) {
      return;
    }
    synchronized (a)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      AdIPCManager.INSTANCE.register("ipc_interstitial_close", new GdtInterstitialAd.IPCHandlerForClose());
      AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new GdtInterstitialPreDownloader.IPCHandlerForPreDownload());
      return;
    }
  }
  
  boolean b(String paramString)
  {
    boolean bool;
    if ((TextUtils.isEmpty(paramString)) || (!this.f.containsKey(paramString)))
    {
      bool = false;
    }
    else
    {
      this.f.remove(paramString);
      bool = true;
    }
    GdtLog.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
    return bool;
  }
  
  GdtAppReceiver c()
  {
    return this.d;
  }
  
  GdtArkApp d()
  {
    return this.e;
  }
  
  GdtInterstitialNotifyReg e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialManager
 * JD-Core Version:    0.7.0.1
 */