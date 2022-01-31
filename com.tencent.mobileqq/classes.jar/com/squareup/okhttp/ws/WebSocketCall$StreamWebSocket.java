package com.squareup.okhttp.ws;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WebSocketCall$StreamWebSocket
  extends RealWebSocket
{
  private final ExecutorService replyExecutor;
  private final StreamAllocation streamAllocation;
  
  private WebSocketCall$StreamWebSocket(StreamAllocation paramStreamAllocation, Random paramRandom, ExecutorService paramExecutorService, WebSocketListener paramWebSocketListener, String paramString)
  {
    super(true, paramStreamAllocation.connection().source, paramStreamAllocation.connection().sink, paramRandom, paramExecutorService, paramWebSocketListener, paramString);
    this.streamAllocation = paramStreamAllocation;
    this.replyExecutor = paramExecutorService;
  }
  
  static RealWebSocket create(StreamAllocation paramStreamAllocation, Response paramResponse, Random paramRandom, WebSocketListener paramWebSocketListener)
  {
    paramResponse = paramResponse.request().urlString();
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), Util.threadFactory(String.format("OkHttp %s WebSocket", new Object[] { paramResponse }), true));
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    return new StreamWebSocket(paramStreamAllocation, paramRandom, localThreadPoolExecutor, paramWebSocketListener, paramResponse);
  }
  
  public void close()
  {
    this.replyExecutor.shutdown();
    this.streamAllocation.noNewStreams();
    this.streamAllocation.streamFinished(this.streamAllocation.stream());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ws.WebSocketCall.StreamWebSocket
 * JD-Core Version:    0.7.0.1
 */