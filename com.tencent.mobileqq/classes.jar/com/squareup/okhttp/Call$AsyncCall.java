package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;

final class Call$AsyncCall
  extends NamedRunnable
{
  private final boolean forWebSocket;
  private final Callback responseCallback;
  
  private Call$AsyncCall(Call paramCall, Callback paramCallback, boolean paramBoolean)
  {
    super("OkHttp %s", new Object[] { paramCall.originalRequest.urlString() });
    this.responseCallback = paramCallback;
    this.forWebSocket = paramBoolean;
  }
  
  void cancel()
  {
    this.this$0.cancel();
  }
  
  /* Error */
  public void execute()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   6: aload_0
    //   7: getfield 37	com/squareup/okhttp/Call$AsyncCall:forWebSocket	Z
    //   10: invokestatic 52	com/squareup/okhttp/Call:access$100	(Lcom/squareup/okhttp/Call;Z)Lcom/squareup/okhttp/Response;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   18: getfield 55	com/squareup/okhttp/Call:canceled	Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +43 -> 66
    //   26: aload_0
    //   27: getfield 35	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
    //   30: aload_0
    //   31: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   34: getfield 24	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
    //   37: new 48	java/io/IOException
    //   40: dup
    //   41: ldc 57
    //   43: invokespecial 60	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   46: invokeinterface 66 3 0
    //   51: aload_0
    //   52: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   55: invokestatic 70	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
    //   58: invokevirtual 76	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
    //   61: aload_0
    //   62: invokevirtual 82	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
    //   65: return
    //   66: aload_0
    //   67: getfield 35	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
    //   70: aload_3
    //   71: invokeinterface 86 2 0
    //   76: goto -25 -> 51
    //   79: astore_3
    //   80: iload_1
    //   81: ifeq +53 -> 134
    //   84: getstatic 92	com/squareup/okhttp/internal/Internal:logger	Ljava/util/logging/Logger;
    //   87: getstatic 98	java/util/logging/Level:INFO	Ljava/util/logging/Level;
    //   90: new 100	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   97: ldc 104
    //   99: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   106: invokestatic 112	com/squareup/okhttp/Call:access$200	(Lcom/squareup/okhttp/Call;)Ljava/lang/String;
    //   109: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aload_3
    //   116: invokevirtual 121	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   123: invokestatic 70	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
    //   126: invokevirtual 76	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
    //   129: aload_0
    //   130: invokevirtual 82	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
    //   133: return
    //   134: aload_0
    //   135: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   138: getfield 125	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   141: ifnonnull +44 -> 185
    //   144: aload_0
    //   145: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   148: getfield 24	com/squareup/okhttp/Call:originalRequest	Lcom/squareup/okhttp/Request;
    //   151: astore 4
    //   153: aload_0
    //   154: getfield 35	com/squareup/okhttp/Call$AsyncCall:responseCallback	Lcom/squareup/okhttp/Callback;
    //   157: aload 4
    //   159: aload_3
    //   160: invokeinterface 66 3 0
    //   165: goto -46 -> 119
    //   168: astore_3
    //   169: aload_0
    //   170: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   173: invokestatic 70	com/squareup/okhttp/Call:access$300	(Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
    //   176: invokevirtual 76	com/squareup/okhttp/OkHttpClient:getDispatcher	()Lcom/squareup/okhttp/Dispatcher;
    //   179: aload_0
    //   180: invokevirtual 82	com/squareup/okhttp/Dispatcher:finished	(Lcom/squareup/okhttp/Call$AsyncCall;)V
    //   183: aload_3
    //   184: athrow
    //   185: aload_0
    //   186: getfield 14	com/squareup/okhttp/Call$AsyncCall:this$0	Lcom/squareup/okhttp/Call;
    //   189: getfield 125	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   192: invokevirtual 131	com/squareup/okhttp/internal/http/HttpEngine:getRequest	()Lcom/squareup/okhttp/Request;
    //   195: astore 4
    //   197: goto -44 -> 153
    //   200: astore_3
    //   201: iconst_0
    //   202: istore_1
    //   203: goto -123 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	AsyncCall
    //   1	202	1	i	int
    //   21	2	2	bool	boolean
    //   13	58	3	localResponse	Response
    //   79	81	3	localIOException1	java.io.IOException
    //   168	16	3	localObject	Object
    //   200	1	3	localIOException2	java.io.IOException
    //   151	45	4	localRequest	Request
    // Exception table:
    //   from	to	target	type
    //   26	51	79	java/io/IOException
    //   66	76	79	java/io/IOException
    //   2	22	168	finally
    //   26	51	168	finally
    //   66	76	168	finally
    //   84	119	168	finally
    //   134	153	168	finally
    //   153	165	168	finally
    //   185	197	168	finally
    //   2	22	200	java/io/IOException
  }
  
  Call get()
  {
    return this.this$0;
  }
  
  String host()
  {
    return this.this$0.originalRequest.httpUrl().host();
  }
  
  Request request()
  {
    return this.this$0.originalRequest;
  }
  
  Object tag()
  {
    return this.this$0.originalRequest.tag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Call.AsyncCall
 * JD-Core Version:    0.7.0.1
 */