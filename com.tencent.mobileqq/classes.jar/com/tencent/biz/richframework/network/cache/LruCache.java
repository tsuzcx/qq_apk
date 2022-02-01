package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.util.Encrypt;
import com.tencent.biz.richframework.network.util.SdCardUtil;
import java.io.File;
import java.io.IOException;

public abstract class LruCache
  extends Cache
{
  protected static long CacheSize = 15728640L;
  protected static final int DISK_CACHE_INDEX = 0;
  private static final long INTERNAL_FILE_CACHE_SIZE = 15728640L;
  protected static int IO_BUFFER_SIZE = 8192;
  private static final String TAG = "LruCache";
  private static String mAppCacheDir;
  private static String mPackgeName;
  private String mCurrentCacheName = "";
  protected DiskLruCache mDiskLruCache = null;
  private boolean mIsWriting = false;
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
    //   3: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   13: invokevirtual 74	com/jakewharton/disklrucache/DiskLruCache:isClosed	()Z
    //   16: ifeq +88 -> 104
    //   19: invokestatic 79	com/tencent/biz/richframework/network/util/SdCardUtil:sdCardExists	()Z
    //   22: ifne +9 -> 31
    //   25: ldc2_w 13
    //   28: putstatic 32	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   31: aload_0
    //   32: invokevirtual 83	com/tencent/biz/richframework/network/cache/LruCache:getCacheDir	()Ljava/lang/String;
    //   35: astore_1
    //   36: new 85	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 91	java/io/File:exists	()Z
    //   49: ifne +58 -> 107
    //   52: ldc 19
    //   54: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   57: new 98	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   64: ldc 101
    //   66: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 107
    //   75: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 32	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   81: invokestatic 113	com/tencent/biz/richframework/network/util/StringUtils:formatSize	(J)Ljava/lang/String;
    //   84: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: invokevirtual 123	java/io/File:mkdirs	()Z
    //   97: pop
    //   98: aload_0
    //   99: aload_2
    //   100: invokevirtual 127	com/tencent/biz/richframework/network/cache/LruCache:open	(Ljava/io/File;)Z
    //   103: pop
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: ldc 19
    //   109: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   112: new 98	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   119: ldc 101
    //   121: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 129
    //   130: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 32	com/tencent/biz/richframework/network/cache/LruCache:CacheSize	J
    //   136: invokestatic 113	com/tencent/biz/richframework/network/util/StringUtils:formatSize	(J)Ljava/lang/String;
    //   139: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 132	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: goto -50 -> 98
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	LruCache
    //   35	90	1	str	String
    //   151	4	1	localObject	Object
    //   44	56	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	19	151	finally
    //   19	31	151	finally
    //   31	98	151	finally
    //   98	104	151	finally
    //   107	148	151	finally
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
    //   11: invokespecial 59	com/tencent/biz/richframework/network/cache/LruCache:initDiskCache	()V
    //   14: aload_0
    //   15: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   18: ifnull +186 -> 204
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 142	com/tencent/biz/richframework/network/cache/LruCache:getCacheName	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 41	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   44: aload 6
    //   46: invokevirtual 146	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +20 -> 73
    //   56: iload 4
    //   58: istore_2
    //   59: aload 8
    //   61: invokevirtual 151	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
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
    //   76: ldc 19
    //   78: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   81: new 98	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   88: ldc 153
    //   90: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 155
    //   100: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: goto -47 -> 66
    //   116: astore 6
    //   118: aload 7
    //   120: monitorexit
    //   121: aload 6
    //   123: athrow
    //   124: astore 6
    //   126: ldc 19
    //   128: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   131: new 98	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   138: ldc 157
    //   140: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: iload_2
    //   154: ireturn
    //   155: astore 6
    //   157: iload 5
    //   159: istore_2
    //   160: ldc 19
    //   162: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   165: new 98	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   172: ldc 159
    //   174: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload_2
    //   188: ireturn
    //   189: astore 6
    //   191: goto -31 -> 160
    //   194: astore 6
    //   196: goto -70 -> 126
    //   199: astore 6
    //   201: goto -83 -> 118
    //   204: iconst_0
    //   205: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	LruCache
    //   0	206	1	paramString	String
    //   4	184	2	bool1	boolean
    //   9	63	3	bool2	boolean
    //   1	73	4	bool3	boolean
    //   6	152	5	bool4	boolean
    //   26	68	6	str	String
    //   116	6	6	localObject1	Object
    //   124	1	6	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   155	1	6	localIOException1	IOException
    //   189	1	6	localIOException2	IOException
    //   194	1	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   199	1	6	localObject2	Object
    //   32	87	7	localDiskLruCache	DiskLruCache
    //   49	11	8	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   40	51	116	finally
    //   59	64	116	finally
    //   68	71	116	finally
    //   76	113	116	finally
    //   121	124	124	java/io/UnsupportedEncodingException
    //   21	37	155	java/io/IOException
    //   121	124	189	java/io/IOException
    //   21	37	194	java/io/UnsupportedEncodingException
    //   118	121	199	finally
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
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
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
        paramString = Encrypt.decrypt(localSnapshot.getString(0));
        str2 = paramString;
        str3 = paramString;
        localSnapshot.close();
        str2 = paramString;
      }
      return str2;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return str2;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return str3;
  }
  
  public String getCacheDir()
  {
    if (SdCardUtil.sdCardExists()) {}
    for (String str = SdCardUtil.getSdCardDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + mPackgeName + File.separator + "cache" + File.separator + getCacheTag();; str = mAppCacheDir + File.separator + "cache" + File.separator + getCacheTag())
    {
      RFLog.d("LruCache", RFLog.DEV, "Init cache dir: " + str);
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
          RFLog.w("LruCache", RFLog.DEV, "Get cache error: Cache name: " + str + ", Url: " + paramString);
        }
        RFLog.i("LruCache", RFLog.DEV, "Get cache success: Cache name: " + str + ", Url: " + paramString);
        return localCacheInputStream;
      }
      if (localObject != null)
      {
        localCacheInputStream.setSnapshot(localObject);
        localCacheInputStream.setInputStream(localObject.getInputStream(0));
        if (localCacheInputStream.getInputStream() == null)
        {
          RFLog.w("LruCache", RFLog.DEV, "Get cache error: InputStream is null. Cache name: " + str + ", Url: " + paramString);
          return localCacheInputStream;
        }
      }
      RFLog.w("LruCache", RFLog.DEV, "Get cache error: snapshot is null. Cache name: " + str + ", Url: " + paramString + ",instance hashCode:" + getInstanceHashCode());
      return localCacheInputStream;
    }
    RFLog.w("LruCache", RFLog.DEV, "Get cache error: DiskCache or cacheName is null. Cache name: " + str + ", Url: " + paramString);
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
    RFLog.d("LruCache", RFLog.DEV, "Open cache dir.");
    try
    {
      this.mDiskLruCache = DiskLruCache.open(paramFile, 1, 1, CacheSize);
      return false;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
      }
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
      paramString.printStackTrace();
      return;
    }
    catch (NullPointerException paramString)
    {
      paramString.printStackTrace();
    }
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
          RFLog.w("LruCache", RFLog.DEV, "Set cache error: Exception ");
        }
      }
      finally {}
      bool1 = bool2;
      if (localObject != null) {
        RFLog.i("LruCache", RFLog.DEV, "name: " + paramString1 + ", Cache name: " + str + ", value length: " + paramString2.length());
      }
      try
      {
        localObject.set(0, Encrypt.encrypt(paramString2));
        localObject.commit();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          RFLog.w("LruCache", RFLog.DEV, "Commit cache error: Exception ");
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
    //   10: getfield 46	com/tencent/biz/richframework/network/cache/LruCache:mWriteLock	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 48	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 52	com/tencent/biz/richframework/network/cache/LruCache:mCurrentCacheName	Ljava/lang/String;
    //   28: aload 7
    //   30: monitorexit
    //   31: aload_0
    //   32: invokespecial 59	com/tencent/biz/richframework/network/cache/LruCache:initDiskCache	()V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 142	com/tencent/biz/richframework/network/cache/LruCache:getCacheName	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 11
    //   42: aload_0
    //   43: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   46: ifnull +523 -> 569
    //   49: aload 11
    //   51: ifnull +518 -> 569
    //   54: aload_2
    //   55: ifnull +514 -> 569
    //   58: aload_0
    //   59: getfield 41	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   62: astore 10
    //   64: aload 10
    //   66: monitorenter
    //   67: aload_0
    //   68: invokevirtual 65	com/tencent/biz/richframework/network/cache/LruCache:getInstance	()Lcom/jakewharton/disklrucache/DiskLruCache;
    //   71: aload 11
    //   73: invokevirtual 261	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +447 -> 527
    //   83: new 292	java/io/BufferedOutputStream
    //   86: dup
    //   87: aload 9
    //   89: iconst_0
    //   90: invokevirtual 296	com/jakewharton/disklrucache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   93: getstatic 34	com/tencent/biz/richframework/network/cache/LruCache:IO_BUFFER_SIZE	I
    //   96: invokespecial 299	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   99: astore 8
    //   101: aload 8
    //   103: astore 7
    //   105: getstatic 34	com/tencent/biz/richframework/network/cache/LruCache:IO_BUFFER_SIZE	I
    //   108: newarray byte
    //   110: astore 12
    //   112: aload 8
    //   114: astore 7
    //   116: aload_2
    //   117: aload 12
    //   119: invokevirtual 305	java/io/InputStream:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: iconst_m1
    //   125: if_icmpeq +29 -> 154
    //   128: aload 8
    //   130: astore 7
    //   132: aload_0
    //   133: getfield 48	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   136: ifne +207 -> 343
    //   139: aload 8
    //   141: astore 7
    //   143: ldc 19
    //   145: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   148: ldc_w 307
    //   151: invokestatic 310	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 8
    //   156: astore 7
    //   158: aload 8
    //   160: invokevirtual 315	java/io/OutputStream:flush	()V
    //   163: aload 8
    //   165: astore 7
    //   167: aload 9
    //   169: invokevirtual 281	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   172: aload 8
    //   174: ifnull +456 -> 630
    //   177: aload 8
    //   179: invokevirtual 316	java/io/OutputStream:close	()V
    //   182: iconst_1
    //   183: istore 4
    //   185: ldc 19
    //   187: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   190: new 98	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 318
    //   200: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 11
    //   205: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 320
    //   211: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 322
    //   221: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: invokespecial 232	com/tencent/biz/richframework/network/cache/LruCache:getInstanceHashCode	()I
    //   228: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 226	com/tencent/biz/richframework/delegate/impl/RFLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_0
    //   238: getfield 41	com/tencent/biz/richframework/network/cache/LruCache:mDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   241: invokevirtual 284	java/lang/Object:notifyAll	()V
    //   244: aload 10
    //   246: monitorexit
    //   247: iload 4
    //   249: istore 5
    //   251: aload_0
    //   252: getfield 48	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   255: ifne +12 -> 267
    //   258: aload_0
    //   259: aload_1
    //   260: invokevirtual 324	com/tencent/biz/richframework/network/cache/LruCache:remove	(Ljava/lang/String;)V
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: getfield 46	com/tencent/biz/richframework/network/cache/LruCache:mWriteLock	Ljava/lang/Object;
    //   271: astore_1
    //   272: aload_1
    //   273: monitorenter
    //   274: aload_0
    //   275: iconst_0
    //   276: putfield 48	com/tencent/biz/richframework/network/cache/LruCache:mIsWriting	Z
    //   279: aload_0
    //   280: ldc 50
    //   282: putfield 52	com/tencent/biz/richframework/network/cache/LruCache:mCurrentCacheName	Ljava/lang/String;
    //   285: aload_1
    //   286: monitorexit
    //   287: iload 5
    //   289: ireturn
    //   290: astore_1
    //   291: aload 7
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    //   296: astore 7
    //   298: ldc 19
    //   300: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   303: new 98	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 326
    //   313: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 11
    //   318: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 320
    //   324: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_1
    //   328: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aconst_null
    //   338: astore 9
    //   340: goto -262 -> 78
    //   343: aload 8
    //   345: astore 7
    //   347: ldc 19
    //   349: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   352: new 98	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   359: aload 11
    //   361: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 328
    //   367: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload_3
    //   371: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 132	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload 8
    //   382: astore 7
    //   384: aload 8
    //   386: aload 12
    //   388: iconst_0
    //   389: iload_3
    //   390: invokevirtual 332	java/io/OutputStream:write	([BII)V
    //   393: goto -281 -> 112
    //   396: astore_2
    //   397: aload 8
    //   399: astore_2
    //   400: aload_2
    //   401: astore 7
    //   403: ldc 19
    //   405: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   408: new 98	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 334
    //   418: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 11
    //   423: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 320
    //   429: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_1
    //   433: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 322
    //   439: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: invokespecial 232	com/tencent/biz/richframework/network/cache/LruCache:getInstanceHashCode	()I
    //   446: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: iload 5
    //   457: istore 4
    //   459: aload_2
    //   460: ifnull -275 -> 185
    //   463: aload_2
    //   464: invokevirtual 316	java/io/OutputStream:close	()V
    //   467: iload 5
    //   469: istore 4
    //   471: goto -286 -> 185
    //   474: astore_2
    //   475: aload_2
    //   476: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   479: iload 5
    //   481: istore 4
    //   483: goto -298 -> 185
    //   486: astore_1
    //   487: aload 10
    //   489: monitorexit
    //   490: aload_1
    //   491: athrow
    //   492: astore_2
    //   493: aload_2
    //   494: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   497: iconst_1
    //   498: istore 4
    //   500: goto -315 -> 185
    //   503: astore_1
    //   504: aconst_null
    //   505: astore 7
    //   507: aload 7
    //   509: ifnull +8 -> 517
    //   512: aload 7
    //   514: invokevirtual 316	java/io/OutputStream:close	()V
    //   517: aload_1
    //   518: athrow
    //   519: astore_2
    //   520: aload_2
    //   521: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   524: goto -7 -> 517
    //   527: ldc 19
    //   529: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   532: new 98	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 336
    //   542: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 11
    //   547: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 320
    //   553: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_1
    //   557: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: goto -329 -> 237
    //   569: ldc 19
    //   571: getstatic 96	com/tencent/biz/richframework/delegate/impl/RFLog:DEV	I
    //   574: new 98	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 338
    //   584: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 11
    //   589: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 320
    //   595: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_1
    //   599: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 120	com/tencent/biz/richframework/delegate/impl/RFLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: iload 6
    //   610: istore 5
    //   612: goto -345 -> 267
    //   615: astore_2
    //   616: aload_1
    //   617: monitorexit
    //   618: aload_2
    //   619: athrow
    //   620: astore_1
    //   621: goto -114 -> 507
    //   624: astore_2
    //   625: aconst_null
    //   626: astore_2
    //   627: goto -227 -> 400
    //   630: iconst_1
    //   631: istore 4
    //   633: goto -448 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	LruCache
    //   0	636	2	paramInputStream	java.io.InputStream
    //   122	268	3	i	int
    //   1	631	4	bool1	boolean
    //   7	604	5	bool2	boolean
    //   4	605	6	bool3	boolean
    //   13	279	7	localObject1	Object
    //   296	1	7	localIOException	IOException
    //   345	168	7	localObject2	Object
    //   99	299	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   76	263	9	localEditor	DiskLruCache.Editor
    //   62	426	10	localDiskLruCache	DiskLruCache
    //   40	548	11	str	String
    //   110	277	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	31	290	finally
    //   291	294	290	finally
    //   67	78	296	java/io/IOException
    //   105	112	396	java/io/IOException
    //   116	123	396	java/io/IOException
    //   132	139	396	java/io/IOException
    //   143	154	396	java/io/IOException
    //   158	163	396	java/io/IOException
    //   167	172	396	java/io/IOException
    //   347	380	396	java/io/IOException
    //   384	393	396	java/io/IOException
    //   463	467	474	java/io/IOException
    //   67	78	486	finally
    //   177	182	486	finally
    //   185	237	486	finally
    //   237	247	486	finally
    //   298	337	486	finally
    //   463	467	486	finally
    //   475	479	486	finally
    //   487	490	486	finally
    //   493	497	486	finally
    //   512	517	486	finally
    //   517	519	486	finally
    //   520	524	486	finally
    //   527	566	486	finally
    //   177	182	492	java/io/IOException
    //   83	101	503	finally
    //   512	517	519	java/io/IOException
    //   274	287	615	finally
    //   616	618	615	finally
    //   105	112	620	finally
    //   116	123	620	finally
    //   132	139	620	finally
    //   143	154	620	finally
    //   158	163	620	finally
    //   167	172	620	finally
    //   347	380	620	finally
    //   384	393	620	finally
    //   403	455	620	finally
    //   83	101	624	java/io/IOException
  }
  
  public long size()
  {
    initDiskCache();
    return getInstance().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.cache.LruCache
 * JD-Core Version:    0.7.0.1
 */