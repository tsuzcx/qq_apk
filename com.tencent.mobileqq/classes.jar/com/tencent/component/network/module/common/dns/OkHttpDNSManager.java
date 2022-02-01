package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;

public class OkHttpDNSManager
{
  private CustomDnsResolve customDnsResolve;
  
  public OkHttpDNSManager(CustomDnsResolve paramCustomDnsResolve)
  {
    this.customDnsResolve = paramCustomDnsResolve;
  }
  
  public List<InetAddress> getAllByName(String paramString)
  {
    Object localObject1 = this.customDnsResolve;
    if (localObject1 != null)
    {
      localObject1 = ((CustomDnsResolve)localObject1).getAllByName(paramString);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        QDLog.i("downloader", "OkHttpDNSManager customDnsResolve.getAllByName");
      }
      else
      {
        localObject2 = this.customDnsResolve.resolveByDns(paramString);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (localObject2.length > 0)
          {
            QDLog.i("downloader", "OkHttpDNSManager customDnsResolve.resolveByDns");
            localObject1 = localObject2;
          }
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      paramString = Arrays.asList((Object[])localObject1);
    }
    else
    {
      paramString = Dns.SYSTEM.lookup(paramString);
      QDLog.i("downloader", "OkHttpDNSManager Dns.SYSTEM.lookup");
    }
    localObject1 = new StringBuilder();
    if (paramString != null)
    {
      localObject2 = paramString.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(((InetAddress)((Iterator)localObject2).next()).getHostAddress());
        ((StringBuilder)localObject1).append(";");
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OkHttpDNSManager");
    ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
    QDLog.i("downloader", ((StringBuilder)localObject2).toString());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.OkHttpDNSManager
 * JD-Core Version:    0.7.0.1
 */