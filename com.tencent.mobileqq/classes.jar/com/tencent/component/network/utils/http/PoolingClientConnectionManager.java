package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.ConnPoolControl;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.http.pool.PoolStats;
import com.tencent.component.network.utils.http.pool.QzoneClientConnectionOperator;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

public class PoolingClientConnectionManager
  implements ConnPoolControl<HttpRoute>, ClientConnectionManager
{
  private final CustomDnsResolve customDnsResolve;
  private final DnsResolver dnsResolver;
  private final ClientConnectionOperator operator;
  private final HttpConnPool pool;
  private final SchemeRegistry schemeRegistry;
  
  public PoolingClientConnectionManager()
  {
    this(SchemeRegistryFactory.createDefault());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramSchemeRegistry, paramLong, paramTimeUnit, new SystemDefaultDnsResolver(), null);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, DnsResolver paramDnsResolver, CustomDnsResolve paramCustomDnsResolve)
  {
    if (paramSchemeRegistry != null)
    {
      if (paramDnsResolver != null)
      {
        this.schemeRegistry = paramSchemeRegistry;
        this.dnsResolver = paramDnsResolver;
        this.customDnsResolve = paramCustomDnsResolve;
        this.operator = createConnectionOperator(paramSchemeRegistry);
        this.pool = new HttpConnPool(null, 2, 20, paramLong, paramTimeUnit);
        return;
      }
      throw new IllegalArgumentException("DNS resolver may not be null");
    }
    throw new IllegalArgumentException("Scheme registry may not be null");
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, DnsResolver paramDnsResolver)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS, paramDnsResolver, null);
  }
  
  private String format(HttpPoolEntry paramHttpPoolEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id: ");
    localStringBuilder.append(paramHttpPoolEntry.getId());
    localStringBuilder.append("]");
    localStringBuilder.append("[route: ");
    localStringBuilder.append(paramHttpPoolEntry.getRoute());
    localStringBuilder.append("]");
    paramHttpPoolEntry = paramHttpPoolEntry.getState();
    if (paramHttpPoolEntry != null)
    {
      localStringBuilder.append("[state: ");
      localStringBuilder.append(paramHttpPoolEntry);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String format(HttpRoute paramHttpRoute, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(paramHttpRoute);
    localStringBuilder.append("]");
    if (paramObject != null)
    {
      localStringBuilder.append("[state: ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String formatStats(HttpRoute paramHttpRoute)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    PoolStats localPoolStats = this.pool.getTotalStats();
    paramHttpRoute = this.pool.getStats(paramHttpRoute);
    localStringBuilder.append("[total kept alive: ");
    localStringBuilder.append(localPoolStats.getAvailable());
    localStringBuilder.append("; ");
    localStringBuilder.append("route allocated: ");
    localStringBuilder.append(paramHttpRoute.getLeased() + paramHttpRoute.getAvailable());
    localStringBuilder.append(" of ");
    localStringBuilder.append(paramHttpRoute.getMax());
    localStringBuilder.append("; ");
    localStringBuilder.append("total allocated: ");
    localStringBuilder.append(localPoolStats.getLeased() + localPoolStats.getAvailable());
    localStringBuilder.append(" of ");
    localStringBuilder.append(localPoolStats.getMax());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void closeExpiredConnections()
  {
    this.pool.closeExpired();
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    this.pool.closeIdle(paramLong, paramTimeUnit);
  }
  
  protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    return new QzoneClientConnectionOperator(paramSchemeRegistry, this.customDnsResolve);
  }
  
  protected void finalize()
  {
    try
    {
      shutdown();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDefaultMaxPerRoute()
  {
    return this.pool.getDefaultMaxPerRoute();
  }
  
  public int getMaxPerRoute(HttpRoute paramHttpRoute)
  {
    return this.pool.getMaxPerRoute(paramHttpRoute);
  }
  
  public int getMaxTotal()
  {
    return this.pool.getMaxTotal();
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    return this.schemeRegistry;
  }
  
  public PoolStats getStats(HttpRoute paramHttpRoute)
  {
    return this.pool.getStats(paramHttpRoute);
  }
  
  public PoolStats getTotalStats()
  {
    return this.pool.getTotalStats();
  }
  
  ManagedClientConnection leaseConnection(Future<HttpPoolEntry> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit = (HttpPoolEntry)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit != null) && (!paramFuture.isCancelled()))
      {
        if (paramTimeUnit.getConnection() != null) {
          return new ManagedClientConnectionImpl(this, this.operator, paramTimeUnit);
        }
        throw new IllegalStateException("Pool entry with no connection");
      }
      throw new InterruptedException();
    }
    catch (ExecutionException paramFuture)
    {
      paramFuture.getCause();
      throw new InterruptedException();
    }
    catch (TimeoutException paramFuture)
    {
      label69:
      break label69;
    }
    throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
  }
  
  /* Error */
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 211
    //   4: ifeq +134 -> 138
    //   7: aload_1
    //   8: checkcast 211	com/tencent/component/network/utils/http/ManagedClientConnectionImpl
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 241	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:getManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   16: aload_0
    //   17: if_acmpne +110 -> 127
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_1
    //   23: invokevirtual 245	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:detach	()Lcom/tencent/component/network/utils/http/HttpPoolEntry;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnonnull +6 -> 36
    //   33: aload_1
    //   34: monitorexit
    //   35: return
    //   36: aload_1
    //   37: invokevirtual 248	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:isOpen	()Z
    //   40: ifeq +18 -> 58
    //   43: aload_1
    //   44: invokevirtual 251	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   47: istore 5
    //   49: iload 5
    //   51: ifne +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 252	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:shutdown	()V
    //   58: aload_1
    //   59: invokevirtual 251	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   62: ifeq +24 -> 86
    //   65: aload 4
    //   67: ifnull +6 -> 73
    //   70: goto +8 -> 78
    //   73: getstatic 39	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   76: astore 4
    //   78: aload 6
    //   80: lload_2
    //   81: aload 4
    //   83: invokevirtual 255	com/tencent/component/network/utils/http/HttpPoolEntry:updateExpiry	(JLjava/util/concurrent/TimeUnit;)V
    //   86: aload_0
    //   87: getfield 69	com/tencent/component/network/utils/http/PoolingClientConnectionManager:pool	Lcom/tencent/component/network/utils/http/HttpConnPool;
    //   90: aload 6
    //   92: aload_1
    //   93: invokevirtual 251	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   96: invokevirtual 259	com/tencent/component/network/utils/http/HttpConnPool:release	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   99: aload_1
    //   100: monitorexit
    //   101: return
    //   102: astore 4
    //   104: aload_0
    //   105: getfield 69	com/tencent/component/network/utils/http/PoolingClientConnectionManager:pool	Lcom/tencent/component/network/utils/http/HttpConnPool;
    //   108: aload 6
    //   110: aload_1
    //   111: invokevirtual 251	com/tencent/component/network/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   114: invokevirtual 259	com/tencent/component/network/utils/http/HttpConnPool:release	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   117: aload 4
    //   119: athrow
    //   120: astore 4
    //   122: aload_1
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    //   127: new 216	java/lang/IllegalStateException
    //   130: dup
    //   131: ldc_w 261
    //   134: invokespecial 219	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: new 71	java/lang/IllegalArgumentException
    //   141: dup
    //   142: ldc_w 263
    //   145: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    //   149: astore 7
    //   151: goto -93 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	PoolingClientConnectionManager
    //   0	154	1	paramManagedClientConnection	ManagedClientConnection
    //   0	154	2	paramLong	long
    //   0	154	4	paramTimeUnit	TimeUnit
    //   47	3	5	bool	boolean
    //   26	83	6	localHttpPoolEntry	HttpPoolEntry
    //   149	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   36	49	102	finally
    //   54	58	102	finally
    //   58	65	102	finally
    //   73	78	102	finally
    //   78	86	102	finally
    //   22	28	120	finally
    //   33	35	120	finally
    //   86	101	120	finally
    //   104	120	120	finally
    //   122	124	120	finally
    //   54	58	149	java/io/IOException
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute != null) {
      return new PoolingClientConnectionManager.1(this, this.pool.lease(paramHttpRoute, paramObject));
    }
    throw new IllegalArgumentException("HTTP route may not be null");
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    this.pool.setDefaultMaxPerRoute(paramInt);
  }
  
  public void setMaxPerRoute(HttpRoute paramHttpRoute, int paramInt)
  {
    this.pool.setMaxPerRoute(paramHttpRoute, paramInt);
  }
  
  public void setMaxTotal(int paramInt)
  {
    this.pool.setMaxTotal(paramInt);
  }
  
  public void shutdown()
  {
    try
    {
      this.pool.shutdown();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.PoolingClientConnectionManager
 * JD-Core Version:    0.7.0.1
 */