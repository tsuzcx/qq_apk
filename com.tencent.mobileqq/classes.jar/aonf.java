import android.media.AudioTrack;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;

public class aonf
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
  
  public aonf(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
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
    //   3: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   6: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   9: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   12: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   15: iconst_1
    //   16: if_icmpne +79 -> 95
    //   19: iconst_4
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   25: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   28: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   31: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   34: bipush 16
    //   36: if_icmpne +5 -> 41
    //   39: iconst_2
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
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
    //   66: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
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
    //   0	127	0	this	aonf
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
    for (;;)
    {
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
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_a_of_type_Int >= paramArrayOfByte.length) {
          continue;
        }
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.jdField_c_of_type_Float != 0.0F)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = (int)(this.jdField_c_of_type_Float * this.d / this.jdField_b_of_type_Float);
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          int m = j % this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.jdField_b_of_type_Int;
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
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a.jdField_b_of_type_Boolean) {
            break label808;
          }
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localAudioTrack.write(paramArrayOfByte, this.jdField_a_of_type_Int, j);
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        AudioTrack localAudioTrack;
        int k;
        byte[] arrayOfByte;
        boolean bool;
        localObject2 = localObject1;
        QLog.e("AudioDecoder", 4, "AudioTrack Playback Failed");
        localObject2 = localObject1;
        paramArrayOfByte.printStackTrace();
        return;
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
        continue;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        localAudioTrack.stop();
        return;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        localObject2.release();
      }
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
          this.jdField_a_of_type_Int = 0;
        }
      }
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      bool = this.jdField_b_of_type_Boolean;
      if (bool)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        try
        {
          Object localObject3 = this.jdField_a_of_type_JavaLangObject;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            continue;
          }
          finally
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localInterruptedException.printStackTrace();
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          this.jdField_a_of_type_Boolean = true;
        }
        continue;
        label808:
        i = 1;
      }
    }
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 156	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   15: getfield 159	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 165	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 102	aonf:d	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 102	aonf:d	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 27	aonf:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 103	aonf:jdField_b_of_type_Int	I
    //   48: aload_0
    //   49: getfield 103	aonf:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   59: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 103	aonf:jdField_b_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   84: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   87: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 103	aonf:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: getfield 29	aonf:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 102	aonf:d	I
    //   111: putfield 167	aonf:jdField_c_of_type_Int	I
    //   114: ldc 66
    //   116: iconst_4
    //   117: new 169	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   124: ldc 172
    //   126: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 103	aonf:jdField_b_of_type_Int	I
    //   133: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 181
    //   138: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 167	aonf:jdField_c_of_type_Int	I
    //   145: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 167	aonf:jdField_c_of_type_Int	I
    //   158: aload_0
    //   159: getfield 103	aonf:jdField_b_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 7
    //   167: new 187	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull +41 -> 221
    //   183: aload 6
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 103	aonf:jdField_b_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: aload_0
    //   201: getfield 103	aonf:jdField_b_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 194	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: aload 7
    //   217: invokevirtual 198	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 201	java/io/FileInputStream:close	()V
    //   231: ldc 66
    //   233: iconst_4
    //   234: new 169	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   241: ldc 203
    //   243: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 7
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 102	aonf:d	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 29	aonf:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 167	aonf:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 167	aonf:jdField_c_of_type_Int	I
    //   282: aload_0
    //   283: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   289: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   292: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 167	aonf:jdField_c_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   314: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   317: getfield 50	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 167	aonf:jdField_c_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   337: goto -106 -> 231
    //   340: astore 7
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 6
    //   347: astore 5
    //   349: ldc 66
    //   351: iconst_4
    //   352: ldc 127
    //   354: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 6
    //   359: astore 5
    //   361: aload 7
    //   363: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   366: aload 6
    //   368: ifnull +8 -> 376
    //   371: aload 6
    //   373: invokevirtual 201	java/io/FileInputStream:close	()V
    //   376: aconst_null
    //   377: areturn
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   385: goto -9 -> 376
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 201	java/io/FileInputStream:close	()V
    //   403: aload 6
    //   405: athrow
    //   406: astore 5
    //   408: aload 5
    //   410: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   413: goto -10 -> 403
    //   416: astore 6
    //   418: goto -25 -> 393
    //   421: astore 7
    //   423: goto -78 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	aonf
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   330	3	5	localIOException1	java.io.IOException
    //   347	13	5	localObject2	Object
    //   378	3	5	localIOException2	java.io.IOException
    //   391	8	5	localObject3	Object
    //   406	3	5	localIOException3	java.io.IOException
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
  
  /* Error */
  private byte[] a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 66
    //   2: iconst_4
    //   3: ldc 212
    //   5: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   11: lstore 14
    //   13: aconst_null
    //   14: astore 18
    //   16: aconst_null
    //   17: astore 17
    //   19: new 214	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 215	android/media/MediaExtractor:<init>	()V
    //   26: astore 21
    //   28: aconst_null
    //   29: astore 19
    //   31: aload 21
    //   33: aload_1
    //   34: invokevirtual 218	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   37: lconst_0
    //   38: lstore 10
    //   40: lconst_0
    //   41: lstore 8
    //   43: iconst_0
    //   44: istore_3
    //   45: aload 18
    //   47: astore_1
    //   48: iload_3
    //   49: aload 21
    //   51: invokevirtual 221	android/media/MediaExtractor:getTrackCount	()I
    //   54: if_icmpge +1379 -> 1433
    //   57: aload 18
    //   59: astore_1
    //   60: aload 21
    //   62: iload_3
    //   63: invokevirtual 225	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   66: astore 20
    //   68: aload 18
    //   70: astore_1
    //   71: aload 20
    //   73: ldc 227
    //   75: invokevirtual 233	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 22
    //   80: aload 18
    //   82: astore_1
    //   83: aload_0
    //   84: aload 20
    //   86: ldc 235
    //   88: invokevirtual 239	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   91: putfield 241	aonf:jdField_a_of_type_Long	J
    //   94: aload 18
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 27	aonf:jdField_a_of_type_Float	F
    //   101: aload_0
    //   102: getfield 241	aonf:jdField_a_of_type_Long	J
    //   105: l2f
    //   106: fmul
    //   107: f2l
    //   108: lstore 10
    //   110: aload 18
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 29	aonf:jdField_b_of_type_Float	F
    //   117: aload_0
    //   118: getfield 241	aonf:jdField_a_of_type_Long	J
    //   121: l2f
    //   122: fmul
    //   123: f2l
    //   124: lstore 12
    //   126: lload 12
    //   128: lstore 8
    //   130: lload 12
    //   132: lconst_0
    //   133: lcmp
    //   134: ifne +12 -> 146
    //   137: aload 18
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 241	aonf:jdField_a_of_type_Long	J
    //   144: lstore 8
    //   146: aload 18
    //   148: astore_1
    //   149: aload 22
    //   151: ldc 243
    //   153: invokevirtual 249	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +405 -> 561
    //   159: aload 18
    //   161: astore_1
    //   162: aload 21
    //   164: iload_3
    //   165: invokevirtual 253	android/media/MediaExtractor:selectTrack	(I)V
    //   168: lload 10
    //   170: lconst_0
    //   171: lcmp
    //   172: ifle +14 -> 186
    //   175: aload 18
    //   177: astore_1
    //   178: aload 21
    //   180: lload 10
    //   182: iconst_0
    //   183: invokevirtual 257	android/media/MediaExtractor:seekTo	(JI)V
    //   186: aload 18
    //   188: astore_1
    //   189: aload 22
    //   191: invokestatic 263	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   194: astore 18
    //   196: aload 18
    //   198: astore 17
    //   200: aload 18
    //   202: astore_1
    //   203: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +92 -> 298
    //   209: aload 18
    //   211: astore 17
    //   213: aload 18
    //   215: astore_1
    //   216: ldc 66
    //   218: iconst_4
    //   219: new 169	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 269
    //   229: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   236: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   239: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   242: getfield 270	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   245: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 272
    //   251: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_0
    //   255: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   258: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   261: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   264: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   267: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc_w 274
    //   273: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   280: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   283: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   286: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   289: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload 18
    //   300: astore_1
    //   301: aload_0
    //   302: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   305: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   308: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   311: aload 20
    //   313: ldc_w 276
    //   316: invokevirtual 280	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   319: putfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   322: aload 18
    //   324: astore_1
    //   325: aload_0
    //   326: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   329: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   332: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   335: aload 20
    //   337: ldc_w 282
    //   340: invokevirtual 280	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   343: putfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   346: aload 18
    //   348: astore 17
    //   350: aload 18
    //   352: astore_1
    //   353: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +92 -> 448
    //   359: aload 18
    //   361: astore 17
    //   363: aload 18
    //   365: astore_1
    //   366: ldc 66
    //   368: iconst_4
    //   369: new 169	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 284
    //   379: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   386: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   389: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   392: getfield 270	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_c_of_type_Int	I
    //   395: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: ldc_w 272
    //   401: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   408: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   411: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   414: getfield 48	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   417: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc_w 274
    //   423: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_0
    //   427: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   430: getfield 38	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   433: getfield 43	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   436: getfield 52	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   439: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload 18
    //   450: astore 17
    //   452: aload 18
    //   454: astore_1
    //   455: aload 18
    //   457: aload 20
    //   459: aconst_null
    //   460: aconst_null
    //   461: iconst_0
    //   462: invokevirtual 288	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   465: aload 18
    //   467: astore 17
    //   469: aload 17
    //   471: ifnonnull +97 -> 568
    //   474: ldc 66
    //   476: iconst_2
    //   477: ldc_w 290
    //   480: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aconst_null
    //   484: astore_1
    //   485: aload 17
    //   487: ifnull +13 -> 500
    //   490: aload 17
    //   492: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   495: aload 17
    //   497: invokevirtual 292	android/media/MediaCodec:release	()V
    //   500: aload 21
    //   502: ifnull +8 -> 510
    //   505: aload 21
    //   507: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   510: iconst_0
    //   511: ifeq +11 -> 522
    //   514: new 295	java/lang/NullPointerException
    //   517: dup
    //   518: invokespecial 296	java/lang/NullPointerException:<init>	()V
    //   521: athrow
    //   522: aload_1
    //   523: areturn
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   529: aconst_null
    //   530: areturn
    //   531: astore 22
    //   533: aload 18
    //   535: astore 17
    //   537: aload 18
    //   539: astore_1
    //   540: aload 22
    //   542: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   545: goto -199 -> 346
    //   548: astore 18
    //   550: aload 17
    //   552: astore_1
    //   553: aload 18
    //   555: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   558: goto -89 -> 469
    //   561: iload_3
    //   562: iconst_1
    //   563: iadd
    //   564: istore_3
    //   565: goto -520 -> 45
    //   568: aload 17
    //   570: invokevirtual 299	android/media/MediaCodec:start	()V
    //   573: aload 17
    //   575: invokevirtual 303	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   578: astore 20
    //   580: aload 17
    //   582: invokevirtual 306	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   585: astore_1
    //   586: new 308	android/media/MediaCodec$BufferInfo
    //   589: dup
    //   590: invokespecial 309	android/media/MediaCodec$BufferInfo:<init>	()V
    //   593: astore 22
    //   595: iconst_0
    //   596: istore_3
    //   597: iconst_0
    //   598: istore 5
    //   600: iload_2
    //   601: ifeq +288 -> 889
    //   604: aload_0
    //   605: invokespecial 85	aonf:a	()Landroid/media/AudioTrack;
    //   608: astore 18
    //   610: aconst_null
    //   611: astore 19
    //   613: iconst_0
    //   614: istore 4
    //   616: iload 4
    //   618: ifne +645 -> 1263
    //   621: iload 5
    //   623: ifne +824 -> 1447
    //   626: aload 17
    //   628: ldc2_w 310
    //   631: invokevirtual 315	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   634: istore 6
    //   636: iload 6
    //   638: iflt +809 -> 1447
    //   641: aload 21
    //   643: aload 20
    //   645: iload 6
    //   647: aaload
    //   648: iconst_0
    //   649: invokevirtual 319	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   652: istore 7
    //   654: aload 21
    //   656: invokevirtual 322	android/media/MediaExtractor:getSampleTime	()J
    //   659: lstore 12
    //   661: iload 7
    //   663: iflt +18 -> 681
    //   666: lload 8
    //   668: lconst_0
    //   669: lcmp
    //   670: ifle +238 -> 908
    //   673: lload 12
    //   675: lload 8
    //   677: lcmp
    //   678: iflt +230 -> 908
    //   681: aload 17
    //   683: iload 6
    //   685: iconst_0
    //   686: iconst_0
    //   687: lconst_0
    //   688: iconst_4
    //   689: invokevirtual 326	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   692: iconst_1
    //   693: istore 5
    //   695: iload_3
    //   696: ifne +734 -> 1430
    //   699: aload 17
    //   701: aload 22
    //   703: ldc2_w 310
    //   706: invokevirtual 330	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   709: istore 6
    //   711: iload 6
    //   713: tableswitch	default:+726 -> 1439, -3:+217->930, -2:+241->954, -1:+280->993
    //   741: lload 180
    //   743: aconst_null
    //   744: astore_2
    //   745: iconst_4
    //   746: iand
    //   747: ifeq +264 -> 1011
    //   750: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   753: ifeq +689 -> 1442
    //   756: ldc 66
    //   758: iconst_2
    //   759: ldc_w 335
    //   762: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: goto +677 -> 1442
    //   768: aload 17
    //   770: iload 6
    //   772: iconst_0
    //   773: invokevirtual 339	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   776: aload_0
    //   777: getfield 121	aonf:jdField_b_of_type_Boolean	Z
    //   780: istore 16
    //   782: iload 16
    //   784: ifeq +643 -> 1427
    //   787: aload_0
    //   788: getfield 25	aonf:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   791: astore 23
    //   793: aload 23
    //   795: monitorenter
    //   796: aload_0
    //   797: getfield 25	aonf:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   800: invokevirtual 124	java/lang/Object:wait	()V
    //   803: aload 23
    //   805: monitorexit
    //   806: iload_3
    //   807: ifeq +617 -> 1424
    //   810: iload_2
    //   811: ifeq +452 -> 1263
    //   814: aload 17
    //   816: invokevirtual 340	android/media/MediaCodec:flush	()V
    //   819: aload 21
    //   821: lload 10
    //   823: iconst_0
    //   824: invokevirtual 257	android/media/MediaExtractor:seekTo	(JI)V
    //   827: iconst_0
    //   828: istore 5
    //   830: iconst_0
    //   831: istore_3
    //   832: goto -216 -> 616
    //   835: astore_1
    //   836: aload_1
    //   837: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   840: ldc 66
    //   842: iconst_2
    //   843: ldc_w 342
    //   846: aload_1
    //   847: invokestatic 345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   850: aconst_null
    //   851: astore_1
    //   852: aload 17
    //   854: ifnull +13 -> 867
    //   857: aload 17
    //   859: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   862: aload 17
    //   864: invokevirtual 292	android/media/MediaCodec:release	()V
    //   867: aload 21
    //   869: ifnull +8 -> 877
    //   872: aload 21
    //   874: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   877: iconst_0
    //   878: ifeq -356 -> 522
    //   881: new 295	java/lang/NullPointerException
    //   884: dup
    //   885: invokespecial 296	java/lang/NullPointerException:<init>	()V
    //   888: athrow
    //   889: new 347	java/io/ByteArrayOutputStream
    //   892: dup
    //   893: invokespecial 348	java/io/ByteArrayOutputStream:<init>	()V
    //   896: astore 18
    //   898: aload 18
    //   900: astore 19
    //   902: aconst_null
    //   903: astore 18
    //   905: goto -292 -> 613
    //   908: aload 17
    //   910: iload 6
    //   912: iconst_0
    //   913: iload 7
    //   915: lload 12
    //   917: iconst_0
    //   918: invokevirtual 326	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   921: aload 21
    //   923: invokevirtual 351	android/media/MediaExtractor:advance	()Z
    //   926: pop
    //   927: goto +520 -> 1447
    //   930: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   933: ifeq +12 -> 945
    //   936: ldc 66
    //   938: iconst_2
    //   939: ldc_w 353
    //   942: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: aload 17
    //   947: invokevirtual 306	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   950: astore_1
    //   951: goto -175 -> 776
    //   954: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   957: ifeq +473 -> 1430
    //   960: ldc 66
    //   962: iconst_2
    //   963: new 169	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   970: ldc_w 355
    //   973: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload 17
    //   978: invokevirtual 359	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   981: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: goto -214 -> 776
    //   993: invokestatic 267	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   996: ifeq +434 -> 1430
    //   999: ldc 66
    //   1001: iconst_2
    //   1002: ldc_w 364
    //   1005: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: goto -232 -> 776
    //   1011: aload_1
    //   1012: iload 6
    //   1014: aaload
    //   1015: astore 24
    //   1017: aload 24
    //   1019: ifnonnull +56 -> 1075
    //   1022: ldc 66
    //   1024: iconst_1
    //   1025: ldc_w 366
    //   1028: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1031: aconst_null
    //   1032: astore_1
    //   1033: aload 17
    //   1035: ifnull +13 -> 1048
    //   1038: aload 17
    //   1040: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   1043: aload 17
    //   1045: invokevirtual 292	android/media/MediaCodec:release	()V
    //   1048: aload 21
    //   1050: ifnull +8 -> 1058
    //   1053: aload 21
    //   1055: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   1058: aload 18
    //   1060: ifnull -538 -> 522
    //   1063: aload 18
    //   1065: invokevirtual 145	android/media/AudioTrack:stop	()V
    //   1068: aload 18
    //   1070: invokevirtual 130	android/media/AudioTrack:release	()V
    //   1073: aconst_null
    //   1074: areturn
    //   1075: aload 22
    //   1077: getfield 369	android/media/MediaCodec$BufferInfo:size	I
    //   1080: ifeq +31 -> 1111
    //   1083: aload 24
    //   1085: aload 22
    //   1087: getfield 372	android/media/MediaCodec$BufferInfo:offset	I
    //   1090: invokevirtual 378	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1093: pop
    //   1094: aload 24
    //   1096: aload 22
    //   1098: getfield 372	android/media/MediaCodec$BufferInfo:offset	I
    //   1101: aload 22
    //   1103: getfield 369	android/media/MediaCodec$BufferInfo:size	I
    //   1106: iadd
    //   1107: invokevirtual 381	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1110: pop
    //   1111: aload 24
    //   1113: invokevirtual 384	java/nio/ByteBuffer:remaining	()I
    //   1116: istore 7
    //   1118: iload 7
    //   1120: newarray byte
    //   1122: astore 23
    //   1124: aload 24
    //   1126: aload 23
    //   1128: iconst_0
    //   1129: iload 7
    //   1131: invokevirtual 388	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   1134: pop
    //   1135: iload_2
    //   1136: ifeq +19 -> 1155
    //   1139: aload_0
    //   1140: getfield 20	aonf:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   1143: aload 18
    //   1145: aload 23
    //   1147: iload 7
    //   1149: invokestatic 391	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
    //   1152: goto +298 -> 1450
    //   1155: aload 19
    //   1157: aload 23
    //   1159: iconst_0
    //   1160: iload 7
    //   1162: invokevirtual 394	java/io/ByteArrayOutputStream:write	([BII)V
    //   1165: goto +285 -> 1450
    //   1168: astore_1
    //   1169: ldc 66
    //   1171: iconst_1
    //   1172: new 169	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1179: ldc_w 396
    //   1182: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: aload_1
    //   1186: invokevirtual 397	java/lang/Exception:toString	()Ljava/lang/String;
    //   1189: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1198: aconst_null
    //   1199: astore_1
    //   1200: aload 17
    //   1202: ifnull +13 -> 1215
    //   1205: aload 17
    //   1207: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   1210: aload 17
    //   1212: invokevirtual 292	android/media/MediaCodec:release	()V
    //   1215: aload 21
    //   1217: ifnull +8 -> 1225
    //   1220: aload 21
    //   1222: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   1225: aload 18
    //   1227: ifnull -705 -> 522
    //   1230: aload 18
    //   1232: invokevirtual 145	android/media/AudioTrack:stop	()V
    //   1235: aload 18
    //   1237: invokevirtual 130	android/media/AudioTrack:release	()V
    //   1240: aconst_null
    //   1241: areturn
    //   1242: astore 24
    //   1244: aload 23
    //   1246: monitorexit
    //   1247: aload 24
    //   1249: athrow
    //   1250: astore 23
    //   1252: aload 23
    //   1254: invokevirtual 125	java/lang/InterruptedException:printStackTrace	()V
    //   1257: iconst_1
    //   1258: istore 4
    //   1260: goto -454 -> 806
    //   1263: ldc 66
    //   1265: iconst_1
    //   1266: new 169	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1273: ldc_w 399
    //   1276: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   1282: lload 14
    //   1284: lsub
    //   1285: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1294: aload 19
    //   1296: ifnonnull +52 -> 1348
    //   1299: aconst_null
    //   1300: astore 19
    //   1302: aload 17
    //   1304: ifnull +13 -> 1317
    //   1307: aload 17
    //   1309: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   1312: aload 17
    //   1314: invokevirtual 292	android/media/MediaCodec:release	()V
    //   1317: aload 21
    //   1319: ifnull +8 -> 1327
    //   1322: aload 21
    //   1324: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   1327: aload 19
    //   1329: astore_1
    //   1330: aload 18
    //   1332: ifnull -810 -> 522
    //   1335: aload 18
    //   1337: invokevirtual 145	android/media/AudioTrack:stop	()V
    //   1340: aload 18
    //   1342: invokevirtual 130	android/media/AudioTrack:release	()V
    //   1345: aload 19
    //   1347: areturn
    //   1348: aload 19
    //   1350: invokevirtual 402	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1353: astore 19
    //   1355: goto -53 -> 1302
    //   1358: astore 20
    //   1360: aload_1
    //   1361: astore 17
    //   1363: aload 19
    //   1365: astore 18
    //   1367: aload 20
    //   1369: astore_1
    //   1370: aload 17
    //   1372: ifnull +13 -> 1385
    //   1375: aload 17
    //   1377: invokevirtual 291	android/media/MediaCodec:stop	()V
    //   1380: aload 17
    //   1382: invokevirtual 292	android/media/MediaCodec:release	()V
    //   1385: aload 21
    //   1387: ifnull +8 -> 1395
    //   1390: aload 21
    //   1392: invokevirtual 293	android/media/MediaExtractor:release	()V
    //   1395: aload 18
    //   1397: ifnull +13 -> 1410
    //   1400: aload 18
    //   1402: invokevirtual 145	android/media/AudioTrack:stop	()V
    //   1405: aload 18
    //   1407: invokevirtual 130	android/media/AudioTrack:release	()V
    //   1410: aload_1
    //   1411: athrow
    //   1412: astore_1
    //   1413: aload 19
    //   1415: astore 18
    //   1417: goto -47 -> 1370
    //   1420: astore_1
    //   1421: goto -51 -> 1370
    //   1424: goto -808 -> 616
    //   1427: goto -621 -> 806
    //   1430: goto -654 -> 776
    //   1433: aconst_null
    //   1434: astore 17
    //   1436: goto -967 -> 469
    //   1439: goto -699 -> 740
    //   1442: iconst_1
    //   1443: istore_3
    //   1444: goto -676 -> 768
    //   1447: goto -752 -> 695
    //   1450: goto -682 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1453	0	this	aonf
    //   0	1453	1	paramString	String
    //   0	1453	2	paramBoolean	boolean
    //   44	1400	3	i	int
    //   614	645	4	j	int
    //   598	231	5	k	int
    //   634	379	6	m	int
    //   652	509	7	n	int
    //   41	635	8	l1	long
    //   38	784	10	l2	long
    //   124	792	12	l3	long
    //   11	1272	14	l4	long
    //   780	3	16	bool	boolean
    //   17	1418	17	localObject1	Object
    //   14	524	18	localMediaCodec	android.media.MediaCodec
    //   548	6	18	localThrowable1	Throwable
    //   608	808	18	localObject2	Object
    //   29	1385	19	localObject3	Object
    //   66	578	20	localObject4	Object
    //   1358	10	20	localObject5	Object
    //   26	1365	21	localMediaExtractor	android.media.MediaExtractor
    //   78	112	22	str	String
    //   531	10	22	localThrowable2	Throwable
    //   593	509	22	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   1250	3	23	localInterruptedException	InterruptedException
    //   1015	110	24	localObject7	Object
    //   1242	6	24	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	524	java/io/IOException
    //   301	322	531	java/lang/Throwable
    //   325	346	531	java/lang/Throwable
    //   189	196	548	java/lang/Throwable
    //   203	209	548	java/lang/Throwable
    //   216	298	548	java/lang/Throwable
    //   353	359	548	java/lang/Throwable
    //   366	448	548	java/lang/Throwable
    //   455	465	548	java/lang/Throwable
    //   540	545	548	java/lang/Throwable
    //   568	573	835	java/lang/Throwable
    //   1022	1031	1168	java/lang/Exception
    //   1075	1111	1168	java/lang/Exception
    //   1111	1135	1168	java/lang/Exception
    //   1139	1152	1168	java/lang/Exception
    //   1155	1165	1168	java/lang/Exception
    //   796	806	1242	finally
    //   1244	1247	1242	finally
    //   787	796	1250	java/lang/InterruptedException
    //   1247	1250	1250	java/lang/InterruptedException
    //   48	57	1358	finally
    //   60	68	1358	finally
    //   71	80	1358	finally
    //   83	94	1358	finally
    //   97	110	1358	finally
    //   113	126	1358	finally
    //   140	146	1358	finally
    //   149	159	1358	finally
    //   162	168	1358	finally
    //   178	186	1358	finally
    //   189	196	1358	finally
    //   203	209	1358	finally
    //   216	298	1358	finally
    //   301	322	1358	finally
    //   325	346	1358	finally
    //   353	359	1358	finally
    //   366	448	1358	finally
    //   455	465	1358	finally
    //   540	545	1358	finally
    //   553	558	1358	finally
    //   474	483	1412	finally
    //   568	573	1412	finally
    //   573	595	1412	finally
    //   604	610	1412	finally
    //   836	850	1412	finally
    //   889	898	1412	finally
    //   626	636	1420	finally
    //   641	661	1420	finally
    //   681	692	1420	finally
    //   699	711	1420	finally
    //   740	765	1420	finally
    //   768	776	1420	finally
    //   776	782	1420	finally
    //   787	796	1420	finally
    //   814	827	1420	finally
    //   908	927	1420	finally
    //   930	945	1420	finally
    //   945	951	1420	finally
    //   954	990	1420	finally
    //   993	1008	1420	finally
    //   1022	1031	1420	finally
    //   1075	1111	1420	finally
    //   1111	1135	1420	finally
    //   1139	1152	1420	finally
    //   1155	1165	1420	finally
    //   1169	1198	1420	finally
    //   1247	1250	1420	finally
    //   1252	1257	1420	finally
    //   1263	1294	1420	finally
    //   1348	1355	1420	finally
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
 * Qualified Name:     aonf
 * JD-Core Version:    0.7.0.1
 */