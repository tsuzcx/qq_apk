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
import com.tencent.aelight.camera.ae.camera.autotest.AEFilterManagerParamsListener;
import com.tencent.aelight.camera.ae.camera.autotest.AutoImageTestManager;
import com.tencent.aelight.camera.ae.camera.autotest.TestCameraFilterConfig;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGenderTypeListener;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater;
import com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.OPERATION_ENUM;
import com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater.OperationRecoveryInfo;
import com.tencent.aelight.camera.ae.debug.AECameraDebug;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.gif.GifFilterMgr;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.third.AELightLogger;
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
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.DeviceCameraConfig;
import org.light.bean.WMElement;
import org.light.listener.LightAssetListener;
import org.light.utils.LightLogUtil;
import org.light.utils.TouchEventUtils;

public class AEFilterProcessTex
  extends FilterProcessBase
{
  private static SparseArray<VideoMaterial> M = new SparseArray();
  private static int N = 0;
  private static int O = 0;
  private static String P = null;
  private static boolean Q = false;
  private static boolean W = false;
  private Frame A;
  private Frame B;
  private BaseFilter C;
  private BaseFilter D;
  private ScaleFilter E;
  private SpaceFilter F;
  private CropFilter G;
  private GifFilterMgr H;
  private Queue<Runnable> I = new ArrayDeque();
  private AEFilterConfig J;
  private AEFilterProcessTex.IGetOriginListener K = null;
  private boolean L = false;
  private AECameraDebug R = new AECameraDebug();
  private final int S;
  private String T;
  private boolean U = false;
  private Set<String> V = new HashSet();
  private boolean X = true;
  private AEFilterProcessTex.IEditableWatermarkMaterialRecover Y;
  private LightNode.ILightNodeTipsListener Z;
  public volatile boolean a = true;
  private LightAssetListener aa;
  private AECameraGLSurfaceView.AEGenderTypeListener ab;
  private String ac;
  private AutoImageTestManager ad = null;
  private final ArrayList<PointF> ae = new ArrayList();
  private String af = "";
  private boolean ag = false;
  private boolean ah = false;
  private boolean ai = false;
  private boolean aj = false;
  private Bitmap ak = null;
  private AIOOperationUpdater al;
  private AIOOperationUpdater am;
  private AEFilterManager.MaterialInnerEffectListener an;
  private AEFilterManager z;
  
  public AEFilterProcessTex(int paramInt, AEFilterConfig paramAEFilterConfig)
  {
    this.S = paramInt;
    this.J = paramAEFilterConfig;
    w();
    v();
  }
  
  private void A()
  {
    this.z.initInGL(this.f, this.g);
    this.z.setStickerInnerLutFilterListener(this.an);
    LogUtils.setEnable(false);
    Object localObject = this.J.f().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      this.z.setBeautyOrTransformLevel((BeautyRealConfig.TYPE)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("smooth.curveAdjustAlpha", "0");
    this.z.updateCameraConfigData((Map)localObject);
    if (this.J.c())
    {
      this.z.switchAbilityInLightNode("ai.gender.enable", true);
      this.ag = true;
      this.ah = true;
    }
    if (this.J.d())
    {
      this.z.switchAbilityInLightNode("ai.age.enable", true);
      this.ai = true;
      this.aj = true;
    }
    this.z.setExposureValue(50);
    this.z.setLightNodeTipsListener(new AEFilterProcessTex.1(this));
    this.z.setLightNodeLightAssetListener(new AEFilterProcessTex.2(this));
    z();
    for (;;)
    {
      localObject = this.I;
      if ((localObject == null) || (((Queue)localObject).isEmpty())) {
        break;
      }
      localObject = (Runnable)this.I.poll();
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
    }
  }
  
  private boolean B()
  {
    AEFilterManager localAEFilterManager = this.z;
    boolean bool2 = false;
    if (localAEFilterManager == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (DovSVParamManager.a().c())
    {
      bool1 = bool2;
      if (s())
      {
        bool1 = bool2;
        if (this.z.canUseLargeImage()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void C()
  {
    this.o[0] = this.f;
    this.o[1] = this.g;
    if (this.g * 9 > this.f * 16)
    {
      this.o[1] = (this.f * 16 / 9);
      return;
    }
    if (this.g * 9 < this.f * 16) {
      this.o[0] = (this.g * 9 / 16);
    }
  }
  
  private void D()
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.setStickerPause(true);
      this.z.onStickerStatusChange(true);
    }
  }
  
  @Nullable
  private VideoMaterial E()
  {
    return (VideoMaterial)M.get(this.S);
  }
  
  private Frame F()
  {
    Object localObject;
    if (AECameraDebug.b)
    {
      G();
      localObject = this.ad;
      if (localObject == null) {
        return null;
      }
      AECameraDebug.e = ((AutoImageTestManager)localObject).a();
      if (this.ad.b() == null) {
        return null;
      }
      AECameraDebug.d = this.ad.b();
      AECameraDebug.c = this.ad.c();
    }
    this.R.a(AECameraDebug.e ^ true);
    if (!this.R.i())
    {
      this.R.e();
      this.h = this.R.f();
      this.i = this.R.g();
      if ((this.f != this.h) || (this.g != this.i))
      {
        localObject = this.z;
        if (localObject != null) {
          ((AEFilterManager)localObject).updateWidthHeight(this.h, this.i);
        }
      }
      this.f = this.h;
      this.g = this.i;
    }
    this.D.setRotationAndFlip(0, 0, 1);
    return this.D.RenderProcess(this.R.h(), this.f, this.g);
  }
  
  private void G()
  {
    if (this.ad == null)
    {
      this.ad = TestCameraFilterConfig.a().c();
      AutoImageTestManager localAutoImageTestManager = this.ad;
      if (localAutoImageTestManager != null) {
        localAutoImageTestManager.a(new AEFilterManagerParamsListener(this.z));
      }
    }
  }
  
  private void H()
  {
    AIOOperationUpdater localAIOOperationUpdater = this.am;
    if (localAIOOperationUpdater == null) {
      return;
    }
    localAIOOperationUpdater.a(this);
    if (this.am.a()) {
      this.am = null;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 * paramInt3 == paramInt5 * paramInt2) {
      return paramInt1;
    }
    this.G.updateCorpRect(paramInt4, paramInt5, paramInt2, paramInt3);
    return this.G.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5).getTextureId();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      i = -((this.v - 90 + 360) % 360);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[captureFrame]:rotation = ");
      ((StringBuilder)localObject).append(i);
      AEQLog.a("AEFilterProcessTex", ((StringBuilder)localObject).toString());
      this.D.setRotationAndFlip(i, 0, 0);
      if (this.v == 0) {
        break label180;
      }
      if (this.v != 180) {
        break label177;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject;
        continue;
        label177:
        continue;
        label180:
        int i = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = i;
      }
    }
    this.D.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.B);
    this.D.setRotationAndFlip(0, 0, 0);
    localObject = RendererUtils.saveTexture(this.B);
    if (this.w != null) {
      this.w.onPhotoCaptured((Bitmap)localObject);
    }
    if (this.X) {
      D();
    }
    return;
    if (this.w != null) {
      this.w.onCaptureError(103);
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
      FrameUtil.clearFrame(this.A, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt2);
      this.E.RenderProcess(paramInt3, paramInt1, paramInt1, -1, 0.0D, this.A);
      paramInt3 = this.A.getTextureId();
    }
    this.F.setRotationAndFlip(0, 0, 1);
    this.F.RenderProcess(paramInt3, paramInt1, paramInt2, 0, 0.0D, this.A);
    if (paramBoolean) {
      GlUtil.setBlendModeSrcAlpha(false);
    }
  }
  
  public static void a(int paramInt, VideoMaterial paramVideoMaterial)
  {
    M.put(paramInt, paramVideoMaterial);
  }
  
  private void a(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    AIOOperationUpdater localAIOOperationUpdater = this.al;
    if (localAIOOperationUpdater == null) {
      return;
    }
    localAIOOperationUpdater.a(paramOPERATION_ENUM);
  }
  
  private boolean a(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM, String paramString, int paramInt1, int paramInt2)
  {
    if (c(paramOPERATION_ENUM)) {
      return true;
    }
    this.am.a(paramOPERATION_ENUM, new AIOOperationUpdater.OperationRecoveryInfo(paramString, paramInt1, paramInt2));
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSizeDY previewWidth: ");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append(" previewHeight: ");
    localStringBuilder.append(paramInt6);
    localStringBuilder.append(",viewWidth:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",viewHeight:");
    localStringBuilder.append(paramInt2);
    AEQLog.b("AEFilterProcessTex", localStringBuilder.toString());
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.m = (d1 / d2);
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      this.h = paramInt3;
      this.i = paramInt4;
      d1 = this.h;
      d2 = this.i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.l = (d1 / d2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSizeDY cameraWidth: ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" cameraHeight: ");
      localStringBuilder.append(this.i);
      AEQLog.b("AEFilterProcessTex", localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSizeDY mCameraAspectRatio: ");
    localStringBuilder.append(this.l);
    AEQLog.b("AEFilterProcessTex", localStringBuilder.toString());
    this.d = paramInt5;
    d1 = this.d;
    d2 = this.m;
    Double.isNaN(d1);
    this.e = ((int)(d1 / d2));
    this.f = paramInt5;
    if (this.l > 1.E-005D)
    {
      d1 = this.f;
      d2 = this.l;
      Double.isNaN(d1);
      this.g = ((int)(d1 / d2));
      if (this.f > this.g * 9 / 16)
      {
        paramInt2 = this.f * 16 / 9;
        paramInt1 = paramInt2;
        if (paramInt2 > paramInt4)
        {
          paramInt1 = paramInt2;
          if (paramInt4 > 0) {
            paramInt1 = paramInt4;
          }
        }
        this.g = paramInt1;
        d1 = paramInt1;
        d2 = this.l;
        Double.isNaN(d1);
        this.f = ((int)(d1 * d2));
      }
    }
    else
    {
      this.g = paramInt6;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSizeDY this.previewWidth: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",this.previewHeight:");
    localStringBuilder.append(this.g);
    AEQLog.b("AEFilterProcessTex", localStringBuilder.toString());
    this.b = 1080;
    d1 = this.b;
    d2 = this.f;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = this.g;
    Double.isNaN(d2);
    this.c = ((int)(d1 * d2));
    C();
  }
  
  private void b(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    AIOOperationUpdater localAIOOperationUpdater = this.am;
    if (localAIOOperationUpdater == null) {
      return;
    }
    localAIOOperationUpdater.c(paramOPERATION_ENUM);
  }
  
  private void b(@Nullable VideoMaterial paramVideoMaterial)
  {
    M.put(this.S, paramVideoMaterial);
  }
  
  private boolean c(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    AIOOperationUpdater localAIOOperationUpdater = this.am;
    return (localAIOOperationUpdater == null) || (localAIOOperationUpdater.b(paramOPERATION_ENUM));
  }
  
  private void e(String paramString)
  {
    AIOOperationUpdater localAIOOperationUpdater = this.al;
    if (localAIOOperationUpdater == null) {
      return;
    }
    localAIOOperationUpdater.a(paramString);
  }
  
  private void f(int paramInt)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, paramInt);
    }
  }
  
  private static void v()
  {
    if (W) {
      return;
    }
    W = true;
    LightLogUtil.initLogger(new AELightLogger());
    LightLogUtil.setMinPriority(6);
  }
  
  private void w()
  {
    try
    {
      if (this.C == null) {
        this.C = new SurfaceTextureFilter();
      }
      if (this.F == null) {
        this.F = new SpaceFilter();
      }
      if (this.D == null) {
        this.D = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.E == null) {
        this.E = new ScaleFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.G == null) {
        this.G = new CropFilter();
      }
      if (this.A == null) {
        this.A = new Frame();
      }
      if (this.B == null) {
        this.B = new Frame();
      }
      if (this.z == null) {
        this.z = new AEFilterManager(this.J.a(), this.J.b(), true, null, true);
      }
      if (this.H == null) {
        this.H = new GifFilterMgr();
      }
      return;
    }
    finally {}
  }
  
  @MustRunOnGLThread
  private void x()
  {
    Object localObject = this.C;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(true, this.f, this.g);
    }
    localObject = this.F;
    if (localObject != null) {
      ((SpaceFilter)localObject).applyFilterChain(true, this.f, this.g);
    }
    localObject = this.D;
    if (localObject != null) {
      ((BaseFilter)localObject).applyFilterChain(true, this.f, this.g);
    }
    localObject = this.E;
    if (localObject != null) {
      ((ScaleFilter)localObject).apply();
    }
    localObject = this.G;
    if (localObject != null) {
      ((CropFilter)localObject).apply();
    }
    if (this.z != null)
    {
      A();
      y();
    }
    localObject = this.H;
    if (localObject != null) {
      ((GifFilterMgr)localObject).a();
    }
    this.R.c();
  }
  
  private void y()
  {
    if (c(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION))
    {
      b(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
      e();
    }
  }
  
  private void z()
  {
    if (AEResUtil.a() != null)
    {
      Iterator localIterator = AEResUtil.a().keySet().iterator();
      while (localIterator.hasNext())
      {
        AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
        if ((AEResUtil.d(localAEResInfo)) && (this.z != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[injectBundlePathsToLight] agentType:");
          localStringBuilder.append(localAEResInfo.agentType);
          localStringBuilder.append(" | dir:");
          localStringBuilder.append(AEResUtil.f(localAEResInfo));
          QLog.d("AEFilterProcessTex", 2, localStringBuilder.toString());
          this.z.setLightBundle(AEResUtil.f(localAEResInfo), localAEResInfo.agentType);
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.j, this.k);
    return this.H.a(localFrame).getTextureId();
  }
  
  public void a()
  {
    x();
  }
  
  public void a(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setPhoneRoll(paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (t()) {
      b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    } else {
      super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateWidthHeight(this.f, this.g);
    }
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager == null) {
      return;
    }
    localAEFilterManager.addMaskTouchPoint(paramPointF, paramInt);
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setSensorEventToLight(paramSensorEvent);
    }
  }
  
  public void a(Handler paramHandler)
  {
    AETipsManager.getInstance().setUIHandler(paramHandler, this.d, this.e, 0.1666666666666667D);
  }
  
  public void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if (this.z != null)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if ((i != 0) && (i != 1) && (i != 2) && (i != 5) && (i != 6)) {
        return;
      }
      this.ae.clear();
      int j = paramMotionEvent.getPointerCount();
      i = 0;
      while (i < j)
      {
        this.ae.add(new PointF(paramMotionEvent.getX(i), paramMotionEvent.getY(i)));
        i += 1;
      }
      this.z.updateTouchEvent(TouchEventUtils.getEventAction(paramMotionEvent), paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), this.ae, paramInt1, paramInt2);
    }
  }
  
  public void a(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.an = paramMaterialInnerEffectListener;
  }
  
  public void a(AECameraGLSurfaceView.AEGenderTypeListener paramAEGenderTypeListener)
  {
    this.ab = paramAEGenderTypeListener;
  }
  
  public void a(AEFilterProcessTex.IEditableWatermarkMaterialRecover paramIEditableWatermarkMaterialRecover)
  {
    this.Y = paramIEditableWatermarkMaterialRecover;
  }
  
  public void a(AEFilterProcessTex.IGetOriginListener paramIGetOriginListener)
  {
    this.K = paramIGetOriginListener;
  }
  
  public void a(AIOOperationUpdater paramAIOOperationUpdater1, AIOOperationUpdater paramAIOOperationUpdater2)
  {
    this.al = paramAIOOperationUpdater1;
    this.am = paramAIOOperationUpdater2;
  }
  
  public void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setBeautyOrTransformLevel(paramTYPE, paramInt);
    }
  }
  
  public void a(LightNode.ILightNodeTipsListener paramILightNodeTipsListener)
  {
    this.Z = paramILightNodeTipsListener;
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    a(paramVideoMaterial, false);
  }
  
  public void a(VideoMaterial paramVideoMaterial, boolean paramBoolean)
  {
    b(paramVideoMaterial);
    if (this.z != null) {
      if ((paramVideoMaterial != null) && (paramVideoMaterial.getId() != null) && ((paramBoolean) || (!paramVideoMaterial.getId().equals(this.T))))
      {
        this.z.updateMaterialGL(paramVideoMaterial);
        a(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
        this.T = paramVideoMaterial.getId();
      }
      else if ((paramVideoMaterial != null) && (paramVideoMaterial.getId() != null))
      {
        AEQLog.d("AEFilterProcessTex", "[setVideoMaterial] material is same");
        if ((!TextUtils.isEmpty(this.T)) && (this.V.contains(this.T)))
        {
          this.z.updateMaterialGL(paramVideoMaterial);
          a(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
          this.T = paramVideoMaterial.getId();
        }
      }
      else
      {
        this.z.updateMaterialGL(paramVideoMaterial);
        a(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
        this.T = "none";
      }
    }
    int i = O;
    if (i > 0) {
      f(i);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.I.offer(paramRunnable);
  }
  
  public void a(String paramString)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setCustomMaterial(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!a(AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION, paramString, paramInt, 0)) {
      return;
    }
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.openAndUpdateBasicMultiply(paramString, paramInt);
      a(AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION);
    }
    b(AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!a(AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION, paramString, paramInt1, paramInt2)) {
      return;
    }
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.openAndUpdateBasicLips(paramString, paramInt1, paramInt2);
      a(AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION);
    }
    b(AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION);
  }
  
  public void a(DeviceCameraConfig paramDeviceCameraConfig)
  {
    AEFilterManager localAEFilterManager = this.z;
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
    this.aa = paramLightAssetListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!s())
    {
      this.s[0] = 0;
      this.s[1] = 0;
      return this.s;
    }
    H();
    boolean bool1 = this.u;
    this.C.updateMatrix(this.t);
    Object localObject3 = this.C.RenderProcess(this.q, this.h, this.i);
    boolean bool2 = AECameraDebug.a;
    Object localObject1 = localObject3;
    Object localObject4;
    if (bool2)
    {
      localObject4 = F();
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = localObject4;
      }
    }
    if ((!bool2) && (bool1) && (B()))
    {
      AEDashboardUtil.a.o = true;
      this.f = this.b;
      this.g = this.c;
    }
    if (this.ac != null)
    {
      localObject3 = this.z.wmGetEditableWMElements();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((WMElement)((Iterator)localObject3).next()).setText(this.ac);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apply watermark text success: ");
        ((StringBuilder)localObject3).append(this.ac);
        AEQLog.b("AEFilterProcessTex", ((StringBuilder)localObject3).toString());
        this.ac = null;
      }
      else
      {
        AEQLog.d("AEFilterProcessTex", "try apply watermark text, but found no WMElements");
      }
    }
    if (bool2)
    {
      i = this.h;
      j = this.i;
    }
    else if ((!t()) && (Math.abs(this.m - this.l) > 0.01D))
    {
      double d1;
      double d2;
      if (this.m < this.l)
      {
        j = this.i;
        d1 = j;
        d2 = this.m;
        Double.isNaN(d1);
        i = (int)(d1 * d2);
      }
      else
      {
        i = this.h;
        d1 = i;
        d2 = this.m;
        Double.isNaN(d1);
        j = (int)(d1 / d2);
      }
    }
    else
    {
      i = this.h;
      j = this.i;
    }
    this.G.updateCorpRect(i, j, this.h, this.i);
    localObject3 = this.G.RenderProcess(((Frame)localObject1).getTextureId(), this.f, this.g);
    ((Frame)localObject1).unlock();
    try
    {
      localObject1 = this.z.notifyDetectFaceAttr();
      j = -1;
      Object localObject5;
      if (localObject1 != null)
      {
        localObject4 = ((PTFaceAttr)localObject1).getGenderList();
        if ((localObject4 != null) && (((List)localObject4).size() > 0))
        {
          localObject4 = (Integer)((List)localObject4).get(0);
          if ((this.ab != null) && (((Integer)localObject4).intValue() > 0))
          {
            this.ab.onGenderTypeListener(((Integer)localObject4).intValue());
            if (!this.J.c())
            {
              boolean bool3 = this.ag;
              if (bool3)
              {
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("genderType:");
                ((StringBuilder)localObject5).append(localObject4);
                LogUtils.i("AEFilterProcessTex", ((StringBuilder)localObject5).toString());
                this.z.switchAbilityInLightNode("ai.gender.enable", false);
                this.ag = false;
              }
              else if (this.ah)
              {
                LogUtils.i("AEFilterProcessTex", "set genderType: NONE...");
                this.z.switchAIAbility("ai.gender.enable", "none");
                this.ah = false;
              }
            }
          }
        }
        localObject4 = ((PTFaceAttr)localObject1).getFaceStatusList();
        i = j;
        if (localObject4 != null) {
          if (((List)localObject4).isEmpty()) {
            i = j;
          } else if (((List)localObject4).size() > 1) {
            i = 3;
          } else {
            i = ((FaceStatus)((PTFaceAttr)localObject1).getFaceStatusList().get(0)).gender;
          }
        }
        AEBaseReportParam.a().b(i);
      }
      else
      {
        AEBaseReportParam.a().b(-1);
      }
      if ((localObject1 != null) && (!this.L))
      {
        localObject4 = ((PTFaceAttr)localObject1).getGenderList();
        localObject1 = ((PTFaceAttr)localObject1).getAgeList();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("first get face data: genderList=");
        ((StringBuilder)localObject5).append(localObject4);
        ((StringBuilder)localObject5).append("\nageList=");
        ((StringBuilder)localObject5).append(localObject1);
        AEQLog.a("AEFilterProcessTex", ((StringBuilder)localObject5).toString());
        if ((localObject4 != null) && (localObject1 != null) && (((List)localObject4).size() == ((List)localObject1).size()) && (((List)localObject4).size() > 0) && (((Integer)((List)localObject4).get(0)).intValue() != 0))
        {
          this.L = true;
          localObject5 = new JSONArray();
          i = 0;
          while (i < ((List)localObject4).size())
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("ai_beauty_gender", ((List)localObject4).get(i));
            localJSONObject.put("ai_beauty_age", ((List)localObject1).get(i));
            ((JSONArray)localObject5).put(localJSONObject);
            i += 1;
          }
          localObject1 = ((JSONArray)localObject5).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("setAiBeautyFaceInfo: ");
          ((StringBuilder)localObject4).append((String)localObject1);
          AEQLog.b("AEFilterProcessTex", ((StringBuilder)localObject4).toString());
          AEBaseReportParam.a().p((String)localObject1);
          AEBaseDataReporter.a().aY();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("AEKit 渲染 start Throwable = ");
      ((StringBuilder)localObject4).append(localThrowable.getMessage());
      QLog.d("AEFilterProcessTex", 1, ((StringBuilder)localObject4).toString());
    }
    int i = ((Frame)localObject3).getTextureId();
    Object localObject2 = this.z;
    if (localObject2 != null)
    {
      ((AEFilterManager)localObject2).setRotationMatrix(this.y);
      if (!this.U) {
        AELaunchRecorder.d().a("filterMgrDraw-begin");
      }
      localObject4 = new HashMap();
      if (paramBoolean) {
        localObject2 = "1";
      } else {
        localObject2 = "0";
      }
      if (!((String)localObject2).equals(this.af))
      {
        this.af = ((String)localObject2);
        ((HashMap)localObject4).put("transparentMode", localObject2);
      }
      this.z.updateCameraConfigData((Map)localObject4);
      i = this.z.drawFrame(((Frame)localObject3).getTextureId(), bool1, this.r.getTimestamp());
      if (!this.U)
      {
        AELaunchRecorder.d().a("filterMgrDraw-end");
        this.U = true;
      }
      ((Frame)localObject3).unlock();
    }
    if (bool2)
    {
      localObject2 = this.ad;
      if (localObject2 != null) {
        ((AutoImageTestManager)localObject2).a(i, this.f, this.g);
      }
    }
    if (this.K != null)
    {
      localObject2 = this.ak;
      if (localObject2 != null) {
        ((Bitmap)localObject2).recycle();
      }
      this.ak = RendererUtils.saveTexture(i, this.f, this.g);
      this.K.a(this.ak);
      this.K = null;
    }
    if (t())
    {
      j = this.g * paramInt1;
      int k = this.f * paramInt2;
      if (j > k)
      {
        j = k / paramInt1;
        j = a(i, this.f, this.g, this.f, j);
        break label1408;
      }
      if (j < k)
      {
        j /= paramInt2;
        j = a(i, this.f, this.g, j, this.g);
        break label1408;
      }
    }
    int j = i;
    label1408:
    a(paramInt1, paramInt2, j, paramBoolean);
    if (bool1)
    {
      QLog.d("AEFilterProcessTex", 1, "in capture frame.");
      a(i, this.f, this.g);
      this.u = false;
    }
    FrameBufferCache.getInstance().forceRecycle();
    if (this.p)
    {
      this.D.setRotationAndFlip(0, 0, 1);
      if (t())
      {
        paramInt1 = a(i, this.f, this.g, this.o[0], this.o[1]);
        this.D.RenderProcess(paramInt1, this.o[0], this.o[1], -1, 0.0D, this.B);
      }
      else
      {
        this.D.RenderProcess(i, this.f, this.g, -1, 0.0D, this.B);
      }
      this.D.setRotationAndFlip(0, 0, 0);
    }
    this.s[0] = i;
    this.s[1] = this.B.getTextureId();
    return this.s;
  }
  
  public void b(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.z;
    if ((localAEFilterManager != null) && (localAEFilterManager.currentMaterialNeedVoiceDecibel())) {
      this.z.updateVoiceDecibel(paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    N = paramInt;
    this.z.setSmoothLevel(paramInt);
  }
  
  public void b(@Nullable String paramString)
  {
    this.ac = paramString;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (!a(AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION, paramString, paramInt, 0)) {
      return;
    }
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.openAndUpdateBasicSoftLight(paramString, paramInt);
      a(AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION);
    }
    b(AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION);
  }
  
  public void b(boolean paramBoolean)
  {
    N = 0;
    O = 0;
    Q = false;
    if (paramBoolean) {
      b(null);
    }
  }
  
  public boolean b()
  {
    AEFilterManager localAEFilterManager = this.z;
    return (localAEFilterManager != null) && (localAEFilterManager.getVideoMaterial() != null) && ((this.z.getVideoMaterial().needFaceInfo()) || (this.z.getVideoMaterial().needBodyDetect()));
  }
  
  public void c()
  {
    AETipsManager.getInstance().checkVideoShowFaceView();
  }
  
  public void c(float paramFloat)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateLutAlpha(paramFloat);
    }
  }
  
  public void c(int paramInt)
  {
    O = paramInt;
    f(paramInt);
  }
  
  public void c(String paramString)
  {
    if (!a(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT, paramString, 0, 0)) {
      return;
    }
    P = paramString;
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.updateLutGL(paramString);
      e(paramString);
    }
    b(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT);
  }
  
  public void c(boolean paramBoolean)
  {
    Q = paramBoolean;
    AEFilterProcessTex.3 local3 = new AEFilterProcessTex.3(this, paramBoolean);
    AEFilterManager localAEFilterManager = this.z;
    if ((localAEFilterManager != null) && (localAEFilterManager.isInited()))
    {
      local3.run();
      return;
    }
    a(local3);
  }
  
  public void d()
  {
    AETipsManager.getInstance().checkVideoShowBodyView();
  }
  
  public void d(int paramInt)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.updateFenGeAlpha(paramInt);
    }
  }
  
  public void d(String paramString)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.openFaceThinEnable(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.switchAIBeauty(paramBoolean);
    }
  }
  
  public void e()
  {
    if (E() != null)
    {
      VideoMaterial localVideoMaterial = VideoMaterial.loadLightAsset(E().getDataPath());
      if (FeatureManager.ensureMaterialSoLoaded(localVideoMaterial))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recoverLastEffect---id=");
        ((StringBuilder)localObject).append(localVideoMaterial.getId());
        AEQLog.b("AEFilterProcessTex", ((StringBuilder)localObject).toString());
        if (localVideoMaterial.isWatermarkMaterial())
        {
          AEQLog.b("AEFilterProcessTex", "recoverLastEffect---is an editable watermark material");
          localObject = this.Y;
          if (localObject != null) {
            ((AEFilterProcessTex.IEditableWatermarkMaterialRecover)localObject).recover(localVideoMaterial);
          }
        }
        else
        {
          this.z.updateMaterialGL(localVideoMaterial);
          a(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
          this.T = localVideoMaterial.getId();
        }
      }
    }
    else
    {
      this.z.updateMaterialGL(null);
      a(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
    }
    if ((Q) && (this.z.isInited())) {
      c(Q);
    }
    int i = N;
    if (i > 0) {
      this.z.setSmoothLevel(i);
    }
    i = O;
    if (i > 0) {
      f(i);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.switchAbilityInLightNode("stroke.segmentFollowFace", paramBoolean);
    }
  }
  
  public void f()
  {
    Object localObject = this.C;
    if (localObject != null)
    {
      ((BaseFilter)localObject).clearGLSL();
      this.C = null;
    }
    localObject = this.F;
    if (localObject != null)
    {
      ((SpaceFilter)localObject).clearGLSL();
      this.F = null;
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((BaseFilter)localObject).clearGLSL();
      this.D = null;
    }
    localObject = this.E;
    if (localObject != null) {
      ((ScaleFilter)localObject).clearGLSLSelf();
    }
    localObject = this.G;
    if (localObject != null)
    {
      ((CropFilter)localObject).clearGLSL();
      this.G = null;
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.A = null;
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.B = null;
    }
    localObject = this.z;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).destroy();
      this.z = null;
    }
    localObject = this.H;
    if (localObject != null)
    {
      ((GifFilterMgr)localObject).b();
      this.H = null;
    }
    localObject = this.ak;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.ak = null;
    }
    this.K = null;
    this.R.d();
    AEBaseReportParam.a().i();
  }
  
  public void f(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.openBeautyEnable(paramBoolean);
    }
  }
  
  public void g()
  {
    if ((this.z != null) && (E() != null) && (this.z.getVideoMaterial() != null) && (this.z.getVideoMaterial().needResetWhenRecord())) {
      this.z.stickerReset(true);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager != null) {
      localAEFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public AEFilterManager h()
  {
    return this.z;
  }
  
  public boolean i()
  {
    VideoMaterial localVideoMaterial = E();
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
  
  public boolean j()
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager == null) {
      return false;
    }
    return AEStaticDetector.hasFaceData(localAEFilterManager.getFaceAttr());
  }
  
  public PTFaceAttr k()
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager == null) {
      return null;
    }
    return localAEFilterManager.getFaceAttr();
  }
  
  public boolean l()
  {
    AEFilterManager localAEFilterManager = this.z;
    if (localAEFilterManager == null) {
      return false;
    }
    return localAEFilterManager.needMaskRecordTouchPoint();
  }
  
  public boolean m()
  {
    AEFilterManager localAEFilterManager = this.z;
    boolean bool = false;
    if (localAEFilterManager == null) {
      return false;
    }
    if ((E() != null) || (N > 0) || (O > 0) || (P != null)) {
      bool = true;
    }
    return bool;
  }
  
  public void n()
  {
    try
    {
      if (!TextUtils.isEmpty(this.T)) {
        this.V.add(this.T);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<AEResInfo> o()
  {
    AEFilterConfig localAEFilterConfig = this.J;
    if (localAEFilterConfig != null) {
      return localAEFilterConfig.h();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex
 * JD-Core Version:    0.7.0.1
 */