package com.tencent.ad.tangram.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
    AdAnalysisHelperForUtil.reportForGetIPV4Start(paramContext);
    long l = System.currentTimeMillis();
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(AdUriUtil.replaceHttpsWithHttpForVivoY67OnAndroidM("https://ipv4.gdt.qq.com/get_client_ip"));
    localParams.method = "GET";
    localParams.connectTimeoutMillis = 3000;
    localParams.readTimeoutMillis = 3000;
    AdHttp.send(localParams);
    AdLog.i("AdIPV4", String.format("getIPV4AddressByNetwork responseCode:%d", new Object[] { Integer.valueOf(localParams.responseCode) }));
    Object localObject2;
    Throwable localThrowable2;
    if ((localParams.canSend()) && (localParams.responseCode == 200))
    {
      try
      {
        localObject2 = new String(localParams.responseData, "UTF-8");
        Object localObject1 = null;
      }
      catch (Throwable localThrowable1)
      {
        AdLog.e("AdIPV4", "getIPV4AddressByNetwork", localThrowable1);
        localObject2 = null;
      }
    }
    else
    {
      localThrowable2 = null;
      localObject2 = localThrowable2;
    }
    AdAnalysisHelperForUtil.reportForGetIPV4End(paramContext, System.currentTimeMillis() - l, localParams, (String)localObject2, localThrowable2);
    return localObject2;
  }
  
  private void updateCacheIfNecessary(Context paramContext)
  {
    if (!this.initialized) {
      return;
    }
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    if (localBoolean == null) {
      AdLog.e("AdIPV4", "updateCacheIfNecessary isOnMainProcess == null");
    } else {
      if ((!localBoolean.booleanValue()) && ((this.address == null) || (TextUtils.isEmpty(this.address.ip))) && ((this.tryToUpdateCacheTimeMillis == -2147483648L) || (System.currentTimeMillis() - this.tryToUpdateCacheTimeMillis >= 60000L))) {
        break label93;
      }
    }
    boolean bool = false;
    break label133;
    label93:
    if (paramContext != null) {
      paramContext = new WeakReference(paramContext.getApplicationContext());
    } else {
      paramContext = null;
    }
    AdThreadManager.INSTANCE.post(new a.3(this, paramContext), 3);
    bool = true;
    label133:
    AdLog.i("AdIPV4", String.format("updateCacheIfNecessary %b", new Object[] { Boolean.valueOf(bool) }));
  }
  
  public a.a getCache(Context paramContext)
  {
    updateCacheIfNecessary(paramContext);
    return this.address;
  }
  
  public void init(Context paramContext)
  {
    AdLog.i("AdIPV4", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    Object localObject2 = null;
    if (paramContext != null) {
      localObject1 = paramContext.getApplicationContext();
    } else {
      localObject1 = null;
    }
    Object localObject1 = new WeakReference(localObject1);
    Boolean localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    try
    {
      if (this.initialized) {
        return;
      }
      if (localBoolean == null)
      {
        AdLog.e("AdIPV4", "getCache isOnMainProcess == null");
        return;
      }
      this.ipcHandler = new a.b();
      this.initialized = true;
      if (localBoolean.booleanValue())
      {
        AdThreadManager.INSTANCE.post(new a.1(this, (WeakReference)localObject1), 4);
        return;
      }
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = new WeakReference(paramContext.getApplicationContext());
      }
      AdThreadManager.INSTANCE.post(new a.2(this, (WeakReference)localObject1), 3);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a
 * JD-Core Version:    0.7.0.1
 */