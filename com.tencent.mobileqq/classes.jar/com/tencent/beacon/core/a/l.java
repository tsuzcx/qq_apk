package com.tencent.beacon.core.a;

import android.content.Context;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class l
{
  static l a;
  Context b = null;
  Map<String, FileChannel> c = null;
  
  protected l(Context paramContext)
  {
    this.b = paramContext;
    this.c = new HashMap(5);
  }
  
  public static l a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new l(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  protected java.io.File a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	com/tencent/beacon/core/a/l:b	Landroid/content/Context;
    //   8: invokevirtual 40	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +9 -> 24
    //   18: aload_3
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 18	com/tencent/beacon/core/a/l:b	Landroid/content/Context;
    //   28: invokevirtual 40	android/content/Context:getFilesDir	()Ljava/io/File;
    //   31: astore_3
    //   32: new 42	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: ldc 45
    //   45: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore_1
    //   53: new 51	java/io/File
    //   56: dup
    //   57: aload_3
    //   58: aload_1
    //   59: ldc 53
    //   61: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 64	java/io/File:exists	()Z
    //   75: istore_2
    //   76: aload_3
    //   77: astore_1
    //   78: iload_2
    //   79: ifne +26 -> 105
    //   82: ldc 66
    //   84: iconst_1
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_3
    //   91: invokevirtual 69	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   94: aastore
    //   95: invokestatic 74	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_3
    //   99: invokevirtual 77	java/io/File:createNewFile	()Z
    //   102: pop
    //   103: aload_3
    //   104: astore_1
    //   105: goto -85 -> 20
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 80	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -10 -> 105
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	l
    //   0	123	1	paramString	String
    //   75	4	2	bool	boolean
    //   1	103	3	localFile	java.io.File
    //   11	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	41	108	java/io/IOException
    //   41	53	108	java/io/IOException
    //   53	76	108	java/io/IOException
    //   82	103	108	java/io/IOException
    //   4	13	118	finally
    //   24	41	118	finally
    //   41	53	118	finally
    //   53	76	118	finally
    //   82	103	118	finally
    //   109	113	118	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +15 -> 18
    //   6: aload_1
    //   7: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 92	java/lang/String:length	()I
    //   13: istore_2
    //   14: iload_2
    //   15: ifgt +9 -> 24
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 20	com/tencent/beacon/core/a/l:c	Ljava/util/Map;
    //   28: aload_1
    //   29: invokeinterface 98 2 0
    //   34: ifeq +8 -> 42
    //   37: iconst_1
    //   38: istore_3
    //   39: goto -19 -> 20
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 100	com/tencent/beacon/core/a/l:a	(Ljava/lang/String;)Ljava/io/File;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +8 -> 59
    //   54: iconst_1
    //   55: istore_3
    //   56: goto -36 -> 20
    //   59: aload_0
    //   60: getfield 20	com/tencent/beacon/core/a/l:c	Ljava/util/Map;
    //   63: aload_1
    //   64: invokeinterface 104 2 0
    //   69: checkcast 106	java/nio/channels/FileChannel
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +13 -> 89
    //   79: aload 4
    //   81: invokevirtual 109	java/nio/channels/FileChannel:isOpen	()Z
    //   84: istore_3
    //   85: iload_3
    //   86: ifne +43 -> 129
    //   89: ldc 111
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: invokestatic 74	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: new 113	java/io/FileOutputStream
    //   105: dup
    //   106: aload 5
    //   108: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   111: invokevirtual 120	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 20	com/tencent/beacon/core/a/l:c	Ljava/util/Map;
    //   120: aload_1
    //   121: aload 4
    //   123: invokeinterface 124 3 0
    //   128: pop
    //   129: aload 4
    //   131: invokevirtual 128	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +22 -> 158
    //   139: aload_1
    //   140: invokevirtual 133	java/nio/channels/FileLock:isValid	()Z
    //   143: istore_3
    //   144: iload_3
    //   145: ifeq +13 -> 158
    //   148: iconst_1
    //   149: istore_3
    //   150: goto -130 -> 20
    //   153: astore_1
    //   154: aload_1
    //   155: invokestatic 80	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -140 -> 20
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	l
    //   0	168	1	paramString	String
    //   13	2	2	i	int
    //   19	141	3	bool	boolean
    //   72	58	4	localFileChannel	FileChannel
    //   47	60	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   59	74	153	java/lang/Throwable
    //   79	85	153	java/lang/Throwable
    //   89	129	153	java/lang/Throwable
    //   129	135	153	java/lang/Throwable
    //   139	144	153	java/lang/Throwable
    //   6	14	163	finally
    //   24	37	163	finally
    //   42	49	163	finally
    //   59	74	163	finally
    //   79	85	163	finally
    //   89	129	163	finally
    //   129	135	163	finally
    //   139	144	163	finally
    //   154	158	163	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.l
 * JD-Core Version:    0.7.0.1
 */