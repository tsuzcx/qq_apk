package com.tencent.beacon.core.network.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher
  extends Thread
{
  private static final boolean DEBUG = VolleyLog.DEBUG;
  private final Cache mCache;
  private final BlockingQueue<Request<?>> mCacheQueue;
  private final ResponseDelivery mDelivery;
  private final BlockingQueue<Request<?>> mNetworkQueue;
  private volatile boolean mQuit = false;
  private final CacheDispatcher.WaitingRequestManager mWaitingRequestManager;
  
  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mCacheQueue = paramBlockingQueue1;
    this.mNetworkQueue = paramBlockingQueue2;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
    this.mWaitingRequestManager = new CacheDispatcher.WaitingRequestManager(this);
  }
  
  private void processRequest()
  {
    processRequest((Request)this.mCacheQueue.take());
  }
  
  void processRequest(Request<?> paramRequest)
  {
    paramRequest.addMarker("cache-queue-take");
    paramRequest.sendEvent(1);
    for (;;)
    {
      try
      {
        boolean bool = paramRequest.isCanceled();
        if (bool)
        {
          paramRequest.finish("cache-discard-canceled");
          return;
        }
        Cache.Entry localEntry = this.mCache.get(paramRequest.getCacheKey());
        if (localEntry == null)
        {
          paramRequest.addMarker("cache-miss");
          if (!CacheDispatcher.WaitingRequestManager.access$000(this.mWaitingRequestManager, paramRequest)) {
            this.mNetworkQueue.put(paramRequest);
          }
          return;
        }
        bool = localEntry.isExpired();
        if (bool)
        {
          paramRequest.addMarker("cache-hit-expired");
          paramRequest.setCacheEntry(localEntry);
          if (!CacheDispatcher.WaitingRequestManager.access$000(this.mWaitingRequestManager, paramRequest)) {
            this.mNetworkQueue.put(paramRequest);
          }
          return;
        }
        paramRequest.addMarker("cache-hit");
        Response localResponse = paramRequest.parseNetworkResponse(new NetworkResponse(localEntry.data, localEntry.responseHeaders));
        paramRequest.addMarker("cache-hit-parsed");
        if (!localEntry.refreshNeeded())
        {
          this.mDelivery.postResponse(paramRequest, localResponse);
          return;
        }
        paramRequest.addMarker("cache-hit-refresh-needed");
        paramRequest.setCacheEntry(localEntry);
        localResponse.intermediate = true;
        if (!CacheDispatcher.WaitingRequestManager.access$000(this.mWaitingRequestManager, paramRequest)) {
          this.mDelivery.postResponse(paramRequest, localResponse, new CacheDispatcher.1(this, paramRequest));
        } else {
          this.mDelivery.postResponse(paramRequest, localResponse);
        }
      }
      finally
      {
        paramRequest.sendEvent(2);
      }
    }
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      VolleyLog.v("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.mCache.initialize();
    try
    {
      for (;;)
      {
        processRequest();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (this.mQuit)
      {
        Thread.currentThread().interrupt();
        return;
      }
      VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.CacheDispatcher
 * JD-Core Version:    0.7.0.1
 */