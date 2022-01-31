package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;

public final class StreamAllocation
{
  public final Address address;
  private boolean canceled;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  private boolean released;
  private RouteSelector routeSelector;
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
  }
  
  private void connectionFailed(IOException paramIOException)
  {
    synchronized (this.connectionPool)
    {
      if (this.routeSelector != null)
      {
        if (this.connection.streamCount == 0)
        {
          Route localRoute = this.connection.getRoute();
          this.routeSelector.connectFailed(localRoute, paramIOException);
        }
      }
      else
      {
        connectionFailed();
        return;
      }
      this.routeSelector = null;
    }
  }
  
  private void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    ConnectionPool localConnectionPool = this.connectionPool;
    if (paramBoolean3) {}
    try
    {
      this.stream = null;
      if (paramBoolean2) {
        this.released = true;
      }
      Object localObject1 = localObject4;
      if (this.connection != null)
      {
        if (paramBoolean1) {
          this.connection.noNewStreams = true;
        }
        localObject1 = localObject4;
        if (this.stream == null) {
          if (!this.released)
          {
            localObject1 = localObject4;
            if (!this.connection.noNewStreams) {}
          }
          else
          {
            release(this.connection);
            if (this.connection.streamCount > 0) {
              this.routeSelector = null;
            }
            localObject1 = localObject3;
            if (this.connection.allocations.isEmpty())
            {
              this.connection.idleAtNanos = System.nanoTime();
              localObject1 = localObject3;
              if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                localObject1 = this.connection;
              }
            }
            this.connection = null;
          }
        }
      }
      if (localObject1 != null) {
        Util.closeQuietly(((RealConnection)localObject1).getSocket());
      }
      return;
    }
    finally {}
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.connectionPool)
    {
      if (this.released) {
        throw new IllegalStateException("released");
      }
    }
    if (this.stream != null) {
      throw new IllegalStateException("stream != null");
    }
    if (this.canceled) {
      throw new IOException("Canceled");
    }
    RealConnection localRealConnection1 = this.connection;
    if ((localRealConnection1 != null) && (!localRealConnection1.noNewStreams)) {
      return localRealConnection1;
    }
    localRealConnection1 = Internal.instance.get(this.connectionPool, this.address, this);
    if (localRealConnection1 != null)
    {
      this.connection = localRealConnection1;
      return localRealConnection1;
    }
    if (this.routeSelector == null) {
      this.routeSelector = new RouteSelector(this.address, routeDatabase());
    }
    localRealConnection1 = new RealConnection(this.routeSelector.next());
    acquire(localRealConnection1);
    synchronized (this.connectionPool)
    {
      Internal.instance.put(this.connectionPool, localRealConnection1);
      this.connection = localRealConnection1;
      if (this.canceled) {
        throw new IOException("Canceled");
      }
    }
    localRealConnection2.connect(paramInt1, paramInt2, paramInt3, this.address.getConnectionSpecs(), paramBoolean);
    routeDatabase().connected(localRealConnection2.getRoute());
    return localRealConnection2;
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      RealConnection localRealConnection1 = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if (localRealConnection1.streamCount == 0) {
          return localRealConnection1;
        }
        if (!localRealConnection1.isHealthy(paramBoolean2)) {
          connectionFailed();
        }
      }
    }
    return localRealConnection2;
  }
  
  private boolean isRecoverable(RouteException paramRouteException)
  {
    paramRouteException = paramRouteException.getLastConnectException();
    if ((paramRouteException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramRouteException instanceof InterruptedIOException)) {
        return paramRouteException instanceof SocketTimeoutException;
      }
    } while ((((paramRouteException instanceof SSLHandshakeException)) && ((paramRouteException.getCause() instanceof CertificateException))) || ((paramRouteException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean isRecoverable(IOException paramIOException)
  {
    if ((paramIOException instanceof ProtocolException)) {}
    while ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    return true;
  }
  
  private void release(RealConnection paramRealConnection)
  {
    int j = paramRealConnection.allocations.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramRealConnection.allocations.get(i)).get() == this)
      {
        paramRealConnection.allocations.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection)
  {
    paramRealConnection.allocations.add(new WeakReference(this));
  }
  
  public void cancel()
  {
    RealConnection localRealConnection;
    do
    {
      synchronized (this.connectionPool)
      {
        this.canceled = true;
        HttpStream localHttpStream = this.stream;
        localRealConnection = this.connection;
        if (localHttpStream != null)
        {
          localHttpStream.cancel();
          return;
        }
      }
    } while (localRealConnection == null);
    localRealConnection.cancel();
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void connectionFailed()
  {
    deallocate(true, false, true);
  }
  
  /* Error */
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 234	com/squareup/okhttp/internal/http/StreamAllocation:findHealthyConnection	(IIIZZ)Lcom/squareup/okhttp/internal/io/RealConnection;
    //   11: astore 7
    //   13: aload 7
    //   15: getfield 238	com/squareup/okhttp/internal/io/RealConnection:framedConnection	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   18: ifnull +51 -> 69
    //   21: new 240	com/squareup/okhttp/internal/http/Http2xStream
    //   24: dup
    //   25: aload_0
    //   26: aload 7
    //   28: getfield 238	com/squareup/okhttp/internal/io/RealConnection:framedConnection	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   31: invokespecial 243	com/squareup/okhttp/internal/http/Http2xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/framed/FramedConnection;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 24	com/squareup/okhttp/internal/http/StreamAllocation:connectionPool	Lcom/squareup/okhttp/ConnectionPool;
    //   40: astore 8
    //   42: aload 8
    //   44: monitorenter
    //   45: aload 7
    //   47: aload 7
    //   49: getfield 39	com/squareup/okhttp/internal/io/RealConnection:streamCount	I
    //   52: iconst_1
    //   53: iadd
    //   54: putfield 39	com/squareup/okhttp/internal/io/RealConnection:streamCount	I
    //   57: aload_0
    //   58: aload 6
    //   60: putfield 55	com/squareup/okhttp/internal/http/StreamAllocation:stream	Lcom/squareup/okhttp/internal/http/HttpStream;
    //   63: aload 8
    //   65: monitorexit
    //   66: aload 6
    //   68: areturn
    //   69: aload 7
    //   71: invokevirtual 98	com/squareup/okhttp/internal/io/RealConnection:getSocket	()Ljava/net/Socket;
    //   74: iload_2
    //   75: invokevirtual 249	java/net/Socket:setSoTimeout	(I)V
    //   78: aload 7
    //   80: getfield 253	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   83: invokeinterface 259 1 0
    //   88: iload_2
    //   89: i2l
    //   90: getstatic 265	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   93: invokevirtual 270	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   96: pop
    //   97: aload 7
    //   99: getfield 274	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   102: invokeinterface 277 1 0
    //   107: iload_3
    //   108: i2l
    //   109: getstatic 265	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   112: invokevirtual 270	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   115: pop
    //   116: new 279	com/squareup/okhttp/internal/http/Http1xStream
    //   119: dup
    //   120: aload_0
    //   121: aload 7
    //   123: getfield 253	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   126: aload 7
    //   128: getfield 274	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   131: invokespecial 282	com/squareup/okhttp/internal/http/Http1xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   134: astore 6
    //   136: goto -100 -> 36
    //   139: astore 6
    //   141: new 172	com/squareup/okhttp/internal/http/RouteException
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 284	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   150: athrow
    //   151: astore 6
    //   153: aload 8
    //   155: monitorexit
    //   156: aload 6
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	StreamAllocation
    //   0	159	1	paramInt1	int
    //   0	159	2	paramInt2	int
    //   0	159	3	paramInt3	int
    //   0	159	4	paramBoolean1	boolean
    //   0	159	5	paramBoolean2	boolean
    //   34	101	6	localObject1	Object
    //   139	7	6	localIOException	IOException
    //   151	6	6	localObject2	Object
    //   11	116	7	localRealConnection	RealConnection
    // Exception table:
    //   from	to	target	type
    //   0	36	139	java/io/IOException
    //   36	45	139	java/io/IOException
    //   69	136	139	java/io/IOException
    //   156	159	139	java/io/IOException
    //   45	66	151	finally
    //   153	156	151	finally
  }
  
  public void noNewStreams()
  {
    deallocate(true, false, false);
  }
  
  public boolean recover(RouteException paramRouteException)
  {
    if (this.connection != null) {
      connectionFailed(paramRouteException.getLastConnectException());
    }
    return ((this.routeSelector == null) || (this.routeSelector.hasNext())) && (isRecoverable(paramRouteException));
  }
  
  public boolean recover(IOException paramIOException, Sink paramSink)
  {
    int i;
    if (this.connection != null)
    {
      i = this.connection.streamCount;
      connectionFailed(paramIOException);
      if (i != 1) {}
    }
    for (;;)
    {
      return false;
      if ((paramSink == null) || ((paramSink instanceof RetryableSink))) {}
      for (i = 1; ((this.routeSelector == null) || (this.routeSelector.hasNext())) && (isRecoverable(paramIOException)) && (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public void release()
  {
    deallocate(false, true, false);
  }
  
  public HttpStream stream()
  {
    synchronized (this.connectionPool)
    {
      HttpStream localHttpStream = this.stream;
      return localHttpStream;
    }
  }
  
  /* Error */
  public void streamFinished(HttpStream paramHttpStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/squareup/okhttp/internal/http/StreamAllocation:connectionPool	Lcom/squareup/okhttp/ConnectionPool;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +11 -> 19
    //   11: aload_1
    //   12: aload_0
    //   13: getfield 55	com/squareup/okhttp/internal/http/StreamAllocation:stream	Lcom/squareup/okhttp/internal/http/HttpStream;
    //   16: if_acmpeq +49 -> 65
    //   19: new 108	java/lang/IllegalStateException
    //   22: dup
    //   23: new 302	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 305
    //   33: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 55	com/squareup/okhttp/internal/http/StreamAllocation:stream	Lcom/squareup/okhttp/internal/http/HttpStream;
    //   40: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc_w 314
    //   46: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 112	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_0
    //   68: iconst_0
    //   69: iconst_0
    //   70: iconst_1
    //   71: invokespecial 230	com/squareup/okhttp/internal/http/StreamAllocation:deallocate	(ZZZ)V
    //   74: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	StreamAllocation
    //   0	75	1	paramHttpStream	HttpStream
    //   4	62	2	localConnectionPool	ConnectionPool
    // Exception table:
    //   from	to	target	type
    //   11	19	60	finally
    //   19	60	60	finally
    //   61	63	60	finally
    //   65	67	60	finally
  }
  
  public String toString()
  {
    return this.address.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.StreamAllocation
 * JD-Core Version:    0.7.0.1
 */