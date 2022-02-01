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
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$WebSocketDelegate.onClose(paramInt, paramString);
  }
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$WebSocketDelegate.onError(paramThrowable.getMessage());
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$WebSocketDelegate.onMessage(paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$WebSocketDelegate.onMessage(paramByteString.toByteArray(), paramByteString.size());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.jdField_a_of_type_ComTencentCrossengineNetNetworkManager$WebSocketDelegate.onOpen(OkHttpNetworkManager.a(this.jdField_a_of_type_ComTencentCrossengineNetOkHttpNetworkManager, paramResponse));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.4
 * JD-Core Version:    0.7.0.1
 */