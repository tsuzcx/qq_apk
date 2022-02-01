import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;

@TargetApi(11)
public class bppq
  implements SurfaceTexture.OnFrameAvailableListener, bbmy, HWDecodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  protected bbmm a;
  private bbmy jdField_a_of_type_Bbmy;
  protected bbna a;
  private bppr jdField_a_of_type_Bppr;
  private bppx jdField_a_of_type_Bppx;
  private bppz jdField_a_of_type_Bppz;
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  protected DecodeConfig a;
  protected HWVideoDecoder a;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<DynamicStickerData> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long = -1L;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList<TrackerStickerParam> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  public bppq()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bbna = new bbna();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    if (this.jdField_a_of_type_Bppz != null) {
      this.jdField_a_of_type_Bppz.a();
    }
    if (this.jdField_a_of_type_Bppx != null) {
      this.jdField_a_of_type_Bppx.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.destroy();
    }
  }
  
  public void a()
  {
    ykq.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
  }
  
  public void a(DecodeConfig paramDecodeConfig, bbmm parambbmm, bbmy parambbmy, bppr parambppr)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_Bbmm = parambbmm;
    if ((paramDecodeConfig.speedType == 1) || (paramDecodeConfig.speedType == 3)) {
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bbmy = parambbmy;
    this.jdField_a_of_type_Bppr = parambppr;
    this.jdField_a_of_type_Bbna.a(parambbmm, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.fromJSONObject(paramString);
    }
  }
  
  public void a(ArrayList<DynamicStickerData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bbna.a();
  }
  
  public void b(ArrayList<TrackerStickerParam> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Bbna.b();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = (paramInt + 10000);
    this.jdField_a_of_type_Bbna.b();
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeError(this.jdField_a_of_type_Int, paramThrowable);
    }
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Bbna.b();
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong1 + " orgSampleTime: " + paramLong2);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong1);
        }
      }
    }
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeFinish(paramString);
    }
    if (this.jdField_d_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.deleteTexture(this.jdField_c_of_type_Int);
    b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeFrame();
    }
  }
  
  /* Error */
  public void onEncodeStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 262
    //   4: invokestatic 266	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   7: putfield 245	bppq:jdField_c_of_type_Int	I
    //   10: aload_0
    //   11: new 250	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   14: dup
    //   15: aload_0
    //   16: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   19: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   22: aload_0
    //   23: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   26: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   29: ldc_w 272
    //   32: invokespecial 275	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   35: putfield 248	bppq:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   38: aload_0
    //   39: new 250	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   42: dup
    //   43: aload_0
    //   44: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   47: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   50: aload_0
    //   51: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   54: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   57: ldc_w 272
    //   60: invokespecial 275	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   63: putfield 253	bppq:jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   66: aload_0
    //   67: bipush 102
    //   69: invokestatic 280	bppt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   72: checkcast 76	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   75: putfield 74	bppq:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   78: aload_0
    //   79: getfield 74	bppq:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   82: aload_0
    //   83: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   86: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   89: aload_0
    //   90: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   93: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   96: invokevirtual 284	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   99: aload_0
    //   100: getfield 74	bppq:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   103: invokevirtual 287	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   106: aload_0
    //   107: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   110: getfield 290	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   113: ifeq +94 -> 207
    //   116: aload_0
    //   117: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   120: getfield 291	bbmm:jdField_c_of_type_Boolean	Z
    //   123: ifeq +84 -> 207
    //   126: aload_0
    //   127: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   130: getfield 294	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   133: ifeq +823 -> 956
    //   136: bipush 166
    //   138: istore_1
    //   139: aload_0
    //   140: new 83	bppz
    //   143: dup
    //   144: iload_1
    //   145: invokespecial 296	bppz:<init>	(I)V
    //   148: putfield 81	bppq:jdField_a_of_type_Bppz	Lbppz;
    //   151: aload_0
    //   152: getfield 81	bppq:jdField_a_of_type_Bppz	Lbppz;
    //   155: aload_0
    //   156: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   159: getfield 299	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:width	I
    //   162: aload_0
    //   163: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   166: getfield 302	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:height	I
    //   169: aload_0
    //   170: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   173: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   176: aload_0
    //   177: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   180: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   183: invokevirtual 305	bppz:a	(IIII)V
    //   186: aload_0
    //   187: getfield 81	bppq:jdField_a_of_type_Bppz	Lbppz;
    //   190: aload_0
    //   191: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   194: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   197: aload_0
    //   198: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   201: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   204: invokevirtual 307	bppz:a	(II)V
    //   207: aload_0
    //   208: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   211: getfield 309	bbmm:f	I
    //   214: invokestatic 312	bppt:a	(I)Z
    //   217: ifne +13 -> 230
    //   220: aload_0
    //   221: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   224: getfield 315	bbmm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   227: ifnull +112 -> 339
    //   230: aload_0
    //   231: new 89	bppx
    //   234: dup
    //   235: invokespecial 316	bppx:<init>	()V
    //   238: putfield 87	bppq:jdField_a_of_type_Bppx	Lbppx;
    //   241: aload_0
    //   242: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   245: getfield 309	bbmm:f	I
    //   248: invokestatic 312	bppt:a	(I)Z
    //   251: ifeq +20 -> 271
    //   254: aload_0
    //   255: getfield 87	bppq:jdField_a_of_type_Bppx	Lbppx;
    //   258: aload_0
    //   259: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   262: getfield 309	bbmm:f	I
    //   265: invokestatic 280	bppt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   268: invokevirtual 319	bppx:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   271: aload_0
    //   272: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   275: getfield 315	bbmm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   278: astore_2
    //   279: aload_2
    //   280: ifnull +31 -> 311
    //   283: bipush 106
    //   285: invokestatic 280	bppt:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   288: astore_2
    //   289: aload_2
    //   290: checkcast 321	bppw
    //   293: aload_0
    //   294: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   297: getfield 315	bbmm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   300: invokevirtual 323	bppw:a	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield 87	bppq:jdField_a_of_type_Bppx	Lbppx;
    //   307: aload_2
    //   308: invokevirtual 319	bppx:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   311: aload_0
    //   312: getfield 87	bppq:jdField_a_of_type_Bppx	Lbppx;
    //   315: aload_0
    //   316: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   319: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   322: aload_0
    //   323: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   326: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   329: invokevirtual 324	bppx:onOutputSizeChanged	(II)V
    //   332: aload_0
    //   333: getfield 87	bppq:jdField_a_of_type_Bppx	Lbppx;
    //   336: invokevirtual 325	bppx:init	()V
    //   339: aload_0
    //   340: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   343: getfield 327	bbmm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   346: astore_2
    //   347: aload_2
    //   348: ifnull +127 -> 475
    //   351: aload_0
    //   352: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   355: getfield 327	bbmm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   358: invokestatic 333	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   361: astore_3
    //   362: aload_0
    //   363: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   366: getfield 290	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   369: ifeq +515 -> 884
    //   372: aload_3
    //   373: astore_2
    //   374: aload_0
    //   375: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   378: getfield 334	bbmm:jdField_d_of_type_Boolean	Z
    //   381: ifeq +24 -> 405
    //   384: aload_3
    //   385: astore_2
    //   386: aload_3
    //   387: invokevirtual 340	android/graphics/Bitmap:getWidth	()I
    //   390: aload_3
    //   391: invokevirtual 343	android/graphics/Bitmap:getHeight	()I
    //   394: if_icmple +11 -> 405
    //   397: aload_3
    //   398: ldc_w 344
    //   401: invokestatic 350	com/tencent/biz/qqstory/utils/UIUtils:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   404: astore_2
    //   405: aload_0
    //   406: sipush 3553
    //   409: aload_2
    //   410: invokestatic 353	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   413: putfield 61	bppq:jdField_d_of_type_Int	I
    //   416: aload_0
    //   417: aload_2
    //   418: invokevirtual 340	android/graphics/Bitmap:getWidth	()I
    //   421: putfield 355	bppq:jdField_e_of_type_Int	I
    //   424: aload_0
    //   425: aload_2
    //   426: invokevirtual 343	android/graphics/Bitmap:getHeight	()I
    //   429: putfield 356	bppq:f	I
    //   432: aload_2
    //   433: invokevirtual 359	android/graphics/Bitmap:recycle	()V
    //   436: aload_0
    //   437: new 94	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter
    //   440: dup
    //   441: invokespecial 360	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:<init>	()V
    //   444: putfield 92	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   447: aload_0
    //   448: getfield 92	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   451: aload_0
    //   452: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   455: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   458: aload_0
    //   459: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   462: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   465: invokevirtual 361	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:onOutputSizeChanged	(II)V
    //   468: aload_0
    //   469: getfield 92	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   472: invokevirtual 362	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:init	()V
    //   475: aload_0
    //   476: new 240	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager
    //   479: dup
    //   480: invokespecial 363	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:<init>	()V
    //   483: putfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   486: aload_0
    //   487: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   490: invokevirtual 367	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getChainBuilder	()Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder;
    //   493: astore_2
    //   494: aload_2
    //   495: iconst_1
    //   496: invokevirtual 373	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:setUseSort	(Z)V
    //   499: aload_0
    //   500: getfield 157	bppq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   503: ifnull +20 -> 523
    //   506: aload_0
    //   507: getfield 157	bppq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   510: invokevirtual 378	java/util/ArrayList:size	()I
    //   513: ifle +10 -> 523
    //   516: aload_2
    //   517: bipush 120
    //   519: aconst_null
    //   520: invokevirtual 382	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   523: aload_0
    //   524: getfield 163	bppq:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   527: ifnull +10 -> 537
    //   530: aload_2
    //   531: bipush 110
    //   533: aconst_null
    //   534: invokevirtual 382	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   537: aload_2
    //   538: invokevirtual 385	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:commit	()V
    //   541: aload_0
    //   542: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   545: invokevirtual 389	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   548: aload_0
    //   549: getfield 157	bppq:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   552: invokevirtual 395	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setDynamicStickerParam	(Ljava/util/List;)V
    //   555: aload_0
    //   556: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   559: invokevirtual 389	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   562: aload_0
    //   563: getfield 163	bppq:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   566: invokevirtual 398	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setTrackerStickerParam	(Ljava/util/ArrayList;)V
    //   569: aload_0
    //   570: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   573: aload_0
    //   574: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   577: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   580: aload_0
    //   581: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   584: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   587: aload_0
    //   588: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   591: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   594: aload_0
    //   595: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   598: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   601: invokevirtual 401	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:surfaceCreate	(IIII)V
    //   604: aload_0
    //   605: getfield 136	bppq:jdField_a_of_type_Bppr	Lbppr;
    //   608: ifnull +40 -> 648
    //   611: aload_0
    //   612: getfield 136	bppq:jdField_a_of_type_Bppr	Lbppr;
    //   615: aload_0
    //   616: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   619: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   622: aload_0
    //   623: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   626: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   629: aload_0
    //   630: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   633: getfield 269	bbmm:jdField_a_of_type_Int	I
    //   636: aload_0
    //   637: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   640: getfield 271	bbmm:jdField_b_of_type_Int	I
    //   643: invokeinterface 404 5 0
    //   648: aload_0
    //   649: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   652: invokevirtual 389	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   655: aload_0
    //   656: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   659: getfield 407	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:startTimeMillSecond	J
    //   662: invokevirtual 410	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setVideoStartTime	(J)V
    //   665: aload_0
    //   666: getfield 151	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   669: ifnull +133 -> 802
    //   672: aload_0
    //   673: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   676: sipush 160
    //   679: invokevirtual 413	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:hasQQFilter	(I)Z
    //   682: ifne +269 -> 951
    //   685: aload_0
    //   686: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   689: sipush 160
    //   692: aconst_null
    //   693: invokevirtual 417	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:pushChainBasedStackTopChain	(ILjava/lang/Object;)Ljava/lang/String;
    //   696: pop
    //   697: aload_0
    //   698: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   701: sipush 160
    //   704: invokevirtual 421	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilterByType	(I)Lcom/tencent/mobileqq/shortvideo/filter/QQBaseFilter;
    //   707: checkcast 423	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   710: astore_2
    //   711: aload_2
    //   712: astore_3
    //   713: aload_2
    //   714: ifnonnull +62 -> 776
    //   717: aload_0
    //   718: getfield 238	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   721: sipush 160
    //   724: invokevirtual 427	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilters	(I)Ljava/util/List;
    //   727: astore 4
    //   729: aload_2
    //   730: astore_3
    //   731: aload 4
    //   733: ifnull +43 -> 776
    //   736: aload_2
    //   737: astore_3
    //   738: aload 4
    //   740: invokeinterface 430 1 0
    //   745: ifle +31 -> 776
    //   748: aload_2
    //   749: astore_3
    //   750: aload 4
    //   752: iconst_0
    //   753: invokeinterface 434 2 0
    //   758: instanceof 423
    //   761: ifeq +15 -> 776
    //   764: aload 4
    //   766: iconst_0
    //   767: invokeinterface 434 2 0
    //   772: checkcast 423	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   775: astore_3
    //   776: aload_3
    //   777: ifnull +25 -> 802
    //   780: aload_3
    //   781: aload_0
    //   782: getfield 151	bppq:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   785: invokevirtual 438	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setTransferData	(Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;)V
    //   788: aload_3
    //   789: aload_0
    //   790: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   793: getfield 130	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
    //   796: invokestatic 442	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:getSpeedRate	(I)F
    //   799: invokevirtual 446	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setSpeedRate	(F)V
    //   802: aload_0
    //   803: getfield 71	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   806: aload_0
    //   807: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   810: aload_0
    //   811: getfield 245	bppq:jdField_c_of_type_Int	I
    //   814: aload_0
    //   815: aload_0
    //   816: invokevirtual 450	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:startDecode	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;)V
    //   819: aload_0
    //   820: getfield 134	bppq:jdField_a_of_type_Bbmy	Lbbmy;
    //   823: ifnull +138 -> 961
    //   826: aload_0
    //   827: getfield 134	bppq:jdField_a_of_type_Bbmy	Lbbmy;
    //   830: invokeinterface 452 1 0
    //   835: return
    //   836: astore_2
    //   837: ldc 112
    //   839: iconst_1
    //   840: ldc_w 454
    //   843: aload_2
    //   844: invokestatic 457	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   847: goto -536 -> 311
    //   850: astore_2
    //   851: aload_0
    //   852: iconst_4
    //   853: aload_2
    //   854: invokevirtual 219	bppq:onEncodeError	(ILjava/lang/Throwable;)V
    //   857: ldc 112
    //   859: iconst_1
    //   860: new 183	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 459
    //   870: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_2
    //   874: invokevirtual 462	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: return
    //   884: aload_3
    //   885: sipush 360
    //   888: aload_0
    //   889: getfield 123	bppq:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   892: getfield 467	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   895: isub
    //   896: i2f
    //   897: invokestatic 350	com/tencent/biz/qqstory/utils/UIUtils:rotateBitmap	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   900: astore_2
    //   901: goto -496 -> 405
    //   904: astore_2
    //   905: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq +36 -> 944
    //   911: ldc 112
    //   913: iconst_2
    //   914: new 183	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 469
    //   924: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_0
    //   928: getfield 125	bppq:jdField_a_of_type_Bbmm	Lbbmm;
    //   931: getfield 327	bbmm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   934: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: aload_2
    //   941: invokestatic 457	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   944: aload_0
    //   945: iconst_1
    //   946: aload_2
    //   947: invokevirtual 219	bppq:onEncodeError	(ILjava/lang/Throwable;)V
    //   950: return
    //   951: aconst_null
    //   952: astore_2
    //   953: goto -242 -> 711
    //   956: iconst_0
    //   957: istore_1
    //   958: goto -819 -> 139
    //   961: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	this	bppq
    //   138	820	1	i	int
    //   278	471	2	localObject1	Object
    //   836	8	2	localException1	Exception
    //   850	24	2	localException2	Exception
    //   900	1	2	localBitmap	android.graphics.Bitmap
    //   904	43	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   952	1	2	localObject2	Object
    //   361	524	3	localObject3	Object
    //   727	38	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   283	311	836	java/lang/Exception
    //   0	136	850	java/lang/Exception
    //   139	207	850	java/lang/Exception
    //   207	230	850	java/lang/Exception
    //   230	271	850	java/lang/Exception
    //   271	279	850	java/lang/Exception
    //   311	339	850	java/lang/Exception
    //   339	347	850	java/lang/Exception
    //   351	372	850	java/lang/Exception
    //   374	384	850	java/lang/Exception
    //   386	405	850	java/lang/Exception
    //   405	436	850	java/lang/Exception
    //   436	475	850	java/lang/Exception
    //   475	523	850	java/lang/Exception
    //   523	537	850	java/lang/Exception
    //   537	648	850	java/lang/Exception
    //   648	711	850	java/lang/Exception
    //   717	729	850	java/lang/Exception
    //   738	748	850	java/lang/Exception
    //   750	776	850	java/lang/Exception
    //   780	802	850	java/lang/Exception
    //   802	835	850	java/lang/Exception
    //   837	847	850	java/lang/Exception
    //   884	901	850	java/lang/Exception
    //   905	944	850	java/lang/Exception
    //   944	950	850	java/lang/Exception
    //   351	372	904	java/lang/OutOfMemoryError
    //   374	384	904	java/lang/OutOfMemoryError
    //   386	405	904	java/lang/OutOfMemoryError
    //   405	436	904	java/lang/OutOfMemoryError
    //   884	901	904	java/lang/OutOfMemoryError
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_c_of_type_Long + ", mLastDecodeTimestamp " + this.jdField_a_of_type_Long + ", mLastDecodeSampleTimestamp :" + this.jdField_b_of_type_Long);
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
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    label888:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int != 0) || (this.jdField_d_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_a_of_type_Int + "; canceled=" + this.jdField_c_of_type_Boolean + "; stopped=" + this.jdField_d_of_type_Boolean);
          return;
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
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.jdField_c_of_type_Long);
          }
          float[] arrayOfFloat1 = new float[16];
          paramSurfaceTexture.getTransformMatrix(arrayOfFloat1);
          paramSurfaceTexture = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.recoverInitialTexId();
          float[] arrayOfFloat2 = new float[16];
          Matrix.setIdentityM(arrayOfFloat2, 0);
          Matrix.rotateM(arrayOfFloat2, 0, this.jdField_a_of_type_Bbmm.h, 0.0F, 0.0F, 1.0F);
          Matrix.scaleM(arrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_c_of_type_Int, arrayOfFloat1, arrayOfFloat2);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          int i;
          if (this.jdField_a_of_type_Bppz != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Bppz.a(paramSurfaceTexture.getTexId());
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Bppr != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Bppr.a(paramSurfaceTexture.getTexId(), this.jdField_c_of_type_Long);
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Bppx == null) {
            break label888;
          }
          paramSurfaceTexture.bind();
          this.jdField_a_of_type_Bppx.drawTexture(paramSurfaceTexture.getTexId(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_Bppx.a();
          paramSurfaceTexture.unbind();
          paramSurfaceTexture.bind();
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null)
          {
            arrayOfFloat1 = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.drawTexture(this.jdField_d_of_type_Int, null, arrayOfFloat1);
          }
          paramSurfaceTexture.unbind();
          long l2 = this.jdField_c_of_type_Long;
          long l1 = l2;
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            l1 = l2;
            if (this.jdField_c_of_type_Long > 0L) {
              l1 = 0L;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().SetTimeStamp(l1, this.jdField_b_of_type_Long);
          paramSurfaceTexture.setTexId(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(paramSurfaceTexture.getTexId()));
          if ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Long == -1L) || (this.jdField_c_of_type_Long - this.jdField_d_of_type_Long >= 16666666L))
          {
            arrayOfFloat1 = new float[16];
            Matrix.setIdentityM(arrayOfFloat1, 0);
            Matrix.scaleM(arrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
            this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
            this.jdField_a_of_type_Bbna.a(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.jdField_c_of_type_Long);
            i = 1;
            if (i <= this.jdField_b_of_type_Int)
            {
              this.jdField_a_of_type_Bbna.a(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.jdField_c_of_type_Long + i * 5 * 1000);
              i += 1;
              continue;
              paramSurfaceTexture = finally;
            }
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          paramSurfaceTexture.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_a_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean);
          return;
        }
      }
      paramSurfaceTexture.recoverInitialTexId();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppq
 * JD-Core Version:    0.7.0.1
 */