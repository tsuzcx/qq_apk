package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AudioDecoder$AudioPlayRunnable
  implements Runnable
{
  private float jdField_a_of_type_Float = 0.0F;
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  private volatile int jdField_b_of_type_Int = -1;
  public boolean b;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int = 0;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private int e = 0;
  
  public AudioDecoder$AudioPlayRunnable(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  private AudioTrack a()
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e != 1) {
          break label161;
        }
        i = 4;
        if (this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_b_of_type_Int != 16) {
          break label167;
        }
        j = 2;
        int k = AudioTrack.getMinBufferSize(this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_d_of_type_Int, i, j);
        AudioTrack localAudioTrack = new AudioTrack(3, this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_d_of_type_Int, i, j, k, 1);
        try
        {
          localAudioTrack.setStereoVolume(this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_a_of_type_Float, this.this$0.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_a_of_type_Float);
          localAudioTrack.play();
          return localAudioTrack;
        }
        catch (Throwable localThrowable1)
        {
          localObject = localAudioTrack;
        }
        QLog.e("AudioDecoder", 4, "AudioTrack init fail");
      }
      catch (Throwable localThrowable2) {}
      localThrowable2.printStackTrace();
      return localObject;
      label161:
      int i = 12;
      continue;
      label167:
      int j = 3;
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 88
    //   2: iconst_4
    //   3: ldc 103
    //   5: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aload_0
    //   15: invokespecial 107	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	()Landroid/media/AudioTrack;
    //   18: astore 9
    //   20: aload 9
    //   22: astore 8
    //   24: aload 9
    //   26: astore 7
    //   28: aload 9
    //   30: invokevirtual 111	android/media/AudioTrack:getSampleRate	()I
    //   33: aload 9
    //   35: invokevirtual 114	android/media/AudioTrack:getChannelConfiguration	()I
    //   38: aload 9
    //   40: invokevirtual 117	android/media/AudioTrack:getAudioFormat	()I
    //   43: invokestatic 75	android/media/AudioTrack:getMinBufferSize	(III)I
    //   46: iconst_2
    //   47: imul
    //   48: istore 4
    //   50: aload 9
    //   52: astore 8
    //   54: aload 9
    //   56: astore 7
    //   58: iload 4
    //   60: newarray byte
    //   62: astore 10
    //   64: aload 9
    //   66: astore 8
    //   68: aload 9
    //   70: astore 7
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 119	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Boolean	Z
    //   77: aload 9
    //   79: astore 8
    //   81: aload 9
    //   83: astore 7
    //   85: aload_0
    //   86: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   89: aload_1
    //   90: arraylength
    //   91: if_icmpge +723 -> 814
    //   94: aload 9
    //   96: astore 8
    //   98: aload 9
    //   100: astore 7
    //   102: aload_0
    //   103: getfield 119	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Boolean	Z
    //   106: ifne +708 -> 814
    //   109: aload 9
    //   111: astore 8
    //   113: aload 9
    //   115: astore 7
    //   117: aload_0
    //   118: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   121: ldc 48
    //   123: fcmpl
    //   124: ifeq +132 -> 256
    //   127: aload 9
    //   129: astore 8
    //   131: aload 9
    //   133: astore 7
    //   135: aload_0
    //   136: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   139: aload_0
    //   140: getfield 41	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   143: i2f
    //   144: fmul
    //   145: aload_0
    //   146: getfield 33	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   149: fdiv
    //   150: f2i
    //   151: istore_3
    //   152: aload 9
    //   154: astore 8
    //   156: aload 9
    //   158: astore 7
    //   160: iload_3
    //   161: aload_0
    //   162: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   165: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   168: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   171: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   174: irem
    //   175: istore 5
    //   177: iload_3
    //   178: istore_2
    //   179: iload 5
    //   181: ifeq +30 -> 211
    //   184: aload 9
    //   186: astore 8
    //   188: aload 9
    //   190: astore 7
    //   192: iload_3
    //   193: aload_0
    //   194: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   197: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   200: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   203: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   206: iload 5
    //   208: isub
    //   209: iadd
    //   210: istore_2
    //   211: aload 9
    //   213: astore 8
    //   215: aload 9
    //   217: astore 7
    //   219: aload_0
    //   220: iload_2
    //   221: aload_0
    //   222: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   225: isub
    //   226: putfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   229: aload 9
    //   231: astore 8
    //   233: aload 9
    //   235: astore 7
    //   237: aload 9
    //   239: invokevirtual 122	android/media/AudioTrack:flush	()V
    //   242: aload 9
    //   244: astore 8
    //   246: aload 9
    //   248: astore 7
    //   250: aload_0
    //   251: ldc 48
    //   253: putfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   256: aload 9
    //   258: astore 8
    //   260: aload 9
    //   262: astore 7
    //   264: aload_0
    //   265: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   268: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   271: getfield 123	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_Int	I
    //   274: istore_2
    //   275: iload_2
    //   276: iconst_1
    //   277: if_icmpeq +186 -> 463
    //   280: iload_2
    //   281: iconst_2
    //   282: if_icmpeq +156 -> 438
    //   285: iload_2
    //   286: iconst_3
    //   287: if_icmpeq +127 -> 414
    //   290: iload_2
    //   291: iconst_4
    //   292: if_icmpeq +97 -> 389
    //   295: iload_2
    //   296: iconst_5
    //   297: if_icmpeq +68 -> 365
    //   300: aload 9
    //   302: astore 8
    //   304: aload 9
    //   306: astore 7
    //   308: aload_1
    //   309: arraylength
    //   310: aload_0
    //   311: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   314: isub
    //   315: iload 4
    //   317: invokestatic 129	java/lang/Math:min	(II)I
    //   320: istore_3
    //   321: aload 9
    //   323: astore 8
    //   325: aload 9
    //   327: astore 7
    //   329: aload_0
    //   330: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   333: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   336: getfield 131	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_b_of_type_Boolean	Z
    //   339: ifne +554 -> 893
    //   342: aload 9
    //   344: astore 8
    //   346: aload 9
    //   348: astore 7
    //   350: aload 9
    //   352: aload_1
    //   353: aload_0
    //   354: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   357: iload_3
    //   358: invokevirtual 135	android/media/AudioTrack:write	([BII)I
    //   361: pop
    //   362: goto +531 -> 893
    //   365: aload 9
    //   367: astore 8
    //   369: aload 9
    //   371: astore 7
    //   373: aload_1
    //   374: aload_0
    //   375: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   378: aload 10
    //   380: iload 4
    //   382: invokestatic 140	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:c	([BI[BI)I
    //   385: istore_2
    //   386: goto +512 -> 898
    //   389: aload 9
    //   391: astore 8
    //   393: aload 9
    //   395: astore 7
    //   397: aload_1
    //   398: aload_0
    //   399: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   402: aload 10
    //   404: iload 4
    //   406: iconst_4
    //   407: invokestatic 143	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BII)I
    //   410: istore_2
    //   411: goto +487 -> 898
    //   414: aload 9
    //   416: astore 8
    //   418: aload 9
    //   420: astore 7
    //   422: aload_1
    //   423: aload_0
    //   424: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   427: aload 10
    //   429: iload 4
    //   431: invokestatic 145	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:b	([BI[BI)I
    //   434: istore_2
    //   435: goto +463 -> 898
    //   438: aload 9
    //   440: astore 8
    //   442: aload 9
    //   444: astore 7
    //   446: aload_1
    //   447: aload_0
    //   448: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   451: aload 10
    //   453: iload 4
    //   455: iconst_2
    //   456: invokestatic 143	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BII)I
    //   459: istore_2
    //   460: goto +438 -> 898
    //   463: aload 9
    //   465: astore 8
    //   467: aload 9
    //   469: astore 7
    //   471: aload_1
    //   472: aload_0
    //   473: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   476: aload 10
    //   478: iload 4
    //   480: invokestatic 147	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BI)I
    //   483: istore_2
    //   484: goto +414 -> 898
    //   487: aload 9
    //   489: astore 8
    //   491: aload 9
    //   493: astore 7
    //   495: aload_0
    //   496: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   499: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   502: getfield 131	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_b_of_type_Boolean	Z
    //   505: ifne +26 -> 531
    //   508: iload_2
    //   509: ifne +22 -> 531
    //   512: aload 9
    //   514: astore 8
    //   516: aload 9
    //   518: astore 7
    //   520: aload 9
    //   522: aload 10
    //   524: iconst_0
    //   525: iload 4
    //   527: invokevirtual 135	android/media/AudioTrack:write	([BII)I
    //   530: pop
    //   531: aload 9
    //   533: astore 8
    //   535: aload 9
    //   537: astore 7
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   544: iload_3
    //   545: iadd
    //   546: putfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   549: aload 9
    //   551: astore 8
    //   553: aload 9
    //   555: astore 7
    //   557: aload_0
    //   558: getfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   561: aload_1
    //   562: arraylength
    //   563: if_icmplt +147 -> 710
    //   566: aload 9
    //   568: astore 8
    //   570: aload 9
    //   572: astore 7
    //   574: aload_0
    //   575: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   578: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   581: getfield 148	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_Boolean	Z
    //   584: ifeq +126 -> 710
    //   587: aload 9
    //   589: astore 8
    //   591: aload 9
    //   593: astore 7
    //   595: aload_0
    //   596: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   599: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   602: getfield 123	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_Int	I
    //   605: iconst_3
    //   606: if_icmpeq +61 -> 667
    //   609: aload 9
    //   611: astore 8
    //   613: aload 9
    //   615: astore 7
    //   617: aload_0
    //   618: monitorenter
    //   619: aload_0
    //   620: getfield 47	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   623: ifne +26 -> 649
    //   626: aload_0
    //   627: invokevirtual 151	java/lang/Object:wait	()V
    //   630: aload_0
    //   631: iconst_0
    //   632: putfield 47	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   635: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +11 -> 649
    //   641: ldc 88
    //   643: iconst_1
    //   644: ldc 157
    //   646: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: aload_0
    //   650: monitorexit
    //   651: goto +16 -> 667
    //   654: astore_1
    //   655: aload_0
    //   656: monitorexit
    //   657: aload 9
    //   659: astore 8
    //   661: aload 9
    //   663: astore 7
    //   665: aload_1
    //   666: athrow
    //   667: aload 9
    //   669: astore 8
    //   671: aload 9
    //   673: astore 7
    //   675: aload_0
    //   676: iconst_0
    //   677: putfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   680: aload 9
    //   682: astore 8
    //   684: aload 9
    //   686: astore 7
    //   688: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +19 -> 710
    //   694: aload 9
    //   696: astore 8
    //   698: aload 9
    //   700: astore 7
    //   702: ldc 88
    //   704: iconst_1
    //   705: ldc 159
    //   707: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload 9
    //   712: astore 8
    //   714: aload 9
    //   716: astore 7
    //   718: aload_0
    //   719: getfield 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Boolean	Z
    //   722: istore 6
    //   724: iload 6
    //   726: ifeq -649 -> 77
    //   729: aload 9
    //   731: astore 8
    //   733: aload 9
    //   735: astore 7
    //   737: aload_0
    //   738: getfield 45	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   741: astore 11
    //   743: aload 9
    //   745: astore 8
    //   747: aload 9
    //   749: astore 7
    //   751: aload 11
    //   753: monitorenter
    //   754: aload_0
    //   755: getfield 45	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   758: invokevirtual 151	java/lang/Object:wait	()V
    //   761: aload 11
    //   763: monitorexit
    //   764: goto -687 -> 77
    //   767: astore 12
    //   769: aload 11
    //   771: monitorexit
    //   772: aload 9
    //   774: astore 8
    //   776: aload 9
    //   778: astore 7
    //   780: aload 12
    //   782: athrow
    //   783: astore 11
    //   785: aload 9
    //   787: astore 8
    //   789: aload 9
    //   791: astore 7
    //   793: aload 11
    //   795: invokevirtual 160	java/lang/InterruptedException:printStackTrace	()V
    //   798: aload 9
    //   800: astore 8
    //   802: aload 9
    //   804: astore 7
    //   806: aload_0
    //   807: iconst_1
    //   808: putfield 119	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Boolean	Z
    //   811: goto -734 -> 77
    //   814: aload 9
    //   816: astore 8
    //   818: aload 9
    //   820: astore 7
    //   822: aload 9
    //   824: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   827: aload 9
    //   829: ifnull +45 -> 874
    //   832: aload 9
    //   834: astore 7
    //   836: goto +33 -> 869
    //   839: astore_1
    //   840: goto +35 -> 875
    //   843: astore_1
    //   844: aload 7
    //   846: astore 8
    //   848: ldc 88
    //   850: iconst_4
    //   851: ldc 165
    //   853: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: aload 7
    //   858: astore 8
    //   860: aload_1
    //   861: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   864: aload 7
    //   866: ifnull +8 -> 874
    //   869: aload 7
    //   871: invokevirtual 168	android/media/AudioTrack:release	()V
    //   874: return
    //   875: aload 8
    //   877: ifnull +8 -> 885
    //   880: aload 8
    //   882: invokevirtual 168	android/media/AudioTrack:release	()V
    //   885: goto +5 -> 890
    //   888: aload_1
    //   889: athrow
    //   890: goto -2 -> 888
    //   893: iconst_1
    //   894: istore_2
    //   895: goto -408 -> 487
    //   898: iload_2
    //   899: istore_3
    //   900: iconst_0
    //   901: istore_2
    //   902: goto -415 -> 487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	this	AudioPlayRunnable
    //   0	905	1	paramArrayOfByte	byte[]
    //   178	724	2	i	int
    //   151	749	3	j	int
    //   48	478	4	k	int
    //   175	34	5	m	int
    //   722	3	6	bool	boolean
    //   9	861	7	localObject1	Object
    //   12	869	8	localObject2	Object
    //   18	815	9	localAudioTrack	AudioTrack
    //   62	461	10	arrayOfByte	byte[]
    //   741	29	11	localObject3	Object
    //   783	11	11	localInterruptedException	java.lang.InterruptedException
    //   767	14	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   619	649	654	finally
    //   649	651	654	finally
    //   655	657	654	finally
    //   754	764	767	finally
    //   769	772	767	finally
    //   737	743	783	java/lang/InterruptedException
    //   751	754	783	java/lang/InterruptedException
    //   780	783	783	java/lang/InterruptedException
    //   14	20	839	finally
    //   28	50	839	finally
    //   58	64	839	finally
    //   72	77	839	finally
    //   85	94	839	finally
    //   102	109	839	finally
    //   117	127	839	finally
    //   135	152	839	finally
    //   160	177	839	finally
    //   192	211	839	finally
    //   219	229	839	finally
    //   237	242	839	finally
    //   250	256	839	finally
    //   264	275	839	finally
    //   308	321	839	finally
    //   329	342	839	finally
    //   350	362	839	finally
    //   373	386	839	finally
    //   397	411	839	finally
    //   422	435	839	finally
    //   446	460	839	finally
    //   471	484	839	finally
    //   495	508	839	finally
    //   520	531	839	finally
    //   539	549	839	finally
    //   557	566	839	finally
    //   574	587	839	finally
    //   595	609	839	finally
    //   617	619	839	finally
    //   665	667	839	finally
    //   675	680	839	finally
    //   688	694	839	finally
    //   702	710	839	finally
    //   718	724	839	finally
    //   737	743	839	finally
    //   751	754	839	finally
    //   780	783	839	finally
    //   793	798	839	finally
    //   806	811	839	finally
    //   822	827	839	finally
    //   848	856	839	finally
    //   860	864	839	finally
    //   14	20	843	java/lang/Throwable
    //   28	50	843	java/lang/Throwable
    //   58	64	843	java/lang/Throwable
    //   72	77	843	java/lang/Throwable
    //   85	94	843	java/lang/Throwable
    //   102	109	843	java/lang/Throwable
    //   117	127	843	java/lang/Throwable
    //   135	152	843	java/lang/Throwable
    //   160	177	843	java/lang/Throwable
    //   192	211	843	java/lang/Throwable
    //   219	229	843	java/lang/Throwable
    //   237	242	843	java/lang/Throwable
    //   250	256	843	java/lang/Throwable
    //   264	275	843	java/lang/Throwable
    //   308	321	843	java/lang/Throwable
    //   329	342	843	java/lang/Throwable
    //   350	362	843	java/lang/Throwable
    //   373	386	843	java/lang/Throwable
    //   397	411	843	java/lang/Throwable
    //   422	435	843	java/lang/Throwable
    //   446	460	843	java/lang/Throwable
    //   471	484	843	java/lang/Throwable
    //   495	508	843	java/lang/Throwable
    //   520	531	843	java/lang/Throwable
    //   539	549	843	java/lang/Throwable
    //   557	566	843	java/lang/Throwable
    //   574	587	843	java/lang/Throwable
    //   595	609	843	java/lang/Throwable
    //   617	619	843	java/lang/Throwable
    //   665	667	843	java/lang/Throwable
    //   675	680	843	java/lang/Throwable
    //   688	694	843	java/lang/Throwable
    //   702	710	843	java/lang/Throwable
    //   718	724	843	java/lang/Throwable
    //   737	743	843	java/lang/Throwable
    //   751	754	843	java/lang/Throwable
    //   780	783	843	java/lang/Throwable
    //   793	798	843	java/lang/Throwable
    //   806	811	843	java/lang/Throwable
    //   822	827	843	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 181	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   15: getfield 184	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 187	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 190	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 41	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 41	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   48: aload_0
    //   49: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   52: aload_0
    //   53: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   59: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_2
    //   67: iload_2
    //   68: ifeq +27 -> 95
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   76: aload_0
    //   77: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   80: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   83: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   86: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   89: iload_2
    //   90: isub
    //   91: iadd
    //   92: putfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   95: aload_0
    //   96: getfield 33	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   99: fstore_1
    //   100: fload_1
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +14 -> 117
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 41	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   111: putfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   114: goto +62 -> 176
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 41	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	I
    //   122: i2f
    //   123: fload_1
    //   124: fmul
    //   125: f2i
    //   126: putfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   129: aload_0
    //   130: getfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   133: aload_0
    //   134: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   137: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   140: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   143: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   146: irem
    //   147: istore_2
    //   148: iload_2
    //   149: ifeq +27 -> 176
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   157: aload_0
    //   158: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   161: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   164: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   167: getfield 68	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   170: iload_2
    //   171: isub
    //   172: iadd
    //   173: putfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   176: new 192	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   183: astore 6
    //   185: aload 6
    //   187: ldc 195
    //   189: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 6
    //   195: aload_0
    //   196: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   199: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: ldc 204
    //   207: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_0
    //   214: getfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   217: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 88
    //   223: iconst_4
    //   224: aload 6
    //   226: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_0
    //   233: getfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   236: aload_0
    //   237: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   240: isub
    //   241: newarray byte
    //   243: astore 6
    //   245: goto +36 -> 281
    //   248: ldc 88
    //   250: iconst_4
    //   251: ldc 210
    //   253: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: getstatic 215	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   259: ifnull +9 -> 268
    //   262: getstatic 215	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   265: invokevirtual 220	android/support/v4/util/MQLruCache:evictAll	()V
    //   268: aload_0
    //   269: getfield 37	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Int	I
    //   272: aload_0
    //   273: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   276: isub
    //   277: newarray byte
    //   279: astore 6
    //   281: new 222	java/io/FileInputStream
    //   284: dup
    //   285: aload 5
    //   287: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   290: astore 7
    //   292: aload 7
    //   294: astore 5
    //   296: aload_0
    //   297: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   300: ifeq +18 -> 318
    //   303: aload 7
    //   305: astore 5
    //   307: aload 7
    //   309: aload_0
    //   310: getfield 35	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   313: i2l
    //   314: invokevirtual 229	java/io/FileInputStream:skip	(J)J
    //   317: pop2
    //   318: aload 7
    //   320: astore 5
    //   322: aload 7
    //   324: aload 6
    //   326: invokevirtual 233	java/io/FileInputStream:read	([B)I
    //   329: pop
    //   330: aload 7
    //   332: invokevirtual 236	java/io/FileInputStream:close	()V
    //   335: goto +10 -> 345
    //   338: astore 5
    //   340: aload 5
    //   342: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   345: new 192	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   352: astore 5
    //   354: aload 5
    //   356: ldc 239
    //   358: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 5
    //   364: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   367: lload_3
    //   368: lsub
    //   369: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: ldc 88
    //   375: iconst_4
    //   376: aload 5
    //   378: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 6
    //   386: areturn
    //   387: astore 8
    //   389: aload 7
    //   391: astore 6
    //   393: goto +16 -> 409
    //   396: astore 5
    //   398: aconst_null
    //   399: astore 6
    //   401: goto +60 -> 461
    //   404: astore 8
    //   406: aconst_null
    //   407: astore 6
    //   409: aload 6
    //   411: astore 5
    //   413: ldc 88
    //   415: iconst_4
    //   416: ldc 165
    //   418: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload 6
    //   423: astore 5
    //   425: aload 8
    //   427: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   430: aload 6
    //   432: ifnull +17 -> 449
    //   435: aload 6
    //   437: invokevirtual 236	java/io/FileInputStream:close	()V
    //   440: aconst_null
    //   441: areturn
    //   442: astore 5
    //   444: aload 5
    //   446: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   449: aconst_null
    //   450: areturn
    //   451: astore 7
    //   453: aload 5
    //   455: astore 6
    //   457: aload 7
    //   459: astore 5
    //   461: aload 6
    //   463: ifnull +18 -> 481
    //   466: aload 6
    //   468: invokevirtual 236	java/io/FileInputStream:close	()V
    //   471: goto +10 -> 481
    //   474: astore 6
    //   476: aload 6
    //   478: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   481: aload 5
    //   483: athrow
    //   484: astore 6
    //   486: goto -238 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	AudioPlayRunnable
    //   99	25	1	f	float
    //   66	106	2	i	int
    //   3	365	3	l	long
    //   21	300	5	localObject1	Object
    //   338	3	5	localIOException1	java.io.IOException
    //   352	25	5	localStringBuilder	StringBuilder
    //   396	1	5	localObject2	Object
    //   411	13	5	localObject3	Object
    //   442	12	5	localIOException2	java.io.IOException
    //   459	23	5	localObject4	Object
    //   183	284	6	localObject5	Object
    //   474	3	6	localIOException3	java.io.IOException
    //   484	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   290	100	7	localFileInputStream	java.io.FileInputStream
    //   451	7	7	localObject6	Object
    //   387	1	8	localThrowable1	Throwable
    //   404	22	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   330	335	338	java/io/IOException
    //   296	303	387	java/lang/Throwable
    //   307	318	387	java/lang/Throwable
    //   322	330	387	java/lang/Throwable
    //   281	292	396	finally
    //   281	292	404	java/lang/Throwable
    //   435	440	442	java/io/IOException
    //   296	303	451	finally
    //   307	318	451	finally
    //   322	330	451	finally
    //   413	421	451	finally
    //   425	430	451	finally
    //   466	471	474	java/io/IOException
    //   232	245	484	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private byte[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 88
    //   2: iconst_4
    //   3: ldc 247
    //   5: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   11: lstore 13
    //   13: new 249	android/media/MediaExtractor
    //   16: dup
    //   17: invokespecial 250	android/media/MediaExtractor:<init>	()V
    //   20: astore 22
    //   22: aload 22
    //   24: aload_1
    //   25: invokevirtual 253	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   28: lconst_0
    //   29: lstore 11
    //   31: lload 11
    //   33: lstore 9
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: aload 22
    //   40: invokevirtual 256	android/media/MediaExtractor:getTrackCount	()I
    //   43: if_icmpge +2026 -> 2069
    //   46: aload 22
    //   48: iload_3
    //   49: invokevirtual 260	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 20
    //   54: aload 20
    //   56: ldc_w 262
    //   59: invokevirtual 268	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 17
    //   64: aload_0
    //   65: aload 20
    //   67: ldc_w 270
    //   70: invokevirtual 274	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   73: putfield 39	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   76: aload_0
    //   77: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   80: aload_0
    //   81: getfield 39	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   84: l2f
    //   85: fmul
    //   86: f2l
    //   87: lstore 11
    //   89: aload_0
    //   90: getfield 33	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   93: aload_0
    //   94: getfield 39	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   97: l2f
    //   98: fmul
    //   99: f2l
    //   100: lstore 15
    //   102: lload 15
    //   104: lstore 9
    //   106: lload 15
    //   108: lconst_0
    //   109: lcmp
    //   110: ifne +9 -> 119
    //   113: aload_0
    //   114: getfield 39	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   117: lstore 9
    //   119: aload 17
    //   121: ldc_w 276
    //   124: invokevirtual 282	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   127: ifeq +1923 -> 2050
    //   130: aload 22
    //   132: iload_3
    //   133: invokevirtual 286	android/media/MediaExtractor:selectTrack	(I)V
    //   136: lload 11
    //   138: lconst_0
    //   139: lcmp
    //   140: ifle +11 -> 151
    //   143: aload 22
    //   145: lload 11
    //   147: iconst_0
    //   148: invokevirtual 290	android/media/MediaExtractor:seekTo	(JI)V
    //   151: aload 17
    //   153: invokestatic 296	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   156: astore 17
    //   158: aload 17
    //   160: astore 18
    //   162: aload 17
    //   164: astore 19
    //   166: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +171 -> 340
    //   172: aload 17
    //   174: astore 18
    //   176: aload 17
    //   178: astore 19
    //   180: new 192	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   187: astore 21
    //   189: aload 17
    //   191: astore 18
    //   193: aload 17
    //   195: astore 19
    //   197: aload 21
    //   199: ldc_w 298
    //   202: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 17
    //   208: astore 18
    //   210: aload 17
    //   212: astore 19
    //   214: aload 21
    //   216: aload_0
    //   217: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   220: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   223: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   226: getfield 299	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   229: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 17
    //   235: astore 18
    //   237: aload 17
    //   239: astore 19
    //   241: aload 21
    //   243: ldc_w 301
    //   246: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 17
    //   252: astore 18
    //   254: aload 17
    //   256: astore 19
    //   258: aload 21
    //   260: aload_0
    //   261: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   264: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   267: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   270: getfield 67	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   273: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 17
    //   279: astore 18
    //   281: aload 17
    //   283: astore 19
    //   285: aload 21
    //   287: ldc_w 303
    //   290: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 17
    //   296: astore 18
    //   298: aload 17
    //   300: astore 19
    //   302: aload 21
    //   304: aload_0
    //   305: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   308: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   311: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   314: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_d_of_type_Int	I
    //   317: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 17
    //   323: astore 18
    //   325: aload 17
    //   327: astore 19
    //   329: ldc 88
    //   331: iconst_4
    //   332: aload 21
    //   334: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload 17
    //   342: astore 18
    //   344: aload 17
    //   346: astore 19
    //   348: aload_0
    //   349: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   352: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   355: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   358: astore 23
    //   360: aload 20
    //   362: astore 21
    //   364: aload 17
    //   366: astore 18
    //   368: aload 17
    //   370: astore 19
    //   372: aload 23
    //   374: aload 21
    //   376: aload_1
    //   377: invokestatic 308	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   380: putfield 67	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   383: aload 17
    //   385: astore 18
    //   387: aload 17
    //   389: astore 19
    //   391: aload_0
    //   392: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   395: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   398: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   401: aload 21
    //   403: invokestatic 311	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;)I
    //   406: putfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_d_of_type_Int	I
    //   409: goto +20 -> 429
    //   412: astore_1
    //   413: goto +4 -> 417
    //   416: astore_1
    //   417: aload 17
    //   419: astore 18
    //   421: aload 17
    //   423: astore 19
    //   425: aload_1
    //   426: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   429: aload 17
    //   431: astore 18
    //   433: aload 17
    //   435: astore 19
    //   437: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +163 -> 603
    //   443: aload 17
    //   445: astore 18
    //   447: aload 17
    //   449: astore 19
    //   451: new 192	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   458: astore_1
    //   459: aload 17
    //   461: astore 18
    //   463: aload 17
    //   465: astore 19
    //   467: aload_1
    //   468: ldc_w 313
    //   471: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 17
    //   477: astore 18
    //   479: aload 17
    //   481: astore 19
    //   483: aload_1
    //   484: aload_0
    //   485: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   488: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   491: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   494: getfield 299	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   497: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 17
    //   503: astore 18
    //   505: aload 17
    //   507: astore 19
    //   509: aload_1
    //   510: ldc_w 301
    //   513: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload 17
    //   519: astore 18
    //   521: aload 17
    //   523: astore 19
    //   525: aload_1
    //   526: aload_0
    //   527: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   530: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   533: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   536: getfield 67	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   539: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 17
    //   545: astore 18
    //   547: aload 17
    //   549: astore 19
    //   551: aload_1
    //   552: ldc_w 303
    //   555: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 17
    //   561: astore 18
    //   563: aload 17
    //   565: astore 19
    //   567: aload_1
    //   568: aload_0
    //   569: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   572: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   575: getfield 64	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   578: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_d_of_type_Int	I
    //   581: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 17
    //   587: astore 18
    //   589: aload 17
    //   591: astore 19
    //   593: ldc 88
    //   595: iconst_4
    //   596: aload_1
    //   597: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload 17
    //   605: astore 18
    //   607: aload 17
    //   609: astore 19
    //   611: aload 17
    //   613: aload 20
    //   615: aconst_null
    //   616: aconst_null
    //   617: iconst_0
    //   618: invokevirtual 317	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   621: goto +26 -> 647
    //   624: astore_1
    //   625: goto +7 -> 632
    //   628: astore_1
    //   629: aconst_null
    //   630: astore 17
    //   632: aload 17
    //   634: astore 18
    //   636: aload 17
    //   638: astore 19
    //   640: aload_1
    //   641: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   644: goto +3 -> 647
    //   647: aload 17
    //   649: ifnonnull +59 -> 708
    //   652: aload 17
    //   654: astore 18
    //   656: aload 17
    //   658: astore 19
    //   660: ldc 88
    //   662: iconst_2
    //   663: ldc_w 319
    //   666: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload 17
    //   671: ifnull +16 -> 687
    //   674: aload 17
    //   676: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   679: aload 17
    //   681: invokevirtual 321	android/media/MediaCodec:release	()V
    //   684: goto +3 -> 687
    //   687: aload 22
    //   689: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   692: aconst_null
    //   693: areturn
    //   694: ldc 88
    //   696: iconst_1
    //   697: aload_1
    //   698: iconst_0
    //   699: anewarray 4	java/lang/Object
    //   702: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   705: goto -13 -> 692
    //   708: aload 17
    //   710: astore 18
    //   712: aload 17
    //   714: astore 19
    //   716: aload 17
    //   718: invokevirtual 328	android/media/MediaCodec:start	()V
    //   721: aload 17
    //   723: astore 18
    //   725: aload 17
    //   727: astore 19
    //   729: aload 17
    //   731: invokevirtual 332	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   734: astore 23
    //   736: aload 17
    //   738: astore 18
    //   740: aload 17
    //   742: astore 19
    //   744: aload 17
    //   746: invokevirtual 335	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   749: astore 20
    //   751: aload 17
    //   753: astore 18
    //   755: aload 17
    //   757: astore 19
    //   759: new 337	android/media/MediaCodec$BufferInfo
    //   762: dup
    //   763: invokespecial 338	android/media/MediaCodec$BufferInfo:<init>	()V
    //   766: astore 24
    //   768: iload_2
    //   769: ifeq +22 -> 791
    //   772: aload 17
    //   774: astore 18
    //   776: aload 17
    //   778: astore 19
    //   780: aload_0
    //   781: invokespecial 107	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	()Landroid/media/AudioTrack;
    //   784: astore_1
    //   785: aconst_null
    //   786: astore 19
    //   788: goto +26 -> 814
    //   791: aload 17
    //   793: astore 18
    //   795: aload 17
    //   797: astore 19
    //   799: new 340	java/io/ByteArrayOutputStream
    //   802: dup
    //   803: invokespecial 341	java/io/ByteArrayOutputStream:<init>	()V
    //   806: astore 21
    //   808: aconst_null
    //   809: astore_1
    //   810: aload 21
    //   812: astore 19
    //   814: aload 20
    //   816: astore 18
    //   818: iconst_0
    //   819: istore 7
    //   821: iconst_0
    //   822: istore 5
    //   824: iconst_0
    //   825: istore_3
    //   826: iload 7
    //   828: ifne +1319 -> 2147
    //   831: iload 5
    //   833: istore 4
    //   835: iload 5
    //   837: ifne +134 -> 971
    //   840: aload 17
    //   842: ldc2_w 342
    //   845: invokevirtual 347	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   848: istore 6
    //   850: iload 5
    //   852: istore 4
    //   854: iload 6
    //   856: iflt +115 -> 971
    //   859: aload 22
    //   861: aload 23
    //   863: iload 6
    //   865: aaload
    //   866: iconst_0
    //   867: invokevirtual 351	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   870: istore 4
    //   872: aload 22
    //   874: invokevirtual 354	android/media/MediaExtractor:getSampleTime	()J
    //   877: lstore 15
    //   879: iload 4
    //   881: iflt +47 -> 928
    //   884: lload 9
    //   886: lconst_0
    //   887: lcmp
    //   888: ifle +14 -> 902
    //   891: lload 15
    //   893: lload 9
    //   895: lcmp
    //   896: iflt +6 -> 902
    //   899: goto +29 -> 928
    //   902: aload 17
    //   904: iload 6
    //   906: iconst_0
    //   907: iload 4
    //   909: lload 15
    //   911: iconst_0
    //   912: invokevirtual 358	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   915: aload 22
    //   917: invokevirtual 361	android/media/MediaExtractor:advance	()Z
    //   920: pop
    //   921: iload 5
    //   923: istore 4
    //   925: goto +46 -> 971
    //   928: aload 17
    //   930: iload 6
    //   932: iconst_0
    //   933: iconst_0
    //   934: lconst_0
    //   935: iconst_4
    //   936: invokevirtual 358	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   939: iconst_1
    //   940: istore 4
    //   942: goto +29 -> 971
    //   945: astore 19
    //   947: aload_1
    //   948: astore 18
    //   950: aload 19
    //   952: astore_1
    //   953: goto +1036 -> 1989
    //   956: astore 18
    //   958: aload_1
    //   959: astore 19
    //   961: aload 17
    //   963: astore_1
    //   964: aload 19
    //   966: astore 17
    //   968: goto +946 -> 1914
    //   971: iload_3
    //   972: ifne +1147 -> 2119
    //   975: aload 17
    //   977: aload 24
    //   979: ldc2_w 342
    //   982: invokevirtual 365	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   985: istore 5
    //   987: iload 5
    //   989: bipush 253
    //   991: if_icmpeq +421 -> 1412
    //   994: iload 5
    //   996: bipush 254
    //   998: if_icmpeq +351 -> 1349
    //   1001: iload 5
    //   1003: iconst_m1
    //   1004: if_icmpeq +313 -> 1317
    //   1007: aload 24
    //   1009: getfield 368	android/media/MediaCodec$BufferInfo:flags	I
    //   1012: istore 6
    //   1014: iload 6
    //   1016: iconst_4
    //   1017: iand
    //   1018: ifeq +23 -> 1041
    //   1021: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1024: ifeq +12 -> 1036
    //   1027: ldc 88
    //   1029: iconst_2
    //   1030: ldc_w 370
    //   1033: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1036: iconst_1
    //   1037: istore_3
    //   1038: goto +164 -> 1202
    //   1041: aload 18
    //   1043: iload 5
    //   1045: aaload
    //   1046: astore 20
    //   1048: aload 20
    //   1050: ifnonnull +63 -> 1113
    //   1053: ldc 88
    //   1055: iconst_1
    //   1056: ldc_w 372
    //   1059: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1062: aload 17
    //   1064: ifnull +16 -> 1080
    //   1067: aload 17
    //   1069: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1072: aload 17
    //   1074: invokevirtual 321	android/media/MediaCodec:release	()V
    //   1077: goto +3 -> 1080
    //   1080: aload 22
    //   1082: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1085: aload_1
    //   1086: ifnull +11 -> 1097
    //   1089: aload_1
    //   1090: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   1093: aload_1
    //   1094: invokevirtual 168	android/media/AudioTrack:release	()V
    //   1097: aconst_null
    //   1098: areturn
    //   1099: ldc 88
    //   1101: iconst_1
    //   1102: aload_1
    //   1103: iconst_0
    //   1104: anewarray 4	java/lang/Object
    //   1107: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1110: goto -13 -> 1097
    //   1113: aload 24
    //   1115: getfield 375	android/media/MediaCodec$BufferInfo:size	I
    //   1118: ifeq +31 -> 1149
    //   1121: aload 20
    //   1123: aload 24
    //   1125: getfield 378	android/media/MediaCodec$BufferInfo:offset	I
    //   1128: invokevirtual 384	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1131: pop
    //   1132: aload 20
    //   1134: aload 24
    //   1136: getfield 378	android/media/MediaCodec$BufferInfo:offset	I
    //   1139: aload 24
    //   1141: getfield 375	android/media/MediaCodec$BufferInfo:size	I
    //   1144: iadd
    //   1145: invokevirtual 387	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1148: pop
    //   1149: aload 20
    //   1151: invokevirtual 390	java/nio/ByteBuffer:remaining	()I
    //   1154: istore 6
    //   1156: iload 6
    //   1158: newarray byte
    //   1160: astore 21
    //   1162: aload 20
    //   1164: aload 21
    //   1166: iconst_0
    //   1167: iload 6
    //   1169: invokevirtual 394	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1172: pop
    //   1173: iload_2
    //   1174: ifeq +18 -> 1192
    //   1177: aload_0
    //   1178: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   1181: aload_1
    //   1182: aload 21
    //   1184: iload 6
    //   1186: invokestatic 397	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
    //   1189: goto +13 -> 1202
    //   1192: aload 19
    //   1194: aload 21
    //   1196: iconst_0
    //   1197: iload 6
    //   1199: invokevirtual 400	java/io/ByteArrayOutputStream:write	([BII)V
    //   1202: aload 17
    //   1204: iload 5
    //   1206: iconst_0
    //   1207: invokevirtual 404	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1210: iload_3
    //   1211: istore 6
    //   1213: aload 18
    //   1215: astore 20
    //   1217: goto +223 -> 1440
    //   1220: aload_1
    //   1221: astore 19
    //   1223: new 192	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1230: astore 20
    //   1232: aload 20
    //   1234: ldc_w 406
    //   1237: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: aload 20
    //   1243: aload 18
    //   1245: invokevirtual 407	java/lang/Exception:toString	()Ljava/lang/String;
    //   1248: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: ldc 88
    //   1254: iconst_1
    //   1255: aload 20
    //   1257: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1263: aload 17
    //   1265: ifnull +16 -> 1281
    //   1268: aload 17
    //   1270: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1273: aload 17
    //   1275: invokevirtual 321	android/media/MediaCodec:release	()V
    //   1278: goto +3 -> 1281
    //   1281: aload 22
    //   1283: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1286: aload 19
    //   1288: ifnull +13 -> 1301
    //   1291: aload 19
    //   1293: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   1296: aload 19
    //   1298: invokevirtual 168	android/media/AudioTrack:release	()V
    //   1301: aconst_null
    //   1302: areturn
    //   1303: ldc 88
    //   1305: iconst_1
    //   1306: aload_1
    //   1307: iconst_0
    //   1308: anewarray 4	java/lang/Object
    //   1311: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1314: goto -13 -> 1301
    //   1317: iload_3
    //   1318: istore 6
    //   1320: aload 18
    //   1322: astore 20
    //   1324: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1327: ifeq +113 -> 1440
    //   1330: ldc 88
    //   1332: iconst_2
    //   1333: ldc_w 409
    //   1336: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1339: iload_3
    //   1340: istore 6
    //   1342: aload 18
    //   1344: astore 20
    //   1346: goto +94 -> 1440
    //   1349: iload_3
    //   1350: istore 6
    //   1352: aload 18
    //   1354: astore 20
    //   1356: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1359: ifeq +81 -> 1440
    //   1362: new 192	java/lang/StringBuilder
    //   1365: dup
    //   1366: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1369: astore 20
    //   1371: aload 20
    //   1373: ldc_w 411
    //   1376: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: pop
    //   1380: aload 20
    //   1382: aload 17
    //   1384: invokevirtual 415	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1387: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: ldc 88
    //   1393: iconst_2
    //   1394: aload 20
    //   1396: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: iload_3
    //   1403: istore 6
    //   1405: aload 18
    //   1407: astore 20
    //   1409: goto +31 -> 1440
    //   1412: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1415: ifeq +12 -> 1427
    //   1418: ldc 88
    //   1420: iconst_2
    //   1421: ldc_w 420
    //   1424: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1427: aload 17
    //   1429: invokevirtual 335	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1432: astore 20
    //   1434: iload_3
    //   1435: istore 6
    //   1437: goto +3 -> 1440
    //   1440: aload_1
    //   1441: astore 18
    //   1443: iload 6
    //   1445: ifeq +96 -> 1541
    //   1448: iload_2
    //   1449: ifeq +214 -> 1663
    //   1452: aload_0
    //   1453: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   1456: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   1459: getfield 123	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_Int	I
    //   1462: iconst_3
    //   1463: if_icmpeq +47 -> 1510
    //   1466: aload_0
    //   1467: monitorenter
    //   1468: aload_0
    //   1469: getfield 47	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   1472: ifne +26 -> 1498
    //   1475: aload_0
    //   1476: invokevirtual 151	java/lang/Object:wait	()V
    //   1479: aload_0
    //   1480: iconst_0
    //   1481: putfield 47	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   1484: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq +11 -> 1498
    //   1490: ldc 88
    //   1492: iconst_1
    //   1493: ldc 157
    //   1495: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: aload_0
    //   1499: monitorexit
    //   1500: goto +10 -> 1510
    //   1503: astore 18
    //   1505: aload_0
    //   1506: monitorexit
    //   1507: aload 18
    //   1509: athrow
    //   1510: aload 17
    //   1512: invokevirtual 421	android/media/MediaCodec:flush	()V
    //   1515: aload 22
    //   1517: lload 11
    //   1519: iconst_0
    //   1520: invokevirtual 290	android/media/MediaExtractor:seekTo	(JI)V
    //   1523: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1526: ifeq +603 -> 2129
    //   1529: ldc 88
    //   1531: iconst_1
    //   1532: ldc_w 423
    //   1535: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1538: goto +591 -> 2129
    //   1541: iload 4
    //   1543: istore 5
    //   1545: iload 6
    //   1547: istore_3
    //   1548: aload_0
    //   1549: getfield 29	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   1552: ifne +50 -> 1602
    //   1555: aload_0
    //   1556: iconst_m1
    //   1557: putfield 29	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   1560: aload 17
    //   1562: invokevirtual 421	android/media/MediaCodec:flush	()V
    //   1565: aload 22
    //   1567: lload 11
    //   1569: iconst_0
    //   1570: invokevirtual 290	android/media/MediaExtractor:seekTo	(JI)V
    //   1573: iload 4
    //   1575: istore 5
    //   1577: iload 6
    //   1579: istore_3
    //   1580: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1583: ifeq +19 -> 1602
    //   1586: ldc 88
    //   1588: iconst_1
    //   1589: ldc_w 425
    //   1592: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1595: iload 6
    //   1597: istore_3
    //   1598: iload 4
    //   1600: istore 5
    //   1602: aload_0
    //   1603: getfield 43	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Boolean	Z
    //   1606: istore 8
    //   1608: iload 8
    //   1610: ifeq +527 -> 2137
    //   1613: aload_0
    //   1614: getfield 45	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1617: astore 21
    //   1619: aload 21
    //   1621: monitorenter
    //   1622: aload_0
    //   1623: getfield 45	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1626: invokevirtual 151	java/lang/Object:wait	()V
    //   1629: aload 21
    //   1631: monitorexit
    //   1632: goto +505 -> 2137
    //   1635: astore 25
    //   1637: aload 21
    //   1639: monitorexit
    //   1640: aload 25
    //   1642: athrow
    //   1643: astore 21
    //   1645: aload 21
    //   1647: invokevirtual 160	java/lang/InterruptedException:printStackTrace	()V
    //   1650: aload 18
    //   1652: astore_1
    //   1653: iconst_1
    //   1654: istore 7
    //   1656: aload 20
    //   1658: astore 18
    //   1660: goto -834 -> 826
    //   1663: aload_1
    //   1664: astore 18
    //   1666: new 192	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1673: astore 20
    //   1675: aload 20
    //   1677: ldc_w 427
    //   1680: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: aload 20
    //   1686: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   1689: lload 13
    //   1691: lsub
    //   1692: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1695: pop
    //   1696: ldc 88
    //   1698: iconst_1
    //   1699: aload 20
    //   1701: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1707: aload 19
    //   1709: ifnonnull +8 -> 1717
    //   1712: aconst_null
    //   1713: astore_1
    //   1714: goto +13 -> 1727
    //   1717: aload 19
    //   1719: invokevirtual 430	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1722: astore 19
    //   1724: aload 19
    //   1726: astore_1
    //   1727: aload 17
    //   1729: ifnull +16 -> 1745
    //   1732: aload 17
    //   1734: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1737: aload 17
    //   1739: invokevirtual 321	android/media/MediaCodec:release	()V
    //   1742: goto +3 -> 1745
    //   1745: aload 22
    //   1747: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1750: aload 18
    //   1752: ifnull +27 -> 1779
    //   1755: aload 18
    //   1757: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   1760: aload 18
    //   1762: invokevirtual 168	android/media/AudioTrack:release	()V
    //   1765: aload_1
    //   1766: areturn
    //   1767: ldc 88
    //   1769: iconst_1
    //   1770: aload 17
    //   1772: iconst_0
    //   1773: anewarray 4	java/lang/Object
    //   1776: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1779: aload_1
    //   1780: areturn
    //   1781: astore 18
    //   1783: aload_1
    //   1784: astore 19
    //   1786: aload 18
    //   1788: astore_1
    //   1789: aload 19
    //   1791: astore 18
    //   1793: goto +196 -> 1989
    //   1796: astore 18
    //   1798: aload_1
    //   1799: astore 19
    //   1801: aload 17
    //   1803: astore_1
    //   1804: aload 19
    //   1806: astore 17
    //   1808: goto +106 -> 1914
    //   1811: astore_1
    //   1812: aload 18
    //   1814: astore 17
    //   1816: goto +85 -> 1901
    //   1819: astore 18
    //   1821: aload 19
    //   1823: astore_1
    //   1824: goto +87 -> 1911
    //   1827: astore_1
    //   1828: aload 17
    //   1830: astore 18
    //   1832: aload 17
    //   1834: astore 19
    //   1836: aload_1
    //   1837: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   1840: aload 17
    //   1842: astore 18
    //   1844: aload 17
    //   1846: astore 19
    //   1848: ldc 88
    //   1850: iconst_2
    //   1851: ldc_w 432
    //   1854: aload_1
    //   1855: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1858: aload 17
    //   1860: ifnull +16 -> 1876
    //   1863: aload 17
    //   1865: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1868: aload 17
    //   1870: invokevirtual 321	android/media/MediaCodec:release	()V
    //   1873: goto +3 -> 1876
    //   1876: aload 22
    //   1878: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1881: aconst_null
    //   1882: areturn
    //   1883: ldc 88
    //   1885: iconst_1
    //   1886: aload_1
    //   1887: iconst_0
    //   1888: anewarray 4	java/lang/Object
    //   1891: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1894: goto -13 -> 1881
    //   1897: astore_1
    //   1898: aconst_null
    //   1899: astore 17
    //   1901: aconst_null
    //   1902: astore 18
    //   1904: goto +85 -> 1989
    //   1907: astore 18
    //   1909: aconst_null
    //   1910: astore_1
    //   1911: aconst_null
    //   1912: astore 17
    //   1914: ldc 88
    //   1916: iconst_1
    //   1917: aload 18
    //   1919: iconst_0
    //   1920: anewarray 4	java/lang/Object
    //   1923: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1926: aload_1
    //   1927: ifnull +14 -> 1941
    //   1930: aload_1
    //   1931: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1934: aload_1
    //   1935: invokevirtual 321	android/media/MediaCodec:release	()V
    //   1938: goto +3 -> 1941
    //   1941: aload 22
    //   1943: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1946: aload 17
    //   1948: ifnull +13 -> 1961
    //   1951: aload 17
    //   1953: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   1956: aload 17
    //   1958: invokevirtual 168	android/media/AudioTrack:release	()V
    //   1961: aconst_null
    //   1962: areturn
    //   1963: ldc 88
    //   1965: iconst_1
    //   1966: aload_1
    //   1967: iconst_0
    //   1968: anewarray 4	java/lang/Object
    //   1971: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1974: goto -13 -> 1961
    //   1977: astore 19
    //   1979: aload 17
    //   1981: astore 18
    //   1983: aload_1
    //   1984: astore 17
    //   1986: aload 19
    //   1988: astore_1
    //   1989: aload 17
    //   1991: ifnull +16 -> 2007
    //   1994: aload 17
    //   1996: invokevirtual 320	android/media/MediaCodec:stop	()V
    //   1999: aload 17
    //   2001: invokevirtual 321	android/media/MediaCodec:release	()V
    //   2004: goto +3 -> 2007
    //   2007: aload 22
    //   2009: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   2012: aload 18
    //   2014: ifnull +28 -> 2042
    //   2017: aload 18
    //   2019: invokevirtual 163	android/media/AudioTrack:stop	()V
    //   2022: aload 18
    //   2024: invokevirtual 168	android/media/AudioTrack:release	()V
    //   2027: goto +15 -> 2042
    //   2030: ldc 88
    //   2032: iconst_1
    //   2033: aload 17
    //   2035: iconst_0
    //   2036: anewarray 4	java/lang/Object
    //   2039: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2042: goto +5 -> 2047
    //   2045: aload_1
    //   2046: athrow
    //   2047: goto -2 -> 2045
    //   2050: iload_3
    //   2051: iconst_1
    //   2052: iadd
    //   2053: istore_3
    //   2054: lload 11
    //   2056: lstore 15
    //   2058: lload 9
    //   2060: lstore 11
    //   2062: lload 15
    //   2064: lstore 9
    //   2066: goto -2029 -> 37
    //   2069: lload 9
    //   2071: lstore 15
    //   2073: aconst_null
    //   2074: astore 17
    //   2076: lload 11
    //   2078: lstore 9
    //   2080: lload 15
    //   2082: lstore 11
    //   2084: goto -1437 -> 647
    //   2087: astore_1
    //   2088: goto -1394 -> 694
    //   2091: astore_1
    //   2092: goto -993 -> 1099
    //   2095: astore 18
    //   2097: goto -877 -> 1220
    //   2100: astore 18
    //   2102: goto -882 -> 1220
    //   2105: astore_1
    //   2106: goto -803 -> 1303
    //   2109: astore 18
    //   2111: goto -328 -> 1783
    //   2114: astore 18
    //   2116: goto -318 -> 1798
    //   2119: iload_3
    //   2120: istore 6
    //   2122: aload 18
    //   2124: astore 20
    //   2126: goto -686 -> 1440
    //   2129: iconst_0
    //   2130: istore 5
    //   2132: iconst_0
    //   2133: istore_3
    //   2134: goto -532 -> 1602
    //   2137: aload 18
    //   2139: astore_1
    //   2140: aload 20
    //   2142: astore 18
    //   2144: goto -1318 -> 826
    //   2147: goto -484 -> 1663
    //   2150: astore 17
    //   2152: goto -385 -> 1767
    //   2155: astore_1
    //   2156: goto -273 -> 1883
    //   2159: astore_1
    //   2160: goto -197 -> 1963
    //   2163: astore 17
    //   2165: goto -135 -> 2030
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2168	0	this	AudioPlayRunnable
    //   0	2168	1	paramString	String
    //   0	2168	2	paramBoolean	boolean
    //   36	2098	3	i	int
    //   833	766	4	j	int
    //   822	1309	5	k	int
    //   848	1273	6	m	int
    //   819	836	7	n	int
    //   1606	3	8	bool	boolean
    //   33	2046	9	l1	long
    //   29	2054	11	l2	long
    //   11	1679	13	l3	long
    //   100	1981	15	l4	long
    //   62	2013	17	localObject1	Object
    //   2150	1	17	localException1	Exception
    //   2163	1	17	localException2	Exception
    //   160	789	18	localObject2	Object
    //   956	450	18	localException3	Exception
    //   1441	1	18	str	String
    //   1503	148	18	localObject3	Object
    //   1658	103	18	localObject4	Object
    //   1781	6	18	localObject5	Object
    //   1791	1	18	localObject6	Object
    //   1796	17	18	localException4	Exception
    //   1819	1	18	localException5	Exception
    //   1830	73	18	localObject7	Object
    //   1907	11	18	localException6	Exception
    //   1981	42	18	localObject8	Object
    //   2095	1	18	localException7	Exception
    //   2100	1	18	localException8	Exception
    //   2109	1	18	localObject9	Object
    //   2114	24	18	localException9	Exception
    //   2142	1	18	localObject10	Object
    //   164	649	19	localObject11	Object
    //   945	6	19	localObject12	Object
    //   959	888	19	localObject13	Object
    //   1977	10	19	localObject14	Object
    //   52	2089	20	localObject15	Object
    //   187	1451	21	localObject16	Object
    //   1643	3	21	localInterruptedException	java.lang.InterruptedException
    //   20	1988	22	localMediaExtractor	android.media.MediaExtractor
    //   358	504	23	localObject17	Object
    //   766	374	24	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   1635	6	25	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   372	383	412	java/lang/Throwable
    //   391	409	412	java/lang/Throwable
    //   348	360	416	java/lang/Throwable
    //   166	172	624	java/lang/Throwable
    //   180	189	624	java/lang/Throwable
    //   197	206	624	java/lang/Throwable
    //   214	233	624	java/lang/Throwable
    //   241	250	624	java/lang/Throwable
    //   258	277	624	java/lang/Throwable
    //   285	294	624	java/lang/Throwable
    //   302	321	624	java/lang/Throwable
    //   329	340	624	java/lang/Throwable
    //   425	429	624	java/lang/Throwable
    //   437	443	624	java/lang/Throwable
    //   451	459	624	java/lang/Throwable
    //   467	475	624	java/lang/Throwable
    //   483	501	624	java/lang/Throwable
    //   509	517	624	java/lang/Throwable
    //   525	543	624	java/lang/Throwable
    //   551	559	624	java/lang/Throwable
    //   567	585	624	java/lang/Throwable
    //   593	603	624	java/lang/Throwable
    //   611	621	624	java/lang/Throwable
    //   151	158	628	java/lang/Throwable
    //   840	850	945	finally
    //   859	879	945	finally
    //   902	921	945	finally
    //   928	939	945	finally
    //   1021	1036	945	finally
    //   840	850	956	java/lang/Exception
    //   859	879	956	java/lang/Exception
    //   902	921	956	java/lang/Exception
    //   928	939	956	java/lang/Exception
    //   1021	1036	956	java/lang/Exception
    //   1468	1498	1503	finally
    //   1498	1500	1503	finally
    //   1505	1507	1503	finally
    //   1622	1632	1635	finally
    //   1637	1640	1635	finally
    //   1613	1622	1643	java/lang/InterruptedException
    //   1640	1643	1643	java/lang/InterruptedException
    //   1113	1149	1781	finally
    //   1149	1173	1781	finally
    //   1177	1189	1781	finally
    //   1192	1202	1781	finally
    //   1202	1210	1781	finally
    //   1223	1263	1781	finally
    //   1324	1339	1781	finally
    //   1356	1402	1781	finally
    //   1412	1427	1781	finally
    //   1427	1434	1781	finally
    //   1452	1468	1781	finally
    //   1507	1510	1781	finally
    //   1510	1538	1781	finally
    //   1548	1573	1781	finally
    //   1580	1595	1781	finally
    //   1602	1608	1781	finally
    //   1613	1622	1781	finally
    //   1640	1643	1781	finally
    //   1645	1650	1781	finally
    //   1666	1707	1781	finally
    //   1717	1724	1781	finally
    //   1202	1210	1796	java/lang/Exception
    //   1223	1263	1796	java/lang/Exception
    //   1324	1339	1796	java/lang/Exception
    //   1356	1402	1796	java/lang/Exception
    //   1412	1427	1796	java/lang/Exception
    //   1427	1434	1796	java/lang/Exception
    //   1452	1468	1796	java/lang/Exception
    //   1507	1510	1796	java/lang/Exception
    //   1510	1538	1796	java/lang/Exception
    //   1548	1573	1796	java/lang/Exception
    //   1580	1595	1796	java/lang/Exception
    //   1602	1608	1796	java/lang/Exception
    //   1613	1622	1796	java/lang/Exception
    //   1640	1643	1796	java/lang/Exception
    //   1645	1650	1796	java/lang/Exception
    //   1666	1707	1796	java/lang/Exception
    //   1717	1724	1796	java/lang/Exception
    //   166	172	1811	finally
    //   180	189	1811	finally
    //   197	206	1811	finally
    //   214	233	1811	finally
    //   241	250	1811	finally
    //   258	277	1811	finally
    //   285	294	1811	finally
    //   302	321	1811	finally
    //   329	340	1811	finally
    //   348	360	1811	finally
    //   372	383	1811	finally
    //   391	409	1811	finally
    //   425	429	1811	finally
    //   437	443	1811	finally
    //   451	459	1811	finally
    //   467	475	1811	finally
    //   483	501	1811	finally
    //   509	517	1811	finally
    //   525	543	1811	finally
    //   551	559	1811	finally
    //   567	585	1811	finally
    //   593	603	1811	finally
    //   611	621	1811	finally
    //   640	644	1811	finally
    //   660	669	1811	finally
    //   716	721	1811	finally
    //   729	736	1811	finally
    //   744	751	1811	finally
    //   759	768	1811	finally
    //   780	785	1811	finally
    //   799	808	1811	finally
    //   1836	1840	1811	finally
    //   1848	1858	1811	finally
    //   166	172	1819	java/lang/Exception
    //   180	189	1819	java/lang/Exception
    //   197	206	1819	java/lang/Exception
    //   214	233	1819	java/lang/Exception
    //   241	250	1819	java/lang/Exception
    //   258	277	1819	java/lang/Exception
    //   285	294	1819	java/lang/Exception
    //   302	321	1819	java/lang/Exception
    //   329	340	1819	java/lang/Exception
    //   348	360	1819	java/lang/Exception
    //   372	383	1819	java/lang/Exception
    //   391	409	1819	java/lang/Exception
    //   425	429	1819	java/lang/Exception
    //   437	443	1819	java/lang/Exception
    //   451	459	1819	java/lang/Exception
    //   467	475	1819	java/lang/Exception
    //   483	501	1819	java/lang/Exception
    //   509	517	1819	java/lang/Exception
    //   525	543	1819	java/lang/Exception
    //   551	559	1819	java/lang/Exception
    //   567	585	1819	java/lang/Exception
    //   593	603	1819	java/lang/Exception
    //   611	621	1819	java/lang/Exception
    //   640	644	1819	java/lang/Exception
    //   660	669	1819	java/lang/Exception
    //   716	721	1819	java/lang/Exception
    //   729	736	1819	java/lang/Exception
    //   744	751	1819	java/lang/Exception
    //   759	768	1819	java/lang/Exception
    //   780	785	1819	java/lang/Exception
    //   799	808	1819	java/lang/Exception
    //   1836	1840	1819	java/lang/Exception
    //   1848	1858	1819	java/lang/Exception
    //   716	721	1827	java/lang/Throwable
    //   22	28	1897	finally
    //   37	102	1897	finally
    //   113	119	1897	finally
    //   119	136	1897	finally
    //   143	151	1897	finally
    //   151	158	1897	finally
    //   22	28	1907	java/lang/Exception
    //   37	102	1907	java/lang/Exception
    //   113	119	1907	java/lang/Exception
    //   119	136	1907	java/lang/Exception
    //   143	151	1907	java/lang/Exception
    //   151	158	1907	java/lang/Exception
    //   1914	1926	1977	finally
    //   674	684	2087	java/lang/Exception
    //   687	692	2087	java/lang/Exception
    //   1067	1077	2091	java/lang/Exception
    //   1080	1085	2091	java/lang/Exception
    //   1089	1097	2091	java/lang/Exception
    //   1113	1149	2095	java/lang/Exception
    //   1149	1173	2095	java/lang/Exception
    //   1177	1189	2095	java/lang/Exception
    //   1192	1202	2095	java/lang/Exception
    //   1053	1062	2100	java/lang/Exception
    //   1268	1278	2105	java/lang/Exception
    //   1281	1286	2105	java/lang/Exception
    //   1291	1301	2105	java/lang/Exception
    //   975	987	2109	finally
    //   1007	1014	2109	finally
    //   1053	1062	2109	finally
    //   975	987	2114	java/lang/Exception
    //   1007	1014	2114	java/lang/Exception
    //   1732	1742	2150	java/lang/Exception
    //   1745	1750	2150	java/lang/Exception
    //   1755	1765	2150	java/lang/Exception
    //   1863	1873	2155	java/lang/Exception
    //   1876	1881	2155	java/lang/Exception
    //   1930	1938	2159	java/lang/Exception
    //   1941	1946	2159	java/lang/Exception
    //   1951	1961	2159	java/lang/Exception
    //   1994	2004	2163	java/lang/Exception
    //   2007	2012	2163	java/lang/Exception
    //   2017	2027	2163	java/lang/Exception
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   4: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   7: getfield 123	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:jdField_a_of_type_Int	I
    //   10: iconst_3
    //   11: if_icmpeq +49 -> 60
    //   14: ldc2_w 436
    //   17: invokestatic 443	java/lang/Thread:sleep	(J)V
    //   20: goto +8 -> 28
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 160	java/lang/InterruptedException:printStackTrace	()V
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 47	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_d_of_type_Boolean	Z
    //   35: aload_0
    //   36: invokevirtual 446	java/lang/Object:notifyAll	()V
    //   39: goto +12 -> 51
    //   42: astore_1
    //   43: goto +13 -> 56
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 447	java/lang/Exception:printStackTrace	()V
    //   51: aload_0
    //   52: monitorexit
    //   53: goto +7 -> 60
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 27	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 29	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   70: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	AudioPlayRunnable
    //   23	2	1	localInterruptedException	java.lang.InterruptedException
    //   42	1	1	localObject	Object
    //   46	13	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   14	20	23	java/lang/InterruptedException
    //   30	39	42	finally
    //   47	51	42	finally
    //   51	53	42	finally
    //   56	58	42	finally
    //   30	39	46	java/lang/Exception
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.this$0.a != null)
    {
      float f = (float)paramLong1 / (float)paramLong2;
      if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float))
      {
        if (this.this$0.a.jdField_a_of_type_Int == 5) {
          this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - (f - this.jdField_a_of_type_Float));
        } else {
          this.jdField_c_of_type_Float = f;
        }
        QLog.d("AudioDecoder", 1, new Object[] { "seekToPercent: ", Float.valueOf(this.jdField_c_of_type_Float) });
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek error, timePercent=");
      localStringBuilder.append(f);
      QLog.w("AudioDecoder", 1, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    boolean bool2 = this.jdField_b_of_type_Boolean;
    boolean bool1 = true;
    if ((bool2) && (!TextUtils.isEmpty(this.this$0.a.jdField_b_of_type_JavaLangString))) {}
    try
    {
      localObject = FileUtils.fileToBytes(new File(this.this$0.a.jdField_b_of_type_JavaLangString));
    }
    catch (Exception localException)
    {
      Object localObject;
      label51:
      break label51;
    }
    QLog.e("AudioDecoder", 1, "bgm music get error");
    localObject = null;
    break label132;
    if (MimeHelper.validateVideoType(MimeTypesTools.getMimeType(BaseApplication.getContext(), this.this$0.a.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.this$0.a.jdField_a_of_type_JavaLangString;
      if (this.this$0.a.jdField_a_of_type_Int == 5) {
        bool1 = false;
      }
      localObject = a((String)localObject, bool1);
    }
    else
    {
      localObject = a();
    }
    label132:
    if (localObject != null) {
      a((byte[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder.AudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */