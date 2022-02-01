package com.tencent.biz.richframework.network.cache;

import bfys;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.File;
import java.io.IOException;
import udo;
import xvv;

public abstract class LruCache
  extends Cache
{
  protected static long CacheSize = 15728640L;
  protected static final int DISK_CACHE_INDEX = 0;
  protected static int IO_BUFFER_SIZE = 8192;
  private static String mAppCacheDir;
  private static String mPackgeName;
  private long INTERNAL_FILE_CACHE_SIZE = 15728640L;
  private final String TAG = "LruCache";
  private String mCurrentCacheName = "";
  protected DiskLruCache mDiskLruCache;
  private boolean mIsWriting;
  private Object mWriteLock = new Object();
  
  public LruCache(String paramString1, String paramString2)
  {
    mPackgeName = paramString1;
    mAppCacheDir = paramString2;
    initDiskCache();
  }
  
  private int getInstanceHashCode()
  {
    if (getInstance() == null) {
      return 0;
    }
    return getInstance().hashCode();
  }
  
  /* Error */
  private void initDiskCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   13: invokevirtual 72	com/jakewharton/disklrucache/DiskLruCache:isClosed	()Z
    //   16: ifeq +86 -> 102
    //   19: invokestatic 77	bfys:c	()Z
    //   22: ifne +10 -> 32
    //   25: aload_0
    //   26: getfield 50	com/tencent/biz/richframework/network/cache/LruCache:INTERNAL_FILE_CACHE_SIZE	J
    //   29: putstatic 28	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   32: aload_0
    //   33: invokevirtual 81	com/tencent/biz/richframework/network/cache/LruCache:getCacheDir	()Ljava/lang/String;
    //   36: astore_1
    //   37: new 83	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 89	java/io/File:exists	()Z
    //   50: ifne +55 -> 105
    //   53: ldc 37
    //   55: new 91	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   62: ldc 94
    //   64: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 100
    //   73: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 28	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   79: invokestatic 106	com/tencent/mobileqq/utils/StringUtil:formatSize	(J)Ljava/lang/String;
    //   82: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: invokevirtual 117	java/io/File:mkdirs	()Z
    //   95: pop
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 121	com/tencent/biz/richframework/network/cache/LruCache:open	(Ljava/io/File;)Z
    //   101: pop
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: ldc 37
    //   107: new 91	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   114: ldc 94
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 123
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: getstatic 28	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   131: invokestatic 106	com/tencent/mobileqq/utils/StringUtil:formatSize	(J)Ljava/lang/String;
    //   134: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 126	xvv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -47 -> 96
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	LruCache
    //   36	84	1	str	String
    //   146	4	1	localObject	Object
    //   45	53	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	19	146	finally
    //   19	32	146	finally
    //   32	96	146	finally
    //   96	102	146	finally
    //   105	143	146	finally
  }
  
  /* Error */
  public boolean cacheExists(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore_3
    //   10: aload_0
    //   11: invokespecial 57	com/tencent/biz/richframework/network/cache/LruCache:initDiskCache	()V
    //   14: aload_0
    //   15: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   18: ifnull +177 -> 195
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 136	com/tencent/biz/richframework/network/cache/LruCache:getCacheName	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 138	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   44: aload 6
    //   46: invokevirtual 142	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +20 -> 73
    //   56: iload 4
    //   58: istore_2
    //   59: aload 8
    //   61: invokevirtual 147	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   64: iconst_1
    //   65: istore_3
    //   66: iload_3
    //   67: istore_2
    //   68: aload 7
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: iload 4
    //   75: istore_2
    //   76: ldc 37
    //   78: new 91	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   85: ldc 149
    //   87: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 6
    //   92: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 151
    //   97: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -44 -> 66
    //   113: astore 6
    //   115: aload 7
    //   117: monitorexit
    //   118: aload 6
    //   120: athrow
    //   121: astore 6
    //   123: ldc 37
    //   125: new 91	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   132: ldc 153
    //   134: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: iload_2
    //   148: ireturn
    //   149: astore 6
    //   151: iload 5
    //   153: istore_2
    //   154: ldc 37
    //   156: new 91	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   163: ldc 155
    //   165: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: iload_2
    //   179: ireturn
    //   180: astore 6
    //   182: goto -28 -> 154
    //   185: astore 6
    //   187: goto -64 -> 123
    //   190: astore 6
    //   192: goto -77 -> 115
    //   195: iconst_0
    //   196: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	LruCache
    //   0	197	1	paramString	String
    //   4	175	2	bool1	boolean
    //   9	63	3	bool2	boolean
    //   1	73	4	bool3	boolean
    //   6	146	5	bool4	boolean
    //   26	65	6	str	String
    //   113	6	6	localObject1	Object
    //   121	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   149	1	6	localIOException1	IOException
    //   180	1	6	localIOException2	IOException
    //   185	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   190	1	6	localObject2	Object
    //   32	84	7	localDiskLruCache	DiskLruCache
    //   49	11	8	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   40	51	113	finally
    //   59	64	113	finally
    //   68	71	113	finally
    //   76	110	113	finally
    //   118	121	121	java/io/UnsupportedEncodingException
    //   21	37	149	java/io/IOException
    //   118	121	180	java/io/IOException
    //   21	37	185	java/io/UnsupportedEncodingException
    //   115	118	190	finally
  }
  
  public void clear()
  {
    initDiskCache();
    try
    {
      synchronized (this.mDiskLruCache)
      {
        getInstance().delete();
        return;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected void finalize()
  {
    try
    {
      super.finalize();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          getInstance().close();
          return;
        }
        catch (IOException localIOException) {}
        localThrowable = localThrowable;
      }
    }
  }
  
  public String get(String paramString)
  {
    initDiskCache();
    String str1 = "";
    String str2 = str1;
    String str3;
    if (getInstance() != null)
    {
      str2 = str1;
      str3 = str1;
    }
    try
    {
      paramString = getCacheName(paramString);
      str2 = str1;
      str3 = str1;
      DiskLruCache.Snapshot localSnapshot = getInstance().get(paramString);
      str2 = str1;
      if (localSnapshot != null)
      {
        str2 = str1;
        str3 = str1;
        paramString = udo.b(localSnapshot.getString(0));
        str2 = paramString;
        str3 = paramString;
        localSnapshot.close();
        str2 = paramString;
      }
      return str2;
    }
    catch (IOException paramString)
    {
      return str2;
    }
    catch (NumberFormatException paramString) {}
    return str3;
  }
  
  public String getCacheDir()
  {
    if (bfys.c()) {}
    for (String str = bfys.a() + File.separator + "Android" + File.separator + "data" + File.separator + mPackgeName + File.separator + "cache" + File.separator + getCacheTag();; str = mAppCacheDir + File.separator + "cache" + File.separator + getCacheTag())
    {
      xvv.b("LruCache", "Init cache dir: " + str);
      return str;
    }
  }
  
  protected abstract String getCacheTag();
  
  protected DiskLruCache getInstance()
  {
    return this.mDiskLruCache;
  }
  
  public Cache.CacheInputStream getStream(String paramString)
  {
    initDiskCache();
    Cache.CacheInputStream localCacheInputStream = new Cache.CacheInputStream(this);
    String str = getCacheName(paramString);
    if ((getInstance() != null) && (str != null))
    {
      Object localObject = null;
      try
      {
        DiskLruCache.Snapshot localSnapshot = getInstance().get(str);
        localObject = localSnapshot;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          xvv.d("LruCache", "Get cache error: Cache name: " + str + ", Url: " + paramString);
        }
        xvv.c("LruCache", "Get cache success: Cache name: " + str + ", Url: " + paramString);
        return localCacheInputStream;
      }
      if (localObject != null)
      {
        localCacheInputStream.setSnapshot(localObject);
        localCacheInputStream.setInputStream(localObject.getInputStream(0));
        if (localCacheInputStream.getInputStream() == null)
        {
          xvv.d("LruCache", "Get cache error: InputStream is null. Cache name: " + str + ", Url: " + paramString);
          return localCacheInputStream;
        }
      }
      xvv.d("LruCache", "Get cache error: snapshot is null. Cache name: " + str + ", Url: " + paramString + ",instance hashCode:" + getInstanceHashCode());
      return localCacheInputStream;
    }
    xvv.d("LruCache", "Get cache error: DiskCache or cacheName is null. Cache name: " + str + ", Url: " + paramString);
    return localCacheInputStream;
  }
  
  public void interrupt(String paramString)
  {
    synchronized (this.mWriteLock)
    {
      if ((this.mCurrentCacheName.equals(paramString)) && (this.mIsWriting)) {
        this.mIsWriting = false;
      }
      return;
    }
  }
  
  protected boolean open(File paramFile)
  {
    xvv.b("LruCache", "Open cache dir.");
    try
    {
      this.mDiskLruCache = DiskLruCache.open(paramFile, 1, 1, CacheSize);
      label20:
      return false;
    }
    catch (IOException paramFile)
    {
      break label20;
    }
  }
  
  public void remove(String paramString)
  {
    initDiskCache();
    try
    {
      synchronized (this.mDiskLruCache)
      {
        getInstance().remove(getCacheName(paramString));
        return;
      }
      return;
    }
    catch (IOException paramString)
    {
      return;
    }
    catch (NullPointerException paramString) {}
  }
  
  public boolean set(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    initDiskCache();
    String str = getCacheName(paramString1);
    DiskLruCache localDiskLruCache;
    boolean bool1;
    if ((getInstance() != null) && (str != null))
    {
      localDiskLruCache = this.mDiskLruCache;
      Object localObject = null;
      try
      {
        DiskLruCache.Editor localEditor = getInstance().edit(str);
        localObject = localEditor;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          xvv.d("LruCache", "Set cache error: Exception ");
        }
      }
      finally {}
      bool1 = bool2;
      if (localObject != null) {
        xvv.c("LruCache", "name: " + paramString1 + ", Cache name: " + str + ", value length: " + paramString2.length());
      }
      try
      {
        localObject.set(0, udo.a(paramString2));
        localObject.commit();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          xvv.d("LruCache", "Commit cache error: Exception ");
          bool1 = bool2;
        }
      }
      this.mDiskLruCache.notifyAll();
      return bool1;
    }
    return false;
  }
  
  /* Error */
  public boolean setStream(String arg1, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: getfield 44	com/tencent/biz/richframework/network/cache/LruCache:mWriteLock	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 242	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 48	com/tencent/biz/richframework/network/cache/LruCache:mCurrentCacheName	Ljava/lang/String;
    //   28: aload 7
    //   30: monitorexit
    //   31: aload_0
    //   32: invokespecial 57	com/tencent/biz/richframework/network/cache/LruCache:initDiskCache	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 136	com/tencent/biz/richframework/network/cache/LruCache:getCacheName	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 11
    //   42: aload_0
    //   43: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   46: ifnull +489 -> 535
    //   49: aload 11
    //   51: ifnull +484 -> 535
    //   54: aload_2
    //   55: ifnull +480 -> 535
    //   58: aload_0
    //   59: getfield 138	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   62: astore 10
    //   64: aload 10
    //   66: monitorenter
    //   67: aload_0
    //   68: invokevirtual 63	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   71: aload 11
    //   73: invokevirtual 258	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +416 -> 496
    //   83: new 288	java/io/BufferedOutputStream
    //   86: dup
    //   87: aload 9
    //   89: iconst_0
    //   90: invokevirtual 292	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   93: getstatic 30	com/tencent/biz/richframework/network/cache/LruCache:IO_BUFFER_SIZE	I
    //   96: invokespecial 295	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   99: astore 8
    //   101: aload 8
    //   103: astore 7
    //   105: getstatic 30	com/tencent/biz/richframework/network/cache/LruCache:IO_BUFFER_SIZE	I
    //   108: newarray byte
    //   110: astore 12
    //   112: aload 8
    //   114: astore 7
    //   116: aload_2
    //   117: aload 12
    //   119: invokevirtual 301	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_m1
    //   125: if_icmpeq +26 -> 151
    //   128: aload 8
    //   130: astore 7
    //   132: aload_0
    //   133: getfield 242	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   136: ifne +198 -> 334
    //   139: aload 8
    //   141: astore 7
    //   143: ldc 37
    //   145: ldc_w 303
    //   148: invokestatic 306	xvv:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 8
    //   153: astore 7
    //   155: aload 8
    //   157: invokevirtual 311	java/io/OutputStream:flush	()V
    //   160: aload 8
    //   162: astore 7
    //   164: aload 9
    //   166: invokevirtual 277	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   169: aload 8
    //   171: ifnull +426 -> 597
    //   174: aload 8
    //   176: invokevirtual 312	java/io/OutputStream:close	()V
    //   179: iconst_1
    //   180: istore 4
    //   182: ldc 37
    //   184: new 91	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 314
    //   194: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 11
    //   199: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 316
    //   205: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 318
    //   215: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: invokespecial 228	com/tencent/biz/richframework/network/cache/LruCache:getInstanceHashCode	()I
    //   222: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 222	xvv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: getfield 138	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   235: invokevirtual 280	java/lang/Object:notifyAll	()V
    //   238: aload 10
    //   240: monitorexit
    //   241: iload 4
    //   243: istore 5
    //   245: aload_0
    //   246: getfield 242	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   249: ifne +12 -> 261
    //   252: aload_0
    //   253: aload_1
    //   254: invokevirtual 320	com/tencent/biz/richframework/network/cache/LruCache:remove	(Ljava/lang/String;)V
    //   257: iload 4
    //   259: istore 5
    //   261: aload_0
    //   262: getfield 44	com/tencent/biz/richframework/network/cache/LruCache:mWriteLock	Ljava/lang/Object;
    //   265: astore_1
    //   266: aload_1
    //   267: monitorenter
    //   268: aload_0
    //   269: iconst_0
    //   270: putfield 242	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   273: aload_0
    //   274: ldc 46
    //   276: putfield 48	com/tencent/biz/richframework/network/cache/LruCache:mCurrentCacheName	Ljava/lang/String;
    //   279: aload_1
    //   280: monitorexit
    //   281: iload 5
    //   283: ireturn
    //   284: astore_1
    //   285: aload 7
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    //   290: astore 7
    //   292: ldc 37
    //   294: new 91	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 322
    //   304: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 11
    //   309: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 316
    //   315: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aconst_null
    //   329: astore 9
    //   331: goto -253 -> 78
    //   334: aload 8
    //   336: astore 7
    //   338: ldc 37
    //   340: new 91	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   347: aload 11
    //   349: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 324
    //   355: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_3
    //   359: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 126	xvv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 8
    //   370: astore 7
    //   372: aload 8
    //   374: aload 12
    //   376: iconst_0
    //   377: iload_3
    //   378: invokevirtual 328	java/io/OutputStream:write	([BII)V
    //   381: goto -269 -> 112
    //   384: astore_2
    //   385: aload 8
    //   387: astore_2
    //   388: aload_2
    //   389: astore 7
    //   391: ldc 37
    //   393: new 91	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 330
    //   403: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 11
    //   408: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc_w 316
    //   414: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 318
    //   424: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokespecial 228	com/tencent/biz/richframework/network/cache/LruCache:getInstanceHashCode	()I
    //   431: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: iload 5
    //   442: istore 4
    //   444: aload_2
    //   445: ifnull -263 -> 182
    //   448: aload_2
    //   449: invokevirtual 312	java/io/OutputStream:close	()V
    //   452: iload 5
    //   454: istore 4
    //   456: goto -274 -> 182
    //   459: astore_2
    //   460: iload 5
    //   462: istore 4
    //   464: goto -282 -> 182
    //   467: astore_2
    //   468: iconst_1
    //   469: istore 4
    //   471: goto -289 -> 182
    //   474: astore_1
    //   475: aconst_null
    //   476: astore 7
    //   478: aload 7
    //   480: ifnull +8 -> 488
    //   483: aload 7
    //   485: invokevirtual 312	java/io/OutputStream:close	()V
    //   488: aload_1
    //   489: athrow
    //   490: astore_1
    //   491: aload 10
    //   493: monitorexit
    //   494: aload_1
    //   495: athrow
    //   496: ldc 37
    //   498: new 91	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 332
    //   508: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 11
    //   513: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 316
    //   519: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload_1
    //   523: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: goto -301 -> 231
    //   535: ldc 37
    //   537: new 91	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 334
    //   547: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 11
    //   552: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc_w 316
    //   558: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_1
    //   562: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 114	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iload 6
    //   573: istore 5
    //   575: goto -314 -> 261
    //   578: astore_2
    //   579: aload_1
    //   580: monitorexit
    //   581: aload_2
    //   582: athrow
    //   583: astore_2
    //   584: goto -96 -> 488
    //   587: astore_1
    //   588: goto -110 -> 478
    //   591: astore_2
    //   592: aconst_null
    //   593: astore_2
    //   594: goto -206 -> 388
    //   597: iconst_1
    //   598: istore 4
    //   600: goto -418 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	LruCache
    //   0	603	2	paramInputStream	java.io.InputStream
    //   122	256	3	i	int
    //   1	598	4	bool1	boolean
    //   7	567	5	bool2	boolean
    //   4	568	6	bool3	boolean
    //   13	273	7	localObject1	Object
    //   290	1	7	localIOException	IOException
    //   336	148	7	localObject2	Object
    //   99	287	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   76	254	9	localEditor	DiskLruCache.Editor
    //   62	430	10	localDiskLruCache	DiskLruCache
    //   40	511	11	str	String
    //   110	265	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	31	284	finally
    //   285	288	284	finally
    //   67	78	290	java/io/IOException
    //   105	112	384	java/io/IOException
    //   116	123	384	java/io/IOException
    //   132	139	384	java/io/IOException
    //   143	151	384	java/io/IOException
    //   155	160	384	java/io/IOException
    //   164	169	384	java/io/IOException
    //   338	368	384	java/io/IOException
    //   372	381	384	java/io/IOException
    //   448	452	459	java/io/IOException
    //   174	179	467	java/io/IOException
    //   83	101	474	finally
    //   67	78	490	finally
    //   174	179	490	finally
    //   182	231	490	finally
    //   231	241	490	finally
    //   292	328	490	finally
    //   448	452	490	finally
    //   483	488	490	finally
    //   488	490	490	finally
    //   491	494	490	finally
    //   496	532	490	finally
    //   268	281	578	finally
    //   579	581	578	finally
    //   483	488	583	java/io/IOException
    //   105	112	587	finally
    //   116	123	587	finally
    //   132	139	587	finally
    //   143	151	587	finally
    //   155	160	587	finally
    //   164	169	587	finally
    //   338	368	587	finally
    //   372	381	587	finally
    //   391	440	587	finally
    //   83	101	591	java/io/IOException
  }
  
  public long size()
  {
    initDiskCache();
    return getInstance().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.LruCache
 * JD-Core Version:    0.7.0.1
 */