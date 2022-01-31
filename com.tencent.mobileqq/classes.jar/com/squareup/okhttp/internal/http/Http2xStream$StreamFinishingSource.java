package com.squareup.okhttp.internal.http;

import okio.ForwardingSource;
import okio.Source;

class Http2xStream$StreamFinishingSource
  extends ForwardingSource
{
  public Http2xStream$StreamFinishingSource(Http2xStream paramHttp2xStream, Source paramSource)
  {
    super(paramSource);
  }
  
  public void close()
  {
    Http2xStream.access$000(this.this$0).streamFinished(this.this$0);
    super.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http2xStream.StreamFinishingSource
 * JD-Core Version:    0.7.0.1
 */