package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import okio.BufferedSource;

public final class Cache
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new Cache.1(this);
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  private int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  /* Error */
  private com.squareup.okhttp.internal.http.CacheRequest put(Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 109	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   4: invokevirtual 115	com/squareup/okhttp/Request:method	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 109	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   12: invokevirtual 115	com/squareup/okhttp/Request:method	()Ljava/lang/String;
    //   15: invokestatic 121	com/squareup/okhttp/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 109	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   26: invokespecial 73	com/squareup/okhttp/Cache:remove	(Lcom/squareup/okhttp/Request;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 123
    //   34: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 135	com/squareup/okhttp/internal/http/OkHeaders:hasVaryAll	(Lcom/squareup/okhttp/Response;)Z
    //   44: ifne -15 -> 29
    //   47: new 137	com/squareup/okhttp/Cache$Entry
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 140	com/squareup/okhttp/Cache$Entry:<init>	(Lcom/squareup/okhttp/Response;)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 52	com/squareup/okhttp/Cache:cache	Lcom/squareup/okhttp/internal/DiskLruCache;
    //   60: aload_1
    //   61: invokevirtual 109	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   64: invokestatic 144	com/squareup/okhttp/Cache:urlToKey	(Lcom/squareup/okhttp/Request;)Ljava/lang/String;
    //   67: invokevirtual 148	com/squareup/okhttp/internal/DiskLruCache:edit	(Ljava/lang/String;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull -43 -> 29
    //   75: aload_2
    //   76: aload_1
    //   77: invokevirtual 151	com/squareup/okhttp/Cache$Entry:writeTo	(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   80: new 153	com/squareup/okhttp/Cache$CacheRequestImpl
    //   83: dup
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 156	com/squareup/okhttp/Cache$CacheRequestImpl:<init>	(Lcom/squareup/okhttp/Cache;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   89: astore_2
    //   90: aload_2
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 158	com/squareup/okhttp/Cache:abortQuietly	(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_2
    //   103: goto -8 -> 95
    //   106: astore_1
    //   107: aconst_null
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	Cache
    //   0	109	1	paramResponse	Response
    //   7	84	2	localObject	Object
    //   102	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   56	71	92	java/io/IOException
    //   75	90	102	java/io/IOException
    //   21	29	106	java/io/IOException
  }
  
  private static int readInt(BufferedSource paramBufferedSource)
  {
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty())) {
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
      }
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
  }
  
  private void remove(Request paramRequest)
  {
    this.cache.remove(urlToKey(paramRequest));
  }
  
  private void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void trackResponse(com.squareup.okhttp.internal.http.CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 204	com/squareup/okhttp/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 204	com/squareup/okhttp/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 210	com/squareup/okhttp/internal/http/CacheStrategy:networkRequest	Lcom/squareup/okhttp/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 212	com/squareup/okhttp/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 212	com/squareup/okhttp/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 216	com/squareup/okhttp/internal/http/CacheStrategy:cacheResponse	Lcom/squareup/okhttp/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 202	com/squareup/okhttp/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 202	com/squareup/okhttp/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	com.squareup.okhttp.internal.http.CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  private void update(Response paramResponse1, Response paramResponse2)
  {
    Cache.Entry localEntry = new Cache.Entry(paramResponse2);
    paramResponse2 = Cache.CacheResponseBody.access$500((Cache.CacheResponseBody)paramResponse1.body());
    paramResponse1 = null;
    try
    {
      paramResponse2 = paramResponse2.edit();
      if (paramResponse2 != null)
      {
        paramResponse1 = paramResponse2;
        localEntry.writeTo(paramResponse2);
        paramResponse1 = paramResponse2;
        paramResponse2.commit();
      }
      return;
    }
    catch (IOException paramResponse2)
    {
      abortQuietly(paramResponse1);
    }
  }
  
  private static String urlToKey(Request paramRequest)
  {
    return Util.md5Hex(paramRequest.urlString());
  }
  
  public void close()
  {
    this.cache.close();
  }
  
  public void delete()
  {
    this.cache.delete();
  }
  
  public void evictAll()
  {
    this.cache.evictAll();
  }
  
  public void flush()
  {
    this.cache.flush();
  }
  
  Response get(Request paramRequest)
  {
    Object localObject = urlToKey(paramRequest);
    try
    {
      localObject = this.cache.get((String)localObject);
      if (localObject == null) {
        return null;
      }
      try
      {
        Cache.Entry localEntry = new Cache.Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        localObject = localEntry.response(paramRequest, (DiskLruCache.Snapshot)localObject);
        if (!localEntry.matches(paramRequest, (Response)localObject))
        {
          Util.closeQuietly(((Response)localObject).body());
          return null;
        }
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject);
        return null;
      }
      return localObject;
    }
    catch (IOException paramRequest) {}
    return null;
  }
  
  public File getDirectory()
  {
    return this.cache.getDirectory();
  }
  
  public int getHitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getMaxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int getNetworkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRequestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getSize()
  {
    return this.cache.size();
  }
  
  public int getWriteAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getWriteSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void initialize()
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public Iterator<String> urls()
  {
    return new Cache.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Cache
 * JD-Core Version:    0.7.0.1
 */