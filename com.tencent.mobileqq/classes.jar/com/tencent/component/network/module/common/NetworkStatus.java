package com.tencent.component.network.module.common;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.NetworkUtils.DNS;

public class NetworkStatus
{
  private static volatile NetworkStatus sInstance;
  private final Context mContext;
  private NetworkUtils.DNS mDNS;
  
  private NetworkStatus(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    init();
  }
  
  public static NetworkStatus getInstance(Context paramContext)
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance != null)
      {
        paramContext = sInstance;
        return paramContext;
      }
    }
    finally {}
    paramContext = new NetworkStatus(paramContext);
    sInstance = paramContext;
    return paramContext;
  }
  
  private void init()
  {
    refreshDNS();
    NetworkStatus.1 local1 = new NetworkStatus.1(this);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.mContext.registerReceiver(local1, localIntentFilter);
  }
  
  private void refreshDNS()
  {
    try
    {
      this.mDNS = NetworkUtils.getDNS(this.mContext);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public NetworkUtils.DNS getDNS()
  {
    return this.mDNS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkStatus
 * JD-Core Version:    0.7.0.1
 */