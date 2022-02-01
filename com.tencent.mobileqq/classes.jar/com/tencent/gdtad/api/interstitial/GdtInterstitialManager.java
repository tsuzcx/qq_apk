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
  private static volatile GdtInterstitialManager jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
  private volatile GdtArkApp jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkApp;
  private GdtInterstitialNotifyReg jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialNotifyReg = new GdtInterstitialNotifyReg();
  private Map<String, WeakReference<GdtInterstitialFragment>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  private GdtInterstitialManager(GdtArkApp paramGdtArkApp)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialManager.1(this), 0);
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkApp = paramGdtArkApp;
  }
  
  public static GdtInterstitialManager a()
  {
    if (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager == null)
        {
          GdtArkApp localGdtArkApp = new GdtArkApp();
          localGdtArkApp.a = "com.tencent.tangram.interstitial";
          localGdtArkApp.b = "Index";
          localGdtArkApp.c = "1.0.0.1";
          jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager = new GdtInterstitialManager(localGdtArkApp);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager;
  }
  
  GdtAppReceiver a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  GdtArkApp a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtArkApp;
  }
  
  GdtInterstitialNotifyReg a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialNotifyReg;
  }
  
  WeakReference<GdtInterstitialFragment> a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return null;
    }
    return (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    GdtLog.b("GdtInterstitialManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialManager)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      AdIPCManager.INSTANCE.register("ipc_interstitial_close", new GdtInterstitialAd.IPCHandlerForClose());
      AdIPCManager.INSTANCE.register("ipc_interstitial_predownload", new GdtInterstitialPreDownloader.IPCHandlerForPreDownload());
      return;
    }
  }
  
  boolean a(String paramString)
  {
    boolean bool;
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
    {
      bool = false;
    }
    else
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      bool = true;
    }
    GdtLog.b("GdtInterstitialManager", String.format("unregister %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
    return bool;
  }
  
  boolean a(String paramString, WeakReference<GdtInterstitialFragment> paramWeakReference)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (paramWeakReference != null) && (paramWeakReference.get() != null))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramWeakReference);
      bool = true;
    }
    else
    {
      bool = false;
    }
    GdtLog.b("GdtInterstitialManager", String.format("register %b traceId:%s", new Object[] { Boolean.valueOf(bool), paramString }));
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialManager
 * JD-Core Version:    0.7.0.1
 */