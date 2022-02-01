package com.tencent.component.network.module.common;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody
  extends ResponseBody
{
  private BufferedSource bufferedSource;
  private final ProgressResponseBody.ProgressListener progressListener;
  private final ResponseBody responseBody;
  
  public ProgressResponseBody(ResponseBody paramResponseBody, ProgressResponseBody.ProgressListener paramProgressListener)
  {
    this.responseBody = paramResponseBody;
    this.progressListener = paramProgressListener;
  }
  
  private Source source(Source paramSource)
  {
    return new ProgressResponseBody.1(this, paramSource);
  }
  
  public long contentLength()
  {
    return this.responseBody.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.responseBody.contentType();
  }
  
  public BufferedSource source()
  {
    if (this.bufferedSource == null) {
      this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
    }
    return this.bufferedSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.ProgressResponseBody
 * JD-Core Version:    0.7.0.1
 */