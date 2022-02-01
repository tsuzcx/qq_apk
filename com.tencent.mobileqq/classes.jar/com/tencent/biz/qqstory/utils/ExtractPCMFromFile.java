package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;

@TargetApi(16)
public class ExtractPCMFromFile
{
  private int jdField_a_of_type_Int;
  private ByteOrder jdField_a_of_type_JavaNioByteOrder = ByteOrder.nativeOrder();
  
  public static void a(MediaFormat paramMediaFormat)
  {
    int i = paramMediaFormat.getInteger("max-input-size");
    if ((i <= 0) || (i > 134217728))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("max-input-size overflow ! ");
      localStringBuilder.append(i);
      localStringBuilder.append(" > ");
      localStringBuilder.append(134217728);
      QLog.e("ExtractPCMFromFile", 1, "fixACodec22885421: ", new Exception(localStringBuilder.toString()));
      paramMediaFormat.setInteger("max-input-size", 134217728);
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 35	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 78
    //   19: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: iload_1
    //   26: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 49
    //   32: iconst_2
    //   33: aload 6
    //   35: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aconst_null
    //   42: astore 8
    //   44: aconst_null
    //   45: astore 7
    //   47: aload 7
    //   49: astore 6
    //   51: bipush 88
    //   53: newarray byte
    //   55: astore 9
    //   57: iconst_0
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: aload 7
    //   63: astore 6
    //   65: iload_2
    //   66: aload 9
    //   68: arraylength
    //   69: if_icmpge +15 -> 84
    //   72: aload 9
    //   74: iload_2
    //   75: iconst_m1
    //   76: bastore
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -20 -> 61
    //   84: aload 7
    //   86: astore 6
    //   88: new 84	java/io/BufferedOutputStream
    //   91: dup
    //   92: new 86	java/io/FileOutputStream
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   100: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   103: astore_0
    //   104: lconst_0
    //   105: lstore 4
    //   107: lload 4
    //   109: iload_1
    //   110: i2l
    //   111: lcmp
    //   112: ifge +18 -> 130
    //   115: aload_0
    //   116: aload 9
    //   118: invokevirtual 94	java/io/BufferedOutputStream:write	([B)V
    //   121: lload 4
    //   123: lconst_1
    //   124: ladd
    //   125: lstore 4
    //   127: goto -20 -> 107
    //   130: aload 9
    //   132: arraylength
    //   133: iload_1
    //   134: imul
    //   135: istore_2
    //   136: iload_1
    //   137: i2f
    //   138: ldc 95
    //   140: fmul
    //   141: f2i
    //   142: iconst_2
    //   143: idiv
    //   144: iconst_2
    //   145: imul
    //   146: iload_2
    //   147: iadd
    //   148: istore_1
    //   149: iload_1
    //   150: sipush 2048
    //   153: iload_1
    //   154: sipush 2048
    //   157: irem
    //   158: isub
    //   159: iadd
    //   160: iload_2
    //   161: isub
    //   162: istore_2
    //   163: iload_2
    //   164: ifle +22 -> 186
    //   167: iload_3
    //   168: istore_1
    //   169: iload_1
    //   170: iload_2
    //   171: if_icmpge +15 -> 186
    //   174: aload_0
    //   175: iconst_m1
    //   176: invokevirtual 98	java/io/BufferedOutputStream:write	(I)V
    //   179: iload_1
    //   180: iconst_1
    //   181: iadd
    //   182: istore_1
    //   183: goto -14 -> 169
    //   186: aload_0
    //   187: invokevirtual 101	java/io/BufferedOutputStream:flush	()V
    //   190: aload_0
    //   191: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   194: return
    //   195: astore 7
    //   197: aload_0
    //   198: astore 6
    //   200: aload 7
    //   202: astore_0
    //   203: goto +46 -> 249
    //   206: astore 7
    //   208: goto +12 -> 220
    //   211: astore_0
    //   212: goto +37 -> 249
    //   215: astore 7
    //   217: aload 8
    //   219: astore_0
    //   220: aload_0
    //   221: astore 6
    //   223: ldc 49
    //   225: iconst_1
    //   226: aload 7
    //   228: invokevirtual 105	java/lang/Exception:toString	()Ljava/lang/String;
    //   231: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: ifnull +13 -> 248
    //   238: aload_0
    //   239: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   242: return
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   248: return
    //   249: aload 6
    //   251: ifnull +18 -> 269
    //   254: aload 6
    //   256: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   259: goto +10 -> 269
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   269: goto +5 -> 274
    //   272: aload_0
    //   273: athrow
    //   274: goto -2 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramString	String
    //   0	277	1	paramInt	int
    //   60	112	2	i	int
    //   58	110	3	j	int
    //   105	21	4	l	long
    //   13	242	6	localObject1	Object
    //   262	3	6	localIOException	IOException
    //   45	40	7	localObject2	Object
    //   195	6	7	localObject3	Object
    //   206	1	7	localException1	Exception
    //   215	12	7	localException2	Exception
    //   42	176	8	localObject4	Object
    //   55	76	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   115	121	195	finally
    //   130	149	195	finally
    //   174	179	195	finally
    //   186	190	195	finally
    //   115	121	206	java/lang/Exception
    //   130	149	206	java/lang/Exception
    //   174	179	206	java/lang/Exception
    //   186	190	206	java/lang/Exception
    //   51	57	211	finally
    //   65	72	211	finally
    //   88	104	211	finally
    //   223	234	211	finally
    //   51	57	215	java/lang/Exception
    //   65	72	215	java/lang/Exception
    //   88	104	215	java/lang/Exception
    //   190	194	243	java/io/IOException
    //   238	242	243	java/io/IOException
    //   254	259	262	java/io/IOException
  }
  
  private void b(String paramString, SlideItemInfo paramSlideItemInfo)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    File localFile = new File(paramString);
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int j = localMediaExtractor.getTrackCount();
      paramString = null;
      int i = 0;
      while (i < j)
      {
        paramString = localMediaExtractor.getTrackFormat(i);
        if (paramString.getString("mime").startsWith("audio/"))
        {
          localMediaExtractor.selectTrack(i);
          break;
        }
        i += 1;
      }
      if ((i != j) && (paramString != null))
      {
        paramString.getInteger("channel-count");
        this.jdField_a_of_type_Int = AudioSampleRateExtract.a(paramString);
        paramSlideItemInfo.c = this.jdField_a_of_type_Int;
        localMediaExtractor.release();
        return;
      }
      paramString = new StringBuilder();
      paramString.append("No audio track found in ");
      paramString.append(localFile);
      QLog.w("ExtractPCMFromFile", 1, paramString.toString());
      localMediaExtractor.release();
      paramSlideItemInfo.a = false;
      return;
    }
    catch (IOException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDataSource exception: ");
      localStringBuilder.append(localFile);
      QLog.w("ExtractPCMFromFile", 1, localStringBuilder.toString(), paramString);
      localMediaExtractor.release();
      paramSlideItemInfo.a = false;
    }
  }
  
  /* Error */
  private boolean b(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
  {
    // Byte code:
    //   0: new 114	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 115	android/media/MediaExtractor:<init>	()V
    //   7: astore 20
    //   9: new 117	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   17: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 21
    //   22: aload 20
    //   24: aload_1
    //   25: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   28: invokevirtual 121	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   31: aload 20
    //   33: invokevirtual 125	android/media/MediaExtractor:getTrackCount	()I
    //   36: istore 9
    //   38: aconst_null
    //   39: astore 19
    //   41: aconst_null
    //   42: astore 18
    //   44: aconst_null
    //   45: astore 17
    //   47: aconst_null
    //   48: astore 16
    //   50: iconst_0
    //   51: istore 8
    //   53: iload 8
    //   55: iload 9
    //   57: if_icmpge +46 -> 103
    //   60: aload 20
    //   62: iload 8
    //   64: invokevirtual 129	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   67: astore 16
    //   69: aload 16
    //   71: ldc 131
    //   73: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc 137
    //   78: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   81: ifeq +13 -> 94
    //   84: aload 20
    //   86: iload 8
    //   88: invokevirtual 146	android/media/MediaExtractor:selectTrack	(I)V
    //   91: goto +12 -> 103
    //   94: iload 8
    //   96: iconst_1
    //   97: iadd
    //   98: istore 8
    //   100: goto -47 -> 53
    //   103: iload 8
    //   105: iload 9
    //   107: if_icmpeq +771 -> 878
    //   110: aload 16
    //   112: ifnonnull +6 -> 118
    //   115: goto +763 -> 878
    //   118: aload 16
    //   120: invokestatic 191	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Landroid/media/MediaFormat;)V
    //   123: iload_2
    //   124: ifle +15 -> 139
    //   127: aload 20
    //   129: iload_2
    //   130: i2l
    //   131: ldc2_w 192
    //   134: lmul
    //   135: iconst_2
    //   136: invokevirtual 197	android/media/MediaExtractor:seekTo	(JI)V
    //   139: aload 16
    //   141: ldc 199
    //   143: invokevirtual 203	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   146: lstore 12
    //   148: iload_3
    //   149: i2f
    //   150: aload_1
    //   151: getfield 207	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   154: l2f
    //   155: fdiv
    //   156: fstore 7
    //   158: fload 7
    //   160: fconst_0
    //   161: fcmpl
    //   162: ifeq +14 -> 176
    //   165: fload 7
    //   167: fstore 6
    //   169: fload 7
    //   171: fconst_1
    //   172: fcmpl
    //   173: ifle +6 -> 179
    //   176: fconst_1
    //   177: fstore 6
    //   179: fload 6
    //   181: lload 12
    //   183: l2f
    //   184: fmul
    //   185: f2l
    //   186: lstore 14
    //   188: lload 14
    //   190: lconst_0
    //   191: lcmp
    //   192: ifne +6 -> 198
    //   195: goto +7 -> 202
    //   198: lload 14
    //   200: lstore 12
    //   202: aload 16
    //   204: aload_1
    //   205: getfield 189	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   208: invokestatic 210	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   211: istore 10
    //   213: aload_0
    //   214: aload 16
    //   216: invokestatic 153	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;)I
    //   219: putfield 155	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:jdField_a_of_type_Int	I
    //   222: aload 5
    //   224: aload_0
    //   225: getfield 155	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:jdField_a_of_type_Int	I
    //   228: putfield 160	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:c	I
    //   231: aload 16
    //   233: ldc 131
    //   235: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 216	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   241: astore 21
    //   243: aload 21
    //   245: aload 16
    //   247: aconst_null
    //   248: aconst_null
    //   249: iconst_0
    //   250: invokevirtual 220	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   253: aload 21
    //   255: invokevirtual 223	android/media/MediaCodec:start	()V
    //   258: new 225	android/media/MediaCodec$BufferInfo
    //   261: dup
    //   262: invokespecial 226	android/media/MediaCodec$BufferInfo:<init>	()V
    //   265: astore 16
    //   267: aload 19
    //   269: astore_1
    //   270: new 84	java/io/BufferedOutputStream
    //   273: dup
    //   274: new 86	java/io/FileOutputStream
    //   277: dup
    //   278: aload 4
    //   280: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   283: invokespecial 90	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   286: astore 5
    //   288: iconst_2
    //   289: invokestatic 232	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   292: aload_0
    //   293: getfield 22	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:jdField_a_of_type_JavaNioByteOrder	Ljava/nio/ByteOrder;
    //   296: invokevirtual 236	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   299: astore 18
    //   301: aload 18
    //   303: invokevirtual 240	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   306: astore 19
    //   308: iconst_0
    //   309: istore_2
    //   310: aload 17
    //   312: astore 4
    //   314: aload 21
    //   316: ldc2_w 241
    //   319: invokevirtual 246	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   322: istore 9
    //   324: iload 9
    //   326: iflt +76 -> 402
    //   329: aload 21
    //   331: invokevirtual 250	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   334: iload 9
    //   336: aaload
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 254	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   342: pop
    //   343: aload 20
    //   345: aload_1
    //   346: iconst_0
    //   347: invokevirtual 258	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   350: istore_3
    //   351: aload 20
    //   353: invokevirtual 262	android/media/MediaExtractor:getSampleTime	()J
    //   356: lstore 14
    //   358: iload_3
    //   359: iflt +622 -> 981
    //   362: lload 12
    //   364: lconst_0
    //   365: lcmp
    //   366: ifle +609 -> 975
    //   369: lload 14
    //   371: lload 12
    //   373: lcmp
    //   374: iflt +601 -> 975
    //   377: goto +604 -> 981
    //   380: aload 21
    //   382: iload 9
    //   384: iconst_0
    //   385: iload_3
    //   386: lload 14
    //   388: iload 8
    //   390: invokevirtual 266	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   393: aload 20
    //   395: invokevirtual 269	android/media/MediaExtractor:advance	()Z
    //   398: pop
    //   399: goto +50 -> 449
    //   402: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +44 -> 449
    //   408: new 35	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   415: astore_1
    //   416: aload_1
    //   417: ldc_w 271
    //   420: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_1
    //   425: iload 9
    //   427: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_1
    //   432: ldc_w 273
    //   435: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: ldc 49
    //   441: iconst_2
    //   442: aload_1
    //   443: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload 21
    //   451: aload 16
    //   453: ldc2_w 241
    //   456: invokevirtual 277	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   459: istore 11
    //   461: iload 11
    //   463: iflt +238 -> 701
    //   466: aload 16
    //   468: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   471: ifle +192 -> 663
    //   474: aload 4
    //   476: ifnonnull +15 -> 491
    //   479: aload 16
    //   481: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   484: invokestatic 232	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   487: astore_1
    //   488: goto +28 -> 516
    //   491: aload 4
    //   493: astore_1
    //   494: aload 4
    //   496: invokevirtual 283	java/nio/ByteBuffer:capacity	()I
    //   499: aload 16
    //   501: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   504: if_icmpge +12 -> 516
    //   507: aload 16
    //   509: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   512: invokestatic 232	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   515: astore_1
    //   516: aload_1
    //   517: invokevirtual 286	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   520: pop
    //   521: aload 21
    //   523: invokevirtual 289	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   526: iload 11
    //   528: aaload
    //   529: aload_1
    //   530: invokevirtual 293	java/nio/ByteBuffer:array	()[B
    //   533: iconst_0
    //   534: aload 16
    //   536: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   539: invokevirtual 297	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   542: pop
    //   543: aload_1
    //   544: aload_0
    //   545: getfield 22	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:jdField_a_of_type_JavaNioByteOrder	Ljava/nio/ByteOrder;
    //   548: invokevirtual 236	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   551: invokevirtual 240	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   554: astore 4
    //   556: iconst_0
    //   557: istore_3
    //   558: iload_3
    //   559: aload 16
    //   561: getfield 280	android/media/MediaCodec$BufferInfo:size	I
    //   564: if_icmpge +83 -> 647
    //   567: iconst_0
    //   568: istore 8
    //   570: iconst_0
    //   571: istore 9
    //   573: iload 8
    //   575: iload 10
    //   577: if_icmpge +22 -> 599
    //   580: iload 9
    //   582: aload 4
    //   584: invokevirtual 302	java/nio/ShortBuffer:get	()S
    //   587: iadd
    //   588: istore 9
    //   590: iload 8
    //   592: iconst_1
    //   593: iadd
    //   594: istore 8
    //   596: goto -23 -> 573
    //   599: iload 9
    //   601: iload 10
    //   603: idiv
    //   604: istore 8
    //   606: aload 19
    //   608: invokevirtual 303	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   611: pop
    //   612: aload 19
    //   614: iload 8
    //   616: i2s
    //   617: invokevirtual 307	java/nio/ShortBuffer:put	(S)Ljava/nio/ShortBuffer;
    //   620: pop
    //   621: aload 19
    //   623: invokevirtual 303	java/nio/ShortBuffer:rewind	()Ljava/nio/Buffer;
    //   626: pop
    //   627: aload 5
    //   629: aload 18
    //   631: invokevirtual 293	java/nio/ByteBuffer:array	()[B
    //   634: invokevirtual 94	java/io/BufferedOutputStream:write	([B)V
    //   637: iload_3
    //   638: iload 10
    //   640: iconst_2
    //   641: imul
    //   642: iadd
    //   643: istore_3
    //   644: goto -86 -> 558
    //   647: aload_1
    //   648: astore 4
    //   650: aload 16
    //   652: getfield 310	android/media/MediaCodec$BufferInfo:flags	I
    //   655: iconst_4
    //   656: iand
    //   657: ifeq +21 -> 678
    //   660: goto +334 -> 994
    //   663: ldc 49
    //   665: iconst_2
    //   666: ldc_w 312
    //   669: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aload 4
    //   674: astore_1
    //   675: goto +319 -> 994
    //   678: aload 21
    //   680: invokevirtual 289	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   683: iload 11
    //   685: aaload
    //   686: invokevirtual 254	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   689: pop
    //   690: aload 21
    //   692: iload 11
    //   694: iconst_0
    //   695: invokevirtual 316	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   698: goto +3 -> 701
    //   701: iload_2
    //   702: ifeq +25 -> 727
    //   705: aload 20
    //   707: invokevirtual 163	android/media/MediaExtractor:release	()V
    //   710: aload 21
    //   712: invokevirtual 319	android/media/MediaCodec:stop	()V
    //   715: aload 21
    //   717: invokevirtual 320	android/media/MediaCodec:release	()V
    //   720: aload 5
    //   722: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   725: iconst_1
    //   726: ireturn
    //   727: goto -413 -> 314
    //   730: astore_1
    //   731: goto +94 -> 825
    //   734: astore_1
    //   735: aload 5
    //   737: astore 4
    //   739: aload_1
    //   740: astore 5
    //   742: goto +20 -> 762
    //   745: astore 4
    //   747: aload_1
    //   748: astore 5
    //   750: aload 4
    //   752: astore_1
    //   753: goto +72 -> 825
    //   756: astore 5
    //   758: aload 18
    //   760: astore 4
    //   762: aload 4
    //   764: astore_1
    //   765: ldc 49
    //   767: iconst_2
    //   768: aload 5
    //   770: invokevirtual 321	java/lang/Throwable:toString	()Ljava/lang/String;
    //   773: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload 20
    //   778: invokevirtual 163	android/media/MediaExtractor:release	()V
    //   781: aload 21
    //   783: invokevirtual 319	android/media/MediaCodec:stop	()V
    //   786: aload 21
    //   788: invokevirtual 320	android/media/MediaCodec:release	()V
    //   791: aload 4
    //   793: ifnull +30 -> 823
    //   796: aload 4
    //   798: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   801: goto +22 -> 823
    //   804: astore_1
    //   805: ldc 49
    //   807: iconst_1
    //   808: ldc_w 323
    //   811: aload_1
    //   812: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   815: goto +8 -> 823
    //   818: astore_1
    //   819: aload_1
    //   820: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   823: iconst_0
    //   824: ireturn
    //   825: aload 20
    //   827: invokevirtual 163	android/media/MediaExtractor:release	()V
    //   830: aload 21
    //   832: invokevirtual 319	android/media/MediaCodec:stop	()V
    //   835: aload 21
    //   837: invokevirtual 320	android/media/MediaCodec:release	()V
    //   840: aload 5
    //   842: ifnull +34 -> 876
    //   845: aload 5
    //   847: invokevirtual 104	java/io/BufferedOutputStream:close	()V
    //   850: goto +26 -> 876
    //   853: astore 4
    //   855: ldc 49
    //   857: iconst_1
    //   858: ldc_w 323
    //   861: aload 4
    //   863: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   866: goto +10 -> 876
    //   869: astore 4
    //   871: aload 4
    //   873: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   876: aload_1
    //   877: athrow
    //   878: new 35	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   885: astore_1
    //   886: aload_1
    //   887: ldc 165
    //   889: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload_1
    //   894: aload 21
    //   896: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: ldc 49
    //   902: iconst_1
    //   903: aload_1
    //   904: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: aload 20
    //   912: invokevirtual 163	android/media/MediaExtractor:release	()V
    //   915: aload 5
    //   917: iconst_0
    //   918: putfield 174	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Z
    //   921: iconst_0
    //   922: ireturn
    //   923: astore_1
    //   924: new 35	java/lang/StringBuilder
    //   927: dup
    //   928: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   931: astore 4
    //   933: aload 4
    //   935: ldc_w 327
    //   938: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload 4
    //   944: aload 21
    //   946: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: ldc 49
    //   952: iconst_1
    //   953: aload 4
    //   955: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: aload_1
    //   959: invokestatic 178	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   962: aload 20
    //   964: invokevirtual 163	android/media/MediaExtractor:release	()V
    //   967: aload 5
    //   969: iconst_0
    //   970: putfield 174	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Z
    //   973: iconst_0
    //   974: ireturn
    //   975: iconst_0
    //   976: istore 8
    //   978: goto -598 -> 380
    //   981: ldc2_w 328
    //   984: lstore 14
    //   986: iconst_0
    //   987: istore_3
    //   988: iconst_4
    //   989: istore 8
    //   991: goto -611 -> 380
    //   994: iconst_1
    //   995: istore_2
    //   996: aload_1
    //   997: astore 4
    //   999: goto -321 -> 678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	ExtractPCMFromFile
    //   0	1002	1	paramLocalMediaInfo	LocalMediaInfo
    //   0	1002	2	paramInt1	int
    //   0	1002	3	paramInt2	int
    //   0	1002	4	paramString	String
    //   0	1002	5	paramSlideItemInfo	SlideItemInfo
    //   167	13	6	f1	float
    //   156	14	7	f2	float
    //   51	939	8	i	int
    //   36	568	9	j	int
    //   211	431	10	k	int
    //   459	234	11	m	int
    //   146	226	12	l1	long
    //   186	799	14	l2	long
    //   48	603	16	localObject1	Object
    //   45	266	17	localObject2	Object
    //   42	717	18	localByteBuffer	java.nio.ByteBuffer
    //   39	583	19	localShortBuffer	java.nio.ShortBuffer
    //   7	956	20	localMediaExtractor	MediaExtractor
    //   20	925	21	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   288	308	730	finally
    //   314	324	730	finally
    //   329	358	730	finally
    //   380	399	730	finally
    //   402	449	730	finally
    //   449	461	730	finally
    //   466	474	730	finally
    //   479	488	730	finally
    //   494	516	730	finally
    //   516	556	730	finally
    //   558	567	730	finally
    //   580	590	730	finally
    //   599	637	730	finally
    //   650	660	730	finally
    //   663	672	730	finally
    //   678	698	730	finally
    //   288	308	734	java/lang/Throwable
    //   314	324	734	java/lang/Throwable
    //   329	358	734	java/lang/Throwable
    //   380	399	734	java/lang/Throwable
    //   402	449	734	java/lang/Throwable
    //   449	461	734	java/lang/Throwable
    //   466	474	734	java/lang/Throwable
    //   479	488	734	java/lang/Throwable
    //   494	516	734	java/lang/Throwable
    //   516	556	734	java/lang/Throwable
    //   558	567	734	java/lang/Throwable
    //   580	590	734	java/lang/Throwable
    //   599	637	734	java/lang/Throwable
    //   650	660	734	java/lang/Throwable
    //   663	672	734	java/lang/Throwable
    //   678	698	734	java/lang/Throwable
    //   270	288	745	finally
    //   765	776	745	finally
    //   270	288	756	java/lang/Throwable
    //   720	725	804	java/lang/StackOverflowError
    //   796	801	804	java/lang/StackOverflowError
    //   720	725	818	java/io/IOException
    //   796	801	818	java/io/IOException
    //   845	850	853	java/lang/StackOverflowError
    //   845	850	869	java/io/IOException
    //   22	31	923	java/io/IOException
  }
  
  public void a(String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.a = true;
      b(paramString, paramSlideItemInfo);
      return;
    }
    catch (IOException paramString)
    {
      label12:
      break label12;
    }
    QLog.e("ExtractPCMFromFile", 2, "Exception : getMetaDataFromFile ERROR");
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, String paramString, SlideItemInfo paramSlideItemInfo)
  {
    try
    {
      paramSlideItemInfo.a = true;
      boolean bool = b(paramLocalMediaInfo, paramInt1, paramInt2, paramString, paramSlideItemInfo);
      return bool;
    }
    catch (IOException paramLocalMediaInfo)
    {
      label22:
      break label22;
    }
    QLog.e("ExtractPCMFromFile", 2, "Exception : getPCMFromFile ERROR");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ExtractPCMFromFile
 * JD-Core Version:    0.7.0.1
 */