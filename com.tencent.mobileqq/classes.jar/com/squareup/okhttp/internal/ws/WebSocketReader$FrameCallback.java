package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ResponseBody;
import okio.Buffer;

public abstract interface WebSocketReader$FrameCallback
{
  public abstract void onClose(int paramInt, String paramString);
  
  public abstract void onMessage(ResponseBody paramResponseBody);
  
  public abstract void onPing(Buffer paramBuffer);
  
  public abstract void onPong(Buffer paramBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback
 * JD-Core Version:    0.7.0.1
 */