package com.squareup.okhttp.internal.http;

import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

abstract class Http1xStream$AbstractSource
  implements Source
{
  protected boolean closed;
  protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.access$600(this.this$0).timeout());
  
  private Http1xStream$AbstractSource(Http1xStream paramHttp1xStream) {}
  
  protected final void endOfInput()
  {
    if (Http1xStream.access$500(this.this$0) != 5) {
      throw new IllegalStateException("state: " + Http1xStream.access$500(this.this$0));
    }
    Http1xStream.access$400(this.this$0, this.timeout);
    Http1xStream.access$502(this.this$0, 6);
    if (Http1xStream.access$700(this.this$0) != null) {
      Http1xStream.access$700(this.this$0).streamFinished(this.this$0);
    }
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  protected final void unexpectedEndOfInput()
  {
    if (Http1xStream.access$500(this.this$0) == 6) {}
    do
    {
      return;
      Http1xStream.access$502(this.this$0, 6);
    } while (Http1xStream.access$700(this.this$0) == null);
    Http1xStream.access$700(this.this$0).noNewStreams();
    Http1xStream.access$700(this.this$0).streamFinished(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.Http1xStream.AbstractSource
 * JD-Core Version:    0.7.0.1
 */