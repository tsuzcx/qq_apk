package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;

public class Video2Video
{
  public static String a = "Video2Video";
  private Mp4ReEncoder b;
  private final Object c = new Object();
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  private void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, int paramInt)
  {
    if (paramInt != 0)
    {
      paramEncodeConfig.m = paramInt;
      paramEncodeConfig.l = 0;
    }
    paramInt = Math.min(paramEncodeConfig.c, paramEncodeConfig.d);
    int i = Math.max(paramEncodeConfig.c, paramEncodeConfig.d);
    paramEncodeConfig.c = paramInt;
    paramEncodeConfig.d = i;
    paramDecodeConfig.width = paramEncodeConfig.c;
    paramDecodeConfig.height = paramEncodeConfig.d;
  }
  
  private boolean a()
  {
    if (this.f) {
      return false;
    }
    return this.d;
  }
  
  /* Error */
  public boolean a(SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +685 -> 686
    //   4: aload_1
    //   5: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   8: ifnonnull +6 -> 14
    //   11: goto +675 -> 686
    //   14: aload_0
    //   15: new 76	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder
    //   18: dup
    //   19: invokespecial 77	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder:<init>	()V
    //   22: putfield 79	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:b	Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder;
    //   25: new 81	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 82	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 10
    //   34: aload 10
    //   36: aload_1
    //   37: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   40: getfield 87	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   43: invokevirtual 91	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   50: aload 10
    //   52: bipush 19
    //   54: invokevirtual 95	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   57: invokestatic 101	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: putfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   63: aload_1
    //   64: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   67: aload 10
    //   69: bipush 18
    //   71: invokevirtual 95	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   74: invokestatic 101	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: putfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   80: aload_1
    //   81: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   84: aload 10
    //   86: bipush 24
    //   88: invokevirtual 95	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   91: invokestatic 101	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: putfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   97: goto +20 -> 117
    //   100: astore_1
    //   101: goto +578 -> 679
    //   104: astore 11
    //   106: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +8 -> 117
    //   112: aload 11
    //   114: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   117: aload 10
    //   119: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   122: aload_1
    //   123: getfield 125	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:i	J
    //   126: lstore 5
    //   128: aload_1
    //   129: getfield 128	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:j	J
    //   132: lstore 7
    //   134: aload_1
    //   135: getfield 130	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:f	Ljava/lang/String;
    //   138: astore 10
    //   140: aload_1
    //   141: getfield 133	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:k	Ljava/lang/String;
    //   144: astore 11
    //   146: aload_1
    //   147: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   150: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   153: istore_2
    //   154: aload_1
    //   155: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   158: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   161: istore_2
    //   162: aload_0
    //   163: aload_1
    //   164: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   167: invokevirtual 136	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:b	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   170: istore 4
    //   172: new 34	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   175: dup
    //   176: aload 11
    //   178: sipush 720
    //   181: sipush 1280
    //   184: getstatic 141	com/tencent/mobileqq/editor/composite/CodecParam:mMaxrate	I
    //   187: iconst_1
    //   188: iconst_0
    //   189: aload_1
    //   190: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   193: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   196: invokespecial 144	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   199: astore 12
    //   201: aload 12
    //   203: sipush 720
    //   206: putfield 43	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:c	I
    //   209: aload 12
    //   211: sipush 1280
    //   214: putfield 45	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:d	I
    //   217: aload_1
    //   218: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   221: astore 13
    //   223: aload 13
    //   225: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   228: bipush 90
    //   230: if_icmpeq +26 -> 256
    //   233: aload 13
    //   235: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   238: sipush 270
    //   241: if_icmpne +6 -> 247
    //   244: goto +12 -> 256
    //   247: aload 13
    //   249: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   252: istore_2
    //   253: goto +9 -> 262
    //   256: aload 13
    //   258: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   261: istore_2
    //   262: aload 13
    //   264: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   267: bipush 90
    //   269: if_icmpeq +26 -> 295
    //   272: aload 13
    //   274: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   277: sipush 270
    //   280: if_icmpne +6 -> 286
    //   283: goto +12 -> 295
    //   286: aload 13
    //   288: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   291: istore_3
    //   292: goto +9 -> 301
    //   295: aload 13
    //   297: getfield 107	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   300: istore_3
    //   301: iload_2
    //   302: i2f
    //   303: iload_3
    //   304: i2f
    //   305: fdiv
    //   306: ldc 145
    //   308: fcmpl
    //   309: iflt +23 -> 332
    //   312: iload_2
    //   313: iload_3
    //   314: sipush 720
    //   317: sipush 1280
    //   320: invokestatic 150	com/tencent/biz/qqstory/utils/VideoUtils:a	(IIII)Z
    //   323: ifeq +9 -> 332
    //   326: aload 12
    //   328: iconst_1
    //   329: putfield 153	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:r	Z
    //   332: new 56	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   335: dup
    //   336: aload_1
    //   337: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   340: getfield 87	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   343: iconst_0
    //   344: iconst_0
    //   345: iconst_1
    //   346: aload_1
    //   347: getfield 125	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:i	J
    //   350: aload_1
    //   351: getfield 128	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:j	J
    //   354: invokespecial 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZJJ)V
    //   357: astore 13
    //   359: aload_0
    //   360: aload 13
    //   362: aload 12
    //   364: iload 4
    //   366: invokespecial 158	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;I)V
    //   369: aload 13
    //   371: iconst_1
    //   372: putfield 161	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   375: aload 13
    //   377: aload_1
    //   378: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   381: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   384: putfield 164	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   387: aload 13
    //   389: aload_0
    //   390: aload_1
    //   391: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   394: invokevirtual 167	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   397: putfield 170	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   400: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +151 -> 554
    //   406: getstatic 172	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	Ljava/lang/String;
    //   409: astore 14
    //   411: new 174	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   418: astore 15
    //   420: aload 15
    //   422: ldc 177
    //   424: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 15
    //   430: aload 10
    //   432: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 15
    //   438: ldc 183
    //   440: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 15
    //   446: aload 11
    //   448: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 15
    //   454: ldc 185
    //   456: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 15
    //   462: lload 5
    //   464: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 15
    //   470: ldc 190
    //   472: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 15
    //   478: lload 7
    //   480: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 15
    //   486: ldc 192
    //   488: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 15
    //   494: aload_1
    //   495: getfield 74	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   498: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   501: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 15
    //   507: ldc 197
    //   509: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 15
    //   515: aload 12
    //   517: getfield 38	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:m	I
    //   520: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 15
    //   526: ldc 199
    //   528: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 15
    //   534: aload 13
    //   536: getfield 170	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   539: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 14
    //   545: iconst_2
    //   546: aload 15
    //   548: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: aload_0
    //   555: getfield 79	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:b	Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder;
    //   558: aload 13
    //   560: aload 12
    //   562: new 211	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video$1
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 214	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/slideshow/Video2Video;)V
    //   570: aconst_null
    //   571: invokevirtual 217	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder$EncodeFilterRender;)V
    //   574: aload_0
    //   575: getfield 24	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:c	Ljava/lang/Object;
    //   578: astore_1
    //   579: aload_1
    //   580: monitorenter
    //   581: aload_0
    //   582: getfield 30	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:f	Z
    //   585: ifne +31 -> 616
    //   588: aload_0
    //   589: getfield 26	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:d	Z
    //   592: ifne +24 -> 616
    //   595: aload_0
    //   596: getfield 28	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:e	Z
    //   599: istore 9
    //   601: iload 9
    //   603: ifne +13 -> 616
    //   606: aload_0
    //   607: getfield 24	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:c	Ljava/lang/Object;
    //   610: invokevirtual 220	java/lang/Object:wait	()V
    //   613: goto -32 -> 581
    //   616: aload_1
    //   617: monitorexit
    //   618: aload_0
    //   619: invokespecial 222	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	()Z
    //   622: istore 9
    //   624: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +42 -> 669
    //   630: getstatic 172	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	Ljava/lang/String;
    //   633: astore_1
    //   634: new 174	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   641: astore 10
    //   643: aload 10
    //   645: ldc 224
    //   647: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 10
    //   653: iload 9
    //   655: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload_1
    //   660: iconst_2
    //   661: aload 10
    //   663: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: iload 9
    //   671: ireturn
    //   672: astore 10
    //   674: aload_1
    //   675: monitorexit
    //   676: aload 10
    //   678: athrow
    //   679: aload 10
    //   681: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   684: aload_1
    //   685: athrow
    //   686: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   689: ifeq +12 -> 701
    //   692: getstatic 172	com/tencent/biz/qqstory/takevideo/slideshow/Video2Video:a	Ljava/lang/String;
    //   695: iconst_2
    //   696: ldc 226
    //   698: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: iconst_0
    //   702: ireturn
    //   703: astore 10
    //   705: goto -124 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	Video2Video
    //   0	708	1	paramSlideItemInfo	SlideItemInfo
    //   153	160	2	i	int
    //   291	23	3	j	int
    //   170	195	4	k	int
    //   126	337	5	l1	long
    //   132	347	7	l2	long
    //   599	71	9	bool	boolean
    //   32	630	10	localObject1	Object
    //   672	8	10	localObject2	Object
    //   703	1	10	localInterruptedException	java.lang.InterruptedException
    //   104	9	11	localException	java.lang.Exception
    //   144	303	11	str1	String
    //   199	362	12	localEncodeConfig	EncodeConfig
    //   221	338	13	localObject3	Object
    //   409	135	14	str2	String
    //   418	129	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	97	100	finally
    //   106	117	100	finally
    //   34	97	104	java/lang/Exception
    //   581	601	672	finally
    //   606	613	672	finally
    //   616	618	672	finally
    //   674	676	672	finally
    //   606	613	703	java/lang/InterruptedException
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.mediaWidth;
    int j = paramLocalMediaInfo.mediaHeight;
    boolean bool = true;
    if (i > j)
    {
      if (paramLocalMediaInfo.rotation % 180 == 0) {
        return true;
      }
    }
    else
    {
      if (paramLocalMediaInfo.rotation == 90) {
        break label55;
      }
      if (paramLocalMediaInfo.rotation == 270) {
        return true;
      }
    }
    bool = false;
    label55:
    return bool;
  }
  
  public int b(LocalMediaInfo paramLocalMediaInfo)
  {
    if (a(paramLocalMediaInfo)) {
      return paramLocalMediaInfo.rotation + 90;
    }
    return paramLocalMediaInfo.rotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Video2Video
 * JD-Core Version:    0.7.0.1
 */