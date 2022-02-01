package com.tencent.beacon.core.network.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final Cache mCache;
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request<?>> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mQueue = paramBlockingQueue;
    this.mNetwork = paramNetwork;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
  }
  
  @TargetApi(14)
  private void addTrafficStatsTag(Request<?> paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
    }
  }
  
  private void parseAndDeliverNetworkError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    this.mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  private void processRequest()
  {
    processRequest((Request)this.mQueue.take());
  }
  
  /* Error */
  void processRequest(Request<?> paramRequest)
  {
    // Byte code:
    //   0: invokestatic 89	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: iconst_3
    //   6: invokevirtual 92	com/tencent/beacon/core/network/volley/Request:sendEvent	(I)V
    //   9: aload_1
    //   10: ldc 94
    //   12: invokevirtual 98	com/tencent/beacon/core/network/volley/Request:addMarker	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 102	com/tencent/beacon/core/network/volley/Request:isCanceled	()Z
    //   19: istore 4
    //   21: iload 4
    //   23: ifeq +19 -> 42
    //   26: aload_1
    //   27: ldc 104
    //   29: invokevirtual 107	com/tencent/beacon/core/network/volley/Request:finish	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: invokevirtual 110	com/tencent/beacon/core/network/volley/Request:notifyListenerResponseNotUsable	()V
    //   36: aload_1
    //   37: iconst_4
    //   38: invokevirtual 92	com/tencent/beacon/core/network/volley/Request:sendEvent	(I)V
    //   41: return
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 112	com/tencent/beacon/core/network/volley/NetworkDispatcher:addTrafficStatsTag	(Lcom/tencent/beacon/core/network/volley/Request;)V
    //   47: aload_0
    //   48: getfield 26	com/tencent/beacon/core/network/volley/NetworkDispatcher:mNetwork	Lcom/tencent/beacon/core/network/volley/Network;
    //   51: aload_1
    //   52: invokeinterface 118 2 0
    //   57: astore 5
    //   59: aload_1
    //   60: ldc 120
    //   62: invokevirtual 98	com/tencent/beacon/core/network/volley/Request:addMarker	(Ljava/lang/String;)V
    //   65: aload 5
    //   67: getfield 125	com/tencent/beacon/core/network/volley/NetworkResponse:notModified	Z
    //   70: ifeq +30 -> 100
    //   73: aload_1
    //   74: invokevirtual 128	com/tencent/beacon/core/network/volley/Request:hasHadResponseDelivered	()Z
    //   77: istore 4
    //   79: iload 4
    //   81: ifeq +19 -> 100
    //   84: aload_1
    //   85: ldc 130
    //   87: invokevirtual 107	com/tencent/beacon/core/network/volley/Request:finish	(Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokevirtual 110	com/tencent/beacon/core/network/volley/Request:notifyListenerResponseNotUsable	()V
    //   94: aload_1
    //   95: iconst_4
    //   96: invokevirtual 92	com/tencent/beacon/core/network/volley/Request:sendEvent	(I)V
    //   99: return
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 134	com/tencent/beacon/core/network/volley/Request:parseNetworkResponse	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)Lcom/tencent/beacon/core/network/volley/Response;
    //   106: astore 5
    //   108: aload_1
    //   109: ldc 136
    //   111: invokevirtual 98	com/tencent/beacon/core/network/volley/Request:addMarker	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokevirtual 139	com/tencent/beacon/core/network/volley/Request:shouldCache	()Z
    //   118: ifeq +35 -> 153
    //   121: aload 5
    //   123: getfield 145	com/tencent/beacon/core/network/volley/Response:cacheEntry	Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   126: ifnull +27 -> 153
    //   129: aload_0
    //   130: getfield 28	com/tencent/beacon/core/network/volley/NetworkDispatcher:mCache	Lcom/tencent/beacon/core/network/volley/Cache;
    //   133: aload_1
    //   134: invokevirtual 149	com/tencent/beacon/core/network/volley/Request:getCacheKey	()Ljava/lang/String;
    //   137: aload 5
    //   139: getfield 145	com/tencent/beacon/core/network/volley/Response:cacheEntry	Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   142: invokeinterface 155 3 0
    //   147: aload_1
    //   148: ldc 157
    //   150: invokevirtual 98	com/tencent/beacon/core/network/volley/Request:addMarker	(Ljava/lang/String;)V
    //   153: aload_1
    //   154: invokevirtual 160	com/tencent/beacon/core/network/volley/Request:markDelivered	()V
    //   157: aload_0
    //   158: getfield 30	com/tencent/beacon/core/network/volley/NetworkDispatcher:mDelivery	Lcom/tencent/beacon/core/network/volley/ResponseDelivery;
    //   161: aload_1
    //   162: aload 5
    //   164: invokeinterface 164 3 0
    //   169: aload_1
    //   170: aload 5
    //   172: invokevirtual 168	com/tencent/beacon/core/network/volley/Request:notifyListenerResponseReceived	(Lcom/tencent/beacon/core/network/volley/Response;)V
    //   175: aload_1
    //   176: iconst_4
    //   177: invokevirtual 92	com/tencent/beacon/core/network/volley/Request:sendEvent	(I)V
    //   180: return
    //   181: astore 5
    //   183: aload 5
    //   185: ldc 170
    //   187: iconst_1
    //   188: anewarray 172	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload 5
    //   195: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   198: aastore
    //   199: invokestatic 181	com/tencent/beacon/core/network/volley/VolleyLog:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: new 81	com/tencent/beacon/core/network/volley/VolleyError
    //   205: dup
    //   206: aload 5
    //   208: invokespecial 184	com/tencent/beacon/core/network/volley/VolleyError:<init>	(Ljava/lang/Throwable;)V
    //   211: astore 5
    //   213: aload 5
    //   215: invokestatic 89	android/os/SystemClock:elapsedRealtime	()J
    //   218: lload_2
    //   219: lsub
    //   220: invokevirtual 188	com/tencent/beacon/core/network/volley/VolleyError:setNetworkTimeMs	(J)V
    //   223: aload_0
    //   224: getfield 30	com/tencent/beacon/core/network/volley/NetworkDispatcher:mDelivery	Lcom/tencent/beacon/core/network/volley/ResponseDelivery;
    //   227: aload_1
    //   228: aload 5
    //   230: invokeinterface 69 3 0
    //   235: aload_1
    //   236: invokevirtual 110	com/tencent/beacon/core/network/volley/Request:notifyListenerResponseNotUsable	()V
    //   239: goto -64 -> 175
    //   242: astore 5
    //   244: aload_1
    //   245: iconst_4
    //   246: invokevirtual 92	com/tencent/beacon/core/network/volley/Request:sendEvent	(I)V
    //   249: aload 5
    //   251: athrow
    //   252: astore 5
    //   254: aload 5
    //   256: invokestatic 89	android/os/SystemClock:elapsedRealtime	()J
    //   259: lload_2
    //   260: lsub
    //   261: invokevirtual 188	com/tencent/beacon/core/network/volley/VolleyError:setNetworkTimeMs	(J)V
    //   264: aload_0
    //   265: aload_1
    //   266: aload 5
    //   268: invokespecial 190	com/tencent/beacon/core/network/volley/NetworkDispatcher:parseAndDeliverNetworkError	(Lcom/tencent/beacon/core/network/volley/Request;Lcom/tencent/beacon/core/network/volley/VolleyError;)V
    //   271: aload_1
    //   272: invokevirtual 110	com/tencent/beacon/core/network/volley/Request:notifyListenerResponseNotUsable	()V
    //   275: goto -100 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	NetworkDispatcher
    //   0	278	1	paramRequest	Request<?>
    //   3	257	2	l	long
    //   19	61	4	bool	boolean
    //   57	114	5	localObject1	Object
    //   181	26	5	localException	java.lang.Exception
    //   211	18	5	localVolleyError1	VolleyError
    //   242	8	5	localObject2	Object
    //   252	15	5	localVolleyError2	VolleyError
    // Exception table:
    //   from	to	target	type
    //   9	21	181	java/lang/Exception
    //   26	36	181	java/lang/Exception
    //   42	59	181	java/lang/Exception
    //   59	79	181	java/lang/Exception
    //   84	94	181	java/lang/Exception
    //   100	108	181	java/lang/Exception
    //   108	147	181	java/lang/Exception
    //   147	153	181	java/lang/Exception
    //   153	175	181	java/lang/Exception
    //   9	21	242	finally
    //   26	36	242	finally
    //   42	59	242	finally
    //   59	79	242	finally
    //   84	94	242	finally
    //   100	108	242	finally
    //   108	147	242	finally
    //   147	153	242	finally
    //   153	175	242	finally
    //   183	239	242	finally
    //   254	275	242	finally
    //   9	21	252	com/tencent/beacon/core/network/volley/VolleyError
    //   26	36	252	com/tencent/beacon/core/network/volley/VolleyError
    //   42	59	252	com/tencent/beacon/core/network/volley/VolleyError
    //   59	79	252	com/tencent/beacon/core/network/volley/VolleyError
    //   84	94	252	com/tencent/beacon/core/network/volley/VolleyError
    //   100	108	252	com/tencent/beacon/core/network/volley/VolleyError
    //   108	147	252	com/tencent/beacon/core/network/volley/VolleyError
    //   147	153	252	com/tencent/beacon/core/network/volley/VolleyError
    //   153	175	252	com/tencent/beacon/core/network/volley/VolleyError
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
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
      VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.NetworkDispatcher
 * JD-Core Version:    0.7.0.1
 */