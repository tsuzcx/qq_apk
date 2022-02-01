package com.tencent.beacon.core.network.volley;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BasicNetwork
  implements Network
{
  protected static final boolean DEBUG = VolleyLog.DEBUG;
  private static final int DEFAULT_POOL_SIZE = 4096;
  private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
  private final BaseHttpStack mBaseHttpStack;
  @Deprecated
  protected final HttpStack mHttpStack;
  protected final ByteArrayPool mPool;
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack)
  {
    this(paramBaseHttpStack, new ByteArrayPool(4096));
  }
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.mBaseHttpStack = paramBaseHttpStack;
    this.mHttpStack = paramBaseHttpStack;
    this.mPool = paramByteArrayPool;
  }
  
  @Deprecated
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(4096));
  }
  
  @Deprecated
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.mHttpStack = paramHttpStack;
    this.mBaseHttpStack = new AdaptedHttpStack(paramHttpStack);
    this.mPool = paramByteArrayPool;
  }
  
  private static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError paramVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramVolleyError;
    }
  }
  
  private static List<Header> combineHeaders(List<Header> paramList, Cache.Entry paramEntry)
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    if (!paramList.isEmpty())
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localTreeSet.add(((Header)((Iterator)localObject).next()).getName());
      }
    }
    paramList = new ArrayList(paramList);
    Object localObject = paramEntry.allResponseHeaders;
    if (localObject != null)
    {
      if (!((List)localObject).isEmpty())
      {
        paramEntry = paramEntry.allResponseHeaders.iterator();
        while (paramEntry.hasNext())
        {
          localObject = (Header)paramEntry.next();
          if (!localTreeSet.contains(((Header)localObject).getName())) {
            paramList.add(localObject);
          }
        }
      }
    }
    else if (!paramEntry.responseHeaders.isEmpty())
    {
      paramEntry = paramEntry.responseHeaders.entrySet().iterator();
      while (paramEntry.hasNext())
      {
        localObject = (Map.Entry)paramEntry.next();
        if (!localTreeSet.contains(((Map.Entry)localObject).getKey())) {
          paramList.add(new Header((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue()));
        }
      }
    }
    return paramList;
  }
  
  @Deprecated
  protected static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private Map<String, String> getCacheHeaders(Cache.Entry paramEntry)
  {
    if (paramEntry == null) {
      paramEntry = Collections.emptyMap();
    }
    HashMap localHashMap;
    long l;
    do
    {
      return paramEntry;
      localHashMap = new HashMap();
      String str = paramEntry.etag;
      if (str != null) {
        localHashMap.put("If-None-Match", str);
      }
      l = paramEntry.lastModified;
      paramEntry = localHashMap;
    } while (l <= 0L);
    localHashMap.put("If-Modified-Since", HttpHeaderParser.formatEpochAsRfc1123(l));
    return localHashMap;
  }
  
  /* Error */
  private byte[] inputStreamToBytes(java.io.InputStream paramInputStream, int paramInt)
  {
    // Byte code:
    //   0: new 226	com/tencent/beacon/core/network/volley/PoolingByteArrayOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 46	com/tencent/beacon/core/network/volley/BasicNetwork:mPool	Lcom/tencent/beacon/core/network/volley/ByteArrayPool;
    //   8: iload_2
    //   9: invokespecial 229	com/tencent/beacon/core/network/volley/PoolingByteArrayOutputStream:<init>	(Lcom/tencent/beacon/core/network/volley/ByteArrayPool;I)V
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 4
    //   17: aload_1
    //   18: ifnull +113 -> 131
    //   21: aload_0
    //   22: getfield 46	com/tencent/beacon/core/network/volley/BasicNetwork:mPool	Lcom/tencent/beacon/core/network/volley/ByteArrayPool;
    //   25: sipush 1024
    //   28: invokevirtual 233	com/tencent/beacon/core/network/volley/ByteArrayPool:getBuf	(I)[B
    //   31: astore_3
    //   32: aload_1
    //   33: aload_3
    //   34: invokevirtual 239	java/io/InputStream:read	([B)I
    //   37: istore_2
    //   38: iload_2
    //   39: iconst_m1
    //   40: if_icmpeq +46 -> 86
    //   43: aload 6
    //   45: aload_3
    //   46: iconst_0
    //   47: iload_2
    //   48: invokevirtual 243	com/tencent/beacon/core/network/volley/PoolingByteArrayOutputStream:write	([BII)V
    //   51: goto -19 -> 32
    //   54: astore 5
    //   56: aload_3
    //   57: astore 4
    //   59: aload 5
    //   61: astore_3
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 246	java/io/InputStream:close	()V
    //   70: aload_0
    //   71: getfield 46	com/tencent/beacon/core/network/volley/BasicNetwork:mPool	Lcom/tencent/beacon/core/network/volley/ByteArrayPool;
    //   74: aload 4
    //   76: invokevirtual 250	com/tencent/beacon/core/network/volley/ByteArrayPool:returnBuf	([B)V
    //   79: aload 6
    //   81: invokevirtual 251	com/tencent/beacon/core/network/volley/PoolingByteArrayOutputStream:close	()V
    //   84: aload_3
    //   85: athrow
    //   86: aload 6
    //   88: invokevirtual 257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   91: astore 4
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 246	java/io/InputStream:close	()V
    //   101: aload_0
    //   102: getfield 46	com/tencent/beacon/core/network/volley/BasicNetwork:mPool	Lcom/tencent/beacon/core/network/volley/ByteArrayPool;
    //   105: aload_3
    //   106: invokevirtual 250	com/tencent/beacon/core/network/volley/ByteArrayPool:returnBuf	([B)V
    //   109: aload 6
    //   111: invokevirtual 251	com/tencent/beacon/core/network/volley/PoolingByteArrayOutputStream:close	()V
    //   114: aload 4
    //   116: areturn
    //   117: astore_1
    //   118: ldc_w 259
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 263	com/tencent/beacon/core/network/volley/VolleyLog:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -27 -> 101
    //   131: new 265	com/tencent/beacon/core/network/volley/ServerError
    //   134: dup
    //   135: invokespecial 266	com/tencent/beacon/core/network/volley/ServerError:<init>	()V
    //   138: athrow
    //   139: astore_3
    //   140: goto -78 -> 62
    //   143: astore_1
    //   144: ldc_w 259
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 263	com/tencent/beacon/core/network/volley/VolleyLog:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: goto -84 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	BasicNetwork
    //   0	157	1	paramInputStream	java.io.InputStream
    //   0	157	2	paramInt	int
    //   31	75	3	localObject1	Object
    //   139	1	3	localObject2	Object
    //   15	100	4	localObject3	Object
    //   54	6	5	localObject4	Object
    //   12	98	6	localPoolingByteArrayOutputStream	PoolingByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   32	38	54	finally
    //   43	51	54	finally
    //   86	93	54	finally
    //   97	101	117	java/io/IOException
    //   21	32	139	finally
    //   131	139	139	finally
    //   66	70	143	java/io/IOException
  }
  
  private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, int paramInt)
  {
    if ((DEBUG) || (paramLong > 3000L)) {
      if (paramArrayOfByte == null) {
        break label77;
      }
    }
    label77:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramInt), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
      return;
    }
  }
  
  protected void logError(String paramString1, String paramString2, long paramLong)
  {
    VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[] { paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2 });
  }
  
  /* Error */
  public NetworkResponse performRequest(Request<?> paramRequest)
  {
    // Byte code:
    //   0: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: invokestatic 306	java/util/Collections:emptyList	()Ljava/util/List;
    //   10: astore 8
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 310	com/tencent/beacon/core/network/volley/Request:getCacheEntry	()Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   17: invokespecial 312	com/tencent/beacon/core/network/volley/BasicNetwork:getCacheHeaders	(Lcom/tencent/beacon/core/network/volley/Cache$Entry;)Ljava/util/Map;
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 42	com/tencent/beacon/core/network/volley/BasicNetwork:mBaseHttpStack	Lcom/tencent/beacon/core/network/volley/BaseHttpStack;
    //   26: aload_1
    //   27: aload 5
    //   29: invokevirtual 318	com/tencent/beacon/core/network/volley/BaseHttpStack:executeRequest	(Lcom/tencent/beacon/core/network/volley/Request;Ljava/util/Map;)Lcom/tencent/beacon/core/network/volley/HttpResponse;
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 323	com/tencent/beacon/core/network/volley/HttpResponse:getStatusCode	()I
    //   39: istore_2
    //   40: aload 5
    //   42: invokevirtual 326	com/tencent/beacon/core/network/volley/HttpResponse:getHeaders	()Ljava/util/List;
    //   45: astore 6
    //   47: aload 6
    //   49: astore 8
    //   51: iload_2
    //   52: sipush 304
    //   55: if_icmpne +67 -> 122
    //   58: aload_1
    //   59: invokevirtual 310	com/tencent/beacon/core/network/volley/Request:getCacheEntry	()Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +23 -> 89
    //   69: new 328	com/tencent/beacon/core/network/volley/NetworkResponse
    //   72: dup
    //   73: sipush 304
    //   76: aconst_null
    //   77: iconst_1
    //   78: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   81: lload_3
    //   82: lsub
    //   83: aload 8
    //   85: invokespecial 331	com/tencent/beacon/core/network/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   88: areturn
    //   89: aload 8
    //   91: aload 6
    //   93: invokestatic 333	com/tencent/beacon/core/network/volley/BasicNetwork:combineHeaders	(Ljava/util/List;Lcom/tencent/beacon/core/network/volley/Cache$Entry;)Ljava/util/List;
    //   96: astore 7
    //   98: new 328	com/tencent/beacon/core/network/volley/NetworkResponse
    //   101: dup
    //   102: sipush 304
    //   105: aload 6
    //   107: getfield 337	com/tencent/beacon/core/network/volley/Cache$Entry:data	[B
    //   110: iconst_1
    //   111: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   114: lload_3
    //   115: lsub
    //   116: aload 7
    //   118: invokespecial 331	com/tencent/beacon/core/network/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   121: areturn
    //   122: aload 5
    //   124: invokevirtual 341	com/tencent/beacon/core/network/volley/HttpResponse:getContent	()Ljava/io/InputStream;
    //   127: astore 6
    //   129: aload 6
    //   131: ifnull +85 -> 216
    //   134: aload_0
    //   135: aload 6
    //   137: aload 5
    //   139: invokevirtual 344	com/tencent/beacon/core/network/volley/HttpResponse:getContentLength	()I
    //   142: invokespecial 346	com/tencent/beacon/core/network/volley/BasicNetwork:inputStreamToBytes	(Ljava/io/InputStream;I)[B
    //   145: astore 6
    //   147: aload_0
    //   148: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   151: lload_3
    //   152: lsub
    //   153: aload_1
    //   154: aload 6
    //   156: iload_2
    //   157: invokespecial 348	com/tencent/beacon/core/network/volley/BasicNetwork:logSlowRequests	(JLcom/tencent/beacon/core/network/volley/Request;[BI)V
    //   160: iload_2
    //   161: sipush 200
    //   164: if_icmplt +60 -> 224
    //   167: iload_2
    //   168: sipush 299
    //   171: if_icmpgt +53 -> 224
    //   174: new 328	com/tencent/beacon/core/network/volley/NetworkResponse
    //   177: dup
    //   178: iload_2
    //   179: aload 6
    //   181: iconst_0
    //   182: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   185: lload_3
    //   186: lsub
    //   187: aload 8
    //   189: invokespecial 331	com/tencent/beacon/core/network/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   192: astore 7
    //   194: aload 7
    //   196: areturn
    //   197: astore 5
    //   199: ldc_w 350
    //   202: aload_1
    //   203: new 352	com/tencent/beacon/core/network/volley/TimeoutError
    //   206: dup
    //   207: invokespecial 353	com/tencent/beacon/core/network/volley/TimeoutError:<init>	()V
    //   210: invokestatic 355	com/tencent/beacon/core/network/volley/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/Request;Lcom/tencent/beacon/core/network/volley/VolleyError;)V
    //   213: goto -209 -> 4
    //   216: iconst_0
    //   217: newarray byte
    //   219: astore 6
    //   221: goto -74 -> 147
    //   224: new 224	java/io/IOException
    //   227: dup
    //   228: invokespecial 356	java/io/IOException:<init>	()V
    //   231: athrow
    //   232: astore 5
    //   234: new 358	java/lang/RuntimeException
    //   237: dup
    //   238: new 360	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 361	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 363
    //   248: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 370	com/tencent/beacon/core/network/volley/Request:getUrl	()Ljava/lang/String;
    //   255: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: aload 5
    //   263: invokespecial 376	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: athrow
    //   267: astore 9
    //   269: aload 6
    //   271: astore 7
    //   273: aload 5
    //   275: astore 6
    //   277: aload 9
    //   279: astore 5
    //   281: aload 6
    //   283: ifnull +232 -> 515
    //   286: aload 6
    //   288: invokevirtual 323	com/tencent/beacon/core/network/volley/HttpResponse:getStatusCode	()I
    //   291: istore_2
    //   292: ldc_w 378
    //   295: iconst_2
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: iload_2
    //   302: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: dup
    //   307: iconst_1
    //   308: aload_1
    //   309: invokevirtual 370	com/tencent/beacon/core/network/volley/Request:getUrl	()Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 381	com/tencent/beacon/core/network/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 7
    //   318: ifnull +180 -> 498
    //   321: new 328	com/tencent/beacon/core/network/volley/NetworkResponse
    //   324: dup
    //   325: iload_2
    //   326: aload 7
    //   328: iconst_0
    //   329: invokestatic 296	android/os/SystemClock:elapsedRealtime	()J
    //   332: lload_3
    //   333: lsub
    //   334: aload 8
    //   336: invokespecial 331	com/tencent/beacon/core/network/volley/NetworkResponse:<init>	(I[BZJLjava/util/List;)V
    //   339: astore 5
    //   341: iload_2
    //   342: sipush 401
    //   345: if_icmpeq +10 -> 355
    //   348: iload_2
    //   349: sipush 403
    //   352: if_icmpne +62 -> 414
    //   355: ldc_w 383
    //   358: aload_1
    //   359: new 385	com/tencent/beacon/core/network/volley/AuthFailureError
    //   362: dup
    //   363: aload 5
    //   365: invokespecial 388	com/tencent/beacon/core/network/volley/AuthFailureError:<init>	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)V
    //   368: invokestatic 355	com/tencent/beacon/core/network/volley/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/Request;Lcom/tencent/beacon/core/network/volley/VolleyError;)V
    //   371: goto -367 -> 4
    //   374: astore 9
    //   376: aconst_null
    //   377: astore 7
    //   379: aload 5
    //   381: astore 6
    //   383: aload 9
    //   385: astore 5
    //   387: goto -106 -> 281
    //   390: astore 9
    //   392: aconst_null
    //   393: astore 7
    //   395: aload 5
    //   397: astore 6
    //   399: aload 9
    //   401: astore 5
    //   403: goto -122 -> 281
    //   406: astore 5
    //   408: aconst_null
    //   409: astore 7
    //   411: goto -130 -> 281
    //   414: iload_2
    //   415: sipush 400
    //   418: if_icmplt +10 -> 428
    //   421: iload_2
    //   422: sipush 499
    //   425: if_icmple +43 -> 468
    //   428: iload_2
    //   429: sipush 500
    //   432: if_icmplt +56 -> 488
    //   435: iload_2
    //   436: sipush 599
    //   439: if_icmpgt +49 -> 488
    //   442: aload_1
    //   443: invokevirtual 391	com/tencent/beacon/core/network/volley/Request:shouldRetryServerErrors	()Z
    //   446: ifeq +32 -> 478
    //   449: ldc_w 393
    //   452: aload_1
    //   453: new 265	com/tencent/beacon/core/network/volley/ServerError
    //   456: dup
    //   457: aload 5
    //   459: invokespecial 394	com/tencent/beacon/core/network/volley/ServerError:<init>	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)V
    //   462: invokestatic 355	com/tencent/beacon/core/network/volley/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/Request;Lcom/tencent/beacon/core/network/volley/VolleyError;)V
    //   465: goto -461 -> 4
    //   468: new 396	com/tencent/beacon/core/network/volley/ClientError
    //   471: dup
    //   472: aload 5
    //   474: invokespecial 397	com/tencent/beacon/core/network/volley/ClientError:<init>	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)V
    //   477: athrow
    //   478: new 265	com/tencent/beacon/core/network/volley/ServerError
    //   481: dup
    //   482: aload 5
    //   484: invokespecial 394	com/tencent/beacon/core/network/volley/ServerError:<init>	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)V
    //   487: athrow
    //   488: new 265	com/tencent/beacon/core/network/volley/ServerError
    //   491: dup
    //   492: aload 5
    //   494: invokespecial 394	com/tencent/beacon/core/network/volley/ServerError:<init>	(Lcom/tencent/beacon/core/network/volley/NetworkResponse;)V
    //   497: athrow
    //   498: ldc_w 399
    //   501: aload_1
    //   502: new 401	com/tencent/beacon/core/network/volley/NetworkError
    //   505: dup
    //   506: invokespecial 402	com/tencent/beacon/core/network/volley/NetworkError:<init>	()V
    //   509: invokestatic 355	com/tencent/beacon/core/network/volley/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/Request;Lcom/tencent/beacon/core/network/volley/VolleyError;)V
    //   512: goto -508 -> 4
    //   515: new 404	com/tencent/beacon/core/network/volley/NoConnectionError
    //   518: dup
    //   519: aload 5
    //   521: invokespecial 407	com/tencent/beacon/core/network/volley/NoConnectionError:<init>	(Ljava/lang/Throwable;)V
    //   524: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	BasicNetwork
    //   0	525	1	paramRequest	Request<?>
    //   39	401	2	i	int
    //   3	330	3	l	long
    //   20	118	5	localObject1	Object
    //   197	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   232	42	5	localMalformedURLException	java.net.MalformedURLException
    //   279	123	5	localObject2	Object
    //   406	114	5	localIOException1	java.io.IOException
    //   5	393	6	localObject3	Object
    //   96	314	7	localObject4	Object
    //   10	325	8	localObject5	Object
    //   267	11	9	localIOException2	java.io.IOException
    //   374	10	9	localIOException3	java.io.IOException
    //   390	10	9	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   12	34	197	java/net/SocketTimeoutException
    //   34	47	197	java/net/SocketTimeoutException
    //   58	64	197	java/net/SocketTimeoutException
    //   69	89	197	java/net/SocketTimeoutException
    //   89	122	197	java/net/SocketTimeoutException
    //   122	129	197	java/net/SocketTimeoutException
    //   134	147	197	java/net/SocketTimeoutException
    //   147	160	197	java/net/SocketTimeoutException
    //   174	194	197	java/net/SocketTimeoutException
    //   216	221	197	java/net/SocketTimeoutException
    //   224	232	197	java/net/SocketTimeoutException
    //   12	34	232	java/net/MalformedURLException
    //   34	47	232	java/net/MalformedURLException
    //   58	64	232	java/net/MalformedURLException
    //   69	89	232	java/net/MalformedURLException
    //   89	122	232	java/net/MalformedURLException
    //   122	129	232	java/net/MalformedURLException
    //   134	147	232	java/net/MalformedURLException
    //   147	160	232	java/net/MalformedURLException
    //   174	194	232	java/net/MalformedURLException
    //   216	221	232	java/net/MalformedURLException
    //   224	232	232	java/net/MalformedURLException
    //   147	160	267	java/io/IOException
    //   174	194	267	java/io/IOException
    //   224	232	267	java/io/IOException
    //   58	64	374	java/io/IOException
    //   69	89	374	java/io/IOException
    //   89	122	374	java/io/IOException
    //   122	129	374	java/io/IOException
    //   134	147	374	java/io/IOException
    //   216	221	374	java/io/IOException
    //   34	47	390	java/io/IOException
    //   12	34	406	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.BasicNetwork
 * JD-Core Version:    0.7.0.1
 */