package com.tencent.component.network.utils.http;

import com.tencent.component.network.module.base.QDLog;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class ManagedClientConnectionImpl
  implements ManagedClientConnection
{
  private volatile long duration;
  private final ClientConnectionManager manager;
  private final ClientConnectionOperator operator;
  private volatile HttpPoolEntry poolEntry;
  private volatile boolean reusable;
  
  ManagedClientConnectionImpl(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, HttpPoolEntry paramHttpPoolEntry)
  {
    if (paramClientConnectionManager != null)
    {
      if (paramClientConnectionOperator != null)
      {
        if (paramHttpPoolEntry != null)
        {
          this.manager = paramClientConnectionManager;
          this.operator = paramClientConnectionOperator;
          this.poolEntry = paramHttpPoolEntry;
          this.reusable = false;
          this.duration = 9223372036854775807L;
          return;
        }
        throw new IllegalArgumentException("HTTP pool entry may not be null");
      }
      throw new IllegalArgumentException("Connection operator may not be null");
    }
    throw new IllegalArgumentException("Connection manager may not be null");
  }
  
  private OperatedClientConnection ensureConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null) {
      return (OperatedClientConnection)localHttpPoolEntry.getConnection();
    }
    throw new ConnectionShutdownException();
  }
  
  private HttpPoolEntry ensurePoolEntry()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null) {
      return localHttpPoolEntry;
    }
    throw new ConnectionShutdownException();
  }
  
  private OperatedClientConnection getConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      return null;
    }
    return (OperatedClientConnection)localHttpPoolEntry.getConnection();
  }
  
  /* Error */
  public void abortConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/tencent/component/network/utils/http/HttpPoolEntry;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 29	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:reusable	Z
    //   17: aload_0
    //   18: getfield 27	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/tencent/component/network/utils/http/HttpPoolEntry;
    //   21: invokevirtual 53	com/tencent/component/network/utils/http/HttpPoolEntry:getConnection	()Ljava/lang/Object;
    //   24: checkcast 55	org/apache/http/conn/OperatedClientConnection
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 66 1 0
    //   34: aload_0
    //   35: getfield 23	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:manager	Lorg/apache/http/conn/ClientConnectionManager;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 33	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:duration	J
    //   43: getstatic 72	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 78 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 27	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/tencent/component/network/utils/http/HttpPoolEntry;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ManagedClientConnectionImpl
    //   27	2	1	localOperatedClientConnection	OperatedClientConnection
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void close()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.resetTracker();
      localOperatedClientConnection.close();
    }
  }
  
  HttpPoolEntry detach()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    this.poolEntry = null;
    return localHttpPoolEntry;
  }
  
  public void flush()
  {
    ensureConnection().flush();
  }
  
  public Object getAttribute(String paramString)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      return ((HttpContext)localOperatedClientConnection).getAttribute(paramString);
    }
    return null;
  }
  
  public InetAddress getLocalAddress()
  {
    return ensureConnection().getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return ensureConnection().getLocalPort();
  }
  
  public ClientConnectionManager getManager()
  {
    return this.manager;
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    return ensureConnection().getMetrics();
  }
  
  HttpPoolEntry getPoolEntry()
  {
    return this.poolEntry;
  }
  
  public InetAddress getRemoteAddress()
  {
    return ensureConnection().getRemoteAddress();
  }
  
  public int getRemotePort()
  {
    return ensureConnection().getRemotePort();
  }
  
  public HttpRoute getRoute()
  {
    return ensurePoolEntry().getEffectiveRoute();
  }
  
  public SSLSession getSSLSession()
  {
    Socket localSocket = ensureConnection().getSocket();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  public int getSocketTimeout()
  {
    return ensureConnection().getSocketTimeout();
  }
  
  public Object getState()
  {
    return ensurePoolEntry().getState();
  }
  
  public boolean isMarkedReusable()
  {
    return this.reusable;
  }
  
  public boolean isOpen()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isOpen();
    }
    return false;
  }
  
  public boolean isResponseAvailable(int paramInt)
  {
    return ensureConnection().isResponseAvailable(paramInt);
  }
  
  public boolean isSecure()
  {
    return ensureConnection().isSecure();
  }
  
  public boolean isStale()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isStale();
    }
    return true;
  }
  
  public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpParams != null) {
      try
      {
        if (this.poolEntry != null)
        {
          Object localObject = this.poolEntry.getTracker();
          if (((RouteTracker)localObject).isConnected())
          {
            if (((RouteTracker)localObject).isTunnelled())
            {
              if (!((RouteTracker)localObject).isLayered())
              {
                localObject = ((RouteTracker)localObject).getTargetHost();
                OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
                this.operator.updateSecureConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpContext, paramHttpParams);
                try
                {
                  if (this.poolEntry != null)
                  {
                    this.poolEntry.getTracker().layerProtocol(localOperatedClientConnection.isSecure());
                    return;
                  }
                  throw new InterruptedIOException();
                }
                finally {}
              }
              throw new IllegalStateException("Multiple protocol layering not supported");
            }
            throw new IllegalStateException("Protocol layering without a tunnel not supported");
          }
          throw new IllegalStateException("Connection not open");
        }
        throw new ConnectionShutdownException();
      }
      finally {}
    }
    throw new IllegalArgumentException("HTTP parameters may not be null");
  }
  
  public void markReusable()
  {
    this.reusable = true;
  }
  
  public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpRoute != null)
    {
      if (paramHttpParams != null) {
        try
        {
          if (this.poolEntry != null)
          {
            if (!this.poolEntry.getTracker().isConnected())
            {
              OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
              Object localObject;
              if (QDLog.isInfoEnable())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("host:");
                ((StringBuilder)localObject).append(localOperatedClientConnection.getTargetHost());
                ((StringBuilder)localObject).append("   ");
                ((StringBuilder)localObject).append(localOperatedClientConnection.getLocalAddress());
                ((StringBuilder)localObject).append(":");
                ((StringBuilder)localObject).append(localOperatedClientConnection.getLocalPort());
                ((StringBuilder)localObject).append("   ");
                ((StringBuilder)localObject).append(localOperatedClientConnection.getRemoteAddress());
                ((StringBuilder)localObject).append(":");
                ((StringBuilder)localObject).append(localOperatedClientConnection.getRemotePort());
                QDLog.i("http", ((StringBuilder)localObject).toString());
              }
              HttpHost localHttpHost = paramHttpRoute.getProxyHost();
              try
              {
                ClientConnectionOperator localClientConnectionOperator = this.operator;
                if (localHttpHost != null) {
                  localObject = localHttpHost;
                } else {
                  localObject = paramHttpRoute.getTargetHost();
                }
                localClientConnectionOperator.openConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
              }
              catch (Exception paramHttpRoute)
              {
                paramHttpContext = new StringBuilder();
                paramHttpContext.append("open ");
                paramHttpContext.append(paramHttpRoute.getMessage());
                QDLog.e("ManagedClientConnectionImpl", paramHttpContext.toString());
              }
              try
              {
                if (this.poolEntry != null)
                {
                  paramHttpRoute = this.poolEntry.getTracker();
                  if (localHttpHost == null) {
                    paramHttpRoute.connectTarget(localOperatedClientConnection.isSecure());
                  } else {
                    paramHttpRoute.connectProxy(localHttpHost, localOperatedClientConnection.isSecure());
                  }
                  return;
                }
                throw new InterruptedIOException();
              }
              finally {}
            }
            throw new IllegalStateException("Connection already open");
          }
          throw new ConnectionShutdownException();
        }
        finally {}
      }
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public void receiveResponseEntity(HttpResponse paramHttpResponse)
  {
    ensureConnection().receiveResponseEntity(paramHttpResponse);
  }
  
  public HttpResponse receiveResponseHeader()
  {
    return ensureConnection().receiveResponseHeader();
  }
  
  public void releaseConnection()
  {
    try
    {
      if (this.poolEntry == null) {
        return;
      }
      this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
      this.poolEntry = null;
      return;
    }
    finally {}
  }
  
  public Object removeAttribute(String paramString)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      return ((HttpContext)localOperatedClientConnection).removeAttribute(paramString);
    }
    return null;
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    ensureConnection().sendRequestEntity(paramHttpEntityEnclosingRequest);
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    ensureConnection().sendRequestHeader(paramHttpRequest);
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      ((HttpContext)localOperatedClientConnection).setAttribute(paramString, paramObject);
    }
  }
  
  public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.duration = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.duration = -1L;
  }
  
  public void setSocketTimeout(int paramInt)
  {
    ensureConnection().setSocketTimeout(paramInt);
  }
  
  public void setState(Object paramObject)
  {
    ensurePoolEntry().setState(paramObject);
  }
  
  public void shutdown()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.resetTracker();
      localOperatedClientConnection.shutdown();
    }
  }
  
  public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpHost != null)
    {
      if (paramHttpParams != null) {
        try
        {
          if (this.poolEntry != null)
          {
            if (this.poolEntry.getTracker().isConnected())
            {
              OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
              localOperatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
              try
              {
                if (this.poolEntry != null)
                {
                  this.poolEntry.getTracker().tunnelProxy(paramHttpHost, paramBoolean);
                  return;
                }
                throw new InterruptedIOException();
              }
              finally {}
            }
            throw new IllegalStateException("Connection not open");
          }
          throw new ConnectionShutdownException();
        }
        finally {}
      }
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    throw new IllegalArgumentException("Next proxy amy not be null");
  }
  
  public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpParams != null) {
      try
      {
        if (this.poolEntry != null)
        {
          Object localObject = this.poolEntry.getTracker();
          if (((RouteTracker)localObject).isConnected())
          {
            if (!((RouteTracker)localObject).isTunnelled())
            {
              localObject = ((RouteTracker)localObject).getTargetHost();
              OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
              localOperatedClientConnection.update(null, (HttpHost)localObject, paramBoolean, paramHttpParams);
              try
              {
                if (this.poolEntry != null)
                {
                  this.poolEntry.getTracker().tunnelTarget(paramBoolean);
                  return;
                }
                throw new InterruptedIOException();
              }
              finally {}
            }
            throw new IllegalStateException("Connection is already tunnelled");
          }
          throw new IllegalStateException("Connection not open");
        }
        throw new ConnectionShutdownException();
      }
      finally {}
    }
    throw new IllegalArgumentException("HTTP parameters may not be null");
  }
  
  public void unmarkReusable()
  {
    this.reusable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.ManagedClientConnectionImpl
 * JD-Core Version:    0.7.0.1
 */