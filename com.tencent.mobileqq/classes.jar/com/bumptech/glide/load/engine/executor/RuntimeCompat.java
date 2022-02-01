package com.bumptech.glide.load.engine.executor;

import android.os.Build.VERSION;

final class RuntimeCompat
{
  static int a()
  {
    int j = Runtime.getRuntime().availableProcessors();
    int i = j;
    if (Build.VERSION.SDK_INT < 17) {
      i = Math.max(b(), j);
    }
    return i;
  }
  
  /* Error */
  private static int b()
  {
    // Byte code:
    //   0: invokestatic 43	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_2
    //   4: new 45	java/io/File
    //   7: dup
    //   8: ldc 47
    //   10: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: new 52	com/bumptech/glide/load/engine/executor/RuntimeCompat$1
    //   16: dup
    //   17: ldc 54
    //   19: invokestatic 60	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   22: invokespecial 63	com/bumptech/glide/load/engine/executor/RuntimeCompat$1:<init>	(Ljava/util/regex/Pattern;)V
    //   25: invokevirtual 67	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   28: astore_1
    //   29: aload_2
    //   30: invokestatic 71	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   33: goto +33 -> 66
    //   36: astore_1
    //   37: goto +47 -> 84
    //   40: astore_1
    //   41: ldc 73
    //   43: bipush 6
    //   45: invokestatic 79	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   48: ifeq +12 -> 60
    //   51: ldc 73
    //   53: ldc 81
    //   55: aload_1
    //   56: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   59: pop
    //   60: aload_2
    //   61: invokestatic 71	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +9 -> 76
    //   70: aload_1
    //   71: arraylength
    //   72: istore_0
    //   73: goto +5 -> 78
    //   76: iconst_0
    //   77: istore_0
    //   78: iconst_1
    //   79: iload_0
    //   80: invokestatic 35	java/lang/Math:max	(II)I
    //   83: ireturn
    //   84: aload_2
    //   85: invokestatic 71	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	8	0	i	int
    //   28	1	1	arrayOfFile	java.io.File[]
    //   36	1	1	localObject1	Object
    //   40	16	1	localThrowable	java.lang.Throwable
    //   65	24	1	localObject2	Object
    //   3	82	2	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   4	29	36	finally
    //   41	60	36	finally
    //   4	29	40	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.RuntimeCompat
 * JD-Core Version:    0.7.0.1
 */