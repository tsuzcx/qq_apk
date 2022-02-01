package com.tencent.luggage.wxa.nz;

import android.net.nsd.NsdManager.ResolveListener;
import android.net.nsd.NsdServiceInfo;
import java.util.concurrent.CountDownLatch;

class p$2$1
  implements NsdManager.ResolveListener
{
  p$2$1(p.2 param2, CountDownLatch paramCountDownLatch) {}
  
  public void onResolveFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt)
  {
    this.b.b.a(new p.c(paramNsdServiceInfo), paramInt);
    this.a.countDown();
  }
  
  public void onServiceResolved(NsdServiceInfo paramNsdServiceInfo)
  {
    this.b.b.a(new p.c(paramNsdServiceInfo));
    this.a.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.p.2.1
 * JD-Core Version:    0.7.0.1
 */