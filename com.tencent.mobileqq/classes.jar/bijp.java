import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
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
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class bijp
  extends bijs
{
  private static SparseArray<VideoMaterial> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static final String jdField_a_of_type_JavaLangString = bijp.class.getSimpleName();
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  private static int o;
  private static int p;
  private biqu jdField_a_of_type_Biqu = new biqu();
  private bisb jdField_a_of_type_Bisb;
  private AEFilterManager.StickerInnerEffectFilterListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private CropFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int n = -1;
  private final int q;
  
  public bijp(int paramInt)
  {
    this.q = paramInt;
    f();
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
          break label129;
        }
        if (this.l != 180) {
          break label126;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap;
        if (this.jdField_a_of_type_Bijr == null) {
          continue;
        }
        this.jdField_a_of_type_Bijr.b(103);
        return;
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
      localBitmap = RendererUtils.saveTexture(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      if (this.jdField_a_of_type_Bijr != null) {
        this.jdField_a_of_type_Bijr.a(localBitmap);
      }
      return;
      label126:
      continue;
      label129:
      int i = paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = i;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramInt3, paramInt1, paramInt2, 0, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
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
  
  private void f()
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
      if (this.jdField_a_of_type_Bisb == null) {
        this.jdField_a_of_type_Bisb = new bisb();
      }
      return;
    }
    finally {}
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((!bkup.a().b()) || (!e()) || (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.canUseLargeImage())) {
      return false;
    }
    return true;
  }
  
  @MustRunOnGLThread
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.e, this.f);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.applyFilterChain(true, this.e, this.f);
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.e, this.f);
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
      i();
      h();
    }
    if (this.jdField_a_of_type_Bisb != null) {
      this.jdField_a_of_type_Bisb.a();
    }
    this.jdField_a_of_type_Biqu.a();
  }
  
  private void h()
  {
    Object localObject = a();
    if ((localObject != null) && (FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject)))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL((VideoMaterial)localObject);
      if (localObject == null) {
        break label93;
      }
    }
    label93:
    for (this.jdField_c_of_type_JavaLangString = ((VideoMaterial)localObject).getId();; this.jdField_c_of_type_JavaLangString = "none")
    {
      if (o > 0) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(o);
      }
      if (p > 0) {
        d(p);
      }
      if (jdField_b_of_type_Boolean)
      {
        localObject = FeatureManager.getResourceDir();
        if (AIManager.installDetector(PTSegmenter.class, (String)localObject, (String)localObject)) {
          b(jdField_b_of_type_Boolean);
        }
      }
      return;
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setParam("SET_ENABLE_ASYNC_INIT_FILTERS", Boolean.valueOf(true));
    int j = 100;
    Object localObject = bizj.a().a("app_alg_filter_timeout_id", "", 4);
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      i = Integer.parseInt((String)localObject);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setParam("SET_ENDURANCE_TIME", Integer.valueOf(i));
      bijo.a(this);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.e, this.f);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setStickerInnerLutFilterListener(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      LogUtils.setEnable(false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setOnMaterialLoadFinishListener(new bijq(this));
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
  
  public int a(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.i, this.j);
    return this.jdField_a_of_type_Bisb.a(localFrame).getTextureId();
  }
  
  public AEFilterManager a()
  {
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  }
  
  @Nullable
  public AESticker a()
  {
    AESticker localAESticker = null;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      localAESticker = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getmPTSticker();
    }
    return localAESticker;
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
    g();
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
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(paramInt5, paramInt6);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothSharpenSize(paramInt5, paramInt6);
    }
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.addMaskTouchPoint(paramPointF, paramInt);
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
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
      if (paramVideoMaterial == null) {
        break label46;
      }
    }
    label46:
    for (this.jdField_c_of_type_JavaLangString = paramVideoMaterial.getId();; this.jdField_c_of_type_JavaLangString = "none")
    {
      if (p > 0) {
        d(p);
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
  }
  
  public void a(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(paramString);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setFilterInSmooth(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    o = 0;
    p = 0;
    jdField_b_of_type_Boolean = false;
    if (paramBoolean) {
      b(null);
    }
  }
  
  public boolean a()
  {
    VideoMaterial localVideoMaterial = a();
    if (localVideoMaterial == null) {
      return false;
    }
    return localVideoMaterial.needFaceInfo();
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    if (!e())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      return this.jdField_a_of_type_ArrayOfInt;
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    Object localObject = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.k, this.g, this.h);
    if (biqu.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Biqu.a())
      {
        this.jdField_a_of_type_Biqu.c();
        this.g = this.jdField_a_of_type_Biqu.a();
        this.h = this.jdField_a_of_type_Biqu.b();
      }
      localObject = this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_Biqu.c(), this.e, this.f);
    }
    for (;;)
    {
      int i;
      int j;
      label226:
      Frame localFrame;
      if ((bool) && (f()))
      {
        bimt.a.jdField_a_of_type_Boolean = true;
        this.e = this.jdField_a_of_type_Int;
        this.f = this.jdField_b_of_type_Int;
        if (Math.abs(this.jdField_b_of_type_Double - this.jdField_a_of_type_Double) <= 0.01D) {
          break label571;
        }
        if (this.jdField_b_of_type_Double >= this.jdField_a_of_type_Double) {
          break label552;
        }
        i = this.h;
        j = (int)(i * this.jdField_b_of_type_Double);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.updateCorpRect(j, i, this.g, this.h);
        localFrame = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.RenderProcess(((Frame)localObject).getTextureId(), this.e, this.f);
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
          label552:
          label571:
          QLog.d(jdField_a_of_type_JavaLangString, 1, "AEKit 渲染 start Throwable = " + localThrowable.getMessage());
          continue;
          this.n = ((FaceStatus)localThrowable.getFaceStatusList().get(0)).gender;
          continue;
          bizg.a().a(-1);
          continue;
        }
        bizg.a().a(this.n);
        i = localFrame.getTextureId();
        if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setRotationMatrix(this.jdField_b_of_type_ArrayOfFloat);
          if (!this.jdField_c_of_type_Boolean) {
            biwd.a().a("filterMgrDraw-begin");
          }
          i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(localFrame.getTextureId(), bool, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTimestamp());
          if (!this.jdField_c_of_type_Boolean)
          {
            biwd.a().a("filterMgrDraw-end");
            this.jdField_c_of_type_Boolean = true;
          }
          localFrame.unlock();
        }
        b(paramInt1, paramInt2, i);
        if (bool)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "in capture frame.");
          a(i, this.e, this.f);
          this.jdField_a_of_type_Boolean = false;
        }
        FrameBufferCache.getInstance().forceRecycle();
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.e, this.f, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
        this.jdField_a_of_type_ArrayOfInt[0] = i;
        this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
        return this.jdField_a_of_type_ArrayOfInt;
        this.e = this.jdField_c_of_type_Int;
        this.f = this.d;
        break;
        j = this.g;
        i = (int)(j / this.jdField_b_of_type_Double);
        break label226;
        j = this.g;
        i = this.h;
        break label226;
        if (localList.size() <= 1) {
          continue;
        }
        this.n = 3;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.ClearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.ClearGLSL();
      this.jdField_b_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.ClearGLSL();
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
    if (this.jdField_a_of_type_Bisb != null)
    {
      this.jdField_a_of_type_Bisb.b();
      this.jdField_a_of_type_Bisb = null;
    }
    this.jdField_a_of_type_Biqu.b();
  }
  
  public void b(int paramInt)
  {
    p = paramInt;
    d(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    AEFilterProcessTex.2 local2 = new AEFilterProcessTex.2(this, paramBoolean);
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited()))
    {
      local2.run();
      return;
    }
    a(local2);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.detectedFace();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (a() != null)) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.stickerReset(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.needMaskRecordTouchPoint();
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((a() == null) && (o <= 0) && (p <= 0) && (jdField_b_of_type_JavaLangString == null)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijp
 * JD-Core Version:    0.7.0.1
 */