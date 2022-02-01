package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.j;
import java.nio.ByteBuffer;

public final class k
{
  /* Error */
  public static int a(@NonNull java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: sipush 16384
    //   3: newarray byte
    //   5: astore 7
    //   7: aload_0
    //   8: invokevirtual 21	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +262 -> 277
    //   18: aload 5
    //   20: invokevirtual 27	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   23: astore 4
    //   25: aload 4
    //   27: ldc 29
    //   29: invokevirtual 35	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   32: ifne -25 -> 7
    //   35: aload 4
    //   37: ldc 37
    //   39: invokevirtual 35	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +6 -> 48
    //   45: goto -38 -> 7
    //   48: aload 5
    //   50: invokevirtual 41	java/util/zip/ZipEntry:isDirectory	()Z
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +69 -> 124
    //   58: aload 4
    //   60: iconst_0
    //   61: aload 4
    //   63: invokevirtual 45	java/lang/String:length	()I
    //   66: iconst_1
    //   67: isub
    //   68: invokevirtual 49	java/lang/String:substring	(II)Ljava/lang/String;
    //   71: astore 4
    //   73: new 51	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   80: astore 5
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 5
    //   91: ldc 61
    //   93: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 5
    //   99: aload 4
    //   101: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 63	com/tencent/luggage/wxa/rt/i
    //   108: dup
    //   109: aload 5
    //   111: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 69	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 72	com/tencent/luggage/wxa/rt/i:u	()Z
    //   120: pop
    //   121: goto -114 -> 7
    //   124: new 51	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: aload_1
    //   136: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 5
    //   142: ldc 61
    //   144: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: aload 4
    //   152: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: new 63	com/tencent/luggage/wxa/rt/i
    //   159: dup
    //   160: aload 5
    //   162: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 69	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   168: astore 6
    //   170: aload 6
    //   172: invokevirtual 76	com/tencent/luggage/wxa/rt/i:g	()Lcom/tencent/luggage/wxa/rt/i;
    //   175: invokevirtual 72	com/tencent/luggage/wxa/rt/i:u	()Z
    //   178: pop
    //   179: aload 6
    //   181: invokevirtual 79	com/tencent/luggage/wxa/rt/i:v	()Z
    //   184: pop
    //   185: aconst_null
    //   186: astore 5
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 6
    //   193: invokestatic 85	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   196: astore 6
    //   198: aload 6
    //   200: astore 4
    //   202: aload 6
    //   204: astore 5
    //   206: aload_0
    //   207: aload 7
    //   209: invokevirtual 89	java/util/zip/ZipInputStream:read	([B)I
    //   212: istore_2
    //   213: iload_2
    //   214: iconst_m1
    //   215: if_icmpeq +36 -> 251
    //   218: aload 6
    //   220: astore 4
    //   222: aload 6
    //   224: astore 5
    //   226: aload 6
    //   228: aload 7
    //   230: iconst_0
    //   231: iload_2
    //   232: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   235: aload 6
    //   237: astore 4
    //   239: aload 6
    //   241: astore 5
    //   243: aload 6
    //   245: invokevirtual 98	java/io/OutputStream:flush	()V
    //   248: goto -50 -> 198
    //   251: aload 6
    //   253: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   256: goto -249 -> 7
    //   259: astore_1
    //   260: goto +10 -> 270
    //   263: astore_1
    //   264: aload 5
    //   266: astore 4
    //   268: aload_1
    //   269: athrow
    //   270: aload 4
    //   272: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   275: aload_1
    //   276: athrow
    //   277: aload_0
    //   278: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore_1
    //   284: goto +63 -> 347
    //   287: astore_1
    //   288: ldc 105
    //   290: aload_1
    //   291: ldc 107
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: bipush 253
    //   302: istore_2
    //   303: aload_0
    //   304: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   307: iload_2
    //   308: ireturn
    //   309: astore_1
    //   310: ldc 105
    //   312: aload_1
    //   313: ldc 107
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: bipush 254
    //   324: istore_2
    //   325: goto -22 -> 303
    //   328: astore_1
    //   329: ldc 105
    //   331: aload_1
    //   332: ldc 107
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_0
    //   342: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   345: iconst_m1
    //   346: ireturn
    //   347: aload_0
    //   348: invokestatic 103	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   351: goto +5 -> 356
    //   354: aload_1
    //   355: athrow
    //   356: goto -2 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramZipInputStream	java.util.zip.ZipInputStream
    //   0	359	1	paramString	String
    //   212	113	2	i	int
    //   53	2	3	bool	boolean
    //   23	248	4	localObject1	Object
    //   11	254	5	localObject2	Object
    //   168	84	6	localObject3	Object
    //   5	224	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   191	198	259	finally
    //   206	213	259	finally
    //   226	235	259	finally
    //   243	248	259	finally
    //   268	270	259	finally
    //   191	198	263	java/lang/Exception
    //   206	213	263	java/lang/Exception
    //   226	235	263	java/lang/Exception
    //   243	248	263	java/lang/Exception
    //   0	7	283	finally
    //   7	13	283	finally
    //   18	45	283	finally
    //   48	54	283	finally
    //   58	121	283	finally
    //   124	185	283	finally
    //   251	256	283	finally
    //   270	277	283	finally
    //   288	300	283	finally
    //   310	322	283	finally
    //   329	341	283	finally
    //   0	7	287	java/lang/OutOfMemoryError
    //   7	13	287	java/lang/OutOfMemoryError
    //   18	45	287	java/lang/OutOfMemoryError
    //   48	54	287	java/lang/OutOfMemoryError
    //   58	121	287	java/lang/OutOfMemoryError
    //   124	185	287	java/lang/OutOfMemoryError
    //   251	256	287	java/lang/OutOfMemoryError
    //   270	277	287	java/lang/OutOfMemoryError
    //   0	7	309	java/io/IOException
    //   7	13	309	java/io/IOException
    //   18	45	309	java/io/IOException
    //   48	54	309	java/io/IOException
    //   58	121	309	java/io/IOException
    //   124	185	309	java/io/IOException
    //   251	256	309	java/io/IOException
    //   270	277	309	java/io/IOException
    //   0	7	328	java/io/FileNotFoundException
    //   7	13	328	java/io/FileNotFoundException
    //   18	45	328	java/io/FileNotFoundException
    //   48	54	328	java/io/FileNotFoundException
    //   58	121	328	java/io/FileNotFoundException
    //   124	185	328	java/io/FileNotFoundException
    //   251	256	328	java/io/FileNotFoundException
    //   270	277	328	java/io/FileNotFoundException
  }
  
  public static long a(i parami)
  {
    if (parami == null) {
      return -1L;
    }
    parami = parami.s();
    long l1 = 0L;
    if (parami == null) {
      return 0L;
    }
    int j = parami.length;
    int i = 0;
    while (i < j)
    {
      i locali = parami[i];
      long l2;
      if (locali.o()) {
        l2 = locali.q();
      } else {
        l2 = a(locali);
      }
      l1 += l2;
      i += 1;
    }
    return l1;
  }
  
  public static String a(String paramString)
  {
    if (af.c(paramString)) {
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  /* Error */
  @NonNull
  static ByteBuffer a(i parami, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +312 -> 313
    //   4: aload_0
    //   5: invokevirtual 150	com/tencent/luggage/wxa/rt/i:j	()Z
    //   8: ifeq +305 -> 313
    //   11: aload_0
    //   12: invokevirtual 124	com/tencent/luggage/wxa/rt/i:o	()Z
    //   15: ifne +6 -> 21
    //   18: goto +295 -> 313
    //   21: aload_0
    //   22: invokevirtual 128	com/tencent/luggage/wxa/rt/i:q	()J
    //   25: l2i
    //   26: istore 5
    //   28: iload 5
    //   30: ifge +8 -> 38
    //   33: iconst_0
    //   34: invokestatic 156	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   37: areturn
    //   38: lload_1
    //   39: lload_3
    //   40: ladd
    //   41: lconst_1
    //   42: lsub
    //   43: iload 5
    //   45: iconst_1
    //   46: isub
    //   47: i2l
    //   48: lcmp
    //   49: ifle +8 -> 57
    //   52: iconst_0
    //   53: invokestatic 156	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   56: areturn
    //   57: iload 5
    //   59: invokestatic 156	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   62: astore 10
    //   64: iload 5
    //   66: i2l
    //   67: lstore 6
    //   69: lload_3
    //   70: lconst_0
    //   71: lcmp
    //   72: iflt +6 -> 78
    //   75: goto +6 -> 81
    //   78: lload 6
    //   80: lstore_3
    //   81: aload_0
    //   82: invokevirtual 159	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   85: iconst_0
    //   86: invokestatic 162	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   89: astore 11
    //   91: aconst_null
    //   92: astore 9
    //   94: aload 9
    //   96: astore 8
    //   98: aload 11
    //   100: invokevirtual 168	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   103: aload 10
    //   105: invokevirtual 173	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   108: pop
    //   109: aload 9
    //   111: astore 8
    //   113: aload 10
    //   115: invokevirtual 177	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   118: pop
    //   119: lload_1
    //   120: lconst_0
    //   121: lcmp
    //   122: ifne +23 -> 145
    //   125: lload_3
    //   126: lload 6
    //   128: lcmp
    //   129: ifne +16 -> 145
    //   132: aload 11
    //   134: ifnull +8 -> 142
    //   137: aload 11
    //   139: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   142: aload 10
    //   144: areturn
    //   145: lload_3
    //   146: l2i
    //   147: istore 5
    //   149: aload 9
    //   151: astore 8
    //   153: iload 5
    //   155: newarray byte
    //   157: astore 12
    //   159: aload 9
    //   161: astore 8
    //   163: aload 10
    //   165: lload_1
    //   166: l2i
    //   167: invokevirtual 184	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   170: pop
    //   171: aload 9
    //   173: astore 8
    //   175: aload 10
    //   177: aload 12
    //   179: iconst_0
    //   180: iload 5
    //   182: invokevirtual 188	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   185: pop
    //   186: aload 9
    //   188: astore 8
    //   190: aload 12
    //   192: invokestatic 192	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   195: astore 9
    //   197: aload 11
    //   199: ifnull +8 -> 207
    //   202: aload 11
    //   204: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   207: aload 9
    //   209: areturn
    //   210: astore 9
    //   212: goto +12 -> 224
    //   215: astore 9
    //   217: aload 9
    //   219: astore 8
    //   221: aload 9
    //   223: athrow
    //   224: aload 11
    //   226: ifnull +21 -> 247
    //   229: aload 8
    //   231: ifnull +11 -> 242
    //   234: aload 11
    //   236: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   239: goto +8 -> 247
    //   242: aload 11
    //   244: invokevirtual 180	java/io/RandomAccessFile:close	()V
    //   247: aload 9
    //   249: athrow
    //   250: ldc 105
    //   252: ldc 194
    //   254: iconst_2
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_0
    //   261: invokevirtual 128	com/tencent/luggage/wxa/rt/i:q	()J
    //   264: invokestatic 200	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 10
    //   272: invokevirtual 203	java/nio/ByteBuffer:capacity	()I
    //   275: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: invokestatic 211	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload 10
    //   284: invokestatic 216	com/tencent/luggage/util/a:a	(Ljava/nio/ByteBuffer;)V
    //   287: goto +21 -> 308
    //   290: astore_0
    //   291: ldc 105
    //   293: aload_0
    //   294: ldc 218
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokestatic 112	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: aload 10
    //   305: invokestatic 216	com/tencent/luggage/util/a:a	(Ljava/nio/ByteBuffer;)V
    //   308: iconst_0
    //   309: invokestatic 156	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   312: areturn
    //   313: iconst_0
    //   314: invokestatic 156	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   317: areturn
    //   318: astore 8
    //   320: goto -70 -> 250
    //   323: astore 8
    //   325: goto -78 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	parami	i
    //   0	328	1	paramLong1	long
    //   0	328	3	paramLong2	long
    //   26	155	5	i	int
    //   67	60	6	l	long
    //   96	134	8	localObject1	Object
    //   318	1	8	localBufferOverflowException	java.nio.BufferOverflowException
    //   323	1	8	localThrowable1	java.lang.Throwable
    //   92	116	9	localByteBuffer1	ByteBuffer
    //   210	1	9	localObject2	Object
    //   215	33	9	localThrowable2	java.lang.Throwable
    //   62	242	10	localByteBuffer2	ByteBuffer
    //   89	154	11	localRandomAccessFile	java.io.RandomAccessFile
    //   157	34	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	109	210	finally
    //   113	119	210	finally
    //   153	159	210	finally
    //   163	171	210	finally
    //   175	186	210	finally
    //   190	197	210	finally
    //   221	224	210	finally
    //   98	109	215	java/lang/Throwable
    //   113	119	215	java/lang/Throwable
    //   153	159	215	java/lang/Throwable
    //   163	171	215	java/lang/Throwable
    //   175	186	215	java/lang/Throwable
    //   190	197	215	java/lang/Throwable
    //   81	91	290	java/io/IOException
    //   137	142	290	java/io/IOException
    //   202	207	290	java/io/IOException
    //   234	239	290	java/io/IOException
    //   242	247	290	java/io/IOException
    //   247	250	290	java/io/IOException
    //   81	91	318	java/nio/BufferOverflowException
    //   137	142	318	java/nio/BufferOverflowException
    //   202	207	318	java/nio/BufferOverflowException
    //   234	239	318	java/nio/BufferOverflowException
    //   242	247	318	java/nio/BufferOverflowException
    //   247	250	318	java/nio/BufferOverflowException
    //   234	239	323	java/lang/Throwable
  }
  
  static void a(i parami, j paramj)
  {
    parami = parami.a(paramj);
    if (parami != null)
    {
      int j = parami.length;
      int i = 0;
      while (i < j)
      {
        i locali = parami[i];
        if (locali.n()) {
          a(locali, paramj);
        }
        i += 1;
      }
    }
  }
  
  public static String b(String paramString)
  {
    int j = o.c();
    int i = 0;
    if (j <= 1) {
      o.e("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    }
    if (af.c(paramString)) {
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    if (i == 1) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/");
    localStringBuilder.append(paramString.substring(i));
    return localStringBuilder.toString();
  }
  
  @NonNull
  static ByteBuffer b(i parami)
  {
    return a(parami, 0L, -1L);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  public static void c(i parami)
  {
    if (parami != null)
    {
      if (!parami.n()) {
        return;
      }
      if (parami.j())
      {
        i[] arrayOfi = parami.s();
        if (arrayOfi != null)
        {
          int j = arrayOfi.length;
          int i = 0;
          while (i < j)
          {
            i locali = arrayOfi[i];
            if (locali.n()) {
              c(locali);
            }
            locali.w();
            i += 1;
          }
        }
        parami.w();
      }
    }
  }
  
  public static boolean d(i parami)
  {
    if (parami != null)
    {
      if (!parami.j()) {
        return false;
      }
      try
      {
        FileStructStat localFileStructStat = new FileStructStat();
        if (FileStat.a(parami.l(), localFileStructStat) == 0)
        {
          o.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { parami.l(), Integer.valueOf(localFileStructStat.st_mode) });
          boolean bool = localFileStructStat.isSymLink();
          return bool;
        }
      }
      catch (Exception parami)
      {
        o.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", parami, "", new Object[0]);
      }
      return false;
    }
    throw new NullPointerException("file should not be NULL");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.k
 * JD-Core Version:    0.7.0.1
 */