package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.aelight.camera.log.AEQLog;

public class MediaUtil
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
    catch (RuntimeException paramString)
    {
      AEQLog.a(a, "[getVideoDuration]", paramString);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AEQLog.a(a, "[getVideoDuration]", paramString);
    }
    return 0L;
  }
  
  /* Error */
  @TargetApi(10)
  public static android.graphics.Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 63	com/tencent/biz/qqstory/utils/FileUtils:i	(Ljava/lang/String;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: iload_2
    //   9: ifne +57 -> 66
    //   12: getstatic 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	Ljava/lang/String;
    //   15: astore_3
    //   16: new 65	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   23: astore 4
    //   25: aload 4
    //   27: ldc 68
    //   29: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: aload_0
    //   36: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: ldc 74
    //   44: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: iload_1
    //   51: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: new 24	android/media/MediaMetadataRetriever
    //   69: dup
    //   70: invokespecial 25	android/media/MediaMetadataRetriever:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload_0
    //   81: invokevirtual 29	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: astore_3
    //   87: aload 4
    //   89: iload_1
    //   90: i2l
    //   91: ldc2_w 88
    //   94: lmul
    //   95: iconst_0
    //   96: invokevirtual 93	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: aload_0
    //   101: astore_3
    //   102: aload 4
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 36	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_3
    //   110: areturn
    //   111: astore_3
    //   112: aload 4
    //   114: astore_0
    //   115: aload_3
    //   116: astore 4
    //   118: goto +13 -> 131
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_3
    //   124: goto +33 -> 157
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: astore_3
    //   133: getstatic 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	Ljava/lang/String;
    //   136: iconst_1
    //   137: ldc 95
    //   139: aload 4
    //   141: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload 5
    //   150: astore_3
    //   151: goto -46 -> 105
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 36	android/media/MediaMetadataRetriever:release	()V
    //   165: goto +5 -> 170
    //   168: aload_0
    //   169: athrow
    //   170: goto -2 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   0	173	1	paramInt	int
    //   4	5	2	bool	boolean
    //   15	95	3	localObject1	Object
    //   111	5	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   123	39	3	localObject2	Object
    //   23	94	4	localObject3	Object
    //   127	13	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   6	143	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   78	84	111	java/lang/OutOfMemoryError
    //   87	100	111	java/lang/OutOfMemoryError
    //   66	75	121	finally
    //   66	75	127	java/lang/OutOfMemoryError
    //   78	84	156	finally
    //   87	100	156	finally
    //   133	144	156	finally
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, com.tencent.mobileqq.activity.photo.LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 19
    //   3: aconst_null
    //   4: astore 18
    //   6: aconst_null
    //   7: astore 17
    //   9: aload_1
    //   10: getfield 112	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   13: istore 6
    //   15: aload_1
    //   16: getfield 115	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   19: istore 7
    //   21: aload_1
    //   22: getfield 118	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   25: sipush 180
    //   28: irem
    //   29: ifeq +15 -> 44
    //   32: aload_1
    //   33: getfield 115	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   36: istore 6
    //   38: aload_1
    //   39: getfield 112	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   42: istore 7
    //   44: iconst_0
    //   45: istore 9
    //   47: aload_0
    //   48: iload 6
    //   50: iload 7
    //   52: iconst_0
    //   53: invokestatic 123	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:a	(Ljava/lang/String;IIZ)I
    //   56: ifne +401 -> 457
    //   59: invokestatic 129	com/tencent/maxvideo/trim/TrimNative:isGetFrameReady	()Z
    //   62: istore 15
    //   64: goto +3 -> 67
    //   67: iload 15
    //   69: ifeq +16 -> 85
    //   72: lload_2
    //   73: lload_2
    //   74: ldc2_w 130
    //   77: lsub
    //   78: invokestatic 134	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:a	(JJ)Landroid/graphics/Bitmap;
    //   81: astore_1
    //   82: goto +5 -> 87
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore 16
    //   90: aload_1
    //   91: ifnull +231 -> 322
    //   94: aload_1
    //   95: invokevirtual 140	android/graphics/Bitmap:getHeight	()I
    //   98: aload_1
    //   99: invokevirtual 143	android/graphics/Bitmap:getRowBytes	()I
    //   102: imul
    //   103: invokestatic 149	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   106: astore 16
    //   108: aload_1
    //   109: aload 16
    //   111: invokevirtual 153	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   114: aload 16
    //   116: invokevirtual 157	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   119: pop
    //   120: iload 6
    //   122: iload 7
    //   124: imul
    //   125: istore 13
    //   127: iload 13
    //   129: newarray int
    //   131: astore 20
    //   133: iload 9
    //   135: iload 13
    //   137: if_icmpge +141 -> 278
    //   140: aload 16
    //   142: invokevirtual 161	java/nio/ByteBuffer:get	()B
    //   145: istore 12
    //   147: aload 16
    //   149: invokevirtual 161	java/nio/ByteBuffer:get	()B
    //   152: istore 8
    //   154: aload 16
    //   156: invokevirtual 161	java/nio/ByteBuffer:get	()B
    //   159: istore 6
    //   161: aload 16
    //   163: invokevirtual 161	java/nio/ByteBuffer:get	()B
    //   166: istore 14
    //   168: iload 12
    //   170: istore 10
    //   172: iload 8
    //   174: istore 11
    //   176: iload 6
    //   178: istore 7
    //   180: iload 14
    //   182: ifle +331 -> 513
    //   185: iload 12
    //   187: istore 10
    //   189: iload 8
    //   191: istore 11
    //   193: iload 6
    //   195: istore 7
    //   197: iload 14
    //   199: sipush 255
    //   202: if_icmpeq +311 -> 513
    //   205: iload 12
    //   207: i2f
    //   208: fstore 4
    //   210: iload 14
    //   212: i2f
    //   213: fconst_1
    //   214: fmul
    //   215: fstore 5
    //   217: fload 4
    //   219: fconst_1
    //   220: fmul
    //   221: fload 5
    //   223: fdiv
    //   224: ldc 162
    //   226: fmul
    //   227: f2i
    //   228: istore 10
    //   230: iload 8
    //   232: i2f
    //   233: fconst_1
    //   234: fmul
    //   235: fload 5
    //   237: fdiv
    //   238: ldc 162
    //   240: fmul
    //   241: f2i
    //   242: istore 7
    //   244: iload 6
    //   246: i2f
    //   247: fconst_1
    //   248: fmul
    //   249: fload 5
    //   251: fdiv
    //   252: ldc 162
    //   254: fmul
    //   255: f2i
    //   256: istore 12
    //   258: iload 10
    //   260: istore 6
    //   262: iload 10
    //   264: sipush 255
    //   267: if_icmple +196 -> 463
    //   270: sipush 255
    //   273: istore 6
    //   275: goto +188 -> 463
    //   278: aload 20
    //   280: aload_1
    //   281: invokevirtual 165	android/graphics/Bitmap:getWidth	()I
    //   284: aload_1
    //   285: invokevirtual 140	android/graphics/Bitmap:getHeight	()I
    //   288: getstatic 171	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   291: invokestatic 175	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   294: astore 16
    //   296: goto +26 -> 322
    //   299: astore 16
    //   301: goto +7 -> 308
    //   304: astore 16
    //   306: aconst_null
    //   307: astore_1
    //   308: getstatic 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	Ljava/lang/String;
    //   311: iconst_1
    //   312: ldc 177
    //   314: aload 16
    //   316: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_1
    //   320: astore 16
    //   322: aload 16
    //   324: ifnonnull +130 -> 454
    //   327: aload 17
    //   329: astore_1
    //   330: new 24	android/media/MediaMetadataRetriever
    //   333: dup
    //   334: invokespecial 25	android/media/MediaMetadataRetriever:<init>	()V
    //   337: astore 17
    //   339: aload 17
    //   341: aload_0
    //   342: invokevirtual 29	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   345: aload 17
    //   347: ldc2_w 88
    //   350: lload_2
    //   351: lmul
    //   352: iconst_3
    //   353: invokevirtual 93	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   356: astore_0
    //   357: aload 17
    //   359: invokevirtual 36	android/media/MediaMetadataRetriever:release	()V
    //   362: aload_0
    //   363: areturn
    //   364: astore_0
    //   365: aload 17
    //   367: astore_1
    //   368: goto +76 -> 444
    //   371: astore_1
    //   372: aload 17
    //   374: astore_0
    //   375: aload_1
    //   376: astore 17
    //   378: goto +22 -> 400
    //   381: astore_1
    //   382: aload 17
    //   384: astore_0
    //   385: aload_1
    //   386: astore 17
    //   388: goto +32 -> 420
    //   391: astore_0
    //   392: goto +52 -> 444
    //   395: astore 17
    //   397: aload 19
    //   399: astore_0
    //   400: aload_0
    //   401: astore_1
    //   402: getstatic 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	Ljava/lang/String;
    //   405: iconst_1
    //   406: ldc 181
    //   408: aload 17
    //   410: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: aload_0
    //   414: ifnull +40 -> 454
    //   417: goto +20 -> 437
    //   420: aload_0
    //   421: astore_1
    //   422: getstatic 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	Ljava/lang/String;
    //   425: iconst_1
    //   426: ldc 177
    //   428: aload 17
    //   430: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   433: aload_0
    //   434: ifnull +20 -> 454
    //   437: aload_0
    //   438: invokevirtual 36	android/media/MediaMetadataRetriever:release	()V
    //   441: aload 16
    //   443: areturn
    //   444: aload_1
    //   445: ifnull +7 -> 452
    //   448: aload_1
    //   449: invokevirtual 36	android/media/MediaMetadataRetriever:release	()V
    //   452: aload_0
    //   453: athrow
    //   454: aload 16
    //   456: areturn
    //   457: iconst_0
    //   458: istore 15
    //   460: goto -393 -> 67
    //   463: iload 7
    //   465: istore 8
    //   467: iload 7
    //   469: sipush 255
    //   472: if_icmple +8 -> 480
    //   475: sipush 255
    //   478: istore 8
    //   480: iload 6
    //   482: istore 10
    //   484: iload 8
    //   486: istore 11
    //   488: iload 12
    //   490: istore 7
    //   492: iload 12
    //   494: sipush 255
    //   497: if_icmple +16 -> 513
    //   500: sipush 255
    //   503: istore 7
    //   505: iload 8
    //   507: istore 11
    //   509: iload 6
    //   511: istore 10
    //   513: aload 20
    //   515: iload 9
    //   517: iload 10
    //   519: bipush 16
    //   521: ishl
    //   522: ldc 182
    //   524: iand
    //   525: ldc 183
    //   527: ior
    //   528: iload 11
    //   530: bipush 8
    //   532: ishl
    //   533: ldc 184
    //   535: iand
    //   536: ior
    //   537: iload 7
    //   539: sipush 255
    //   542: iand
    //   543: ior
    //   544: iastore
    //   545: iload 9
    //   547: iconst_1
    //   548: iadd
    //   549: istore 9
    //   551: goto -418 -> 133
    //   554: astore 17
    //   556: aload 18
    //   558: astore_0
    //   559: goto -139 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	paramString	String
    //   0	562	1	paramLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   0	562	2	paramLong	long
    //   208	10	4	f1	float
    //   215	35	5	f2	float
    //   13	497	6	i	int
    //   19	524	7	j	int
    //   152	354	8	k	int
    //   45	505	9	m	int
    //   170	352	10	n	int
    //   174	359	11	i1	int
    //   145	353	12	i2	int
    //   125	13	13	i3	int
    //   166	45	14	i4	int
    //   62	397	15	bool	boolean
    //   88	207	16	localObject1	Object
    //   299	1	16	localThrowable1	java.lang.Throwable
    //   304	11	16	localThrowable2	java.lang.Throwable
    //   320	135	16	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   7	380	17	localObject2	Object
    //   395	34	17	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   554	1	17	localException	java.lang.Exception
    //   4	553	18	localObject3	Object
    //   1	397	19	localObject4	Object
    //   131	383	20	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   94	120	299	java/lang/Throwable
    //   127	133	299	java/lang/Throwable
    //   140	168	299	java/lang/Throwable
    //   217	258	299	java/lang/Throwable
    //   278	296	299	java/lang/Throwable
    //   9	21	304	java/lang/Throwable
    //   21	44	304	java/lang/Throwable
    //   47	64	304	java/lang/Throwable
    //   72	82	304	java/lang/Throwable
    //   339	357	364	finally
    //   339	357	371	java/lang/OutOfMemoryError
    //   339	357	381	java/lang/Exception
    //   330	339	391	finally
    //   402	413	391	finally
    //   422	433	391	finally
    //   330	339	395	java/lang/OutOfMemoryError
    //   330	339	554	java/lang/Exception
  }
  
  /* Error */
  public static MediaUtil.FrameWithoutBlackResult b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 14	java/lang/Object:<init>	()V
    //   7: astore_2
    //   8: new 190	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$FrameWithoutBlackResult
    //   11: dup
    //   12: invokespecial 191	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$FrameWithoutBlackResult:<init>	()V
    //   15: astore_3
    //   16: new 193	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator
    //   19: dup
    //   20: invokespecial 194	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator:<init>	()V
    //   23: astore 4
    //   25: aload 4
    //   27: invokestatic 200	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   30: invokevirtual 203	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator:a	(Landroid/os/Looper;)V
    //   33: aload 4
    //   35: aload_0
    //   36: aconst_null
    //   37: iconst_0
    //   38: sipush 480
    //   41: iload_1
    //   42: sipush 10000
    //   45: iconst_1
    //   46: iconst_1
    //   47: new 205	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$1
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 208	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$1:<init>	(Ljava/lang/Object;)V
    //   55: new 210	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$2
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 213	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$2:<init>	(Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil$FrameWithoutBlackResult;)V
    //   63: invokevirtual 216	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator:a	(Ljava/lang/String;Ljava/lang/String;ZIIIIZLcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/baoutils/common/Callbacks$Callback;Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/baoutils/common/Callbacks$Callback;)V
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_2
    //   69: ldc2_w 217
    //   72: invokevirtual 222	java/lang/Object:wait	(J)V
    //   75: goto +12 -> 87
    //   78: astore_0
    //   79: goto +12 -> 91
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 223	java/lang/InterruptedException:printStackTrace	()V
    //   87: aload_2
    //   88: monitorexit
    //   89: aload_3
    //   90: areturn
    //   91: aload_2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   0	95	1	paramInt	int
    //   7	85	2	localObject	Object
    //   15	75	3	localFrameWithoutBlackResult	MediaUtil.FrameWithoutBlackResult
    //   23	11	4	localMediaCodecThumbnailGenerator	com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator
    // Exception table:
    //   from	to	target	type
    //   68	75	78	finally
    //   83	87	78	finally
    //   87	89	78	finally
    //   91	93	78	finally
    //   68	75	82	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil
 * JD-Core Version:    0.7.0.1
 */