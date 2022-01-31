package com.squareup.okhttp;

import okio.BufferedSource;

final class ResponseBody$1
  extends ResponseBody
{
  ResponseBody$1(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource) {}
  
  public long contentLength()
  {
    return this.val$contentLength;
  }
  
  public MediaType contentType()
  {
    return this.val$contentType;
  }
  
  public BufferedSource source()
  {
    return this.val$content;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ResponseBody.1
 * JD-Core Version:    0.7.0.1
 */