package com.tencent.ad.tangram.ipc;

import android.support.annotation.Keep;
import android.text.TextUtils;
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
  private Map<String, AdIPCManager.Handler> map = new HashMap();
  
  private AdIPCManager() {}
  
  private AdIPCManager.Adapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdIPCManager.Adapter)this.adapter.get();
    }
    return null;
  }
  
  private AdIPCManager.Handler getHandler(String paramString)
  {
    return (AdIPCManager.Handler)this.map.get(paramString);
  }
  
  public AdIPCManager.Result receive(String paramString, AdIPCManager.Params paramParams)
  {
    paramString = getHandler(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.receive(paramParams);
  }
  
  public boolean register(String paramString, AdIPCManager.Handler paramHandler)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      AdLog.i("AdIPCManager", String.format("register action:%s result:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      return bool;
      if (paramHandler == null)
      {
        bool = false;
      }
      else if (this.map.containsKey(paramString))
      {
        bool = false;
      }
      else
      {
        this.map.put(paramString, paramHandler);
        bool = true;
      }
    }
  }
  
  public AdIPCManager.Result send(String paramString, AdIPCManager.Params paramParams)
  {
    AdIPCManager.Adapter localAdapter = getAdapter();
    if (localAdapter != null) {
      return localAdapter.send(paramString, paramParams);
    }
    return null;
  }
  
  public void setAdapter(WeakReference<AdIPCManager.Adapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager
 * JD-Core Version:    0.7.0.1
 */