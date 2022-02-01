package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.tencent.component.network.downloader.GlobalHandlerThread;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.List;

public class NetworkState
  extends BroadcastReceiver
{
  public static final int NETWORK_TYPE_2G = 3;
  public static final int NETWORK_TYPE_3G = 2;
  public static final int NETWORK_TYPE_4G = 6;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final int NETWORK_TYPE_WIFI = 1;
  private static final String TAG = NetworkState.class.getName();
  private static NetworkState instance = null;
  private static int networkType = 0;
  private Context context = null;
  private boolean loadProviderName = false;
  private List<NetworkState.NetworkStateListener> observers = new ArrayList();
  private String providerName = null;
  
  public static NetworkState g()
  {
    if (instance == null) {
      instance = new NetworkState();
    }
    return instance;
  }
  
  private static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    default: 
      networkType = 0;
    }
    for (;;)
    {
      return networkType;
      networkType = 1;
      continue;
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        networkType = 3;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        networkType = 2;
        break;
      case 13: 
        networkType = 6;
      }
    }
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    int j;
    int i;
    NetworkInfo localNetworkInfo;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label53;
      }
      j = paramContext.length;
      i = 0;
    }
    catch (SecurityException paramContext)
    {
      return true;
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    if (localNetworkInfo.isConnectedOrConnecting())
    {
      getNetworkType(localNetworkInfo);
      return true;
    }
    label53:
    label73:
    for (;;)
    {
      return false;
      for (;;)
      {
        if (i >= j) {
          break label73;
        }
        localNetworkInfo = paramContext[i];
        if (localNetworkInfo != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].onNetworkConnect(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public void addListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.observers)
    {
      if (!this.observers.contains(paramNetworkStateListener)) {
        this.observers.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public int getNetworkType()
  {
    return networkType;
  }
  
  public boolean isNetworkAvailable()
  {
    boolean bool1;
    if (this.context == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    QDLog.e(TAG, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public boolean isNetworkConnected()
  {
    if (this.context == null) {
      return true;
    }
    return isNetworkConnected(this.context);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QDLog.e(TAG, "NetworkStateReceiver ====== " + paramIntent.getAction());
    if (paramIntent.getAction() == null) {}
    while (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") != 0) {
      return;
    }
    GlobalHandlerThread.getInstance(paramContext).getHandler().post(new NetworkState.1(this, paramContext));
  }
  
  public void removeListener(NetworkState.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.observers)
    {
      this.observers.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    isNetworkConnected(paramContext);
  }
  
  public void unregisterReceiver()
  {
    this.context.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkState
 * JD-Core Version:    0.7.0.1
 */