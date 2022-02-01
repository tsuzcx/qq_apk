package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl.CodecOutputSurface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Assert;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Locale;

@TargetApi(16)
public class MediaCodecThumbnailGenerator$CodecHandler
  extends Handler
{
  public MediaCodecThumbnailGenerator$CodecHandler(MediaCodecThumbnailGenerator paramMediaCodecThumbnailGenerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  private void a(MediaCodecThumbnailGenerator.ThumbnailArgs paramThumbnailArgs)
  {
    // Byte code:
    //   0: new 26	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext
    //   3: dup
    //   4: invokespecial 29	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: aload_1
    //   12: putfield 32	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs;
    //   15: aload 9
    //   17: aload_1
    //   18: getfield 37	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 42	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	(Ljava/lang/String;)J
    //   24: ldc2_w 43
    //   27: lmul
    //   28: putfield 48	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Long	J
    //   31: new 50	java/io/File
    //   34: dup
    //   35: aload_1
    //   36: getfield 37	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 11
    //   44: aload 11
    //   46: invokevirtual 57	java/io/File:canRead	()Z
    //   49: ifeq +446 -> 495
    //   52: new 59	android/media/MediaExtractor
    //   55: dup
    //   56: invokespecial 60	android/media/MediaExtractor:<init>	()V
    //   59: astore 10
    //   61: aload 10
    //   63: aload 11
    //   65: invokevirtual 64	java/io/File:toString	()Ljava/lang/String;
    //   68: invokevirtual 67	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   71: aload 10
    //   73: invokestatic 72	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/baoutils/media/VideoUtils:a	(Landroid/media/MediaExtractor;)I
    //   76: istore 5
    //   78: iload 5
    //   80: iflt +381 -> 461
    //   83: aload 10
    //   85: iload 5
    //   87: invokevirtual 76	android/media/MediaExtractor:selectTrack	(I)V
    //   90: aload_1
    //   91: getfield 79	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_b_of_type_Int	I
    //   94: istore 4
    //   96: aload_1
    //   97: getfield 82	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   100: newarray long
    //   102: astore 11
    //   104: aload_1
    //   105: getfield 82	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   108: newarray long
    //   110: astore 12
    //   112: iconst_0
    //   113: istore_3
    //   114: iload_3
    //   115: aload_1
    //   116: getfield 82	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   119: if_icmpge +51 -> 170
    //   122: iload 4
    //   124: i2l
    //   125: ldc2_w 43
    //   128: lmul
    //   129: lstore 6
    //   131: aload 10
    //   133: lload 6
    //   135: iconst_0
    //   136: invokevirtual 86	android/media/MediaExtractor:seekTo	(JI)V
    //   139: aload 12
    //   141: iload_3
    //   142: lload 6
    //   144: lastore
    //   145: aload 11
    //   147: iload_3
    //   148: aload 10
    //   150: invokevirtual 90	android/media/MediaExtractor:getSampleTime	()J
    //   153: lastore
    //   154: iload 4
    //   156: aload_1
    //   157: getfield 93	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:c	I
    //   160: iadd
    //   161: istore 4
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_3
    //   167: goto -53 -> 114
    //   170: aload 10
    //   172: aload 11
    //   174: iconst_0
    //   175: laload
    //   176: iconst_0
    //   177: invokevirtual 86	android/media/MediaExtractor:seekTo	(JI)V
    //   180: aload 10
    //   182: iload 5
    //   184: invokevirtual 97	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   187: astore 13
    //   189: aload 13
    //   191: ldc 99
    //   193: invokevirtual 105	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   196: istore 8
    //   198: iload 8
    //   200: ifeq +18 -> 218
    //   203: aload 9
    //   205: aload 13
    //   207: ldc 99
    //   209: invokevirtual 109	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   212: putfield 110	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   215: goto +49 -> 264
    //   218: new 112	android/media/MediaMetadataRetriever
    //   221: dup
    //   222: invokespecial 113	android/media/MediaMetadataRetriever:<init>	()V
    //   225: astore 14
    //   227: aload 14
    //   229: aload 9
    //   231: getfield 32	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs;
    //   234: getfield 37	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: invokevirtual 114	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   240: aload 14
    //   242: bipush 24
    //   244: invokevirtual 118	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   247: astore 15
    //   249: aload 9
    //   251: aload 15
    //   253: invokestatic 123	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   256: putfield 110	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   259: aload 14
    //   261: invokevirtual 126	android/media/MediaMetadataRetriever:release	()V
    //   264: aload 13
    //   266: ldc 128
    //   268: invokevirtual 109	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   271: istore_3
    //   272: aload 13
    //   274: ldc 130
    //   276: invokevirtual 109	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   279: istore 4
    //   281: new 132	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   288: astore 14
    //   290: aload 14
    //   292: ldc 135
    //   294: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 14
    //   300: iload 4
    //   302: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 14
    //   308: ldc 144
    //   310: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 14
    //   316: iload_3
    //   317: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 146
    //   323: aload 14
    //   325: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 152	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   331: pop
    //   332: aload_1
    //   333: getfield 154	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_Int	I
    //   336: i2f
    //   337: fconst_1
    //   338: fmul
    //   339: iload_3
    //   340: iload 4
    //   342: invokestatic 160	java/lang/Math:max	(II)I
    //   345: i2f
    //   346: fdiv
    //   347: fstore_2
    //   348: new 162	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface
    //   351: dup
    //   352: iload 4
    //   354: i2f
    //   355: fload_2
    //   356: fmul
    //   357: f2i
    //   358: iload_3
    //   359: i2f
    //   360: fload_2
    //   361: fmul
    //   362: f2i
    //   363: invokespecial 165	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:<init>	(II)V
    //   366: astore_1
    //   367: aload 13
    //   369: ldc 167
    //   371: invokevirtual 171	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: invokestatic 177	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   377: astore 14
    //   379: aload 14
    //   381: aload 13
    //   383: aload_1
    //   384: invokevirtual 180	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:a	()Landroid/view/Surface;
    //   387: aconst_null
    //   388: iconst_0
    //   389: invokevirtual 184	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   392: aload 14
    //   394: invokevirtual 187	android/media/MediaCodec:start	()V
    //   397: aload 9
    //   399: aload 10
    //   401: putfield 190	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   404: aload 9
    //   406: aload_1
    //   407: putfield 193	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglCodecOutputSurface	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface;
    //   410: aload 9
    //   412: aload 14
    //   414: putfield 196	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   417: aload 9
    //   419: iload 5
    //   421: putfield 197	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:c	I
    //   424: aload 9
    //   426: iconst_0
    //   427: putfield 198	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   430: aload 9
    //   432: iconst_0
    //   433: putfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   436: aload 9
    //   438: aload 11
    //   440: putfield 202	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ArrayOfLong	[J
    //   443: aload 9
    //   445: aload 12
    //   447: putfield 204	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_ArrayOfLong	[J
    //   450: aload_0
    //   451: iconst_2
    //   452: aload 9
    //   454: invokevirtual 208	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   457: invokevirtual 213	android/os/Message:sendToTarget	()V
    //   460: return
    //   461: new 132	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   468: astore_1
    //   469: aload_1
    //   470: ldc 215
    //   472: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_1
    //   477: aload 11
    //   479: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: new 220	java/lang/RuntimeException
    //   486: dup
    //   487: aload_1
    //   488: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokespecial 221	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   494: athrow
    //   495: new 132	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   502: astore_1
    //   503: aload_1
    //   504: ldc 223
    //   506: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_1
    //   511: aload 11
    //   513: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: new 225	java/io/FileNotFoundException
    //   520: dup
    //   521: aload_1
    //   522: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokespecial 226	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   528: athrow
    //   529: astore_1
    //   530: goto +72 -> 602
    //   533: astore_1
    //   534: ldc 146
    //   536: ldc 228
    //   538: aload_1
    //   539: invokestatic 232	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   542: pop
    //   543: aload_1
    //   544: instanceof 234
    //   547: ifeq +13 -> 560
    //   550: aload 9
    //   552: bipush 100
    //   554: putfield 198	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   557: goto +26 -> 583
    //   560: aload_1
    //   561: instanceof 220
    //   564: ifeq +13 -> 577
    //   567: aload 9
    //   569: bipush 101
    //   571: putfield 198	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   574: goto +9 -> 583
    //   577: aload 9
    //   579: iconst_m1
    //   580: putfield 198	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   583: ldc 146
    //   585: ldc 236
    //   587: aload_1
    //   588: invokestatic 241	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   591: aload_0
    //   592: iconst_4
    //   593: aload 9
    //   595: invokevirtual 208	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   598: invokevirtual 213	android/os/Message:sendToTarget	()V
    //   601: return
    //   602: goto +5 -> 607
    //   605: aload_1
    //   606: athrow
    //   607: goto -2 -> 605
    //   610: astore 14
    //   612: goto -348 -> 264
    //   615: astore 15
    //   617: goto -358 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	CodecHandler
    //   0	620	1	paramThumbnailArgs	MediaCodecThumbnailGenerator.ThumbnailArgs
    //   347	14	2	f	float
    //   113	246	3	i	int
    //   94	259	4	j	int
    //   76	344	5	k	int
    //   129	14	6	l	long
    //   196	3	8	bool	boolean
    //   7	587	9	localThumbnailTaskContext	MediaCodecThumbnailGenerator.ThumbnailTaskContext
    //   59	341	10	localMediaExtractor	MediaExtractor
    //   42	470	11	localObject1	Object
    //   110	336	12	arrayOfLong	long[]
    //   187	195	13	localMediaFormat	android.media.MediaFormat
    //   225	188	14	localObject2	Object
    //   610	1	14	localNullPointerException	java.lang.NullPointerException
    //   247	5	15	str	String
    //   615	1	15	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   31	78	529	finally
    //   83	112	529	finally
    //   114	122	529	finally
    //   131	139	529	finally
    //   145	163	529	finally
    //   170	198	529	finally
    //   203	215	529	finally
    //   218	249	529	finally
    //   249	259	529	finally
    //   259	264	529	finally
    //   264	460	529	finally
    //   461	495	529	finally
    //   495	529	529	finally
    //   534	557	529	finally
    //   560	574	529	finally
    //   577	583	529	finally
    //   583	601	529	finally
    //   31	78	533	java/lang/Exception
    //   83	112	533	java/lang/Exception
    //   114	122	533	java/lang/Exception
    //   131	139	533	java/lang/Exception
    //   145	163	533	java/lang/Exception
    //   170	198	533	java/lang/Exception
    //   203	215	533	java/lang/Exception
    //   218	249	533	java/lang/Exception
    //   249	259	533	java/lang/Exception
    //   259	264	533	java/lang/Exception
    //   264	460	533	java/lang/Exception
    //   461	495	533	java/lang/Exception
    //   495	529	533	java/lang/Exception
    //   203	215	610	java/lang/NullPointerException
    //   249	259	615	java/lang/NumberFormatException
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool;
    if (paramThumbnailTaskContext.jdField_a_of_type_Int != 0) {
      bool = false;
    } else {
      bool = true;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglCodecOutputSurface != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglCodecOutputSurface.a();
      paramThumbnailTaskContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglCodecOutputSurface = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    MediaCodecThumbnailGenerator.ThumbnailResult localThumbnailResult = new MediaCodecThumbnailGenerator.ThumbnailResult();
    localThumbnailResult.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList);
    localThumbnailResult.b = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList);
    localThumbnailResult.jdField_a_of_type_Int = paramThumbnailTaskContext.jdField_a_of_type_Int;
    if (bool)
    {
      localThumbnailResult.jdField_a_of_type_Boolean = (true ^ paramThumbnailTaskContext.jdField_a_of_type_Boolean);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasBlackThumbnail = ");
      localStringBuilder.append(localThumbnailResult.jdField_a_of_type_Boolean);
      SLog.c("MediaCodecThumbnailGen", localStringBuilder.toString());
      StoryReportor.a("actBlackThumbnailVideo", localThumbnailResult.jdField_a_of_type_Boolean, System.currentTimeMillis() - MediaCodecThumbnailGenerator.a(this.a), new String[0]);
    }
    this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramThumbnailTaskContext, bool, localThumbnailResult));
  }
  
  /* Error */
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 193	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglCodecOutputSurface	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface;
    //   4: astore 9
    //   6: aload_1
    //   7: getfield 32	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs;
    //   10: astore 16
    //   12: aload_1
    //   13: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   16: istore 7
    //   18: aload_1
    //   19: getfield 259	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: astore 13
    //   24: aload_1
    //   25: getfield 270	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   28: astore 14
    //   30: aload 9
    //   32: invokevirtual 323	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:c	()V
    //   35: aload 9
    //   37: invokevirtual 325	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:d	()V
    //   40: iconst_0
    //   41: istore 8
    //   43: aload 9
    //   45: iconst_0
    //   46: invokevirtual 328	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:a	(Z)V
    //   49: new 330	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress
    //   52: dup
    //   53: invokespecial 331	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:<init>	()V
    //   56: astore 15
    //   58: aload 9
    //   60: invokevirtual 334	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/opengl/CodecOutputSurface:a	()Landroid/graphics/Bitmap;
    //   63: astore 10
    //   65: aload 10
    //   67: astore 11
    //   69: aload 10
    //   71: ifnull +273 -> 344
    //   74: aload_1
    //   75: getfield 110	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   78: istore 6
    //   80: aload_1
    //   81: getfield 110	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   84: sipush 180
    //   87: irem
    //   88: ifle +16 -> 104
    //   91: aload 10
    //   93: invokevirtual 340	android/graphics/Bitmap:getWidth	()I
    //   96: aload 10
    //   98: invokevirtual 343	android/graphics/Bitmap:getHeight	()I
    //   101: if_icmplt +522 -> 623
    //   104: iload 6
    //   106: istore 5
    //   108: aload_1
    //   109: getfield 110	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   112: sipush 180
    //   115: irem
    //   116: ifne +23 -> 139
    //   119: iload 6
    //   121: istore 5
    //   123: aload 10
    //   125: invokevirtual 340	android/graphics/Bitmap:getWidth	()I
    //   128: aload 10
    //   130: invokevirtual 343	android/graphics/Bitmap:getHeight	()I
    //   133: if_icmple +6 -> 139
    //   136: goto +487 -> 623
    //   139: aload 10
    //   141: astore 9
    //   143: iload 5
    //   145: ifle +18 -> 163
    //   148: aload 10
    //   150: iload 5
    //   152: i2f
    //   153: invokestatic 348	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   156: astore 9
    //   158: aload 10
    //   160: invokevirtual 351	android/graphics/Bitmap:recycle	()V
    //   163: aload 14
    //   165: aload 9
    //   167: invokevirtual 357	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: aload 9
    //   173: astore 11
    //   175: iload_2
    //   176: ifeq +168 -> 344
    //   179: new 50	java/io/File
    //   182: dup
    //   183: aload 16
    //   185: getfield 359	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokestatic 365	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   191: aload_0
    //   192: iload 7
    //   194: invokevirtual 367	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:a	(I)Ljava/lang/String;
    //   197: iconst_0
    //   198: anewarray 369	java/lang/Object
    //   201: invokestatic 373	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: astore 12
    //   209: aconst_null
    //   210: astore 10
    //   212: new 377	java/io/BufferedOutputStream
    //   215: dup
    //   216: new 379	java/io/FileOutputStream
    //   219: dup
    //   220: aload 12
    //   222: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   225: invokespecial 385	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   228: astore 11
    //   230: aload 9
    //   232: getstatic 391	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   235: bipush 80
    //   237: aload 11
    //   239: invokevirtual 395	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   242: pop
    //   243: aload 11
    //   245: invokevirtual 398	java/io/BufferedOutputStream:close	()V
    //   248: aload 13
    //   250: aload 12
    //   252: invokevirtual 401	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   255: invokevirtual 357	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   258: pop
    //   259: aload 15
    //   261: aload 12
    //   263: invokevirtual 401	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   266: putfield 402	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   269: new 132	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   276: astore 10
    //   278: aload 10
    //   280: ldc_w 404
    //   283: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 10
    //   289: aload 12
    //   291: invokevirtual 407	java/io/File:getPath	()Ljava/lang/String;
    //   294: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 146
    //   300: aload 10
    //   302: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 285	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload 9
    //   310: astore 11
    //   312: goto +32 -> 344
    //   315: aload 10
    //   317: ifnull +8 -> 325
    //   320: aload 10
    //   322: invokevirtual 398	java/io/BufferedOutputStream:close	()V
    //   325: aload 11
    //   327: athrow
    //   328: astore 10
    //   330: ldc 146
    //   332: ldc_w 409
    //   335: aload 10
    //   337: invokestatic 241	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 9
    //   342: astore 11
    //   344: aload 15
    //   346: aload_1
    //   347: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   350: putfield 410	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_Int	I
    //   353: aload 15
    //   355: aload 11
    //   357: putfield 413	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   360: fconst_0
    //   361: fstore 4
    //   363: fload 4
    //   365: fstore_3
    //   366: aload 16
    //   368: getfield 415	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_b_of_type_Boolean	Z
    //   371: ifeq +68 -> 439
    //   374: fload 4
    //   376: fstore_3
    //   377: aload_1
    //   378: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   381: ifne +58 -> 439
    //   384: aload 11
    //   386: invokestatic 418	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator:a	(Landroid/graphics/Bitmap;)F
    //   389: fstore_3
    //   390: new 132	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   397: astore 9
    //   399: aload 9
    //   401: ldc_w 420
    //   404: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 9
    //   410: fload_3
    //   411: invokevirtual 423	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc 146
    //   417: aload 9
    //   419: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 285	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 15
    //   427: aload_1
    //   428: getfield 204	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_ArrayOfLong	[J
    //   431: aload_1
    //   432: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   435: laload
    //   436: putfield 425	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_Long	J
    //   439: fload_3
    //   440: ldc_w 426
    //   443: fcmpg
    //   444: iflt +71 -> 515
    //   447: aload 15
    //   449: getfield 425	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_Long	J
    //   452: ldc2_w 427
    //   455: lcmp
    //   456: ifgt +59 -> 515
    //   459: aload 15
    //   461: getfield 425	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_Long	J
    //   464: ldc2_w 429
    //   467: ladd
    //   468: aload_1
    //   469: getfield 48	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Long	J
    //   472: lcmp
    //   473: ifle +6 -> 479
    //   476: goto +39 -> 515
    //   479: aload_1
    //   480: getfield 204	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_ArrayOfLong	[J
    //   483: astore 9
    //   485: aload_1
    //   486: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   489: istore 5
    //   491: aload 9
    //   493: iload 5
    //   495: aload 9
    //   497: iload 5
    //   499: laload
    //   500: ldc2_w 431
    //   503: ladd
    //   504: lastore
    //   505: aload_0
    //   506: iconst_2
    //   507: aload_1
    //   508: invokevirtual 208	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   511: invokevirtual 213	android/os/Message:sendToTarget	()V
    //   514: return
    //   515: aload 13
    //   517: aload 15
    //   519: getfield 402	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   522: invokevirtual 357	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   525: pop
    //   526: aload 14
    //   528: aload 11
    //   530: invokevirtual 357	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   533: pop
    //   534: iload 8
    //   536: istore_2
    //   537: fload_3
    //   538: ldc_w 426
    //   541: fcmpg
    //   542: ifge +5 -> 547
    //   545: iconst_1
    //   546: istore_2
    //   547: aload_1
    //   548: iload_2
    //   549: putfield 276	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Boolean	Z
    //   552: aload_0
    //   553: getfield 13	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:a	Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator;
    //   556: getfield 307	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator:a	Landroid/os/Handler;
    //   559: new 434	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler$2
    //   562: dup
    //   563: aload_0
    //   564: aload_1
    //   565: aload 15
    //   567: invokespecial 437	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler$2:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler;Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext;Lcom/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailProgress;)V
    //   570: invokevirtual 316	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   573: pop
    //   574: aload_1
    //   575: aload_1
    //   576: getfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   579: iconst_1
    //   580: iadd
    //   581: putfield 199	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   584: aload_0
    //   585: iconst_2
    //   586: aload_1
    //   587: invokevirtual 208	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   590: invokevirtual 213	android/os/Message:sendToTarget	()V
    //   593: return
    //   594: aload_0
    //   595: aload_0
    //   596: iconst_3
    //   597: aload_1
    //   598: invokevirtual 208	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   601: ldc2_w 438
    //   604: invokevirtual 443	com/tencent/aelight/camera/aioeditor/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   607: pop
    //   608: ldc 146
    //   610: ldc_w 445
    //   613: invokestatic 246	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   616: pop
    //   617: return
    //   618: astore 9
    //   620: goto -26 -> 594
    //   623: iload 6
    //   625: bipush 90
    //   627: iadd
    //   628: istore 5
    //   630: goto -491 -> 139
    //   633: astore 12
    //   635: aload 11
    //   637: astore 10
    //   639: aload 12
    //   641: astore 11
    //   643: goto -328 -> 315
    //   646: astore 11
    //   648: goto -333 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	CodecHandler
    //   0	651	1	paramThumbnailTaskContext	MediaCodecThumbnailGenerator.ThumbnailTaskContext
    //   0	651	2	paramBoolean	boolean
    //   365	173	3	f1	float
    //   361	14	4	f2	float
    //   106	523	5	i	int
    //   78	550	6	j	int
    //   16	177	7	k	int
    //   41	494	8	bool	boolean
    //   4	492	9	localObject1	Object
    //   618	1	9	localTimeoutException	java.util.concurrent.TimeoutException
    //   63	258	10	localObject2	Object
    //   328	8	10	localIOException	java.io.IOException
    //   637	1	10	localObject3	Object
    //   67	575	11	localObject4	Object
    //   646	1	11	localObject5	Object
    //   207	83	12	localFile	java.io.File
    //   633	7	12	localObject6	Object
    //   22	494	13	localArrayList1	java.util.ArrayList
    //   28	499	14	localArrayList2	java.util.ArrayList
    //   56	510	15	localThumbnailProgress	MediaCodecThumbnailGenerator.ThumbnailProgress
    //   10	357	16	localThumbnailArgs	MediaCodecThumbnailGenerator.ThumbnailArgs
    // Exception table:
    //   from	to	target	type
    //   243	308	328	java/io/IOException
    //   320	325	328	java/io/IOException
    //   325	328	328	java/io/IOException
    //   30	40	618	java/util/concurrent/TimeoutException
    //   43	65	618	java/util/concurrent/TimeoutException
    //   74	104	618	java/util/concurrent/TimeoutException
    //   108	119	618	java/util/concurrent/TimeoutException
    //   123	136	618	java/util/concurrent/TimeoutException
    //   148	163	618	java/util/concurrent/TimeoutException
    //   163	171	618	java/util/concurrent/TimeoutException
    //   179	209	618	java/util/concurrent/TimeoutException
    //   243	308	618	java/util/concurrent/TimeoutException
    //   320	325	618	java/util/concurrent/TimeoutException
    //   325	328	618	java/util/concurrent/TimeoutException
    //   330	340	618	java/util/concurrent/TimeoutException
    //   344	360	618	java/util/concurrent/TimeoutException
    //   366	374	618	java/util/concurrent/TimeoutException
    //   377	439	618	java/util/concurrent/TimeoutException
    //   447	476	618	java/util/concurrent/TimeoutException
    //   479	491	618	java/util/concurrent/TimeoutException
    //   505	514	618	java/util/concurrent/TimeoutException
    //   515	534	618	java/util/concurrent/TimeoutException
    //   547	593	618	java/util/concurrent/TimeoutException
    //   230	243	633	finally
    //   212	230	646	finally
  }
  
  private void b(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    int k;
    long l;
    int i;
    int j;
    label178:
    label447:
    boolean bool;
    try
    {
      MediaExtractor localMediaExtractor = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec;
      MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
      long[] arrayOfLong = paramThumbnailTaskContext.jdField_a_of_type_ArrayOfLong;
      localObject1 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
      int m = paramThumbnailTaskContext.c;
      k = paramThumbnailTaskContext.d;
      l = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
      i = 0;
      j = 0;
      int n = 0;
      if ((j != 0) || (k >= localThumbnailArgs.d)) {
        break label842;
      }
      if ((paramThumbnailTaskContext.jdField_a_of_type_Long == arrayOfLong[k]) || (l >= arrayOfLong[k])) {
        break label807;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SeekTo: ");
      ((StringBuilder)localObject2).append(arrayOfLong[k]);
      Log.e("MediaCodecThumbnailGen", ((StringBuilder)localObject2).toString());
      localMediaExtractor.seekTo(arrayOfLong[k], 0);
      paramThumbnailTaskContext.jdField_a_of_type_Long = arrayOfLong[k];
      localMediaCodec.flush();
      if (n != 0) {
        break label810;
      }
      i1 = localMediaCodec.dequeueInputBuffer(-1L);
      if (i1 >= 0)
      {
        int i2 = localMediaExtractor.readSampleData(arrayOfByteBuffer[i1], 0);
        if (i2 < 0)
        {
          localMediaCodec.queueInputBuffer(i1, 0, 0, 0L, 4);
          Log.d("MediaCodecThumbnailGen", "sent input EOS");
          n = 1;
        }
        else
        {
          if (localMediaExtractor.getSampleTrackIndex() != m)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WEIRD: got sample from track ");
            ((StringBuilder)localObject2).append(localMediaExtractor.getSampleTrackIndex());
            ((StringBuilder)localObject2).append(", expected ");
            ((StringBuilder)localObject2).append(m);
            Log.w("MediaCodecThumbnailGen", ((StringBuilder)localObject2).toString());
          }
          localMediaCodec.queueInputBuffer(i1, 0, i2, localMediaExtractor.getSampleTime(), 0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("submitted frame ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" to dec, size=");
          ((StringBuilder)localObject2).append(i2);
          Log.d("MediaCodecThumbnailGen", ((StringBuilder)localObject2).toString());
          l = localMediaExtractor.getSampleTime();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("extractor sample time = ");
          ((StringBuilder)localObject2).append(l);
          Log.d("MediaCodecThumbnailGen", ((StringBuilder)localObject2).toString());
          localMediaExtractor.advance();
          i += 1;
        }
      }
      else
      {
        Log.d("MediaCodecThumbnailGen", "input buffer not available");
      }
      i1 = j;
      if (j != 0) {
        break label836;
      }
      i1 = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
      if (i1 == -1)
      {
        Log.d("MediaCodecThumbnailGen", "no output from decoder available");
        i1 = j;
        break label836;
      }
      if (i1 == -3)
      {
        Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
        i1 = j;
        break label836;
      }
      if (i1 == -2)
      {
        localObject2 = localMediaCodec.getOutputFormat();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decoder output format changed: ");
        localStringBuilder.append(localObject2);
        Log.d("MediaCodecThumbnailGen", localStringBuilder.toString());
        i1 = j;
        break label836;
      }
      if (i1 < 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unexpected result from decoder.dequeueOutputBuffer: ");
        ((StringBuilder)localObject2).append(i1);
        Assert.a(((StringBuilder)localObject2).toString());
        i1 = j;
        break label836;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("surface decoder given buffer ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(" (size=");
      ((StringBuilder)localObject2).append(localBufferInfo.size);
      ((StringBuilder)localObject2).append(")");
      Log.d("MediaCodecThumbnailGen", ((StringBuilder)localObject2).toString());
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label813;
      }
      Log.d("MediaCodecThumbnailGen", "output EOS");
      j = 1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      MediaCodec localMediaCodec;
      Object localObject1;
      label701:
      QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", localIllegalStateException);
      obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
      return;
    }
    localMediaCodec.releaseOutputBuffer(i1, bool);
    int i1 = j;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("awaiting decode of time: ");
      ((StringBuilder)localObject1).append(l);
      Log.d("MediaCodecThumbnailGen", ((StringBuilder)localObject1).toString());
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
        return;
      }
      obtainMessage(3, paramThumbnailTaskContext).sendToTarget();
      return;
      label807:
      break label178;
      label810:
      break label447;
      label813:
      if (l > localIllegalStateException[k])
      {
        bool = true;
        break label701;
      }
      bool = false;
      break label701;
      label836:
      j = i1;
      break;
      label842:
      i = 0;
    }
  }
  
  public String a(int paramInt)
  {
    return String.format(Locale.getDefault(), "thumbnail-%d.jpg", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
            SLog.c("MediaCodecThumbnailGen", "finishCapture");
            a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject);
          }
        }
        else
        {
          localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
          SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
          a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject, false);
        }
      }
      else
      {
        localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
        SLog.c("MediaCodecThumbnailGen", "decodeThumbnails");
        b((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject);
      }
    }
    else
    {
      localObject = (MediaCodecThumbnailGenerator.ThumbnailArgs)paramMessage.obj;
      SLog.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((MediaCodecThumbnailGenerator.ThumbnailArgs)localObject);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler
 * JD-Core Version:    0.7.0.1
 */