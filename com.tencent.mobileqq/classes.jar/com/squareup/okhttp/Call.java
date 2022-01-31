package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;

public class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
  {
    return new Call.ApplicationInterceptorChain(this, 0, this.originalRequest, paramBoolean).proceed(this.originalRequest);
  }
  
  private String toLoggableString()
  {
    if (this.canceled) {}
    for (String str = "canceled call";; str = "call")
    {
      HttpUrl localHttpUrl = this.originalRequest.httpUrl().resolve("/...");
      return str + " to " + localHttpUrl;
    }
  }
  
  public void cancel()
  {
    this.canceled = true;
    if (this.engine != null) {
      this.engine.cancel();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    this.client.getDispatcher().enqueue(new Call.AsyncCall(this, paramCallback, paramBoolean, null));
  }
  
  public Response execute()
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    try
    {
      this.client.getDispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain(false);
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      this.client.getDispatcher().finished(this);
    }
    this.client.getDispatcher().finished(this);
    return localResponse2;
  }
  
  /* Error */
  Response getResponse(Request paramRequest, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 147	com/squareup/okhttp/Request:body	()Lcom/squareup/okhttp/RequestBody;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +382 -> 390
    //   11: aload_1
    //   12: invokevirtual 151	com/squareup/okhttp/Request:newBuilder	()Lcom/squareup/okhttp/Request$Builder;
    //   15: astore_1
    //   16: aload 6
    //   18: invokevirtual 157	com/squareup/okhttp/RequestBody:contentType	()Lcom/squareup/okhttp/MediaType;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnull +15 -> 40
    //   28: aload_1
    //   29: ldc 159
    //   31: aload 7
    //   33: invokevirtual 162	com/squareup/okhttp/MediaType:toString	()Ljava/lang/String;
    //   36: invokevirtual 168	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   39: pop
    //   40: aload 6
    //   42: invokevirtual 172	com/squareup/okhttp/RequestBody:contentLength	()J
    //   45: lstore 4
    //   47: lload 4
    //   49: ldc2_w 173
    //   52: lcmp
    //   53: ifeq +75 -> 128
    //   56: aload_1
    //   57: ldc 176
    //   59: lload 4
    //   61: invokestatic 181	java/lang/Long:toString	(J)Ljava/lang/String;
    //   64: invokevirtual 168	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   67: pop
    //   68: aload_1
    //   69: ldc 183
    //   71: invokevirtual 187	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 191	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   79: astore_1
    //   80: aload_0
    //   81: new 94	com/squareup/okhttp/internal/http/HttpEngine
    //   84: dup
    //   85: aload_0
    //   86: getfield 26	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   89: aload_1
    //   90: iconst_0
    //   91: iconst_0
    //   92: iload_2
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokespecial 194	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   99: putfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   102: iconst_0
    //   103: istore_3
    //   104: aload_0
    //   105: getfield 56	com/squareup/okhttp/Call:canceled	Z
    //   108: ifeq +39 -> 147
    //   111: aload_0
    //   112: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   115: invokevirtual 197	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   118: new 131	java/io/IOException
    //   121: dup
    //   122: ldc 133
    //   124: invokespecial 134	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload_1
    //   129: ldc 183
    //   131: ldc 199
    //   133: invokevirtual 168	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   136: pop
    //   137: aload_1
    //   138: ldc 176
    //   140: invokevirtual 187	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   143: pop
    //   144: goto -69 -> 75
    //   147: aload_0
    //   148: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   151: invokevirtual 202	com/squareup/okhttp/internal/http/HttpEngine:sendRequest	()V
    //   154: aload_0
    //   155: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   158: invokevirtual 205	com/squareup/okhttp/internal/http/HttpEngine:readResponse	()V
    //   161: aload_0
    //   162: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   165: invokevirtual 207	com/squareup/okhttp/internal/http/HttpEngine:getResponse	()Lcom/squareup/okhttp/Response;
    //   168: astore 7
    //   170: aload_0
    //   171: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   174: invokevirtual 210	com/squareup/okhttp/internal/http/HttpEngine:followUpRequest	()Lcom/squareup/okhttp/Request;
    //   177: astore 8
    //   179: aload 8
    //   181: ifnonnull +106 -> 287
    //   184: iload_2
    //   185: ifne +10 -> 195
    //   188: aload_0
    //   189: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   192: invokevirtual 197	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   195: aload 7
    //   197: areturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 214	com/squareup/okhttp/internal/http/RequestException:getCause	()Ljava/io/IOException;
    //   203: athrow
    //   204: astore_1
    //   205: iconst_1
    //   206: istore_3
    //   207: iload_3
    //   208: ifeq +13 -> 221
    //   211: aload_0
    //   212: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   215: invokevirtual 218	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   218: invokevirtual 223	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   228: aload_1
    //   229: invokevirtual 227	com/squareup/okhttp/internal/http/HttpEngine:recover	(Lcom/squareup/okhttp/internal/http/RouteException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   232: astore 6
    //   234: aload 6
    //   236: ifnull +18 -> 254
    //   239: aload_0
    //   240: aload 6
    //   242: putfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   245: goto -141 -> 104
    //   248: iconst_0
    //   249: istore_3
    //   250: astore_1
    //   251: goto -44 -> 207
    //   254: aload_1
    //   255: invokevirtual 230	com/squareup/okhttp/internal/http/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   258: athrow
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   264: aload_1
    //   265: aconst_null
    //   266: invokevirtual 233	com/squareup/okhttp/internal/http/HttpEngine:recover	(Ljava/io/IOException;Lokio/Sink;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   269: astore 6
    //   271: aload 6
    //   273: ifnull +12 -> 285
    //   276: aload_0
    //   277: aload 6
    //   279: putfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   282: goto -178 -> 104
    //   285: aload_1
    //   286: athrow
    //   287: aload_0
    //   288: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   291: invokevirtual 218	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   294: astore 6
    //   296: iload_3
    //   297: iconst_1
    //   298: iadd
    //   299: istore_3
    //   300: iload_3
    //   301: bipush 20
    //   303: if_icmple +35 -> 338
    //   306: aload 6
    //   308: invokevirtual 223	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   311: new 235	java/net/ProtocolException
    //   314: dup
    //   315: new 74	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   322: ldc 237
    //   324: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_3
    //   328: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 241	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   337: athrow
    //   338: aload 6
    //   340: astore_1
    //   341: aload_0
    //   342: getfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   345: aload 8
    //   347: invokevirtual 64	com/squareup/okhttp/Request:httpUrl	()Lcom/squareup/okhttp/HttpUrl;
    //   350: invokevirtual 245	com/squareup/okhttp/internal/http/HttpEngine:sameConnection	(Lcom/squareup/okhttp/HttpUrl;)Z
    //   353: ifne +10 -> 363
    //   356: aload 6
    //   358: invokevirtual 223	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   361: aconst_null
    //   362: astore_1
    //   363: aload_0
    //   364: new 94	com/squareup/okhttp/internal/http/HttpEngine
    //   367: dup
    //   368: aload_0
    //   369: getfield 26	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   372: aload 8
    //   374: iconst_0
    //   375: iconst_0
    //   376: iload_2
    //   377: aload_1
    //   378: aconst_null
    //   379: aload 7
    //   381: invokespecial 194	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   384: putfield 92	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   387: goto -283 -> 104
    //   390: goto -310 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	Call
    //   0	393	1	paramRequest	Request
    //   0	393	2	paramBoolean	boolean
    //   103	225	3	i	int
    //   45	15	4	l	long
    //   4	353	6	localObject1	Object
    //   21	359	7	localObject2	Object
    //   177	196	8	localRequest	Request
    // Exception table:
    //   from	to	target	type
    //   147	161	198	com/squareup/okhttp/internal/http/RequestException
    //   147	161	204	finally
    //   199	204	204	finally
    //   224	234	204	finally
    //   254	259	204	finally
    //   260	271	204	finally
    //   285	287	204	finally
    //   147	161	223	com/squareup/okhttp/internal/http/RouteException
    //   239	245	248	finally
    //   276	282	248	finally
    //   147	161	259	java/io/IOException
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  Object tag()
  {
    return this.originalRequest.tag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Call
 * JD-Core Version:    0.7.0.1
 */