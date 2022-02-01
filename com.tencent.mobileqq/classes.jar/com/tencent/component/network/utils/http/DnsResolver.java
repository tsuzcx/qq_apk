package com.tencent.component.network.utils.http;

import java.net.InetAddress;

public abstract interface DnsResolver
{
  public abstract InetAddress[] resolve(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.DnsResolver
 * JD-Core Version:    0.7.0.1
 */