package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final Authenticator authenticator;
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
      if (paramDns != null) {
        break;
      }
      throw new IllegalArgumentException("dns == null");
    }
    this.dns = paramDns;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    this.socketFactory = paramSocketFactory;
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    this.authenticator = paramAuthenticator;
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    this.protocols = Util.immutableList(paramList);
    if (paramList1 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    this.connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.proxySelector = paramProxySelector;
    this.proxy = paramProxy;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (this.url.equals(paramObject.url))
      {
        bool1 = bool2;
        if (this.dns.equals(paramObject.dns))
        {
          bool1 = bool2;
          if (this.authenticator.equals(paramObject.authenticator))
          {
            bool1 = bool2;
            if (this.protocols.equals(paramObject.protocols))
            {
              bool1 = bool2;
              if (this.connectionSpecs.equals(paramObject.connectionSpecs))
              {
                bool1 = bool2;
                if (this.proxySelector.equals(paramObject.proxySelector))
                {
                  bool1 = bool2;
                  if (Util.equal(this.proxy, paramObject.proxy))
                  {
                    bool1 = bool2;
                    if (Util.equal(this.sslSocketFactory, paramObject.sslSocketFactory))
                    {
                      bool1 = bool2;
                      if (Util.equal(this.hostnameVerifier, paramObject.hostnameVerifier))
                      {
                        bool1 = bool2;
                        if (Util.equal(this.certificatePinner, paramObject.certificatePinner)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Authenticator getAuthenticator()
  {
    return this.authenticator;
  }
  
  public CertificatePinner getCertificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> getConnectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public Dns getDns()
  {
    return this.dns;
  }
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> getProtocols()
  {
    return this.protocols;
  }
  
  public Proxy getProxy()
  {
    return this.proxy;
  }
  
  public ProxySelector getProxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory getSslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  @Deprecated
  public String getUriHost()
  {
    return this.url.host();
  }
  
  @Deprecated
  public int getUriPort()
  {
    return this.url.port();
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.url.hashCode();
    int i1 = this.dns.hashCode();
    int i2 = this.authenticator.hashCode();
    int i3 = this.protocols.hashCode();
    int i4 = this.connectionSpecs.hashCode();
    int i5 = this.proxySelector.hashCode();
    int i;
    int j;
    if (this.proxy != null)
    {
      i = this.proxy.hashCode();
      if (this.sslSocketFactory == null) {
        break label185;
      }
      j = this.sslSocketFactory.hashCode();
      label91:
      if (this.hostnameVerifier == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int k = this.hostnameVerifier.hashCode();; k = 0)
    {
      if (this.certificatePinner != null) {
        m = this.certificatePinner.hashCode();
      }
      return (k + (j + (i + ((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label91;
    }
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Address
 * JD-Core Version:    0.7.0.1
 */