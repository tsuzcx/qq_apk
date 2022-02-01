package com.tencent.luggage.wxa.pi;

import com.tencent.luggage.wxa.sj.g;

class a$a
  implements g
{
  private volatile boolean b = false;
  
  private a$a(a parama) {}
  
  public String a()
  {
    return "WebsocketWriteThread";
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/luggage/wxa/pi/a$a:b	Z
    //   4: ifne +162 -> 166
    //   7: invokestatic 40	java/lang/Thread:interrupted	()Z
    //   10: ifne +156 -> 166
    //   13: aload_0
    //   14: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   17: invokestatic 45	com/tencent/luggage/wxa/pi/a:a	(Lcom/tencent/luggage/wxa/pi/a;)Lcom/tencent/luggage/wxa/ph/c;
    //   20: invokevirtual 49	com/tencent/luggage/wxa/ph/c:b	()Z
    //   23: ifeq -23 -> 0
    //   26: aload_0
    //   27: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   30: invokestatic 45	com/tencent/luggage/wxa/pi/a:a	(Lcom/tencent/luggage/wxa/pi/a;)Lcom/tencent/luggage/wxa/ph/c;
    //   33: getfield 53	com/tencent/luggage/wxa/ph/c:f	Ljava/util/concurrent/BlockingQueue;
    //   36: ldc2_w 54
    //   39: getstatic 61	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   42: invokeinterface 67 4 0
    //   47: checkcast 69	java/nio/ByteBuffer
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull -52 -> 0
    //   55: aload_0
    //   56: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   59: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   62: aload_1
    //   63: invokevirtual 76	java/nio/ByteBuffer:array	()[B
    //   66: iconst_0
    //   67: aload_1
    //   68: invokevirtual 80	java/nio/ByteBuffer:limit	()I
    //   71: invokevirtual 86	java/io/OutputStream:write	([BII)V
    //   74: aload_0
    //   75: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   78: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   81: invokevirtual 89	java/io/OutputStream:flush	()V
    //   84: goto -84 -> 0
    //   87: astore_1
    //   88: goto +181 -> 269
    //   91: astore_1
    //   92: goto +101 -> 193
    //   95: astore_1
    //   96: goto +135 -> 231
    //   99: aload_0
    //   100: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   103: invokestatic 45	com/tencent/luggage/wxa/pi/a:a	(Lcom/tencent/luggage/wxa/pi/a;)Lcom/tencent/luggage/wxa/ph/c;
    //   106: getfield 53	com/tencent/luggage/wxa/ph/c:f	Ljava/util/concurrent/BlockingQueue;
    //   109: invokeinterface 93 1 0
    //   114: astore_1
    //   115: aload_1
    //   116: invokeinterface 98 1 0
    //   121: ifeq +45 -> 166
    //   124: aload_1
    //   125: invokeinterface 102 1 0
    //   130: checkcast 69	java/nio/ByteBuffer
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   138: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   141: aload_2
    //   142: invokevirtual 76	java/nio/ByteBuffer:array	()[B
    //   145: iconst_0
    //   146: aload_2
    //   147: invokevirtual 80	java/nio/ByteBuffer:limit	()I
    //   150: invokevirtual 86	java/io/OutputStream:write	([BII)V
    //   153: aload_0
    //   154: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   157: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   160: invokevirtual 89	java/io/OutputStream:flush	()V
    //   163: goto -48 -> 115
    //   166: ldc 104
    //   168: ldc 106
    //   170: invokestatic 112	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   177: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 115	java/io/OutputStream:close	()V
    //   185: aload_0
    //   186: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   189: invokestatic 117	com/tencent/luggage/wxa/pi/a:c	(Lcom/tencent/luggage/wxa/pi/a;)V
    //   192: return
    //   193: aload_0
    //   194: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   197: aload_1
    //   198: invokestatic 120	com/tencent/luggage/wxa/pi/a:a	(Lcom/tencent/luggage/wxa/pi/a;Ljava/lang/Exception;)V
    //   201: ldc 104
    //   203: aload_1
    //   204: ldc 122
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 125	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: ldc 104
    //   215: ldc 106
    //   217: invokestatic 112	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   224: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   227: astore_1
    //   228: goto -47 -> 181
    //   231: aload_0
    //   232: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   235: aload_1
    //   236: invokestatic 120	com/tencent/luggage/wxa/pi/a:a	(Lcom/tencent/luggage/wxa/pi/a;Ljava/lang/Exception;)V
    //   239: ldc 104
    //   241: aload_1
    //   242: ldc 127
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 125	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc 104
    //   253: ldc 106
    //   255: invokestatic 112	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   262: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   265: astore_1
    //   266: goto -85 -> 181
    //   269: ldc 104
    //   271: ldc 106
    //   273: invokestatic 112	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   280: invokestatic 72	com/tencent/luggage/wxa/pi/a:b	(Lcom/tencent/luggage/wxa/pi/a;)Ljava/io/OutputStream;
    //   283: invokevirtual 115	java/io/OutputStream:close	()V
    //   286: aload_0
    //   287: getfield 14	com/tencent/luggage/wxa/pi/a$a:a	Lcom/tencent/luggage/wxa/pi/a;
    //   290: invokestatic 117	com/tencent/luggage/wxa/pi/a:c	(Lcom/tencent/luggage/wxa/pi/a;)V
    //   293: goto +5 -> 298
    //   296: aload_1
    //   297: athrow
    //   298: goto -2 -> 296
    //   301: astore_1
    //   302: goto -203 -> 99
    //   305: astore_1
    //   306: goto -121 -> 185
    //   309: astore_2
    //   310: goto -24 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	a
    //   50	18	1	localByteBuffer1	java.nio.ByteBuffer
    //   87	1	1	localObject1	Object
    //   91	1	1	localException	java.lang.Exception
    //   95	1	1	localIOException1	java.io.IOException
    //   114	183	1	localObject2	Object
    //   301	1	1	localInterruptedException	java.lang.InterruptedException
    //   305	1	1	localIOException2	java.io.IOException
    //   133	14	2	localByteBuffer2	java.nio.ByteBuffer
    //   309	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	51	87	finally
    //   55	84	87	finally
    //   99	115	87	finally
    //   115	163	87	finally
    //   193	213	87	finally
    //   231	251	87	finally
    //   0	51	91	java/lang/Exception
    //   55	84	91	java/lang/Exception
    //   99	115	91	java/lang/Exception
    //   115	163	91	java/lang/Exception
    //   0	51	95	java/io/IOException
    //   55	84	95	java/io/IOException
    //   99	115	95	java/io/IOException
    //   115	163	95	java/io/IOException
    //   0	51	301	java/lang/InterruptedException
    //   55	84	301	java/lang/InterruptedException
    //   173	181	305	java/io/IOException
    //   181	185	305	java/io/IOException
    //   220	228	305	java/io/IOException
    //   258	266	305	java/io/IOException
    //   276	286	309	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pi.a.a
 * JD-Core Version:    0.7.0.1
 */