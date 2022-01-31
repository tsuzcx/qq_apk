package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramAddress == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Route))
    {
      paramObject = (Route)paramObject;
      bool1 = bool2;
      if (this.address.equals(paramObject.address))
      {
        bool1 = bool2;
        if (this.proxy.equals(paramObject.proxy))
        {
          bool1 = bool2;
          if (this.inetSocketAddress.equals(paramObject.inetSocketAddress)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Address getAddress()
  {
    return this.address;
  }
  
  public Proxy getProxy()
  {
    return this.proxy;
  }
  
  public InetSocketAddress getSocketAddress()
  {
    return this.inetSocketAddress;
  }
  
  public int hashCode()
  {
    return ((this.address.hashCode() + 527) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode();
  }
  
  public boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Route
 * JD-Core Version:    0.7.0.1
 */