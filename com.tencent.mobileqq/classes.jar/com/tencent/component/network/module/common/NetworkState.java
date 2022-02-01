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
  private static final String TAG = "com.tencent.component.network.module.common.NetworkState";
  private static NetworkState instance;
  private static int networkType;
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
    int i = paramNetworkInfo.getType();
    if (i != 0)
    {
      if (i != 1) {
        networkType = 0;
      } else {
        networkType = 1;
      }
    }
    else {
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        break;
      case 13: 
        networkType = 6;
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
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        networkType = 3;
      }
    }
    return networkType;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    for (;;)
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
        if (paramContext != null)
        {
          j = paramContext.length;
          i = 0;
          break label62;
          if (localNetworkInfo.isConnectedOrConnecting())
          {
            getNetworkType(localNetworkInfo);
            return true;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (SecurityException paramContext)
      {
        return true;
      }
      catch (Throwable paramContext)
      {
        return false;
      }
      label62:
      if (i < j)
      {
        localNetworkInfo = paramContext[i];
        if (localNetworkInfo != null) {}
      }
    }
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      NetworkState.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkState.NetworkStateListener[this.observers.size()];
      this.observers.toArray(arrayOfNetworkStateListener);
      int j = arrayOfNetworkStateListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfNetworkStateListener[i].onNetworkConnect(paramBoolean);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject;
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
    Object localObject = this.context;
    if (localObject == null) {
      return true;
    }
    localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject == null) {
      return false;
    }
    boolean bool = ((NetworkInfo)localObject).isConnected();
    if (bool) {
      return bool;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNetworkEnable() : FALSE with TYPE = ");
    localStringBuilder.append(((NetworkInfo)localObject).getType());
    QDLog.e(str, localStringBuilder.toString());
    return bool;
  }
  
  public boolean isNetworkConnected()
  {
    Context localContext = this.context;
    if (localContext == null) {
      return true;
    }
    return isNetworkConnected(localContext);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkStateReceiver ====== ");
    localStringBuilder.append(paramIntent.getAction());
    QDLog.e(str, localStringBuilder.toString());
    if (paramIntent.getAction() == null) {
      return;
    }
    if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0) {
      GlobalHandlerThread.getInstance(paramContext).getHandler().post(new NetworkState.1(this, paramContext));
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkState
 * JD-Core Version:    0.7.0.1
 */