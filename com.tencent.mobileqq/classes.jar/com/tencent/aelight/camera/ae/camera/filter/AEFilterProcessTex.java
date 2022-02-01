package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.debug.AECameraDebug;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.gif.GifFilterMgr;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AELightLogger;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.CropFilter;
import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.light.DeviceCameraConfig;
import org.light.bean.WMElement;
import org.light.listener.LightAssetListener;
import org.light.utils.LightLogUtil;
import org.light.utils.TouchEventUtils;

public class AEFilterProcessTex
  extends FilterProcessBase
{
  private static SparseArray<VideoMaterial> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_c_of_type_Boolean;
  private static boolean e;
  private static int o = 0;
  private static int p = 0;
  private AEFilterManager.MaterialInnerEffectListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private AEFilterProcessTex.IEditableWatermarkMaterialRecover jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover;
  private ScaleFilter jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter;
  private AECameraDebug jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug = new AECameraDebug();
  private GifFilterMgr jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private CropFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
  private LightNode.ILightNodeTipsListener jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode$ILightNodeTipsListener;
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
  private ArrayList<PointF> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private LightAssetListener jdField_a_of_type_OrgLightListenerLightAssetListener;
  public volatile boolean a;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean f;
  private int n = -1;
  private final int q;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_c_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
  }
  
  public AEFilterProcessTex(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.q = paramInt;
    j();
    i();
  }
  
  @Nullable
  private VideoMaterial a()
  {
    return (VideoMaterial)jdField_a_of_type_AndroidUtilSparseArray.get(this.q);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      i = -((this.l - 90 + 360) % 360);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[captureFrame]:rotation = ");
      ((StringBuilder)localObject).append(i);
      AEQLog.a("AEFilterProcessTex", ((StringBuilder)localObject).toString());
      this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(i, 0, 0);
      if (this.l == 0) {
        break label178;
      }
      if (this.l != 180) {
        break label175;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject;
        continue;
        label175:
        continue;
        label178:
        int i = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = i;
      }
    }
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
    localObject = RendererUtils.saveTexture(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$CapturePhotoListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$CapturePhotoListener.onPhotoCaptured((Bitmap)localObject);
    }
    if (this.jdField_f_of_type_Boolean) {
      o();
    }
    return;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$CapturePhotoListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$CapturePhotoListener.onCaptureError(103);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      FrameUtil.clearFrame(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter.RenderProcess(paramInt3, paramInt1, paramInt1, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      paramInt3 = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
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
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, paramInt);
    }
  }
  
  private boolean h()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    boolean bool2 = false;
    if (localAEFilterManager == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (DovSVParamManager.a().a())
    {
      bool1 = bool2;
      if (g())
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.canUseLargeImage()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static void i()
  {
    if (jdField_e_of_type_Boolean) {
      return;
    }
    jdField_e_of_type_Boolean = true;
    LightLogUtil.initLogger(new AELightLogger());
    LightLogUtil.setMinPriority(6);
  }
  
  private void j()
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
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter = new ScaleFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
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
      if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr = new GifFilterMgr();
      }
      return;
    }
    finally {}
  }
  
  @MustRunOnGLThread
  private void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentFilterBaseFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
    if (localObject != null) {
      ((SpaceFilter)localObject).applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    localObject = this.jdField_b_of_type_ComTencentFilterBaseFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter;
    if (localObject != null) {
      ((ScaleFilter)localObject).apply();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
    if (localObject != null) {
      ((CropFilter)localObject).apply();
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      n();
      l();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr;
    if (localObject != null) {
      ((GifFilterMgr)localObject).a();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.a();
  }
  
  private void l()
  {
    if (a() != null)
    {
      VideoMaterial localVideoMaterial = VideoMaterial.loadLightAsset(a().getDataPath());
      if (FeatureManager.ensureMaterialSoLoaded(localVideoMaterial))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recoverLastEffect---id=");
        ((StringBuilder)localObject).append(localVideoMaterial.getId());
        AEQLog.b("AEFilterProcessTex", ((StringBuilder)localObject).toString());
        if (localVideoMaterial.isWatermarkMaterial())
        {
          AEQLog.b("AEFilterProcessTex", "recoverLastEffect---is an editable watermark material");
          localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover;
          if (localObject != null) {
            ((AEFilterProcessTex.IEditableWatermarkMaterialRecover)localObject).recover(localVideoMaterial);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(localVideoMaterial);
          this.jdField_b_of_type_JavaLangString = localVideoMaterial.getId();
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
    }
    int i = o;
    if (i > 0) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(i);
    }
    i = p;
    if (i > 0) {
      d(i);
    }
    if ((jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
      c(jdField_c_of_type_Boolean);
    }
  }
  
  private void m()
  {
    if (AEResUtil.a() != null)
    {
      Iterator localIterator = AEResUtil.a().keySet().iterator();
      while (localIterator.hasNext())
      {
        AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
        if ((AEResUtil.b(localAEResInfo)) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[injectBundlePathsToLight] agentType:");
          localStringBuilder.append(localAEResInfo.agentType);
          localStringBuilder.append(" | dir:");
          localStringBuilder.append(AEResUtil.c(localAEResInfo));
          QLog.d("AEFilterProcessTex", 2, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightBundle(AEResUtil.c(localAEResInfo), localAEResInfo.agentType);
        }
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setStickerInnerLutFilterListener(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener);
    LogUtils.setEnable(false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.EYE_LIGHTEN, 35);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.REMOVE_POUNCH, 40);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeTipsListener(new AEFilterProcessTex.1(this));
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeLightAssetListener(new AEFilterProcessTex.2(this));
    m();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setCustomMaterial(this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilQueue;
      if ((localObject == null) || (((Queue)localObject).isEmpty())) {
        break;
      }
      localObject = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
    }
  }
  
  private void o()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setStickerPause(true);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.onStickerStatusChange(true);
    }
  }
  
  public int a(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.i, this.j);
    return this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr.a(localFrame).getTextureId();
  }
  
  public AEFilterManager a()
  {
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  }
  
  public PTFaceAttr a()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return null;
    }
    return localAEFilterManager.getFaceAttr();
  }
  
  public void a()
  {
    k();
  }
  
  public void a(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.setPhoneRoll(paramFloat);
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
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateWidthHeight(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return;
    }
    localAEFilterManager.addMaskTouchPoint(paramPointF, paramInt);
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.setSensorEventToLight(paramSensorEvent);
    }
  }
  
  public void a(Handler paramHandler)
  {
    AETipsManager.getInstance().setUIHandler(paramHandler, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, 0.1666666666666667D);
  }
  
  public void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if ((i != 0) && (i != 1) && (i != 2) && (i != 5) && (i != 6)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int j = paramMotionEvent.getPointerCount();
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new PointF(paramMotionEvent.getX(i), paramMotionEvent.getY(i)));
        i += 1;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateTouchEvent(TouchEventUtils.getEventAction(paramMotionEvent), paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), this.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
    }
  }
  
  public void a(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener = paramMaterialInnerEffectListener;
  }
  
  public void a(AEFilterProcessTex.IEditableWatermarkMaterialRecover paramIEditableWatermarkMaterialRecover)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover = paramIEditableWatermarkMaterialRecover;
  }
  
  public void a(LightNode.ILightNodeTipsListener paramILightNodeTipsListener)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode$ILightNodeTipsListener = paramILightNodeTipsListener;
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    b(paramVideoMaterial);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      if ((paramVideoMaterial != null) && (paramVideoMaterial.getId() != null) && (!paramVideoMaterial.getId().equals(this.jdField_b_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
        this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
      }
      else if ((paramVideoMaterial != null) && (paramVideoMaterial.getId() != null))
      {
        AEQLog.d("AEFilterProcessTex", "[setVideoMaterial] material is same");
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
          this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
        this.jdField_b_of_type_JavaLangString = "none";
      }
    }
    int i = p;
    if (i > 0) {
      d(i);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
  }
  
  public void a(String paramString)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setCustomMaterial(paramString);
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(DeviceCameraConfig paramDeviceCameraConfig)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateDeviceCameraConfig(paramDeviceCameraConfig);
    }
  }
  
  public void a(LightAssetListener paramLightAssetListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLightNodeLightAssetListener: ");
    localStringBuilder.append(paramLightAssetListener);
    AEQLog.a("AEFilterProcessTex", localStringBuilder.toString());
    this.jdField_a_of_type_OrgLightListenerLightAssetListener = paramLightAssetListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    return (localAEFilterManager != null) && (localAEFilterManager.getVideoMaterial() != null) && ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needFaceInfo()) || (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needBodyDetect()));
  }
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!g())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      return this.jdField_a_of_type_ArrayOfInt;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
    Object localObject1 = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.k, this.g, this.h);
    if (AECameraDebug.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.a())
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.c();
        this.g = this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.a();
        this.h = this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.b();
      }
      localObject1 = this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.c(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    if ((bool) && (h()))
    {
      AEDashboardUtil.a.jdField_a_of_type_Boolean = true;
      this.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
    }
    else
    {
      this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_f_of_type_Int = this.jdField_d_of_type_Int;
    }
    if (this.jdField_d_of_type_JavaLangString != null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((WMElement)((Iterator)localObject3).next()).setText(this.jdField_d_of_type_JavaLangString);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apply watermark text success: ");
        ((StringBuilder)localObject3).append(this.jdField_d_of_type_JavaLangString);
        AEQLog.b("AEFilterProcessTex", ((StringBuilder)localObject3).toString());
        this.jdField_d_of_type_JavaLangString = null;
      }
      else
      {
        AEQLog.d("AEFilterProcessTex", "try apply watermark text, but found no WMElements");
      }
    }
    int j;
    if (Math.abs(this.jdField_b_of_type_Double - this.jdField_a_of_type_Double) > 0.01D)
    {
      double d1;
      double d2;
      if (this.jdField_b_of_type_Double < this.jdField_a_of_type_Double)
      {
        i = this.h;
        d1 = i;
        d2 = this.jdField_b_of_type_Double;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
      }
      else
      {
        j = this.g;
        d1 = j;
        d2 = this.jdField_b_of_type_Double;
        Double.isNaN(d1);
        i = (int)(d1 / d2);
      }
    }
    else
    {
      j = this.g;
      i = this.h;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.updateCorpRect(j, i, this.g, this.h);
    Object localObject3 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.RenderProcess(((Frame)localObject1).getTextureId(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    ((Frame)localObject1).unlock();
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.notifyDetectFaceAttr();
      if (localObject1 != null)
      {
        localObject4 = ((PTFaceAttr)localObject1).getFaceStatusList();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
        {
          if (((List)localObject4).size() > 1) {
            this.n = 3;
          } else {
            this.n = ((FaceStatus)((PTFaceAttr)localObject1).getFaceStatusList().get(0)).gender;
          }
        }
        else {
          this.n = -1;
        }
        AEBaseReportParam.a().a(this.n);
      }
      else
      {
        AEBaseReportParam.a().a(-1);
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("AEKit 渲染 start Throwable = ");
      ((StringBuilder)localObject4).append(localThrowable.getMessage());
      QLog.d("AEFilterProcessTex", 1, ((StringBuilder)localObject4).toString());
    }
    int i = ((Frame)localObject3).getTextureId();
    Object localObject2 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject2 != null)
    {
      ((AEFilterManager)localObject2).setRotationMatrix(this.jdField_b_of_type_ArrayOfFloat);
      if (!this.jdField_d_of_type_Boolean) {
        AELaunchRecorder.a().a("filterMgrDraw-begin");
      }
      localObject2 = new HashMap();
      if (paramBoolean) {
        ((HashMap)localObject2).put("transparentMode", "1");
      } else {
        ((HashMap)localObject2).put("transparentMode", "0");
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateCameraConfigData((Map)localObject2);
      i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(((Frame)localObject3).getTextureId(), bool, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTimestamp());
      if (!this.jdField_d_of_type_Boolean)
      {
        AELaunchRecorder.a().a("filterMgrDraw-end");
        this.jdField_d_of_type_Boolean = true;
      }
      ((Frame)localObject3).unlock();
    }
    a(paramInt1, paramInt2, i, paramBoolean);
    if (bool)
    {
      QLog.d("AEFilterProcessTex", 1, "in capture frame.");
      a(i, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_b_of_type_Boolean = false;
    }
    FrameBufferCache.getInstance().forceRecycle();
    this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
    this.jdField_a_of_type_ArrayOfInt[0] = i;
    this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b()
  {
    AETipsManager.getInstance().checkVideoShowFaceView();
  }
  
  public void b(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if ((localAEFilterManager != null) && (localAEFilterManager.currentMaterialNeedVoiceDecibel())) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateVoiceDecibel(paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    p = paramInt;
    d(paramInt);
  }
  
  public void b(@Nullable String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
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
    boolean bool2 = false;
    if (localVideoMaterial == null)
    {
      AEQLog.a("AEFilterProcessTex", "[isNeedFaceDetect]: false");
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(localVideoMaterial.getDataPath()))
    {
      bool1 = bool2;
      if (localVideoMaterial.needFaceInfo()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    AETipsManager.getInstance().checkVideoShowBodyView();
  }
  
  public void c(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateLutGL(paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
    AEFilterProcessTex.3 local3 = new AEFilterProcessTex.3(this, paramBoolean);
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if ((localAEFilterManager != null) && (localAEFilterManager.isInited()))
    {
      local3.run();
      return;
    }
    a(local3);
  }
  
  public boolean c()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return false;
    }
    return AEStaticDetector.hasFaceData(localAEFilterManager.getFaceAttr());
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentFilterBaseFilter;
    if (localObject != null)
    {
      ((BaseFilter)localObject).clearGLSL();
      this.jdField_a_of_type_ComTencentFilterBaseFilter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
    if (localObject != null)
    {
      ((SpaceFilter)localObject).clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = null;
    }
    localObject = this.jdField_b_of_type_ComTencentFilterBaseFilter;
    if (localObject != null)
    {
      ((BaseFilter)localObject).clearGLSL();
      this.jdField_b_of_type_ComTencentFilterBaseFilter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraFilterScaleFilter;
    if (localObject != null) {
      ((ScaleFilter)localObject).clearGLSLSelf();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
    if (localObject != null)
    {
      ((CropFilter)localObject).clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    localObject = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr;
    if (localObject != null)
    {
      ((GifFilterMgr)localObject).b();
      this.jdField_a_of_type_ComTencentAelightCameraAeGifGifFilterMgr = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeDebugAECameraDebug.b();
  }
  
  public void d(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.switchAbilityInLightNode("stroke.segmentFollowFace", paramBoolean);
    }
  }
  
  public boolean d()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return false;
    }
    return localAEFilterManager.needMaskRecordTouchPoint();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (a() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needResetWhenRecord())) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.stickerReset(true);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null) {
      localAEFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public boolean e()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return false;
    }
    return localAEFilterManager.currentMaterialNeedTouchTriggerEvent();
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
  
  public boolean f()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    boolean bool = false;
    if (localAEFilterManager == null) {
      return false;
    }
    if ((a() != null) || (o > 0) || (p > 0) || (jdField_a_of_type_JavaLangString != null)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex
 * JD-Core Version:    0.7.0.1
 */