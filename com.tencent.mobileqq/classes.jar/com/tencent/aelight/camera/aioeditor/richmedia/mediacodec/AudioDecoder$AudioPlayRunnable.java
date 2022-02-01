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
  public boolean a;
  public boolean b;
  private volatile int c = 0;
  private volatile int d = -1;
  private float e = 0.0F;
  private float f = 0.0F;
  private int g = 0;
  private int h = 0;
  private long i = 0L;
  private int j = 0;
  private volatile boolean k = false;
  private Object l = new Object();
  private volatile boolean m = false;
  private float n = -1.0F;
  
  public AudioDecoder$AudioPlayRunnable(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 67
    //   2: iconst_4
    //   3: ldc 69
    //   5: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aload_0
    //   15: invokespecial 77	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	()Landroid/media/AudioTrack;
    //   18: astore 9
    //   20: aload 9
    //   22: astore 8
    //   24: aload 9
    //   26: astore 7
    //   28: aload 9
    //   30: invokevirtual 83	android/media/AudioTrack:getSampleRate	()I
    //   33: aload 9
    //   35: invokevirtual 86	android/media/AudioTrack:getChannelConfiguration	()I
    //   38: aload 9
    //   40: invokevirtual 89	android/media/AudioTrack:getAudioFormat	()I
    //   43: invokestatic 93	android/media/AudioTrack:getMinBufferSize	(III)I
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
    //   74: putfield 95	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	Z
    //   77: aload 9
    //   79: astore 8
    //   81: aload 9
    //   83: astore 7
    //   85: aload_0
    //   86: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   89: aload_1
    //   90: arraylength
    //   91: if_icmpge +723 -> 814
    //   94: aload 9
    //   96: astore 8
    //   98: aload 9
    //   100: astore 7
    //   102: aload_0
    //   103: getfield 95	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	Z
    //   106: ifne +708 -> 814
    //   109: aload 9
    //   111: astore 8
    //   113: aload 9
    //   115: astore 7
    //   117: aload_0
    //   118: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:n	F
    //   121: ldc 57
    //   123: fcmpl
    //   124: ifeq +132 -> 256
    //   127: aload 9
    //   129: astore 8
    //   131: aload 9
    //   133: astore 7
    //   135: aload_0
    //   136: getfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:n	F
    //   139: aload_0
    //   140: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:j	I
    //   143: i2f
    //   144: fmul
    //   145: aload_0
    //   146: getfield 42	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:f	F
    //   149: fdiv
    //   150: f2i
    //   151: istore_3
    //   152: aload 9
    //   154: astore 8
    //   156: aload 9
    //   158: astore 7
    //   160: iload_3
    //   161: aload_0
    //   162: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   165: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   168: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   171: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
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
    //   194: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   197: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   200: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   203: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
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
    //   222: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   225: isub
    //   226: putfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   229: aload 9
    //   231: astore 8
    //   233: aload 9
    //   235: astore 7
    //   237: aload 9
    //   239: invokevirtual 111	android/media/AudioTrack:flush	()V
    //   242: aload 9
    //   244: astore 8
    //   246: aload 9
    //   248: astore 7
    //   250: aload_0
    //   251: ldc 57
    //   253: putfield 59	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:n	F
    //   256: aload 9
    //   258: astore 8
    //   260: aload 9
    //   262: astore 7
    //   264: aload_0
    //   265: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   268: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   271: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:d	I
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
    //   311: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   314: isub
    //   315: iload 4
    //   317: invokestatic 118	java/lang/Math:min	(II)I
    //   320: istore_3
    //   321: aload 9
    //   323: astore 8
    //   325: aload 9
    //   327: astore 7
    //   329: aload_0
    //   330: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   333: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   336: getfield 120	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:e	Z
    //   339: ifne +554 -> 893
    //   342: aload 9
    //   344: astore 8
    //   346: aload 9
    //   348: astore 7
    //   350: aload 9
    //   352: aload_1
    //   353: aload_0
    //   354: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   357: iload_3
    //   358: invokevirtual 124	android/media/AudioTrack:write	([BII)I
    //   361: pop
    //   362: goto +531 -> 893
    //   365: aload 9
    //   367: astore 8
    //   369: aload 9
    //   371: astore 7
    //   373: aload_1
    //   374: aload_0
    //   375: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   378: aload 10
    //   380: iload 4
    //   382: invokestatic 129	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:c	([BI[BI)I
    //   385: istore_2
    //   386: goto +512 -> 898
    //   389: aload 9
    //   391: astore 8
    //   393: aload 9
    //   395: astore 7
    //   397: aload_1
    //   398: aload_0
    //   399: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   402: aload 10
    //   404: iload 4
    //   406: iconst_4
    //   407: invokestatic 132	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BII)I
    //   410: istore_2
    //   411: goto +487 -> 898
    //   414: aload 9
    //   416: astore 8
    //   418: aload 9
    //   420: astore 7
    //   422: aload_1
    //   423: aload_0
    //   424: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   427: aload 10
    //   429: iload 4
    //   431: invokestatic 134	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:b	([BI[BI)I
    //   434: istore_2
    //   435: goto +463 -> 898
    //   438: aload 9
    //   440: astore 8
    //   442: aload 9
    //   444: astore 7
    //   446: aload_1
    //   447: aload_0
    //   448: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   451: aload 10
    //   453: iload 4
    //   455: iconst_2
    //   456: invokestatic 132	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BII)I
    //   459: istore_2
    //   460: goto +438 -> 898
    //   463: aload 9
    //   465: astore 8
    //   467: aload 9
    //   469: astore 7
    //   471: aload_1
    //   472: aload_0
    //   473: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   476: aload 10
    //   478: iload 4
    //   480: invokestatic 136	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	([BI[BI)I
    //   483: istore_2
    //   484: goto +414 -> 898
    //   487: aload 9
    //   489: astore 8
    //   491: aload 9
    //   493: astore 7
    //   495: aload_0
    //   496: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   499: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   502: getfield 120	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:e	Z
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
    //   527: invokevirtual 124	android/media/AudioTrack:write	([BII)I
    //   530: pop
    //   531: aload 9
    //   533: astore 8
    //   535: aload 9
    //   537: astore 7
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   544: iload_3
    //   545: iadd
    //   546: putfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   549: aload 9
    //   551: astore 8
    //   553: aload 9
    //   555: astore 7
    //   557: aload_0
    //   558: getfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   561: aload_1
    //   562: arraylength
    //   563: if_icmplt +147 -> 710
    //   566: aload 9
    //   568: astore 8
    //   570: aload 9
    //   572: astore 7
    //   574: aload_0
    //   575: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   578: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   581: getfield 138	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:c	Z
    //   584: ifeq +126 -> 710
    //   587: aload 9
    //   589: astore 8
    //   591: aload 9
    //   593: astore 7
    //   595: aload_0
    //   596: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   599: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   602: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:d	I
    //   605: iconst_3
    //   606: if_icmpeq +61 -> 667
    //   609: aload 9
    //   611: astore 8
    //   613: aload 9
    //   615: astore 7
    //   617: aload_0
    //   618: monitorenter
    //   619: aload_0
    //   620: getfield 56	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:m	Z
    //   623: ifne +26 -> 649
    //   626: aload_0
    //   627: invokevirtual 141	java/lang/Object:wait	()V
    //   630: aload_0
    //   631: iconst_0
    //   632: putfield 56	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:m	Z
    //   635: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +11 -> 649
    //   641: ldc 67
    //   643: iconst_1
    //   644: ldc 147
    //   646: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   677: putfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   680: aload 9
    //   682: astore 8
    //   684: aload 9
    //   686: astore 7
    //   688: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +19 -> 710
    //   694: aload 9
    //   696: astore 8
    //   698: aload 9
    //   700: astore 7
    //   702: ldc 67
    //   704: iconst_1
    //   705: ldc 149
    //   707: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload 9
    //   712: astore 8
    //   714: aload 9
    //   716: astore 7
    //   718: aload_0
    //   719: getfield 52	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:k	Z
    //   722: istore 6
    //   724: iload 6
    //   726: ifeq -649 -> 77
    //   729: aload 9
    //   731: astore 8
    //   733: aload 9
    //   735: astore 7
    //   737: aload_0
    //   738: getfield 54	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:l	Ljava/lang/Object;
    //   741: astore 11
    //   743: aload 9
    //   745: astore 8
    //   747: aload 9
    //   749: astore 7
    //   751: aload 11
    //   753: monitorenter
    //   754: aload_0
    //   755: getfield 54	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:l	Ljava/lang/Object;
    //   758: invokevirtual 141	java/lang/Object:wait	()V
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
    //   795: invokevirtual 152	java/lang/InterruptedException:printStackTrace	()V
    //   798: aload 9
    //   800: astore 8
    //   802: aload 9
    //   804: astore 7
    //   806: aload_0
    //   807: iconst_1
    //   808: putfield 95	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	Z
    //   811: goto -734 -> 77
    //   814: aload 9
    //   816: astore 8
    //   818: aload 9
    //   820: astore 7
    //   822: aload 9
    //   824: invokevirtual 155	android/media/AudioTrack:stop	()V
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
    //   848: ldc 67
    //   850: iconst_4
    //   851: ldc 157
    //   853: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: aload 7
    //   858: astore 8
    //   860: aload_1
    //   861: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   864: aload 7
    //   866: ifnull +8 -> 874
    //   869: aload 7
    //   871: invokevirtual 163	android/media/AudioTrack:release	()V
    //   874: return
    //   875: aload 8
    //   877: ifnull +8 -> 885
    //   880: aload 8
    //   882: invokevirtual 163	android/media/AudioTrack:release	()V
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
    //   178	724	2	i1	int
    //   151	749	3	i2	int
    //   48	478	4	i3	int
    //   175	34	5	i4	int
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
  private byte[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 67
    //   2: iconst_4
    //   3: ldc 168
    //   5: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   11: lstore 13
    //   13: new 176	android/media/MediaExtractor
    //   16: dup
    //   17: invokespecial 177	android/media/MediaExtractor:<init>	()V
    //   20: astore 22
    //   22: aload 22
    //   24: aload_1
    //   25: invokevirtual 181	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   28: lconst_0
    //   29: lstore 11
    //   31: lload 11
    //   33: lstore 9
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: aload 22
    //   40: invokevirtual 184	android/media/MediaExtractor:getTrackCount	()I
    //   43: if_icmpge +2018 -> 2061
    //   46: aload 22
    //   48: iload_3
    //   49: invokevirtual 188	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 20
    //   54: aload 20
    //   56: ldc 190
    //   58: invokevirtual 196	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 17
    //   63: aload_0
    //   64: aload 20
    //   66: ldc 198
    //   68: invokevirtual 202	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   71: putfield 48	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:i	J
    //   74: aload_0
    //   75: getfield 40	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	F
    //   78: aload_0
    //   79: getfield 48	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:i	J
    //   82: l2f
    //   83: fmul
    //   84: f2l
    //   85: lstore 11
    //   87: aload_0
    //   88: getfield 42	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:f	F
    //   91: aload_0
    //   92: getfield 48	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:i	J
    //   95: l2f
    //   96: fmul
    //   97: f2l
    //   98: lstore 15
    //   100: lload 15
    //   102: lstore 9
    //   104: lload 15
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +9 -> 117
    //   111: aload_0
    //   112: getfield 48	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:i	J
    //   115: lstore 9
    //   117: aload 17
    //   119: ldc 204
    //   121: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   124: ifeq +1918 -> 2042
    //   127: aload 22
    //   129: iload_3
    //   130: invokevirtual 214	android/media/MediaExtractor:selectTrack	(I)V
    //   133: lload 11
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +11 -> 148
    //   140: aload 22
    //   142: lload 11
    //   144: iconst_0
    //   145: invokevirtual 218	android/media/MediaExtractor:seekTo	(JI)V
    //   148: aload 17
    //   150: invokestatic 224	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   153: astore 17
    //   155: aload 17
    //   157: astore 18
    //   159: aload 17
    //   161: astore 19
    //   163: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +168 -> 334
    //   169: aload 17
    //   171: astore 18
    //   173: aload 17
    //   175: astore 19
    //   177: new 226	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   184: astore 21
    //   186: aload 17
    //   188: astore 18
    //   190: aload 17
    //   192: astore 19
    //   194: aload 21
    //   196: ldc 229
    //   198: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 17
    //   204: astore 18
    //   206: aload 17
    //   208: astore 19
    //   210: aload 21
    //   212: aload_0
    //   213: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   216: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   219: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   222: getfield 235	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   225: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 17
    //   231: astore 18
    //   233: aload 17
    //   235: astore 19
    //   237: aload 21
    //   239: ldc 240
    //   241: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 17
    //   247: astore 18
    //   249: aload 17
    //   251: astore 19
    //   253: aload 21
    //   255: aload_0
    //   256: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   259: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   262: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   265: getfield 241	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:g	I
    //   268: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 17
    //   274: astore 18
    //   276: aload 17
    //   278: astore 19
    //   280: aload 21
    //   282: ldc 243
    //   284: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 17
    //   290: astore 18
    //   292: aload 17
    //   294: astore 19
    //   296: aload 21
    //   298: aload_0
    //   299: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   302: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   305: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   308: getfield 245	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:f	I
    //   311: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 17
    //   317: astore 18
    //   319: aload 17
    //   321: astore 19
    //   323: ldc 67
    //   325: iconst_4
    //   326: aload 21
    //   328: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload 17
    //   336: astore 18
    //   338: aload 17
    //   340: astore 19
    //   342: aload_0
    //   343: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   346: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   349: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   352: astore 23
    //   354: aload 20
    //   356: astore 21
    //   358: aload 17
    //   360: astore 18
    //   362: aload 17
    //   364: astore 19
    //   366: aload 23
    //   368: aload 21
    //   370: aload_1
    //   371: invokestatic 254	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   374: putfield 241	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:g	I
    //   377: aload 17
    //   379: astore 18
    //   381: aload 17
    //   383: astore 19
    //   385: aload_0
    //   386: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   389: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   392: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   395: aload 21
    //   397: invokestatic 257	com/tencent/biz/qqstory/utils/AudioSampleRateExtract:a	(Landroid/media/MediaFormat;)I
    //   400: putfield 245	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:f	I
    //   403: goto +20 -> 423
    //   406: astore_1
    //   407: goto +4 -> 411
    //   410: astore_1
    //   411: aload 17
    //   413: astore 18
    //   415: aload 17
    //   417: astore 19
    //   419: aload_1
    //   420: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   423: aload 17
    //   425: astore 18
    //   427: aload 17
    //   429: astore 19
    //   431: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +161 -> 595
    //   437: aload 17
    //   439: astore 18
    //   441: aload 17
    //   443: astore 19
    //   445: new 226	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   452: astore_1
    //   453: aload 17
    //   455: astore 18
    //   457: aload 17
    //   459: astore 19
    //   461: aload_1
    //   462: ldc_w 259
    //   465: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 17
    //   471: astore 18
    //   473: aload 17
    //   475: astore 19
    //   477: aload_1
    //   478: aload_0
    //   479: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   482: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   485: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   488: getfield 235	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   491: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 17
    //   497: astore 18
    //   499: aload 17
    //   501: astore 19
    //   503: aload_1
    //   504: ldc 240
    //   506: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 17
    //   512: astore 18
    //   514: aload 17
    //   516: astore 19
    //   518: aload_1
    //   519: aload_0
    //   520: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   523: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   526: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   529: getfield 241	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:g	I
    //   532: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 17
    //   538: astore 18
    //   540: aload 17
    //   542: astore 19
    //   544: aload_1
    //   545: ldc 243
    //   547: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 17
    //   553: astore 18
    //   555: aload 17
    //   557: astore 19
    //   559: aload_1
    //   560: aload_0
    //   561: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   564: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   567: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   570: getfield 245	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:f	I
    //   573: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 17
    //   579: astore 18
    //   581: aload 17
    //   583: astore 19
    //   585: ldc 67
    //   587: iconst_4
    //   588: aload_1
    //   589: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload 17
    //   597: astore 18
    //   599: aload 17
    //   601: astore 19
    //   603: aload 17
    //   605: aload 20
    //   607: aconst_null
    //   608: aconst_null
    //   609: iconst_0
    //   610: invokevirtual 263	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   613: goto +26 -> 639
    //   616: astore_1
    //   617: goto +7 -> 624
    //   620: astore_1
    //   621: aconst_null
    //   622: astore 17
    //   624: aload 17
    //   626: astore 18
    //   628: aload 17
    //   630: astore 19
    //   632: aload_1
    //   633: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   636: goto +3 -> 639
    //   639: aload 17
    //   641: ifnonnull +59 -> 700
    //   644: aload 17
    //   646: astore 18
    //   648: aload 17
    //   650: astore 19
    //   652: ldc 67
    //   654: iconst_2
    //   655: ldc_w 265
    //   658: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aload 17
    //   663: ifnull +16 -> 679
    //   666: aload 17
    //   668: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   671: aload 17
    //   673: invokevirtual 267	android/media/MediaCodec:release	()V
    //   676: goto +3 -> 679
    //   679: aload 22
    //   681: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   684: aconst_null
    //   685: areturn
    //   686: ldc 67
    //   688: iconst_1
    //   689: aload_1
    //   690: iconst_0
    //   691: anewarray 4	java/lang/Object
    //   694: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   697: goto -13 -> 684
    //   700: aload 17
    //   702: astore 18
    //   704: aload 17
    //   706: astore 19
    //   708: aload 17
    //   710: invokevirtual 274	android/media/MediaCodec:start	()V
    //   713: aload 17
    //   715: astore 18
    //   717: aload 17
    //   719: astore 19
    //   721: aload 17
    //   723: invokevirtual 278	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   726: astore 23
    //   728: aload 17
    //   730: astore 18
    //   732: aload 17
    //   734: astore 19
    //   736: aload 17
    //   738: invokevirtual 281	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   741: astore 20
    //   743: aload 17
    //   745: astore 18
    //   747: aload 17
    //   749: astore 19
    //   751: new 283	android/media/MediaCodec$BufferInfo
    //   754: dup
    //   755: invokespecial 284	android/media/MediaCodec$BufferInfo:<init>	()V
    //   758: astore 24
    //   760: iload_2
    //   761: ifeq +22 -> 783
    //   764: aload 17
    //   766: astore 18
    //   768: aload 17
    //   770: astore 19
    //   772: aload_0
    //   773: invokespecial 77	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	()Landroid/media/AudioTrack;
    //   776: astore_1
    //   777: aconst_null
    //   778: astore 19
    //   780: goto +26 -> 806
    //   783: aload 17
    //   785: astore 18
    //   787: aload 17
    //   789: astore 19
    //   791: new 286	java/io/ByteArrayOutputStream
    //   794: dup
    //   795: invokespecial 287	java/io/ByteArrayOutputStream:<init>	()V
    //   798: astore 21
    //   800: aconst_null
    //   801: astore_1
    //   802: aload 21
    //   804: astore 19
    //   806: aload 20
    //   808: astore 18
    //   810: iconst_0
    //   811: istore 7
    //   813: iconst_0
    //   814: istore 5
    //   816: iconst_0
    //   817: istore_3
    //   818: iload 7
    //   820: ifne +1319 -> 2139
    //   823: iload 5
    //   825: istore 4
    //   827: iload 5
    //   829: ifne +134 -> 963
    //   832: aload 17
    //   834: ldc2_w 288
    //   837: invokevirtual 293	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   840: istore 6
    //   842: iload 5
    //   844: istore 4
    //   846: iload 6
    //   848: iflt +115 -> 963
    //   851: aload 22
    //   853: aload 23
    //   855: iload 6
    //   857: aaload
    //   858: iconst_0
    //   859: invokevirtual 297	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   862: istore 4
    //   864: aload 22
    //   866: invokevirtual 300	android/media/MediaExtractor:getSampleTime	()J
    //   869: lstore 15
    //   871: iload 4
    //   873: iflt +47 -> 920
    //   876: lload 9
    //   878: lconst_0
    //   879: lcmp
    //   880: ifle +14 -> 894
    //   883: lload 15
    //   885: lload 9
    //   887: lcmp
    //   888: iflt +6 -> 894
    //   891: goto +29 -> 920
    //   894: aload 17
    //   896: iload 6
    //   898: iconst_0
    //   899: iload 4
    //   901: lload 15
    //   903: iconst_0
    //   904: invokevirtual 304	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   907: aload 22
    //   909: invokevirtual 307	android/media/MediaExtractor:advance	()Z
    //   912: pop
    //   913: iload 5
    //   915: istore 4
    //   917: goto +46 -> 963
    //   920: aload 17
    //   922: iload 6
    //   924: iconst_0
    //   925: iconst_0
    //   926: lconst_0
    //   927: iconst_4
    //   928: invokevirtual 304	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   931: iconst_1
    //   932: istore 4
    //   934: goto +29 -> 963
    //   937: astore 19
    //   939: aload_1
    //   940: astore 18
    //   942: aload 19
    //   944: astore_1
    //   945: goto +1036 -> 1981
    //   948: astore 18
    //   950: aload_1
    //   951: astore 19
    //   953: aload 17
    //   955: astore_1
    //   956: aload 19
    //   958: astore 17
    //   960: goto +946 -> 1906
    //   963: iload_3
    //   964: ifne +1147 -> 2111
    //   967: aload 17
    //   969: aload 24
    //   971: ldc2_w 288
    //   974: invokevirtual 311	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   977: istore 5
    //   979: iload 5
    //   981: bipush 253
    //   983: if_icmpeq +421 -> 1404
    //   986: iload 5
    //   988: bipush 254
    //   990: if_icmpeq +351 -> 1341
    //   993: iload 5
    //   995: iconst_m1
    //   996: if_icmpeq +313 -> 1309
    //   999: aload 24
    //   1001: getfield 314	android/media/MediaCodec$BufferInfo:flags	I
    //   1004: istore 6
    //   1006: iload 6
    //   1008: iconst_4
    //   1009: iand
    //   1010: ifeq +23 -> 1033
    //   1013: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq +12 -> 1028
    //   1019: ldc 67
    //   1021: iconst_2
    //   1022: ldc_w 316
    //   1025: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: iconst_1
    //   1029: istore_3
    //   1030: goto +164 -> 1194
    //   1033: aload 18
    //   1035: iload 5
    //   1037: aaload
    //   1038: astore 20
    //   1040: aload 20
    //   1042: ifnonnull +63 -> 1105
    //   1045: ldc 67
    //   1047: iconst_1
    //   1048: ldc_w 318
    //   1051: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: aload 17
    //   1056: ifnull +16 -> 1072
    //   1059: aload 17
    //   1061: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1064: aload 17
    //   1066: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1069: goto +3 -> 1072
    //   1072: aload 22
    //   1074: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   1077: aload_1
    //   1078: ifnull +11 -> 1089
    //   1081: aload_1
    //   1082: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   1085: aload_1
    //   1086: invokevirtual 163	android/media/AudioTrack:release	()V
    //   1089: aconst_null
    //   1090: areturn
    //   1091: ldc 67
    //   1093: iconst_1
    //   1094: aload_1
    //   1095: iconst_0
    //   1096: anewarray 4	java/lang/Object
    //   1099: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1102: goto -13 -> 1089
    //   1105: aload 24
    //   1107: getfield 321	android/media/MediaCodec$BufferInfo:size	I
    //   1110: ifeq +31 -> 1141
    //   1113: aload 20
    //   1115: aload 24
    //   1117: getfield 324	android/media/MediaCodec$BufferInfo:offset	I
    //   1120: invokevirtual 330	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1123: pop
    //   1124: aload 20
    //   1126: aload 24
    //   1128: getfield 324	android/media/MediaCodec$BufferInfo:offset	I
    //   1131: aload 24
    //   1133: getfield 321	android/media/MediaCodec$BufferInfo:size	I
    //   1136: iadd
    //   1137: invokevirtual 333	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1140: pop
    //   1141: aload 20
    //   1143: invokevirtual 336	java/nio/ByteBuffer:remaining	()I
    //   1146: istore 6
    //   1148: iload 6
    //   1150: newarray byte
    //   1152: astore 21
    //   1154: aload 20
    //   1156: aload 21
    //   1158: iconst_0
    //   1159: iload 6
    //   1161: invokevirtual 340	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1164: pop
    //   1165: iload_2
    //   1166: ifeq +18 -> 1184
    //   1169: aload_0
    //   1170: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   1173: aload_1
    //   1174: aload 21
    //   1176: iload 6
    //   1178: invokestatic 343	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
    //   1181: goto +13 -> 1194
    //   1184: aload 19
    //   1186: aload 21
    //   1188: iconst_0
    //   1189: iload 6
    //   1191: invokevirtual 346	java/io/ByteArrayOutputStream:write	([BII)V
    //   1194: aload 17
    //   1196: iload 5
    //   1198: iconst_0
    //   1199: invokevirtual 350	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1202: iload_3
    //   1203: istore 6
    //   1205: aload 18
    //   1207: astore 20
    //   1209: goto +223 -> 1432
    //   1212: aload_1
    //   1213: astore 19
    //   1215: new 226	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   1222: astore 20
    //   1224: aload 20
    //   1226: ldc_w 352
    //   1229: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload 20
    //   1235: aload 18
    //   1237: invokevirtual 353	java/lang/Exception:toString	()Ljava/lang/String;
    //   1240: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: ldc 67
    //   1246: iconst_1
    //   1247: aload 20
    //   1249: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1255: aload 17
    //   1257: ifnull +16 -> 1273
    //   1260: aload 17
    //   1262: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1265: aload 17
    //   1267: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1270: goto +3 -> 1273
    //   1273: aload 22
    //   1275: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   1278: aload 19
    //   1280: ifnull +13 -> 1293
    //   1283: aload 19
    //   1285: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   1288: aload 19
    //   1290: invokevirtual 163	android/media/AudioTrack:release	()V
    //   1293: aconst_null
    //   1294: areturn
    //   1295: ldc 67
    //   1297: iconst_1
    //   1298: aload_1
    //   1299: iconst_0
    //   1300: anewarray 4	java/lang/Object
    //   1303: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1306: goto -13 -> 1293
    //   1309: iload_3
    //   1310: istore 6
    //   1312: aload 18
    //   1314: astore 20
    //   1316: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1319: ifeq +113 -> 1432
    //   1322: ldc 67
    //   1324: iconst_2
    //   1325: ldc_w 355
    //   1328: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1331: iload_3
    //   1332: istore 6
    //   1334: aload 18
    //   1336: astore 20
    //   1338: goto +94 -> 1432
    //   1341: iload_3
    //   1342: istore 6
    //   1344: aload 18
    //   1346: astore 20
    //   1348: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq +81 -> 1432
    //   1354: new 226	java/lang/StringBuilder
    //   1357: dup
    //   1358: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   1361: astore 20
    //   1363: aload 20
    //   1365: ldc_w 357
    //   1368: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload 20
    //   1374: aload 17
    //   1376: invokevirtual 361	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1379: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1382: pop
    //   1383: ldc 67
    //   1385: iconst_2
    //   1386: aload 20
    //   1388: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1394: iload_3
    //   1395: istore 6
    //   1397: aload 18
    //   1399: astore 20
    //   1401: goto +31 -> 1432
    //   1404: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +12 -> 1419
    //   1410: ldc 67
    //   1412: iconst_2
    //   1413: ldc_w 366
    //   1416: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1419: aload 17
    //   1421: invokevirtual 281	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1424: astore 20
    //   1426: iload_3
    //   1427: istore 6
    //   1429: goto +3 -> 1432
    //   1432: aload_1
    //   1433: astore 18
    //   1435: iload 6
    //   1437: ifeq +96 -> 1533
    //   1440: iload_2
    //   1441: ifeq +214 -> 1655
    //   1444: aload_0
    //   1445: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   1448: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   1451: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:d	I
    //   1454: iconst_3
    //   1455: if_icmpeq +47 -> 1502
    //   1458: aload_0
    //   1459: monitorenter
    //   1460: aload_0
    //   1461: getfield 56	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:m	Z
    //   1464: ifne +26 -> 1490
    //   1467: aload_0
    //   1468: invokevirtual 141	java/lang/Object:wait	()V
    //   1471: aload_0
    //   1472: iconst_0
    //   1473: putfield 56	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:m	Z
    //   1476: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1479: ifeq +11 -> 1490
    //   1482: ldc 67
    //   1484: iconst_1
    //   1485: ldc 147
    //   1487: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1490: aload_0
    //   1491: monitorexit
    //   1492: goto +10 -> 1502
    //   1495: astore 18
    //   1497: aload_0
    //   1498: monitorexit
    //   1499: aload 18
    //   1501: athrow
    //   1502: aload 17
    //   1504: invokevirtual 367	android/media/MediaCodec:flush	()V
    //   1507: aload 22
    //   1509: lload 11
    //   1511: iconst_0
    //   1512: invokevirtual 218	android/media/MediaExtractor:seekTo	(JI)V
    //   1515: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1518: ifeq +603 -> 2121
    //   1521: ldc 67
    //   1523: iconst_1
    //   1524: ldc_w 369
    //   1527: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1530: goto +591 -> 2121
    //   1533: iload 4
    //   1535: istore 5
    //   1537: iload 6
    //   1539: istore_3
    //   1540: aload_0
    //   1541: getfield 38	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   1544: ifne +50 -> 1594
    //   1547: aload_0
    //   1548: iconst_m1
    //   1549: putfield 38	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   1552: aload 17
    //   1554: invokevirtual 367	android/media/MediaCodec:flush	()V
    //   1557: aload 22
    //   1559: lload 11
    //   1561: iconst_0
    //   1562: invokevirtual 218	android/media/MediaExtractor:seekTo	(JI)V
    //   1565: iload 4
    //   1567: istore 5
    //   1569: iload 6
    //   1571: istore_3
    //   1572: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1575: ifeq +19 -> 1594
    //   1578: ldc 67
    //   1580: iconst_1
    //   1581: ldc_w 371
    //   1584: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1587: iload 6
    //   1589: istore_3
    //   1590: iload 4
    //   1592: istore 5
    //   1594: aload_0
    //   1595: getfield 52	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:k	Z
    //   1598: istore 8
    //   1600: iload 8
    //   1602: ifeq +527 -> 2129
    //   1605: aload_0
    //   1606: getfield 54	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:l	Ljava/lang/Object;
    //   1609: astore 21
    //   1611: aload 21
    //   1613: monitorenter
    //   1614: aload_0
    //   1615: getfield 54	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:l	Ljava/lang/Object;
    //   1618: invokevirtual 141	java/lang/Object:wait	()V
    //   1621: aload 21
    //   1623: monitorexit
    //   1624: goto +505 -> 2129
    //   1627: astore 25
    //   1629: aload 21
    //   1631: monitorexit
    //   1632: aload 25
    //   1634: athrow
    //   1635: astore 21
    //   1637: aload 21
    //   1639: invokevirtual 152	java/lang/InterruptedException:printStackTrace	()V
    //   1642: aload 18
    //   1644: astore_1
    //   1645: iconst_1
    //   1646: istore 7
    //   1648: aload 20
    //   1650: astore 18
    //   1652: goto -834 -> 818
    //   1655: aload_1
    //   1656: astore 18
    //   1658: new 226	java/lang/StringBuilder
    //   1661: dup
    //   1662: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   1665: astore 20
    //   1667: aload 20
    //   1669: ldc_w 373
    //   1672: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: pop
    //   1676: aload 20
    //   1678: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   1681: lload 13
    //   1683: lsub
    //   1684: invokevirtual 376	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: ldc 67
    //   1690: iconst_1
    //   1691: aload 20
    //   1693: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1696: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1699: aload 19
    //   1701: ifnonnull +8 -> 1709
    //   1704: aconst_null
    //   1705: astore_1
    //   1706: goto +13 -> 1719
    //   1709: aload 19
    //   1711: invokevirtual 380	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1714: astore 19
    //   1716: aload 19
    //   1718: astore_1
    //   1719: aload 17
    //   1721: ifnull +16 -> 1737
    //   1724: aload 17
    //   1726: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1729: aload 17
    //   1731: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1734: goto +3 -> 1737
    //   1737: aload 22
    //   1739: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   1742: aload 18
    //   1744: ifnull +27 -> 1771
    //   1747: aload 18
    //   1749: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   1752: aload 18
    //   1754: invokevirtual 163	android/media/AudioTrack:release	()V
    //   1757: aload_1
    //   1758: areturn
    //   1759: ldc 67
    //   1761: iconst_1
    //   1762: aload 17
    //   1764: iconst_0
    //   1765: anewarray 4	java/lang/Object
    //   1768: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1771: aload_1
    //   1772: areturn
    //   1773: astore 18
    //   1775: aload_1
    //   1776: astore 19
    //   1778: aload 18
    //   1780: astore_1
    //   1781: aload 19
    //   1783: astore 18
    //   1785: goto +196 -> 1981
    //   1788: astore 18
    //   1790: aload_1
    //   1791: astore 19
    //   1793: aload 17
    //   1795: astore_1
    //   1796: aload 19
    //   1798: astore 17
    //   1800: goto +106 -> 1906
    //   1803: astore_1
    //   1804: aload 18
    //   1806: astore 17
    //   1808: goto +85 -> 1893
    //   1811: astore 18
    //   1813: aload 19
    //   1815: astore_1
    //   1816: goto +87 -> 1903
    //   1819: astore_1
    //   1820: aload 17
    //   1822: astore 18
    //   1824: aload 17
    //   1826: astore 19
    //   1828: aload_1
    //   1829: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   1832: aload 17
    //   1834: astore 18
    //   1836: aload 17
    //   1838: astore 19
    //   1840: ldc 67
    //   1842: iconst_2
    //   1843: ldc_w 382
    //   1846: aload_1
    //   1847: invokestatic 385	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1850: aload 17
    //   1852: ifnull +16 -> 1868
    //   1855: aload 17
    //   1857: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1860: aload 17
    //   1862: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1865: goto +3 -> 1868
    //   1868: aload 22
    //   1870: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   1873: aconst_null
    //   1874: areturn
    //   1875: ldc 67
    //   1877: iconst_1
    //   1878: aload_1
    //   1879: iconst_0
    //   1880: anewarray 4	java/lang/Object
    //   1883: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1886: goto -13 -> 1873
    //   1889: astore_1
    //   1890: aconst_null
    //   1891: astore 17
    //   1893: aconst_null
    //   1894: astore 18
    //   1896: goto +85 -> 1981
    //   1899: astore 18
    //   1901: aconst_null
    //   1902: astore_1
    //   1903: aconst_null
    //   1904: astore 17
    //   1906: ldc 67
    //   1908: iconst_1
    //   1909: aload 18
    //   1911: iconst_0
    //   1912: anewarray 4	java/lang/Object
    //   1915: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1918: aload_1
    //   1919: ifnull +14 -> 1933
    //   1922: aload_1
    //   1923: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1926: aload_1
    //   1927: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1930: goto +3 -> 1933
    //   1933: aload 22
    //   1935: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   1938: aload 17
    //   1940: ifnull +13 -> 1953
    //   1943: aload 17
    //   1945: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   1948: aload 17
    //   1950: invokevirtual 163	android/media/AudioTrack:release	()V
    //   1953: aconst_null
    //   1954: areturn
    //   1955: ldc 67
    //   1957: iconst_1
    //   1958: aload_1
    //   1959: iconst_0
    //   1960: anewarray 4	java/lang/Object
    //   1963: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1966: goto -13 -> 1953
    //   1969: astore 19
    //   1971: aload 17
    //   1973: astore 18
    //   1975: aload_1
    //   1976: astore 17
    //   1978: aload 19
    //   1980: astore_1
    //   1981: aload 17
    //   1983: ifnull +16 -> 1999
    //   1986: aload 17
    //   1988: invokevirtual 266	android/media/MediaCodec:stop	()V
    //   1991: aload 17
    //   1993: invokevirtual 267	android/media/MediaCodec:release	()V
    //   1996: goto +3 -> 1999
    //   1999: aload 22
    //   2001: invokevirtual 268	android/media/MediaExtractor:release	()V
    //   2004: aload 18
    //   2006: ifnull +28 -> 2034
    //   2009: aload 18
    //   2011: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   2014: aload 18
    //   2016: invokevirtual 163	android/media/AudioTrack:release	()V
    //   2019: goto +15 -> 2034
    //   2022: ldc 67
    //   2024: iconst_1
    //   2025: aload 17
    //   2027: iconst_0
    //   2028: anewarray 4	java/lang/Object
    //   2031: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2034: goto +5 -> 2039
    //   2037: aload_1
    //   2038: athrow
    //   2039: goto -2 -> 2037
    //   2042: iload_3
    //   2043: iconst_1
    //   2044: iadd
    //   2045: istore_3
    //   2046: lload 11
    //   2048: lstore 15
    //   2050: lload 9
    //   2052: lstore 11
    //   2054: lload 15
    //   2056: lstore 9
    //   2058: goto -2021 -> 37
    //   2061: lload 9
    //   2063: lstore 15
    //   2065: aconst_null
    //   2066: astore 17
    //   2068: lload 11
    //   2070: lstore 9
    //   2072: lload 15
    //   2074: lstore 11
    //   2076: goto -1437 -> 639
    //   2079: astore_1
    //   2080: goto -1394 -> 686
    //   2083: astore_1
    //   2084: goto -993 -> 1091
    //   2087: astore 18
    //   2089: goto -877 -> 1212
    //   2092: astore 18
    //   2094: goto -882 -> 1212
    //   2097: astore_1
    //   2098: goto -803 -> 1295
    //   2101: astore 18
    //   2103: goto -328 -> 1775
    //   2106: astore 18
    //   2108: goto -318 -> 1790
    //   2111: iload_3
    //   2112: istore 6
    //   2114: aload 18
    //   2116: astore 20
    //   2118: goto -686 -> 1432
    //   2121: iconst_0
    //   2122: istore 5
    //   2124: iconst_0
    //   2125: istore_3
    //   2126: goto -532 -> 1594
    //   2129: aload 18
    //   2131: astore_1
    //   2132: aload 20
    //   2134: astore 18
    //   2136: goto -1318 -> 818
    //   2139: goto -484 -> 1655
    //   2142: astore 17
    //   2144: goto -385 -> 1759
    //   2147: astore_1
    //   2148: goto -273 -> 1875
    //   2151: astore_1
    //   2152: goto -197 -> 1955
    //   2155: astore 17
    //   2157: goto -135 -> 2022
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2160	0	this	AudioPlayRunnable
    //   0	2160	1	paramString	String
    //   0	2160	2	paramBoolean	boolean
    //   36	2090	3	i1	int
    //   825	766	4	i2	int
    //   814	1309	5	i3	int
    //   840	1273	6	i4	int
    //   811	836	7	i5	int
    //   1598	3	8	bool	boolean
    //   33	2038	9	l1	long
    //   29	2046	11	l2	long
    //   11	1671	13	l3	long
    //   98	1975	15	l4	long
    //   61	2006	17	localObject1	Object
    //   2142	1	17	localException1	Exception
    //   2155	1	17	localException2	Exception
    //   157	784	18	localObject2	Object
    //   948	450	18	localException3	Exception
    //   1433	1	18	str	String
    //   1495	148	18	localObject3	Object
    //   1650	103	18	localObject4	Object
    //   1773	6	18	localObject5	Object
    //   1783	1	18	localObject6	Object
    //   1788	17	18	localException4	Exception
    //   1811	1	18	localException5	Exception
    //   1822	73	18	localObject7	Object
    //   1899	11	18	localException6	Exception
    //   1973	42	18	localObject8	Object
    //   2087	1	18	localException7	Exception
    //   2092	1	18	localException8	Exception
    //   2101	1	18	localObject9	Object
    //   2106	24	18	localException9	Exception
    //   2134	1	18	localObject10	Object
    //   161	644	19	localObject11	Object
    //   937	6	19	localObject12	Object
    //   951	888	19	localObject13	Object
    //   1969	10	19	localObject14	Object
    //   52	2081	20	localObject15	Object
    //   184	1446	21	localObject16	Object
    //   1635	3	21	localInterruptedException	java.lang.InterruptedException
    //   20	1980	22	localMediaExtractor	android.media.MediaExtractor
    //   352	502	23	localObject17	Object
    //   758	374	24	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   1627	6	25	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   366	377	406	java/lang/Throwable
    //   385	403	406	java/lang/Throwable
    //   342	354	410	java/lang/Throwable
    //   163	169	616	java/lang/Throwable
    //   177	186	616	java/lang/Throwable
    //   194	202	616	java/lang/Throwable
    //   210	229	616	java/lang/Throwable
    //   237	245	616	java/lang/Throwable
    //   253	272	616	java/lang/Throwable
    //   280	288	616	java/lang/Throwable
    //   296	315	616	java/lang/Throwable
    //   323	334	616	java/lang/Throwable
    //   419	423	616	java/lang/Throwable
    //   431	437	616	java/lang/Throwable
    //   445	453	616	java/lang/Throwable
    //   461	469	616	java/lang/Throwable
    //   477	495	616	java/lang/Throwable
    //   503	510	616	java/lang/Throwable
    //   518	536	616	java/lang/Throwable
    //   544	551	616	java/lang/Throwable
    //   559	577	616	java/lang/Throwable
    //   585	595	616	java/lang/Throwable
    //   603	613	616	java/lang/Throwable
    //   148	155	620	java/lang/Throwable
    //   832	842	937	finally
    //   851	871	937	finally
    //   894	913	937	finally
    //   920	931	937	finally
    //   1013	1028	937	finally
    //   832	842	948	java/lang/Exception
    //   851	871	948	java/lang/Exception
    //   894	913	948	java/lang/Exception
    //   920	931	948	java/lang/Exception
    //   1013	1028	948	java/lang/Exception
    //   1460	1490	1495	finally
    //   1490	1492	1495	finally
    //   1497	1499	1495	finally
    //   1614	1624	1627	finally
    //   1629	1632	1627	finally
    //   1605	1614	1635	java/lang/InterruptedException
    //   1632	1635	1635	java/lang/InterruptedException
    //   1105	1141	1773	finally
    //   1141	1165	1773	finally
    //   1169	1181	1773	finally
    //   1184	1194	1773	finally
    //   1194	1202	1773	finally
    //   1215	1255	1773	finally
    //   1316	1331	1773	finally
    //   1348	1394	1773	finally
    //   1404	1419	1773	finally
    //   1419	1426	1773	finally
    //   1444	1460	1773	finally
    //   1499	1502	1773	finally
    //   1502	1530	1773	finally
    //   1540	1565	1773	finally
    //   1572	1587	1773	finally
    //   1594	1600	1773	finally
    //   1605	1614	1773	finally
    //   1632	1635	1773	finally
    //   1637	1642	1773	finally
    //   1658	1699	1773	finally
    //   1709	1716	1773	finally
    //   1194	1202	1788	java/lang/Exception
    //   1215	1255	1788	java/lang/Exception
    //   1316	1331	1788	java/lang/Exception
    //   1348	1394	1788	java/lang/Exception
    //   1404	1419	1788	java/lang/Exception
    //   1419	1426	1788	java/lang/Exception
    //   1444	1460	1788	java/lang/Exception
    //   1499	1502	1788	java/lang/Exception
    //   1502	1530	1788	java/lang/Exception
    //   1540	1565	1788	java/lang/Exception
    //   1572	1587	1788	java/lang/Exception
    //   1594	1600	1788	java/lang/Exception
    //   1605	1614	1788	java/lang/Exception
    //   1632	1635	1788	java/lang/Exception
    //   1637	1642	1788	java/lang/Exception
    //   1658	1699	1788	java/lang/Exception
    //   1709	1716	1788	java/lang/Exception
    //   163	169	1803	finally
    //   177	186	1803	finally
    //   194	202	1803	finally
    //   210	229	1803	finally
    //   237	245	1803	finally
    //   253	272	1803	finally
    //   280	288	1803	finally
    //   296	315	1803	finally
    //   323	334	1803	finally
    //   342	354	1803	finally
    //   366	377	1803	finally
    //   385	403	1803	finally
    //   419	423	1803	finally
    //   431	437	1803	finally
    //   445	453	1803	finally
    //   461	469	1803	finally
    //   477	495	1803	finally
    //   503	510	1803	finally
    //   518	536	1803	finally
    //   544	551	1803	finally
    //   559	577	1803	finally
    //   585	595	1803	finally
    //   603	613	1803	finally
    //   632	636	1803	finally
    //   652	661	1803	finally
    //   708	713	1803	finally
    //   721	728	1803	finally
    //   736	743	1803	finally
    //   751	760	1803	finally
    //   772	777	1803	finally
    //   791	800	1803	finally
    //   1828	1832	1803	finally
    //   1840	1850	1803	finally
    //   163	169	1811	java/lang/Exception
    //   177	186	1811	java/lang/Exception
    //   194	202	1811	java/lang/Exception
    //   210	229	1811	java/lang/Exception
    //   237	245	1811	java/lang/Exception
    //   253	272	1811	java/lang/Exception
    //   280	288	1811	java/lang/Exception
    //   296	315	1811	java/lang/Exception
    //   323	334	1811	java/lang/Exception
    //   342	354	1811	java/lang/Exception
    //   366	377	1811	java/lang/Exception
    //   385	403	1811	java/lang/Exception
    //   419	423	1811	java/lang/Exception
    //   431	437	1811	java/lang/Exception
    //   445	453	1811	java/lang/Exception
    //   461	469	1811	java/lang/Exception
    //   477	495	1811	java/lang/Exception
    //   503	510	1811	java/lang/Exception
    //   518	536	1811	java/lang/Exception
    //   544	551	1811	java/lang/Exception
    //   559	577	1811	java/lang/Exception
    //   585	595	1811	java/lang/Exception
    //   603	613	1811	java/lang/Exception
    //   632	636	1811	java/lang/Exception
    //   652	661	1811	java/lang/Exception
    //   708	713	1811	java/lang/Exception
    //   721	728	1811	java/lang/Exception
    //   736	743	1811	java/lang/Exception
    //   751	760	1811	java/lang/Exception
    //   772	777	1811	java/lang/Exception
    //   791	800	1811	java/lang/Exception
    //   1828	1832	1811	java/lang/Exception
    //   1840	1850	1811	java/lang/Exception
    //   708	713	1819	java/lang/Throwable
    //   22	28	1889	finally
    //   37	100	1889	finally
    //   111	117	1889	finally
    //   117	133	1889	finally
    //   140	148	1889	finally
    //   148	155	1889	finally
    //   22	28	1899	java/lang/Exception
    //   37	100	1899	java/lang/Exception
    //   111	117	1899	java/lang/Exception
    //   117	133	1899	java/lang/Exception
    //   140	148	1899	java/lang/Exception
    //   148	155	1899	java/lang/Exception
    //   1906	1918	1969	finally
    //   666	676	2079	java/lang/Exception
    //   679	684	2079	java/lang/Exception
    //   1059	1069	2083	java/lang/Exception
    //   1072	1077	2083	java/lang/Exception
    //   1081	1089	2083	java/lang/Exception
    //   1105	1141	2087	java/lang/Exception
    //   1141	1165	2087	java/lang/Exception
    //   1169	1181	2087	java/lang/Exception
    //   1184	1194	2087	java/lang/Exception
    //   1045	1054	2092	java/lang/Exception
    //   1260	1270	2097	java/lang/Exception
    //   1273	1278	2097	java/lang/Exception
    //   1283	1293	2097	java/lang/Exception
    //   967	979	2101	finally
    //   999	1006	2101	finally
    //   1045	1054	2101	finally
    //   967	979	2106	java/lang/Exception
    //   999	1006	2106	java/lang/Exception
    //   1724	1734	2142	java/lang/Exception
    //   1737	1742	2142	java/lang/Exception
    //   1747	1757	2142	java/lang/Exception
    //   1855	1865	2147	java/lang/Exception
    //   1868	1873	2147	java/lang/Exception
    //   1922	1930	2151	java/lang/Exception
    //   1933	1938	2151	java/lang/Exception
    //   1943	1953	2151	java/lang/Exception
    //   1986	1996	2155	java/lang/Exception
    //   1999	2004	2155	java/lang/Exception
    //   2009	2019	2155	java/lang/Exception
  }
  
  /* Error */
  private byte[] d()
  {
    // Byte code:
    //   0: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 391	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   15: getfield 394	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:a	Ljava/lang/String;
    //   18: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 399	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:j	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:j	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 40	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:e	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   48: aload_0
    //   49: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   52: aload_0
    //   53: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   59: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   65: irem
    //   66: istore_2
    //   67: iload_2
    //   68: ifeq +27 -> 95
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   76: aload_0
    //   77: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   80: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   83: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   86: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   89: iload_2
    //   90: isub
    //   91: iadd
    //   92: putfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   95: aload_0
    //   96: getfield 42	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:f	F
    //   99: fstore_1
    //   100: fload_1
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +14 -> 117
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:j	I
    //   111: putfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   114: goto +62 -> 176
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 50	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:j	I
    //   122: i2f
    //   123: fload_1
    //   124: fmul
    //   125: f2i
    //   126: putfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   129: aload_0
    //   130: getfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   133: aload_0
    //   134: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   137: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   140: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   143: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   146: irem
    //   147: istore_2
    //   148: iload_2
    //   149: ifeq +27 -> 176
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   157: aload_0
    //   158: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   161: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   164: getfield 105	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:b	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   167: getfield 108	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   170: iload_2
    //   171: isub
    //   172: iadd
    //   173: putfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   176: new 226	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   183: astore 6
    //   185: aload 6
    //   187: ldc_w 401
    //   190: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: aload_0
    //   197: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   200: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 403
    //   209: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 6
    //   215: aload_0
    //   216: getfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   219: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 67
    //   225: iconst_4
    //   226: aload 6
    //   228: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: getfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   238: aload_0
    //   239: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   242: isub
    //   243: newarray byte
    //   245: astore 6
    //   247: goto +37 -> 284
    //   250: ldc 67
    //   252: iconst_4
    //   253: ldc_w 405
    //   256: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: getstatic 410	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   262: ifnull +9 -> 271
    //   265: getstatic 410	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   268: invokevirtual 415	android/support/v4/util/MQLruCache:evictAll	()V
    //   271: aload_0
    //   272: getfield 46	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:h	I
    //   275: aload_0
    //   276: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   279: isub
    //   280: newarray byte
    //   282: astore 6
    //   284: new 417	java/io/FileInputStream
    //   287: dup
    //   288: aload 5
    //   290: invokespecial 420	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   293: astore 7
    //   295: aload 7
    //   297: astore 5
    //   299: aload_0
    //   300: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   303: ifeq +18 -> 321
    //   306: aload 7
    //   308: astore 5
    //   310: aload 7
    //   312: aload_0
    //   313: getfield 44	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:g	I
    //   316: i2l
    //   317: invokevirtual 424	java/io/FileInputStream:skip	(J)J
    //   320: pop2
    //   321: aload 7
    //   323: astore 5
    //   325: aload 7
    //   327: aload 6
    //   329: invokevirtual 428	java/io/FileInputStream:read	([B)I
    //   332: pop
    //   333: aload 7
    //   335: invokevirtual 431	java/io/FileInputStream:close	()V
    //   338: goto +10 -> 348
    //   341: astore 5
    //   343: aload 5
    //   345: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   348: new 226	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   355: astore 5
    //   357: aload 5
    //   359: ldc_w 434
    //   362: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 5
    //   368: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   371: lload_3
    //   372: lsub
    //   373: invokevirtual 376	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 67
    //   379: iconst_4
    //   380: aload 5
    //   382: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: aload 6
    //   390: areturn
    //   391: astore 8
    //   393: aload 7
    //   395: astore 6
    //   397: goto +16 -> 413
    //   400: astore 5
    //   402: aconst_null
    //   403: astore 6
    //   405: goto +60 -> 465
    //   408: astore 8
    //   410: aconst_null
    //   411: astore 6
    //   413: aload 6
    //   415: astore 5
    //   417: ldc 67
    //   419: iconst_4
    //   420: ldc 157
    //   422: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload 6
    //   427: astore 5
    //   429: aload 8
    //   431: invokevirtual 160	java/lang/Throwable:printStackTrace	()V
    //   434: aload 6
    //   436: ifnull +17 -> 453
    //   439: aload 6
    //   441: invokevirtual 431	java/io/FileInputStream:close	()V
    //   444: aconst_null
    //   445: areturn
    //   446: astore 5
    //   448: aload 5
    //   450: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   453: aconst_null
    //   454: areturn
    //   455: astore 7
    //   457: aload 5
    //   459: astore 6
    //   461: aload 7
    //   463: astore 5
    //   465: aload 6
    //   467: ifnull +18 -> 485
    //   470: aload 6
    //   472: invokevirtual 431	java/io/FileInputStream:close	()V
    //   475: goto +10 -> 485
    //   478: astore 6
    //   480: aload 6
    //   482: invokevirtual 432	java/io/IOException:printStackTrace	()V
    //   485: aload 5
    //   487: athrow
    //   488: astore 6
    //   490: goto -240 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	AudioPlayRunnable
    //   99	25	1	f1	float
    //   66	106	2	i1	int
    //   3	369	3	l1	long
    //   21	303	5	localObject1	Object
    //   341	3	5	localIOException1	java.io.IOException
    //   355	26	5	localStringBuilder	StringBuilder
    //   400	1	5	localObject2	Object
    //   415	13	5	localObject3	Object
    //   446	12	5	localIOException2	java.io.IOException
    //   463	23	5	localObject4	Object
    //   183	288	6	localObject5	Object
    //   478	3	6	localIOException3	java.io.IOException
    //   488	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   293	101	7	localFileInputStream	java.io.FileInputStream
    //   455	7	7	localObject6	Object
    //   391	1	8	localThrowable1	Throwable
    //   408	22	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   333	338	341	java/io/IOException
    //   299	306	391	java/lang/Throwable
    //   310	321	391	java/lang/Throwable
    //   325	333	391	java/lang/Throwable
    //   284	295	400	finally
    //   284	295	408	java/lang/Throwable
    //   439	444	446	java/io/IOException
    //   299	306	455	finally
    //   310	321	455	finally
    //   325	333	455	finally
    //   417	425	455	finally
    //   429	434	455	finally
    //   470	475	478	java/io/IOException
    //   234	247	488	java/lang/OutOfMemoryError
  }
  
  private AudioTrack e()
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.this$0.a.b.g != 1) {
          break label162;
        }
        i1 = 4;
        if (this.this$0.a.b.d != 16) {
          break label168;
        }
        i2 = 2;
        int i3 = AudioTrack.getMinBufferSize(this.this$0.a.b.f, i1, i2);
        AudioTrack localAudioTrack = new AudioTrack(3, this.this$0.a.b.f, i1, i2, i3, 1);
        try
        {
          localAudioTrack.setStereoVolume(this.this$0.a.b.h, this.this$0.a.b.h);
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
      label162:
      int i1 = 12;
      continue;
      label168:
      int i2 = 3;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder;
    //   4: getfield 100	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder:a	Lcom/tencent/mobileqq/videocodec/audio/AudioDecodeConfig;
    //   7: getfield 112	com/tencent/mobileqq/videocodec/audio/AudioDecodeConfig:d	I
    //   10: iconst_3
    //   11: if_icmpeq +49 -> 60
    //   14: ldc2_w 449
    //   17: invokestatic 456	java/lang/Thread:sleep	(J)V
    //   20: goto +8 -> 28
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 152	java/lang/InterruptedException:printStackTrace	()V
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 56	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:m	Z
    //   35: aload_0
    //   36: invokevirtual 459	java/lang/Object:notifyAll	()V
    //   39: goto +12 -> 51
    //   42: astore_1
    //   43: goto +13 -> 56
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 460	java/lang/Exception:printStackTrace	()V
    //   51: aload_0
    //   52: monitorexit
    //   53: goto +7 -> 60
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 36	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:c	I
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 38	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
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
      float f1 = (float)paramLong1 / (float)paramLong2;
      if ((f1 >= this.e) && (f1 <= this.f))
      {
        if (this.this$0.a.d == 5) {
          this.n = (this.f - (f1 - this.e));
        } else {
          this.n = f1;
        }
        QLog.d("AudioDecoder", 1, new Object[] { "seekToPercent: ", Float.valueOf(this.n) });
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek error, timePercent=");
      localStringBuilder.append(f1);
      QLog.w("AudioDecoder", 1, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.k = true;
  }
  
  public void c()
  {
    this.k = false;
    synchronized (this.l)
    {
      this.l.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    boolean bool2 = this.b;
    boolean bool1 = true;
    if ((bool2) && (!TextUtils.isEmpty(this.this$0.a.i))) {}
    try
    {
      localObject = FileUtils.fileToBytes(new File(this.this$0.a.i));
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
    if (MimeHelper.validateVideoType(MimeTypesTools.getMimeType(BaseApplication.getContext(), this.this$0.a.a)))
    {
      localObject = this.this$0.a.a;
      if (this.this$0.a.d == 5) {
        bool1 = false;
      }
      localObject = a((String)localObject, bool1);
    }
    else
    {
      localObject = d();
    }
    label132:
    if (localObject != null) {
      a((byte[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder.AudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */