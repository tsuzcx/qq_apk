package com.tencent.beacon.core.network.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
  private final Cache mCache;
  private CacheDispatcher mCacheDispatcher;
  private final PriorityBlockingQueue<Request<?>> mCacheQueue = new PriorityBlockingQueue();
  private final Set<Request<?>> mCurrentRequests = new HashSet();
  private final ResponseDelivery mDelivery;
  private final NetworkDispatcher[] mDispatchers;
  private final List<RequestQueue.RequestEventListener> mEventListeners = new ArrayList();
  private final List<RequestQueue.RequestFinishedListener> mFinishedListeners = new ArrayList();
  private final Network mNetwork;
  private final PriorityBlockingQueue<Request<?>> mNetworkQueue = new PriorityBlockingQueue();
  private final AtomicInteger mSequenceGenerator = new AtomicInteger();
  
  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    this.mCache = paramCache;
    this.mNetwork = paramNetwork;
    this.mDispatchers = new NetworkDispatcher[paramInt];
    this.mDelivery = paramResponseDelivery;
  }
  
  public <T> Request<T> add(Request<T> paramRequest)
  {
    paramRequest.setRequestQueue(this);
    synchronized (this.mCurrentRequests)
    {
      this.mCurrentRequests.add(paramRequest);
      paramRequest.setSequence(getSequenceNumber());
      paramRequest.addMarker("add-to-queue");
      sendRequestEvent(paramRequest, 0);
      if (!paramRequest.shouldCache())
      {
        this.mNetworkQueue.add(paramRequest);
        return paramRequest;
      }
      this.mCacheQueue.add(paramRequest);
      return paramRequest;
    }
  }
  
  public void addRequestEventListener(RequestQueue.RequestEventListener paramRequestEventListener)
  {
    synchronized (this.mEventListeners)
    {
      this.mEventListeners.add(paramRequestEventListener);
      return;
    }
  }
  
  @Deprecated
  public <T> void addRequestFinishedListener(RequestQueue.RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (this.mFinishedListeners)
    {
      this.mFinishedListeners.add(paramRequestFinishedListener);
      return;
    }
  }
  
  public void cancelAll(RequestQueue.RequestFilter paramRequestFilter)
  {
    synchronized (this.mCurrentRequests)
    {
      Iterator localIterator = this.mCurrentRequests.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.apply(localRequest)) {
          localRequest.cancel();
        }
      }
    }
  }
  
  public void cancelAll(Object paramObject)
  {
    if (paramObject != null)
    {
      cancelAll(new RequestQueue.1(this, paramObject));
      return;
    }
    throw new IllegalArgumentException("Cannot cancelAll with a null tag");
  }
  
  <T> void finish(Request<T> paramRequest)
  {
    synchronized (this.mCurrentRequests)
    {
      this.mCurrentRequests.remove(paramRequest);
      synchronized (this.mFinishedListeners)
      {
        Iterator localIterator = this.mFinishedListeners.iterator();
        if (localIterator.hasNext()) {
          ((RequestQueue.RequestFinishedListener)localIterator.next()).onRequestFinished(paramRequest);
        }
      }
      sendRequestEvent(paramRequest, 5);
      return;
    }
  }
  
  public Cache getCache()
  {
    return this.mCache;
  }
  
  public int getSequenceNumber()
  {
    return this.mSequenceGenerator.incrementAndGet();
  }
  
  public void removeRequestEventListener(RequestQueue.RequestEventListener paramRequestEventListener)
  {
    synchronized (this.mEventListeners)
    {
      this.mEventListeners.remove(paramRequestEventListener);
      return;
    }
  }
  
  @Deprecated
  public <T> void removeRequestFinishedListener(RequestQueue.RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (this.mFinishedListeners)
    {
      this.mFinishedListeners.remove(paramRequestFinishedListener);
      return;
    }
  }
  
  void sendRequestEvent(Request<?> paramRequest, int paramInt)
  {
    synchronized (this.mEventListeners)
    {
      Iterator localIterator = this.mEventListeners.iterator();
      if (localIterator.hasNext()) {
        ((RequestQueue.RequestEventListener)localIterator.next()).onRequestEvent(paramRequest, paramInt);
      }
    }
  }
  
  public void start()
  {
    stop();
    this.mCacheDispatcher = new CacheDispatcher(this.mCacheQueue, this.mNetworkQueue, this.mCache, this.mDelivery);
    this.mCacheDispatcher.start();
    int i = 0;
    while (i < this.mDispatchers.length)
    {
      NetworkDispatcher localNetworkDispatcher = new NetworkDispatcher(this.mNetworkQueue, this.mNetwork, this.mCache, this.mDelivery);
      this.mDispatchers[i] = localNetworkDispatcher;
      localNetworkDispatcher.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    Object localObject1 = this.mCacheDispatcher;
    if (localObject1 != null) {
      ((CacheDispatcher)localObject1).quit();
    }
    localObject1 = this.mDispatchers;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.quit();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.RequestQueue
 * JD-Core Version:    0.7.0.1
 */