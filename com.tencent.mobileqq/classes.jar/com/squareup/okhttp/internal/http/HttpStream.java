package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import okio.Sink;

public abstract interface HttpStream
{
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
  
  public abstract void cancel();
  
  public abstract Sink createRequestBody(Request paramRequest, long paramLong);
  
  public abstract void finishRequest();
  
  public abstract ResponseBody openResponseBody(Response paramResponse);
  
  public abstract Response.Builder readResponseHeaders();
  
  public abstract void setHttpEngine(HttpEngine paramHttpEngine);
  
  public abstract void writeRequestBody(RetryableSink paramRetryableSink);
  
  public abstract void writeRequestHeaders(Request paramRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpStream
 * JD-Core Version:    0.7.0.1
 */