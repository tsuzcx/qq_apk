package com.tencent.ad.tangram.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public final class AdScreenStatusManager
  extends BroadcastReceiver
{
  private static final String TAG = "AdScreenStatusManager";
  private static volatile AdScreenStatusManager sInstance;
  private volatile boolean initialized = false;
  private volatile boolean isScreenOn = false;
  private CopyOnWriteArrayList<AdScreenStatusManager.a> listeners = new CopyOnWriteArrayList();
  
  public static AdScreenStatusManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AdScreenStatusManager();
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
      } while (paramContext == null);
      paramContext = paramContext.getApplicationContext();
    } while (paramContext == null);
    for (;;)
    {
      try
      {
        Object localObject = (PowerManager)paramContext.getSystemService("power");
        if ((localObject != null) && (((PowerManager)localObject).isScreenOn()))
        {
          bool = true;
          this.isScreenOn = bool;
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
          paramContext.registerReceiver(this, (IntentFilter)localObject);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdScreenStatusManager", "init error :", paramContext);
        return;
      }
      boolean bool = false;
    }
  }
  
  public boolean isScreenOn()
  {
    return this.isScreenOn;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      if (this.isScreenOn) {
        return;
      }
      this.isScreenOn = true;
    }
    for (;;)
    {
      paramContext = this.listeners.iterator();
      while (paramContext.hasNext())
      {
        paramIntent = (AdScreenStatusManager.a)paramContext.next();
        if (paramIntent != null) {
          paramIntent.onScreenStatusChanged(this.isScreenOn);
        }
      }
      break;
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        if (!this.isScreenOn) {
          break;
        }
        this.isScreenOn = false;
      }
    }
  }
  
  public void registerListener(AdScreenStatusManager.a parama)
  {
    if ((this.listeners != null) && (!this.listeners.contains(parama))) {
      this.listeners.add(parama);
    }
  }
  
  public void unRegisterListener(AdScreenStatusManager.a parama)
  {
    if ((this.listeners != null) && (this.listeners.contains(parama))) {
      this.listeners.remove(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdScreenStatusManager
 * JD-Core Version:    0.7.0.1
 */