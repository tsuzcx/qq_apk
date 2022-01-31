import android.media.AudioTrack;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;

public class aovv
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d;
  
  public aovv(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  /* Error */
  private AudioTrack a()
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   6: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   9: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   12: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   15: iconst_1
    //   16: if_icmpne +79 -> 95
    //   19: iconst_4
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   25: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   28: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   31: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   34: bipush 16
    //   36: if_icmpne +5 -> 41
    //   39: iconst_2
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   45: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   48: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   51: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   54: iload_1
    //   55: iload_2
    //   56: invokestatic 58	android/media/AudioTrack:getMinBufferSize	(III)I
    //   59: istore_3
    //   60: new 54	android/media/AudioTrack
    //   63: dup
    //   64: iconst_3
    //   65: aload_0
    //   66: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   69: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   72: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   75: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   78: iload_1
    //   79: iload_2
    //   80: iload_3
    //   81: iconst_1
    //   82: invokespecial 61	android/media/AudioTrack:<init>	(IIIIII)V
    //   85: astore 4
    //   87: aload 4
    //   89: invokevirtual 64	android/media/AudioTrack:play	()V
    //   92: aload 4
    //   94: areturn
    //   95: bipush 12
    //   97: istore_1
    //   98: goto -77 -> 21
    //   101: astore 5
    //   103: aconst_null
    //   104: astore 4
    //   106: ldc 66
    //   108: iconst_4
    //   109: ldc 68
    //   111: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 5
    //   116: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   119: aload 4
    //   121: areturn
    //   122: astore 5
    //   124: goto -18 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	aovv
    //   20	78	1	i	int
    //   1	79	2	j	int
    //   59	22	3	k	int
    //   85	35	4	localAudioTrack	AudioTrack
    //   101	14	5	localThrowable1	Throwable
    //   122	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	19	101	java/lang/Throwable
    //   21	39	101	java/lang/Throwable
    //   41	87	101	java/lang/Throwable
    //   87	92	122	java/lang/Throwable
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    QLog.d("AudioDecoder", 4, "begin playAudio");
    Object localObject2 = null;
    Object localObject1 = null;
    AudioTrack localAudioTrack;
    int i;
    try
    {
      localAudioTrack = a();
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      k = AudioTrack.getMinBufferSize(localAudioTrack.getSampleRate(), localAudioTrack.getChannelConfiguration(), localAudioTrack.getAudioFormat());
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      arrayOfByte = new byte[k * 2];
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      this.jdField_a_of_type_Boolean = false;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        int k;
        byte[] arrayOfByte;
        int m;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        int j = AudioDataUtil.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = AudioDataUtil.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2, 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = AudioDataUtil.b(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = AudioDataUtil.a(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2, 4);
        i = 0;
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        j = AudioDataUtil.c(paramArrayOfByte, this.jdField_a_of_type_Int, arrayOfByte, k * 2);
        i = 0;
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label842;
      }
      localObject2.release();
    }
    localObject1 = localAudioTrack;
    localObject2 = localAudioTrack;
    if (this.jdField_a_of_type_Int < paramArrayOfByte.length)
    {
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_c_of_type_Float != 0.0F)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = (int)(this.jdField_c_of_type_Float * this.d / this.jdField_b_of_type_Float);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          m = j % this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_b_of_type_Int;
          i = j;
          if (m != 0)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            i = j + (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_b_of_type_Int - m);
          }
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          this.jdField_a_of_type_Int = (i - this.jdField_b_of_type_Int);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localAudioTrack.flush();
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          this.jdField_c_of_type_Float = 0.0F;
        }
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        switch (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_Int)
        {
        case 1: 
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = Math.min(paramArrayOfByte.length - this.jdField_a_of_type_Int, k * 2);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_b_of_type_Boolean)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            localAudioTrack.write(paramArrayOfByte, this.jdField_a_of_type_Int, j);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if ((!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_b_of_type_Boolean) && (i == 0))
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        localAudioTrack.write(arrayOfByte, 0, k * 2);
      }
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      this.jdField_a_of_type_Int += j;
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if (this.jdField_a_of_type_Int >= paramArrayOfByte.length)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_Boolean)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_Int != 3)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
          }
        }
      }
      label842:
      do
      {
        boolean bool;
        Object localObject3;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        localAudioTrack.stop();
      } while (localAudioTrack == null);
      localAudioTrack.release();
      return;
      break;
      i = 1;
    }
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 160	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   15: getfield 163	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 169	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 102	aovv:d	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 102	aovv:d	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 27	aovv:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 103	aovv:jdField_b_of_type_Int	I
    //   48: aload_0
    //   49: getfield 103	aovv:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   59: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 103	aovv:jdField_b_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   84: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   87: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 103	aovv:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: getfield 29	aovv:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 102	aovv:d	I
    //   111: putfield 171	aovv:jdField_c_of_type_Int	I
    //   114: ldc 66
    //   116: iconst_4
    //   117: new 173	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   124: ldc 176
    //   126: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 103	aovv:jdField_b_of_type_Int	I
    //   133: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 185
    //   138: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 171	aovv:jdField_c_of_type_Int	I
    //   145: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 171	aovv:jdField_c_of_type_Int	I
    //   158: aload_0
    //   159: getfield 103	aovv:jdField_b_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 6
    //   167: new 191	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 7
    //   178: aload 7
    //   180: ifnull +41 -> 221
    //   183: aload 7
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 103	aovv:jdField_b_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 7
    //   196: astore 5
    //   198: aload 7
    //   200: aload_0
    //   201: getfield 103	aovv:jdField_b_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 198	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 7
    //   211: astore 5
    //   213: aload 7
    //   215: aload 6
    //   217: invokevirtual 202	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 7
    //   223: ifnull +8 -> 231
    //   226: aload 7
    //   228: invokevirtual 205	java/io/FileInputStream:close	()V
    //   231: ldc 66
    //   233: iconst_4
    //   234: new 173	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   241: ldc 207
    //   243: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 6
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 102	aovv:d	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 29	aovv:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 171	aovv:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 171	aovv:jdField_c_of_type_Int	I
    //   282: aload_0
    //   283: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   289: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   292: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 171	aovv:jdField_c_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   314: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   317: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 171	aovv:jdField_c_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 6
    //   332: ldc 66
    //   334: iconst_4
    //   335: ldc 212
    //   337: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: getstatic 218	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   343: ifnull +9 -> 352
    //   346: getstatic 218	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   349: invokevirtual 223	android/support/v4/util/MQLruCache:evictAll	()V
    //   352: aload_0
    //   353: getfield 171	aovv:jdField_c_of_type_Int	I
    //   356: aload_0
    //   357: getfield 103	aovv:jdField_b_of_type_Int	I
    //   360: isub
    //   361: newarray byte
    //   363: astore 6
    //   365: goto -198 -> 167
    //   368: astore 5
    //   370: aload 5
    //   372: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   375: goto -144 -> 231
    //   378: astore 8
    //   380: aconst_null
    //   381: astore 6
    //   383: aload 6
    //   385: astore 5
    //   387: ldc 66
    //   389: iconst_4
    //   390: ldc 129
    //   392: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 6
    //   397: astore 5
    //   399: aload 8
    //   401: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   404: aload 6
    //   406: ifnull +8 -> 414
    //   409: aload 6
    //   411: invokevirtual 205	java/io/FileInputStream:close	()V
    //   414: aconst_null
    //   415: areturn
    //   416: astore 5
    //   418: aload 5
    //   420: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   423: goto -9 -> 414
    //   426: astore 6
    //   428: aconst_null
    //   429: astore 5
    //   431: aload 5
    //   433: ifnull +8 -> 441
    //   436: aload 5
    //   438: invokevirtual 205	java/io/FileInputStream:close	()V
    //   441: aload 6
    //   443: athrow
    //   444: astore 5
    //   446: aload 5
    //   448: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   451: goto -10 -> 441
    //   454: astore 6
    //   456: goto -25 -> 431
    //   459: astore 8
    //   461: aload 7
    //   463: astore 6
    //   465: goto -82 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	aovv
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   368	3	5	localIOException1	java.io.IOException
    //   385	13	5	localObject2	Object
    //   416	3	5	localIOException2	java.io.IOException
    //   429	8	5	localObject3	Object
    //   444	3	5	localIOException3	java.io.IOException
    //   165	96	6	arrayOfByte1	byte[]
    //   330	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   363	47	6	arrayOfByte2	byte[]
    //   426	16	6	localObject4	Object
    //   454	1	6	localObject5	Object
    //   463	1	6	localObject6	Object
    //   176	286	7	localFileInputStream	java.io.FileInputStream
    //   378	22	8	localThrowable1	Throwable
    //   459	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   154	167	330	java/lang/OutOfMemoryError
    //   226	231	368	java/io/IOException
    //   167	178	378	java/lang/Throwable
    //   409	414	416	java/io/IOException
    //   167	178	426	finally
    //   436	441	444	java/io/IOException
    //   187	194	454	finally
    //   198	209	454	finally
    //   213	221	454	finally
    //   387	395	454	finally
    //   399	404	454	finally
    //   187	194	459	java/lang/Throwable
    //   198	209	459	java/lang/Throwable
    //   213	221	459	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 66
    //   2: iconst_4
    //   3: ldc 229
    //   5: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   11: lstore 14
    //   13: aconst_null
    //   14: astore 24
    //   16: aconst_null
    //   17: astore 19
    //   19: aconst_null
    //   20: astore 25
    //   22: new 231	android/media/MediaExtractor
    //   25: dup
    //   26: invokespecial 232	android/media/MediaExtractor:<init>	()V
    //   29: astore 26
    //   31: aconst_null
    //   32: astore 23
    //   34: aconst_null
    //   35: astore 22
    //   37: aconst_null
    //   38: astore 21
    //   40: aload 24
    //   42: astore 18
    //   44: aload 23
    //   46: astore 20
    //   48: aload 19
    //   50: astore 17
    //   52: aload 26
    //   54: aload_1
    //   55: invokevirtual 235	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   58: lconst_0
    //   59: lstore 10
    //   61: lconst_0
    //   62: lstore 8
    //   64: iconst_0
    //   65: istore_3
    //   66: aload 24
    //   68: astore 18
    //   70: aload 23
    //   72: astore 20
    //   74: aload 19
    //   76: astore 17
    //   78: iload_3
    //   79: aload 26
    //   81: invokevirtual 238	android/media/MediaExtractor:getTrackCount	()I
    //   84: if_icmpge +1636 -> 1720
    //   87: aload 24
    //   89: astore 18
    //   91: aload 23
    //   93: astore 20
    //   95: aload 19
    //   97: astore 17
    //   99: aload 26
    //   101: iload_3
    //   102: invokevirtual 242	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   105: astore 27
    //   107: aload 24
    //   109: astore 18
    //   111: aload 23
    //   113: astore 20
    //   115: aload 19
    //   117: astore 17
    //   119: aload 27
    //   121: ldc 244
    //   123: invokevirtual 250	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 28
    //   128: aload 24
    //   130: astore 18
    //   132: aload 23
    //   134: astore 20
    //   136: aload 19
    //   138: astore 17
    //   140: aload_0
    //   141: aload 27
    //   143: ldc 252
    //   145: invokevirtual 256	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   148: putfield 258	aovv:jdField_a_of_type_Long	J
    //   151: aload 24
    //   153: astore 18
    //   155: aload 23
    //   157: astore 20
    //   159: aload 19
    //   161: astore 17
    //   163: aload_0
    //   164: getfield 27	aovv:jdField_a_of_type_Float	F
    //   167: aload_0
    //   168: getfield 258	aovv:jdField_a_of_type_Long	J
    //   171: l2f
    //   172: fmul
    //   173: f2l
    //   174: lstore 10
    //   176: aload 24
    //   178: astore 18
    //   180: aload 23
    //   182: astore 20
    //   184: aload 19
    //   186: astore 17
    //   188: aload_0
    //   189: getfield 29	aovv:jdField_b_of_type_Float	F
    //   192: aload_0
    //   193: getfield 258	aovv:jdField_a_of_type_Long	J
    //   196: l2f
    //   197: fmul
    //   198: f2l
    //   199: lstore 12
    //   201: lload 12
    //   203: lstore 8
    //   205: lload 12
    //   207: lconst_0
    //   208: lcmp
    //   209: ifne +21 -> 230
    //   212: aload 24
    //   214: astore 18
    //   216: aload 23
    //   218: astore 20
    //   220: aload 19
    //   222: astore 17
    //   224: aload_0
    //   225: getfield 258	aovv:jdField_a_of_type_Long	J
    //   228: lstore 8
    //   230: aload 24
    //   232: astore 18
    //   234: aload 23
    //   236: astore 20
    //   238: aload 19
    //   240: astore 17
    //   242: aload 28
    //   244: ldc_w 260
    //   247: invokevirtual 266	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   250: ifeq +500 -> 750
    //   253: aload 24
    //   255: astore 18
    //   257: aload 23
    //   259: astore 20
    //   261: aload 19
    //   263: astore 17
    //   265: aload 26
    //   267: iload_3
    //   268: invokevirtual 270	android/media/MediaExtractor:selectTrack	(I)V
    //   271: lload 10
    //   273: lconst_0
    //   274: lcmp
    //   275: ifle +23 -> 298
    //   278: aload 24
    //   280: astore 18
    //   282: aload 23
    //   284: astore 20
    //   286: aload 19
    //   288: astore 17
    //   290: aload 26
    //   292: lload 10
    //   294: iconst_0
    //   295: invokevirtual 274	android/media/MediaExtractor:seekTo	(JI)V
    //   298: aload 25
    //   300: astore_1
    //   301: aload 24
    //   303: astore 18
    //   305: aload 23
    //   307: astore 20
    //   309: aload 19
    //   311: astore 17
    //   313: aload 28
    //   315: invokestatic 280	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   318: astore 19
    //   320: aload 19
    //   322: astore_1
    //   323: aload 19
    //   325: astore 18
    //   327: aload 23
    //   329: astore 20
    //   331: aload 19
    //   333: astore 17
    //   335: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +100 -> 438
    //   341: aload 19
    //   343: astore_1
    //   344: aload 19
    //   346: astore 18
    //   348: aload 23
    //   350: astore 20
    //   352: aload 19
    //   354: astore 17
    //   356: ldc 66
    //   358: iconst_4
    //   359: new 173	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 286
    //   369: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   376: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   379: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   382: getfield 287	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   385: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: ldc_w 289
    //   391: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   398: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   401: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   404: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   407: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc_w 291
    //   413: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   420: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   423: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   426: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   429: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 19
    //   440: astore 18
    //   442: aload 23
    //   444: astore 20
    //   446: aload 19
    //   448: astore 17
    //   450: aload_0
    //   451: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   454: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   457: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   460: aload 27
    //   462: ldc_w 293
    //   465: invokevirtual 297	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   468: putfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   471: aload 19
    //   473: astore 18
    //   475: aload 23
    //   477: astore 20
    //   479: aload 19
    //   481: astore 17
    //   483: aload_0
    //   484: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   487: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   490: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   493: aload 27
    //   495: ldc_w 299
    //   498: invokevirtual 297	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   501: putfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   504: aload 19
    //   506: astore_1
    //   507: aload 19
    //   509: astore 18
    //   511: aload 23
    //   513: astore 20
    //   515: aload 19
    //   517: astore 17
    //   519: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +100 -> 622
    //   525: aload 19
    //   527: astore_1
    //   528: aload 19
    //   530: astore 18
    //   532: aload 23
    //   534: astore 20
    //   536: aload 19
    //   538: astore 17
    //   540: ldc 66
    //   542: iconst_4
    //   543: new 173	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 301
    //   553: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   560: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   563: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   566: getfield 287	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   569: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc_w 289
    //   575: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_0
    //   579: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   582: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   585: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   588: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   591: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc_w 291
    //   597: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   604: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   607: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   610: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   613: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   616: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: aload 19
    //   624: astore_1
    //   625: aload 19
    //   627: astore 18
    //   629: aload 23
    //   631: astore 20
    //   633: aload 19
    //   635: astore 17
    //   637: aload 19
    //   639: aload 27
    //   641: aconst_null
    //   642: aconst_null
    //   643: iconst_0
    //   644: invokevirtual 305	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   647: aload 19
    //   649: astore_1
    //   650: aload_1
    //   651: ifnonnull +106 -> 757
    //   654: ldc 66
    //   656: iconst_2
    //   657: ldc_w 307
    //   660: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: aconst_null
    //   664: astore 17
    //   666: aload_1
    //   667: ifnull +11 -> 678
    //   670: aload_1
    //   671: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   674: aload_1
    //   675: invokevirtual 309	android/media/MediaCodec:release	()V
    //   678: aload 26
    //   680: ifnull +8 -> 688
    //   683: aload 26
    //   685: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   688: aload 17
    //   690: astore_1
    //   691: iconst_0
    //   692: ifeq +11 -> 703
    //   695: new 312	java/lang/NullPointerException
    //   698: dup
    //   699: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   702: athrow
    //   703: aload_1
    //   704: areturn
    //   705: astore 24
    //   707: aload 19
    //   709: astore_1
    //   710: aload 19
    //   712: astore 18
    //   714: aload 23
    //   716: astore 20
    //   718: aload 19
    //   720: astore 17
    //   722: aload 24
    //   724: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   727: goto -223 -> 504
    //   730: astore 19
    //   732: aload_1
    //   733: astore 18
    //   735: aload 23
    //   737: astore 20
    //   739: aload_1
    //   740: astore 17
    //   742: aload 19
    //   744: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   747: goto -97 -> 650
    //   750: iload_3
    //   751: iconst_1
    //   752: iadd
    //   753: istore_3
    //   754: goto -688 -> 66
    //   757: aload_1
    //   758: invokevirtual 316	android/media/MediaCodec:start	()V
    //   761: aload_1
    //   762: invokevirtual 320	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   765: astore 23
    //   767: aload_1
    //   768: invokevirtual 323	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   771: astore 17
    //   773: new 325	android/media/MediaCodec$BufferInfo
    //   776: dup
    //   777: invokespecial 326	android/media/MediaCodec$BufferInfo:<init>	()V
    //   780: astore 20
    //   782: iconst_0
    //   783: istore_3
    //   784: iconst_0
    //   785: istore 5
    //   787: iload_2
    //   788: ifeq +287 -> 1075
    //   791: aload_0
    //   792: invokespecial 85	aovv:a	()Landroid/media/AudioTrack;
    //   795: astore 18
    //   797: aconst_null
    //   798: astore 19
    //   800: iconst_0
    //   801: istore 4
    //   803: iload 4
    //   805: ifne +643 -> 1448
    //   808: iload 5
    //   810: ifne +923 -> 1733
    //   813: aload_1
    //   814: ldc2_w 327
    //   817: invokevirtual 332	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   820: istore 7
    //   822: iload 7
    //   824: iflt +909 -> 1733
    //   827: aload 26
    //   829: aload 23
    //   831: iload 7
    //   833: aaload
    //   834: iconst_0
    //   835: invokevirtual 336	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   838: istore 6
    //   840: aload 26
    //   842: invokevirtual 339	android/media/MediaExtractor:getSampleTime	()J
    //   845: lstore 12
    //   847: iload 6
    //   849: iflt +18 -> 867
    //   852: lload 8
    //   854: lconst_0
    //   855: lcmp
    //   856: ifle +234 -> 1090
    //   859: lload 12
    //   861: lload 8
    //   863: lcmp
    //   864: iflt +226 -> 1090
    //   867: aload_1
    //   868: iload 7
    //   870: iconst_0
    //   871: iconst_0
    //   872: lconst_0
    //   873: iconst_4
    //   874: invokevirtual 343	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   877: iconst_1
    //   878: istore 5
    //   880: iload_3
    //   881: ifne +836 -> 1717
    //   884: aload_1
    //   885: aload 20
    //   887: ldc2_w 327
    //   890: invokevirtual 347	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   893: istore 6
    //   895: iload 6
    //   897: tableswitch	default:+828 -> 1725, -3:+214->1111, -2:+238->1135, -1:+276->1173
    //   925: ldc2_w -19455
    //   928: dup2_x2
    //   929: iconst_4
    //   930: iand
    //   931: ifeq +260 -> 1191
    //   934: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   937: ifeq +791 -> 1728
    //   940: ldc 66
    //   942: iconst_2
    //   943: ldc_w 352
    //   946: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   949: goto +779 -> 1728
    //   952: aload_1
    //   953: iload 6
    //   955: iconst_0
    //   956: invokevirtual 356	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   959: aload_0
    //   960: getfield 126	aovv:jdField_b_of_type_Boolean	Z
    //   963: istore 16
    //   965: iload 16
    //   967: ifeq +747 -> 1714
    //   970: aload_0
    //   971: getfield 25	aovv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   974: astore 22
    //   976: aload 22
    //   978: monitorenter
    //   979: aload_0
    //   980: getfield 25	aovv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   983: invokevirtual 125	java/lang/Object:wait	()V
    //   986: aload 22
    //   988: monitorexit
    //   989: iload_3
    //   990: ifeq +721 -> 1711
    //   993: iload_2
    //   994: ifeq +454 -> 1448
    //   997: aload_1
    //   998: invokevirtual 357	android/media/MediaCodec:flush	()V
    //   1001: aload 26
    //   1003: lload 10
    //   1005: iconst_0
    //   1006: invokevirtual 274	android/media/MediaExtractor:seekTo	(JI)V
    //   1009: iconst_0
    //   1010: istore 5
    //   1012: iconst_0
    //   1013: istore_3
    //   1014: goto -211 -> 803
    //   1017: astore 17
    //   1019: aload 17
    //   1021: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   1024: ldc 66
    //   1026: iconst_2
    //   1027: ldc_w 359
    //   1030: aload 17
    //   1032: invokestatic 362	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1035: aconst_null
    //   1036: astore 17
    //   1038: aload_1
    //   1039: ifnull +11 -> 1050
    //   1042: aload_1
    //   1043: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1046: aload_1
    //   1047: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1050: aload 26
    //   1052: ifnull +8 -> 1060
    //   1055: aload 26
    //   1057: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1060: aload 17
    //   1062: astore_1
    //   1063: iconst_0
    //   1064: ifeq -361 -> 703
    //   1067: new 312	java/lang/NullPointerException
    //   1070: dup
    //   1071: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   1074: athrow
    //   1075: new 364	java/io/ByteArrayOutputStream
    //   1078: dup
    //   1079: invokespecial 365	java/io/ByteArrayOutputStream:<init>	()V
    //   1082: astore 19
    //   1084: aconst_null
    //   1085: astore 18
    //   1087: goto -287 -> 800
    //   1090: aload_1
    //   1091: iload 7
    //   1093: iconst_0
    //   1094: iload 6
    //   1096: lload 12
    //   1098: iconst_0
    //   1099: invokevirtual 343	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1102: aload 26
    //   1104: invokevirtual 368	android/media/MediaExtractor:advance	()Z
    //   1107: pop
    //   1108: goto +625 -> 1733
    //   1111: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1114: ifeq +12 -> 1126
    //   1117: ldc 66
    //   1119: iconst_2
    //   1120: ldc_w 370
    //   1123: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1126: aload_1
    //   1127: invokevirtual 323	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1130: astore 17
    //   1132: goto -173 -> 959
    //   1135: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1138: ifeq +579 -> 1717
    //   1141: ldc 66
    //   1143: iconst_2
    //   1144: new 173	java/lang/StringBuilder
    //   1147: dup
    //   1148: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1151: ldc_w 372
    //   1154: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: aload_1
    //   1158: invokevirtual 376	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1161: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1170: goto -211 -> 959
    //   1173: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1176: ifeq +541 -> 1717
    //   1179: ldc 66
    //   1181: iconst_2
    //   1182: ldc_w 381
    //   1185: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: goto -229 -> 959
    //   1191: aload 17
    //   1193: iload 6
    //   1195: aaload
    //   1196: astore 22
    //   1198: aload 22
    //   1200: ifnonnull +57 -> 1257
    //   1203: ldc 66
    //   1205: iconst_1
    //   1206: ldc_w 383
    //   1209: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1212: aconst_null
    //   1213: astore 17
    //   1215: aload_1
    //   1216: ifnull +11 -> 1227
    //   1219: aload_1
    //   1220: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1223: aload_1
    //   1224: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1227: aload 26
    //   1229: ifnull +8 -> 1237
    //   1232: aload 26
    //   1234: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1237: aload 17
    //   1239: astore_1
    //   1240: aload 18
    //   1242: ifnull -539 -> 703
    //   1245: aload 18
    //   1247: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   1250: aload 18
    //   1252: invokevirtual 132	android/media/AudioTrack:release	()V
    //   1255: aconst_null
    //   1256: areturn
    //   1257: aload 20
    //   1259: getfield 386	android/media/MediaCodec$BufferInfo:size	I
    //   1262: ifeq +31 -> 1293
    //   1265: aload 22
    //   1267: aload 20
    //   1269: getfield 389	android/media/MediaCodec$BufferInfo:offset	I
    //   1272: invokevirtual 395	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1275: pop
    //   1276: aload 22
    //   1278: aload 20
    //   1280: getfield 389	android/media/MediaCodec$BufferInfo:offset	I
    //   1283: aload 20
    //   1285: getfield 386	android/media/MediaCodec$BufferInfo:size	I
    //   1288: iadd
    //   1289: invokevirtual 398	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1292: pop
    //   1293: aload 22
    //   1295: invokevirtual 401	java/nio/ByteBuffer:remaining	()I
    //   1298: istore 7
    //   1300: iload 7
    //   1302: newarray byte
    //   1304: astore 21
    //   1306: aload 22
    //   1308: aload 21
    //   1310: iconst_0
    //   1311: iload 7
    //   1313: invokevirtual 405	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1316: pop
    //   1317: iload_2
    //   1318: ifeq +19 -> 1337
    //   1321: aload_0
    //   1322: getfield 20	aovv:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   1325: aload 18
    //   1327: aload 21
    //   1329: iload 7
    //   1331: invokestatic 408	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
    //   1334: goto +402 -> 1736
    //   1337: aload 19
    //   1339: aload 21
    //   1341: iconst_0
    //   1342: iload 7
    //   1344: invokevirtual 411	java/io/ByteArrayOutputStream:write	([BII)V
    //   1347: goto +389 -> 1736
    //   1350: astore 17
    //   1352: ldc 66
    //   1354: iconst_1
    //   1355: new 173	java/lang/StringBuilder
    //   1358: dup
    //   1359: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1362: ldc_w 413
    //   1365: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: aload 17
    //   1370: invokevirtual 414	java/lang/Exception:toString	()Ljava/lang/String;
    //   1373: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: aconst_null
    //   1383: astore 17
    //   1385: aload_1
    //   1386: ifnull +11 -> 1397
    //   1389: aload_1
    //   1390: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1393: aload_1
    //   1394: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1397: aload 26
    //   1399: ifnull +8 -> 1407
    //   1402: aload 26
    //   1404: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1407: aload 17
    //   1409: astore_1
    //   1410: aload 18
    //   1412: ifnull -709 -> 703
    //   1415: aload 18
    //   1417: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   1420: aload 18
    //   1422: invokevirtual 132	android/media/AudioTrack:release	()V
    //   1425: aconst_null
    //   1426: areturn
    //   1427: astore 21
    //   1429: aload 22
    //   1431: monitorexit
    //   1432: aload 21
    //   1434: athrow
    //   1435: astore 21
    //   1437: aload 21
    //   1439: invokevirtual 127	java/lang/InterruptedException:printStackTrace	()V
    //   1442: iconst_1
    //   1443: istore 4
    //   1445: goto -456 -> 989
    //   1448: ldc 66
    //   1450: iconst_1
    //   1451: new 173	java/lang/StringBuilder
    //   1454: dup
    //   1455: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1458: ldc_w 416
    //   1461: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   1467: lload 14
    //   1469: lsub
    //   1470: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1479: aload 19
    //   1481: ifnonnull +49 -> 1530
    //   1484: aconst_null
    //   1485: astore 17
    //   1487: aload_1
    //   1488: ifnull +11 -> 1499
    //   1491: aload_1
    //   1492: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1495: aload_1
    //   1496: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1499: aload 26
    //   1501: ifnull +8 -> 1509
    //   1504: aload 26
    //   1506: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1509: aload 17
    //   1511: astore_1
    //   1512: aload 18
    //   1514: ifnull -811 -> 703
    //   1517: aload 18
    //   1519: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   1522: aload 18
    //   1524: invokevirtual 132	android/media/AudioTrack:release	()V
    //   1527: aload 17
    //   1529: areturn
    //   1530: aload 19
    //   1532: invokevirtual 419	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1535: astore 17
    //   1537: goto -50 -> 1487
    //   1540: astore_1
    //   1541: aload 21
    //   1543: astore 19
    //   1545: aload 19
    //   1547: astore 20
    //   1549: aload 18
    //   1551: astore 17
    //   1553: ldc 66
    //   1555: iconst_1
    //   1556: aload_1
    //   1557: iconst_0
    //   1558: anewarray 4	java/lang/Object
    //   1561: invokestatic 422	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1564: aconst_null
    //   1565: astore_1
    //   1566: aload 18
    //   1568: ifnull +13 -> 1581
    //   1571: aload 18
    //   1573: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1576: aload 18
    //   1578: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1581: aload 26
    //   1583: ifnull +8 -> 1591
    //   1586: aload 26
    //   1588: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1591: aload 19
    //   1593: ifnull -890 -> 703
    //   1596: aload 19
    //   1598: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   1601: aload 19
    //   1603: invokevirtual 132	android/media/AudioTrack:release	()V
    //   1606: aconst_null
    //   1607: areturn
    //   1608: astore_1
    //   1609: aload 17
    //   1611: ifnull +13 -> 1624
    //   1614: aload 17
    //   1616: invokevirtual 308	android/media/MediaCodec:stop	()V
    //   1619: aload 17
    //   1621: invokevirtual 309	android/media/MediaCodec:release	()V
    //   1624: aload 26
    //   1626: ifnull +8 -> 1634
    //   1629: aload 26
    //   1631: invokevirtual 310	android/media/MediaExtractor:release	()V
    //   1634: aload 20
    //   1636: ifnull +13 -> 1649
    //   1639: aload 20
    //   1641: invokevirtual 147	android/media/AudioTrack:stop	()V
    //   1644: aload 20
    //   1646: invokevirtual 132	android/media/AudioTrack:release	()V
    //   1649: aload_1
    //   1650: athrow
    //   1651: astore 18
    //   1653: aload_1
    //   1654: astore 17
    //   1656: aload 18
    //   1658: astore_1
    //   1659: aload 22
    //   1661: astore 20
    //   1663: goto -54 -> 1609
    //   1666: astore 19
    //   1668: aload_1
    //   1669: astore 17
    //   1671: aload 19
    //   1673: astore_1
    //   1674: aload 18
    //   1676: astore 20
    //   1678: goto -69 -> 1609
    //   1681: astore 17
    //   1683: aload_1
    //   1684: astore 18
    //   1686: aload 17
    //   1688: astore_1
    //   1689: aload 21
    //   1691: astore 19
    //   1693: goto -148 -> 1545
    //   1696: astore 17
    //   1698: aload 18
    //   1700: astore 19
    //   1702: aload_1
    //   1703: astore 18
    //   1705: aload 17
    //   1707: astore_1
    //   1708: goto -163 -> 1545
    //   1711: goto -908 -> 803
    //   1714: goto -725 -> 989
    //   1717: goto -758 -> 959
    //   1720: aconst_null
    //   1721: astore_1
    //   1722: goto -1072 -> 650
    //   1725: goto -801 -> 924
    //   1728: iconst_1
    //   1729: istore_3
    //   1730: goto -778 -> 952
    //   1733: goto -853 -> 880
    //   1736: goto -784 -> 952
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1739	0	this	aovv
    //   0	1739	1	paramString	String
    //   0	1739	2	paramBoolean	boolean
    //   65	1665	3	i	int
    //   801	643	4	j	int
    //   785	226	5	k	int
    //   838	356	6	m	int
    //   820	523	7	n	int
    //   62	800	8	l1	long
    //   59	945	10	l2	long
    //   199	898	12	l3	long
    //   11	1457	14	l4	long
    //   963	3	16	bool	boolean
    //   50	722	17	localObject1	Object
    //   1017	14	17	localThrowable1	Throwable
    //   1036	202	17	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1350	19	17	localException1	Exception
    //   1383	287	17	localObject2	Object
    //   1681	6	17	localException2	Exception
    //   1696	10	17	localException3	Exception
    //   42	1535	18	localObject3	Object
    //   1651	24	18	localObject4	Object
    //   1684	20	18	str1	String
    //   17	702	19	localMediaCodec	android.media.MediaCodec
    //   730	13	19	localThrowable2	Throwable
    //   798	804	19	localObject5	Object
    //   1666	6	19	localObject6	Object
    //   1691	10	19	localObject7	Object
    //   46	1631	20	localObject8	Object
    //   38	1302	21	arrayOfByte	byte[]
    //   1427	6	21	localObject9	Object
    //   1435	255	21	localInterruptedException	InterruptedException
    //   32	798	23	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   14	288	24	localObject11	Object
    //   705	18	24	localThrowable3	Throwable
    //   20	279	25	localObject12	Object
    //   29	1601	26	localMediaExtractor	android.media.MediaExtractor
    //   105	535	27	localMediaFormat	android.media.MediaFormat
    //   126	188	28	str2	String
    // Exception table:
    //   from	to	target	type
    //   450	471	705	java/lang/Throwable
    //   483	504	705	java/lang/Throwable
    //   313	320	730	java/lang/Throwable
    //   335	341	730	java/lang/Throwable
    //   356	438	730	java/lang/Throwable
    //   519	525	730	java/lang/Throwable
    //   540	622	730	java/lang/Throwable
    //   637	647	730	java/lang/Throwable
    //   722	727	730	java/lang/Throwable
    //   757	761	1017	java/lang/Throwable
    //   1203	1212	1350	java/lang/Exception
    //   1257	1293	1350	java/lang/Exception
    //   1293	1317	1350	java/lang/Exception
    //   1321	1334	1350	java/lang/Exception
    //   1337	1347	1350	java/lang/Exception
    //   979	989	1427	finally
    //   1429	1432	1427	finally
    //   970	979	1435	java/lang/InterruptedException
    //   1432	1435	1435	java/lang/InterruptedException
    //   52	58	1540	java/lang/Exception
    //   78	87	1540	java/lang/Exception
    //   99	107	1540	java/lang/Exception
    //   119	128	1540	java/lang/Exception
    //   140	151	1540	java/lang/Exception
    //   163	176	1540	java/lang/Exception
    //   188	201	1540	java/lang/Exception
    //   224	230	1540	java/lang/Exception
    //   242	253	1540	java/lang/Exception
    //   265	271	1540	java/lang/Exception
    //   290	298	1540	java/lang/Exception
    //   313	320	1540	java/lang/Exception
    //   335	341	1540	java/lang/Exception
    //   356	438	1540	java/lang/Exception
    //   450	471	1540	java/lang/Exception
    //   483	504	1540	java/lang/Exception
    //   519	525	1540	java/lang/Exception
    //   540	622	1540	java/lang/Exception
    //   637	647	1540	java/lang/Exception
    //   722	727	1540	java/lang/Exception
    //   742	747	1540	java/lang/Exception
    //   52	58	1608	finally
    //   78	87	1608	finally
    //   99	107	1608	finally
    //   119	128	1608	finally
    //   140	151	1608	finally
    //   163	176	1608	finally
    //   188	201	1608	finally
    //   224	230	1608	finally
    //   242	253	1608	finally
    //   265	271	1608	finally
    //   290	298	1608	finally
    //   313	320	1608	finally
    //   335	341	1608	finally
    //   356	438	1608	finally
    //   450	471	1608	finally
    //   483	504	1608	finally
    //   519	525	1608	finally
    //   540	622	1608	finally
    //   637	647	1608	finally
    //   722	727	1608	finally
    //   742	747	1608	finally
    //   1553	1564	1608	finally
    //   654	663	1651	finally
    //   757	761	1651	finally
    //   761	782	1651	finally
    //   791	797	1651	finally
    //   1019	1035	1651	finally
    //   1075	1084	1651	finally
    //   813	822	1666	finally
    //   827	847	1666	finally
    //   867	877	1666	finally
    //   884	895	1666	finally
    //   924	949	1666	finally
    //   952	959	1666	finally
    //   959	965	1666	finally
    //   970	979	1666	finally
    //   997	1009	1666	finally
    //   1090	1108	1666	finally
    //   1111	1126	1666	finally
    //   1126	1132	1666	finally
    //   1135	1170	1666	finally
    //   1173	1188	1666	finally
    //   1203	1212	1666	finally
    //   1257	1293	1666	finally
    //   1293	1317	1666	finally
    //   1321	1334	1666	finally
    //   1337	1347	1666	finally
    //   1352	1382	1666	finally
    //   1432	1435	1666	finally
    //   1437	1442	1666	finally
    //   1448	1479	1666	finally
    //   1530	1537	1666	finally
    //   654	663	1681	java/lang/Exception
    //   757	761	1681	java/lang/Exception
    //   761	782	1681	java/lang/Exception
    //   791	797	1681	java/lang/Exception
    //   1019	1035	1681	java/lang/Exception
    //   1075	1084	1681	java/lang/Exception
    //   813	822	1696	java/lang/Exception
    //   827	847	1696	java/lang/Exception
    //   867	877	1696	java/lang/Exception
    //   884	895	1696	java/lang/Exception
    //   924	949	1696	java/lang/Exception
    //   952	959	1696	java/lang/Exception
    //   959	965	1696	java/lang/Exception
    //   970	979	1696	java/lang/Exception
    //   997	1009	1696	java/lang/Exception
    //   1090	1108	1696	java/lang/Exception
    //   1111	1126	1696	java/lang/Exception
    //   1126	1132	1696	java/lang/Exception
    //   1135	1170	1696	java/lang/Exception
    //   1173	1188	1696	java/lang/Exception
    //   1352	1382	1696	java/lang/Exception
    //   1432	1435	1696	java/lang/Exception
    //   1437	1442	1696	java/lang/Exception
    //   1448	1479	1696	java/lang/Exception
    //   1530	1537	1696	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_Int != 3) {}
    try
    {
      Thread.sleep(500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.jdField_c_of_type_Boolean = true;
          notifyAll();
          this.jdField_a_of_type_Int = 0;
          return;
          localInterruptedException = localInterruptedException;
          localInterruptedException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      finally {}
    }
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
    boolean bool;
    if (MimeHelper.b(MimeTypesTools.a(BaseApplication.getContext(), this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_Int != 5) {
        bool = true;
      }
    }
    for (Object localObject = a((String)localObject, bool);; localObject = a())
    {
      if (localObject != null) {
        a((byte[])localObject);
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aovv
 * JD-Core Version:    0.7.0.1
 */