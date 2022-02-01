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
    if (paramOperatedClientConnection != null)
    {
      if (paramHttpHost != null)
      {
        if (paramHttpParams != null)
        {
          if (!paramOperatedClientConnection.isOpen())
          {
            Scheme localScheme = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
            if (!"https".equalsIgnoreCase(paramHttpHost.getSchemeName()))
            {
              super.openConnection(paramOperatedClientConnection, paramHttpHost, paramInetAddress, paramHttpContext, paramHttpParams);
              return;
            }
            Object localObject6 = localScheme.getSocketFactory();
            boolean bool = localObject6 instanceof LayeredSocketFactory;
            Object localObject3 = null;
            Object localObject2;
            Object localObject1;
            if (bool)
            {
              localObject2 = staticPlainSocketFactory;
              localObject1 = (LayeredSocketFactory)localObject6;
            }
            else
            {
              localObject1 = null;
              localObject2 = localObject6;
            }
            Object localObject4 = this.customDnsResolve;
            if (localObject4 != null) {
              localObject3 = ((CustomDnsResolve)localObject4).getAllByName(paramHttpHost.getHostName());
            }
            int i;
            Object localObject7;
            if (localObject3 != null)
            {
              localObject4 = "";
              i = 0;
              while (i < localObject3.length)
              {
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append((String)localObject4);
                ((StringBuilder)localObject7).append(localObject3[i].getHostAddress());
                ((StringBuilder)localObject7).append(";");
                localObject4 = ((StringBuilder)localObject7).toString();
                i += 1;
              }
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("to download QzoneClientConnectionOperator resolve:");
              ((StringBuilder)localObject7).append((String)localObject4);
              QDLog.i("downloader", ((StringBuilder)localObject7).toString());
            }
            if (localObject3 != null)
            {
              localObject4 = localObject3;
              if (localObject3.length <= 0) {}
            }
            for (;;)
            {
              localObject3 = localObject4;
              break label321;
              try
              {
                localObject4 = InetAddress.getAllByName(paramHttpHost.getHostName());
              }
              catch (Throwable localThrowable)
              {
                if (this.customDnsResolve == null) {
                  break label636;
                }
              }
            }
            QDLog.e("downloader", "dns resolve failed! try switch to custom dns", localThrowable);
            localObject3 = this.customDnsResolve.resolveByDns(paramHttpHost.getHostName());
            label321:
            Object localObject5;
            if ((localObject3 != null) && (localObject3.length > 0))
            {
              QDLog.e("downloader", "custom dns resolve success.");
              i = 0;
              localObject5 = localObject2;
              localObject2 = localObject6;
              localObject6 = localObject1;
              while (i < localObject3.length)
              {
                localObject7 = localObject5.createSocket();
                paramOperatedClientConnection.opening((Socket)localObject7, paramHttpHost);
                try
                {
                  localObject1 = localObject3[i].getHostAddress();
                  int j = localScheme.resolvePort(paramHttpHost.getPort());
                  try
                  {
                    Socket localSocket = localObject5.connectSocket((Socket)localObject7, (String)localObject1, j, paramInetAddress, 0, paramHttpParams);
                    localObject1 = localObject7;
                    if (localObject7 != localSocket)
                    {
                      paramOperatedClientConnection.opening(localSocket, paramHttpHost);
                      localObject1 = localSocket;
                    }
                    paramHttpContext.setAttribute("RealRemoteAddr", localObject3[i].getHostAddress());
                    if (localObject6 != null)
                    {
                      localObject7 = paramHttpHost.getHostName();
                      j = localScheme.resolvePort(paramHttpHost.getPort());
                    }
                  }
                  catch (ConnectTimeoutException localConnectTimeoutException2)
                  {
                    for (;;)
                    {
                      try
                      {
                        localObject7 = ((LayeredSocketFactory)localObject6).createSocket((Socket)localObject1, (String)localObject7, j, true);
                        if (localObject7 != localObject1) {
                          paramOperatedClientConnection.opening((Socket)localObject7, paramHttpHost);
                        }
                      }
                      catch (ConnectTimeoutException localConnectTimeoutException5)
                      {
                        continue;
                      }
                      catch (ConnectException localConnectException5)
                      {
                        continue;
                      }
                      try
                      {
                        prepareSocket((Socket)localObject7, paramHttpContext, paramHttpParams);
                        try
                        {
                          paramOperatedClientConnection.openCompleted(((SocketFactory)localObject2).isSecure((Socket)localObject7), paramHttpParams);
                          return;
                        }
                        catch (ConnectTimeoutException localConnectTimeoutException1) {}catch (ConnectException localConnectException1)
                        {
                          continue;
                        }
                        prepareSocket((Socket)localObject1, paramHttpContext, paramHttpParams);
                        paramOperatedClientConnection.openCompleted(((SocketFactory)localObject2).isSecure((Socket)localObject1), paramHttpParams);
                        return;
                      }
                      catch (ConnectTimeoutException localConnectTimeoutException4) {}catch (ConnectException localConnectException4) {}
                    }
                    localConnectTimeoutException2 = localConnectTimeoutException2;
                  }
                  catch (ConnectException localConnectException2) {}
                  if (i == localObject3.length - 1) {
                    break label612;
                  }
                }
                catch (ConnectTimeoutException localConnectTimeoutException3)
                {
                  if (i == localObject3.length - 1) {
                    throw localConnectTimeoutException3;
                  }
                }
                catch (ConnectException localConnectException3) {}
                i += 1;
                continue;
                label612:
                throw new HttpHostConnectException(paramHttpHost, localConnectException3);
              }
              return;
            }
            QDLog.e("downloader", "dns resolve failed! try switch to custom dns", localObject5);
            throw localObject5;
            label636:
            throw localObject5;
          }
          throw new IllegalArgumentException("Connection must not be open.");
        }
        throw new IllegalArgumentException("Parameters must not be null.");
      }
      throw new IllegalArgumentException("Target host must not be null.");
    }
    paramOperatedClientConnection = new IllegalArgumentException("Connection must not be null.");
    for (;;)
    {
      throw paramOperatedClientConnection;
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