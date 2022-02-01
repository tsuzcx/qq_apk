import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.CropFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class bnaz
  extends bnbe
{
  private static SparseArray<VideoMaterial> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static String jdField_a_of_type_JavaLangString;
  private static boolean c;
  private static int o;
  private static int p;
  private bnbc jdField_a_of_type_Bnbc;
  private bnbd jdField_a_of_type_Bnbd;
  private bnkm jdField_a_of_type_Bnkm = new bnkm();
  private bnmd jdField_a_of_type_Bnmd;
  private AEFilterManager.StickerInnerEffectFilterListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private CropFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public volatile boolean a;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter;
  private String jdField_b_of_type_JavaLangString;
  private boolean d;
  private boolean e;
  private int n = -1;
  private final int q;
  
  public bnaz(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.q = paramInt;
    i();
  }
  
  @Nullable
  private VideoMaterial a()
  {
    return (VideoMaterial)jdField_a_of_type_AndroidUtilSparseArray.get(this.q);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        i = -((this.l - 90 + 360) % 360);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(i, 0, 0);
        if (this.l == 0) {
          break label140;
        }
        if (this.l != 180) {
          break label137;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap;
        if (this.jdField_a_of_type_Bnbb == null) {
          continue;
        }
        this.jdField_a_of_type_Bnbb.onCaptureError(103);
        return;
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
      localBitmap = RendererUtils.saveTexture(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      if (this.jdField_a_of_type_Bnbb != null) {
        this.jdField_a_of_type_Bnbb.onPhotoCaptured(localBitmap);
      }
      if (this.jdField_e_of_type_Boolean) {
        m();
      }
      return;
      label137:
      continue;
      label140:
      int i = paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = i;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
      GLES20.glClear(16384);
      GlUtil.setBlendModeSrcAlpha(true);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramInt3, paramInt1, paramInt2, 0, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    if (paramBoolean) {
      GlUtil.setBlendModeSrcAlpha(false);
    }
  }
  
  public static void a(int paramInt, VideoMaterial paramVideoMaterial)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoMaterial);
  }
  
  private void b(@Nullable VideoMaterial paramVideoMaterial)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(this.q, paramVideoMaterial);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, paramInt);
    }
  }
  
  private boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((!bpnj.a().b()) || (!f()) || (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.canUseLargeImage())) {
      return false;
    }
    return true;
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentFilterBaseFilter == null) {
        this.jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
      }
      if (this.jdField_b_of_type_ComTencentFilterBaseFilter == null) {
        this.jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = new CropFilter();
      }
      if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == null) {
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
      }
      if (this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame == null) {
        this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
      }
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
      }
      if (this.jdField_a_of_type_Bnmd == null) {
        this.jdField_a_of_type_Bnmd = new bnmd();
      }
      return;
    }
    finally {}
  }
  
  @MustRunOnGLThread
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.f);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.f);
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.f);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.apply();
    }
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null) {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    }
    if (this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame != null) {
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      l();
      k();
    }
    if (this.jdField_a_of_type_Bnmd != null) {
      this.jdField_a_of_type_Bnmd.a();
    }
    this.jdField_a_of_type_Bnkm.a();
  }
  
  private void k()
  {
    Object localObject = a();
    if ((localObject != null) && (FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject)))
    {
      bnrh.b("AEFilterProcessTex", "recoverLastEffect---id=" + ((VideoMaterial)localObject).getId());
      if (VideoMaterialUtil.isWatermarkEditable((VideoMaterial)localObject)) {
        break label124;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL((VideoMaterial)localObject);
      this.jdField_b_of_type_JavaLangString = ((VideoMaterial)localObject).getId();
    }
    for (;;)
    {
      if (o > 0) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(o);
      }
      if (p > 0) {
        d(p);
      }
      if (jdField_c_of_type_Boolean)
      {
        localObject = FeatureManager.getResourceDir();
        if (AIManager.installDetector(PTHumanSegmenter.class, (String)localObject, (String)localObject)) {
          c(jdField_c_of_type_Boolean);
        }
      }
      return;
      label124:
      bnrh.b("AEFilterProcessTex", "recoverLastEffect---is an editable watermark material");
      if (this.jdField_a_of_type_Bnbc != null) {
        this.jdField_a_of_type_Bnbc.recover((VideoMaterial)localObject);
      }
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setParam("SET_ENABLE_ASYNC_INIT_FILTERS", Boolean.valueOf(true));
    int j = 100;
    Object localObject = bnqu.a().a("app_alg_filter_timeout_id", "", 4);
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      i = Integer.parseInt((String)localObject);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setParam("SET_ENDURANCE_TIME", Integer.valueOf(i));
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_e_of_type_Int, this.f);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setStickerInnerLutFilterListener(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      LogUtils.setEnable(false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setOnMaterialLoadFinishListener(new bnba(this));
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 113, 108, 101, 111, 104, 102, 105, 103 });
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.EYE_LIGHTEN, 35);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.REMOVE_POUNCH, 40);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSegStrokeWidthInPixel(18.0F);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSegStrokeGapInPixel(1.0F);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSegStrokeColor(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSegBgColor(new float[] { 1.0F, 1.0F, 1.0F, 0.0F });
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(111, false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setmNeedGenderDetect(true);
      while ((this.jdField_a_of_type_JavaUtilQueue != null) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()))
      {
        localObject = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localObject != null) {
          ((Runnable)localObject).run();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getmPTSticker() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getmPTSticker().getVideoMateral() != null))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getmPTSticker().getVideoMateral().setSupportPause(true);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.onStickerStatusChange(true);
    }
  }
  
  public int a(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.i, this.j);
    return this.jdField_a_of_type_Bnmd.a(localFrame).getTextureId();
  }
  
  public AEFilterManager a()
  {
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  }
  
  public AIAttr a()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getAIAttr();
  }
  
  public void a()
  {
    j();
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setPhoneRoll(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    o = paramInt;
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(this.jdField_e_of_type_Int, this.f);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothSharpenSize(this.jdField_e_of_type_Int, this.f);
    }
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.addMaskTouchPoint(paramPointF, paramInt);
  }
  
  public void a(Handler paramHandler)
  {
    AETipsManager.getInstance().setUIHandler(paramHandler, this.jdField_e_of_type_Int, this.f, 0.1666666666666667D);
  }
  
  public void a(bnbc parambnbc)
  {
    this.jdField_a_of_type_Bnbc = parambnbc;
  }
  
  public void a(bnbd parambnbd)
  {
    this.jdField_a_of_type_Bnbd = parambnbd;
  }
  
  public void a(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener = paramStickerInnerEffectFilterListener;
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    b(paramVideoMaterial);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null) || (paramVideoMaterial.getId().equals(this.jdField_b_of_type_JavaLangString))) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
      this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
    }
    for (;;)
    {
      if (p > 0) {
        d(p);
      }
      return;
      label67:
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null))
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setFilterInSmooth(true);
        this.jdField_b_of_type_JavaLangString = "none";
      }
      else
      {
        bnrh.d("AEFilterProcessTex", "[setVideoMaterial] material is same");
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
          this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
        }
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(paramString);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setFilterInSmooth(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial() != null) && ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needFaceInfo()) || (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needBodyInfo()));
  }
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!f())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      return this.jdField_a_of_type_ArrayOfInt;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    Object localObject = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.k, this.g, this.h);
    if (bnkm.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Bnkm.a())
      {
        this.jdField_a_of_type_Bnkm.c();
        this.g = this.jdField_a_of_type_Bnkm.a();
        this.h = this.jdField_a_of_type_Bnkm.b();
      }
      localObject = this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_Bnkm.c(), this.jdField_e_of_type_Int, this.f);
    }
    for (;;)
    {
      int i;
      int j;
      label228:
      Frame localFrame;
      if ((bool) && (g()))
      {
        bnep.a.jdField_a_of_type_Boolean = true;
        this.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
        this.f = this.jdField_b_of_type_Int;
        if (Math.abs(this.jdField_b_of_type_Double - this.jdField_a_of_type_Double) <= 0.01D) {
          break label581;
        }
        if (this.jdField_b_of_type_Double >= this.jdField_a_of_type_Double) {
          break label561;
        }
        i = this.h;
        j = (int)(i * this.jdField_b_of_type_Double);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.updateCorpRect(j, i, this.g, this.h);
        localFrame = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.RenderProcess(((Frame)localObject).getTextureId(), this.jdField_e_of_type_Int, this.f);
        ((Frame)localObject).unlock();
      }
      for (;;)
      {
        try
        {
          localObject = (PTFaceAttr)this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getAIAttr().getFaceAttr();
          if (localObject == null) {
            continue;
          }
          localList = ((PTFaceAttr)localObject).getFaceStatusList();
          if ((localList != null) && (!localList.isEmpty())) {
            continue;
          }
          this.n = -1;
        }
        catch (Throwable localThrowable)
        {
          List localList;
          label561:
          label581:
          QLog.d("AEFilterProcessTex", 1, "AEKit 渲染 start Throwable = " + localThrowable.getMessage());
          continue;
          this.n = ((FaceStatus)localThrowable.getFaceStatusList().get(0)).gender;
          continue;
          bnqq.a().a(-1);
          continue;
        }
        bnqq.a().a(this.n);
        i = localFrame.getTextureId();
        if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setRotationMatrix(this.jdField_b_of_type_ArrayOfFloat);
          if (!this.jdField_d_of_type_Boolean) {
            bnqe.a().a("filterMgrDraw-begin");
          }
          i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(localFrame.getTextureId(), bool, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTimestamp());
          if (!this.jdField_d_of_type_Boolean)
          {
            bnqe.a().a("filterMgrDraw-end");
            this.jdField_d_of_type_Boolean = true;
          }
          localFrame.unlock();
        }
        a(paramInt1, paramInt2, i, paramBoolean);
        if (bool)
        {
          QLog.d("AEFilterProcessTex", 1, "in capture frame.");
          a(i, this.jdField_e_of_type_Int, this.f);
          this.jdField_b_of_type_Boolean = false;
        }
        FrameBufferCache.getInstance().forceRecycle();
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.jdField_e_of_type_Int, this.f, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
        this.jdField_a_of_type_ArrayOfInt[0] = i;
        this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
        return this.jdField_a_of_type_ArrayOfInt;
        this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
        this.f = this.jdField_d_of_type_Int;
        break;
        j = this.g;
        i = (int)(j / this.jdField_b_of_type_Double);
        break label228;
        j = this.g;
        i = this.h;
        break label228;
        if (localList.size() <= 1) {
          continue;
        }
        this.n = 3;
      }
    }
  }
  
  public void b()
  {
    AETipsManager.getInstance().checkVideoShowFaceView();
  }
  
  public void b(int paramInt)
  {
    p = paramInt;
    d(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    o = 0;
    p = 0;
    jdField_c_of_type_Boolean = false;
    if (paramBoolean) {
      b(null);
    }
  }
  
  public boolean b()
  {
    VideoMaterial localVideoMaterial = a();
    if (localVideoMaterial == null) {}
    while ((TextUtils.isEmpty(localVideoMaterial.getDataPath())) || (!localVideoMaterial.needFaceInfo())) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    AETipsManager.getInstance().checkVideoShowBodyView();
  }
  
  public void c(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
    AEFilterProcessTex.2 local2 = new AEFilterProcessTex.2(this, paramBoolean);
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited()))
    {
      local2.run();
      return;
    }
    a(local2);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.detectedFace();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.clearGLSL();
      this.jdField_b_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    if (this.jdField_a_of_type_Bnmd != null)
    {
      this.jdField_a_of_type_Bnmd.b();
      this.jdField_a_of_type_Bnmd = null;
    }
    this.jdField_a_of_type_Bnkm.b();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.needMaskRecordTouchPoint();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (a() != null)) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.stickerReset(true);
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((a() == null) && (o <= 0) && (p <= 0) && (jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    return true;
  }
  
  public void f()
  {
    try
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnaz
 * JD-Core Version:    0.7.0.1
 */