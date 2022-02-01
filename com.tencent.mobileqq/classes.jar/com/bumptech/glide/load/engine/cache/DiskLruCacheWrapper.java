package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper
  implements DiskCache
{
  private final SafeKeyGenerator a;
  private final File b;
  private final long c;
  private final DiskCacheWriteLocker d = new DiskCacheWriteLocker();
  private DiskLruCache e;
  
  @Deprecated
  protected DiskLruCacheWrapper(File paramFile, long paramLong)
  {
    this.b = paramFile;
    this.c = paramLong;
    this.a = new SafeKeyGenerator();
  }
  
  private DiskLruCache a()
  {
    try
    {
      if (this.e == null) {
        this.e = DiskLruCache.a(this.b, 1, 1, this.c);
      }
      DiskLruCache localDiskLruCache = this.e;
      return localDiskLruCache;
    }
    finally {}
  }
  
  public static DiskCache a(File paramFile, long paramLong)
  {
    return new DiskLruCacheWrapper(paramFile, paramLong);
  }
  
  public File a(Key paramKey)
  {
    String str = this.a.a(paramKey);
    if (Log.isLoggable("DiskLruCacheWrapper", 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get: Obtained: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" for for Key: ");
      localStringBuilder.append(paramKey);
      Log.v("DiskLruCacheWrapper", localStringBuilder.toString());
    }
    try
    {
      paramKey = a().a(str);
      if (paramKey != null)
      {
        paramKey = paramKey.a(0);
        return paramKey;
      }
    }
    catch (IOException paramKey)
    {
      if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", paramKey);
      }
    }
    return null;
  }
  
  /* Error */
  public void a(Key paramKey, DiskCache.Writer paramWriter)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:a	Lcom/bumptech/glide/load/engine/cache/SafeKeyGenerator;
    //   4: aload_1
    //   5: invokevirtual 55	com/bumptech/glide/load/engine/cache/SafeKeyGenerator:a	(Lcom/bumptech/glide/load/Key;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 27	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:d	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   13: aload_3
    //   14: invokevirtual 105	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:a	(Ljava/lang/String;)V
    //   17: ldc 57
    //   19: iconst_2
    //   20: invokestatic 63	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   23: ifeq +53 -> 76
    //   26: new 65	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 107
    //   39: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 74
    //   54: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload_1
    //   61: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 57
    //   67: aload 4
    //   69: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 85	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: pop
    //   76: aload_0
    //   77: invokespecial 87	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:a	()Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   80: astore_1
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 90	com/bumptech/glide/disklrucache/DiskLruCache:a	(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Value;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull +12 -> 102
    //   93: aload_0
    //   94: getfield 27	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:d	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   97: aload_3
    //   98: invokevirtual 109	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Ljava/lang/String;)V
    //   101: return
    //   102: aload_1
    //   103: aload_3
    //   104: invokevirtual 112	com/bumptech/glide/disklrucache/DiskLruCache:b	(Ljava/lang/String;)Lcom/bumptech/glide/disklrucache/DiskLruCache$Editor;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +35 -> 144
    //   112: aload_2
    //   113: aload_1
    //   114: iconst_0
    //   115: invokevirtual 115	com/bumptech/glide/disklrucache/DiskLruCache$Editor:a	(I)Ljava/io/File;
    //   118: invokeinterface 120 2 0
    //   123: ifeq +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 122	com/bumptech/glide/disklrucache/DiskLruCache$Editor:a	()V
    //   130: aload_1
    //   131: invokevirtual 124	com/bumptech/glide/disklrucache/DiskLruCache$Editor:c	()V
    //   134: goto +62 -> 196
    //   137: astore_2
    //   138: aload_1
    //   139: invokevirtual 124	com/bumptech/glide/disklrucache/DiskLruCache$Editor:c	()V
    //   142: aload_2
    //   143: athrow
    //   144: new 65	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc 126
    //   155: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: aload_3
    //   161: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new 128	java/lang/IllegalStateException
    //   168: dup
    //   169: aload_1
    //   170: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 130	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_1
    //   178: ldc 57
    //   180: iconst_5
    //   181: invokestatic 63	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   184: ifeq +12 -> 196
    //   187: ldc 57
    //   189: ldc 132
    //   191: aload_1
    //   192: invokestatic 101	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   195: pop
    //   196: aload_0
    //   197: getfield 27	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:d	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   200: aload_3
    //   201: invokevirtual 109	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Ljava/lang/String;)V
    //   204: return
    //   205: astore_1
    //   206: aload_0
    //   207: getfield 27	com/bumptech/glide/load/engine/cache/DiskLruCacheWrapper:d	Lcom/bumptech/glide/load/engine/cache/DiskCacheWriteLocker;
    //   210: aload_3
    //   211: invokevirtual 109	com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker:b	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	DiskLruCacheWrapper
    //   0	216	1	paramKey	Key
    //   0	216	2	paramWriter	DiskCache.Writer
    //   8	203	3	str	String
    //   33	56	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	130	137	finally
    //   76	88	177	java/io/IOException
    //   102	108	177	java/io/IOException
    //   130	134	177	java/io/IOException
    //   138	144	177	java/io/IOException
    //   144	177	177	java/io/IOException
    //   17	76	205	finally
    //   76	88	205	finally
    //   102	108	205	finally
    //   130	134	205	finally
    //   138	144	205	finally
    //   144	177	205	finally
    //   178	196	205	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper
 * JD-Core Version:    0.7.0.1
 */