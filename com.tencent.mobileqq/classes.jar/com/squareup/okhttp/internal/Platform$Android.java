package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class Platform$Android
  extends Platform
{
  private static final int MAX_LOG_LENGTH = 4000;
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Class<?> sslParametersClass;
  private final Method trafficStatsTagSocket;
  private final Method trafficStatsUntagSocket;
  
  public Platform$Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    this.sslParametersClass = paramClass;
    this.setUseSessionTickets = paramOptionalMethod1;
    this.setHostname = paramOptionalMethod2;
    this.trafficStatsTagSocket = paramMethod1;
    this.trafficStatsUntagSocket = paramMethod2;
    this.getAlpnSelectedProtocol = paramOptionalMethod3;
    this.setAlpnProtocols = paramOptionalMethod4;
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
    {
      paramString = concatLengthPrefixed(paramList);
      this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (Util.isAndroidGetsocknameError(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (this.getAlpnSelectedProtocol == null) {}
    while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {}
    for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
      return paramSSLSocket;
    }
  }
  
  public void log(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j;
    if (i < k)
    {
      j = paramString.indexOf('\n', i);
      if (j == -1) {}
    }
    for (;;)
    {
      int m = Math.min(j, i + 4000);
      Log.d("OkHttp", paramString.substring(i, m));
      if (m >= j)
      {
        i = m + 1;
        break;
        j = k;
        continue;
        return;
      }
      i = m;
    }
  }
  
  public void tagSocket(Socket paramSocket)
  {
    if (this.trafficStatsTagSocket == null) {
      return;
    }
    try
    {
      this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
      return;
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new RuntimeException(paramSocket);
    }
    catch (InvocationTargetException paramSocket)
    {
      throw new RuntimeException(paramSocket.getCause());
    }
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        localObject = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
        if (localObject != null) {
          return localObject;
        }
      }
      catch (ClassNotFoundException paramSSLSocketFactory)
      {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
      paramSSLSocketFactory = (SSLSocketFactory)localObject;
    }
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    TrustRootIndex localTrustRootIndex = AndroidTrustRootIndex.get(paramX509TrustManager);
    if (localTrustRootIndex != null) {
      return localTrustRootIndex;
    }
    return super.trustRootIndex(paramX509TrustManager);
  }
  
  public void untagSocket(Socket paramSocket)
  {
    if (this.trafficStatsUntagSocket == null) {
      return;
    }
    try
    {
      this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
      return;
    }
    catch (IllegalAccessException paramSocket)
    {
      throw new RuntimeException(paramSocket);
    }
    catch (InvocationTargetException paramSocket)
    {
      throw new RuntimeException(paramSocket.getCause());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform.Android
 * JD-Core Version:    0.7.0.1
 */