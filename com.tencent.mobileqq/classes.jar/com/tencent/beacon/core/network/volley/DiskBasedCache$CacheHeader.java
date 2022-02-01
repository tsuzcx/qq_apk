package com.tencent.beacon.core.network.volley;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

class DiskBasedCache$CacheHeader
{
  final List<Header> allResponseHeaders;
  final String etag;
  final String key;
  final long lastModified;
  final long serverDate;
  long size;
  final long softTtl;
  final long ttl;
  
  DiskBasedCache$CacheHeader(String paramString, Cache.Entry paramEntry)
  {
    this(paramString, paramEntry.etag, paramEntry.serverDate, paramEntry.lastModified, paramEntry.ttl, paramEntry.softTtl, getAllResponseHeaders(paramEntry));
  }
  
  private DiskBasedCache$CacheHeader(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<Header> paramList)
  {
    this.key = paramString1;
    paramString1 = paramString2;
    if ("".equals(paramString2)) {
      paramString1 = null;
    }
    this.etag = paramString1;
    this.serverDate = paramLong1;
    this.lastModified = paramLong2;
    this.ttl = paramLong3;
    this.softTtl = paramLong4;
    this.allResponseHeaders = paramList;
  }
  
  private static List<Header> getAllResponseHeaders(Cache.Entry paramEntry)
  {
    List localList = paramEntry.allResponseHeaders;
    if (localList != null) {
      return localList;
    }
    return HttpHeaderParser.toAllHeaderList(paramEntry.responseHeaders);
  }
  
  static CacheHeader readHeader(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    if (DiskBasedCache.readInt(paramCountingInputStream) == 538247942) {
      return new CacheHeader(DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readHeaderList(paramCountingInputStream));
    }
    throw new IOException();
  }
  
  Cache.Entry toCacheEntry(byte[] paramArrayOfByte)
  {
    Cache.Entry localEntry = new Cache.Entry();
    localEntry.data = paramArrayOfByte;
    localEntry.etag = this.etag;
    localEntry.serverDate = this.serverDate;
    localEntry.lastModified = this.lastModified;
    localEntry.ttl = this.ttl;
    localEntry.softTtl = this.softTtl;
    localEntry.responseHeaders = HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
    localEntry.allResponseHeaders = Collections.unmodifiableList(this.allResponseHeaders);
    return localEntry;
  }
  
  boolean writeHeader(OutputStream paramOutputStream)
  {
    try
    {
      DiskBasedCache.writeInt(paramOutputStream, 538247942);
      DiskBasedCache.writeString(paramOutputStream, this.key);
      String str = this.etag;
      if (str == null) {}
      for (str = "";; str = this.etag)
      {
        DiskBasedCache.writeString(paramOutputStream, str);
        DiskBasedCache.writeLong(paramOutputStream, this.serverDate);
        DiskBasedCache.writeLong(paramOutputStream, this.lastModified);
        DiskBasedCache.writeLong(paramOutputStream, this.ttl);
        DiskBasedCache.writeLong(paramOutputStream, this.softTtl);
        DiskBasedCache.writeHeaderList(this.allResponseHeaders, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      return false;
    }
    catch (IOException paramOutputStream)
    {
      VolleyLog.d("%s", new Object[] { paramOutputStream.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.DiskBasedCache.CacheHeader
 * JD-Core Version:    0.7.0.1
 */