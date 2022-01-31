package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import java.net.InetAddress;
import java.util.List;
import okhttp3.Dns;

public class OkHttpDNS
  implements Dns
{
  private OkHttpDNSManager okHttpDNSManager;
  
  public OkHttpDNS(CustomDnsResolve paramCustomDnsResolve)
  {
    this.okHttpDNSManager = new OkHttpDNSManager(paramCustomDnsResolve);
  }
  
  public List<InetAddress> lookup(String paramString)
  {
    QDLog.i("downloader", "OkHttpDNS lookup:" + paramString);
    return this.okHttpDNSManager.getAllByName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.OkHttpDNS
 * JD-Core Version:    0.7.0.1
 */