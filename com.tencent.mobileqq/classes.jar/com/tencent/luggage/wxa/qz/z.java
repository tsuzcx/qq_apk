package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.media.MediaPlayer;

public class z
{
  /* Error */
  public static MediaPlayer a(Context paramContext, int paramInt1, z.b paramb, int paramInt2, boolean paramBoolean, z.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +501 -> 502
    //   4: aload_2
    //   5: ifnonnull +6 -> 11
    //   8: goto +494 -> 502
    //   11: aload_0
    //   12: iload_1
    //   13: invokevirtual 16	android/content/Context:getString	(I)Ljava/lang/String;
    //   16: astore 13
    //   18: new 18	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   21: dup
    //   22: invokespecial 22	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   25: astore 12
    //   27: aload_2
    //   28: getstatic 27	com/tencent/luggage/wxa/qz/z$b:a	Lcom/tencent/luggage/wxa/qz/z$b;
    //   31: if_acmpeq +32 -> 63
    //   34: iconst_m1
    //   35: iload_3
    //   36: if_icmpne +27 -> 63
    //   39: aload_2
    //   40: getstatic 30	com/tencent/luggage/wxa/qz/z$b:b	Lcom/tencent/luggage/wxa/qz/z$b;
    //   43: if_acmpne +8 -> 51
    //   46: iconst_3
    //   47: istore_3
    //   48: goto +6 -> 54
    //   51: bipush 8
    //   53: istore_3
    //   54: aload 12
    //   56: iload_3
    //   57: invokevirtual 36	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   60: goto +14 -> 74
    //   63: iload_3
    //   64: iconst_m1
    //   65: if_icmpeq +9 -> 74
    //   68: aload 12
    //   70: iload_3
    //   71: invokevirtual 36	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   74: ldc 38
    //   76: ldc 40
    //   78: bipush 7
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload 12
    //   87: invokevirtual 44	java/lang/Object:hashCode	()I
    //   90: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload 13
    //   98: aastore
    //   99: dup
    //   100: iconst_2
    //   101: aload_0
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: iload_1
    //   106: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_4
    //   112: aload_2
    //   113: aastore
    //   114: dup
    //   115: iconst_5
    //   116: iload 4
    //   118: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   121: aastore
    //   122: dup
    //   123: bipush 6
    //   125: aload 5
    //   127: aastore
    //   128: invokestatic 61	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: invokevirtual 65	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   135: aload 13
    //   137: invokevirtual 71	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   140: astore 11
    //   142: aload 11
    //   144: astore_2
    //   145: aload 11
    //   147: invokevirtual 77	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   150: astore 14
    //   152: aload 11
    //   154: astore_2
    //   155: aload 11
    //   157: invokevirtual 81	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   160: lstore 7
    //   162: aload 11
    //   164: astore_2
    //   165: aload 11
    //   167: invokevirtual 84	android/content/res/AssetFileDescriptor:getLength	()J
    //   170: lstore 9
    //   172: aload 12
    //   174: astore_0
    //   175: aload 11
    //   177: astore_2
    //   178: aload 12
    //   180: aload 14
    //   182: lload 7
    //   184: lload 9
    //   186: invokevirtual 88	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   189: aload 11
    //   191: astore_2
    //   192: aload_0
    //   193: iload 4
    //   195: invokevirtual 92	android/media/MediaPlayer:setLooping	(Z)V
    //   198: aload 11
    //   200: astore_2
    //   201: aload_0
    //   202: new 94	com/tencent/luggage/wxa/qz/z$1
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 97	com/tencent/luggage/wxa/qz/z$1:<init>	(Landroid/media/MediaPlayer;)V
    //   210: invokevirtual 101	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   213: aload 11
    //   215: astore_2
    //   216: aload_0
    //   217: new 103	com/tencent/luggage/wxa/qz/z$2
    //   220: dup
    //   221: aload 13
    //   223: aload_0
    //   224: aload 5
    //   226: invokespecial 106	com/tencent/luggage/wxa/qz/z$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Lcom/tencent/luggage/wxa/qz/z$a;)V
    //   229: invokevirtual 110	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   232: aload 11
    //   234: astore_2
    //   235: aload_0
    //   236: new 112	com/tencent/luggage/wxa/qz/z$3
    //   239: dup
    //   240: aload 13
    //   242: aload_0
    //   243: iload_1
    //   244: invokespecial 115	com/tencent/luggage/wxa/qz/z$3:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;I)V
    //   247: invokevirtual 119	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   250: aload 11
    //   252: astore_2
    //   253: aload_0
    //   254: invokevirtual 122	android/media/MediaPlayer:prepareAsync	()V
    //   257: aload 11
    //   259: astore_2
    //   260: aload_0
    //   261: invokevirtual 44	java/lang/Object:hashCode	()I
    //   264: istore_3
    //   265: aload 11
    //   267: astore_2
    //   268: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   271: ifnull +272 -> 543
    //   274: iconst_1
    //   275: istore 4
    //   277: goto +3 -> 280
    //   280: aload 11
    //   282: astore_2
    //   283: invokestatic 131	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   286: ifnull +263 -> 549
    //   289: iconst_1
    //   290: istore 6
    //   292: goto +3 -> 295
    //   295: aload 11
    //   297: astore_2
    //   298: ldc 38
    //   300: ldc 133
    //   302: iconst_3
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: iload_3
    //   309: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: iload 4
    //   317: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   320: aastore
    //   321: dup
    //   322: iconst_2
    //   323: iload 6
    //   325: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   328: aastore
    //   329: invokestatic 61	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload 11
    //   334: ifnull +23 -> 357
    //   337: aload 11
    //   339: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   342: aload_0
    //   343: areturn
    //   344: astore_2
    //   345: ldc 38
    //   347: aload_2
    //   348: ldc 138
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 141	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload_0
    //   358: areturn
    //   359: astore_0
    //   360: aload 11
    //   362: astore 5
    //   364: goto +33 -> 397
    //   367: astore_0
    //   368: aload 11
    //   370: astore 5
    //   372: goto +25 -> 397
    //   375: astore_0
    //   376: goto +100 -> 476
    //   379: astore_0
    //   380: aload 11
    //   382: astore 5
    //   384: goto +13 -> 397
    //   387: astore_0
    //   388: aconst_null
    //   389: astore_2
    //   390: goto +86 -> 476
    //   393: astore_0
    //   394: aconst_null
    //   395: astore 5
    //   397: aload 5
    //   399: astore_2
    //   400: ldc 38
    //   402: ldc 143
    //   404: iconst_2
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: iload_1
    //   411: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_1
    //   417: aload_0
    //   418: invokevirtual 147	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: aastore
    //   422: invokestatic 149	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aload 5
    //   427: astore_2
    //   428: ldc 38
    //   430: aload_0
    //   431: ldc 138
    //   433: iconst_0
    //   434: anewarray 4	java/lang/Object
    //   437: invokestatic 141	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: aload 5
    //   442: astore_2
    //   443: aload 12
    //   445: invokevirtual 152	android/media/MediaPlayer:release	()V
    //   448: aload 5
    //   450: ifnull +24 -> 474
    //   453: aload 5
    //   455: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   458: goto +16 -> 474
    //   461: astore_0
    //   462: ldc 38
    //   464: aload_0
    //   465: ldc 138
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 141	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: aconst_null
    //   475: areturn
    //   476: aload_2
    //   477: ifnull +23 -> 500
    //   480: aload_2
    //   481: invokevirtual 136	android/content/res/AssetFileDescriptor:close	()V
    //   484: goto +16 -> 500
    //   487: astore_2
    //   488: ldc 38
    //   490: aload_2
    //   491: ldc 138
    //   493: iconst_0
    //   494: anewarray 4	java/lang/Object
    //   497: invokestatic 141	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload_0
    //   501: athrow
    //   502: ldc 38
    //   504: ldc 154
    //   506: iconst_5
    //   507: anewarray 4	java/lang/Object
    //   510: dup
    //   511: iconst_0
    //   512: aload_0
    //   513: aastore
    //   514: dup
    //   515: iconst_1
    //   516: iload_1
    //   517: invokestatic 50	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: aastore
    //   521: dup
    //   522: iconst_2
    //   523: aload_2
    //   524: aastore
    //   525: dup
    //   526: iconst_3
    //   527: iload 4
    //   529: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   532: aastore
    //   533: dup
    //   534: iconst_4
    //   535: aload 5
    //   537: aastore
    //   538: invokestatic 149	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: aconst_null
    //   542: areturn
    //   543: iconst_0
    //   544: istore 4
    //   546: goto -266 -> 280
    //   549: iconst_0
    //   550: istore 6
    //   552: goto -257 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	paramContext	Context
    //   0	555	1	paramInt1	int
    //   0	555	2	paramb	z.b
    //   0	555	3	paramInt2	int
    //   0	555	4	paramBoolean	boolean
    //   0	555	5	parama	z.a
    //   290	261	6	bool	boolean
    //   160	23	7	l1	long
    //   170	15	9	l2	long
    //   140	241	11	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   25	419	12	localReportMediaPlayer	com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer
    //   16	225	13	str	java.lang.String
    //   150	31	14	localFileDescriptor	java.io.FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   337	342	344	java/io/IOException
    //   235	250	359	java/lang/Exception
    //   253	257	359	java/lang/Exception
    //   260	265	359	java/lang/Exception
    //   268	274	359	java/lang/Exception
    //   283	289	359	java/lang/Exception
    //   298	332	359	java/lang/Exception
    //   178	189	367	java/lang/Exception
    //   192	198	367	java/lang/Exception
    //   201	213	367	java/lang/Exception
    //   216	232	367	java/lang/Exception
    //   145	152	375	finally
    //   155	162	375	finally
    //   165	172	375	finally
    //   178	189	375	finally
    //   192	198	375	finally
    //   201	213	375	finally
    //   216	232	375	finally
    //   235	250	375	finally
    //   253	257	375	finally
    //   260	265	375	finally
    //   268	274	375	finally
    //   283	289	375	finally
    //   298	332	375	finally
    //   400	425	375	finally
    //   428	440	375	finally
    //   443	448	375	finally
    //   145	152	379	java/lang/Exception
    //   155	162	379	java/lang/Exception
    //   165	172	379	java/lang/Exception
    //   131	142	387	finally
    //   131	142	393	java/lang/Exception
    //   453	458	461	java/io/IOException
    //   480	484	487	java/io/IOException
  }
  
  public static MediaPlayer a(Context paramContext, int paramInt, z.b paramb, boolean paramBoolean, z.a parama)
  {
    return a(paramContext, paramInt, paramb, -1, paramBoolean, parama);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, z.b.a, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.z
 * JD-Core Version:    0.7.0.1
 */