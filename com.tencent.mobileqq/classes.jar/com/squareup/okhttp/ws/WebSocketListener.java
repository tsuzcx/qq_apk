package com.squareup.okhttp.ws;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Buffer;

public abstract interface WebSocketListener
{
  public abstract void onClose(int paramInt, String paramString);
  
  public abstract void onFailure(IOException paramIOException, Response paramResponse);
  
  public abstract void onMessage(ResponseBody paramResponseBody);
  
  public abstract void onOpen(WebSocket paramWebSocket, Response paramResponse);
  
  public abstract void onPong(Buffer paramBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ws.WebSocketListener
 * JD-Core Version:    0.7.0.1
 */