package com.tencent.component.network.utils.http.pool;

import com.tencent.component.network.module.base.QDLog;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class QzoneClientConnectionOperator
  extends DefaultClientConnectionOperator
{
  private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
  private final CustomDnsResolve customDnsResolve;
  
  public QzoneClientConnectionOperator(SchemeRegistry paramSchemeRegistry, CustomDnsResolve paramCustomDnsResolve)
  {
    super(paramSchemeRegistry);
    this.customDnsResolve = paramCustomDnsResolve;
  }
  
  public void openConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, InetAddress paramInetAddress, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramOperatedClientConnection == null) {
      throw new IllegalArgumentException("Connection must not be null.");
    }
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Target host must not be null.");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters must not be null.");
    }
    if (paramOperatedClientConnection.isOpen()) {
      throw new IllegalArgumentException("Connection must not be open.");
    }
    Scheme localScheme = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
    if (!"https".equalsIgnoreCase(paramHttpHost.getSchemeName()))
    {
      super.openConnection(paramOperatedClientConnection, paramHttpHost, paramInetAddress, paramHttpContext, paramHttpParams);
      return;
    }
    SocketFactory localSocketFactory = localScheme.getSocketFactory();
    Object localObject1;
    LayeredSocketFactory localLayeredSocketFactory;
    if ((localSocketFactory instanceof LayeredSocketFactory))
    {
      localObject1 = staticPlainSocketFactory;
      localLayeredSocketFactory = (LayeredSocketFactory)localSocketFactory;
      if (this.customDnsResolve == null) {
        break label218;
      }
    }
    Object localObject2;
    int i;
    label218:
    for (InetAddress[] arrayOfInetAddress = this.customDnsResolve.getAllByName(paramHttpHost.getHostName());; arrayOfInetAddress = null)
    {
      localObject2 = "";
      if (arrayOfInetAddress == null) {
        break label249;
      }
      i = 0;
      while (i < arrayOfInetAddress.length)
      {
        localObject2 = (String)localObject2 + arrayOfInetAddress[i].getHostAddress() + ";";
        i += 1;
      }
      localLayeredSocketFactory = null;
      localObject1 = localSocketFactory;
      break;
    }
    QDLog.i("downloader", "to download QzoneClientConnectionOperator resolve:" + (String)localObject2);
    label249:
    if ((arrayOfInetAddress == null) || (arrayOfInetAddress.length <= 0)) {
      arrayOfInetAddress = InetAddress.getAllByName(paramHttpHost.getHostName());
    }
    for (;;)
    {
      i = 0;
      while (i < arrayOfInetAddress.length)
      {
        Socket localSocket1 = ((SocketFactory)localObject1).createSocket();
        paramOperatedClientConnection.opening(localSocket1, paramHttpHost);
        try
        {
          Socket localSocket2 = ((SocketFactory)localObject1).connectSocket(localSocket1, arrayOfInetAddress[i].getHostAddress(), localScheme.resolvePort(paramHttpHost.getPort()), paramInetAddress, 0, paramHttpParams);
          localObject2 = localSocket1;
          if (localSocket1 != localSocket2)
          {
            paramOperatedClientConnection.opening(localSocket2, paramHttpHost);
            localObject2 = localSocket2;
          }
          if (localLayeredSocketFactory != null)
          {
            localSocket1 = localLayeredSocketFactory.createSocket((Socket)localObject2, paramHttpHost.getHostName(), localScheme.resolvePort(paramHttpHost.getPort()), true);
            if (localSocket1 != localObject2) {
              paramOperatedClientConnection.opening(localSocket1, paramHttpHost);
            }
            prepareSocket(localSocket1, paramHttpContext, paramHttpParams);
            paramOperatedClientConnection.openCompleted(localSocketFactory.isSecure(localSocket1), paramHttpParams);
            return;
          }
        }
        catch (ConnectException localConnectException)
        {
          if (i == arrayOfInetAddress.length - 1)
          {
            throw new HttpHostConnectException(paramHttpHost, localConnectException);
            prepareSocket(localConnectException, paramHttpContext, paramHttpParams);
            paramOperatedClientConnection.openCompleted(localSocketFactory.isSecure(localConnectException), paramHttpParams);
            return;
          }
        }
        catch (ConnectTimeoutException localConnectTimeoutException)
        {
          if (i == arrayOfInetAddress.length - 1) {
            throw localConnectTimeoutException;
          }
          i += 1;
        }
      }
      break;
    }
  }
  
  protected void prepareSocket(Socket paramSocket, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    super.prepareSocket(paramSocket, paramHttpContext, paramHttpParams);
  }
  
  public void updateSecureConnection(OperatedClientConnection paramOperatedClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    super.updateSecureConnection(paramOperatedClientConnection, paramHttpHost, paramHttpContext, paramHttpParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.QzoneClientConnectionOperator
 * JD-Core Version:    0.7.0.1
 */