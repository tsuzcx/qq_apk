package com.tencent.luggage.wxa.f;

import android.media.ImageReader.OnImageAvailableListener;

class c$4
  implements ImageReader.OnImageAvailableListener
{
  c$4(c paramc) {}
  
  /* Error */
  public void onImageAvailable(android.media.ImageReader paramImageReader)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 26	android/media/ImageReader:acquireNextImage	()Landroid/media/Image;
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore_1
    //   12: aload 6
    //   14: invokevirtual 32	android/media/Image:getFormat	()I
    //   17: sipush 256
    //   20: if_icmpne +61 -> 81
    //   23: aload 5
    //   25: astore_1
    //   26: aload 6
    //   28: invokevirtual 36	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   31: iconst_0
    //   32: aaload
    //   33: invokevirtual 42	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   36: astore 7
    //   38: aload 5
    //   40: astore_1
    //   41: aload 7
    //   43: invokevirtual 47	java/nio/ByteBuffer:remaining	()I
    //   46: newarray byte
    //   48: astore 8
    //   50: aload 5
    //   52: astore_1
    //   53: aload 7
    //   55: aload 8
    //   57: invokevirtual 51	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   60: pop
    //   61: aload 5
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   68: getfield 57	com/tencent/luggage/wxa/f/c:f	Lcom/tencent/luggage/wxa/f/i$a;
    //   71: aload 8
    //   73: invokeinterface 62 2 0
    //   78: goto +188 -> 266
    //   81: aload 5
    //   83: astore_1
    //   84: aload 6
    //   86: invokestatic 65	com/tencent/luggage/wxa/f/c:a	(Landroid/media/Image;)[B
    //   89: astore 7
    //   91: aload 7
    //   93: ifnonnull +14 -> 107
    //   96: aload 6
    //   98: ifnull +8 -> 106
    //   101: aload 6
    //   103: invokevirtual 68	android/media/Image:close	()V
    //   106: return
    //   107: aload 5
    //   109: astore_1
    //   110: aload 6
    //   112: invokevirtual 71	android/media/Image:getWidth	()I
    //   115: istore_2
    //   116: aload 5
    //   118: astore_1
    //   119: aload 6
    //   121: invokevirtual 74	android/media/Image:getHeight	()I
    //   124: istore_3
    //   125: aload 5
    //   127: astore_1
    //   128: aload 6
    //   130: invokevirtual 36	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   133: iconst_0
    //   134: aaload
    //   135: astore 8
    //   137: aload 5
    //   139: astore_1
    //   140: aload 8
    //   142: invokevirtual 77	android/media/Image$Plane:getPixelStride	()I
    //   145: istore 4
    //   147: aload 5
    //   149: astore_1
    //   150: aload 8
    //   152: invokevirtual 80	android/media/Image$Plane:getRowStride	()I
    //   155: iload 4
    //   157: iload_2
    //   158: imul
    //   159: isub
    //   160: iload 4
    //   162: idiv
    //   163: istore 4
    //   165: aload 5
    //   167: astore_1
    //   168: aload_0
    //   169: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   172: invokestatic 84	com/tencent/luggage/wxa/f/c:c	(Lcom/tencent/luggage/wxa/f/c;)Z
    //   175: ifeq +62 -> 237
    //   178: aload 5
    //   180: astore_1
    //   181: aload_0
    //   182: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   185: getfield 88	com/tencent/luggage/wxa/f/c:g	Lcom/tencent/luggage/wxa/f/o;
    //   188: instanceof 90
    //   191: ifeq +46 -> 237
    //   194: aload 5
    //   196: astore_1
    //   197: aload_0
    //   198: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   201: getfield 88	com/tencent/luggage/wxa/f/c:g	Lcom/tencent/luggage/wxa/f/o;
    //   204: checkcast 90	com/tencent/luggage/wxa/f/l
    //   207: invokevirtual 94	com/tencent/luggage/wxa/f/l:b	()Lcom/tencent/luggage/wxa/sm/c;
    //   210: ifnull +27 -> 237
    //   213: aload 5
    //   215: astore_1
    //   216: aload_0
    //   217: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   220: getfield 88	com/tencent/luggage/wxa/f/c:g	Lcom/tencent/luggage/wxa/f/o;
    //   223: checkcast 90	com/tencent/luggage/wxa/f/l
    //   226: invokevirtual 94	com/tencent/luggage/wxa/f/l:b	()Lcom/tencent/luggage/wxa/sm/c;
    //   229: aload 7
    //   231: invokeinterface 99 2 0
    //   236: pop
    //   237: aload 5
    //   239: astore_1
    //   240: aload_0
    //   241: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   244: getfield 57	com/tencent/luggage/wxa/f/c:f	Lcom/tencent/luggage/wxa/f/i$a;
    //   247: aload 7
    //   249: iload_2
    //   250: iload 4
    //   252: iadd
    //   253: iload_3
    //   254: aload_0
    //   255: getfield 12	com/tencent/luggage/wxa/f/c$4:a	Lcom/tencent/luggage/wxa/f/c;
    //   258: invokestatic 103	com/tencent/luggage/wxa/f/c:d	(Lcom/tencent/luggage/wxa/f/c;)I
    //   261: invokeinterface 106 5 0
    //   266: aload 6
    //   268: ifnull +8 -> 276
    //   271: aload 6
    //   273: invokevirtual 68	android/media/Image:close	()V
    //   276: return
    //   277: astore 5
    //   279: goto +11 -> 290
    //   282: astore 5
    //   284: aload 5
    //   286: astore_1
    //   287: aload 5
    //   289: athrow
    //   290: aload 6
    //   292: ifnull +20 -> 312
    //   295: aload_1
    //   296: ifnull +11 -> 307
    //   299: aload 6
    //   301: invokevirtual 68	android/media/Image:close	()V
    //   304: goto +8 -> 312
    //   307: aload 6
    //   309: invokevirtual 68	android/media/Image:close	()V
    //   312: aload 5
    //   314: athrow
    //   315: astore_1
    //   316: goto -4 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	4
    //   0	319	1	paramImageReader	android.media.ImageReader
    //   115	138	2	i	int
    //   124	130	3	j	int
    //   145	108	4	k	int
    //   7	231	5	localObject1	Object
    //   277	1	5	localObject2	Object
    //   282	31	5	localThrowable	java.lang.Throwable
    //   4	304	6	localImage	android.media.Image
    //   36	212	7	localObject3	Object
    //   48	103	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	277	finally
    //   26	38	277	finally
    //   41	50	277	finally
    //   53	61	277	finally
    //   64	78	277	finally
    //   84	91	277	finally
    //   110	116	277	finally
    //   119	125	277	finally
    //   128	137	277	finally
    //   140	147	277	finally
    //   150	165	277	finally
    //   168	178	277	finally
    //   181	194	277	finally
    //   197	213	277	finally
    //   216	237	277	finally
    //   240	266	277	finally
    //   287	290	277	finally
    //   12	23	282	java/lang/Throwable
    //   26	38	282	java/lang/Throwable
    //   41	50	282	java/lang/Throwable
    //   53	61	282	java/lang/Throwable
    //   64	78	282	java/lang/Throwable
    //   84	91	282	java/lang/Throwable
    //   110	116	282	java/lang/Throwable
    //   119	125	282	java/lang/Throwable
    //   128	137	282	java/lang/Throwable
    //   140	147	282	java/lang/Throwable
    //   150	165	282	java/lang/Throwable
    //   168	178	282	java/lang/Throwable
    //   181	194	282	java/lang/Throwable
    //   197	213	282	java/lang/Throwable
    //   216	237	282	java/lang/Throwable
    //   240	266	282	java/lang/Throwable
    //   299	304	315	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.4
 * JD-Core Version:    0.7.0.1
 */