package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.BufferedSource;

class WebSocketReader$1
  extends ResponseBody
{
  WebSocketReader$1(WebSocketReader paramWebSocketReader, MediaType paramMediaType, BufferedSource paramBufferedSource) {}
  
  public long contentLength()
  {
    return -1L;
  }
  
  public MediaType contentType()
  {
    return this.val$type;
  }
  
  public BufferedSource source()
  {
    return this.val$source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketReader.1
 * JD-Core Version:    0.7.0.1
 */