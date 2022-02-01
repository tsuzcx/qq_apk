package com.tencent.ad.tangram.lbs;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdLocationManager
{
  INSTANCE;
  
  private static final String TAG = "AdLocationManager";
  private volatile WeakReference<AdLocationAdapter> adapter;
  private volatile boolean initialized = false;
  private volatile AdLocationManager.a ipcHandler;
  private volatile AdLocation location;
  private volatile long tryToUpdateCacheTimeMillis = -2147483648L;
  
  private AdLocationManager() {}
  
  private AdLocation getLocation()
  {
    return this.location;
  }
  
  private void setLocation(AdLocation paramAdLocation)
  {
    AdThreadManager.INSTANCE.post(new AdLocationManager.1(this, paramAdLocation), 3);
  }
  
  private void updateLocationCacheOnChildProcess(Context paramContext, AdLocation paramAdLocation)
  {
    if (!this.initialized) {}
    Boolean localBoolean;
    do
    {
      return;
      localBoolean = AdProcessManager.INSTANCE.isOnMainProcess();
    } while ((localBoolean == null) || (localBoolean.booleanValue()) || ((this.tryToUpdateCacheTimeMillis != -2147483648L) && (System.currentTimeMillis() - this.tryToUpdateCacheTimeMillis < 60000L)));
    this.tryToUpdateCacheTimeMillis = System.currentTimeMillis();
    this.ipcHandler.updateCacheByIPC(paramContext, paramAdLocation);
  }
  
  private AdLocation updateLocationCacheOnCurrentProcess()
  {
    if (getAdapter() != null) {}
    for (AdLocation localAdLocation = getAdapter().getLocationCache();; localAdLocation = null)
    {
      localAdLocation = AdLocation.merge(localAdLocation, getLocation());
      setLocation(localAdLocation);
      return localAdLocation;
    }
  }
  
  public AdLocationAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdLocationAdapter)this.adapter.get();
    }
    return null;
  }
  
  public AdLocation getLocationCache(Context paramContext)
  {
    AdLocation localAdLocation = updateLocationCacheOnCurrentProcess();
    updateLocationCacheOnChildProcess(paramContext, localAdLocation);
    return localAdLocation;
  }
  
  public void init(Context paramContext)
  {
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
    this.ipcHandler = new AdLocationManager.a();
    this.initialized = true;
  }
  
  public void setAdapter(WeakReference<AdLocationAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocationManager
 * JD-Core Version:    0.7.0.1
 */