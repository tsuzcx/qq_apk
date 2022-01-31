package com.tencent.beacon.a.a;

import android.content.Context;
import com.tencent.beacon.a.g.a;
import java.io.File;
import java.io.IOException;
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
  
  private File b(String paramString)
  {
    try
    {
      this.a.getFilesDir();
      try
      {
        File localFile = new File(this.a.getFilesDir(), "beacon_" + paramString + ".lock");
        paramString = localFile;
        if (!localFile.exists())
        {
          localFile.createNewFile();
          paramString = localFile;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          a.a(paramString);
          paramString = null;
        }
      }
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 83	java/lang/String:trim	()Ljava/lang/String;
    //   6: invokevirtual 87	java/lang/String:length	()I
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
    //   21: getfield 24	com/tencent/beacon/a/a/f:b	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 93 2 0
    //   30: ifeq +8 -> 38
    //   33: iconst_1
    //   34: istore_3
    //   35: goto -19 -> 16
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 95	com/tencent/beacon/a/a/f:b	(Ljava/lang/String;)Ljava/io/File;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +8 -> 55
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -36 -> 16
    //   55: aload_0
    //   56: getfield 24	com/tencent/beacon/a/a/f:b	Ljava/util/Map;
    //   59: aload_1
    //   60: invokeinterface 99 2 0
    //   65: checkcast 101	java/nio/channels/FileChannel
    //   68: astore 5
    //   70: aload 5
    //   72: ifnull +15 -> 87
    //   75: aload 5
    //   77: astore 4
    //   79: aload 5
    //   81: invokevirtual 104	java/nio/channels/FileChannel:isOpen	()Z
    //   84: ifne +30 -> 114
    //   87: new 106	java/io/FileOutputStream
    //   90: dup
    //   91: aload 6
    //   93: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: invokevirtual 113	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   99: astore 4
    //   101: aload_0
    //   102: getfield 24	com/tencent/beacon/a/a/f:b	Ljava/util/Map;
    //   105: aload_1
    //   106: aload 4
    //   108: invokeinterface 117 3 0
    //   113: pop
    //   114: aload 4
    //   116: invokevirtual 121	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +22 -> 143
    //   124: aload_1
    //   125: invokevirtual 126	java/nio/channels/FileLock:isValid	()Z
    //   128: istore_3
    //   129: iload_3
    //   130: ifeq +13 -> 143
    //   133: iconst_1
    //   134: istore_3
    //   135: goto -119 -> 16
    //   138: astore_1
    //   139: aload_1
    //   140: invokestatic 75	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   143: iconst_0
    //   144: istore_3
    //   145: goto -129 -> 16
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	f
    //   0	153	1	paramString	String
    //   9	2	2	i	int
    //   15	130	3	bool	boolean
    //   77	38	4	localFileChannel1	FileChannel
    //   68	12	5	localFileChannel2	FileChannel
    //   43	49	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   55	70	138	java/lang/Throwable
    //   79	87	138	java/lang/Throwable
    //   87	114	138	java/lang/Throwable
    //   114	120	138	java/lang/Throwable
    //   124	129	138	java/lang/Throwable
    //   2	10	148	finally
    //   20	33	148	finally
    //   38	45	148	finally
    //   55	70	148	finally
    //   79	87	148	finally
    //   87	114	148	finally
    //   114	120	148	finally
    //   124	129	148	finally
    //   139	143	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.f
 * JD-Core Version:    0.7.0.1
 */