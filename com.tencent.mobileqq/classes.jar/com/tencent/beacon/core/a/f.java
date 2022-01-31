package com.tencent.beacon.core.a;

import android.content.Context;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static f c = null;
  private Context a = null;
  private Map<String, FileChannel> b = null;
  
  private f(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap(5);
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new f(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private java.io.File b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 22	com/tencent/beacon/core/a/f:a	Landroid/content/Context;
    //   8: invokevirtual 41	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +9 -> 22
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 43	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 22	com/tencent/beacon/core/a/f:a	Landroid/content/Context;
    //   30: invokevirtual 41	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: new 45	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 47
    //   39: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_1
    //   43: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 56
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 67	java/io/File:exists	()Z
    //   64: ifne +26 -> 90
    //   67: ldc 69
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_2
    //   76: invokevirtual 72	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 77	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_2
    //   84: invokevirtual 80	java/io/File:createNewFile	()Z
    //   87: pop
    //   88: aload_2
    //   89: astore_1
    //   90: goto -72 -> 18
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 83	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   98: aconst_null
    //   99: astore_1
    //   100: goto -10 -> 90
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	f
    //   0	108	1	paramString	String
    //   1	88	2	localFile1	java.io.File
    //   11	2	3	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   22	58	93	java/io/IOException
    //   60	88	93	java/io/IOException
    //   4	12	103	finally
    //   22	58	103	finally
    //   60	88	103	finally
    //   94	98	103	finally
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 91	java/lang/String:trim	()Ljava/lang/String;
    //   6: invokevirtual 95	java/lang/String:length	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifgt +9 -> 20
    //   14: iconst_0
    //   15: istore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_3
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 24	com/tencent/beacon/core/a/f:b	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 101 2 0
    //   30: ifeq +8 -> 38
    //   33: iconst_1
    //   34: istore_3
    //   35: goto -19 -> 16
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 103	com/tencent/beacon/core/a/f:b	(Ljava/lang/String;)Ljava/io/File;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +8 -> 55
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -36 -> 16
    //   55: aload_0
    //   56: getfield 24	com/tencent/beacon/core/a/f:b	Ljava/util/Map;
    //   59: aload_1
    //   60: invokeinterface 107 2 0
    //   65: checkcast 109	java/nio/channels/FileChannel
    //   68: astore 5
    //   70: aload 5
    //   72: ifnull +15 -> 87
    //   75: aload 5
    //   77: astore 4
    //   79: aload 5
    //   81: invokevirtual 112	java/nio/channels/FileChannel:isOpen	()Z
    //   84: ifne +43 -> 127
    //   87: ldc 114
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: invokestatic 77	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: new 116	java/io/FileOutputStream
    //   103: dup
    //   104: aload 6
    //   106: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   109: invokevirtual 123	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   112: astore 4
    //   114: aload_0
    //   115: getfield 24	com/tencent/beacon/core/a/f:b	Ljava/util/Map;
    //   118: aload_1
    //   119: aload 4
    //   121: invokeinterface 127 3 0
    //   126: pop
    //   127: aload 4
    //   129: invokevirtual 131	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +22 -> 156
    //   137: aload_1
    //   138: invokevirtual 136	java/nio/channels/FileLock:isValid	()Z
    //   141: istore_3
    //   142: iload_3
    //   143: ifeq +13 -> 156
    //   146: iconst_1
    //   147: istore_3
    //   148: goto -132 -> 16
    //   151: astore_1
    //   152: aload_1
    //   153: invokestatic 83	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   156: iconst_0
    //   157: istore_3
    //   158: goto -142 -> 16
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	f
    //   0	166	1	paramString	String
    //   9	2	2	i	int
    //   15	143	3	bool	boolean
    //   77	51	4	localFileChannel1	FileChannel
    //   68	12	5	localFileChannel2	FileChannel
    //   43	62	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   55	70	151	java/lang/Throwable
    //   79	87	151	java/lang/Throwable
    //   87	127	151	java/lang/Throwable
    //   127	133	151	java/lang/Throwable
    //   137	142	151	java/lang/Throwable
    //   2	10	161	finally
    //   20	33	161	finally
    //   38	45	161	finally
    //   55	70	161	finally
    //   79	87	161	finally
    //   87	127	161	finally
    //   127	133	161	finally
    //   137	142	161	finally
    //   152	156	161	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.f
 * JD-Core Version:    0.7.0.1
 */