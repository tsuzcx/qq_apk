package com.tencent.crossengine.net;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

class OkHttpNetworkManager$3
  extends RequestBody
{
  OkHttpNetworkManager$3(OkHttpNetworkManager paramOkHttpNetworkManager, RequestBody paramRequestBody, long[] paramArrayOfLong, NetworkManager.Callback paramCallback) {}
  
  public long contentLength()
  {
    return this.a.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.a.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    paramBufferedSink = Okio.buffer(Okio.sink(new OkHttpNetworkManager.3.1(this, paramBufferedSink.outputStream())));
    this.a.writeTo(paramBufferedSink);
    paramBufferedSink.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.3
 * JD-Core Version:    0.7.0.1
 */