package com.tencent.luggage.wxa.nz;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class p$2
  implements Runnable
{
  p$2(p paramp, p.c paramc, p.a parama) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start reslove ");
    ((StringBuilder)localObject).append(this.a.b);
    o.d("MicroMsg.LocalServiceMgr", ((StringBuilder)localObject).toString());
    localObject = new CountDownLatch(1);
    NsdServiceInfo localNsdServiceInfo = new NsdServiceInfo();
    localNsdServiceInfo.setServiceName(this.a.b);
    localNsdServiceInfo.setServiceType(this.a.c);
    p.a(this.c).resolveService(localNsdServiceInfo, new p.2.1(this, (CountDownLatch)localObject));
    try
    {
      ((CountDownLatch)localObject).await(1000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      o.a("LocalServiceMgr", localInterruptedException, "", new Object[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finish reslove ");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(" trhead id=");
    localStringBuilder.append(Thread.currentThread().getId());
    o.d("MicroMsg.LocalServiceMgr", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.p.2
 * JD-Core Version:    0.7.0.1
 */