package com.tencent.component.network.utils.http;

import java.net.InetAddress;

public class SystemDefaultDnsResolver
  implements DnsResolver
{
  public InetAddress[] resolve(String paramString)
  {
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.http.SystemDefaultDnsResolver
 * JD-Core Version:    0.7.0.1
 */