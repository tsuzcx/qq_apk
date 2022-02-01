package com.tencent.component.network.utils.http;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;

class PoolingClientConnectionManager$1
  implements ClientConnectionRequest
{
  PoolingClientConnectionManager$1(PoolingClientConnectionManager paramPoolingClientConnectionManager, Future paramFuture) {}
  
  public void abortRequest()
  {
    this.val$future.cancel(true);
  }
  
  public ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.this$0.leaseConnection(this.val$future, paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.PoolingClientConnectionManager.1
 * JD-Core Version:    0.7.0.1
 */