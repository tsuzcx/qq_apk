package com.tencent.luggage.wxa.dq;

import android.view.View;
import com.tencent.luggage.wxa.ro.b;

class c$6$1
  implements Runnable
{
  c$6$1(c.6 param6, int paramInt1, int paramInt2, b paramb, View paramView, int paramInt3, int paramInt4) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   4: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   7: invokevirtual 55	com/tencent/luggage/wxa/dq/c:aJ	()Landroid/graphics/Bitmap;
    //   10: astore_3
    //   11: goto +87 -> 98
    //   14: astore_3
    //   15: ldc 57
    //   17: ldc 59
    //   19: iconst_3
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_3
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: aload_0
    //   30: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   33: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   36: invokevirtual 63	com/tencent/luggage/wxa/dq/c:getAppId	()Ljava/lang/String;
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: aload_0
    //   43: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   46: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   49: invokevirtual 66	com/tencent/luggage/wxa/dq/c:an	()Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: goto +40 -> 96
    //   59: ldc 57
    //   61: ldc 73
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   73: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   76: invokevirtual 63	com/tencent/luggage/wxa/dq/c:getAppId	()Ljava/lang/String;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_0
    //   83: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   86: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   89: invokevirtual 66	com/tencent/luggage/wxa/dq/c:an	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +141 -> 240
    //   102: aload_3
    //   103: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   106: ifle +134 -> 240
    //   109: aload_3
    //   110: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   113: ifle +127 -> 240
    //   116: aload_3
    //   117: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   120: aload_0
    //   121: getfield 23	com/tencent/luggage/wxa/dq/c$6$1:a	I
    //   124: invokestatic 88	java/lang/Math:min	(II)I
    //   127: istore_1
    //   128: aload_3
    //   129: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   132: aload_0
    //   133: getfield 25	com/tencent/luggage/wxa/dq/c$6$1:b	I
    //   136: invokestatic 88	java/lang/Math:min	(II)I
    //   139: istore_2
    //   140: aload_0
    //   141: getfield 27	com/tencent/luggage/wxa/dq/c$6$1:c	Lcom/tencent/luggage/wxa/ro/b;
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_3
    //   151: iconst_0
    //   152: iconst_0
    //   153: iload_1
    //   154: iload_2
    //   155: invokestatic 92	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   158: aastore
    //   159: invokeinterface 97 2 0
    //   164: aload_3
    //   165: invokevirtual 100	android/graphics/Bitmap:recycle	()V
    //   168: goto +142 -> 310
    //   171: astore 4
    //   173: goto +60 -> 233
    //   176: ldc 57
    //   178: ldc 102
    //   180: iconst_2
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   190: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   193: invokevirtual 63	com/tencent/luggage/wxa/dq/c:getAppId	()Ljava/lang/String;
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: aload_0
    //   200: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   203: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   206: invokevirtual 66	com/tencent/luggage/wxa/dq/c:an	()Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_0
    //   214: getfield 27	com/tencent/luggage/wxa/dq/c$6$1:c	Lcom/tencent/luggage/wxa/ro/b;
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aconst_null
    //   224: aastore
    //   225: invokeinterface 97 2 0
    //   230: goto -66 -> 164
    //   233: aload_3
    //   234: invokevirtual 100	android/graphics/Bitmap:recycle	()V
    //   237: aload 4
    //   239: athrow
    //   240: iconst_m1
    //   241: istore_2
    //   242: aload_3
    //   243: ifnonnull +8 -> 251
    //   246: iconst_m1
    //   247: istore_1
    //   248: goto +8 -> 256
    //   251: aload_3
    //   252: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   255: istore_1
    //   256: aload_3
    //   257: ifnonnull +6 -> 263
    //   260: goto +8 -> 268
    //   263: aload_3
    //   264: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   267: istore_2
    //   268: ldc 57
    //   270: ldc 104
    //   272: iconst_2
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: iload_1
    //   279: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: iload_2
    //   286: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: invokestatic 71	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_0
    //   294: getfield 27	com/tencent/luggage/wxa/dq/c$6$1:c	Lcom/tencent/luggage/wxa/ro/b;
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aconst_null
    //   304: aastore
    //   305: invokeinterface 97 2 0
    //   310: aload_0
    //   311: getfield 21	com/tencent/luggage/wxa/dq/c$6$1:g	Lcom/tencent/luggage/wxa/dq/c$6;
    //   314: getfield 49	com/tencent/luggage/wxa/dq/c$6:a	Lcom/tencent/luggage/wxa/dq/c;
    //   317: new 112	com/tencent/luggage/wxa/dq/c$6$1$1
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 115	com/tencent/luggage/wxa/dq/c$6$1$1:<init>	(Lcom/tencent/luggage/wxa/dq/c$6$1;)V
    //   325: invokevirtual 118	com/tencent/luggage/wxa/dq/c:a	(Lcom/tencent/luggage/wxa/jx/f$e;)V
    //   328: return
    //   329: astore_3
    //   330: goto -271 -> 59
    //   333: astore 4
    //   335: goto -159 -> 176
    //   338: astore_3
    //   339: goto -29 -> 310
    //   342: astore_3
    //   343: goto -106 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	1
    //   127	152	1	i	int
    //   139	147	2	j	int
    //   10	1	3	localBitmap1	android.graphics.Bitmap
    //   14	12	3	localNullPointerException	java.lang.NullPointerException
    //   97	167	3	localBitmap2	android.graphics.Bitmap
    //   329	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   338	1	3	localThrowable1	java.lang.Throwable
    //   342	1	3	localThrowable2	java.lang.Throwable
    //   171	67	4	localObject	Object
    //   333	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   0	11	14	java/lang/NullPointerException
    //   140	164	171	finally
    //   176	230	171	finally
    //   0	11	329	java/lang/OutOfMemoryError
    //   140	164	333	java/lang/OutOfMemoryError
    //   164	168	338	java/lang/Throwable
    //   233	237	342	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.c.6.1
 * JD-Core Version:    0.7.0.1
 */