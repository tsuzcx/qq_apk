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
public class axvm
  implements SurfaceTexture.OnFrameAvailableListener, axtx, axus, axvu
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private ajuh jdField_a_of_type_Ajuh;
  private axtu jdField_a_of_type_Axtu;
  private axvi jdField_a_of_type_Axvi;
  private axvn jdField_a_of_type_Axvn;
  private axvu jdField_a_of_type_Axvu;
  private axvw jdField_a_of_type_Axvw = new axvw();
  private axwm jdField_a_of_type_Axwm;
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
  private GPUBaseFilter jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    if (this.jdField_a_of_type_Axwm != null) {
      this.jdField_a_of_type_Axwm.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
    if (this.jdField_a_of_type_Ajuh != null) {
      this.jdField_a_of_type_Ajuh.c();
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 97
    //   3: invokestatic 103	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 105	axvm:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 107	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   18: getfield 113	axvi:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   25: getfield 114	axvi:jdField_b_of_type_Int	I
    //   28: ldc 115
    //   30: invokespecial 118	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   33: putfield 120	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   36: aload_0
    //   37: bipush 102
    //   39: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   42: checkcast 69	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   45: putfield 67	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   48: aload_0
    //   49: getfield 67	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   52: aload_0
    //   53: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   56: getfield 113	axvi:jdField_a_of_type_Int	I
    //   59: aload_0
    //   60: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   63: getfield 114	axvi:jdField_b_of_type_Int	I
    //   66: invokevirtual 129	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   69: aload_0
    //   70: getfield 67	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   73: invokevirtual 132	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   76: aload_0
    //   77: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   80: getfield 134	axvi:f	I
    //   83: invokestatic 137	axwe:a	(I)Z
    //   86: ifne +13 -> 99
    //   89: aload_0
    //   90: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   93: getfield 140	axvi:c	Ljava/lang/String;
    //   96: ifnull +110 -> 206
    //   99: aload_0
    //   100: new 76	axwm
    //   103: dup
    //   104: invokespecial 141	axwm:<init>	()V
    //   107: putfield 74	axvm:jdField_a_of_type_Axwm	Laxwm;
    //   110: aload_0
    //   111: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   114: getfield 134	axvi:f	I
    //   117: invokestatic 137	axwe:a	(I)Z
    //   120: ifeq +20 -> 140
    //   123: aload_0
    //   124: getfield 74	axvm:jdField_a_of_type_Axwm	Laxwm;
    //   127: aload_0
    //   128: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   131: getfield 134	axvi:f	I
    //   134: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   137: invokevirtual 144	axwm:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   140: aload_0
    //   141: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   144: getfield 140	axvi:c	Ljava/lang/String;
    //   147: ifnull +31 -> 178
    //   150: bipush 106
    //   152: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   155: astore_1
    //   156: aload_1
    //   157: checkcast 146	axwj
    //   160: aload_0
    //   161: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   164: getfield 140	axvi:c	Ljava/lang/String;
    //   167: invokevirtual 149	axwj:a	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 74	axvm:jdField_a_of_type_Axwm	Laxwm;
    //   174: aload_1
    //   175: invokevirtual 144	axwm:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   178: aload_0
    //   179: getfield 74	axvm:jdField_a_of_type_Axwm	Laxwm;
    //   182: aload_0
    //   183: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   186: getfield 113	axvi:jdField_a_of_type_Int	I
    //   189: aload_0
    //   190: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   193: getfield 114	axvi:jdField_b_of_type_Int	I
    //   196: invokevirtual 150	axwm:onOutputSizeChanged	(II)V
    //   199: aload_0
    //   200: getfield 74	axvm:jdField_a_of_type_Axwm	Laxwm;
    //   203: invokevirtual 151	axwm:init	()V
    //   206: aload_0
    //   207: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   210: getfield 153	axvi:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   213: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +313 -> 529
    //   219: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +11 -> 233
    //   225: ldc 167
    //   227: iconst_2
    //   228: ldc 169
    //   230: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   238: getfield 153	axvi:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   245: getfield 113	axvi:jdField_a_of_type_Int	I
    //   248: i2f
    //   249: aload_0
    //   250: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   253: getfield 114	axvi:jdField_b_of_type_Int	I
    //   256: i2f
    //   257: ldc 173
    //   259: aload_0
    //   260: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   263: getfield 174	axvi:jdField_d_of_type_Int	I
    //   266: i2f
    //   267: fdiv
    //   268: f2i
    //   269: invokestatic 179	ajtz:a	(Ljava/lang/String;FFI)Lajuh;
    //   272: putfield 86	axvm:jdField_a_of_type_Ajuh	Lajuh;
    //   275: aload_0
    //   276: getfield 86	axvm:jdField_a_of_type_Ajuh	Lajuh;
    //   279: ifnull +50 -> 329
    //   282: aload_0
    //   283: getfield 86	axvm:jdField_a_of_type_Ajuh	Lajuh;
    //   286: iconst_1
    //   287: invokevirtual 182	ajuh:a	(Z)Z
    //   290: pop
    //   291: aload_0
    //   292: sipush 1000
    //   295: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   298: putfield 84	axvm:jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   301: aload_0
    //   302: getfield 84	axvm:jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   305: aload_0
    //   306: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   309: getfield 113	axvi:jdField_a_of_type_Int	I
    //   312: aload_0
    //   313: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   316: getfield 114	axvi:jdField_b_of_type_Int	I
    //   319: invokevirtual 183	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   322: aload_0
    //   323: getfield 84	axvm:jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   326: invokevirtual 184	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   329: aload_0
    //   330: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   333: getfield 186	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   336: astore_1
    //   337: aload_1
    //   338: ifnull +120 -> 458
    //   341: aload_0
    //   342: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   345: getfield 186	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   348: invokestatic 192	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   351: astore_2
    //   352: aload_0
    //   353: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   356: getfield 195	axvi:g	I
    //   359: ifeq +220 -> 579
    //   362: aload_2
    //   363: sipush 360
    //   366: aload_0
    //   367: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   370: getfield 195	axvi:g	I
    //   373: isub
    //   374: i2f
    //   375: invokestatic 200	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   378: astore_1
    //   379: aload_0
    //   380: sipush 3553
    //   383: aload_1
    //   384: invokestatic 203	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   387: putfield 54	axvm:jdField_d_of_type_Int	I
    //   390: aload_0
    //   391: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   394: getfield 206	axvi:i	I
    //   397: ifne +214 -> 611
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   405: putfield 214	axvm:e	I
    //   408: aload_0
    //   409: aload_1
    //   410: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   413: putfield 218	axvm:f	I
    //   416: aload_1
    //   417: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   420: aload_0
    //   421: sipush 1000
    //   424: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   427: putfield 79	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   430: aload_0
    //   431: getfield 79	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   434: aload_0
    //   435: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   438: getfield 113	axvi:jdField_a_of_type_Int	I
    //   441: aload_0
    //   442: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   445: getfield 114	axvi:jdField_b_of_type_Int	I
    //   448: invokevirtual 183	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   451: aload_0
    //   452: getfield 79	axvm:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   455: invokevirtual 184	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   458: aload_0
    //   459: bipush 101
    //   461: invokestatic 125	axwe:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   464: putfield 92	axvm:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   467: aload_0
    //   468: getfield 92	axvm:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   471: aload_0
    //   472: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   475: getfield 113	axvi:jdField_a_of_type_Int	I
    //   478: aload_0
    //   479: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   482: getfield 114	axvi:jdField_b_of_type_Int	I
    //   485: invokevirtual 183	com/tencent/ttpic/openapi/filter/GPUBaseFilter:onOutputSizeChanged	(II)V
    //   488: aload_0
    //   489: getfield 92	axvm:jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   492: invokevirtual 184	com/tencent/ttpic/openapi/filter/GPUBaseFilter:init	()V
    //   495: aload_0
    //   496: getfield 64	axvm:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder;
    //   499: aload_0
    //   500: getfield 223	axvm:jdField_a_of_type_Axtu	Laxtu;
    //   503: aload_0
    //   504: getfield 105	axvm:jdField_c_of_type_Int	I
    //   507: aload_0
    //   508: aload_0
    //   509: invokevirtual 226	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder:a	(Laxtu;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Laxtx;)V
    //   512: aload_0
    //   513: getfield 228	axvm:jdField_a_of_type_Axvu	Laxvu;
    //   516: ifnull +160 -> 676
    //   519: aload_0
    //   520: getfield 228	axvm:jdField_a_of_type_Axvu	Laxvu;
    //   523: invokeinterface 230 1 0
    //   528: return
    //   529: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -203 -> 329
    //   535: ldc 167
    //   537: iconst_2
    //   538: ldc 232
    //   540: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto -214 -> 329
    //   546: astore_1
    //   547: aload_0
    //   548: iconst_4
    //   549: aload_1
    //   550: invokevirtual 238	axvm:a_	(ILjava/lang/Throwable;)V
    //   553: ldc 167
    //   555: iconst_1
    //   556: new 240	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   563: ldc 243
    //   565: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_1
    //   569: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: return
    //   579: aload_2
    //   580: astore_1
    //   581: aload_0
    //   582: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   585: getfield 206	axvi:i	I
    //   588: ifeq -209 -> 379
    //   591: aload_2
    //   592: sipush 360
    //   595: aload_0
    //   596: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   599: getfield 206	axvi:i	I
    //   602: isub
    //   603: i2f
    //   604: invokestatic 200	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   607: astore_1
    //   608: goto -229 -> 379
    //   611: aload_0
    //   612: aload_1
    //   613: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   616: putfield 214	axvm:e	I
    //   619: aload_0
    //   620: aload_1
    //   621: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   624: putfield 218	axvm:f	I
    //   627: goto -211 -> 416
    //   630: astore_1
    //   631: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq +36 -> 670
    //   637: ldc 167
    //   639: iconst_2
    //   640: new 240	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 256
    //   650: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_0
    //   654: getfield 109	axvm:jdField_a_of_type_Axvi	Laxvi;
    //   657: getfield 186	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   660: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: aload_1
    //   667: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   670: aload_0
    //   671: iconst_1
    //   672: aload_1
    //   673: invokevirtual 238	axvm:a_	(ILjava/lang/Throwable;)V
    //   676: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	axvm
    //   155	262	1	localObject1	Object
    //   546	23	1	localException	Exception
    //   580	41	1	localObject2	Object
    //   630	43	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   351	241	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	99	546	java/lang/Exception
    //   99	140	546	java/lang/Exception
    //   140	178	546	java/lang/Exception
    //   178	206	546	java/lang/Exception
    //   206	233	546	java/lang/Exception
    //   233	329	546	java/lang/Exception
    //   329	337	546	java/lang/Exception
    //   341	379	546	java/lang/Exception
    //   379	416	546	java/lang/Exception
    //   416	420	546	java/lang/Exception
    //   420	458	546	java/lang/Exception
    //   458	528	546	java/lang/Exception
    //   529	543	546	java/lang/Exception
    //   581	608	546	java/lang/Exception
    //   611	627	546	java/lang/Exception
    //   631	670	546	java/lang/Exception
    //   670	676	546	java/lang/Exception
    //   341	379	630	java/lang/OutOfMemoryError
    //   379	416	630	java/lang/OutOfMemoryError
    //   416	420	630	java/lang/OutOfMemoryError
    //   581	608	630	java/lang/OutOfMemoryError
    //   611	627	630	java/lang/OutOfMemoryError
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a_(paramInt + 10000, paramThrowable);
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
          a_(3, new RuntimeException("frame wait timed out"));
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
          break label274;
        }
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
        this.jdField_a_of_type_Boolean = false;
        throw localInterruptedException;
      }
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void a(axtu paramaxtu, axvi paramaxvi, axvu paramaxvu, axvn paramaxvn)
  {
    this.jdField_a_of_type_Axtu = paramaxtu;
    this.jdField_a_of_type_Axvi = paramaxvi;
    this.jdField_a_of_type_Axvu = paramaxvu;
    this.jdField_a_of_type_Axvn = paramaxvn;
    this.jdField_a_of_type_Axvw.a(paramaxvi, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.a(paramString);
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
    d();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.b();
    }
  }
  
  public void b(long paramLong) {}
  
  public void c()
  {
    wxe.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Axvw.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Axvw.b();
  }
  
  public void l() {}
  
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
      a_(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
    label754:
    for (;;)
    {
      try
      {
        paramSurfaceTexture.updateTexImage();
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.jdField_b_of_type_Long);
        }
        float[] arrayOfFloat = new float[16];
        paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
        ??? = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_c_of_type_Int, null, null);
        paramSurfaceTexture = (SurfaceTexture)???;
        if (this.jdField_a_of_type_Axwm != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Axwm.drawTexture(((RenderBuffer)???).getTexId(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_Axwm.a();
          paramSurfaceTexture.bind();
        }
        if ((this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) && (this.jdField_a_of_type_Ajuh != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "subtitle encoder begin");
          }
          paramSurfaceTexture.unbind();
          if (!this.jdField_a_of_type_Ajuh.a(this.jdField_b_of_type_Long / 1000000L)) {
            break label754;
          }
          paramSurfaceTexture.bind();
          i = this.jdField_a_of_type_Ajuh.d();
          if (i >= 0)
          {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(i, null, null);
            GLES20.glDisable(3042);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "subtitle draw texture end");
          }
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int, this.e, this.f);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_d_of_type_Int, null, (float[])???);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Axvn != null) {
          this.jdField_a_of_type_Axvn.a();
        }
        paramSurfaceTexture.unbind();
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(paramSurfaceTexture.getTexId(), arrayOfFloat, null);
        this.jdField_a_of_type_Axvw.a(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.jdField_b_of_type_Long);
        int i = 1;
        if (i > this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_Axvw.a(3553, paramSurfaceTexture.getTexId(), arrayOfFloat, null, this.jdField_b_of_type_Long + i * 5 * 1000);
        i += 1;
        continue;
        paramSurfaceTexture.bind();
      }
      catch (Exception paramSurfaceTexture)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean, paramSurfaceTexture);
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvm
 * JD-Core Version:    0.7.0.1
 */