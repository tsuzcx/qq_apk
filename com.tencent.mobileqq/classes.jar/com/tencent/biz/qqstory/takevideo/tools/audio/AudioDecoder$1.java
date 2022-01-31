package com.tencent.biz.qqstory.takevideo.tools.audio;

public class AudioDecoder$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: new 20	android/media/MediaExtractor
    //   6: dup
    //   7: invokespecial 23	android/media/MediaExtractor:<init>	()V
    //   10: astore 12
    //   12: aload 12
    //   14: aload_0
    //   15: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   18: invokevirtual 29	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   21: lconst_0
    //   22: lstore 5
    //   24: aconst_null
    //   25: astore 9
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload 12
    //   32: invokevirtual 33	android/media/MediaExtractor:getTrackCount	()I
    //   35: if_icmpge +818 -> 853
    //   38: aload 12
    //   40: iload_1
    //   41: invokevirtual 37	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   44: astore 11
    //   46: aload 11
    //   48: ldc 39
    //   50: invokevirtual 45	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 13
    //   55: aload 11
    //   57: ldc 47
    //   59: invokevirtual 51	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   62: lstore 5
    //   64: aload 13
    //   66: ldc 53
    //   68: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +85 -> 156
    //   74: aload 12
    //   76: iload_1
    //   77: invokevirtual 63	android/media/MediaExtractor:selectTrack	(I)V
    //   80: aload 10
    //   82: astore 9
    //   84: aload 13
    //   86: invokestatic 69	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   89: astore 10
    //   91: aload 10
    //   93: astore 9
    //   95: aload 10
    //   97: aload 11
    //   99: aconst_null
    //   100: aconst_null
    //   101: iconst_0
    //   102: invokevirtual 73	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   105: aload 11
    //   107: astore 9
    //   109: aload 10
    //   111: ifnonnull +56 -> 167
    //   114: ldc 75
    //   116: iconst_2
    //   117: ldc 77
    //   119: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload 12
    //   124: invokevirtual 86	android/media/MediaExtractor:release	()V
    //   127: return
    //   128: astore 9
    //   130: aload 9
    //   132: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   135: goto -114 -> 21
    //   138: astore 10
    //   140: aload 10
    //   142: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   145: aload 9
    //   147: astore 10
    //   149: aload 11
    //   151: astore 9
    //   153: goto -44 -> 109
    //   156: iload_1
    //   157: iconst_1
    //   158: iadd
    //   159: istore_1
    //   160: aload 11
    //   162: astore 9
    //   164: goto -135 -> 29
    //   167: aload 10
    //   169: invokevirtual 93	android/media/MediaCodec:start	()V
    //   172: aload 9
    //   174: ldc 95
    //   176: invokevirtual 99	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   179: istore_1
    //   180: aload 9
    //   182: ldc 101
    //   184: invokevirtual 99	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload_0
    //   189: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   192: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   195: iload_1
    //   196: iconst_2
    //   197: iload_2
    //   198: aload_0
    //   199: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   202: invokeinterface 113 5 0
    //   207: aload 10
    //   209: invokevirtual 117	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   212: astore 11
    //   214: aload 10
    //   216: invokevirtual 120	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   219: astore 9
    //   221: new 122	android/media/MediaCodec$BufferInfo
    //   224: dup
    //   225: invokespecial 123	android/media/MediaCodec$BufferInfo:<init>	()V
    //   228: astore 13
    //   230: iconst_0
    //   231: istore_1
    //   232: iconst_0
    //   233: istore_2
    //   234: aload_0
    //   235: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   238: invokestatic 126	xoi:a	(Lxoi;)Z
    //   241: ifne +191 -> 432
    //   244: iload_2
    //   245: ifne +617 -> 862
    //   248: aload 10
    //   250: ldc2_w 127
    //   253: invokevirtual 132	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   256: istore_3
    //   257: iload_3
    //   258: iflt +604 -> 862
    //   261: aload 12
    //   263: aload 11
    //   265: iload_3
    //   266: aaload
    //   267: iconst_0
    //   268: invokevirtual 136	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   271: istore 4
    //   273: aload 12
    //   275: invokevirtual 140	android/media/MediaExtractor:getSampleTime	()J
    //   278: lstore 7
    //   280: iload 4
    //   282: iflt +18 -> 300
    //   285: lload 5
    //   287: lconst_0
    //   288: lcmp
    //   289: ifle +210 -> 499
    //   292: lload 7
    //   294: lload 5
    //   296: lcmp
    //   297: iflt +202 -> 499
    //   300: aload_0
    //   301: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   304: invokestatic 143	xoi:b	(Lxoi;)Z
    //   307: ifeq +177 -> 484
    //   310: aload 10
    //   312: iload_3
    //   313: iconst_0
    //   314: iconst_0
    //   315: lconst_0
    //   316: iconst_0
    //   317: invokevirtual 147	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   320: aload 12
    //   322: lconst_0
    //   323: iconst_2
    //   324: invokevirtual 151	android/media/MediaExtractor:seekTo	(JI)V
    //   327: iload_1
    //   328: ifne +522 -> 850
    //   331: aload 10
    //   333: aload 13
    //   335: ldc2_w 127
    //   338: invokevirtual 155	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   341: istore_3
    //   342: iload_3
    //   343: tableswitch	default:+516 -> 859, -3:+177->520, -2:+201->544, -1:+239->582
    //   369: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   372: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   375: invokeinterface 158 1 0
    //   380: ifne +467 -> 847
    //   383: iconst_1
    //   384: istore_1
    //   385: aload 13
    //   387: getfield 162	android/media/MediaCodec$BufferInfo:flags	I
    //   390: iconst_4
    //   391: iand
    //   392: ifeq +207 -> 599
    //   395: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +11 -> 409
    //   401: ldc 75
    //   403: iconst_2
    //   404: ldc 167
    //   406: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_0
    //   410: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   413: invokestatic 143	xoi:b	(Lxoi;)Z
    //   416: ifne +320 -> 736
    //   419: iconst_1
    //   420: istore_1
    //   421: aload 10
    //   423: iload_3
    //   424: iconst_0
    //   425: invokevirtual 174	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   428: iload_1
    //   429: ifeq +415 -> 844
    //   432: aload 10
    //   434: invokevirtual 177	android/media/MediaCodec:stop	()V
    //   437: aload 10
    //   439: invokevirtual 178	android/media/MediaCodec:release	()V
    //   442: aload 12
    //   444: invokevirtual 86	android/media/MediaExtractor:release	()V
    //   447: aload_0
    //   448: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   451: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   454: aload_0
    //   455: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   458: invokeinterface 180 2 0
    //   463: return
    //   464: astore 11
    //   466: aload 11
    //   468: invokevirtual 90	java/lang/Throwable:printStackTrace	()V
    //   471: ldc 75
    //   473: iconst_2
    //   474: ldc 182
    //   476: aload 11
    //   478: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -309 -> 172
    //   484: aload 10
    //   486: iload_3
    //   487: iconst_0
    //   488: iconst_0
    //   489: lconst_0
    //   490: iconst_4
    //   491: invokevirtual 147	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   494: iconst_1
    //   495: istore_2
    //   496: goto -169 -> 327
    //   499: aload 10
    //   501: iload_3
    //   502: iconst_0
    //   503: iload 4
    //   505: lload 7
    //   507: iconst_0
    //   508: invokevirtual 147	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   511: aload 12
    //   513: invokevirtual 188	android/media/MediaExtractor:advance	()Z
    //   516: pop
    //   517: goto +345 -> 862
    //   520: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq +11 -> 534
    //   526: ldc 75
    //   528: iconst_2
    //   529: ldc 190
    //   531: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload 10
    //   536: invokevirtual 120	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   539: astore 9
    //   541: goto -113 -> 428
    //   544: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +303 -> 850
    //   550: ldc 75
    //   552: iconst_2
    //   553: new 192	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   560: ldc 195
    //   562: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 10
    //   567: invokevirtual 203	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   570: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: goto -151 -> 428
    //   582: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +265 -> 850
    //   588: ldc 75
    //   590: iconst_2
    //   591: ldc 212
    //   593: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: goto -168 -> 428
    //   599: aload 9
    //   601: iload_3
    //   602: aaload
    //   603: astore 14
    //   605: aload 14
    //   607: ifnonnull +14 -> 621
    //   610: ldc 75
    //   612: iconst_1
    //   613: ldc 214
    //   615: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: goto -190 -> 428
    //   621: aload 13
    //   623: getfield 217	android/media/MediaCodec$BufferInfo:size	I
    //   626: ifeq +31 -> 657
    //   629: aload 14
    //   631: aload 13
    //   633: getfield 220	android/media/MediaCodec$BufferInfo:offset	I
    //   636: invokevirtual 226	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   639: pop
    //   640: aload 14
    //   642: aload 13
    //   644: getfield 220	android/media/MediaCodec$BufferInfo:offset	I
    //   647: aload 13
    //   649: getfield 217	android/media/MediaCodec$BufferInfo:size	I
    //   652: iadd
    //   653: invokevirtual 229	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   656: pop
    //   657: aload 14
    //   659: invokevirtual 232	java/nio/ByteBuffer:remaining	()I
    //   662: istore 4
    //   664: iload 4
    //   666: newarray byte
    //   668: astore 15
    //   670: aload 14
    //   672: aload 15
    //   674: iconst_0
    //   675: iload 4
    //   677: invokevirtual 236	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   680: pop
    //   681: aload_0
    //   682: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   685: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   688: aload 15
    //   690: iconst_0
    //   691: iload 4
    //   693: aload_0
    //   694: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   697: invokeinterface 239 5 0
    //   702: goto -281 -> 421
    //   705: astore 14
    //   707: ldc 75
    //   709: iconst_1
    //   710: new 192	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   717: ldc 241
    //   719: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload 14
    //   724: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   727: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: goto -315 -> 421
    //   739: astore 9
    //   741: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +32 -> 776
    //   747: ldc 75
    //   749: iconst_2
    //   750: new 192	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   757: ldc 244
    //   759: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload 9
    //   764: invokestatic 249	bhsw:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   767: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload 10
    //   778: invokevirtual 177	android/media/MediaCodec:stop	()V
    //   781: aload 10
    //   783: invokevirtual 178	android/media/MediaCodec:release	()V
    //   786: aload 12
    //   788: invokevirtual 86	android/media/MediaExtractor:release	()V
    //   791: aload_0
    //   792: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   795: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   798: aload_0
    //   799: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   802: invokeinterface 180 2 0
    //   807: return
    //   808: astore 9
    //   810: aload 10
    //   812: invokevirtual 177	android/media/MediaCodec:stop	()V
    //   815: aload 10
    //   817: invokevirtual 178	android/media/MediaCodec:release	()V
    //   820: aload 12
    //   822: invokevirtual 86	android/media/MediaExtractor:release	()V
    //   825: aload_0
    //   826: getfield 103	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:this$0	Lxoi;
    //   829: invokestatic 108	xoi:a	(Lxoi;)Lxoj;
    //   832: aload_0
    //   833: getfield 25	com/tencent/biz/qqstory/takevideo/tools/audio/AudioDecoder$1:a	Ljava/lang/String;
    //   836: invokeinterface 180 2 0
    //   841: aload 9
    //   843: athrow
    //   844: goto -610 -> 234
    //   847: goto -462 -> 385
    //   850: goto -422 -> 428
    //   853: aconst_null
    //   854: astore 10
    //   856: goto -747 -> 109
    //   859: goto -491 -> 368
    //   862: goto -535 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	1
    //   28	401	1	i	int
    //   187	309	2	j	int
    //   256	346	3	k	int
    //   271	421	4	m	int
    //   22	273	5	l1	long
    //   278	228	7	l2	long
    //   25	83	9	localObject1	Object
    //   128	18	9	localIOException	java.io.IOException
    //   151	449	9	localObject2	Object
    //   739	24	9	localException1	java.lang.Exception
    //   808	34	9	localObject3	Object
    //   1	109	10	localMediaCodec	android.media.MediaCodec
    //   138	3	10	localThrowable1	java.lang.Throwable
    //   147	708	10	localObject4	Object
    //   44	220	11	localObject5	Object
    //   464	13	11	localThrowable2	java.lang.Throwable
    //   10	811	12	localMediaExtractor	android.media.MediaExtractor
    //   53	595	13	localObject6	Object
    //   603	68	14	localObject7	Object
    //   705	18	14	localException2	java.lang.Exception
    //   668	21	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	21	128	java/io/IOException
    //   84	91	138	java/lang/Throwable
    //   95	105	138	java/lang/Throwable
    //   167	172	464	java/lang/Throwable
    //   610	618	705	java/lang/Exception
    //   621	657	705	java/lang/Exception
    //   657	702	705	java/lang/Exception
    //   234	244	739	java/lang/Exception
    //   248	257	739	java/lang/Exception
    //   261	280	739	java/lang/Exception
    //   300	327	739	java/lang/Exception
    //   331	342	739	java/lang/Exception
    //   368	383	739	java/lang/Exception
    //   385	409	739	java/lang/Exception
    //   409	419	739	java/lang/Exception
    //   421	428	739	java/lang/Exception
    //   484	494	739	java/lang/Exception
    //   499	517	739	java/lang/Exception
    //   520	534	739	java/lang/Exception
    //   534	541	739	java/lang/Exception
    //   544	579	739	java/lang/Exception
    //   582	596	739	java/lang/Exception
    //   707	736	739	java/lang/Exception
    //   234	244	808	finally
    //   248	257	808	finally
    //   261	280	808	finally
    //   300	327	808	finally
    //   331	342	808	finally
    //   368	383	808	finally
    //   385	409	808	finally
    //   409	419	808	finally
    //   421	428	808	finally
    //   484	494	808	finally
    //   499	517	808	finally
    //   520	534	808	finally
    //   534	541	808	finally
    //   544	579	808	finally
    //   582	596	808	finally
    //   610	618	808	finally
    //   621	657	808	finally
    //   657	702	808	finally
    //   707	736	808	finally
    //   741	776	808	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.AudioDecoder.1
 * JD-Core Version:    0.7.0.1
 */