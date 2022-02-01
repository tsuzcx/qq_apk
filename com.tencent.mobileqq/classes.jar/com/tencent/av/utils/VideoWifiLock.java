package com.tencent.av.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;

public class VideoWifiLock
{
  Context a = null;
  int b = 0;
  String c = null;
  WifiManager.WifiLock d = null;
  
  public VideoWifiLock(Context paramContext, int paramInt, String paramString)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public boolean a()
  {
    if (this.d == null) {
      this.d = ((WifiManager)this.a.getSystemService("wifi")).createWifiLock(this.b, this.c);
    }
    WifiManager.WifiLock localWifiLock = this.d;
    if (localWifiLock != null)
    {
      if (!localWifiLock.isHeld()) {
        this.d.acquire();
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (c())
    {
      this.d.release();
      this.d = null;
    }
  }
  
  public boolean c()
  {
    WifiManager.WifiLock localWifiLock = this.d;
    return (localWifiLock != null) && (localWifiLock.isHeld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoWifiLock
 * JD-Core Version:    0.7.0.1
 */