package com.squareup.okhttp.ws;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.RealWebSocket;
import java.net.ProtocolException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import okio.ByteString;

public final class WebSocketCall
{
  private final Call call;
  private final String key;
  private final Random random;
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this(paramOkHttpClient, paramRequest, new SecureRandom());
  }
  
  WebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest, Random paramRandom)
  {
    if (!"GET".equals(paramRequest.method())) {
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    }
    this.random = paramRandom;
    byte[] arrayOfByte = new byte[16];
    paramRandom.nextBytes(arrayOfByte);
    this.key = ByteString.of(arrayOfByte).base64();
    paramOkHttpClient = paramOkHttpClient.clone();
    paramOkHttpClient.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    this.call = paramOkHttpClient.newCall(paramRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build());
  }
  
  public static WebSocketCall create(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return new WebSocketCall(paramOkHttpClient, paramRequest);
  }
  
  private void createWebSocket(Response paramResponse, WebSocketListener paramWebSocketListener)
  {
    if (paramResponse.code() != 101)
    {
      Util.closeQuietly(paramResponse.body());
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    }
    Object localObject = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase((String)localObject)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + (String)localObject + "'");
    }
    localObject = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase((String)localObject)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + (String)localObject + "'");
    }
    localObject = paramResponse.header("Sec-WebSocket-Accept");
    String str = Util.shaBase64(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    if (!str.equals(localObject)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + (String)localObject + "'");
    }
    localObject = WebSocketCall.StreamWebSocket.create(Internal.instance.callEngineGetStreamAllocation(this.call), paramResponse, this.random, paramWebSocketListener);
    paramWebSocketListener.onOpen((WebSocket)localObject, paramResponse);
    while (((RealWebSocket)localObject).readMessage()) {}
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  public void enqueue(WebSocketListener paramWebSocketListener)
  {
    paramWebSocketListener = new WebSocketCall.1(this, paramWebSocketListener);
    Internal.instance.callEnqueue(this.call, paramWebSocketListener, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ws.WebSocketCall
 * JD-Core Version:    0.7.0.1
 */