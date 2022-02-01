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
    //   9: ifnull +18 -> 27
    //   12: ldc 8
    //   14: aload_0
    //   15: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   18: invokevirtual 57	java/io/File:getName	()Ljava/lang/String;
    //   21: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +11 -> 35
    //   27: aload_0
    //   28: aload_0
    //   29: invokespecial 23	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:makeSureDest	()Ljava/io/File;
    //   32: putfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   35: aload_1
    //   36: getfield 69	android/os/Message:obj	Ljava/lang/Object;
    //   39: invokevirtual 74	java/lang/Object:toString	()Ljava/lang/String;
    //   42: ldc 76
    //   44: invokevirtual 80	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   47: invokestatic 86	c/t/m/g/co:c	([B)[B
    //   50: astore 10
    //   52: aload 10
    //   54: arraylength
    //   55: istore 4
    //   57: iload 4
    //   59: newarray byte
    //   61: astore_1
    //   62: aload 10
    //   64: iconst_0
    //   65: aload_1
    //   66: iconst_0
    //   67: iload 4
    //   69: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   72: iload 4
    //   74: iconst_5
    //   75: irem
    //   76: bipush 7
    //   78: iadd
    //   79: istore 5
    //   81: iconst_0
    //   82: istore_2
    //   83: iload 5
    //   85: iconst_1
    //   86: ishl
    //   87: iload_2
    //   88: iadd
    //   89: iload 4
    //   91: if_icmpge +17 -> 108
    //   94: iload_2
    //   95: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   101: istore 6
    //   103: iconst_0
    //   104: istore_3
    //   105: goto +232 -> 337
    //   108: aload_1
    //   109: arraylength
    //   110: iconst_4
    //   111: iadd
    //   112: newarray byte
    //   114: astore 11
    //   116: aload_1
    //   117: arraylength
    //   118: istore_2
    //   119: aload 11
    //   121: iconst_0
    //   122: iload_2
    //   123: bipush 8
    //   125: ishr
    //   126: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   132: bastore
    //   133: aload 11
    //   135: iconst_1
    //   136: iload_2
    //   137: bipush 24
    //   139: ishr
    //   140: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   146: bastore
    //   147: aload 11
    //   149: iconst_2
    //   150: iload_2
    //   151: bipush 16
    //   153: ishr
    //   154: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   160: bastore
    //   161: aload 11
    //   163: iconst_3
    //   164: iload_2
    //   165: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: invokevirtual 102	java/lang/Integer:byteValue	()B
    //   171: bastore
    //   172: aload_1
    //   173: iconst_0
    //   174: aload 11
    //   176: iconst_4
    //   177: iload_2
    //   178: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   181: aload_0
    //   182: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   185: astore_1
    //   186: new 104	java/io/BufferedOutputStream
    //   189: dup
    //   190: new 106	java/io/FileOutputStream
    //   193: dup
    //   194: aload_1
    //   195: iconst_1
    //   196: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   199: invokespecial 112	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   202: astore 10
    //   204: aload 10
    //   206: astore_1
    //   207: aload 10
    //   209: aload 11
    //   211: invokevirtual 116	java/io/BufferedOutputStream:write	([B)V
    //   214: aload 10
    //   216: astore_1
    //   217: aload 10
    //   219: invokevirtual 120	java/io/BufferedOutputStream:flush	()V
    //   222: aload 10
    //   224: invokestatic 126	c/t/m/g/cp:a	(Ljava/io/Closeable;)V
    //   227: aload_0
    //   228: getfield 16	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:this$0	Lcom/tencent/map/geolocation/internal/TencentLogImpl;
    //   231: invokestatic 35	com/tencent/map/geolocation/internal/TencentLogImpl:access$500	(Lcom/tencent/map/geolocation/internal/TencentLogImpl;)Ljava/io/File;
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   239: astore 10
    //   241: aload_1
    //   242: ifnull +8 -> 250
    //   245: aload 10
    //   247: ifnonnull +33 -> 280
    //   250: return
    //   251: astore 11
    //   253: aconst_null
    //   254: astore_1
    //   255: aload 11
    //   257: athrow
    //   258: astore 11
    //   260: aload_1
    //   261: astore 10
    //   263: aload 11
    //   265: astore_1
    //   266: aload 10
    //   268: invokestatic 126	c/t/m/g/cp:a	(Ljava/io/Closeable;)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 25	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   279: return
    //   280: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   283: lstore 8
    //   285: aload 10
    //   287: invokevirtual 133	java/io/File:length	()J
    //   290: ldc2_w 134
    //   293: lcmp
    //   294: ifle -44 -> 250
    //   297: aload 10
    //   299: new 37	java/io/File
    //   302: dup
    //   303: aload_1
    //   304: ldc 137
    //   306: lload 8
    //   308: invokestatic 140	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   311: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   317: invokevirtual 148	java/io/File:renameTo	(Ljava/io/File;)Z
    //   320: pop
    //   321: return
    //   322: astore_1
    //   323: aconst_null
    //   324: astore 10
    //   326: goto -60 -> 266
    //   329: astore 11
    //   331: aload 10
    //   333: astore_1
    //   334: goto -79 -> 255
    //   337: iload_3
    //   338: iload 5
    //   340: if_icmpge +48 -> 388
    //   343: aload_1
    //   344: iload_2
    //   345: iload_3
    //   346: iadd
    //   347: baload
    //   348: istore 7
    //   350: aload_1
    //   351: iload_2
    //   352: iload_3
    //   353: iadd
    //   354: aload_1
    //   355: iload_2
    //   356: iload 5
    //   358: iadd
    //   359: iload_3
    //   360: iadd
    //   361: baload
    //   362: iload 6
    //   364: ixor
    //   365: i2b
    //   366: bastore
    //   367: aload_1
    //   368: iload_2
    //   369: iload 5
    //   371: iadd
    //   372: iload_3
    //   373: iadd
    //   374: iload 7
    //   376: iload 6
    //   378: ixor
    //   379: i2b
    //   380: bastore
    //   381: iload_3
    //   382: iconst_1
    //   383: iadd
    //   384: istore_3
    //   385: goto -48 -> 337
    //   388: iload 5
    //   390: iconst_1
    //   391: ishl
    //   392: iload_2
    //   393: iadd
    //   394: istore_2
    //   395: goto -312 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	LogHandler
    //   0	398	1	paramMessage	android.os.Message
    //   82	313	2	i	int
    //   104	281	3	j	int
    //   55	37	4	k	int
    //   79	313	5	m	int
    //   101	278	6	n	int
    //   348	31	7	i1	int
    //   283	24	8	l	long
    //   50	282	10	localObject1	java.lang.Object
    //   114	96	11	arrayOfByte	byte[]
    //   251	5	11	localIOException1	java.io.IOException
    //   258	6	11	localObject2	java.lang.Object
    //   329	1	11	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   186	204	251	java/io/IOException
    //   207	214	258	finally
    //   217	222	258	finally
    //   255	258	258	finally
    //   35	72	273	java/io/IOException
    //   94	103	273	java/io/IOException
    //   108	186	273	java/io/IOException
    //   222	227	273	java/io/IOException
    //   266	273	273	java/io/IOException
    //   186	204	322	finally
    //   207	214	329	java/io/IOException
    //   217	222	329	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl.LogHandler
 * JD-Core Version:    0.7.0.1
 */