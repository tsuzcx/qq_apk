package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  public static final ConnectionSpec CLEARTEXT = new ConnectionSpec.Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS = new ConnectionSpec.Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  private final String[] cipherSuites;
  private final boolean supportsTlsExtensions;
  private final boolean tls;
  private final String[] tlsVersions;
  
  static
  {
    COMPATIBLE_TLS = new ConnectionSpec.Builder(MODERN_TLS).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  }
  
  private ConnectionSpec(ConnectionSpec.Builder paramBuilder)
  {
    this.tls = ConnectionSpec.Builder.access$000(paramBuilder);
    this.cipherSuites = ConnectionSpec.Builder.access$100(paramBuilder);
    this.tlsVersions = ConnectionSpec.Builder.access$200(paramBuilder);
    this.supportsTlsExtensions = ConnectionSpec.Builder.access$300(paramBuilder);
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.contains(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.cipherSuites != null)
    {
      arrayOfString1 = (String[])Util.intersect(String.class, this.cipherSuites, paramSSLSocket.getEnabledCipherSuites());
      if (this.tlsVersions == null) {
        break label109;
      }
    }
    label109:
    for (String[] arrayOfString2 = (String[])Util.intersect(String.class, this.tlsVersions, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (Util.contains(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
          arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      return new ConnectionSpec.Builder(this).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.tlsVersions != null) {
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.tlsVersions);
    }
    if (localConnectionSpec.cipherSuites != null) {
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.cipherSuites);
    }
  }
  
  public List<CipherSuite> cipherSuites()
  {
    if (this.cipherSuites == null) {
      return null;
    }
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[this.cipherSuites.length];
    int i = 0;
    while (i < this.cipherSuites.length)
    {
      arrayOfCipherSuite[i] = CipherSuite.forJavaName(this.cipherSuites[i]);
      i += 1;
    }
    return Util.immutableList(arrayOfCipherSuite);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (ConnectionSpec)paramObject;
    } while ((this.tls != paramObject.tls) || ((this.tls) && ((!Arrays.equals(this.cipherSuites, paramObject.cipherSuites)) || (!Arrays.equals(this.tlsVersions, paramObject.tlsVersions)) || (this.supportsTlsExtensions != paramObject.supportsTlsExtensions))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.tls)
    {
      j = Arrays.hashCode(this.cipherSuites);
      k = Arrays.hashCode(this.tlsVersions);
      if (!this.supportsTlsExtensions) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      return i;
    }
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls) {}
    while (((this.tlsVersions != null) && (!nonEmptyIntersection(this.tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((this.cipherSuites != null) && (!nonEmptyIntersection(this.cipherSuites, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public boolean isTls()
  {
    return this.tls;
  }
  
  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  public List<TlsVersion> tlsVersions()
  {
    if (this.tlsVersions == null) {
      return null;
    }
    TlsVersion[] arrayOfTlsVersion = new TlsVersion[this.tlsVersions.length];
    int i = 0;
    while (i < this.tlsVersions.length)
    {
      arrayOfTlsVersion[i] = TlsVersion.forJavaName(this.tlsVersions[i]);
      i += 1;
    }
    return Util.immutableList(arrayOfTlsVersion);
  }
  
  public String toString()
  {
    if (!this.tls) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.cipherSuites != null)
    {
      str1 = cipherSuites().toString();
      if (this.tlsVersions == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = tlsVersions().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
      str1 = "[all enabled]";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ConnectionSpec
 * JD-Core Version:    0.7.0.1
 */