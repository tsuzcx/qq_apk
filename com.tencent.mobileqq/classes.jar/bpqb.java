import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class bpqb
{
  private static String a = "MediaUtil";
  
  @TargetApi(10)
  public static long a(String paramString)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      bnrh.a(a, "[getVideoDuration]", paramString);
      return 0L;
    }
    catch (RuntimeException paramString)
    {
      bnrh.a(a, "[getVideoDuration]", paramString);
    }
    return 0L;
  }
  
  /* Error */
  @TargetApi(10)
  public static android.graphics.Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 62	zeb:e	(Ljava/lang/String;)Z
    //   7: ifne +42 -> 49
    //   10: getstatic 12	bpqb:a	Ljava/lang/String;
    //   13: new 64	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   20: ldc 67
    //   22: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 73
    //   31: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 85	ykq:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 5
    //   46: astore_2
    //   47: aload_2
    //   48: areturn
    //   49: new 23	android/media/MediaMetadataRetriever
    //   52: dup
    //   53: invokespecial 26	android/media/MediaMetadataRetriever:<init>	()V
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: aload_0
    //   61: invokevirtual 30	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: iload_1
    //   68: i2l
    //   69: ldc2_w 86
    //   72: lmul
    //   73: iconst_0
    //   74: invokevirtual 91	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   77: astore_0
    //   78: aload_0
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -34 -> 47
    //   84: aload_3
    //   85: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   88: aload_0
    //   89: areturn
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: astore_2
    //   96: getstatic 12	bpqb:a	Ljava/lang/String;
    //   99: iconst_1
    //   100: ldc 93
    //   102: aload 4
    //   104: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload 5
    //   109: astore_2
    //   110: aload_0
    //   111: ifnull -64 -> 47
    //   114: aload_0
    //   115: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: goto -11 -> 123
    //   137: astore 4
    //   139: aload_3
    //   140: astore_0
    //   141: goto -47 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   0	144	1	paramInt	int
    //   46	82	2	localObject1	Object
    //   56	84	3	localMediaMetadataRetriever	MediaMetadataRetriever
    //   90	13	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   137	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	107	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	90	java/lang/OutOfMemoryError
    //   49	57	120	finally
    //   59	64	133	finally
    //   66	78	133	finally
    //   96	107	133	finally
    //   59	64	137	java/lang/OutOfMemoryError
    //   66	78	137	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, com.tencent.mobileqq.activity.photo.LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aload_1
    //   4: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   7: istore 8
    //   9: aload_1
    //   10: getfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   13: istore 7
    //   15: aload_1
    //   16: getfield 116	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   19: sipush 180
    //   22: irem
    //   23: ifeq +453 -> 476
    //   26: aload_1
    //   27: getfield 113	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   30: istore 8
    //   32: aload_1
    //   33: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   36: istore 7
    //   38: aload_0
    //   39: iload 8
    //   41: iload 7
    //   43: iconst_0
    //   44: invokestatic 121	altw:a	(Ljava/lang/String;IIZ)I
    //   47: ifne +523 -> 570
    //   50: invokestatic 127	com/tencent/maxvideo/trim/TrimNative:isGetFrameReady	()Z
    //   53: istore 14
    //   55: iload 14
    //   57: ifeq +413 -> 470
    //   60: lload_2
    //   61: lload_2
    //   62: ldc2_w 128
    //   65: lsub
    //   66: invokestatic 132	altw:a	(JJ)Landroid/graphics/Bitmap;
    //   69: astore_1
    //   70: aload_1
    //   71: astore 15
    //   73: aload 15
    //   75: astore_1
    //   76: aload 15
    //   78: ifnull +202 -> 280
    //   81: aload 15
    //   83: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   86: aload 15
    //   88: invokevirtual 141	android/graphics/Bitmap:getRowBytes	()I
    //   91: imul
    //   92: invokestatic 147	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   95: astore_1
    //   96: aload 15
    //   98: aload_1
    //   99: invokevirtual 151	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   102: aload_1
    //   103: invokevirtual 155	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   106: pop
    //   107: iload 8
    //   109: iload 7
    //   111: imul
    //   112: newarray int
    //   114: astore 16
    //   116: iconst_0
    //   117: istore 9
    //   119: iload 9
    //   121: iload 8
    //   123: iload 7
    //   125: imul
    //   126: if_icmpge +135 -> 261
    //   129: aload_1
    //   130: invokevirtual 159	java/nio/ByteBuffer:get	()B
    //   133: istore 12
    //   135: aload_1
    //   136: invokevirtual 159	java/nio/ByteBuffer:get	()B
    //   139: istore 6
    //   141: aload_1
    //   142: invokevirtual 159	java/nio/ByteBuffer:get	()B
    //   145: istore 4
    //   147: aload_1
    //   148: invokevirtual 159	java/nio/ByteBuffer:get	()B
    //   151: istore 13
    //   153: iload 4
    //   155: istore 5
    //   157: iload 6
    //   159: istore 10
    //   161: iload 12
    //   163: istore 11
    //   165: iload 13
    //   167: ifle +362 -> 529
    //   170: iload 4
    //   172: istore 5
    //   174: iload 6
    //   176: istore 10
    //   178: iload 12
    //   180: istore 11
    //   182: iload 13
    //   184: sipush 255
    //   187: if_icmpeq +342 -> 529
    //   190: iload 12
    //   192: i2f
    //   193: fconst_1
    //   194: fmul
    //   195: iload 13
    //   197: i2f
    //   198: fconst_1
    //   199: fmul
    //   200: fdiv
    //   201: ldc 160
    //   203: fmul
    //   204: f2i
    //   205: istore 10
    //   207: iload 6
    //   209: i2f
    //   210: fconst_1
    //   211: fmul
    //   212: iload 13
    //   214: i2f
    //   215: fconst_1
    //   216: fmul
    //   217: fdiv
    //   218: ldc 160
    //   220: fmul
    //   221: f2i
    //   222: istore 5
    //   224: iload 4
    //   226: i2f
    //   227: fconst_1
    //   228: fmul
    //   229: iload 13
    //   231: i2f
    //   232: fconst_1
    //   233: fmul
    //   234: fdiv
    //   235: ldc 160
    //   237: fmul
    //   238: f2i
    //   239: istore 12
    //   241: iload 10
    //   243: istore 4
    //   245: iload 10
    //   247: sipush 255
    //   250: if_icmple +229 -> 479
    //   253: sipush 255
    //   256: istore 4
    //   258: goto +221 -> 479
    //   261: aload 16
    //   263: aload 15
    //   265: invokevirtual 163	android/graphics/Bitmap:getWidth	()I
    //   268: aload 15
    //   270: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   273: getstatic 169	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   276: invokestatic 173	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   279: astore_1
    //   280: aload_1
    //   281: astore 15
    //   283: aload_1
    //   284: ifnonnull +54 -> 338
    //   287: new 23	android/media/MediaMetadataRetriever
    //   290: dup
    //   291: invokespecial 26	android/media/MediaMetadataRetriever:<init>	()V
    //   294: astore 16
    //   296: aload 16
    //   298: astore 15
    //   300: aload 16
    //   302: aload_0
    //   303: invokevirtual 30	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   306: aload 16
    //   308: astore 15
    //   310: aload 16
    //   312: ldc2_w 86
    //   315: lload_2
    //   316: lmul
    //   317: iconst_3
    //   318: invokevirtual 91	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   321: astore_0
    //   322: aload_0
    //   323: astore 15
    //   325: aload 16
    //   327: ifnull +11 -> 338
    //   330: aload 16
    //   332: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   335: aload_0
    //   336: astore 15
    //   338: aload 15
    //   340: areturn
    //   341: astore 16
    //   343: aload 15
    //   345: astore_1
    //   346: aload 16
    //   348: astore 15
    //   350: getstatic 12	bpqb:a	Ljava/lang/String;
    //   353: iconst_1
    //   354: ldc 175
    //   356: aload 15
    //   358: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: goto -81 -> 280
    //   364: astore_0
    //   365: aconst_null
    //   366: astore 16
    //   368: aload 16
    //   370: astore 15
    //   372: getstatic 12	bpqb:a	Ljava/lang/String;
    //   375: iconst_1
    //   376: ldc 175
    //   378: aload_0
    //   379: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   382: aload_1
    //   383: astore 15
    //   385: aload 16
    //   387: ifnull -49 -> 338
    //   390: aload 16
    //   392: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   395: aload_1
    //   396: areturn
    //   397: astore_0
    //   398: aconst_null
    //   399: astore 16
    //   401: aload 16
    //   403: astore 15
    //   405: getstatic 12	bpqb:a	Ljava/lang/String;
    //   408: iconst_1
    //   409: ldc 179
    //   411: aload_0
    //   412: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: aload_1
    //   416: astore 15
    //   418: aload 16
    //   420: ifnull -82 -> 338
    //   423: aload 16
    //   425: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   428: aload_1
    //   429: areturn
    //   430: astore_0
    //   431: aconst_null
    //   432: astore 15
    //   434: aload 15
    //   436: ifnull +8 -> 444
    //   439: aload 15
    //   441: invokevirtual 37	android/media/MediaMetadataRetriever:release	()V
    //   444: aload_0
    //   445: athrow
    //   446: astore_0
    //   447: goto -13 -> 434
    //   450: astore_0
    //   451: goto -50 -> 401
    //   454: astore_0
    //   455: goto -87 -> 368
    //   458: astore 16
    //   460: aload 15
    //   462: astore_1
    //   463: aload 16
    //   465: astore 15
    //   467: goto -117 -> 350
    //   470: aconst_null
    //   471: astore 15
    //   473: goto -400 -> 73
    //   476: goto -438 -> 38
    //   479: iload 5
    //   481: istore 6
    //   483: iload 5
    //   485: sipush 255
    //   488: if_icmple +8 -> 496
    //   491: sipush 255
    //   494: istore 6
    //   496: iload 12
    //   498: istore 5
    //   500: iload 6
    //   502: istore 10
    //   504: iload 4
    //   506: istore 11
    //   508: iload 12
    //   510: sipush 255
    //   513: if_icmple +16 -> 529
    //   516: sipush 255
    //   519: istore 5
    //   521: iload 4
    //   523: istore 11
    //   525: iload 6
    //   527: istore 10
    //   529: aload 16
    //   531: iload 9
    //   533: iload 5
    //   535: sipush 255
    //   538: iand
    //   539: iload 10
    //   541: bipush 8
    //   543: ishl
    //   544: ldc 180
    //   546: iand
    //   547: iload 11
    //   549: bipush 16
    //   551: ishl
    //   552: ldc 181
    //   554: iand
    //   555: ldc 182
    //   557: ior
    //   558: ior
    //   559: ior
    //   560: iastore
    //   561: iload 9
    //   563: iconst_1
    //   564: iadd
    //   565: istore 9
    //   567: goto -448 -> 119
    //   570: iconst_0
    //   571: istore 14
    //   573: goto -518 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramString	String
    //   0	576	1	paramLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   0	576	2	paramLong	long
    //   145	377	4	i	int
    //   155	384	5	j	int
    //   139	387	6	k	int
    //   13	113	7	m	int
    //   7	119	8	n	int
    //   117	449	9	i1	int
    //   159	385	10	i2	int
    //   163	389	11	i3	int
    //   133	381	12	i4	int
    //   151	79	13	i5	int
    //   53	519	14	bool	boolean
    //   1	471	15	localObject1	Object
    //   114	217	16	localObject2	Object
    //   341	6	16	localThrowable1	java.lang.Throwable
    //   366	58	16	localObject3	Object
    //   458	72	16	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	38	341	java/lang/Throwable
    //   38	55	341	java/lang/Throwable
    //   60	70	341	java/lang/Throwable
    //   287	296	364	java/lang/Exception
    //   287	296	397	java/lang/OutOfMemoryError
    //   287	296	430	finally
    //   300	306	446	finally
    //   310	322	446	finally
    //   372	382	446	finally
    //   405	415	446	finally
    //   300	306	450	java/lang/OutOfMemoryError
    //   310	322	450	java/lang/OutOfMemoryError
    //   300	306	454	java/lang/Exception
    //   310	322	454	java/lang/Exception
    //   81	116	458	java/lang/Throwable
    //   129	153	458	java/lang/Throwable
    //   190	241	458	java/lang/Throwable
    //   261	280	458	java/lang/Throwable
  }
  
  public static bpqe a(String paramString, int paramInt)
  {
    Object localObject = new Object();
    bpqe localbpqe = new bpqe();
    bpdt localbpdt = new bpdt();
    localbpdt.a(ThreadManager.getSubThreadLooper());
    localbpdt.a(paramString, null, false, 480, paramInt, 10000, 1, true, new bpqc(localObject), new bpqd(localbpqe));
    try
    {
      localObject.wait(5000L);
      return localbpqe;
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = new File(paramString.getAbsolutePath() + "/.nomedia");
      if (paramString.exists()) {}
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      QLog.e(a, 1, "createNewFile error, ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqb
 * JD-Core Version:    0.7.0.1
 */