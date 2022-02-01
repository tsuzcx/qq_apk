package com.tencent.mobileqq.ark.debug;

import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;

final class JSDebuggerSoLoader$1
  extends ArkAppCGI.ArkAppCGICallback
{
  JSDebuggerSoLoader$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  /* Error */
  public void b(boolean paramBoolean, long paramLong, byte[] arg4)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +271 -> 272
    //   4: aload 4
    //   6: ifnull +266 -> 272
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: aload 6
    //   17: astore 5
    //   19: new 30	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: getfield 13	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:a	Ljava/lang/String;
    //   27: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 6
    //   34: astore 5
    //   36: aload 8
    //   38: invokevirtual 37	java/io/File:exists	()Z
    //   41: ifeq +13 -> 54
    //   44: aload 6
    //   46: astore 5
    //   48: aload 8
    //   50: invokevirtual 40	java/io/File:delete	()Z
    //   53: pop
    //   54: aload 6
    //   56: astore 5
    //   58: aload 8
    //   60: invokevirtual 43	java/io/File:createNewFile	()Z
    //   63: pop
    //   64: aload 6
    //   66: astore 5
    //   68: new 45	java/io/FileOutputStream
    //   71: dup
    //   72: aload 8
    //   74: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore 6
    //   79: aload 6
    //   81: aload 4
    //   83: invokevirtual 52	java/io/FileOutputStream:write	([B)V
    //   86: aload 6
    //   88: ifnull +8 -> 96
    //   91: aload 6
    //   93: invokevirtual 55	java/io/FileOutputStream:close	()V
    //   96: aload_0
    //   97: getfield 15	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:b	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 17	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:c	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 17	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:c	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 19	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:d	Ljava/lang/String;
    //   112: invokestatic 60	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   115: ifeq +142 -> 257
    //   118: iconst_4
    //   119: invokestatic 63	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(I)V
    //   122: ldc 65
    //   124: iconst_2
    //   125: ldc 67
    //   127: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 19	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:d	Ljava/lang/String;
    //   134: ldc 75
    //   136: invokestatic 78	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: invokestatic 81	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	()Ljava/lang/Object;
    //   142: astore 4
    //   144: aload 4
    //   146: monitorenter
    //   147: iconst_0
    //   148: invokestatic 84	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(Z)Z
    //   151: pop
    //   152: aload 4
    //   154: monitorexit
    //   155: return
    //   156: astore 4
    //   158: ldc 65
    //   160: iconst_1
    //   161: aload 4
    //   163: iconst_0
    //   164: anewarray 86	java/lang/Object
    //   167: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   170: goto -74 -> 96
    //   173: astore 6
    //   175: aload 7
    //   177: astore 4
    //   179: aload 4
    //   181: astore 5
    //   183: ldc 65
    //   185: iconst_1
    //   186: aload 6
    //   188: iconst_0
    //   189: anewarray 86	java/lang/Object
    //   192: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   195: aload 4
    //   197: ifnull -101 -> 96
    //   200: aload 4
    //   202: invokevirtual 55	java/io/FileOutputStream:close	()V
    //   205: goto -109 -> 96
    //   208: astore 4
    //   210: ldc 65
    //   212: iconst_1
    //   213: aload 4
    //   215: iconst_0
    //   216: anewarray 86	java/lang/Object
    //   219: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   222: goto -126 -> 96
    //   225: astore 4
    //   227: aload 5
    //   229: ifnull +8 -> 237
    //   232: aload 5
    //   234: invokevirtual 55	java/io/FileOutputStream:close	()V
    //   237: aload 4
    //   239: athrow
    //   240: astore 5
    //   242: ldc 65
    //   244: iconst_1
    //   245: aload 5
    //   247: iconst_0
    //   248: anewarray 86	java/lang/Object
    //   251: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: goto -17 -> 237
    //   257: iconst_5
    //   258: invokestatic 63	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(I)V
    //   261: ldc 65
    //   263: iconst_2
    //   264: ldc 92
    //   266: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -130 -> 139
    //   272: bipush 6
    //   274: invokestatic 63	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(I)V
    //   277: ldc 65
    //   279: iconst_2
    //   280: ldc 94
    //   282: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto -146 -> 139
    //   288: astore 5
    //   290: aload 4
    //   292: monitorexit
    //   293: aload 5
    //   295: athrow
    //   296: astore 4
    //   298: aload 6
    //   300: astore 5
    //   302: goto -75 -> 227
    //   305: astore 5
    //   307: aload 6
    //   309: astore 4
    //   311: aload 5
    //   313: astore 6
    //   315: goto -136 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	1
    //   0	318	1	paramBoolean	boolean
    //   0	318	2	paramLong	long
    //   17	216	5	localObject1	java.lang.Object
    //   240	6	5	localIOException	java.io.IOException
    //   288	6	5	localObject2	java.lang.Object
    //   300	1	5	localException1	java.lang.Exception
    //   305	7	5	localException2	java.lang.Exception
    //   10	82	6	localFileOutputStream	java.io.FileOutputStream
    //   173	135	6	localException3	java.lang.Exception
    //   313	1	6	localObject3	java.lang.Object
    //   13	163	7	localObject4	java.lang.Object
    //   30	43	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   91	96	156	java/io/IOException
    //   19	32	173	java/lang/Exception
    //   36	44	173	java/lang/Exception
    //   48	54	173	java/lang/Exception
    //   58	64	173	java/lang/Exception
    //   68	79	173	java/lang/Exception
    //   200	205	208	java/io/IOException
    //   19	32	225	finally
    //   36	44	225	finally
    //   48	54	225	finally
    //   58	64	225	finally
    //   68	79	225	finally
    //   183	195	225	finally
    //   232	237	240	java/io/IOException
    //   147	155	288	finally
    //   290	293	288	finally
    //   79	86	296	finally
    //   79	86	305	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.1
 * JD-Core Version:    0.7.0.1
 */