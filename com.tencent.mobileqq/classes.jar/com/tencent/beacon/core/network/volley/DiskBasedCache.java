package com.tencent.beacon.core.network.volley;

import android.os.SystemClock;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  private static final int CACHE_MAGIC = 538247942;
  private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
  static final float HYSTERESIS_FACTOR = 0.9F;
  private final Map<String, DiskBasedCache.CacheHeader> mEntries = new LinkedHashMap(16, 0.75F, true);
  private final int mMaxCacheSizeInBytes;
  private final DiskBasedCache.FileSupplier mRootDirectorySupplier;
  private long mTotalSize = 0L;
  
  public DiskBasedCache(DiskBasedCache.FileSupplier paramFileSupplier)
  {
    this(paramFileSupplier, 5242880);
  }
  
  public DiskBasedCache(DiskBasedCache.FileSupplier paramFileSupplier, int paramInt)
  {
    this.mRootDirectorySupplier = paramFileSupplier;
    this.mMaxCacheSizeInBytes = paramInt;
  }
  
  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public DiskBasedCache(File paramFile, int paramInt)
  {
    this.mRootDirectorySupplier = new DiskBasedCache.1(this, paramFile);
    this.mMaxCacheSizeInBytes = paramInt;
  }
  
  private String getFilenameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private void initializeIfRootDirectoryDeleted()
  {
    if (!this.mRootDirectorySupplier.get().exists())
    {
      VolleyLog.d("Re-initializing cache after external clearing.", new Object[0]);
      this.mEntries.clear();
      this.mTotalSize = 0L;
      initialize();
    }
  }
  
  private void pruneIfNeeded()
  {
    if (this.mTotalSize < this.mMaxCacheSizeInBytes) {}
    label224:
    label228:
    for (;;)
    {
      return;
      if (VolleyLog.DEBUG) {
        VolleyLog.v("Pruning old cache entries.", new Object[0]);
      }
      long l1 = this.mTotalSize;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.mEntries.entrySet().iterator();
      int i = 0;
      Object localObject;
      if (localIterator.hasNext())
      {
        localObject = (DiskBasedCache.CacheHeader)((Map.Entry)localIterator.next()).getValue();
        if (getFileForKey(((DiskBasedCache.CacheHeader)localObject).key).delete())
        {
          this.mTotalSize -= ((DiskBasedCache.CacheHeader)localObject).size;
          label116:
          localIterator.remove();
          i += 1;
          if ((float)this.mTotalSize >= this.mMaxCacheSizeInBytes * 0.9F) {
            break label224;
          }
        }
      }
      for (;;)
      {
        if (!VolleyLog.DEBUG) {
          break label228;
        }
        VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(this.mTotalSize - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        return;
        localObject = ((DiskBasedCache.CacheHeader)localObject).key;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { localObject, getFilenameForKey((String)localObject) });
        break label116;
        break;
      }
    }
  }
  
  private void putEntry(String paramString, DiskBasedCache.CacheHeader paramCacheHeader)
  {
    if (!this.mEntries.containsKey(paramString)) {}
    DiskBasedCache.CacheHeader localCacheHeader;
    long l;
    for (this.mTotalSize += paramCacheHeader.size;; this.mTotalSize = (paramCacheHeader.size - localCacheHeader.size + l))
    {
      this.mEntries.put(paramString, paramCacheHeader);
      return;
      localCacheHeader = (DiskBasedCache.CacheHeader)this.mEntries.get(paramString);
      l = this.mTotalSize;
    }
  }
  
  private static int read(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return i;
    }
    throw new EOFException();
  }
  
  static List<Header> readHeaderList(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    int j = readInt(paramCountingInputStream);
    Object localObject;
    if (j >= 0)
    {
      if (j == 0) {}
      for (localObject = Collections.emptyList();; localObject = new ArrayList())
      {
        int i = 0;
        while (i < j)
        {
          ((List)localObject).add(new Header(readString(paramCountingInputStream).intern(), readString(paramCountingInputStream).intern()));
          i += 1;
        }
      }
    }
    throw new IOException("readHeaderList size=" + j);
    return localObject;
  }
  
  static int readInt(InputStream paramInputStream)
  {
    return read(paramInputStream) << 0 | 0x0 | read(paramInputStream) << 8 | read(paramInputStream) << 16 | read(paramInputStream) << 24;
  }
  
  static long readLong(InputStream paramInputStream)
  {
    return (read(paramInputStream) & 0xFF) << 0 | 0L | (read(paramInputStream) & 0xFF) << 8 | (read(paramInputStream) & 0xFF) << 16 | (read(paramInputStream) & 0xFF) << 24 | (read(paramInputStream) & 0xFF) << 32 | (read(paramInputStream) & 0xFF) << 40 | (read(paramInputStream) & 0xFF) << 48 | (read(paramInputStream) & 0xFF) << 56;
  }
  
  static String readString(DiskBasedCache.CountingInputStream paramCountingInputStream)
  {
    return new String(streamToBytes(paramCountingInputStream, readLong(paramCountingInputStream)), "UTF-8");
  }
  
  private void removeEntry(String paramString)
  {
    paramString = (DiskBasedCache.CacheHeader)this.mEntries.remove(paramString);
    if (paramString != null) {
      this.mTotalSize -= paramString.size;
    }
  }
  
  static byte[] streamToBytes(DiskBasedCache.CountingInputStream paramCountingInputStream, long paramLong)
  {
    long l = paramCountingInputStream.bytesRemaining();
    if ((paramLong >= 0L) && (paramLong <= l))
    {
      int i = (int)paramLong;
      if (i == paramLong)
      {
        byte[] arrayOfByte = new byte[i];
        new DataInputStream(paramCountingInputStream).readFully(arrayOfByte);
        return arrayOfByte;
      }
    }
    throw new IOException("streamToBytes length=" + paramLong + ", maxLength=" + l);
  }
  
  static void writeHeaderList(List<Header> paramList, OutputStream paramOutputStream)
  {
    if (paramList != null)
    {
      writeInt(paramOutputStream, paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Header localHeader = (Header)paramList.next();
        writeString(paramOutputStream, localHeader.getName());
        writeString(paramOutputStream, localHeader.getValue());
      }
    }
    writeInt(paramOutputStream, 0);
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void writeLong(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void writeString(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    writeLong(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  public void clear()
  {
    int i = 0;
    try
    {
      File[] arrayOfFile = this.mRootDirectorySupplier.get().listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
      this.mEntries.clear();
      this.mTotalSize = 0L;
      VolleyLog.d("Cache cleared.", new Object[0]);
      return;
    }
    finally {}
  }
  
  InputStream createInputStream(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  OutputStream createOutputStream(File paramFile)
  {
    return new FileOutputStream(paramFile);
  }
  
  /* Error */
  public Cache.Entry get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/beacon/core/network/volley/DiskBasedCache:mEntries	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 203 2 0
    //   12: checkcast 157	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 165	com/tencent/beacon/core/network/volley/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   31: astore 4
    //   33: new 277	com/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream
    //   36: dup
    //   37: new 352	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_0
    //   42: aload 4
    //   44: invokevirtual 354	com/tencent/beacon/core/network/volley/DiskBasedCache:createInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   47: invokespecial 355	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: aload 4
    //   52: invokevirtual 357	java/io/File:length	()J
    //   55: invokespecial 360	com/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;J)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokestatic 364	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:readHeader	(Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream;)Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader;
    //   65: astore 6
    //   67: aload_1
    //   68: aload 6
    //   70: getfield 161	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   73: invokestatic 370	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   76: istore_2
    //   77: iload_2
    //   78: ifne +48 -> 126
    //   81: ldc_w 372
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload 4
    //   92: invokevirtual 375	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_1
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: aload 6
    //   104: getfield 161	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 107	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 377	com/tencent/beacon/core/network/volley/DiskBasedCache:removeEntry	(Ljava/lang/String;)V
    //   116: aload 5
    //   118: invokevirtual 382	java/io/FilterInputStream:close	()V
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -101 -> 22
    //   126: aload_3
    //   127: aload 5
    //   129: aload 5
    //   131: invokevirtual 280	com/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream:bytesRemaining	()J
    //   134: invokestatic 267	com/tencent/beacon/core/network/volley/DiskBasedCache:streamToBytes	(Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream;J)[B
    //   137: invokevirtual 386	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:toCacheEntry	([B)Lcom/tencent/beacon/core/network/volley/Cache$Entry;
    //   140: astore_3
    //   141: aload 5
    //   143: invokevirtual 382	java/io/FilterInputStream:close	()V
    //   146: aload_3
    //   147: astore_1
    //   148: goto -126 -> 22
    //   151: astore_3
    //   152: ldc_w 388
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload 4
    //   163: invokevirtual 375	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_3
    //   170: invokevirtual 389	java/io/IOException:toString	()Ljava/lang/String;
    //   173: aastore
    //   174: invokestatic 107	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 391	com/tencent/beacon/core/network/volley/DiskBasedCache:remove	(Ljava/lang/String;)V
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -162 -> 22
    //   187: astore_3
    //   188: aload 5
    //   190: invokevirtual 382	java/io/FilterInputStream:close	()V
    //   193: aload_3
    //   194: athrow
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	DiskBasedCache
    //   0	200	1	paramString	String
    //   76	2	2	bool	boolean
    //   15	132	3	localObject1	Object
    //   151	19	3	localIOException	IOException
    //   187	7	3	localObject2	Object
    //   31	131	4	localFile	File
    //   58	131	5	localCountingInputStream	DiskBasedCache.CountingInputStream
    //   65	38	6	localCacheHeader	DiskBasedCache.CacheHeader
    // Exception table:
    //   from	to	target	type
    //   33	60	151	java/io/IOException
    //   116	121	151	java/io/IOException
    //   141	146	151	java/io/IOException
    //   188	195	151	java/io/IOException
    //   60	77	187	finally
    //   81	116	187	finally
    //   126	141	187	finally
    //   2	16	195	finally
    //   26	33	195	finally
    //   33	60	195	finally
    //   116	121	195	finally
    //   141	146	195	finally
    //   152	182	195	finally
    //   188	195	195	finally
  }
  
  public File getFileForKey(String paramString)
  {
    return new File(this.mRootDirectorySupplier.get(), getFilenameForKey(paramString));
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/beacon/core/network/volley/DiskBasedCache:mRootDirectorySupplier	Lcom/tencent/beacon/core/network/volley/DiskBasedCache$FileSupplier;
    //   6: invokeinterface 93 1 0
    //   11: astore 5
    //   13: aload 5
    //   15: invokevirtual 99	java/io/File:exists	()Z
    //   18: ifne +32 -> 50
    //   21: aload 5
    //   23: invokevirtual 397	java/io/File:mkdirs	()Z
    //   26: ifne +21 -> 47
    //   29: ldc_w 399
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload 5
    //   40: invokevirtual 375	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic 402	com/tencent/beacon/core/network/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload 5
    //   52: invokevirtual 336	java/io/File:listFiles	()[Ljava/io/File;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull -12 -> 47
    //   62: aload 5
    //   64: arraylength
    //   65: istore_2
    //   66: iconst_0
    //   67: istore_1
    //   68: iload_1
    //   69: iload_2
    //   70: if_icmpge -23 -> 47
    //   73: aload 5
    //   75: iload_1
    //   76: aaload
    //   77: astore 6
    //   79: aload 6
    //   81: invokevirtual 357	java/io/File:length	()J
    //   84: lstore_3
    //   85: new 277	com/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream
    //   88: dup
    //   89: new 352	java/io/BufferedInputStream
    //   92: dup
    //   93: aload_0
    //   94: aload 6
    //   96: invokevirtual 354	com/tencent/beacon/core/network/volley/DiskBasedCache:createInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   99: invokespecial 355	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: lload_3
    //   103: invokespecial 360	com/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;J)V
    //   106: astore 7
    //   108: aload 7
    //   110: invokestatic 364	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:readHeader	(Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CountingInputStream;)Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader;
    //   113: astore 8
    //   115: aload 8
    //   117: lload_3
    //   118: putfield 171	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:size	J
    //   121: aload_0
    //   122: aload 8
    //   124: getfield 161	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   127: aload 8
    //   129: invokespecial 404	com/tencent/beacon/core/network/volley/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader;)V
    //   132: aload 7
    //   134: invokevirtual 382	java/io/FilterInputStream:close	()V
    //   137: goto +31 -> 168
    //   140: astore 8
    //   142: aload 7
    //   144: invokevirtual 382	java/io/FilterInputStream:close	()V
    //   147: aload 8
    //   149: athrow
    //   150: astore 7
    //   152: aload 6
    //   154: invokevirtual 168	java/io/File:delete	()Z
    //   157: pop
    //   158: goto +10 -> 168
    //   161: astore 5
    //   163: aload_0
    //   164: monitorexit
    //   165: aload 5
    //   167: athrow
    //   168: iload_1
    //   169: iconst_1
    //   170: iadd
    //   171: istore_1
    //   172: goto -104 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	DiskBasedCache
    //   67	105	1	i	int
    //   65	6	2	j	int
    //   84	34	3	l	long
    //   11	63	5	localObject1	Object
    //   161	5	5	localObject2	Object
    //   77	76	6	localFile	File
    //   106	37	7	localCountingInputStream	DiskBasedCache.CountingInputStream
    //   150	1	7	localIOException	IOException
    //   113	15	8	localCacheHeader	DiskBasedCache.CacheHeader
    //   140	8	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   108	132	140	finally
    //   79	108	150	java/io/IOException
    //   132	137	150	java/io/IOException
    //   142	150	150	java/io/IOException
    //   2	47	161	finally
    //   50	57	161	finally
    //   62	66	161	finally
    //   79	108	161	finally
    //   132	137	161	finally
    //   142	150	161	finally
    //   152	158	161	finally
  }
  
  public void invalidate(String paramString, boolean paramBoolean)
  {
    try
    {
      Cache.Entry localEntry = get(paramString);
      if (localEntry != null)
      {
        localEntry.softTtl = 0L;
        if (paramBoolean) {
          localEntry.ttl = 0L;
        }
        put(paramString, localEntry);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void put(String paramString, Cache.Entry paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/tencent/beacon/core/network/volley/DiskBasedCache:mTotalSize	J
    //   6: lstore 5
    //   8: aload_2
    //   9: getfield 423	com/tencent/beacon/core/network/volley/Cache$Entry:data	[B
    //   12: astore 10
    //   14: aload 10
    //   16: arraylength
    //   17: i2l
    //   18: lstore 7
    //   20: aload_0
    //   21: getfield 45	com/tencent/beacon/core/network/volley/DiskBasedCache:mMaxCacheSizeInBytes	I
    //   24: istore_3
    //   25: lload 5
    //   27: lload 7
    //   29: ladd
    //   30: iload_3
    //   31: i2l
    //   32: lcmp
    //   33: ifle +23 -> 56
    //   36: aload 10
    //   38: arraylength
    //   39: istore 4
    //   41: iload 4
    //   43: i2f
    //   44: iload_3
    //   45: i2f
    //   46: ldc 14
    //   48: fmul
    //   49: fcmpl
    //   50: ifle +6 -> 56
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 165	com/tencent/beacon/core/network/volley/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   61: astore 12
    //   63: new 425	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_0
    //   68: aload 12
    //   70: invokevirtual 427	com/tencent/beacon/core/network/volley/DiskBasedCache:createOutputStream	(Ljava/io/File;)Ljava/io/OutputStream;
    //   73: invokespecial 430	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore 11
    //   78: aload 11
    //   80: astore 10
    //   82: new 157	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader
    //   85: dup
    //   86: aload_1
    //   87: aload_2
    //   88: invokespecial 432	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:<init>	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/Cache$Entry;)V
    //   91: astore 13
    //   93: aload 11
    //   95: astore 10
    //   97: aload 13
    //   99: aload 11
    //   101: invokevirtual 436	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:writeHeader	(Ljava/io/OutputStream;)Z
    //   104: ifeq +64 -> 168
    //   107: aload 11
    //   109: astore 10
    //   111: aload 11
    //   113: aload_2
    //   114: getfield 423	com/tencent/beacon/core/network/volley/Cache$Entry:data	[B
    //   117: invokevirtual 438	java/io/BufferedOutputStream:write	([B)V
    //   120: aload 11
    //   122: astore 10
    //   124: aload 13
    //   126: aload 12
    //   128: invokevirtual 357	java/io/File:length	()J
    //   131: putfield 171	com/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader:size	J
    //   134: aload 11
    //   136: astore 10
    //   138: aload_0
    //   139: aload_1
    //   140: aload 13
    //   142: invokespecial 404	com/tencent/beacon/core/network/volley/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/tencent/beacon/core/network/volley/DiskBasedCache$CacheHeader;)V
    //   145: aload 11
    //   147: astore 10
    //   149: aload_0
    //   150: invokespecial 440	com/tencent/beacon/core/network/volley/DiskBasedCache:pruneIfNeeded	()V
    //   153: aload 11
    //   155: astore_1
    //   156: aload_1
    //   157: invokestatic 446	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   160: goto -107 -> 53
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    //   168: aload 11
    //   170: astore 10
    //   172: aload 11
    //   174: invokevirtual 447	java/io/BufferedOutputStream:close	()V
    //   177: aload 11
    //   179: astore 10
    //   181: ldc_w 449
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload 12
    //   192: invokevirtual 375	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 107	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload 11
    //   201: astore 10
    //   203: new 245	java/io/IOException
    //   206: dup
    //   207: invokespecial 450	java/io/IOException:<init>	()V
    //   210: athrow
    //   211: astore_1
    //   212: aload 11
    //   214: astore_1
    //   215: aload_1
    //   216: astore 10
    //   218: aload 12
    //   220: invokevirtual 168	java/io/File:delete	()Z
    //   223: istore 9
    //   225: iload 9
    //   227: ifne +24 -> 251
    //   230: aload_1
    //   231: astore 10
    //   233: ldc_w 452
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload 12
    //   244: invokevirtual 375	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 107	com/tencent/beacon/core/network/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload_1
    //   252: astore 10
    //   254: aload_0
    //   255: invokespecial 454	com/tencent/beacon/core/network/volley/DiskBasedCache:initializeIfRootDirectoryDeleted	()V
    //   258: goto -102 -> 156
    //   261: astore_1
    //   262: aload 10
    //   264: invokestatic 446	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aconst_null
    //   271: astore 10
    //   273: goto -11 -> 262
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -64 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	DiskBasedCache
    //   0	282	1	paramString	String
    //   0	282	2	paramEntry	Cache.Entry
    //   24	21	3	i	int
    //   39	3	4	j	int
    //   6	20	5	l1	long
    //   18	10	7	l2	long
    //   223	3	9	bool	boolean
    //   12	260	10	localObject	Object
    //   76	137	11	localBufferedOutputStream	java.io.BufferedOutputStream
    //   61	182	12	localFile	File
    //   91	50	13	localCacheHeader	DiskBasedCache.CacheHeader
    // Exception table:
    //   from	to	target	type
    //   2	25	163	finally
    //   36	41	163	finally
    //   56	63	163	finally
    //   156	160	163	finally
    //   262	269	163	finally
    //   82	93	211	java/io/IOException
    //   97	107	211	java/io/IOException
    //   111	120	211	java/io/IOException
    //   124	134	211	java/io/IOException
    //   138	145	211	java/io/IOException
    //   149	153	211	java/io/IOException
    //   172	177	211	java/io/IOException
    //   181	199	211	java/io/IOException
    //   203	211	211	java/io/IOException
    //   82	93	261	finally
    //   97	107	261	finally
    //   111	120	261	finally
    //   124	134	261	finally
    //   138	145	261	finally
    //   149	153	261	finally
    //   172	177	261	finally
    //   181	199	261	finally
    //   203	211	261	finally
    //   218	225	261	finally
    //   233	251	261	finally
    //   254	258	261	finally
    //   63	78	269	finally
    //   63	78	276	java/io/IOException
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, getFilenameForKey(paramString) });
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.DiskBasedCache
 * JD-Core Version:    0.7.0.1
 */