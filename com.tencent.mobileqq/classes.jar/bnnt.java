import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.util.ArrayList;

@TargetApi(11)
public class bnnt
  implements SurfaceTexture.OnFrameAvailableListener, axvu, HWDecodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  protected axvi a;
  private axvu jdField_a_of_type_Axvu;
  protected axvw a;
  private bnnu jdField_a_of_type_Bnnu;
  private bnog jdField_a_of_type_Bnog;
  bnoj jdField_a_of_type_Bnoj;
  private bnok jdField_a_of_type_Bnok;
  private bnol jdField_a_of_type_Bnol;
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  protected DecodeConfig a;
  protected HWVideoDecoder a;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private PKFilter jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
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
  
  public bnnt()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Axvw = new axvw();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    if (this.jdField_a_of_type_Bnok != null) {
      this.jdField_a_of_type_Bnok.a();
    }
    if (this.jdField_a_of_type_Bnog != null) {
      this.jdField_a_of_type_Bnog.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.destroy();
    }
    if (this.jdField_a_of_type_Bnoj != null) {
      this.jdField_a_of_type_Bnoj.onSurfaceDestroy();
    }
    if (this.jdField_a_of_type_Bnol != null) {
      this.jdField_a_of_type_Bnol.a();
    }
  }
  
  public HWVideoDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 116
    //   3: invokestatic 122	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 124	bnnt:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 126	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   18: getfield 131	axvi:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   25: getfield 133	axvi:jdField_b_of_type_Int	I
    //   28: ldc 134
    //   30: invokespecial 137	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   33: putfield 139	bnnt:jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   36: aload_0
    //   37: new 126	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   40: dup
    //   41: aload_0
    //   42: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   45: getfield 131	axvi:jdField_a_of_type_Int	I
    //   48: aload_0
    //   49: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   52: getfield 133	axvi:jdField_b_of_type_Int	I
    //   55: ldc 134
    //   57: invokespecial 137	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   60: putfield 141	bnnt:jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   63: aload_0
    //   64: bipush 102
    //   66: invokestatic 146	bnnw:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   69: checkcast 79	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   72: putfield 77	bnnt:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   75: aload_0
    //   76: getfield 77	bnnt:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   79: aload_0
    //   80: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   83: getfield 131	axvi:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   90: getfield 133	axvi:jdField_b_of_type_Int	I
    //   93: invokevirtual 150	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   96: aload_0
    //   97: getfield 77	bnnt:jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   100: invokevirtual 153	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   103: aload_0
    //   104: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   107: getfield 160	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   110: ifeq +94 -> 204
    //   113: aload_0
    //   114: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   117: getfield 162	axvi:jdField_c_of_type_Boolean	Z
    //   120: ifeq +84 -> 204
    //   123: aload_0
    //   124: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   127: getfield 165	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   130: ifeq +825 -> 955
    //   133: bipush 166
    //   135: istore_1
    //   136: aload_0
    //   137: new 86	bnok
    //   140: dup
    //   141: iload_1
    //   142: invokespecial 168	bnok:<init>	(I)V
    //   145: putfield 84	bnnt:jdField_a_of_type_Bnok	Lbnok;
    //   148: aload_0
    //   149: getfield 84	bnnt:jdField_a_of_type_Bnok	Lbnok;
    //   152: aload_0
    //   153: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   156: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:width	I
    //   159: aload_0
    //   160: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   163: getfield 174	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:height	I
    //   166: aload_0
    //   167: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   170: getfield 131	axvi:jdField_a_of_type_Int	I
    //   173: aload_0
    //   174: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   177: getfield 133	axvi:jdField_b_of_type_Int	I
    //   180: invokevirtual 177	bnok:a	(IIII)V
    //   183: aload_0
    //   184: getfield 84	bnnt:jdField_a_of_type_Bnok	Lbnok;
    //   187: aload_0
    //   188: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   191: getfield 131	axvi:jdField_a_of_type_Int	I
    //   194: aload_0
    //   195: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   198: getfield 133	axvi:jdField_b_of_type_Int	I
    //   201: invokevirtual 179	bnok:a	(II)V
    //   204: aload_0
    //   205: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   208: getfield 181	axvi:jdField_f_of_type_Int	I
    //   211: invokestatic 184	bnnw:a	(I)Z
    //   214: ifne +13 -> 227
    //   217: aload_0
    //   218: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   221: getfield 187	axvi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   224: ifnull +112 -> 336
    //   227: aload_0
    //   228: new 92	bnog
    //   231: dup
    //   232: invokespecial 188	bnog:<init>	()V
    //   235: putfield 90	bnnt:jdField_a_of_type_Bnog	Lbnog;
    //   238: aload_0
    //   239: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   242: getfield 181	axvi:jdField_f_of_type_Int	I
    //   245: invokestatic 184	bnnw:a	(I)Z
    //   248: ifeq +20 -> 268
    //   251: aload_0
    //   252: getfield 90	bnnt:jdField_a_of_type_Bnog	Lbnog;
    //   255: aload_0
    //   256: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   259: getfield 181	axvi:jdField_f_of_type_Int	I
    //   262: invokestatic 146	bnnw:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   265: invokevirtual 191	bnog:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   268: aload_0
    //   269: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   272: getfield 187	axvi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   275: astore_2
    //   276: aload_2
    //   277: ifnull +31 -> 308
    //   280: bipush 106
    //   282: invokestatic 146	bnnw:a	(I)Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;
    //   285: astore_2
    //   286: aload_2
    //   287: checkcast 193	bnob
    //   290: aload_0
    //   291: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   294: getfield 187	axvi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   297: invokevirtual 196	bnob:a	(Ljava/lang/String;)V
    //   300: aload_0
    //   301: getfield 90	bnnt:jdField_a_of_type_Bnog	Lbnog;
    //   304: aload_2
    //   305: invokevirtual 191	bnog:a	(Lcom/tencent/ttpic/openapi/filter/GPUBaseFilter;)V
    //   308: aload_0
    //   309: getfield 90	bnnt:jdField_a_of_type_Bnog	Lbnog;
    //   312: aload_0
    //   313: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   316: getfield 131	axvi:jdField_a_of_type_Int	I
    //   319: aload_0
    //   320: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   323: getfield 133	axvi:jdField_b_of_type_Int	I
    //   326: invokevirtual 197	bnog:onOutputSizeChanged	(II)V
    //   329: aload_0
    //   330: getfield 90	bnnt:jdField_a_of_type_Bnog	Lbnog;
    //   333: invokevirtual 198	bnog:init	()V
    //   336: aload_0
    //   337: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   340: getfield 200	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   343: astore_2
    //   344: aload_2
    //   345: ifnull +126 -> 471
    //   348: aload_0
    //   349: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   352: getfield 200	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   355: invokestatic 206	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   358: astore_3
    //   359: aload_0
    //   360: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   363: getfield 160	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   366: ifeq +516 -> 882
    //   369: aload_3
    //   370: astore_2
    //   371: aload_0
    //   372: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   375: getfield 208	axvi:jdField_f_of_type_Boolean	Z
    //   378: ifeq +23 -> 401
    //   381: aload_3
    //   382: astore_2
    //   383: aload_3
    //   384: invokevirtual 214	android/graphics/Bitmap:getWidth	()I
    //   387: aload_3
    //   388: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   391: if_icmple +10 -> 401
    //   394: aload_3
    //   395: ldc 218
    //   397: invokestatic 223	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   400: astore_2
    //   401: aload_0
    //   402: sipush 3553
    //   405: aload_2
    //   406: invokestatic 226	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(ILandroid/graphics/Bitmap;)I
    //   409: putfield 64	bnnt:jdField_d_of_type_Int	I
    //   412: aload_0
    //   413: aload_2
    //   414: invokevirtual 214	android/graphics/Bitmap:getWidth	()I
    //   417: putfield 228	bnnt:jdField_e_of_type_Int	I
    //   420: aload_0
    //   421: aload_2
    //   422: invokevirtual 217	android/graphics/Bitmap:getHeight	()I
    //   425: putfield 229	bnnt:jdField_f_of_type_Int	I
    //   428: aload_2
    //   429: invokevirtual 232	android/graphics/Bitmap:recycle	()V
    //   432: aload_0
    //   433: new 97	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter
    //   436: dup
    //   437: invokespecial 233	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:<init>	()V
    //   440: putfield 95	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   443: aload_0
    //   444: getfield 95	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   447: aload_0
    //   448: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   451: getfield 131	axvi:jdField_a_of_type_Int	I
    //   454: aload_0
    //   455: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   458: getfield 133	axvi:jdField_b_of_type_Int	I
    //   461: invokevirtual 234	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:onOutputSizeChanged	(II)V
    //   464: aload_0
    //   465: getfield 95	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   468: invokevirtual 235	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:init	()V
    //   471: aload_0
    //   472: new 237	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager
    //   475: dup
    //   476: invokespecial 238	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:<init>	()V
    //   479: putfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   482: aload_0
    //   483: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   486: invokevirtual 244	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getChainBuilder	()Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder;
    //   489: astore_2
    //   490: aload_2
    //   491: iconst_1
    //   492: invokevirtual 250	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:setUseSort	(Z)V
    //   495: aload_0
    //   496: getfield 252	bnnt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   499: ifnull +20 -> 519
    //   502: aload_0
    //   503: getfield 252	bnnt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   506: invokevirtual 257	java/util/ArrayList:size	()I
    //   509: ifle +10 -> 519
    //   512: aload_2
    //   513: bipush 120
    //   515: aconst_null
    //   516: invokevirtual 261	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   519: aload_0
    //   520: getfield 263	bnnt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   523: ifnull +10 -> 533
    //   526: aload_2
    //   527: bipush 110
    //   529: aconst_null
    //   530: invokevirtual 261	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:addFilter	(ILjava/lang/Object;)V
    //   533: aload_2
    //   534: invokevirtual 266	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager$ChainBuilder:commit	()V
    //   537: aload_0
    //   538: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   541: invokevirtual 270	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   544: aload_0
    //   545: getfield 252	bnnt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   548: invokevirtual 276	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setDynamicStickerParam	(Ljava/util/List;)V
    //   551: aload_0
    //   552: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   555: invokevirtual 270	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   558: aload_0
    //   559: getfield 263	bnnt:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   562: invokevirtual 280	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setTrackerStickerParam	(Ljava/util/ArrayList;)V
    //   565: aload_0
    //   566: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   569: aload_0
    //   570: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   573: getfield 131	axvi:jdField_a_of_type_Int	I
    //   576: aload_0
    //   577: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   580: getfield 133	axvi:jdField_b_of_type_Int	I
    //   583: aload_0
    //   584: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   587: getfield 131	axvi:jdField_a_of_type_Int	I
    //   590: aload_0
    //   591: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   594: getfield 133	axvi:jdField_b_of_type_Int	I
    //   597: invokevirtual 283	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:surfaceCreate	(IIII)V
    //   600: aload_0
    //   601: getfield 285	bnnt:jdField_a_of_type_Bnnu	Lbnnu;
    //   604: ifnull +40 -> 644
    //   607: aload_0
    //   608: getfield 285	bnnt:jdField_a_of_type_Bnnu	Lbnnu;
    //   611: aload_0
    //   612: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   615: getfield 131	axvi:jdField_a_of_type_Int	I
    //   618: aload_0
    //   619: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   622: getfield 133	axvi:jdField_b_of_type_Int	I
    //   625: aload_0
    //   626: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   629: getfield 131	axvi:jdField_a_of_type_Int	I
    //   632: aload_0
    //   633: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   636: getfield 133	axvi:jdField_b_of_type_Int	I
    //   639: invokeinterface 288 5 0
    //   644: aload_0
    //   645: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   648: invokevirtual 270	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getBusinessOperation	()Lcom/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation;
    //   651: aload_0
    //   652: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   655: getfield 291	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:startTimeMillSecond	J
    //   658: invokevirtual 295	com/tencent/mobileqq/shortvideo/filter/FilterBusinessOperation:setVideoStartTime	(J)V
    //   661: aload_0
    //   662: getfield 297	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   665: ifnull +133 -> 798
    //   668: aload_0
    //   669: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   672: sipush 160
    //   675: invokevirtual 300	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:hasQQFilter	(I)Z
    //   678: ifne +272 -> 950
    //   681: aload_0
    //   682: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   685: sipush 160
    //   688: aconst_null
    //   689: invokevirtual 304	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:pushChainBasedStackTopChain	(ILjava/lang/Object;)Ljava/lang/String;
    //   692: pop
    //   693: aload_0
    //   694: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   697: sipush 160
    //   700: invokevirtual 308	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilterByType	(I)Lcom/tencent/mobileqq/shortvideo/filter/QQBaseFilter;
    //   703: checkcast 310	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   706: astore_2
    //   707: aload_2
    //   708: astore_3
    //   709: aload_2
    //   710: ifnonnull +62 -> 772
    //   713: aload_0
    //   714: getfield 240	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   717: sipush 160
    //   720: invokevirtual 314	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:getQQFilters	(I)Ljava/util/List;
    //   723: astore 4
    //   725: aload_2
    //   726: astore_3
    //   727: aload 4
    //   729: ifnull +43 -> 772
    //   732: aload_2
    //   733: astore_3
    //   734: aload 4
    //   736: invokeinterface 317 1 0
    //   741: ifle +31 -> 772
    //   744: aload_2
    //   745: astore_3
    //   746: aload 4
    //   748: iconst_0
    //   749: invokeinterface 321 2 0
    //   754: instanceof 310
    //   757: ifeq +15 -> 772
    //   760: aload 4
    //   762: iconst_0
    //   763: invokeinterface 321 2 0
    //   768: checkcast 310	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   771: astore_3
    //   772: aload_3
    //   773: ifnull +25 -> 798
    //   776: aload_3
    //   777: aload_0
    //   778: getfield 297	bnnt:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   781: invokevirtual 325	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setTransferData	(Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;)V
    //   784: aload_3
    //   785: aload_0
    //   786: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   789: getfield 328	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
    //   792: invokestatic 332	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:getSpeedRate	(I)F
    //   795: invokevirtual 336	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:setSpeedRate	(F)V
    //   798: aload_0
    //   799: getfield 74	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   802: aload_0
    //   803: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   806: aload_0
    //   807: getfield 124	bnnt:jdField_c_of_type_Int	I
    //   810: aload_0
    //   811: aload_0
    //   812: invokevirtual 340	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:startDecode	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;)V
    //   815: aload_0
    //   816: getfield 342	bnnt:jdField_a_of_type_Axvu	Laxvu;
    //   819: ifnull +141 -> 960
    //   822: aload_0
    //   823: getfield 342	bnnt:jdField_a_of_type_Axvu	Laxvu;
    //   826: invokeinterface 343 1 0
    //   831: return
    //   832: astore_2
    //   833: ldc_w 345
    //   836: iconst_1
    //   837: ldc_w 347
    //   840: aload_2
    //   841: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   844: goto -536 -> 308
    //   847: astore_2
    //   848: aload_0
    //   849: iconst_4
    //   850: aload_2
    //   851: invokevirtual 356	bnnt:a_	(ILjava/lang/Throwable;)V
    //   854: ldc_w 345
    //   857: iconst_1
    //   858: new 358	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 361
    //   868: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_2
    //   872: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: return
    //   882: aload_3
    //   883: sipush 360
    //   886: aload_0
    //   887: getfield 155	bnnt:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   890: getfield 378	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   893: isub
    //   894: i2f
    //   895: invokestatic 223	xsm:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   898: astore_2
    //   899: goto -498 -> 401
    //   902: astore_2
    //   903: invokestatic 382	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq +37 -> 943
    //   909: ldc_w 345
    //   912: iconst_2
    //   913: new 358	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   920: ldc_w 384
    //   923: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload_0
    //   927: getfield 128	bnnt:jdField_a_of_type_Axvi	Laxvi;
    //   930: getfield 200	axvi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   933: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: aload_2
    //   940: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   943: aload_0
    //   944: iconst_1
    //   945: aload_2
    //   946: invokevirtual 356	bnnt:a_	(ILjava/lang/Throwable;)V
    //   949: return
    //   950: aconst_null
    //   951: astore_2
    //   952: goto -245 -> 707
    //   955: iconst_0
    //   956: istore_1
    //   957: goto -821 -> 136
    //   960: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	this	bnnt
    //   135	822	1	i	int
    //   275	470	2	localObject1	Object
    //   832	9	2	localException1	Exception
    //   847	25	2	localException2	Exception
    //   898	1	2	localBitmap	android.graphics.Bitmap
    //   902	44	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   951	1	2	localObject2	Object
    //   358	525	3	localObject3	Object
    //   723	38	4	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   280	308	832	java/lang/Exception
    //   0	133	847	java/lang/Exception
    //   136	204	847	java/lang/Exception
    //   204	227	847	java/lang/Exception
    //   227	268	847	java/lang/Exception
    //   268	276	847	java/lang/Exception
    //   308	336	847	java/lang/Exception
    //   336	344	847	java/lang/Exception
    //   348	369	847	java/lang/Exception
    //   371	381	847	java/lang/Exception
    //   383	401	847	java/lang/Exception
    //   401	432	847	java/lang/Exception
    //   432	471	847	java/lang/Exception
    //   471	519	847	java/lang/Exception
    //   519	533	847	java/lang/Exception
    //   533	644	847	java/lang/Exception
    //   644	707	847	java/lang/Exception
    //   713	725	847	java/lang/Exception
    //   734	744	847	java/lang/Exception
    //   746	772	847	java/lang/Exception
    //   776	798	847	java/lang/Exception
    //   798	831	847	java/lang/Exception
    //   833	844	847	java/lang/Exception
    //   882	899	847	java/lang/Exception
    //   903	943	847	java/lang/Exception
    //   943	949	847	java/lang/Exception
    //   348	369	902	java/lang/OutOfMemoryError
    //   371	381	902	java/lang/OutOfMemoryError
    //   383	401	902	java/lang/OutOfMemoryError
    //   401	432	902	java/lang/OutOfMemoryError
    //   882	899	902	java/lang/OutOfMemoryError
  }
  
  public void a(DecodeConfig paramDecodeConfig, axvi paramaxvi, axvu paramaxvu, bnnu parambnnu)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_Axvi = paramaxvi;
    if ((paramDecodeConfig.speedType == 1) || (paramDecodeConfig.speedType == 3)) {
      this.jdField_e_of_type_Boolean = true;
    }
    if ((paramaxvi.jdField_d_of_type_Boolean) && (paramaxvi.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) && (!TextUtils.isEmpty(paramaxvi.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath)))
    {
      FeatureManager.loadBasicFeatures();
      bhrb.a();
      bkoq.a();
      VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
      BadcaseReportUtils.registerReport(new axpw());
    }
    this.jdField_a_of_type_Axvu = paramaxvu;
    this.jdField_a_of_type_Bnnu = parambnnu;
    this.jdField_a_of_type_Axvw.a(paramaxvi, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(PKFilter paramPKFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter = paramPKFilter;
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.deleteTexture(this.jdField_c_of_type_Int);
    d();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void a(ArrayList<DynamicStickerData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Axvw.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
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
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.fromJSONObject(paramString);
    }
  }
  
  public void b(ArrayList<TrackerStickerParam> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void c()
  {
    wxe.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Axvw.b();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = (paramInt + 10000);
    this.jdField_a_of_type_Axvw.b();
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.a_(this.jdField_a_of_type_Int, paramThrowable);
    }
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Axvw.b();
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
  
  public void onDecodeRepeat()
  {
    if ((this.jdField_a_of_type_Bnnu.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.onFilterDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
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
          a_(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
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
          Matrix.rotateM(arrayOfFloat2, 0, this.jdField_a_of_type_Axvi.h, 0.0F, 0.0F, 1.0F);
          Matrix.scaleM(arrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_c_of_type_Int, arrayOfFloat1, arrayOfFloat2);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          if (this.jdField_a_of_type_Axvi.jdField_d_of_type_Boolean)
          {
            paramSurfaceTexture.unbind();
            if (this.jdField_a_of_type_Bnoj == null)
            {
              this.jdField_a_of_type_Bnoj = new bnoj();
              this.jdField_a_of_type_Bnoj.a(this.jdField_a_of_type_Axvi.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
              this.jdField_a_of_type_Bnoj.a(this.jdField_a_of_type_Axvi.l, this.jdField_a_of_type_Axvi.m);
              this.jdField_a_of_type_Bnoj.onSurfaceCreate();
              this.jdField_a_of_type_Bnoj.onSurfaceChange(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int);
            }
            this.jdField_a_of_type_Bnoj.setInputTextureID(paramSurfaceTexture.getTexId());
            this.jdField_a_of_type_Bnoj.onDrawFrame();
            i = this.jdField_a_of_type_Bnoj.getOutputTextureID();
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.bind();
          }
          if (this.jdField_a_of_type_Axvi.jdField_e_of_type_Boolean)
          {
            if (this.jdField_a_of_type_Bnol == null)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.isLandscape) {
                break label1142;
              }
              i = -90;
              this.jdField_a_of_type_Bnol = new bnol(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Axvi.jdField_e_of_type_JavaLangString, i);
              this.jdField_a_of_type_Bnol.a(this.jdField_a_of_type_Axvi.l, this.jdField_a_of_type_Axvi.m, this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int);
            }
            i = this.jdField_a_of_type_Bnol.a(paramSurfaceTexture.getTexId());
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
          }
          if (this.jdField_a_of_type_Bnok != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Bnok.a(paramSurfaceTexture.getTexId());
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Bnnu != null)
          {
            paramSurfaceTexture.bind();
            i = this.jdField_a_of_type_Bnnu.a(paramSurfaceTexture.getTexId(), this.jdField_c_of_type_Long);
            if (i != -1) {
              paramSurfaceTexture.setTexId(i);
            }
            paramSurfaceTexture.unbind();
          }
          if (this.jdField_a_of_type_Bnog == null) {
            break label1139;
          }
          paramSurfaceTexture.bind();
          this.jdField_a_of_type_Bnog.drawTexture(paramSurfaceTexture.getTexId(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_Bnog.a();
          paramSurfaceTexture.unbind();
          paramSurfaceTexture.bind();
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null)
          {
            arrayOfFloat1 = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
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
            this.jdField_a_of_type_Axvw.a(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.jdField_c_of_type_Long);
            i = 1;
            if (i <= this.jdField_b_of_type_Int)
            {
              this.jdField_a_of_type_Axvw.a(3553, paramSurfaceTexture.getTexId(), null, arrayOfFloat1, this.jdField_c_of_type_Long + i * 5 * 1000);
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
      label1139:
      continue;
      label1142:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnt
 * JD-Core Version:    0.7.0.1
 */