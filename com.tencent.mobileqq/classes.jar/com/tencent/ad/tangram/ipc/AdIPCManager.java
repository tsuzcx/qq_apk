package com.tencent.ad.tangram.ipc;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@Keep
public enum AdIPCManager
{
  INSTANCE;
  
  private static final String TAG = "AdIPCManager";
  private WeakReference<AdIPCManager.Adapter> adapter;
  private volatile boolean initialized = false;
  private Map<String, AdIPCManager.Handler> map = new HashMap();
  
  private AdIPCManager() {}
  
  public AdIPCManager.Handler getHandler(String paramString)
  {
    WeakReference localWeakReference = this.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((AdIPCManager.Adapter)this.adapter.get()).getHandler(paramString);
    }
    return null;
  }
  
  public void init(Context paramContext, WeakReference<AdIPCManager.Adapter> paramWeakReference)
  {
    AdLog.i("AdIPCManager", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
      this.initialized = true;
      this.adapter = paramWeakReference;
      if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
        ((AdIPCManager.Adapter)paramWeakReference.get()).init(paramContext);
      }
      return;
    }
    finally {}
  }
  
  public boolean register(String paramString, AdIPCManager.Handler paramHandler)
  {
    WeakReference localWeakReference = this.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((AdIPCManager.Adapter)this.adapter.get()).register(paramString, paramHandler);
    }
    return false;
  }
  
  public AdIPCManager.Result send(Context paramContext, AdIPCManager.Params paramParams)
  {
    WeakReference localWeakReference = this.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((AdIPCManager.Adapter)this.adapter.get()).send(paramContext, paramParams);
    }
    return null;
  }
  
  public void send(Context paramContext, AdIPCManager.Params paramParams, WeakReference<AdIPCManager.Callback> paramWeakReference)
  {
    WeakReference localWeakReference = this.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AdIPCManager.Adapter)this.adapter.get()).send(paramContext, paramParams, paramWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager
 * JD-Core Version:    0.7.0.1
 */