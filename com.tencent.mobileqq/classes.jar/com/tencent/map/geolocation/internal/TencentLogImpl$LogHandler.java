package com.tencent.map.geolocation.internal;

import android.os.Handler;
import android.os.Looper;
import java.io.File;

final class TencentLogImpl$LogHandler
  extends Handler
{
  private static final String TXWATCHDOG = "txwatchdog";
  private File mDest = makeSureDest();
  
  private TencentLogImpl$LogHandler(TencentLogImpl paramTencentLogImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private File makeSureDest()
  {
    File localFile = TencentLogImpl.access$500(this.this$0);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "txwatchdog");
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 53	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   5: aload_0
    //   6: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   9: astore 13
    //   11: aload 13
    //   13: ifnull +16 -> 29
    //   16: ldc 8
    //   18: aload 13
    //   20: invokevirtual 57	java/io/File:getName	()Ljava/lang/String;
    //   23: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: aload_0
    //   31: invokespecial 23	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:makeSureDest	()Ljava/io/File;
    //   34: putfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   37: aload_1
    //   38: getfield 69	android/os/Message:obj	Ljava/lang/Object;
    //   41: invokevirtual 74	java/lang/Object:toString	()Ljava/lang/String;
    //   44: ldc 76
    //   46: invokevirtual 80	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   49: invokestatic 86	c/t/m/g/co:c	([B)[B
    //   52: astore 13
    //   54: aload 13
    //   56: arraylength
    //   57: istore 5
    //   59: iload 5
    //   61: newarray byte
    //   63: astore_1
    //   64: aload 13
    //   66: iconst_0
    //   67: aload_1
    //   68: iconst_0
    //   69: iload 5
    //   71: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   74: iload 5
    //   76: iconst_5
    //   77: irem
    //   78: bipush 7
    //   80: iadd
    //   81: istore 6
    //   83: iconst_0
    //   84: istore_2
    //   85: iload 6
    //   87: iconst_1
    //   88: ishl
    //   89: iload_2
    //   90: iadd
    //   91: istore 4
    //   93: iload 4
    //   95: iload 5
    //   97: if_icmpge +17 -> 114
    //   100: iload_2
    //   101: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   107: istore 7
    //   109: iconst_0
    //   110: istore_3
    //   111: goto +233 -> 344
    //   114: aload_1
    //   115: arraylength
    //   116: iconst_4
    //   117: iadd
    //   118: newarray byte
    //   120: astore 14
    //   122: aload_1
    //   123: arraylength
    //   124: istore_2
    //   125: aload 14
    //   127: iconst_0
    //   128: iload_2
    //   129: bipush 8
    //   131: ishr
    //   132: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   138: bastore
    //   139: aload 14
    //   141: iconst_1
    //   142: iload_2
    //   143: bipush 24
    //   145: ishr
    //   146: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   152: bastore
    //   153: aload 14
    //   155: iconst_2
    //   156: iload_2
    //   157: bipush 16
    //   159: ishr
    //   160: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   166: bastore
    //   167: aload 14
    //   169: iconst_3
    //   170: iload_2
    //   171: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   177: bastore
    //   178: aload_1
    //   179: iconst_0
    //   180: aload 14
    //   182: iconst_4
    //   183: iload_2
    //   184: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   187: aload_0
    //   188: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   191: astore_1
    //   192: new 104	java/io/BufferedOutputStream
    //   195: dup
    //   196: new 106	java/io/FileOutputStream
    //   199: dup
    //   200: aload_1
    //   201: iconst_1
    //   202: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   205: invokespecial 112	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   208: astore 13
    //   210: aload 13
    //   212: astore_1
    //   213: aload 13
    //   215: aload 14
    //   217: invokevirtual 116	java/io/BufferedOutputStream:write	([B)V
    //   220: aload 13
    //   222: astore_1
    //   223: aload 13
    //   225: invokevirtual 120	java/io/BufferedOutputStream:flush	()V
    //   228: aload 13
    //   230: invokestatic 126	c/t/m/g/cp:a	(Ljava/io/Closeable;)V
    //   233: aload_0
    //   234: getfield 16	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:this$0	Lcom/tencent/map/geolocation/internal/TencentLogImpl;
    //   237: invokestatic 35	com/tencent/map/geolocation/internal/TencentLogImpl:access$500	(Lcom/tencent/map/geolocation/internal/TencentLogImpl;)Ljava/io/File;
    //   240: astore_1
    //   241: aload_0
    //   242: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   245: astore 13
    //   247: aload_1
    //   248: ifnull +50 -> 298
    //   251: aload 13
    //   253: ifnonnull +4 -> 257
    //   256: return
    //   257: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   260: lstore 11
    //   262: aload 13
    //   264: invokevirtual 133	java/io/File:length	()J
    //   267: ldc2_w 134
    //   270: lcmp
    //   271: ifle +27 -> 298
    //   274: aload 13
    //   276: new 37	java/io/File
    //   279: dup
    //   280: aload_1
    //   281: ldc 137
    //   283: lload 11
    //   285: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   288: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   294: invokevirtual 148	java/io/File:renameTo	(Ljava/io/File;)Z
    //   297: pop
    //   298: return
    //   299: astore 14
    //   301: aload 13
    //   303: astore_1
    //   304: aload 14
    //   306: astore 13
    //   308: goto +14 -> 322
    //   311: astore 13
    //   313: aconst_null
    //   314: astore_1
    //   315: goto +12 -> 327
    //   318: astore 13
    //   320: aconst_null
    //   321: astore_1
    //   322: aload 13
    //   324: athrow
    //   325: astore 13
    //   327: aload_1
    //   328: invokestatic 126	c/t/m/g/cp:a	(Ljava/io/Closeable;)V
    //   331: aload 13
    //   333: athrow
    //   334: aload_0
    //   335: aconst_null
    //   336: putfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   339: return
    //   340: astore_1
    //   341: goto -7 -> 334
    //   344: iload_3
    //   345: iload 6
    //   347: if_icmpge +51 -> 398
    //   350: iload_2
    //   351: iload_3
    //   352: iadd
    //   353: istore 8
    //   355: aload_1
    //   356: iload 8
    //   358: baload
    //   359: istore 9
    //   361: iload_2
    //   362: iload 6
    //   364: iadd
    //   365: iload_3
    //   366: iadd
    //   367: istore 10
    //   369: aload_1
    //   370: iload 8
    //   372: aload_1
    //   373: iload 10
    //   375: baload
    //   376: iload 7
    //   378: ixor
    //   379: i2b
    //   380: bastore
    //   381: aload_1
    //   382: iload 10
    //   384: iload 9
    //   386: iload 7
    //   388: ixor
    //   389: i2b
    //   390: bastore
    //   391: iload_3
    //   392: iconst_1
    //   393: iadd
    //   394: istore_3
    //   395: goto -51 -> 344
    //   398: iload 4
    //   400: istore_2
    //   401: goto -316 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	LogHandler
    //   0	404	1	paramMessage	android.os.Message
    //   84	317	2	i	int
    //   110	285	3	j	int
    //   91	308	4	k	int
    //   57	41	5	m	int
    //   81	284	6	n	int
    //   107	282	7	i1	int
    //   353	18	8	i2	int
    //   359	30	9	i3	int
    //   367	16	10	i4	int
    //   260	24	11	l	long
    //   9	298	13	localObject1	java.lang.Object
    //   311	1	13	localObject2	java.lang.Object
    //   318	5	13	localIOException1	java.io.IOException
    //   325	7	13	localObject3	java.lang.Object
    //   120	96	14	arrayOfByte	byte[]
    //   299	6	14	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   213	220	299	java/io/IOException
    //   223	228	299	java/io/IOException
    //   192	210	311	finally
    //   192	210	318	java/io/IOException
    //   213	220	325	finally
    //   223	228	325	finally
    //   322	325	325	finally
    //   37	74	340	java/io/IOException
    //   100	109	340	java/io/IOException
    //   114	192	340	java/io/IOException
    //   228	233	340	java/io/IOException
    //   327	334	340	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl.LogHandler
 * JD-Core Version:    0.7.0.1
 */