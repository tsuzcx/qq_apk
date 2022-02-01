package com.tencent.luggage.wxa.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a
{
  /* Error */
  public static ByteBuffer a(java.io.InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 9
    //   3: iload_1
    //   4: ifne +24 -> 28
    //   7: aload_0
    //   8: astore 9
    //   10: aload_0
    //   11: invokevirtual 18	java/io/InputStream:markSupported	()Z
    //   14: ifne +14 -> 28
    //   17: aload_0
    //   18: invokestatic 23	com/tencent/luggage/wxa/e/e:a	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   21: astore 9
    //   23: aload 9
    //   25: invokestatic 27	com/tencent/luggage/wxa/e/e:b	(Ljava/io/InputStream;)V
    //   28: aload 9
    //   30: ifnonnull +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: sipush 10000
    //   38: newarray byte
    //   40: astore 10
    //   42: ldc 28
    //   44: invokestatic 34	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   47: astore 8
    //   49: aload 8
    //   51: invokestatic 40	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   54: invokevirtual 44	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   57: pop
    //   58: iconst_0
    //   59: istore 5
    //   61: ldc 28
    //   63: istore_3
    //   64: iconst_0
    //   65: istore_2
    //   66: aload 8
    //   68: astore_0
    //   69: aload 9
    //   71: aload 10
    //   73: invokevirtual 48	java/io/InputStream:read	([B)I
    //   76: istore 6
    //   78: iload 5
    //   80: iload 6
    //   82: iadd
    //   83: istore 5
    //   85: iload_3
    //   86: istore 4
    //   88: aload 8
    //   90: astore 7
    //   92: iload 5
    //   94: iload_3
    //   95: if_icmple +23 -> 118
    //   98: aload 8
    //   100: astore_0
    //   101: aload 8
    //   103: invokestatic 51	com/tencent/luggage/wxa/e/a:a	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   106: astore 7
    //   108: aload 7
    //   110: astore_0
    //   111: aload 7
    //   113: invokevirtual 55	java/nio/ByteBuffer:capacity	()I
    //   116: istore 4
    //   118: iload 6
    //   120: ifge +49 -> 169
    //   123: aload 7
    //   125: astore_0
    //   126: aload 7
    //   128: iconst_0
    //   129: invokevirtual 59	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   132: pop
    //   133: iload_1
    //   134: ifeq +11 -> 145
    //   137: aload 9
    //   139: invokevirtual 63	java/io/InputStream:close	()V
    //   142: aload 7
    //   144: areturn
    //   145: aload 9
    //   147: invokevirtual 66	java/io/InputStream:reset	()V
    //   150: aload 7
    //   152: areturn
    //   153: astore_0
    //   154: ldc 68
    //   156: aload_0
    //   157: ldc 70
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 7
    //   168: areturn
    //   169: aload 7
    //   171: astore_0
    //   172: aload 7
    //   174: iload_2
    //   175: invokevirtual 59	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   178: pop
    //   179: aload 7
    //   181: astore_0
    //   182: aload 7
    //   184: aload 10
    //   186: iconst_0
    //   187: iload 6
    //   189: invokevirtual 79	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   192: pop
    //   193: iload_2
    //   194: iload 6
    //   196: iadd
    //   197: istore_2
    //   198: iload 4
    //   200: istore_3
    //   201: aload 7
    //   203: astore 8
    //   205: goto -139 -> 66
    //   208: astore_0
    //   209: goto +99 -> 308
    //   212: astore 7
    //   214: ldc 68
    //   216: aload 7
    //   218: ldc 81
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: iload_1
    //   228: ifeq +10 -> 238
    //   231: aload 9
    //   233: invokevirtual 63	java/io/InputStream:close	()V
    //   236: aload_0
    //   237: areturn
    //   238: aload 9
    //   240: invokevirtual 66	java/io/InputStream:reset	()V
    //   243: aload_0
    //   244: areturn
    //   245: astore 7
    //   247: ldc 68
    //   249: aload 7
    //   251: ldc 70
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_0
    //   261: areturn
    //   262: astore_0
    //   263: ldc 68
    //   265: aload_0
    //   266: ldc 83
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: iload_1
    //   276: ifeq +10 -> 286
    //   279: aload 9
    //   281: invokevirtual 63	java/io/InputStream:close	()V
    //   284: aconst_null
    //   285: areturn
    //   286: aload 9
    //   288: invokevirtual 66	java/io/InputStream:reset	()V
    //   291: aconst_null
    //   292: areturn
    //   293: astore_0
    //   294: ldc 68
    //   296: aload_0
    //   297: ldc 70
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aconst_null
    //   307: areturn
    //   308: iload_1
    //   309: ifeq +11 -> 320
    //   312: aload 9
    //   314: invokevirtual 63	java/io/InputStream:close	()V
    //   317: goto +26 -> 343
    //   320: aload 9
    //   322: invokevirtual 66	java/io/InputStream:reset	()V
    //   325: goto +18 -> 343
    //   328: astore 7
    //   330: ldc 68
    //   332: aload 7
    //   334: ldc 70
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 75	com/tencent/luggage/wxa/c/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: goto +5 -> 348
    //   346: aload_0
    //   347: athrow
    //   348: goto -2 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramInputStream	java.io.InputStream
    //   0	351	1	paramBoolean	boolean
    //   65	133	2	i	int
    //   63	138	3	j	int
    //   86	113	4	k	int
    //   59	37	5	m	int
    //   76	121	6	n	int
    //   90	112	7	localObject1	Object
    //   212	5	7	localBufferOverflowException	java.nio.BufferOverflowException
    //   245	5	7	localException1	java.lang.Exception
    //   328	5	7	localException2	java.lang.Exception
    //   47	157	8	localObject2	Object
    //   1	320	9	localInputStream	java.io.InputStream
    //   40	145	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   137	142	153	java/lang/Exception
    //   145	150	153	java/lang/Exception
    //   69	78	208	finally
    //   101	108	208	finally
    //   111	118	208	finally
    //   126	133	208	finally
    //   172	179	208	finally
    //   182	193	208	finally
    //   214	227	208	finally
    //   263	275	208	finally
    //   69	78	212	java/nio/BufferOverflowException
    //   101	108	212	java/nio/BufferOverflowException
    //   111	118	212	java/nio/BufferOverflowException
    //   126	133	212	java/nio/BufferOverflowException
    //   172	179	212	java/nio/BufferOverflowException
    //   182	193	212	java/nio/BufferOverflowException
    //   231	236	245	java/lang/Exception
    //   238	243	245	java/lang/Exception
    //   69	78	262	java/io/IOException
    //   101	108	262	java/io/IOException
    //   111	118	262	java/io/IOException
    //   126	133	262	java/io/IOException
    //   172	179	262	java/io/IOException
    //   182	193	262	java/io/IOException
    //   279	284	293	java/lang/Exception
    //   286	291	293	java/lang/Exception
    //   312	317	328	java/lang/Exception
    //   320	325	328	java/lang/Exception
  }
  
  private static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramByteBuffer.capacity() + 100000);
    localByteBuffer.order(ByteOrder.nativeOrder());
    paramByteBuffer.position(0);
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.e.a
 * JD-Core Version:    0.7.0.1
 */