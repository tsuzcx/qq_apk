import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class anxa
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  
  public anxa(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: iconst_4
    //   3: istore_2
    //   4: ldc 37
    //   6: iconst_4
    //   7: ldc 39
    //   9: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aconst_null
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   19: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   22: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   25: getfield 59	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   28: iconst_1
    //   29: if_icmpne +432 -> 461
    //   32: aload_0
    //   33: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   36: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   39: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   42: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   45: bipush 16
    //   47: if_icmpne +420 -> 467
    //   50: aload_0
    //   51: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   54: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   57: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   60: getfield 63	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   63: iload_2
    //   64: iload_3
    //   65: invokestatic 69	android/media/AudioTrack:getMinBufferSize	(III)I
    //   68: istore 4
    //   70: iload 4
    //   72: iconst_2
    //   73: imul
    //   74: newarray byte
    //   76: astore 9
    //   78: new 65	android/media/AudioTrack
    //   81: dup
    //   82: iconst_3
    //   83: aload_0
    //   84: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   87: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   90: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   93: getfield 63	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   96: iload_2
    //   97: iload_3
    //   98: iload 4
    //   100: iconst_1
    //   101: invokespecial 72	android/media/AudioTrack:<init>	(IIIIII)V
    //   104: astore 7
    //   106: aload 7
    //   108: invokevirtual 75	android/media/AudioTrack:play	()V
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 77	anxa:jdField_a_of_type_Boolean	Z
    //   116: aload_0
    //   117: getfield 79	anxa:jdField_a_of_type_Int	I
    //   120: aload_1
    //   121: arraylength
    //   122: if_icmpge +452 -> 574
    //   125: aload_0
    //   126: getfield 77	anxa:jdField_a_of_type_Boolean	Z
    //   129: ifne +445 -> 574
    //   132: aload_0
    //   133: getfield 81	anxa:jdField_c_of_type_Float	F
    //   136: fconst_0
    //   137: fcmpl
    //   138: ifeq +83 -> 221
    //   141: aload_0
    //   142: getfield 81	anxa:jdField_c_of_type_Float	F
    //   145: aload_0
    //   146: getfield 82	anxa:d	I
    //   149: i2f
    //   150: fmul
    //   151: aload_0
    //   152: getfield 29	anxa:jdField_b_of_type_Float	F
    //   155: fdiv
    //   156: f2i
    //   157: istore_3
    //   158: iload_3
    //   159: aload_0
    //   160: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   163: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   166: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   169: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   172: irem
    //   173: istore 5
    //   175: iload_3
    //   176: istore_2
    //   177: iload 5
    //   179: ifeq +22 -> 201
    //   182: iload_3
    //   183: aload_0
    //   184: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   187: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   190: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   193: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   196: iload 5
    //   198: isub
    //   199: iadd
    //   200: istore_2
    //   201: aload_0
    //   202: iload_2
    //   203: aload_0
    //   204: getfield 83	anxa:jdField_b_of_type_Int	I
    //   207: isub
    //   208: putfield 79	anxa:jdField_a_of_type_Int	I
    //   211: aload 7
    //   213: invokevirtual 86	android/media/AudioTrack:flush	()V
    //   216: aload_0
    //   217: fconst_0
    //   218: putfield 81	anxa:jdField_c_of_type_Float	F
    //   221: aload_0
    //   222: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   225: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   228: getfield 87	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_Int	I
    //   231: tableswitch	default:+398 -> 629, 1:+241->472, 2:+261->492, 3:+282->513, 4:+302->533, 5:+323->554
    //   265: arraylength
    //   266: aload_0
    //   267: getfield 79	anxa:jdField_a_of_type_Int	I
    //   270: isub
    //   271: iload 4
    //   273: iconst_2
    //   274: imul
    //   275: invokestatic 93	java/lang/Math:min	(II)I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   283: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   286: getfield 95	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_b_of_type_Boolean	Z
    //   289: ifne +343 -> 632
    //   292: aload 7
    //   294: aload_1
    //   295: aload_0
    //   296: getfield 79	anxa:jdField_a_of_type_Int	I
    //   299: iload_3
    //   300: invokevirtual 99	android/media/AudioTrack:write	([BII)I
    //   303: pop
    //   304: goto +328 -> 632
    //   307: aload_0
    //   308: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   314: getfield 95	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_b_of_type_Boolean	Z
    //   317: ifne +20 -> 337
    //   320: iload_2
    //   321: ifne +16 -> 337
    //   324: aload 7
    //   326: aload 9
    //   328: iconst_0
    //   329: iload 4
    //   331: iconst_2
    //   332: imul
    //   333: invokevirtual 99	android/media/AudioTrack:write	([BII)I
    //   336: pop
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 79	anxa:jdField_a_of_type_Int	I
    //   342: iload_3
    //   343: iadd
    //   344: putfield 79	anxa:jdField_a_of_type_Int	I
    //   347: aload_0
    //   348: getfield 79	anxa:jdField_a_of_type_Int	I
    //   351: aload_1
    //   352: arraylength
    //   353: if_icmplt +21 -> 374
    //   356: aload_0
    //   357: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   360: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   363: getfield 100	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_Boolean	Z
    //   366: ifeq +8 -> 374
    //   369: aload_0
    //   370: iconst_0
    //   371: putfield 79	anxa:jdField_a_of_type_Int	I
    //   374: aload_0
    //   375: getfield 101	anxa:jdField_b_of_type_Boolean	Z
    //   378: istore 6
    //   380: iload 6
    //   382: ifeq -266 -> 116
    //   385: aload_0
    //   386: getfield 25	anxa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   389: astore 8
    //   391: aload 8
    //   393: monitorenter
    //   394: aload_0
    //   395: getfield 25	anxa:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   398: invokevirtual 104	java/lang/Object:wait	()V
    //   401: aload 8
    //   403: monitorexit
    //   404: goto -288 -> 116
    //   407: astore 10
    //   409: aload 8
    //   411: monitorexit
    //   412: aload 10
    //   414: athrow
    //   415: astore 8
    //   417: aload 8
    //   419: invokevirtual 107	java/lang/InterruptedException:printStackTrace	()V
    //   422: aload_0
    //   423: iconst_1
    //   424: putfield 77	anxa:jdField_a_of_type_Boolean	Z
    //   427: goto -311 -> 116
    //   430: astore 8
    //   432: aload 7
    //   434: astore_1
    //   435: aload 8
    //   437: astore 7
    //   439: ldc 37
    //   441: iconst_4
    //   442: ldc 109
    //   444: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload 7
    //   449: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   452: aload_1
    //   453: ifnull +7 -> 460
    //   456: aload_1
    //   457: invokevirtual 115	android/media/AudioTrack:release	()V
    //   460: return
    //   461: bipush 12
    //   463: istore_2
    //   464: goto -432 -> 32
    //   467: iconst_3
    //   468: istore_3
    //   469: goto -419 -> 50
    //   472: aload_1
    //   473: aload_0
    //   474: getfield 79	anxa:jdField_a_of_type_Int	I
    //   477: aload 9
    //   479: iload 4
    //   481: iconst_2
    //   482: imul
    //   483: invokestatic 120	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	([BI[BI)I
    //   486: istore_3
    //   487: iconst_0
    //   488: istore_2
    //   489: goto -182 -> 307
    //   492: aload_1
    //   493: aload_0
    //   494: getfield 79	anxa:jdField_a_of_type_Int	I
    //   497: aload 9
    //   499: iload 4
    //   501: iconst_2
    //   502: imul
    //   503: iconst_2
    //   504: invokestatic 123	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	([BI[BII)I
    //   507: istore_3
    //   508: iconst_0
    //   509: istore_2
    //   510: goto -203 -> 307
    //   513: aload_1
    //   514: aload_0
    //   515: getfield 79	anxa:jdField_a_of_type_Int	I
    //   518: aload 9
    //   520: iload 4
    //   522: iconst_2
    //   523: imul
    //   524: invokestatic 125	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:b	([BI[BI)I
    //   527: istore_3
    //   528: iconst_0
    //   529: istore_2
    //   530: goto -223 -> 307
    //   533: aload_1
    //   534: aload_0
    //   535: getfield 79	anxa:jdField_a_of_type_Int	I
    //   538: aload 9
    //   540: iload 4
    //   542: iconst_2
    //   543: imul
    //   544: iconst_4
    //   545: invokestatic 123	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	([BI[BII)I
    //   548: istore_3
    //   549: iconst_0
    //   550: istore_2
    //   551: goto -244 -> 307
    //   554: aload_1
    //   555: aload_0
    //   556: getfield 79	anxa:jdField_a_of_type_Int	I
    //   559: aload 9
    //   561: iload 4
    //   563: iconst_2
    //   564: imul
    //   565: invokestatic 127	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:c	([BI[BI)I
    //   568: istore_3
    //   569: iconst_0
    //   570: istore_2
    //   571: goto -264 -> 307
    //   574: aload 7
    //   576: invokevirtual 130	android/media/AudioTrack:stop	()V
    //   579: aload 7
    //   581: ifnull -121 -> 460
    //   584: aload 7
    //   586: invokevirtual 115	android/media/AudioTrack:release	()V
    //   589: return
    //   590: astore_1
    //   591: aload 8
    //   593: astore 7
    //   595: aload 7
    //   597: ifnull +8 -> 605
    //   600: aload 7
    //   602: invokevirtual 115	android/media/AudioTrack:release	()V
    //   605: aload_1
    //   606: athrow
    //   607: astore_1
    //   608: goto -13 -> 595
    //   611: astore 8
    //   613: aload_1
    //   614: astore 7
    //   616: aload 8
    //   618: astore_1
    //   619: goto -24 -> 595
    //   622: astore 7
    //   624: aconst_null
    //   625: astore_1
    //   626: goto -187 -> 439
    //   629: goto -365 -> 264
    //   632: iconst_1
    //   633: istore_2
    //   634: goto -327 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	anxa
    //   0	637	1	paramArrayOfByte	byte[]
    //   3	631	2	i	int
    //   1	568	3	j	int
    //   68	497	4	k	int
    //   173	26	5	m	int
    //   378	3	6	bool	boolean
    //   104	511	7	localObject1	Object
    //   622	1	7	localThrowable1	Throwable
    //   13	397	8	localObject2	Object
    //   415	3	8	localInterruptedException	java.lang.InterruptedException
    //   430	162	8	localThrowable2	Throwable
    //   611	6	8	localObject3	Object
    //   76	484	9	arrayOfByte	byte[]
    //   407	6	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   394	404	407	finally
    //   409	412	407	finally
    //   385	394	415	java/lang/InterruptedException
    //   412	415	415	java/lang/InterruptedException
    //   106	116	430	java/lang/Throwable
    //   116	175	430	java/lang/Throwable
    //   182	201	430	java/lang/Throwable
    //   201	221	430	java/lang/Throwable
    //   221	264	430	java/lang/Throwable
    //   264	304	430	java/lang/Throwable
    //   307	320	430	java/lang/Throwable
    //   324	337	430	java/lang/Throwable
    //   337	374	430	java/lang/Throwable
    //   374	380	430	java/lang/Throwable
    //   385	394	430	java/lang/Throwable
    //   412	415	430	java/lang/Throwable
    //   417	427	430	java/lang/Throwable
    //   472	487	430	java/lang/Throwable
    //   492	508	430	java/lang/Throwable
    //   513	528	430	java/lang/Throwable
    //   533	549	430	java/lang/Throwable
    //   554	569	430	java/lang/Throwable
    //   574	579	430	java/lang/Throwable
    //   15	32	590	finally
    //   32	50	590	finally
    //   50	106	590	finally
    //   106	116	607	finally
    //   116	175	607	finally
    //   182	201	607	finally
    //   201	221	607	finally
    //   221	264	607	finally
    //   264	304	607	finally
    //   307	320	607	finally
    //   324	337	607	finally
    //   337	374	607	finally
    //   374	380	607	finally
    //   385	394	607	finally
    //   412	415	607	finally
    //   417	427	607	finally
    //   472	487	607	finally
    //   492	508	607	finally
    //   513	528	607	finally
    //   533	549	607	finally
    //   554	569	607	finally
    //   574	579	607	finally
    //   439	452	611	finally
    //   15	32	622	java/lang/Throwable
    //   32	50	622	java/lang/Throwable
    //   50	106	622	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 141	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   15: getfield 144	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 150	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 82	anxa:d	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 82	anxa:d	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 27	anxa:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 83	anxa:jdField_b_of_type_Int	I
    //   48: aload_0
    //   49: getfield 83	anxa:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   59: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 83	anxa:jdField_b_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   84: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   87: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 83	anxa:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: getfield 29	anxa:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 82	anxa:d	I
    //   111: putfield 152	anxa:jdField_c_of_type_Int	I
    //   114: ldc 37
    //   116: iconst_4
    //   117: new 154	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   124: ldc 157
    //   126: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 83	anxa:jdField_b_of_type_Int	I
    //   133: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 166
    //   138: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 152	anxa:jdField_c_of_type_Int	I
    //   145: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 152	anxa:jdField_c_of_type_Int	I
    //   158: aload_0
    //   159: getfield 83	anxa:jdField_b_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 7
    //   167: new 172	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull +41 -> 221
    //   183: aload 6
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 83	anxa:jdField_b_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: aload_0
    //   201: getfield 83	anxa:jdField_b_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 179	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: aload 7
    //   217: invokevirtual 183	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 186	java/io/FileInputStream:close	()V
    //   231: ldc 37
    //   233: iconst_4
    //   234: new 154	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   241: ldc 188
    //   243: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 7
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 82	anxa:d	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 29	anxa:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 152	anxa:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 152	anxa:jdField_c_of_type_Int	I
    //   282: aload_0
    //   283: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   289: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   292: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 152	anxa:jdField_c_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 20	anxa:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: getfield 49	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   314: getfield 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   317: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 152	anxa:jdField_c_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   337: goto -106 -> 231
    //   340: astore 7
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 6
    //   347: astore 5
    //   349: ldc 37
    //   351: iconst_4
    //   352: ldc 109
    //   354: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 6
    //   359: astore 5
    //   361: aload 7
    //   363: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   366: aload 6
    //   368: ifnull +8 -> 376
    //   371: aload 6
    //   373: invokevirtual 186	java/io/FileInputStream:close	()V
    //   376: aconst_null
    //   377: areturn
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   385: goto -9 -> 376
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 186	java/io/FileInputStream:close	()V
    //   403: aload 6
    //   405: athrow
    //   406: astore 5
    //   408: aload 5
    //   410: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   413: goto -10 -> 403
    //   416: astore 6
    //   418: goto -25 -> 393
    //   421: astore 7
    //   423: goto -78 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	anxa
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   330	3	5	localIOException1	IOException
    //   347	13	5	localObject2	Object
    //   378	3	5	localIOException2	IOException
    //   391	8	5	localObject3	Object
    //   406	3	5	localIOException3	IOException
    //   176	196	6	localFileInputStream	java.io.FileInputStream
    //   388	16	6	localObject4	Object
    //   416	1	6	localObject5	Object
    //   165	96	7	arrayOfByte	byte[]
    //   340	22	7	localThrowable1	Throwable
    //   421	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   226	231	330	java/io/IOException
    //   167	178	340	java/lang/Throwable
    //   371	376	378	java/io/IOException
    //   167	178	388	finally
    //   398	403	406	java/io/IOException
    //   187	194	416	finally
    //   198	209	416	finally
    //   213	221	416	finally
    //   349	357	416	finally
    //   361	366	416	finally
    //   187	194	421	java/lang/Throwable
    //   198	209	421	java/lang/Throwable
    //   213	221	421	java/lang/Throwable
  }
  
  private byte[] a(String paramString)
  {
    QLog.d("AudioDecoder", 4, "getAudioDataFromMp4 begin");
    long l3 = System.currentTimeMillis();
    MediaCodec localMediaCodec = null;
    Object localObject1 = null;
    MediaExtractor localMediaExtractor = new MediaExtractor();
    int i;
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        paramString = localMediaCodec;
        String str;
        long l4;
        i += 1;
      }
      catch (IOException paramString)
      {
        try
        {
          localByteArrayOutputStream = new ByteArrayOutputStream();
          paramString = localMediaCodec;
          ByteBuffer.allocate(512);
          l1 = 0L;
          i = 0;
          paramString = localMediaCodec;
          if (i >= localMediaExtractor.getTrackCount()) {
            break label1187;
          }
          paramString = localMediaCodec;
          localObject3 = localMediaExtractor.getTrackFormat(i);
          paramString = localMediaCodec;
          str = ((MediaFormat)localObject3).getString("mime");
          paramString = localMediaCodec;
          this.jdField_a_of_type_Long = ((MediaFormat)localObject3).getLong("durationUs");
          paramString = localMediaCodec;
          l4 = (this.jdField_a_of_type_Float * (float)this.jdField_a_of_type_Long);
          paramString = localMediaCodec;
          l2 = (this.jdField_b_of_type_Float * (float)this.jdField_a_of_type_Long);
          l1 = l2;
          if (l2 == 0L)
          {
            paramString = localMediaCodec;
            l1 = this.jdField_a_of_type_Long;
          }
          paramString = localMediaCodec;
          if (str.startsWith("audio/"))
          {
            paramString = localMediaCodec;
            localMediaExtractor.selectTrack(i);
            if (l4 > 0L)
            {
              paramString = localMediaCodec;
              localMediaExtractor.seekTo(l4, 0);
            }
            paramString = localMediaCodec;
            for (;;)
            {
              try
              {
                localMediaCodec = MediaCodec.createDecoderByType(str);
                localObject1 = localMediaCodec;
                paramString = localMediaCodec;
                if (QLog.isColorLevel())
                {
                  localObject1 = localMediaCodec;
                  paramString = localMediaCodec;
                  QLog.d("AudioDecoder", 4, "config before b=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_c_of_type_Int + " c=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e + " sc=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d);
                }
                paramString = localMediaCodec;
              }
              catch (Throwable localThrowable1)
              {
                paramString = (String)localObject1;
                localThrowable1.printStackTrace();
                continue;
              }
              try
              {
                this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e = ((MediaFormat)localObject3).getInteger("channel-count");
                paramString = localMediaCodec;
                this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d = ((MediaFormat)localObject3).getInteger("sample-rate");
              }
              catch (Throwable localThrowable2)
              {
                localObject1 = localMediaCodec;
                paramString = localMediaCodec;
                localThrowable2.printStackTrace();
              }
            }
            localObject1 = localMediaCodec;
            paramString = localMediaCodec;
            if (QLog.isColorLevel())
            {
              localObject1 = localMediaCodec;
              paramString = localMediaCodec;
              QLog.d("AudioDecoder", 4, "config after b=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_c_of_type_Int + " c=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.e + " sc=" + this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.d);
            }
            localObject1 = localMediaCodec;
            paramString = localMediaCodec;
            localMediaCodec.configure((MediaFormat)localObject3, null, null, 0);
            localObject1 = localMediaCodec;
            if (localObject1 != null) {
              break;
            }
          }
        }
        finally
        {
          ByteArrayOutputStream localByteArrayOutputStream;
          long l1;
          Object localObject3;
          long l2;
          localObject1 = paramString;
          paramString = localObject2;
          if (localObject1 != null)
          {
            ((MediaCodec)localObject1).stop();
            ((MediaCodec)localObject1).release();
          }
          if (localMediaExtractor != null) {
            localMediaExtractor.release();
          }
        }
        try
        {
          QLog.e("AudioDecoder", 2, "Can't find video info!");
          if (localObject1 != null)
          {
            ((MediaCodec)localObject1).stop();
            ((MediaCodec)localObject1).release();
          }
          if (localMediaExtractor != null) {
            localMediaExtractor.release();
          }
          return null;
        }
        finally
        {
          break label1150;
          break label601;
          break label752;
        }
        paramString = paramString;
        paramString.printStackTrace();
        return null;
      }
    }
    label1184:
    label1187:
    label1196:
    label1201:
    for (;;)
    {
      label601:
      int k;
      int m;
      try
      {
        ((MediaCodec)localObject1).start();
        ByteBuffer[] arrayOfByteBuffer = ((MediaCodec)localObject1).getInputBuffers();
        paramString = ((MediaCodec)localObject1).getOutputBuffers();
        localObject3 = new MediaCodec.BufferInfo();
        i = 0;
        int j = 0;
        if (j != 0) {
          break label1201;
        }
        k = ((MediaCodec)localObject1).dequeueInputBuffer(10000L);
        if (k < 0) {
          break label1201;
        }
        m = localMediaExtractor.readSampleData(arrayOfByteBuffer[k], 0);
        l2 = localMediaExtractor.getSampleTime();
        if ((m >= 0) && ((l1 <= 0L) || (l2 < l1))) {
          break label862;
        }
        ((MediaCodec)localObject1).queueInputBuffer(k, 0, 0, 0L, 4);
        j = 1;
        if (i != 0) {
          break label1184;
        }
        k = ((MediaCodec)localObject1).dequeueOutputBuffer((MediaCodec.BufferInfo)localObject3, 10000L);
        switch (k)
        {
        case -3: 
          if ((((MediaCodec.BufferInfo)localObject3).flags & 0x4) == 0) {
            break label965;
          }
          if (!QLog.isColorLevel()) {
            break label1196;
          }
          QLog.d("AudioDecoder", 2, "output EOS");
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.e("AudioDecoder", 2, "decode start error", paramString);
        if (localObject1 == null) {
          continue;
        }
        ((MediaCodec)localObject1).stop();
        ((MediaCodec)localObject1).release();
        if (localMediaExtractor == null) {
          continue;
        }
        localMediaExtractor.release();
        return null;
      }
      ((MediaCodec)localObject1).releaseOutputBuffer(k, false);
      label752:
      if (i != 0)
      {
        QLog.d("AudioDecoder", 1, "getAudioDataFromMp4 time cost=" + (System.currentTimeMillis() - l3));
        paramString = localByteArrayOutputStream.toByteArray();
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).stop();
          ((MediaCodec)localObject1).release();
        }
        if (localMediaExtractor != null) {
          localMediaExtractor.release();
        }
        return paramString;
        ((MediaCodec)localObject1).queueInputBuffer(k, 0, m, l2, 0);
        localMediaExtractor.advance();
        break label1201;
        if (QLog.isColorLevel()) {
          QLog.d("AudioDecoder", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        paramString = ((MediaCodec)localObject1).getOutputBuffers();
        continue;
        if (!QLog.isColorLevel()) {
          break label1184;
        }
        QLog.d("AudioDecoder", 2, "New format " + ((MediaCodec)localObject1).getOutputFormat());
        continue;
        if (!QLog.isColorLevel()) {
          break label1184;
        }
        QLog.d("AudioDecoder", 2, "dequeueOutputBuffer timed out!");
        continue;
        Object localObject4 = paramString[k];
        if (localObject4 == null) {}
        try
        {
          QLog.e("AudioDecoder", 1, "find no data");
          if (localObject1 != null)
          {
            ((MediaCodec)localObject1).stop();
            ((MediaCodec)localObject1).release();
          }
          if (localMediaExtractor != null) {
            localMediaExtractor.release();
          }
          return null;
        }
        catch (Exception paramString)
        {
          byte[] arrayOfByte;
          QLog.e("AudioDecoder", 1, "" + paramString.toString());
          if (localObject1 == null) {
            break label1130;
          }
          ((MediaCodec)localObject1).stop();
          ((MediaCodec)localObject1).release();
          if (localMediaExtractor == null) {
            break label1140;
          }
          localMediaExtractor.release();
          return null;
        }
        if (((MediaCodec.BufferInfo)localObject3).size != 0)
        {
          localObject4.position(((MediaCodec.BufferInfo)localObject3).offset);
          localObject4.limit(((MediaCodec.BufferInfo)localObject3).offset + ((MediaCodec.BufferInfo)localObject3).size);
        }
        m = localObject4.remaining();
        arrayOfByte = new byte[m];
        localObject4.get(arrayOfByte, 0, m);
        localByteArrayOutputStream.write(arrayOfByte, 0, m);
        continue;
      }
      label862:
      label1130:
      label1140:
      label1150:
      localObject1 = null;
      label965:
      break;
      continue;
      i = 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float))
    {
      this.jdField_c_of_type_Float = f;
      return;
    }
    QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_JavaLangString.endsWith(".mp4")) {}
    for (byte[] arrayOfByte = a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_JavaLangString); arrayOfByte == null; arrayOfByte = a()) {
      return;
    }
    a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxa
 * JD-Core Version:    0.7.0.1
 */