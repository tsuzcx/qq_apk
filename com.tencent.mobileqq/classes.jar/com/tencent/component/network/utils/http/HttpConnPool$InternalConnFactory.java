package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.ConnFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.DefaultClientConnection;

class HttpConnPool$InternalConnFactory
  implements ConnFactory<HttpRoute, OperatedClientConnection>
{
  public OperatedClientConnection create(HttpRoute paramHttpRoute)
  {
    return new DefaultClientConnection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpConnPool.InternalConnFactory
 * JD-Core Version:    0.7.0.1
 */