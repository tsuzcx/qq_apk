package com.tencent.mm.plugin.sight.base;

import androidx.annotation.WorkerThread;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;

public class a
{
  public static final int a = b.d;
  
  @WorkerThread
  public static String a(a.a parama)
  {
    if (parama == null)
    {
      o.b("WMPF.RemuxHelper", "remuxIfNeed, compress request is null");
      return null;
    }
    String str = parama.a;
    if (b(str) != -50006)
    {
      o.d("WMPF.RemuxHelper", "STATUS_NO_NEED_TO_REMUX");
      return str;
    }
    o.d("WMPF.RemuxHelper", "compress info: filePath: %s, suggestWidth: %d, suggestHeight: %d, outputWidth: %d, outputHeight: %d, remuxBitRate %d", new Object[] { str, Integer.valueOf(parama.b), Integer.valueOf(parama.c), Integer.valueOf(parama.d), Integer.valueOf(parama.e), Integer.valueOf(parama.f) });
    int i;
    int m;
    int k;
    if ((parama.d != 0) && (parama.e != 0))
    {
      i = parama.d;
      m = parama.e;
      j = i;
      if (i % 2 != 0) {
        j = i + 1;
      }
      k = j;
      i = m;
      if (m % 2 != 0)
      {
        i = m + 1;
        k = j;
      }
    }
    for (;;)
    {
      break;
      if (parama.b > 0) {
        i = parama.b;
      } else {
        i = 720;
      }
      if (parama.c > 0) {
        j = parama.c;
      } else {
        j = 540;
      }
      Object localObject = c(str);
      if (localObject == null) {
        k = 0;
      } else {
        k = ((a.b)localObject).f;
      }
      if (localObject == null) {
        m = 0;
      } else {
        m = ((a.b)localObject).g;
      }
      o.d("WMPF.RemuxHelper", "sourceWidth: %d, sourceHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      localObject = new int[2];
      com.tencent.luggage.wxa.qs.a.a(str, (int[])localObject, i, j);
      k = localObject[0];
      i = localObject[1];
    }
    o.d("WMPF.RemuxHelper", "outputWidth: %d, outputHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
    if (parama.f > 0) {
      j = parama.f;
    } else {
      j = b.d;
    }
    float f;
    if (parama.g > 0.0F) {
      f = parama.g;
    } else {
      f = b.e;
    }
    if (!k.h(com.tencent.luggage.wxa.qs.a.b())) {
      k.g(com.tencent.luggage.wxa.qs.a.b());
    }
    parama = new StringBuilder();
    parama.append(com.tencent.luggage.wxa.qs.a.b());
    parama.append("wxa.");
    parama.append(System.currentTimeMillis());
    parama.append(".mp4");
    parama = parama.toString();
    o.d("WMPF.RemuxHelper", "soft remux mode.");
    int j = SightVideoJNI.a(str, parama, k, i, j, b.c, 8, 2, 25.0F, f, null, 0, false, 0, 51);
    if (j < 0) {
      o.d("WMPF.RemuxHelper", "STATUS_SOFT_REMUX_FAIL");
    } else {
      o.d("WMPF.RemuxHelper", "STATUS_SOFT_REMUX_SECCESS");
    }
    o.d("WMPF.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { str, parama, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
    return parama;
  }
  
  @WorkerThread
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      o.b("WMPF.RemuxHelper", "remuxIfNeed, filePath is null");
      return null;
    }
    return a(new a.a(paramString, 720, 540, 0, 0, b.d, b.e));
  }
  
  public static int b(String paramString)
  {
    boolean bool = com.tencent.luggage.wxa.qs.a.a(paramString);
    int j = 1;
    o.d("WMPF.RemuxHelper", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
    int i;
    if (bool)
    {
      i = SightVideoJNI.a(paramString, 660, 500, 26214400, 1200000.0D, 1000000);
      o.d("WMPF.RemuxHelper", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
    }
    else
    {
      o.d("WMPF.RemuxHelper", "fileLength = %d", new Object[] { Integer.valueOf((int)k.c(paramString)) });
      i = 1;
    }
    switch (i)
    {
    default: 
      o.b("WMPF.RemuxHelper", "unknown check type");
      return -50001;
    case 0: 
      return -50006;
    case -6: 
    case -5: 
    case -4: 
    case -3: 
    case -2: 
    case -1: 
      j = -50002;
    }
    return j;
  }
  
  /* Error */
  public static a.b c(String paramString)
  {
    // Byte code:
    //   0: new 178	com/tencent/luggage/wxa/hh/b
    //   3: dup
    //   4: invokespecial 179	com/tencent/luggage/wxa/hh/b:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: aload_0
    //   12: invokevirtual 185	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   15: aload 10
    //   17: bipush 24
    //   19: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   22: iconst_0
    //   23: invokestatic 194	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   26: istore_3
    //   27: aload 10
    //   29: bipush 12
    //   31: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   34: astore 11
    //   36: aload 10
    //   38: bipush 9
    //   40: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   43: iconst_0
    //   44: invokestatic 194	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   47: istore 4
    //   49: aload_0
    //   50: invokestatic 170	com/tencent/luggage/wxa/rt/k:c	(Ljava/lang/String;)J
    //   53: lstore 8
    //   55: aload 10
    //   57: bipush 18
    //   59: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: iconst_0
    //   63: invokestatic 194	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   66: istore 5
    //   68: aload 10
    //   70: bipush 19
    //   72: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   75: iconst_0
    //   76: invokestatic 194	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   79: istore 6
    //   81: aload 10
    //   83: bipush 20
    //   85: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   88: iconst_0
    //   89: invokestatic 194	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;I)I
    //   92: istore 7
    //   94: getstatic 199	android/os/Build$VERSION:SDK_INT	I
    //   97: bipush 23
    //   99: if_icmplt +210 -> 309
    //   102: aload 10
    //   104: bipush 25
    //   106: invokevirtual 189	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: fconst_0
    //   110: invokestatic 202	com/tencent/luggage/wxa/qz/af:a	(Ljava/lang/String;F)F
    //   113: fstore_1
    //   114: goto +3 -> 117
    //   117: fload_1
    //   118: fstore_2
    //   119: fload_1
    //   120: fconst_0
    //   121: fcmpl
    //   122: ifne +15 -> 137
    //   125: ldc 20
    //   127: ldc 204
    //   129: invokestatic 41	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokestatic 207	com/tencent/mm/plugin/sight/base/a:d	(Ljava/lang/String;)F
    //   136: fstore_2
    //   137: ldc 20
    //   139: ldc 209
    //   141: bipush 9
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: iload_3
    //   153: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: aastore
    //   157: dup
    //   158: iconst_2
    //   159: aload 11
    //   161: aastore
    //   162: dup
    //   163: iconst_3
    //   164: iload 4
    //   166: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: dup
    //   171: iconst_4
    //   172: lload 8
    //   174: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   177: aastore
    //   178: dup
    //   179: iconst_5
    //   180: iload 5
    //   182: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: dup
    //   187: bipush 6
    //   189: iload 6
    //   191: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: bipush 7
    //   198: iload 7
    //   200: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: dup
    //   205: bipush 8
    //   207: fload_2
    //   208: invokestatic 219	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   211: aastore
    //   212: invokestatic 64	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: new 69	com/tencent/mm/plugin/sight/base/a$b
    //   218: dup
    //   219: aload_0
    //   220: iload_3
    //   221: aload 11
    //   223: iload 4
    //   225: lload 8
    //   227: iload 5
    //   229: iload 6
    //   231: iload 7
    //   233: fload_2
    //   234: invokespecial 222	com/tencent/mm/plugin/sight/base/a$b:<init>	(Ljava/lang/String;ILjava/lang/String;IJIIIF)V
    //   237: astore_0
    //   238: aload 10
    //   240: invokevirtual 225	android/media/MediaMetadataRetriever:release	()V
    //   243: aload_0
    //   244: areturn
    //   245: astore_0
    //   246: goto +43 -> 289
    //   249: aload 10
    //   251: astore_0
    //   252: goto +12 -> 264
    //   255: astore_0
    //   256: aconst_null
    //   257: astore 10
    //   259: goto +30 -> 289
    //   262: aconst_null
    //   263: astore_0
    //   264: ldc 20
    //   266: ldc 227
    //   268: invokestatic 229	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: ifnull +7 -> 279
    //   275: aload_0
    //   276: invokevirtual 225	android/media/MediaMetadataRetriever:release	()V
    //   279: aconst_null
    //   280: areturn
    //   281: astore 11
    //   283: aload_0
    //   284: astore 10
    //   286: aload 11
    //   288: astore_0
    //   289: aload 10
    //   291: ifnull +8 -> 299
    //   294: aload 10
    //   296: invokevirtual 225	android/media/MediaMetadataRetriever:release	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_0
    //   302: goto -40 -> 262
    //   305: astore_0
    //   306: goto -57 -> 249
    //   309: fconst_0
    //   310: fstore_1
    //   311: goto -194 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString	String
    //   113	198	1	f1	float
    //   118	116	2	f2	float
    //   26	195	3	i	int
    //   47	177	4	j	int
    //   66	162	5	k	int
    //   79	151	6	m	int
    //   92	140	7	n	int
    //   53	173	8	l	long
    //   7	288	10	localObject1	Object
    //   34	188	11	str	String
    //   281	6	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	114	245	finally
    //   125	137	245	finally
    //   137	238	245	finally
    //   0	9	255	finally
    //   264	271	281	finally
    //   0	9	301	java/lang/Exception
    //   9	114	305	java/lang/Exception
    //   125	137	305	java/lang/Exception
    //   137	238	305	java/lang/Exception
  }
  
  /* Error */
  private static float d(String paramString)
  {
    // Byte code:
    //   0: new 233	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 234	android/media/MediaExtractor:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 235	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: invokevirtual 239	android/media/MediaExtractor:getTrackCount	()I
    //   17: istore_2
    //   18: iconst_0
    //   19: istore_1
    //   20: iload_1
    //   21: iload_2
    //   22: if_icmpge +51 -> 73
    //   25: aload_3
    //   26: iload_1
    //   27: invokevirtual 243	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   30: astore_0
    //   31: aload_0
    //   32: ldc 245
    //   34: invokevirtual 250	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: ldc 252
    //   39: invokevirtual 257	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   42: ifeq +24 -> 66
    //   45: aload_0
    //   46: ldc_w 259
    //   49: invokevirtual 262	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   52: ifeq +14 -> 66
    //   55: aload_0
    //   56: ldc_w 259
    //   59: invokevirtual 265	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   62: istore_1
    //   63: goto +12 -> 75
    //   66: iload_1
    //   67: iconst_1
    //   68: iadd
    //   69: istore_1
    //   70: goto -50 -> 20
    //   73: iconst_0
    //   74: istore_1
    //   75: aload_3
    //   76: invokevirtual 266	android/media/MediaExtractor:release	()V
    //   79: goto +18 -> 97
    //   82: astore_0
    //   83: goto +38 -> 121
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   91: aload_3
    //   92: invokevirtual 266	android/media/MediaExtractor:release	()V
    //   95: iconst_0
    //   96: istore_1
    //   97: ldc 20
    //   99: ldc_w 271
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload_1
    //   109: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 64	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: iload_1
    //   117: i2f
    //   118: fconst_1
    //   119: fmul
    //   120: freturn
    //   121: aload_3
    //   122: invokevirtual 266	android/media/MediaExtractor:release	()V
    //   125: goto +5 -> 130
    //   128: aload_0
    //   129: athrow
    //   130: goto -2 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   19	98	1	i	int
    //   17	6	2	j	int
    //   7	115	3	localMediaExtractor	android.media.MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   8	18	82	finally
    //   25	63	82	finally
    //   87	91	82	finally
    //   8	18	86	java/io/IOException
    //   25	63	86	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.a
 * JD-Core Version:    0.7.0.1
 */