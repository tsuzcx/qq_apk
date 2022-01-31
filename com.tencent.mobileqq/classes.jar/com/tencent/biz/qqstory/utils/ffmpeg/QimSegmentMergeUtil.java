package com.tencent.biz.qqstory.utils.ffmpeg;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class QimSegmentMergeUtil
{
  public ArrayList a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 1)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l = -10L;
    while (paramList.hasNext())
    {
      l = MediaUtil.a((String)paramList.next()) + l;
      localArrayList.add(Long.valueOf(l));
    }
    if (localArrayList.size() > 1) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    return localArrayList;
  }
  
  public ArrayList a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 1) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    long l2 = MediaUtil.a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      l1 = MediaUtil.a((String)localIterator.next()) + l1;
      paramString.add(Long.valueOf(l1));
    }
    if (l1 > l2) {}
    for (l1 = (l1 - l2) / (paramList.size() - 1) / 2L;; l1 = 0L)
    {
      if (paramString.size() > 1) {
        paramString.remove(paramString.size() - 1);
      }
      l2 = -50L;
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        paramString.set(i, Long.valueOf(((Long)paramString.get(i)).longValue() - l1 + l2));
        l2 -= 2L * l1;
        i += 1;
      }
      return paramString;
    }
  }
  
  /* Error */
  public boolean a(List paramList, String paramString)
  {
    // Byte code:
    //   0: new 90	java/io/FileOutputStream
    //   3: dup
    //   4: new 92	java/io/File
    //   7: dup
    //   8: aload_2
    //   9: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: astore 6
    //   17: iconst_0
    //   18: istore_3
    //   19: aload 6
    //   21: astore_2
    //   22: iload_3
    //   23: aload_1
    //   24: invokeinterface 20 1 0
    //   29: if_icmpge +202 -> 231
    //   32: aload 6
    //   34: astore_2
    //   35: new 100	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_1
    //   40: iload_3
    //   41: invokeinterface 101 2 0
    //   46: checkcast 41	java/lang/String
    //   49: ldc 103
    //   51: invokespecial 106	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 6
    //   58: astore_2
    //   59: ldc 107
    //   61: newarray byte
    //   63: astore 8
    //   65: aload 7
    //   67: aload 8
    //   69: invokevirtual 111	java/io/RandomAccessFile:read	([B)I
    //   72: istore 4
    //   74: iload 4
    //   76: iconst_m1
    //   77: if_icmpeq +45 -> 122
    //   80: aload 6
    //   82: aload 8
    //   84: iconst_0
    //   85: iload 4
    //   87: invokevirtual 115	java/io/FileOutputStream:write	([BII)V
    //   90: goto -25 -> 65
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   98: aload 6
    //   100: astore_2
    //   101: aload 7
    //   103: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: ireturn
    //   122: aload 6
    //   124: astore_2
    //   125: aload 7
    //   127: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   130: iload_3
    //   131: iconst_1
    //   132: iadd
    //   133: istore_3
    //   134: goto -115 -> 19
    //   137: astore 7
    //   139: aload 6
    //   141: astore_2
    //   142: aload 7
    //   144: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   147: goto -17 -> 130
    //   150: astore_2
    //   151: aload 6
    //   153: astore_1
    //   154: aload_2
    //   155: astore 6
    //   157: aload_1
    //   158: astore_2
    //   159: aload 6
    //   161: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: aload 6
    //   177: astore_2
    //   178: aload_1
    //   179: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   182: goto -76 -> 106
    //   185: astore_1
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   201: goto -85 -> 116
    //   204: astore_1
    //   205: aload 6
    //   207: astore_2
    //   208: aload 7
    //   210: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   213: aload 6
    //   215: astore_2
    //   216: aload_1
    //   217: athrow
    //   218: astore 7
    //   220: aload 6
    //   222: astore_2
    //   223: aload 7
    //   225: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   228: goto -15 -> 213
    //   231: aload 6
    //   233: astore_2
    //   234: aload 6
    //   236: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   239: iconst_1
    //   240: istore 5
    //   242: aload 6
    //   244: ifnull -125 -> 119
    //   247: aload 6
    //   249: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   252: iconst_1
    //   253: ireturn
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   266: goto -94 -> 172
    //   269: astore_2
    //   270: aload_2
    //   271: invokevirtual 123	java/io/IOException:printStackTrace	()V
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
    //   0	290	1	paramList	List
    //   0	290	2	paramString	String
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
  public boolean a(List paramList, String paramString, int paramInt1, int paramInt2, android.media.MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload_3
    //   4: ifle +8 -> 12
    //   7: iload 4
    //   9: ifgt +600 -> 609
    //   12: new 126	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData
    //   15: dup
    //   16: invokespecial 127	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:<init>	()V
    //   19: astore 15
    //   21: aload_1
    //   22: iconst_0
    //   23: invokeinterface 101 2 0
    //   28: checkcast 41	java/lang/String
    //   31: aload 15
    //   33: invokestatic 132	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils:a	(Ljava/lang/String;Ldov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData;)I
    //   36: istore 6
    //   38: aload 15
    //   40: getfield 135	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   43: iconst_2
    //   44: iaload
    //   45: istore 4
    //   47: iload 4
    //   49: istore_3
    //   50: iload 6
    //   52: ifge +65 -> 117
    //   55: iload 4
    //   57: istore_3
    //   58: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +56 -> 117
    //   64: ldc 142
    //   66: iconst_2
    //   67: new 144	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   74: ldc 147
    //   76: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 6
    //   81: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 14
    //   94: iconst_0
    //   95: istore_3
    //   96: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +18 -> 117
    //   102: ldc 142
    //   104: iconst_2
    //   105: aload 14
    //   107: invokevirtual 165	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: aload 14
    //   112: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 15
    //   119: getfield 135	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   122: iconst_0
    //   123: iaload
    //   124: istore 7
    //   126: aload 15
    //   128: getfield 135	dov/com/tencent/mobileqq/shortvideo/util/MediaMetadataUtils$MetaData:a	[I
    //   131: iconst_1
    //   132: iaload
    //   133: istore 4
    //   135: iload_3
    //   136: istore 6
    //   138: iload 7
    //   140: istore_3
    //   141: invokestatic 173	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   144: ifeq +11 -> 155
    //   147: aload_1
    //   148: aload_2
    //   149: iload 6
    //   151: invokestatic 178	dov/com/tencent/mobileqq/shortvideo/util/HwVideoMerge:a	(Ljava/util/List;Ljava/lang/String;I)Z
    //   154: ireturn
    //   155: new 22	java/util/ArrayList
    //   158: dup
    //   159: invokespecial 23	java/util/ArrayList:<init>	()V
    //   162: astore 16
    //   164: iconst_0
    //   165: istore 7
    //   167: iload 7
    //   169: aload_1
    //   170: invokeinterface 20 1 0
    //   175: if_icmpge +41 -> 216
    //   178: aload 16
    //   180: new 180	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   183: dup
    //   184: aload_1
    //   185: iload 7
    //   187: invokeinterface 101 2 0
    //   192: checkcast 41	java/lang/String
    //   195: iconst_0
    //   196: iconst_0
    //   197: iconst_1
    //   198: invokespecial 183	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZ)V
    //   201: invokeinterface 184 2 0
    //   206: pop
    //   207: iload 7
    //   209: iconst_1
    //   210: iadd
    //   211: istore 7
    //   213: goto -46 -> 167
    //   216: new 186	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig
    //   219: dup
    //   220: aload_2
    //   221: iload_3
    //   222: iload 4
    //   224: getstatic 191	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:r	I
    //   227: iconst_1
    //   228: iconst_0
    //   229: iload 6
    //   231: invokespecial 194	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   234: astore 17
    //   236: aload 17
    //   238: iconst_1
    //   239: putfield 198	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:b	Z
    //   242: aconst_null
    //   243: astore 14
    //   245: ldc 199
    //   247: invokestatic 205	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   250: astore_1
    //   251: new 207	android/media/MediaCodec$BufferInfo
    //   254: dup
    //   255: invokespecial 208	android/media/MediaCodec$BufferInfo:<init>	()V
    //   258: astore 15
    //   260: new 92	java/io/File
    //   263: dup
    //   264: aload 17
    //   266: getfield 211	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:a	Ljava/lang/String;
    //   269: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload_2
    //   274: invokevirtual 214	java/io/File:exists	()Z
    //   277: ifne +10 -> 287
    //   280: aload_2
    //   281: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   284: invokestatic 222	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   287: new 224	android/media/MediaMuxer
    //   290: dup
    //   291: aload 17
    //   293: getfield 211	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:a	Ljava/lang/String;
    //   296: iconst_0
    //   297: invokespecial 227	android/media/MediaMuxer:<init>	(Ljava/lang/String;I)V
    //   300: astore_2
    //   301: aload_2
    //   302: aload 17
    //   304: getfield 230	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:g	I
    //   307: invokevirtual 234	android/media/MediaMuxer:setOrientationHint	(I)V
    //   310: aload_2
    //   311: aload 5
    //   313: invokevirtual 238	android/media/MediaMuxer:addTrack	(Landroid/media/MediaFormat;)I
    //   316: istore 6
    //   318: aload_2
    //   319: invokevirtual 241	android/media/MediaMuxer:start	()V
    //   322: iconst_1
    //   323: istore_3
    //   324: aload 16
    //   326: invokeinterface 27 1 0
    //   331: astore 14
    //   333: lconst_0
    //   334: lstore 8
    //   336: aload 14
    //   338: invokeinterface 35 1 0
    //   343: ifeq +241 -> 584
    //   346: aload 14
    //   348: invokeinterface 39 1 0
    //   353: checkcast 180	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   356: astore 16
    //   358: new 243	android/media/MediaExtractor
    //   361: dup
    //   362: invokespecial 244	android/media/MediaExtractor:<init>	()V
    //   365: astore 5
    //   367: aload 5
    //   369: aload 16
    //   371: getfield 245	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	Ljava/lang/String;
    //   374: invokevirtual 248	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   377: iconst_0
    //   378: istore 4
    //   380: iload 4
    //   382: aload 5
    //   384: invokevirtual 251	android/media/MediaExtractor:getTrackCount	()I
    //   387: if_icmpge +225 -> 612
    //   390: aload 5
    //   392: iload 4
    //   394: invokevirtual 255	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   397: astore 17
    //   399: aload 17
    //   401: ldc_w 257
    //   404: invokevirtual 263	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   407: ldc_w 265
    //   410: invokevirtual 269	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   413: ifeq +208 -> 621
    //   416: aload 5
    //   418: iload 4
    //   420: invokevirtual 272	android/media/MediaExtractor:selectTrack	(I)V
    //   423: aload 17
    //   425: ldc_w 274
    //   428: aload 16
    //   430: getfield 276	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:b	I
    //   433: invokevirtual 279	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   436: goto +176 -> 612
    //   439: aload_1
    //   440: invokevirtual 283	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   443: pop
    //   444: aload 5
    //   446: aload_1
    //   447: iconst_0
    //   448: invokevirtual 287	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   451: istore 4
    //   453: iload 4
    //   455: ifge +34 -> 489
    //   458: aload 5
    //   460: invokevirtual 290	android/media/MediaExtractor:release	()V
    //   463: lload 10
    //   465: lload 12
    //   467: ladd
    //   468: lstore 8
    //   470: goto -134 -> 336
    //   473: astore_1
    //   474: aload 5
    //   476: invokevirtual 290	android/media/MediaExtractor:release	()V
    //   479: aload_2
    //   480: invokevirtual 291	android/media/MediaMuxer:release	()V
    //   483: aload_1
    //   484: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   487: iconst_0
    //   488: ireturn
    //   489: aload 5
    //   491: invokevirtual 294	android/media/MediaExtractor:getSampleTime	()J
    //   494: lload 8
    //   496: ladd
    //   497: lstore 12
    //   499: lload 12
    //   501: lconst_0
    //   502: lcmp
    //   503: ifle +13 -> 516
    //   506: lload 12
    //   508: aload 15
    //   510: getfield 298	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   513: lsub
    //   514: lstore 10
    //   516: aload 15
    //   518: iconst_0
    //   519: putfield 301	android/media/MediaCodec$BufferInfo:offset	I
    //   522: aload 15
    //   524: iload 4
    //   526: putfield 303	android/media/MediaCodec$BufferInfo:size	I
    //   529: aload 15
    //   531: iload_3
    //   532: putfield 306	android/media/MediaCodec$BufferInfo:flags	I
    //   535: iconst_0
    //   536: istore_3
    //   537: aload 15
    //   539: lload 12
    //   541: putfield 298	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   544: aload_2
    //   545: iload 6
    //   547: aload_1
    //   548: aload 15
    //   550: invokevirtual 310	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   553: aload 5
    //   555: invokevirtual 313	android/media/MediaExtractor:advance	()Z
    //   558: pop
    //   559: goto -120 -> 439
    //   562: astore_1
    //   563: ldc 142
    //   565: iconst_2
    //   566: aload_1
    //   567: iconst_0
    //   568: anewarray 4	java/lang/Object
    //   571: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   574: aload_2
    //   575: ifnull +7 -> 582
    //   578: aload_2
    //   579: invokevirtual 291	android/media/MediaMuxer:release	()V
    //   582: iconst_0
    //   583: ireturn
    //   584: aload_2
    //   585: invokevirtual 319	android/media/MediaMuxer:stop	()V
    //   588: aload_2
    //   589: invokevirtual 291	android/media/MediaMuxer:release	()V
    //   592: iconst_1
    //   593: ireturn
    //   594: astore_1
    //   595: aload 14
    //   597: astore_2
    //   598: goto -35 -> 563
    //   601: astore 14
    //   603: iload 4
    //   605: istore_3
    //   606: goto -510 -> 96
    //   609: goto -468 -> 141
    //   612: lconst_0
    //   613: lstore 12
    //   615: lconst_0
    //   616: lstore 10
    //   618: goto -179 -> 439
    //   621: iload 4
    //   623: iconst_1
    //   624: iadd
    //   625: istore 4
    //   627: goto -247 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	QimSegmentMergeUtil
    //   0	630	1	paramList	List
    //   0	630	2	paramString	String
    //   0	630	3	paramInt1	int
    //   0	630	4	paramInt2	int
    //   0	630	5	paramMediaFormat	android.media.MediaFormat
    //   1	545	6	i	int
    //   124	88	7	j	int
    //   334	161	8	l1	long
    //   463	1	10	localObject1	Object
    //   514	103	10	l2	long
    //   465	1	12	localObject2	Object
    //   497	117	12	l3	long
    //   92	19	14	localException1	java.lang.Exception
    //   243	353	14	localIterator	Iterator
    //   601	1	14	localException2	java.lang.Exception
    //   19	530	15	localObject3	Object
    //   162	267	16	localObject4	Object
    //   234	190	17	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   21	47	92	java/lang/Exception
    //   367	377	473	java/io/IOException
    //   301	322	562	java/lang/Exception
    //   324	333	562	java/lang/Exception
    //   336	367	562	java/lang/Exception
    //   367	377	562	java/lang/Exception
    //   380	436	562	java/lang/Exception
    //   439	453	562	java/lang/Exception
    //   458	463	562	java/lang/Exception
    //   474	487	562	java/lang/Exception
    //   489	499	562	java/lang/Exception
    //   506	516	562	java/lang/Exception
    //   516	535	562	java/lang/Exception
    //   537	559	562	java/lang/Exception
    //   584	592	562	java/lang/Exception
    //   245	287	594	java/lang/Exception
    //   287	301	594	java/lang/Exception
    //   58	90	601	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil
 * JD-Core Version:    0.7.0.1
 */