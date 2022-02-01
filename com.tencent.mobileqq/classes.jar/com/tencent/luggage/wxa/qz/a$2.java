package com.tencent.luggage.wxa.qz;

import android.os.Handler.Callback;

final class a$2
  implements Handler.Callback
{
  boolean a = false;
  long b = 0L;
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 28	com/tencent/luggage/wxa/qz/a:a	(Z)Z
    //   4: pop
    //   5: invokestatic 34	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 38	java/lang/Runtime:totalMemory	()J
    //   13: lstore 6
    //   15: aload_1
    //   16: invokevirtual 41	java/lang/Runtime:freeMemory	()J
    //   19: lstore_2
    //   20: aload_1
    //   21: invokevirtual 44	java/lang/Runtime:maxMemory	()J
    //   24: lstore 4
    //   26: lload 6
    //   28: lload_2
    //   29: lsub
    //   30: lstore 6
    //   32: ldc 46
    //   34: ldc 48
    //   36: iconst_3
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: lload 6
    //   44: invokestatic 51	com/tencent/luggage/wxa/qz/a:a	(J)Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: lload_2
    //   51: invokestatic 51	com/tencent/luggage/wxa/qz/a:a	(J)Ljava/lang/String;
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: lload 4
    //   59: invokestatic 51	com/tencent/luggage/wxa/qz/a:a	(J)Ljava/lang/String;
    //   62: aastore
    //   63: invokestatic 57	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: getfield 16	com/tencent/luggage/wxa/qz/a$2:a	Z
    //   70: ifne +237 -> 307
    //   73: lload 6
    //   75: ldc2_w 58
    //   78: lcmp
    //   79: ifle +228 -> 307
    //   82: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   85: lstore_2
    //   86: lload_2
    //   87: aload_0
    //   88: getfield 18	com/tencent/luggage/wxa/qz/a$2:b	J
    //   91: lsub
    //   92: ldc2_w 65
    //   95: lcmp
    //   96: ifle +13 -> 109
    //   99: invokestatic 69	java/lang/System:gc	()V
    //   102: aload_0
    //   103: lload_2
    //   104: putfield 18	com/tencent/luggage/wxa/qz/a$2:b	J
    //   107: iconst_1
    //   108: ireturn
    //   109: aconst_null
    //   110: astore 10
    //   112: aconst_null
    //   113: astore 8
    //   115: aload 8
    //   117: astore_1
    //   118: new 71	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   125: astore 9
    //   127: aload 8
    //   129: astore_1
    //   130: aload 9
    //   132: invokestatic 77	com/tencent/luggage/wxa/hz/a:d	()Ljava/lang/String;
    //   135: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 8
    //   141: astore_1
    //   142: aload 9
    //   144: ldc 83
    //   146: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: astore_1
    //   153: new 85	java/io/PrintWriter
    //   156: dup
    //   157: new 87	java/util/zip/GZIPOutputStream
    //   160: dup
    //   161: new 89	java/io/FileOutputStream
    //   164: dup
    //   165: aload 9
    //   167: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   173: invokespecial 98	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   176: invokespecial 99	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   179: astore 8
    //   181: aload 8
    //   183: lconst_0
    //   184: iconst_m1
    //   185: invokestatic 102	com/tencent/luggage/wxa/qz/a:a	(Ljava/io/PrintWriter;JI)V
    //   188: aload 8
    //   190: invokestatic 107	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   193: goto +54 -> 247
    //   196: astore 9
    //   198: aload 8
    //   200: astore_1
    //   201: aload 9
    //   203: astore 8
    //   205: goto +95 -> 300
    //   208: astore_1
    //   209: aload_1
    //   210: astore 9
    //   212: goto +14 -> 226
    //   215: astore 8
    //   217: goto +83 -> 300
    //   220: astore 9
    //   222: aload 10
    //   224: astore 8
    //   226: aload 8
    //   228: astore_1
    //   229: ldc 46
    //   231: aload 9
    //   233: ldc 109
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload 8
    //   244: invokestatic 107	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   247: new 71	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   254: astore_1
    //   255: aload_1
    //   256: invokestatic 77	com/tencent/luggage/wxa/hz/a:d	()Ljava/lang/String;
    //   259: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: ldc 114
    //   266: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_1
    //   271: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 119	android/os/Debug:dumpHprofData	(Ljava/lang/String;)V
    //   277: goto +16 -> 293
    //   280: astore_1
    //   281: ldc 46
    //   283: aload_1
    //   284: ldc 109
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_0
    //   294: iconst_1
    //   295: putfield 16	com/tencent/luggage/wxa/qz/a$2:a	Z
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_1
    //   301: invokestatic 107	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   304: aload 8
    //   306: athrow
    //   307: iconst_1
    //   308: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	2
    //   0	309	1	paramMessage	android.os.Message
    //   19	85	2	l1	long
    //   24	34	4	l2	long
    //   13	61	6	l3	long
    //   113	91	8	localObject1	Object
    //   215	1	8	localObject2	Object
    //   224	81	8	localObject3	Object
    //   125	41	9	localStringBuilder	java.lang.StringBuilder
    //   196	6	9	localObject4	Object
    //   210	1	9	localMessage	android.os.Message
    //   220	12	9	localException	java.lang.Exception
    //   110	113	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   181	188	196	finally
    //   181	188	208	java/lang/Exception
    //   118	127	215	finally
    //   130	139	215	finally
    //   142	150	215	finally
    //   153	181	215	finally
    //   229	242	215	finally
    //   118	127	220	java/lang/Exception
    //   130	139	220	java/lang/Exception
    //   142	150	220	java/lang/Exception
    //   153	181	220	java/lang/Exception
    //   247	277	280	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.a.2
 * JD-Core Version:    0.7.0.1
 */