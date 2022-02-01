package com.tencent.luggage.wxa.nz;

import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdServiceInfo;
import com.tencent.luggage.wxa.qz.o;

class p$1
  implements NsdManager.DiscoveryListener
{
  p$1(p paramp, p.b paramb) {}
  
  public void onDiscoveryStarted(String paramString)
  {
    this.a.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDiscoveryStarted ");
    localStringBuilder.append(paramString);
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
  
  public void onDiscoveryStopped(String paramString)
  {
    this.a.b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDiscoveryStopped ");
    localStringBuilder.append(paramString);
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
  
  public void onServiceFound(NsdServiceInfo paramNsdServiceInfo)
  {
    Object localObject = new p.c(paramNsdServiceInfo);
    this.a.a((p.c)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onServicesFound ");
    ((StringBuilder)localObject).append(paramNsdServiceInfo.getServiceType());
    o.d("MicroMsg.LocalServiceMgr", ((StringBuilder)localObject).toString());
  }
  
  public void onServiceLost(NsdServiceInfo paramNsdServiceInfo)
  {
    this.a.b(new p.c(paramNsdServiceInfo));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onServiceLost ");
    localStringBuilder.append(paramNsdServiceInfo.getServiceType());
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
  
  public void onStartDiscoveryFailed(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartDiscoveryFailed ");
    localStringBuilder.append(paramString);
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
  
  public void onStopDiscoveryFailed(String paramString, int paramInt)
  {
    this.a.b(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStopDiscoveryFailed ");
    localStringBuilder.append(paramString);
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.p.1
 * JD-Core Version:    0.7.0.1
 */