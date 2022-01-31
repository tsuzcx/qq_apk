package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.ConnPoolControl;
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
import org.apache.http.impl.conn.DefaultClientConnectionOperator;
import pps;
import ppu;
import ppv;
import ppw;

public class PoolingClientConnectionManager
  implements ConnPoolControl, ClientConnectionManager
{
  private final DnsResolver jdField_a_of_type_ComTencentComponentNetworkUtilsHttpDnsResolver;
  private final ClientConnectionOperator jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator;
  private final SchemeRegistry jdField_a_of_type_OrgApacheHttpConnSchemeSchemeRegistry;
  private final pps jdField_a_of_type_Pps;
  
  public PoolingClientConnectionManager()
  {
    this(SchemeRegistryFactory.a());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramSchemeRegistry, paramLong, paramTimeUnit, new SystemDefaultDnsResolver());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, DnsResolver paramDnsResolver)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    if (paramDnsResolver == null) {
      throw new IllegalArgumentException("DNS resolver may not be null");
    }
    this.jdField_a_of_type_OrgApacheHttpConnSchemeSchemeRegistry = paramSchemeRegistry;
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpDnsResolver = paramDnsResolver;
    this.jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator = a(paramSchemeRegistry);
    this.jdField_a_of_type_Pps = new pps(null, 2, 20, paramLong, paramTimeUnit);
  }
  
  protected ClientConnectionOperator a(SchemeRegistry paramSchemeRegistry)
  {
    return new DefaultClientConnectionOperator(paramSchemeRegistry);
  }
  
  public ManagedClientConnection a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit = (ppu)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
        throw new InterruptedException();
      }
    }
    catch (ExecutionException paramFuture)
    {
      if (paramFuture.getCause() == null) {}
      throw new InterruptedException();
      if (paramTimeUnit.b() == null) {
        throw new IllegalStateException("Pool entry with no connection");
      }
    }
    catch (TimeoutException paramFuture)
    {
      throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
    }
    paramFuture = new ppv(this, this.jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator, paramTimeUnit);
    return paramFuture;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Pps.a(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Pps.b(paramInt);
  }
  
  public void closeExpiredConnections()
  {
    this.jdField_a_of_type_Pps.b();
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    this.jdField_a_of_type_Pps.a(paramLong, paramTimeUnit);
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
  
  public SchemeRegistry getSchemeRegistry()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnSchemeSchemeRegistry;
  }
  
  /* Error */
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 111
    //   4: ifne +13 -> 17
    //   7: new 45	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 139
    //   13: invokespecial 50	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: checkcast 111	ppv
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 142	ppv:a	()Lorg/apache/http/conn/ClientConnectionManager;
    //   26: aload_0
    //   27: if_acmpeq +13 -> 40
    //   30: new 101	java/lang/IllegalStateException
    //   33: dup
    //   34: ldc 144
    //   36: invokespecial 104	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: aload_1
    //   41: monitorenter
    //   42: aload_1
    //   43: invokevirtual 147	ppv:a	()Lppu;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnonnull +6 -> 56
    //   53: aload_1
    //   54: monitorexit
    //   55: return
    //   56: aload_1
    //   57: invokevirtual 150	ppv:isOpen	()Z
    //   60: ifeq +18 -> 78
    //   63: aload_1
    //   64: invokevirtual 153	ppv:isMarkedReusable	()Z
    //   67: istore 5
    //   69: iload 5
    //   71: ifne +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 154	ppv:shutdown	()V
    //   78: aload_1
    //   79: invokevirtual 153	ppv:isMarkedReusable	()Z
    //   82: ifeq +16 -> 98
    //   85: aload 4
    //   87: ifnull +34 -> 121
    //   90: aload 6
    //   92: lload_2
    //   93: aload 4
    //   95: invokevirtual 155	ppu:a	(JLjava/util/concurrent/TimeUnit;)V
    //   98: aload_0
    //   99: getfield 68	com/tencent/component/network/utils/http/PoolingClientConnectionManager:jdField_a_of_type_Pps	Lpps;
    //   102: aload 6
    //   104: aload_1
    //   105: invokevirtual 153	ppv:isMarkedReusable	()Z
    //   108: invokevirtual 158	pps:a	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore 4
    //   116: aload_1
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: getstatic 32	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   124: astore 4
    //   126: goto -36 -> 90
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 68	com/tencent/component/network/utils/http/PoolingClientConnectionManager:jdField_a_of_type_Pps	Lpps;
    //   135: aload 6
    //   137: aload_1
    //   138: invokevirtual 153	ppv:isMarkedReusable	()Z
    //   141: invokevirtual 158	pps:a	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   144: aload 4
    //   146: athrow
    //   147: astore 7
    //   149: goto -71 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	PoolingClientConnectionManager
    //   0	152	1	paramManagedClientConnection	ManagedClientConnection
    //   0	152	2	paramLong	long
    //   0	152	4	paramTimeUnit	TimeUnit
    //   67	3	5	bool	boolean
    //   46	90	6	localppu	ppu
    //   147	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   42	48	114	finally
    //   53	55	114	finally
    //   98	113	114	finally
    //   116	118	114	finally
    //   131	147	114	finally
    //   56	69	129	finally
    //   74	78	129	finally
    //   78	85	129	finally
    //   90	98	129	finally
    //   121	126	129	finally
    //   74	78	147	java/io/IOException
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("HTTP route may not be null");
    }
    return new ppw(this, this.jdField_a_of_type_Pps.a(paramHttpRoute, paramObject));
  }
  
  public void shutdown()
  {
    try
    {
      this.jdField_a_of_type_Pps.a();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.PoolingClientConnectionManager
 * JD-Core Version:    0.7.0.1
 */