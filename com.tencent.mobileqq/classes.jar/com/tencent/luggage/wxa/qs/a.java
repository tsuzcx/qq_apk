package com.tencent.luggage.wxa.qs;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import com.tencent.luggage.wxa.hh.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.i;

public class a
{
  public static final int a = b("ftyp");
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return paramArrayOfByte[(i + 1)] & 0xFF | (paramInt & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static String a()
  {
    if ((r.a() != null) && (r.a().getCacheDir() != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append("/mux");
      localObject = ((StringBuilder)localObject).toString();
      i locali = new i((String)localObject);
      if (!locali.j())
      {
        locali.t();
        o.d("WMPF.ImportVideo", "path is not exists, mkdir path: %s", new Object[] { localObject });
      }
      o.e("WMPF.ImportVideo", "WechatSight ffmpegMuxerPath path is %s", new Object[] { localObject });
      return localObject;
    }
    o.b("WMPF.ImportVideo", "path is empty, MMApplicationContext.getContext() == null");
    return "";
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        localObject1 = new b();
      }
      finally
      {
        Object localObject1;
        paramString = null;
        if (paramString == null) {
          continue;
        }
        paramString.release();
        if (paramArrayOfInt[0] % 2 == 0) {
          continue;
        }
        paramArrayOfInt[0] += 1;
        if (paramArrayOfInt[1] % 2 == 0) {
          continue;
        }
        paramArrayOfInt[1] += 1;
        continue;
      }
      try
      {
        ((MediaMetadataRetriever)localObject1).setDataSource(paramString);
        i = af.a(((MediaMetadataRetriever)localObject1).extractMetadata(18), 0);
        j = af.a(((MediaMetadataRetriever)localObject1).extractMetadata(19), 0);
        paramArrayOfInt[0] = i;
        paramArrayOfInt[1] = j;
        k = 0;
      }
      finally
      {
        paramString = (String)localObject1;
        localObject1 = localObject3;
      }
    }
    i /= 2;
    j /= 2;
    k += 1;
    break label229;
    ((MediaMetadataRetriever)localObject1).release();
    if (paramArrayOfInt[0] % 2 != 0) {
      paramArrayOfInt[0] += 1;
    }
    if (paramArrayOfInt[1] % 2 != 0) {
      paramArrayOfInt[1] += 1;
    }
    return;
    for (;;)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = j;
      ((MediaMetadataRetriever)localObject1).release();
      if (paramArrayOfInt[0] % 2 != 0) {
        paramArrayOfInt[0] += 1;
      }
      if (paramArrayOfInt[1] % 2 != 0) {
        paramArrayOfInt[1] += 1;
      }
      return;
      label229:
      if (i > j) {
        break;
      }
      if (i > paramInt2) {
        if (j > paramInt1) {
          break;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 109	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_0
    //   16: invokestatic 114	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_0
    //   20: aload_0
    //   21: astore 4
    //   23: aload_0
    //   24: astore 5
    //   26: bipush 8
    //   28: newarray byte
    //   30: astore 6
    //   32: aload_0
    //   33: astore 4
    //   35: aload_0
    //   36: astore 5
    //   38: aload_0
    //   39: aload 6
    //   41: iconst_0
    //   42: bipush 8
    //   44: invokevirtual 120	java/io/InputStream:read	([BII)I
    //   47: istore_1
    //   48: iload_1
    //   49: bipush 8
    //   51: if_icmpge +28 -> 79
    //   54: aload_0
    //   55: ifnull +22 -> 77
    //   58: aload_0
    //   59: invokevirtual 123	java/io/InputStream:close	()V
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_0
    //   65: ldc 60
    //   67: aload_0
    //   68: ldc 80
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: iconst_0
    //   78: ireturn
    //   79: aload_0
    //   80: astore 4
    //   82: aload_0
    //   83: astore 5
    //   85: aload 6
    //   87: iconst_0
    //   88: invokestatic 128	com/tencent/luggage/wxa/qs/a:a	([BI)I
    //   91: istore_1
    //   92: aload_0
    //   93: astore 4
    //   95: aload_0
    //   96: astore 5
    //   98: aload 6
    //   100: iconst_4
    //   101: invokestatic 128	com/tencent/luggage/wxa/qs/a:a	([BI)I
    //   104: istore_2
    //   105: aload_0
    //   106: astore 4
    //   108: aload_0
    //   109: astore 5
    //   111: getstatic 16	com/tencent/luggage/wxa/qs/a:a	I
    //   114: istore_3
    //   115: iload_2
    //   116: iload_3
    //   117: if_icmpne +32 -> 149
    //   120: iload_1
    //   121: ifle +28 -> 149
    //   124: aload_0
    //   125: ifnull +22 -> 147
    //   128: aload_0
    //   129: invokevirtual 123	java/io/InputStream:close	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: ldc 60
    //   137: aload_0
    //   138: ldc 80
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_0
    //   150: ifnull +22 -> 172
    //   153: aload_0
    //   154: invokevirtual 123	java/io/InputStream:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: ldc 60
    //   162: aload_0
    //   163: ldc 80
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_0
    //   175: goto +47 -> 222
    //   178: astore_0
    //   179: aload 5
    //   181: astore 4
    //   183: ldc 60
    //   185: aload_0
    //   186: ldc 80
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 5
    //   197: ifnull +23 -> 220
    //   200: aload 5
    //   202: invokevirtual 123	java/io/InputStream:close	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_0
    //   208: ldc 60
    //   210: aload_0
    //   211: ldc 80
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: iconst_0
    //   221: ireturn
    //   222: aload 4
    //   224: ifnull +26 -> 250
    //   227: aload 4
    //   229: invokevirtual 123	java/io/InputStream:close	()V
    //   232: goto +18 -> 250
    //   235: astore 4
    //   237: ldc 60
    //   239: aload 4
    //   241: ldc 80
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 126	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_0
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramString	String
    //   47	74	1	i	int
    //   104	14	2	j	int
    //   114	4	3	k	int
    //   13	215	4	str1	String
    //   235	5	4	localIOException	java.io.IOException
    //   10	191	5	str2	String
    //   30	69	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	62	64	java/io/IOException
    //   128	132	134	java/io/IOException
    //   153	157	159	java/io/IOException
    //   15	20	174	finally
    //   26	32	174	finally
    //   38	48	174	finally
    //   85	92	174	finally
    //   98	105	174	finally
    //   111	115	174	finally
    //   183	195	174	finally
    //   15	20	178	java/lang/Exception
    //   26	32	178	java/lang/Exception
    //   38	48	178	java/lang/Exception
    //   85	92	178	java/lang/Exception
    //   98	105	178	java/lang/Exception
    //   111	115	178	java/lang/Exception
    //   200	205	207	java/io/IOException
    //   227	232	235	java/io/IOException
  }
  
  public static int b(String paramString)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = j << 8 | paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  public static String b()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(com.tencent.luggage.wxa.hz.a.d());
      ((StringBuilder)localObject1).append("video/");
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qs.a
 * JD-Core Version:    0.7.0.1
 */