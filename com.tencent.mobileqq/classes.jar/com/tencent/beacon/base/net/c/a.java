package com.tencent.beacon.base.net.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class a
{
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      return d(paramArrayOfByte);
    }
    if (paramInt == 2) {
      return a(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.finish();
    localGZIPOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      return c(paramArrayOfByte);
    }
    if (paramInt == 2) {
      return b(paramArrayOfByte);
    }
    return null;
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 8
    //   12: new 49	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore_2
    //   21: new 53	java/util/zip/GZIPInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 56	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore_3
    //   30: aload 7
    //   32: astore 6
    //   34: aload_2
    //   35: astore 5
    //   37: aload_3
    //   38: astore 4
    //   40: sipush 1024
    //   43: newarray byte
    //   45: astore 9
    //   47: aload 7
    //   49: astore 6
    //   51: aload_2
    //   52: astore 5
    //   54: aload_3
    //   55: astore 4
    //   57: new 15	java/io/ByteArrayOutputStream
    //   60: dup
    //   61: invokespecial 19	java/io/ByteArrayOutputStream:<init>	()V
    //   64: astore 7
    //   66: aload 8
    //   68: astore 4
    //   70: aload_3
    //   71: aload 9
    //   73: iconst_0
    //   74: aload 9
    //   76: arraylength
    //   77: invokevirtual 60	java/util/zip/GZIPInputStream:read	([BII)I
    //   80: istore_1
    //   81: iload_1
    //   82: iconst_m1
    //   83: if_icmpeq +19 -> 102
    //   86: aload 8
    //   88: astore 4
    //   90: aload 7
    //   92: aload 9
    //   94: iconst_0
    //   95: iload_1
    //   96: invokevirtual 63	java/io/ByteArrayOutputStream:write	([BII)V
    //   99: goto -33 -> 66
    //   102: aload 8
    //   104: astore 4
    //   106: aload 7
    //   108: invokevirtual 38	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: astore 5
    //   113: aload 5
    //   115: astore 4
    //   117: aload 7
    //   119: invokevirtual 66	java/io/ByteArrayOutputStream:flush	()V
    //   122: aload 7
    //   124: invokevirtual 39	java/io/ByteArrayOutputStream:close	()V
    //   127: aload_3
    //   128: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   131: aload_2
    //   132: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   135: aload 5
    //   137: areturn
    //   138: astore 4
    //   140: aload 7
    //   142: astore 6
    //   144: aload_2
    //   145: astore 5
    //   147: aload_3
    //   148: astore_0
    //   149: aload 4
    //   151: astore_2
    //   152: goto +284 -> 436
    //   155: astore 8
    //   157: aload 4
    //   159: astore 9
    //   161: goto +61 -> 222
    //   164: astore_2
    //   165: aload 4
    //   167: astore_0
    //   168: goto +268 -> 436
    //   171: astore 8
    //   173: aconst_null
    //   174: astore 9
    //   176: aload 10
    //   178: astore 7
    //   180: goto +42 -> 222
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_0
    //   186: aload_2
    //   187: astore 5
    //   189: aload_3
    //   190: astore_2
    //   191: goto +245 -> 436
    //   194: astore 8
    //   196: goto +17 -> 213
    //   199: astore_2
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 5
    //   205: astore_0
    //   206: goto +230 -> 436
    //   209: astore 8
    //   211: aconst_null
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_3
    //   215: aconst_null
    //   216: astore 9
    //   218: aload 10
    //   220: astore 7
    //   222: aload 7
    //   224: astore 6
    //   226: aload_2
    //   227: astore 5
    //   229: aload_3
    //   230: astore 4
    //   232: invokestatic 73	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   235: astore 10
    //   237: aload 7
    //   239: astore 6
    //   241: aload_2
    //   242: astore 5
    //   244: aload_3
    //   245: astore 4
    //   247: new 75	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   254: astore 11
    //   256: aload 7
    //   258: astore 6
    //   260: aload_2
    //   261: astore 5
    //   263: aload_3
    //   264: astore 4
    //   266: aload 11
    //   268: ldc 78
    //   270: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 7
    //   276: astore 6
    //   278: aload_2
    //   279: astore 5
    //   281: aload_3
    //   282: astore 4
    //   284: aload 11
    //   286: aload_0
    //   287: arraylength
    //   288: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 7
    //   294: astore 6
    //   296: aload_2
    //   297: astore 5
    //   299: aload_3
    //   300: astore 4
    //   302: aload 10
    //   304: ldc 87
    //   306: aload 11
    //   308: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload 8
    //   313: invokevirtual 94	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload 7
    //   318: astore 6
    //   320: aload_2
    //   321: astore 5
    //   323: aload_3
    //   324: astore 4
    //   326: aload 8
    //   328: invokestatic 99	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   331: aload 7
    //   333: astore 6
    //   335: aload_2
    //   336: astore 5
    //   338: aload_3
    //   339: astore 4
    //   341: new 75	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   348: astore_0
    //   349: aload 7
    //   351: astore 6
    //   353: aload_2
    //   354: astore 5
    //   356: aload_3
    //   357: astore 4
    //   359: aload_0
    //   360: ldc 101
    //   362: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 7
    //   368: astore 6
    //   370: aload_2
    //   371: astore 5
    //   373: aload_3
    //   374: astore 4
    //   376: aload_0
    //   377: aload 8
    //   379: invokevirtual 102	java/lang/Exception:toString	()Ljava/lang/String;
    //   382: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 7
    //   388: astore 6
    //   390: aload_2
    //   391: astore 5
    //   393: aload_3
    //   394: astore 4
    //   396: aload_0
    //   397: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 105	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload 7
    //   409: ifnull +8 -> 417
    //   412: aload 7
    //   414: invokevirtual 39	java/io/ByteArrayOutputStream:close	()V
    //   417: aload_3
    //   418: ifnull +7 -> 425
    //   421: aload_3
    //   422: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   425: aload_2
    //   426: ifnull +7 -> 433
    //   429: aload_2
    //   430: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   433: aload 9
    //   435: areturn
    //   436: aload 6
    //   438: ifnull +8 -> 446
    //   441: aload 6
    //   443: invokevirtual 39	java/io/ByteArrayOutputStream:close	()V
    //   446: aload_0
    //   447: ifnull +7 -> 454
    //   450: aload_0
    //   451: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   454: aload 5
    //   456: ifnull +8 -> 464
    //   459: aload 5
    //   461: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   464: goto +5 -> 469
    //   467: aload_2
    //   468: athrow
    //   469: goto -2 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramArrayOfByte	byte[]
    //   80	16	1	i	int
    //   20	132	2	localObject1	Object
    //   164	23	2	localObject2	Object
    //   190	1	2	localObject3	Object
    //   199	1	2	localObject4	Object
    //   212	256	2	localObject5	Object
    //   29	119	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   183	7	3	localObject6	Object
    //   214	208	3	localObject7	Object
    //   38	78	4	localObject8	Object
    //   138	28	4	localObject9	Object
    //   230	165	4	localObject10	Object
    //   35	425	5	localObject11	Object
    //   7	435	6	localObject12	Object
    //   1	412	7	localObject13	Object
    //   10	93	8	localObject14	Object
    //   155	1	8	localException1	java.lang.Exception
    //   171	1	8	localException2	java.lang.Exception
    //   194	1	8	localException3	java.lang.Exception
    //   209	169	8	localException4	java.lang.Exception
    //   45	389	9	localObject15	Object
    //   4	299	10	locald	com.tencent.beacon.a.b.d
    //   254	53	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	81	138	finally
    //   90	99	138	finally
    //   106	113	138	finally
    //   117	122	138	finally
    //   70	81	155	java/lang/Exception
    //   90	99	155	java/lang/Exception
    //   106	113	155	java/lang/Exception
    //   117	122	155	java/lang/Exception
    //   40	47	164	finally
    //   57	66	164	finally
    //   232	237	164	finally
    //   247	256	164	finally
    //   266	274	164	finally
    //   284	292	164	finally
    //   302	316	164	finally
    //   326	331	164	finally
    //   341	349	164	finally
    //   359	366	164	finally
    //   376	386	164	finally
    //   396	407	164	finally
    //   40	47	171	java/lang/Exception
    //   57	66	171	java/lang/Exception
    //   21	30	183	finally
    //   21	30	194	java/lang/Exception
    //   12	21	199	finally
    //   12	21	209	java/lang/Exception
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ZipInputStream localZipInputStream = new ZipInputStream(localByteArrayInputStream);
    paramArrayOfByte = null;
    while (localZipInputStream.getNextEntry() != null)
    {
      paramArrayOfByte = new byte[1024];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
    }
    localZipInputStream.close();
    localByteArrayInputStream.close();
    return paramArrayOfByte;
  }
  
  private static byte[] d(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
    ZipEntry localZipEntry = new ZipEntry("zip");
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipOutputStream.putNextEntry(localZipEntry);
    localZipOutputStream.write(paramArrayOfByte);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.c.a
 * JD-Core Version:    0.7.0.1
 */