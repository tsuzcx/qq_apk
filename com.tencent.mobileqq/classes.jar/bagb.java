import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

@TargetApi(11)
public class bagb
  implements SurfaceTexture.OnFrameAvailableListener, baem, bafh, bagj
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private baej jdField_a_of_type_Baej;
  private bafx jdField_a_of_type_Bafx;
  private bagc jdField_a_of_type_Bagc;
  private bagj jdField_a_of_type_Bagj;
  private bagl jdField_a_of_type_Bagl = new bagl();
  private bahb jdField_a_of_type_Bahb;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private GPUBaseFilter jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    if (this.jdField_a_of_type_Bahb != null) {
      this.jdField_a_of_type_Bahb.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
  }
  
  public void a()
  {
    xvv.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    onEncodeError(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Long >= paramLong)
      {
        this.jdField_b_of_type_Boolean = true;
        QLog.e("Mp4ReEncoder", 2, "mLastDecodeTimestamp >= timestampNanos; mLastDecodeTimestamp = " + this.jdField_a_of_type_Long + " timestampNanos = " + paramLong);
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = paramLong;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong);
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(2000L);
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean)) {
          onEncodeError(3, new RuntimeException("frame wait timed out"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame end timestamp = " + paramLong);
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          break label267;
        }
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
        this.jdField_a_of_type_Boolean = false;
        throw localInterruptedException;
      }
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void a(baej parambaej, bafx parambafx, bagj parambagj, bagc parambagc)
  {
    this.jdField_a_of_type_Baej = parambaej;
    this.jdField_a_of_type_Bafx = parambafx;
    this.jdField_a_of_type_Bagj = parambagj;
    this.jdField_a_of_type_Bagc = parambagc;
    this.jdField_a_of_type_Bagl.a(parambafx, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void b(long paramLong) {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Bagl.b();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Bagl.b();
  }
  
  public void l() {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeFinish(paramString);
    }
    if (this.jdField_d_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.deleteTexture(this.jdField_c_of_type_Int);
    b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeFrame();
    }
  }
  
  /* Error */
  public void onEncodeStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 214
    //   3: invokestatic 218	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 199	bagb:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 204	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   18: getfield 222	bafx:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   25: getfield 223	bafx:jdField_b_of_type_Int	I
    //   28: ldc 224
    //   30: invokespecial 227	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   33: putfield 202	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   36: aload_0
    //   37: bipush 102
    //   39: invokestatic 232	bagt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   42: checkcast 68	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   45: putfield 66	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   48: aload_0
    //   49: getfield 66	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   52: aload_0
    //   53: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   56: getfield 222	bafx:jdField_a_of_type_Int	I
    //   59: aload_0
    //   60: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   63: getfield 223	bafx:jdField_b_of_type_Int	I
    //   66: invokevirtual 236	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   69: aload_0
    //   70: getfield 66	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   73: invokevirtual 239	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   76: aload_0
    //   77: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   80: getfield 241	bafx:f	I
    //   83: invokestatic 244	bagt:a	(I)Z
    //   86: ifne +13 -> 99
    //   89: aload_0
    //   90: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   93: getfield 247	bafx:c	Ljava/lang/String;
    //   96: ifnull +110 -> 206
    //   99: aload_0
    //   100: new 75	bahb
    //   103: dup
    //   104: invokespecial 248	bahb:<init>	()V
    //   107: putfield 73	bagb:jdField_a_of_type_Bahb	Lbahb;
    //   110: aload_0
    //   111: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   114: getfield 241	bafx:f	I
    //   117: invokestatic 244	bagt:a	(I)Z
    //   120: ifeq +20 -> 140
    //   123: aload_0
    //   124: getfield 73	bagb:jdField_a_of_type_Bahb	Lbahb;
    //   127: aload_0
    //   128: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   131: getfield 241	bafx:f	I
    //   134: invokestatic 232	bagt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   137: invokevirtual 251	bahb:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   140: aload_0
    //   141: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   144: getfield 247	bafx:c	Ljava/lang/String;
    //   147: ifnull +31 -> 178
    //   150: bipush 106
    //   152: invokestatic 232	bagt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   155: astore_1
    //   156: aload_1
    //   157: checkcast 253	bagy
    //   160: aload_0
    //   161: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   164: getfield 247	bafx:c	Ljava/lang/String;
    //   167: invokevirtual 255	bagy:a	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 73	bagb:jdField_a_of_type_Bahb	Lbahb;
    //   174: aload_1
    //   175: invokevirtual 251	bahb:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   178: aload_0
    //   179: getfield 73	bagb:jdField_a_of_type_Bahb	Lbahb;
    //   182: aload_0
    //   183: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   186: getfield 222	bafx:jdField_a_of_type_Int	I
    //   189: aload_0
    //   190: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   193: getfield 223	bafx:jdField_b_of_type_Int	I
    //   196: invokevirtual 256	bahb:onOutputSizeChanged	(II)V
    //   199: aload_0
    //   200: getfield 73	bagb:jdField_a_of_type_Bahb	Lbahb;
    //   203: invokevirtual 257	bahb:init	()V
    //   206: aload_0
    //   207: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   210: getfield 259	bafx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +120 -> 335
    //   218: aload_0
    //   219: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   222: getfield 259	bafx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokestatic 265	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   228: astore_2
    //   229: aload_0
    //   230: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   233: getfield 267	bafx:g	I
    //   236: ifeq +170 -> 406
    //   239: aload_2
    //   240: sipush 360
    //   243: aload_0
    //   244: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   247: getfield 267	bafx:g	I
    //   250: isub
    //   251: i2f
    //   252: invokestatic 273	com/tencent/biz/qqstory/utils/UIUtils:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   255: astore_1
    //   256: aload_0
    //   257: sipush 3553
    //   260: aload_1
    //   261: invokestatic 276	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   264: putfield 53	bagb:jdField_d_of_type_Int	I
    //   267: aload_0
    //   268: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   271: getfield 279	bafx:i	I
    //   274: ifne +164 -> 438
    //   277: aload_0
    //   278: aload_1
    //   279: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   282: putfield 287	bagb:e	I
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual 290	android/graphics/Bitmap:getHeight	()I
    //   290: putfield 291	bagb:f	I
    //   293: aload_1
    //   294: invokevirtual 294	android/graphics/Bitmap:recycle	()V
    //   297: aload_0
    //   298: sipush 1000
    //   301: invokestatic 232	bagt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   304: putfield 78	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   307: aload_0
    //   308: getfield 78	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   311: aload_0
    //   312: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   315: getfield 222	bafx:jdField_a_of_type_Int	I
    //   318: aload_0
    //   319: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   322: getfield 223	bafx:jdField_b_of_type_Int	I
    //   325: invokevirtual 295	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   328: aload_0
    //   329: getfield 78	bagb:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   332: invokevirtual 296	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   335: aload_0
    //   336: bipush 101
    //   338: invokestatic 232	bagt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   341: putfield 83	bagb:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   344: aload_0
    //   345: getfield 83	bagb:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   348: aload_0
    //   349: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   352: getfield 222	bafx:jdField_a_of_type_Int	I
    //   355: aload_0
    //   356: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   359: getfield 223	bafx:jdField_b_of_type_Int	I
    //   362: invokevirtual 295	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   365: aload_0
    //   366: getfield 83	bagb:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   369: invokevirtual 296	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   372: aload_0
    //   373: getfield 63	bagb:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder;
    //   376: aload_0
    //   377: getfield 164	bagb:jdField_a_of_type_Baej	Lbaej;
    //   380: aload_0
    //   381: getfield 199	bagb:jdField_c_of_type_Int	I
    //   384: aload_0
    //   385: aload_0
    //   386: invokevirtual 299	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder:a	(Lbaej;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lbaem;)V
    //   389: aload_0
    //   390: getfield 168	bagb:jdField_a_of_type_Bagj	Lbagj;
    //   393: ifnull +12 -> 405
    //   396: aload_0
    //   397: getfield 168	bagb:jdField_a_of_type_Bagj	Lbagj;
    //   400: invokeinterface 301 1 0
    //   405: return
    //   406: aload_2
    //   407: astore_1
    //   408: aload_0
    //   409: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   412: getfield 279	bafx:i	I
    //   415: ifeq -159 -> 256
    //   418: aload_2
    //   419: sipush 360
    //   422: aload_0
    //   423: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   426: getfield 279	bafx:i	I
    //   429: isub
    //   430: i2f
    //   431: invokestatic 273	com/tencent/biz/qqstory/utils/UIUtils:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   434: astore_1
    //   435: goto -179 -> 256
    //   438: aload_0
    //   439: aload_1
    //   440: invokevirtual 290	android/graphics/Bitmap:getHeight	()I
    //   443: putfield 287	bagb:e	I
    //   446: aload_0
    //   447: aload_1
    //   448: invokevirtual 285	android/graphics/Bitmap:getWidth	()I
    //   451: putfield 291	bagb:f	I
    //   454: goto -161 -> 293
    //   457: astore_1
    //   458: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq +36 -> 497
    //   464: ldc 100
    //   466: iconst_2
    //   467: new 116	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 303
    //   477: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_0
    //   481: getfield 166	bagb:jdField_a_of_type_Bafx	Lbafx;
    //   484: getfield 259	bafx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   487: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aload_1
    //   494: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: aload_0
    //   498: iconst_1
    //   499: aload_1
    //   500: invokevirtual 111	bagb:onEncodeError	(ILjava/lang/Throwable;)V
    //   503: return
    //   504: astore_1
    //   505: aload_0
    //   506: iconst_4
    //   507: aload_1
    //   508: invokevirtual 111	bagb:onEncodeError	(ILjava/lang/Throwable;)V
    //   511: ldc 100
    //   513: iconst_1
    //   514: new 116	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 308
    //   524: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	bagb
    //   155	293	1	localObject	Object
    //   457	43	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   504	24	1	localException	Exception
    //   228	191	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   218	256	457	java/lang/OutOfMemoryError
    //   256	293	457	java/lang/OutOfMemoryError
    //   293	297	457	java/lang/OutOfMemoryError
    //   408	435	457	java/lang/OutOfMemoryError
    //   438	454	457	java/lang/OutOfMemoryError
    //   0	99	504	java/lang/Exception
    //   99	140	504	java/lang/Exception
    //   140	178	504	java/lang/Exception
    //   178	206	504	java/lang/Exception
    //   206	214	504	java/lang/Exception
    //   218	256	504	java/lang/Exception
    //   256	293	504	java/lang/Exception
    //   293	297	504	java/lang/Exception
    //   297	335	504	java/lang/Exception
    //   335	405	504	java/lang/Exception
    //   408	435	504	java/lang/Exception
    //   438	454	504	java/lang/Exception
    //   458	497	504	java/lang/Exception
    //   497	503	504	java/lang/Exception
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_b_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long);
      }
      try
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaLangObject.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.e("Mp4ReEncoder", 2, "onFrameAvailable skipDecode");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Int != 0) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean + "; stopped=" + this.jdField_d_of_type_Boolean);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
    }
    if (this.jdField_a_of_type_Boolean) {
      onEncodeError(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
    try
    {
      paramSurfaceTexture.updateTexImage();
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestamp = " + this.jdField_b_of_type_Long);
      }
      float[] arrayOfFloat = new float[16];
      paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
      ??? = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_c_of_type_Int, null, null);
      paramSurfaceTexture = (SurfaceTexture)???;
      if (this.jdField_a_of_type_Bahb != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        this.jdField_a_of_type_Bahb.drawTexture(((RenderBuffer)???).getTexId(), null, null);
        paramSurfaceTexture = this.jdField_a_of_type_Bahb.a();
        paramSurfaceTexture.bind();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
      {
        ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.jdField_b_of_type_Int, this.e, this.f);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_d_of_type_Int, null, (float[])???);
        GLES20.glDisable(3042);
      }
      if (this.jdField_a_of_type_Bagc != null) {
        this.jdField_a_of_type_Bagc.a();
      }
      paramSurfaceTexture.unbind();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(paramSurfaceTexture.getTexId(), arrayOfFloat, null);
      this.jdField_a_of_type_Bagl.a(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.jdField_b_of_type_Long);
      int i = 1;
      while (i <= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Bagl.a(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.jdField_b_of_type_Long + i * 5 * 1000);
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    catch (Exception paramSurfaceTexture)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean, paramSurfaceTexture);
      return;
    }
    this.jdField_a_of_type_JavaLangObject.notifyAll();
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagb
 * JD-Core Version:    0.7.0.1
 */