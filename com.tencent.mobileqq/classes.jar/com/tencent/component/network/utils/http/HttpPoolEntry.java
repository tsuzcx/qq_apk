package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;

class HttpPoolEntry
  extends PoolEntry<HttpRoute, OperatedClientConnection>
{
  HttpRoute route;
  private RouteTracker tracker;
  
  public HttpPoolEntry(Log paramLog, String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
    this.route = paramHttpRoute;
    this.tracker = new RouteTracker(paramHttpRoute);
  }
  
  public void close()
  {
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)getConnection();
    try
    {
      localOperatedClientConnection.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  HttpRoute getEffectiveRoute()
  {
    return this.tracker.toRoute();
  }
  
  HttpRoute getPlannedRoute()
  {
    return (HttpRoute)getRoute();
  }
  
  RouteTracker getTracker()
  {
    return this.tracker;
  }
  
  public boolean isClosed()
  {
    return !((OperatedClientConnection)getConnection()).isOpen();
  }
  
  public boolean isExpired(long paramLong)
  {
    return super.isExpired(paramLong);
  }
  
  public void resetTracker()
  {
    this.tracker = new RouteTracker(this.route);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.utils.http.HttpPoolEntry
 * JD-Core Version:    0.7.0.1
 */