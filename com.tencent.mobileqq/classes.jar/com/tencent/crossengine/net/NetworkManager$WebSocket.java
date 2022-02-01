package com.tencent.crossengine.net;

import androidx.annotation.Keep;

@Keep
public abstract interface NetworkManager$WebSocket
{
  public abstract void close(int paramInt, String paramString);
  
  public abstract void sendMessage(String paramString);
  
  public abstract void sendMessage(byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager.WebSocket
 * JD-Core Version:    0.7.0.1
 */