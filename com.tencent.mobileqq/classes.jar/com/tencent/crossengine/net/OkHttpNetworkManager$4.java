package com.tencent.crossengine.net;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class OkHttpNetworkManager$4
  extends WebSocketListener
{
  OkHttpNetworkManager$4(OkHttpNetworkManager paramOkHttpNetworkManager, NetworkManager.WebSocketDelegate paramWebSocketDelegate) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    this.a.onClose(paramInt, paramString);
  }
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    this.a.onError(paramThrowable.getMessage());
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.a.onMessage(paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.a.onMessage(paramByteString.toByteArray(), paramByteString.size());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.a.onOpen(OkHttpNetworkManager.a(this.b, paramResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.4
 * JD-Core Version:    0.7.0.1
 */