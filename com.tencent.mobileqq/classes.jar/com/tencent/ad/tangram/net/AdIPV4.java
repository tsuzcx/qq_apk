package com.tencent.ad.tangram.net;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdIPV4
{
  INSTANCE;
  
  private static final String TAG = "AdIPV4";
  private volatile AdIPV4.a address;
  private volatile boolean initialized = false;
  private AdIPV4.b ipcHandler;
  private volatile long tryToUpdateCacheTimeMillis = -2147483648L;
  
  private AdIPV4() {}
  
  private static String getIPV4AddressByNetwork(Context paramContext)
  {
    Throwable localThrowable1 = null;
    AdReporterForAnalysis.reportForGetIPV4Start(paramContext);
    long l = System.currentTimeMillis();
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://ipv4.gdt.qq.com/get_client_ip");
    localParams.method = "GET";
    localParams.connectTimeoutMillis = 3000;
    localParams.readTimeoutMillis = 3000;
    AdHttp.send(localParams);
    AdLog.i("AdIPV4", String.format("getIPV4AddressByNetwork responseCode:%d", new Object[] { Integer.valueOf(localParams.responseCode) }));
    String str;
    if (localParams.canSend()) {
      if (localParams.responseCode != 200) {
        str = null;
      }
    }
    for (;;)
    {
      AdReporterForAnalysis.reportForGetIPV4End(paramContext, System.currentTimeMillis() - l, localParams, str, localThrowable1);
      return str;
      try
      {
        str = new String(localParams.responseData, "UTF-8");
      }
      catch (Throwable localThrowable2)
      {
        AdLog.e("AdIPV4", "getIPV4AddressByNetwork", localThrowable2);
        str = null;
      }
      continue;
      str = null;
    }
  }
  
  private void updateCacheIfNecessary()
  {
    boolean bool;
    if (AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) {
      bool = false;
    }
    for (;;)
    {
      AdLog.i("AdIPV4", String.format("updateCacheIfNecessary %b", new Object[] { Boolean.valueOf(bool) }));
      return;
      if ((this.address != null) && (!TextUtils.isEmpty(this.address.ip)))
      {
        bool = false;
      }
      else if ((this.tryToUpdateCacheTimeMillis != -2147483648L) && (System.currentTimeMillis() - this.tryToUpdateCacheTimeMillis < 60000L))
      {
        bool = false;
      }
      else
      {
        AdThreadManager.INSTANCE.post(new AdIPV4.3(this), 3);
        bool = true;
      }
    }
  }
  
  public AdIPV4.a getCache()
  {
    updateCacheIfNecessary();
    return this.address;
  }
  
  public void init(Context paramContext)
  {
    AdLog.i("AdIPV4", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    this.ipcHandler = new AdIPV4.b();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      if (!AdProcessManager.INSTANCE.isOnMainProcess().booleanValue()) {
        break;
      }
      AdThreadManager.INSTANCE.post(new AdIPV4.1(this, paramContext), 4);
      return;
    }
    AdThreadManager.INSTANCE.post(new AdIPV4.2(this), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4
 * JD-Core Version:    0.7.0.1
 */