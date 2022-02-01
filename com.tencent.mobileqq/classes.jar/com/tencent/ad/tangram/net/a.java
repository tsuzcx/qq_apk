package com.tencent.ad.tangram.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;

public enum a
{
  INSTANCE;
  
  private static final String TAG = "AdIPV4";
  private volatile a.a address;
  private volatile boolean initialized = false;
  private a.b ipcHandler;
  private volatile long tryToUpdateCacheTimeMillis = -2147483648L;
  
  private a() {}
  
  private static String getIPV4AddressByNetwork(Context paramContext)
  {
    Throwable localThrowable1 = null;
    AdReporterForAnalysis.reportForGetIPV4Start(paramContext);
    long l = System.currentTimeMillis();
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(AdUriUtil.replaceHttpsWithHttpForVivoY67OnAndroidM("https://ipv4.gdt.qq.com/get_client_ip"));
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
  
  private void updateCacheIfNecessary(Context paramContext)
  {
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    boolean bool;
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
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
      else
      {
        if ((this.tryToUpdateCacheTimeMillis == -2147483648L) || (System.currentTimeMillis() - this.tryToUpdateCacheTimeMillis >= 60000L)) {
          break;
        }
        bool = false;
      }
    }
    if (paramContext != null) {}
    for (paramContext = new WeakReference(paramContext.getApplicationContext());; paramContext = null)
    {
      AdThreadManager.INSTANCE.post(new a.3(this, paramContext), 3);
      bool = true;
      break;
    }
  }
  
  public a.a getCache(Context paramContext)
  {
    updateCacheIfNecessary(paramContext);
    return this.address;
  }
  
  public void init(Context paramContext)
  {
    Object localObject2 = null;
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
    this.ipcHandler = new a.b();
    if (paramContext != null) {}
    for (Object localObject1 = paramContext.getApplicationContext();; localObject1 = null)
    {
      localObject1 = new WeakReference(localObject1);
      Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
      if ((localBoolean == null) || (!localBoolean.booleanValue())) {
        break;
      }
      AdThreadManager.INSTANCE.post(new a.1(this, (WeakReference)localObject1), 4);
      return;
    }
    localObject1 = localObject2;
    if (paramContext != null) {
      localObject1 = new WeakReference(paramContext.getApplicationContext());
    }
    AdThreadManager.INSTANCE.post(new a.2(this, (WeakReference)localObject1), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a
 * JD-Core Version:    0.7.0.1
 */