package com.tencent.beacon.core.network.volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CacheDispatcher$WaitingRequestManager
  implements Request.NetworkRequestCompleteListener
{
  private final CacheDispatcher mCacheDispatcher;
  private final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();
  
  CacheDispatcher$WaitingRequestManager(CacheDispatcher paramCacheDispatcher)
  {
    this.mCacheDispatcher = paramCacheDispatcher;
  }
  
  /* Error */
  private boolean maybeAddToWaitingRequests(Request<?> paramRequest)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 36	com/tencent/beacon/core/network/volley/Request:getCacheKey	()Ljava/lang/String;
    //   8: astore 6
    //   10: aload_0
    //   11: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   14: aload 6
    //   16: invokeinterface 42 2 0
    //   21: ifeq +92 -> 113
    //   24: aload_0
    //   25: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   28: aload 6
    //   30: invokeinterface 46 2 0
    //   35: checkcast 48	java/util/List
    //   38: astore 5
    //   40: aload 5
    //   42: astore 4
    //   44: aload 5
    //   46: ifnonnull +12 -> 58
    //   49: new 50	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 51	java/util/ArrayList:<init>	()V
    //   56: astore 4
    //   58: aload_1
    //   59: ldc 53
    //   61: invokevirtual 57	com/tencent/beacon/core/network/volley/Request:addMarker	(Ljava/lang/String;)V
    //   64: aload 4
    //   66: aload_1
    //   67: invokeinterface 60 2 0
    //   72: pop
    //   73: aload_0
    //   74: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   77: aload 6
    //   79: aload 4
    //   81: invokeinterface 64 3 0
    //   86: pop
    //   87: getstatic 70	com/tencent/beacon/core/network/volley/VolleyLog:DEBUG	Z
    //   90: ifeq +17 -> 107
    //   93: ldc 72
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload 6
    //   103: aastore
    //   104: invokestatic 76	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: iconst_1
    //   108: istore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: iload_2
    //   112: ireturn
    //   113: aload_0
    //   114: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   117: aload 6
    //   119: aconst_null
    //   120: invokeinterface 64 3 0
    //   125: pop
    //   126: aload_1
    //   127: aload_0
    //   128: invokevirtual 80	com/tencent/beacon/core/network/volley/Request:setNetworkRequestCompleteListener	(Lcom/tencent/beacon/core/network/volley/Request$NetworkRequestCompleteListener;)V
    //   131: iload_3
    //   132: istore_2
    //   133: getstatic 70	com/tencent/beacon/core/network/volley/VolleyLog:DEBUG	Z
    //   136: ifeq -27 -> 109
    //   139: ldc 82
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload 6
    //   149: aastore
    //   150: invokestatic 76	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: iload_3
    //   154: istore_2
    //   155: goto -46 -> 109
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	WaitingRequestManager
    //   0	163	1	paramRequest	Request<?>
    //   108	47	2	bool1	boolean
    //   1	153	3	bool2	boolean
    //   42	38	4	localObject	Object
    //   38	7	5	localList	List
    //   8	140	6	str	String
    // Exception table:
    //   from	to	target	type
    //   4	40	158	finally
    //   49	58	158	finally
    //   58	107	158	finally
    //   113	131	158	finally
    //   133	153	158	finally
  }
  
  /* Error */
  public void onNoUsableResponseReceived(Request<?> paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 36	com/tencent/beacon/core/network/volley/Request:getCacheKey	()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 91 2 0
    //   17: checkcast 48	java/util/List
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +84 -> 106
    //   25: aload_2
    //   26: invokeinterface 95 1 0
    //   31: ifne +75 -> 106
    //   34: getstatic 70	com/tencent/beacon/core/network/volley/VolleyLog:DEBUG	Z
    //   37: ifeq +28 -> 65
    //   40: ldc 97
    //   42: iconst_2
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: invokeinterface 101 1 0
    //   54: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_1
    //   61: aastore
    //   62: invokestatic 110	com/tencent/beacon/core/network/volley/VolleyLog:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_2
    //   66: iconst_0
    //   67: invokeinterface 113 2 0
    //   72: checkcast 32	com/tencent/beacon/core/network/volley/Request
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   80: aload_1
    //   81: aload_2
    //   82: invokeinterface 64 3 0
    //   87: pop
    //   88: aload_3
    //   89: aload_0
    //   90: invokevirtual 80	com/tencent/beacon/core/network/volley/Request:setNetworkRequestCompleteListener	(Lcom/tencent/beacon/core/network/volley/Request$NetworkRequestCompleteListener;)V
    //   93: aload_0
    //   94: getfield 23	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mCacheDispatcher	Lcom/tencent/beacon/core/network/volley/CacheDispatcher;
    //   97: invokestatic 119	com/tencent/beacon/core/network/volley/CacheDispatcher:access$100	(Lcom/tencent/beacon/core/network/volley/CacheDispatcher;)Ljava/util/concurrent/BlockingQueue;
    //   100: aload_3
    //   101: invokeinterface 124 2 0
    //   106: aload_0
    //   107: monitorexit
    //   108: return
    //   109: astore_1
    //   110: ldc 126
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokevirtual 129	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 132	com/tencent/beacon/core/network/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: invokestatic 138	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   129: invokevirtual 141	java/lang/Thread:interrupt	()V
    //   132: aload_0
    //   133: getfield 23	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mCacheDispatcher	Lcom/tencent/beacon/core/network/volley/CacheDispatcher;
    //   136: invokevirtual 144	com/tencent/beacon/core/network/volley/CacheDispatcher:quit	()V
    //   139: goto -33 -> 106
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	WaitingRequestManager
    //   0	147	1	paramRequest	Request<?>
    //   20	62	2	localList	List
    //   75	26	3	localRequest	Request
    // Exception table:
    //   from	to	target	type
    //   93	106	109	java/lang/InterruptedException
    //   2	21	142	finally
    //   25	65	142	finally
    //   65	93	142	finally
    //   93	106	142	finally
    //   110	139	142	finally
  }
  
  /* Error */
  public void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 153	com/tencent/beacon/core/network/volley/Response:cacheEntry	Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +10 -> 16
    //   9: aload_3
    //   10: invokevirtual 158	com/tencent/beacon/core/network/volley/Cache$Entry:isExpired	()Z
    //   13: ifeq +9 -> 22
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 160	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:onNoUsableResponseReceived	(Lcom/tencent/beacon/core/network/volley/Request;)V
    //   21: return
    //   22: aload_1
    //   23: invokevirtual 36	com/tencent/beacon/core/network/volley/Request:getCacheKey	()Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 21	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mWaitingRequests	Ljava/util/Map;
    //   33: aload_1
    //   34: invokeinterface 91 2 0
    //   39: checkcast 48	java/util/List
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: ifnull -25 -> 21
    //   49: getstatic 70	com/tencent/beacon/core/network/volley/VolleyLog:DEBUG	Z
    //   52: ifeq +28 -> 80
    //   55: ldc 162
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_3
    //   64: invokeinterface 101 1 0
    //   69: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 110	com/tencent/beacon/core/network/volley/VolleyLog:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokeinterface 166 1 0
    //   86: astore_1
    //   87: aload_1
    //   88: invokeinterface 171 1 0
    //   93: ifeq -72 -> 21
    //   96: aload_1
    //   97: invokeinterface 175 1 0
    //   102: checkcast 32	com/tencent/beacon/core/network/volley/Request
    //   105: astore_3
    //   106: aload_0
    //   107: getfield 23	com/tencent/beacon/core/network/volley/CacheDispatcher$WaitingRequestManager:mCacheDispatcher	Lcom/tencent/beacon/core/network/volley/CacheDispatcher;
    //   110: invokestatic 179	com/tencent/beacon/core/network/volley/CacheDispatcher:access$200	(Lcom/tencent/beacon/core/network/volley/CacheDispatcher;)Lcom/tencent/beacon/core/network/volley/ResponseDelivery;
    //   113: aload_3
    //   114: aload_2
    //   115: invokeinterface 184 3 0
    //   120: goto -33 -> 87
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	WaitingRequestManager
    //   0	128	1	paramRequest	Request<?>
    //   0	128	2	paramResponse	Response<?>
    //   4	110	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	45	123	finally
    //   124	126	123	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.CacheDispatcher.WaitingRequestManager
 * JD-Core Version:    0.7.0.1
 */