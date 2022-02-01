package com.tencent.ad.tangram.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public final class AdConnectivityManager
  extends BroadcastReceiver
{
  private static final String TAG = "AdConnectivityManager";
  private static volatile AdConnectivityManager sInstance = null;
  private volatile boolean initialized = false;
  private CopyOnWriteArrayList<AdConnectivityManager.Listener> listeners = new CopyOnWriteArrayList();
  
  public static AdConnectivityManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AdConnectivityManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {}
    do
    {
      return;
      try
      {
        if (this.initialized) {
          return;
        }
      }
      finally {}
      this.initialized = true;
    } while ((paramContext == null) || (paramContext.getApplicationContext() == null));
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdConnectivityManager", "init error:", paramContext);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = AdNet.isNetValid(paramContext);
    paramIntent = this.listeners.iterator();
    while (paramIntent.hasNext())
    {
      AdConnectivityManager.Listener localListener = (AdConnectivityManager.Listener)paramIntent.next();
      if (localListener != null) {
        localListener.onConnectivityChange(bool, AdNet.getType(paramContext));
      }
    }
  }
  
  public void registerListener(AdConnectivityManager.Listener paramListener)
  {
    if ((this.listeners != null) && (!this.listeners.contains(paramListener))) {
      this.listeners.add(paramListener);
    }
  }
  
  public void unRegisterListener(AdConnectivityManager.Listener paramListener)
  {
    if ((this.listeners != null) && (this.listeners.contains(paramListener))) {
      this.listeners.remove(paramListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdConnectivityManager
 * JD-Core Version:    0.7.0.1
 */