package com.tencent.crossengine.net;

import okhttp3.WebSocket;
import okio.ByteString;

class OkHttpNetworkManager$5
  implements NetworkManager.WebSocket
{
  OkHttpNetworkManager$5(OkHttpNetworkManager paramOkHttpNetworkManager, WebSocket paramWebSocket) {}
  
  public void close(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Okhttp3WebSocket.close(paramInt, paramString);
  }
  
  public void sendMessage(String paramString)
  {
    this.jdField_a_of_type_Okhttp3WebSocket.send(paramString);
  }
  
  public void sendMessage(byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_Okhttp3WebSocket.send(ByteString.of(paramArrayOfByte, 0, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.5
 * JD-Core Version:    0.7.0.1
 */