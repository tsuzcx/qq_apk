package com.tencent.biz.qqstory.utils.ffmpeg;

import android.annotation.TargetApi;

@TargetApi(18)
public class QimSegmentMergeUtil
{
  /* Error */
  public boolean a(java.util.List paramList, java.lang.String paramString)
  {
    // Byte code:
    //   0: new 20	java/io/FileOutputStream
    //   3: dup
    //   4: new 22	java/io/File
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 28	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore 6
    //   17: iconst_0
    //   18: istore_3
    //   19: aload 6
    //   21: astore_2
    //   22: iload_3
    //   23: aload_1
    //   24: invokeinterface 34 1 0
    //   29: if_icmpge +202 -> 231
    //   32: aload 6
    //   34: astore_2
    //   35: new 36	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_1
    //   40: iload_3
    //   41: invokeinterface 40 2 0
    //   46: checkcast 42	java/lang/String
    //   49: ldc 44
    //   51: invokespecial 47	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 6
    //   58: astore_2
    //   59: ldc 48
    //   61: newarray byte
    //   63: astore 8
    //   65: aload 7
    //   67: aload 8
    //   69: invokevirtual 52	java/io/RandomAccessFile:read	([B)I
    //   72: istore 4
    //   74: iload 4
    //   76: iconst_m1
    //   77: if_icmpeq +45 -> 122
    //   80: aload 6
    //   82: aload 8
    //   84: iconst_0
    //   85: iload 4
    //   87: invokevirtual 56	java/io/FileOutputStream:write	([BII)V
    //   90: goto -25 -> 65
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   98: aload 6
    //   100: astore_2
    //   101: aload 7
    //   103: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: ireturn
    //   122: aload 6
    //   124: astore_2
    //   125: aload 7
    //   127: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   130: iload_3
    //   131: iconst_1
    //   132: iadd
    //   133: istore_3
    //   134: goto -115 -> 19
    //   137: astore 7
    //   139: aload 6
    //   141: astore_2
    //   142: aload 7
    //   144: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   147: goto -17 -> 130
    //   150: astore_2
    //   151: aload 6
    //   153: astore_1
    //   154: aload_2
    //   155: astore 6
    //   157: aload_1
    //   158: astore_2
    //   159: aload 6
    //   161: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: aload 6
    //   177: astore_2
    //   178: aload_1
    //   179: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   182: goto -76 -> 106
    //   185: astore_1
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   201: goto -85 -> 116
    //   204: astore_1
    //   205: aload 6
    //   207: astore_2
    //   208: aload 7
    //   210: invokevirtual 62	java/io/RandomAccessFile:close	()V
    //   213: aload 6
    //   215: astore_2
    //   216: aload_1
    //   217: athrow
    //   218: astore 7
    //   220: aload 6
    //   222: astore_2
    //   223: aload 7
    //   225: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   228: goto -15 -> 213
    //   231: aload 6
    //   233: astore_2
    //   234: aload 6
    //   236: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   239: iconst_1
    //   240: istore 5
    //   242: aload 6
    //   244: ifnull -125 -> 119
    //   247: aload 6
    //   249: invokevirtual 63	java/io/FileOutputStream:close	()V
    //   252: iconst_1
    //   253: ireturn
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   266: goto -94 -> 172
    //   269: astore_2
    //   270: aload_2
    //   271: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   274: goto -80 -> 194
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_2
    //   280: goto -94 -> 186
    //   283: astore 6
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -130 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	QimSegmentMergeUtil
    //   0	290	1	paramList	java.util.List
    //   0	290	2	paramString	java.lang.String
    //   18	116	3	i	int
    //   72	14	4	j	int
    //   117	124	5	bool	boolean
    //   15	233	6	localObject	Object
    //   283	1	6	localException1	java.lang.Exception
    //   54	72	7	localRandomAccessFile	java.io.RandomAccessFile
    //   137	72	7	localException2	java.lang.Exception
    //   218	6	7	localException3	java.lang.Exception
    //   63	20	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	74	93	java/lang/Exception
    //   80	90	93	java/lang/Exception
    //   125	130	137	java/lang/Exception
    //   22	32	150	java/lang/Exception
    //   35	56	150	java/lang/Exception
    //   59	65	150	java/lang/Exception
    //   142	147	150	java/lang/Exception
    //   178	182	150	java/lang/Exception
    //   216	218	150	java/lang/Exception
    //   223	228	150	java/lang/Exception
    //   234	239	150	java/lang/Exception
    //   101	106	174	java/lang/Exception
    //   22	32	185	finally
    //   35	56	185	finally
    //   59	65	185	finally
    //   101	106	185	finally
    //   125	130	185	finally
    //   142	147	185	finally
    //   159	164	185	finally
    //   178	182	185	finally
    //   208	213	185	finally
    //   216	218	185	finally
    //   223	228	185	finally
    //   234	239	185	finally
    //   111	116	196	java/io/IOException
    //   65	74	204	finally
    //   80	90	204	finally
    //   94	98	204	finally
    //   208	213	218	java/lang/Exception
    //   247	252	254	java/io/IOException
    //   168	172	261	java/io/IOException
    //   190	194	269	java/io/IOException
    //   0	17	277	finally
    //   0	17	283	java/lang/Exception
  }
  
  /* Error */
  public boolean a(java.util.List paramList, java.lang.String paramString, int paramInt1, int paramInt2, android.media.MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload_3
    //   4: ifle +8 -> 12
    //   7: iload 4
    //   9: ifgt +597 -> 606
    //   12: new 67	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData
    //   15: dup
    //   16: invokespecial 68	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:<init>	()V
    //   19: astore 15
    //   21: aload_1
    //   22: iconst_0
    //   23: invokeinterface 40 2 0
    //   28: checkcast 42	java/lang/String
    //   31: aload 15
    //   33: invokestatic 73	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils:a	(Ljava/lang/String;Ldov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData;)I
    //   36: istore 6
    //   38: aload 15
    //   40: getfield 76	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   43: iconst_2
    //   44: iaload
    //   45: istore 4
    //   47: iload 4
    //   49: istore_3
    //   50: iload 6
    //   52: ifge +65 -> 117
    //   55: iload 4
    //   57: istore_3
    //   58: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +56 -> 117
    //   64: ldc 84
    //   66: iconst_2
    //   67: new 86	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   74: ldc 89
    //   76: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 6
    //   81: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 14
    //   94: iconst_0
    //   95: istore_3
    //   96: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +18 -> 117
    //   102: ldc 84
    //   104: iconst_2
    //   105: aload 14
    //   107: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: aload 14
    //   112: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 15
    //   119: getfield 76	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   122: iconst_0
    //   123: iaload
    //   124: istore 7
    //   126: aload 15
    //   128: getfield 76	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   131: iconst_1
    //   132: iaload
    //   133: istore 4
    //   135: iload_3
    //   136: istore 6
    //   138: iload 7
    //   140: istore_3
    //   141: invokestatic 115	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   144: ifeq +11 -> 155
    //   147: aload_1
    //   148: aload_2
    //   149: iload 6
    //   151: invokestatic 120	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:a	(Ljava/util/List;Ljava/lang/String;I)Z
    //   154: ireturn
    //   155: new 122	java/util/ArrayList
    //   158: dup
    //   159: invokespecial 123	java/util/ArrayList:<init>	()V
    //   162: astore 16
    //   164: iconst_0
    //   165: istore 7
    //   167: iload 7
    //   169: aload_1
    //   170: invokeinterface 34 1 0
    //   175: if_icmpge +41 -> 216
    //   178: aload 16
    //   180: new 125	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   183: dup
    //   184: aload_1
    //   185: iload 7
    //   187: invokeinterface 40 2 0
    //   192: checkcast 42	java/lang/String
    //   195: iconst_0
    //   196: iconst_0
    //   197: iconst_1
    //   198: invokespecial 128	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZ)V
    //   201: invokeinterface 132 2 0
    //   206: pop
    //   207: iload 7
    //   209: iconst_1
    //   210: iadd
    //   211: istore 7
    //   213: goto -46 -> 167
    //   216: new 134	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig
    //   219: dup
    //   220: aload_2
    //   221: iload_3
    //   222: iload 4
    //   224: getstatic 139	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:r	I
    //   227: iconst_1
    //   228: iconst_0
    //   229: iload 6
    //   231: invokespecial 142	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   234: astore 17
    //   236: aload 17
    //   238: iconst_1
    //   239: putfield 146	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:b	Z
    //   242: aconst_null
    //   243: astore 14
    //   245: ldc 147
    //   247: invokestatic 153	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   250: astore_1
    //   251: new 155	android/media/MediaCodec$BufferInfo
    //   254: dup
    //   255: invokespecial 156	android/media/MediaCodec$BufferInfo:<init>	()V
    //   258: astore 15
    //   260: new 22	java/io/File
    //   263: dup
    //   264: aload 17
    //   266: getfield 159	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:a	Ljava/lang/String;
    //   269: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload_2
    //   274: invokevirtual 162	java/io/File:exists	()Z
    //   277: ifne +10 -> 287
    //   280: aload_2
    //   281: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   284: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   287: new 172	android/media/MediaMuxer
    //   290: dup
    //   291: aload 17
    //   293: getfield 159	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:a	Ljava/lang/String;
    //   296: iconst_0
    //   297: invokespecial 175	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   300: astore_2
    //   301: aload_2
    //   302: aload 17
    //   304: getfield 178	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:g	I
    //   307: invokevirtual 182	android/media/MediaMuxer:setOrientationHint	(I)V
    //   310: aload_2
    //   311: aload 5
    //   313: invokevirtual 186	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   316: istore 6
    //   318: aload_2
    //   319: invokevirtual 189	android/media/MediaMuxer:start	()V
    //   322: iconst_1
    //   323: istore_3
    //   324: aload 16
    //   326: invokeinterface 193 1 0
    //   331: astore 14
    //   333: lconst_0
    //   334: lstore 8
    //   336: aload 14
    //   338: invokeinterface 198 1 0
    //   343: ifeq +238 -> 581
    //   346: aload 14
    //   348: invokeinterface 202 1 0
    //   353: checkcast 125	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   356: astore 16
    //   358: new 204	android/media/MediaExtractor
    //   361: dup
    //   362: invokespecial 205	android/media/MediaExtractor:<init>	()V
    //   365: astore 5
    //   367: aload 5
    //   369: aload 16
    //   371: getfield 206	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	Ljava/lang/String;
    //   374: invokevirtual 209	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   377: iconst_0
    //   378: istore 4
    //   380: iload 4
    //   382: aload 5
    //   384: invokevirtual 212	android/media/MediaExtractor:getTrackCount	()I
    //   387: if_icmpge +222 -> 609
    //   390: aload 5
    //   392: iload 4
    //   394: invokevirtual 216	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   397: astore 17
    //   399: aload 17
    //   401: ldc 218
    //   403: invokevirtual 224	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   406: ldc 226
    //   408: invokevirtual 230	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   411: ifeq +207 -> 618
    //   414: aload 5
    //   416: iload 4
    //   418: invokevirtual 233	android/media/MediaExtractor:selectTrack	(I)V
    //   421: aload 17
    //   423: ldc 235
    //   425: aload 16
    //   427: getfield 237	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:b	I
    //   430: invokevirtual 240	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   433: goto +176 -> 609
    //   436: aload_1
    //   437: invokevirtual 244	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   440: pop
    //   441: aload 5
    //   443: aload_1
    //   444: iconst_0
    //   445: invokevirtual 248	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   448: istore 4
    //   450: iload 4
    //   452: ifge +34 -> 486
    //   455: aload 5
    //   457: invokevirtual 251	android/media/MediaExtractor:release	()V
    //   460: lload 10
    //   462: lload 12
    //   464: ladd
    //   465: lstore 8
    //   467: goto -131 -> 336
    //   470: astore_1
    //   471: aload 5
    //   473: invokevirtual 251	android/media/MediaExtractor:release	()V
    //   476: aload_2
    //   477: invokevirtual 252	android/media/MediaMuxer:release	()V
    //   480: aload_1
    //   481: invokevirtual 64	java/io/IOException:printStackTrace	()V
    //   484: iconst_0
    //   485: ireturn
    //   486: aload 5
    //   488: invokevirtual 256	android/media/MediaExtractor:getSampleTime	()J
    //   491: lload 8
    //   493: ladd
    //   494: lstore 12
    //   496: lload 12
    //   498: lconst_0
    //   499: lcmp
    //   500: ifle +13 -> 513
    //   503: lload 12
    //   505: aload 15
    //   507: getfield 260	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   510: lsub
    //   511: lstore 10
    //   513: aload 15
    //   515: iconst_0
    //   516: putfield 263	android/media/MediaCodec$BufferInfo:offset	I
    //   519: aload 15
    //   521: iload 4
    //   523: putfield 265	android/media/MediaCodec$BufferInfo:size	I
    //   526: aload 15
    //   528: iload_3
    //   529: putfield 268	android/media/MediaCodec$BufferInfo:flags	I
    //   532: iconst_0
    //   533: istore_3
    //   534: aload 15
    //   536: lload 12
    //   538: putfield 260	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   541: aload_2
    //   542: iload 6
    //   544: aload_1
    //   545: aload 15
    //   547: invokevirtual 272	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   550: aload 5
    //   552: invokevirtual 275	android/media/MediaExtractor:advance	()Z
    //   555: pop
    //   556: goto -120 -> 436
    //   559: astore_1
    //   560: ldc 84
    //   562: iconst_2
    //   563: aload_1
    //   564: iconst_0
    //   565: anewarray 4	java/lang/Object
    //   568: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   571: aload_2
    //   572: ifnull +7 -> 579
    //   575: aload_2
    //   576: invokevirtual 252	android/media/MediaMuxer:release	()V
    //   579: iconst_0
    //   580: ireturn
    //   581: aload_2
    //   582: invokevirtual 281	android/media/MediaMuxer:stop	()V
    //   585: aload_2
    //   586: invokevirtual 252	android/media/MediaMuxer:release	()V
    //   589: iconst_1
    //   590: ireturn
    //   591: astore_1
    //   592: aload 14
    //   594: astore_2
    //   595: goto -35 -> 560
    //   598: astore 14
    //   600: iload 4
    //   602: istore_3
    //   603: goto -507 -> 96
    //   606: goto -465 -> 141
    //   609: lconst_0
    //   610: lstore 12
    //   612: lconst_0
    //   613: lstore 10
    //   615: goto -179 -> 436
    //   618: iload 4
    //   620: iconst_1
    //   621: iadd
    //   622: istore 4
    //   624: goto -244 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	QimSegmentMergeUtil
    //   0	627	1	paramList	java.util.List
    //   0	627	2	paramString	java.lang.String
    //   0	627	3	paramInt1	int
    //   0	627	4	paramInt2	int
    //   0	627	5	paramMediaFormat	android.media.MediaFormat
    //   1	542	6	i	int
    //   124	88	7	j	int
    //   334	158	8	l1	long
    //   460	1	10	localObject1	Object
    //   511	103	10	l2	long
    //   462	1	12	localObject2	Object
    //   494	117	12	l3	long
    //   92	19	14	localException1	java.lang.Exception
    //   243	350	14	localIterator	java.util.Iterator
    //   598	1	14	localException2	java.lang.Exception
    //   19	527	15	localObject3	Object
    //   162	264	16	localObject4	Object
    //   234	188	17	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   21	47	92	java/lang/Exception
    //   367	377	470	java/io/IOException
    //   301	322	559	java/lang/Exception
    //   324	333	559	java/lang/Exception
    //   336	367	559	java/lang/Exception
    //   367	377	559	java/lang/Exception
    //   380	433	559	java/lang/Exception
    //   436	450	559	java/lang/Exception
    //   455	460	559	java/lang/Exception
    //   471	484	559	java/lang/Exception
    //   486	496	559	java/lang/Exception
    //   503	513	559	java/lang/Exception
    //   513	532	559	java/lang/Exception
    //   534	556	559	java/lang/Exception
    //   581	589	559	java/lang/Exception
    //   245	287	591	java/lang/Exception
    //   287	301	591	java/lang/Exception
    //   58	90	598	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil
 * JD-Core Version:    0.7.0.1
 */