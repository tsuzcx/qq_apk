package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import okio.BufferedSource;
import okio.Okio;

class Cache$CacheResponseBody
  extends ResponseBody
{
  private final BufferedSource bodySource;
  private final String contentLength;
  private final String contentType;
  private final DiskLruCache.Snapshot snapshot;
  
  public Cache$CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
  {
    this.snapshot = paramSnapshot;
    this.contentType = paramString1;
    this.contentLength = paramString2;
    this.bodySource = Okio.buffer(new Cache.CacheResponseBody.1(this, paramSnapshot.getSource(1), paramSnapshot));
  }
  
  public long contentLength()
  {
    long l = -1L;
    try
    {
      if (this.contentLength != null) {
        l = Long.parseLong(this.contentLength);
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1L;
  }
  
  public MediaType contentType()
  {
    if (this.contentType != null) {
      return MediaType.parse(this.contentType);
    }
    return null;
  }
  
  public BufferedSource source()
  {
    return this.bodySource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Cache.CacheResponseBody
 * JD-Core Version:    0.7.0.1
 */