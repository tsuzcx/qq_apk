package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.jx.a;
import java.nio.ByteBuffer;

public class b
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 373;
  public static final String NAME = "canvasPutImageData";
  
  private int[] a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = com.tencent.luggage.wxa.pc.c.a(paramByteBuffer);
    int[] arrayOfInt = new int[paramByteBuffer.length / 4];
    int i = 0;
    int m;
    for (int j = 0; i < arrayOfInt.length; j = m + 1)
    {
      m = j + 1;
      j = paramByteBuffer[j];
      int k = m + 1;
      int n = paramByteBuffer[m];
      m = k + 1;
      arrayOfInt[i] = ((j & 0xFF) << 16 | (n & 0xFF) << 8 | paramByteBuffer[k] & 0xFF | (paramByteBuffer[m] & 0xFF) << 24);
      i += 1;
    }
    return arrayOfInt;
  }
  
  /* Error */
  public void a(com.tencent.luggage.wxa.jx.c paramc, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 29
    //   3: invokevirtual 35	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore 5
    //   8: aload_1
    //   9: ldc 37
    //   11: invokeinterface 42 2 0
    //   16: checkcast 37	com/tencent/luggage/wxa/kd/g
    //   19: aload_1
    //   20: aload_2
    //   21: invokeinterface 45 3 0
    //   26: astore 11
    //   28: aload 11
    //   30: ifnonnull +24 -> 54
    //   33: ldc 47
    //   35: ldc 49
    //   37: invokestatic 55	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_1
    //   41: iload_3
    //   42: aload_0
    //   43: ldc 57
    //   45: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokeinterface 64 3 0
    //   53: return
    //   54: aload 11
    //   56: aload_2
    //   57: ldc 66
    //   59: iconst_0
    //   60: invokevirtual 70	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   63: invokeinterface 75 2 0
    //   68: iload 5
    //   70: invokeinterface 80 2 0
    //   75: astore 11
    //   77: aload 11
    //   79: ifnonnull +36 -> 115
    //   82: ldc 47
    //   84: ldc 82
    //   86: iconst_1
    //   87: anewarray 84	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: iload 5
    //   94: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 93	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_1
    //   102: iload_3
    //   103: aload_0
    //   104: ldc 95
    //   106: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokeinterface 64 3 0
    //   114: return
    //   115: aload 11
    //   117: instanceof 97
    //   120: ifne +36 -> 156
    //   123: ldc 47
    //   125: ldc 99
    //   127: iconst_1
    //   128: anewarray 84	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload 5
    //   135: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokestatic 93	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_1
    //   143: iload_3
    //   144: aload_0
    //   145: ldc 101
    //   147: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokeinterface 64 3 0
    //   155: return
    //   156: aload 11
    //   158: checkcast 97	com/tencent/luggage/wxa/kt/b
    //   161: ldc 103
    //   163: invokevirtual 106	com/tencent/luggage/wxa/kt/b:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   166: checkcast 103	android/view/View
    //   169: astore 11
    //   171: aload 11
    //   173: instanceof 108
    //   176: ifne +36 -> 212
    //   179: ldc 47
    //   181: ldc 110
    //   183: iconst_1
    //   184: anewarray 84	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: iload 5
    //   191: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 113	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_1
    //   199: iload_3
    //   200: aload_0
    //   201: ldc 101
    //   203: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokeinterface 64 3 0
    //   211: return
    //   212: invokestatic 118	com/tencent/luggage/wxa/pc/g:a	()F
    //   215: fstore 4
    //   217: aload_2
    //   218: ldc 120
    //   220: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   223: istore 8
    //   225: aload_2
    //   226: ldc 125
    //   228: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   231: istore 10
    //   233: aload_2
    //   234: ldc 127
    //   236: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   239: istore 7
    //   241: aload_2
    //   242: ldc 129
    //   244: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   247: istore 9
    //   249: iload 8
    //   251: i2f
    //   252: fload 4
    //   254: fmul
    //   255: invokestatic 135	java/lang/Math:round	(F)I
    //   258: pop
    //   259: iload 10
    //   261: i2f
    //   262: fload 4
    //   264: fmul
    //   265: invokestatic 135	java/lang/Math:round	(F)I
    //   268: pop
    //   269: iload 7
    //   271: i2f
    //   272: fload 4
    //   274: fmul
    //   275: invokestatic 135	java/lang/Math:round	(F)I
    //   278: pop
    //   279: iload 9
    //   281: i2f
    //   282: fload 4
    //   284: fmul
    //   285: invokestatic 135	java/lang/Math:round	(F)I
    //   288: pop
    //   289: iload 7
    //   291: ifeq +309 -> 600
    //   294: iload 9
    //   296: ifne +6 -> 302
    //   299: goto +301 -> 600
    //   302: iload 8
    //   304: istore 6
    //   306: iload 7
    //   308: istore 5
    //   310: iload 7
    //   312: ifge +15 -> 327
    //   315: iload 8
    //   317: iload 7
    //   319: iadd
    //   320: istore 6
    //   322: iload 7
    //   324: ineg
    //   325: istore 5
    //   327: iload 10
    //   329: istore 8
    //   331: iload 9
    //   333: istore 7
    //   335: iload 9
    //   337: ifge +15 -> 352
    //   340: iload 10
    //   342: iload 9
    //   344: iadd
    //   345: istore 8
    //   347: iload 9
    //   349: ineg
    //   350: istore 7
    //   352: aload_2
    //   353: ldc 137
    //   355: invokevirtual 141	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   358: astore_2
    //   359: aload_2
    //   360: instanceof 143
    //   363: ifne +24 -> 387
    //   366: ldc 47
    //   368: ldc 145
    //   370: invokestatic 147	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_1
    //   374: iload_3
    //   375: aload_0
    //   376: ldc 149
    //   378: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   381: invokeinterface 64 3 0
    //   386: return
    //   387: aload_2
    //   388: checkcast 143	java/nio/ByteBuffer
    //   391: astore 12
    //   393: new 151	org/json/JSONArray
    //   396: dup
    //   397: invokespecial 152	org/json/JSONArray:<init>	()V
    //   400: astore_2
    //   401: aload_0
    //   402: aload 12
    //   404: invokespecial 154	com/tencent/luggage/wxa/kq/b:a	(Ljava/nio/ByteBuffer;)[I
    //   407: astore 12
    //   409: new 31	org/json/JSONObject
    //   412: dup
    //   413: invokespecial 155	org/json/JSONObject:<init>	()V
    //   416: astore 13
    //   418: new 151	org/json/JSONArray
    //   421: dup
    //   422: invokespecial 152	org/json/JSONArray:<init>	()V
    //   425: astore 14
    //   427: aload 14
    //   429: iload 6
    //   431: invokevirtual 159	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   434: pop
    //   435: aload 14
    //   437: iload 8
    //   439: invokevirtual 159	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   442: pop
    //   443: aload 14
    //   445: iload 5
    //   447: invokevirtual 159	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   450: pop
    //   451: aload 14
    //   453: iload 7
    //   455: invokevirtual 159	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   458: pop
    //   459: aload 14
    //   461: aload 12
    //   463: iload 5
    //   465: iload 7
    //   467: getstatic 165	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   470: invokestatic 171	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   473: invokevirtual 174	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   476: pop
    //   477: aload 13
    //   479: ldc 176
    //   481: ldc 178
    //   483: invokevirtual 181	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   486: pop
    //   487: aload 13
    //   489: ldc 137
    //   491: aload 14
    //   493: invokevirtual 181	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   496: pop
    //   497: aload_2
    //   498: aload 13
    //   500: invokevirtual 174	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   503: pop
    //   504: aload 11
    //   506: checkcast 108	com/tencent/luggage/wxa/ji/b
    //   509: astore 11
    //   511: aload 11
    //   513: aload_2
    //   514: new 183	com/tencent/luggage/wxa/kq/b$1
    //   517: dup
    //   518: aload_0
    //   519: aload_1
    //   520: iload_3
    //   521: invokespecial 186	com/tencent/luggage/wxa/kq/b$1:<init>	(Lcom/tencent/luggage/wxa/kq/b;Lcom/tencent/luggage/wxa/jx/c;I)V
    //   524: invokeinterface 189 3 0
    //   529: aload 11
    //   531: invokeinterface 191 1 0
    //   536: return
    //   537: astore_2
    //   538: ldc 47
    //   540: ldc 193
    //   542: iconst_1
    //   543: anewarray 84	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: aload_2
    //   549: aastore
    //   550: invokestatic 93	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   553: aload_1
    //   554: iload_3
    //   555: aload_0
    //   556: ldc 195
    //   558: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   561: invokeinterface 64 3 0
    //   566: return
    //   567: astore_2
    //   568: ldc 47
    //   570: ldc 197
    //   572: iconst_1
    //   573: anewarray 84	java/lang/Object
    //   576: dup
    //   577: iconst_0
    //   578: aload_2
    //   579: invokestatic 203	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   582: aastore
    //   583: invokestatic 113	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   586: aload_1
    //   587: iload_3
    //   588: aload_0
    //   589: ldc 205
    //   591: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   594: invokeinterface 64 3 0
    //   599: return
    //   600: ldc 47
    //   602: ldc 207
    //   604: iconst_3
    //   605: anewarray 84	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: iload 7
    //   612: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload 9
    //   620: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   623: aastore
    //   624: dup
    //   625: iconst_2
    //   626: iload 5
    //   628: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   631: aastore
    //   632: invokestatic 113	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload_1
    //   636: iload_3
    //   637: aload_0
    //   638: ldc 209
    //   640: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   643: invokeinterface 64 3 0
    //   648: return
    //   649: astore_2
    //   650: ldc 47
    //   652: ldc 211
    //   654: iconst_1
    //   655: anewarray 84	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: aload_2
    //   661: invokestatic 203	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   664: aastore
    //   665: invokestatic 113	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   668: aload_1
    //   669: iload_3
    //   670: aload_0
    //   671: ldc 213
    //   673: invokevirtual 61	com/tencent/luggage/wxa/kq/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokeinterface 64 3 0
    //   681: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	b
    //   0	682	1	paramc	com.tencent.luggage.wxa.jx.c
    //   0	682	2	paramJSONObject	org.json.JSONObject
    //   0	682	3	paramInt	int
    //   215	68	4	f	float
    //   6	621	5	i	int
    //   304	126	6	j	int
    //   239	372	7	k	int
    //   223	215	8	m	int
    //   247	372	9	n	int
    //   231	114	10	i1	int
    //   26	504	11	localObject1	java.lang.Object
    //   391	71	12	localObject2	java.lang.Object
    //   416	83	13	localJSONObject	org.json.JSONObject
    //   425	67	14	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   418	497	537	org/json/JSONException
    //   352	386	567	org/json/JSONException
    //   387	393	567	org/json/JSONException
    //   0	8	649	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.b
 * JD-Core Version:    0.7.0.1
 */