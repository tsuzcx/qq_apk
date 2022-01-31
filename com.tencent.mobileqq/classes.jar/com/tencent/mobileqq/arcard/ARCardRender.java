package com.tencent.mobileqq.arcard;

import aamc;
import aamd;
import aame;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.av.opengl.effects.EffectBeautyTools;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderableConstructorFactoty;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager.DrawFrameParements;
import com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ARCardRender
  implements ARRenderManager, ARRenderMangerInnerCallback
{
  public static float a;
  public static int a;
  public static int b;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  public volatile ARBaseRender a;
  ARRenderManagerCallBack jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
  public ARRenerArumentManager a;
  private CameraRendererable jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable = new CameraRendererable(this);
  FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  public Map a;
  private EGLConfig jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat;
  private long jdField_b_of_type_Long;
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  int c = 0;
  int d = 0;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  public ARCardRender()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager = new ARRenerArumentManager();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      i = this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.process(paramInt1, -1, paramInt2, paramInt3).getTextureId();
      return i;
      label42:
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setNeedSkinColor(true);
    }
  }
  
  private ARBaseRender a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (ARBaseRender)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  private void a(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c();
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDepthMask(true);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDisable(2929);
    b(paramGL10);
    GLES20.glFinish();
  }
  
  private void b(GL10 paramGL10)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion())
    {
      this.d += 1;
      this.c = ((int)(l2 - l1 + this.c));
      if (this.d % 100 == 0) {
        Log.i("wing", "scan line anime cameraRenderer cost---- " + this.c * 1.0F / Math.max(1, this.d));
      }
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if ((paramGL10 != null) && (paramGL10.a()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      ARRenerArumentManager.DrawFrameParements localDrawFrameParements = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(paramGL10.a(), paramGL10.b());
      if (localDrawFrameParements != null) {
        paramGL10.a(localDrawFrameParements);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public ARRenerArumentManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "stop.");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ARBaseRender)localIterator.next()).d();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.g();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(), paramInt2);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(), paramInt2);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(), paramInt2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.d(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(), paramInt2);
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "startCameraPreviewRender. textureId = " + paramInt1 + ", surfaceTexture = " + paramSurfaceTexture);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramInt1, paramSurfaceTexture);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramInt2, paramInt3, paramInt4, paramInt5);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(paramArrayOfFloat);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(VideoRecordController paramVideoRecordController)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = paramVideoRecordController;
  }
  
  public void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.a()) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(paramARRenderTrackInfo);
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a(paramArVideoResourceInfo, paramARRenderMangerInnerCallback);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext, ARRenderManagerCallBack paramARRenderManagerCallBack)
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "init.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack = paramARRenderManagerCallBack;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    return true;
  }
  
  public boolean a(ARRenderResourceInfo paramARRenderResourceInfo)
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "startModelRender. resourceInfo.key = " + paramARRenderResourceInfo.jdField_a_of_type_JavaLangString + ", resourceInfo.arType = " + paramARRenderResourceInfo.jdField_a_of_type_Int + ", resourceInfo.trackMode = " + paramARRenderResourceInfo.jdField_b_of_type_Int);
    ARBaseRender localARBaseRender2 = a(paramARRenderResourceInfo.jdField_a_of_type_JavaLangString);
    ARBaseRender localARBaseRender1 = localARBaseRender2;
    if (localARBaseRender2 == null)
    {
      localARBaseRender1 = ARRenderableConstructorFactoty.a(this, paramARRenderResourceInfo, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      this.jdField_a_of_type_JavaUtilMap.put(paramARRenderResourceInfo.jdField_a_of_type_JavaLangString, localARBaseRender1);
      QLog.d("AREngine_ARRenderManagerImpl", 1, "crate new render here " + localARBaseRender1);
    }
    if (localARBaseRender1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
      }
      paramARRenderResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new aamc(this, paramARRenderResourceInfo));
      return false;
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new aamd(this, localARBaseRender1, paramARRenderResourceInfo));
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramFloat2);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "uninit.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack = null;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.c = paramLong;
  }
  
  public void c()
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "stopCameraPreviewRender.");
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_b_of_type_Long > 0L))
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l > 1000L)
      {
        int i = (int)(this.jdField_b_of_type_Long / (l / 1000L));
        ScanEntranceReport.a().a(i);
      }
    }
  }
  
  public void d()
  {
    QLog.i("AREngine_ARRenderManagerImpl", 1, "stopModelRender.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new aame(this));
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.b()))
    {
      i = 1;
      if (i == 0) {
        break label354;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, jdField_a_of_type_Int, jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      a(paramGL10);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      i = a(true, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), jdField_a_of_type_Int, jdField_b_of_type_Int);
      paramGL10 = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
      if (i == -1) {
        break label332;
      }
      j = i;
      label102:
      paramGL10.a(3553, j, null, null, SystemClock.elapsedRealtimeNanos());
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.e, this.f);
      if (this.jdField_a_of_type_ArrayOfFloat == null) {
        this.jdField_a_of_type_ArrayOfFloat = ARCardUtils.a(jdField_a_of_type_Int, jdField_b_of_type_Int, this.e, this.f);
      }
      paramGL10 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
      if (i == -1) {
        break label343;
      }
    }
    for (;;)
    {
      paramGL10.a(3553, i, null, this.jdField_a_of_type_ArrayOfFloat);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        paramGL10 = new RenderBuffer(540, 960, 33984);
        paramGL10.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), null, null);
        paramGL10.c();
        Bitmap localBitmap = GlUtil.a(paramGL10.a(), 540, 960, 0);
        GLES20.glDeleteTextures(1, new int[] { paramGL10.a() }, 0);
        paramGL10.d();
        if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a(null, 1001, 0, localBitmap);
        }
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_b_of_type_Long += 1L;
      return;
      i = 0;
      break;
      label332:
      j = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      break label102;
      label343:
      i = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    }
    label354:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.d();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    a(paramGL10);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    int i = a(true, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), jdField_a_of_type_Int, jdField_b_of_type_Int);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.e, this.f);
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = ARCardUtils.a(jdField_a_of_type_Int, jdField_b_of_type_Int, this.e, this.f);
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
    if (i != -1) {}
    for (;;)
    {
      paramGL10.a(3553, i, null, this.jdField_a_of_type_ArrayOfFloat);
      break;
      i = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(jdField_a_of_type_Int, jdField_b_of_type_Int, 33984);
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a();
    }
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = paramEGLConfig;
    ARDeviceController.a().a(paramGL10.glGetString(7937));
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.context, EffectBeautyTools.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(0.5F);
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.5F);
    paramEGLConfig = new StringBuilder();
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_RENDERER = " + paramGL10.glGetString(7937));
    }
    paramEGLConfig.append("GL_RENDERER = " + paramGL10.glGetString(7937));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 1, "GL_VENDOR = " + paramGL10.glGetString(7936));
    }
    paramEGLConfig.append("GL_VENDOR = " + paramGL10.glGetString(7936));
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel()) {
      QLog.d("GPU_INFO", 2, "GL_VERSION = " + paramGL10.glGetString(7938));
    }
    paramEGLConfig.append("GL_VERSION = " + paramGL10.glGetString(7938));
    paramEGLConfig.append('\n');
    Object localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36347, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(35661, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34076, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_CUBE_MAP_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34024, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_RENDERBUFFER_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34930, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_IMAGE_UNITS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(3379, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_TEXTURE_SIZE = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34921, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VERTEX_ATTRIBS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36348, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_VARYING_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    paramEGLConfig.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = " + ((IntBuffer)localObject).get());
    paramEGLConfig.append('\n');
    paramEGLConfig = new StringBuilder();
    localObject = paramGL10.glGetString(7939).split(" ");
    int i = 0;
    while (i < localObject.length)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("GPU_INFO", 2, "GL_EXTENSIONS = " + localObject[i]);
        paramEGLConfig.append(localObject[i] + " ");
      }
      i += 1;
    }
    ReportUtil.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardRender
 * JD-Core Version:    0.7.0.1
 */