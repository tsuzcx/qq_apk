package com.tencent.ilive.util.soloader;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

public class LoadLibraryUtil
{
  private static final String TAG = "soloaderutil";
  private static File lastSoDir = null;
  
  @TargetApi(23)
  private static int getPreviousSdkInt()
  {
    try
    {
      int i = Build.VERSION.PREVIEW_SDK_INT;
      return i;
    }
    catch (Throwable localThrowable) {}
    return 1;
  }
  
  /* Error */
  public static boolean installNativeLibraryPath(ClassLoader paramClassLoader, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnull +14 -> 23
    //   12: aload_1
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokevirtual 42	java/io/File:exists	()Z
    //   20: ifne +37 -> 57
    //   23: ldc 8
    //   25: new 44	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   32: ldc 47
    //   34: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 64	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   47: pop
    //   48: iconst_0
    //   49: istore 5
    //   51: ldc 2
    //   53: monitorexit
    //   54: iload 5
    //   56: ireturn
    //   57: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   60: istore_3
    //   61: iload_3
    //   62: bipush 25
    //   64: if_icmpne +13 -> 77
    //   67: invokestatic 69	com/tencent/ilive/util/soloader/LoadLibraryUtil:getPreviousSdkInt	()I
    //   70: istore 4
    //   72: iload 4
    //   74: ifne +9 -> 83
    //   77: iload_3
    //   78: bipush 25
    //   80: if_icmple +5 -> 85
    //   83: iconst_1
    //   84: istore_2
    //   85: iload_2
    //   86: ifeq +41 -> 127
    //   89: aload_0
    //   90: aload_1
    //   91: invokestatic 75	com/tencent/ilive/util/soloader/LoadLibraryUtil$V25:access$000	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   94: aload_1
    //   95: putstatic 14	com/tencent/ilive/util/soloader/LoadLibraryUtil:lastSoDir	Ljava/io/File;
    //   98: goto -47 -> 51
    //   101: astore_0
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    //   107: astore 6
    //   109: aload_0
    //   110: aload_1
    //   111: invokestatic 80	com/tencent/ilive/util/soloader/LoadLibraryUtil$V23:access$100	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   114: goto -20 -> 94
    //   117: astore 6
    //   119: aload_0
    //   120: aload_1
    //   121: invokestatic 85	com/tencent/ilive/util/soloader/LoadLibraryUtil$V14:access$200	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   124: goto -30 -> 94
    //   127: iload_3
    //   128: bipush 23
    //   130: if_icmplt +21 -> 151
    //   133: aload_0
    //   134: aload_1
    //   135: invokestatic 80	com/tencent/ilive/util/soloader/LoadLibraryUtil$V23:access$100	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   138: goto -44 -> 94
    //   141: astore 6
    //   143: aload_0
    //   144: aload_1
    //   145: invokestatic 85	com/tencent/ilive/util/soloader/LoadLibraryUtil$V14:access$200	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   148: goto -54 -> 94
    //   151: iload_3
    //   152: bipush 14
    //   154: if_icmplt -60 -> 94
    //   157: aload_0
    //   158: aload_1
    //   159: invokestatic 85	com/tencent/ilive/util/soloader/LoadLibraryUtil$V14:access$200	(Ljava/lang/ClassLoader;Ljava/io/File;)V
    //   162: goto -68 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramClassLoader	ClassLoader
    //   0	165	1	paramFile	File
    //   4	82	2	i	int
    //   60	95	3	j	int
    //   70	3	4	k	int
    //   1	54	5	bool	boolean
    //   107	1	6	localThrowable1	Throwable
    //   117	1	6	localThrowable2	Throwable
    //   141	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   16	23	101	finally
    //   23	48	101	finally
    //   57	61	101	finally
    //   67	72	101	finally
    //   89	94	101	finally
    //   94	98	101	finally
    //   109	114	101	finally
    //   119	124	101	finally
    //   133	138	101	finally
    //   143	148	101	finally
    //   157	162	101	finally
    //   89	94	107	java/lang/Throwable
    //   109	114	117	java/lang/Throwable
    //   133	138	141	java/lang/Throwable
  }
  
  public static boolean installNativeLibraryPath(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      boolean bool = installNativeLibraryPath(paramClassLoader, new File(paramString));
      return bool;
    }
    finally
    {
      paramClassLoader = finally;
      throw paramClassLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.LoadLibraryUtil
 * JD-Core Version:    0.7.0.1
 */