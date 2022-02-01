package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
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
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.view.GLRenderStatusCallBack;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class UniformGLRenderManagerImpl
  implements ARRenderMangerInnerCallback, UniformGLRenderManager
{
  public static float a = 1.0F;
  public static int a;
  public static int b;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  public volatile ARBaseRender a;
  ARRenderManagerCallBack jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
  ARRenerArumentManager jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager = new ARRenerArumentManager();
  private CameraRendererable jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable = new CameraRendererable(this);
  FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  private GLRenderStatusCallBack jdField_a_of_type_ComTencentMobileqqArViewGLRenderStatusCallBack;
  private EglCore jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  public Map<String, ARBaseRender> a;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Map<Integer, Object> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private volatile boolean e = false;
  
  public UniformGLRenderManagerImpl()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
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
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.e();
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
      this.jdField_d_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + (l2 - l1)));
      if (this.jdField_d_of_type_Int % 100 == 0)
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("scan line anime cameraRenderer cost---- ");
        paramGL10.append(this.jdField_c_of_type_Int * 1.0F / Math.max(1, this.jdField_d_of_type_Int));
        Log.i("wing", paramGL10.toString());
      }
    }
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
    if ((paramGL10 != null) && (paramGL10.d()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      ARRenerArumentManager.DrawFrameParements localDrawFrameParements = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(paramGL10.b(), paramGL10.c());
      if (localDrawFrameParements != null) {
        paramGL10.a(localDrawFrameParements);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a();
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
  
  public UniformGLRenderManager a()
  {
    return this;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
    if (localGLSurfaceView != null) {
      localGLSurfaceView.requestRender();
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startARCorePreViewRender. textureId = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.b(paramInt);
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreviewRender. textureId = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", surfaceTexture = ");
    localStringBuilder.append(paramSurfaceTexture);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, localStringBuilder.toString());
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
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.a()))
    {
      paramARBaseRender = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
      if (paramARBaseRender != null) {
        paramARBaseRender.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
      }
    }
  }
  
  public void a(ARRenderManagerCallBack paramARRenderManagerCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack = paramARRenderManagerCallBack;
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a(paramARRenderTrackInfo);
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    ARRenderManagerCallBack localARRenderManagerCallBack = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
    if (localARRenderManagerCallBack == null) {
      return;
    }
    localARRenderManagerCallBack.a(paramArVideoResourceInfo, paramARRenderMangerInnerCallback);
  }
  
  public void a(GLRenderStatusCallBack paramGLRenderStatusCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqArViewGLRenderStatusCallBack = paramGLRenderStatusCallBack;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
    if (localGLSurfaceView != null) {
      localGLSurfaceView.queueEvent(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public void a(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramFloatBuffer, paramSize);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    return true;
  }
  
  public boolean a(ARRenderResourceInfo paramARRenderResourceInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startModelRender. resourceInfo.key = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", resourceInfo.arType = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append(", resourceInfo.trackMode = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.jdField_b_of_type_Int);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject1).toString());
    if (!this.e)
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
      return false;
    }
    Object localObject2 = a(paramARRenderResourceInfo.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ARRenderableConstructorFactoty.a(this, paramARRenderResourceInfo, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("crate new render here 1");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_JavaUtilMap.put(paramARRenderResourceInfo.jdField_a_of_type_JavaLangString, localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("crate new render here ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
      }
      paramARRenderResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender;
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.1(this, paramARRenderResourceInfo));
      return false;
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.2(this, (ARBaseRender)localObject1, paramARRenderResourceInfo));
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableCameraPreviewScanLine. isEnable = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", endY = ");
    ((StringBuilder)localObject).append(paramFloat2);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable;
    if (localObject != null)
    {
      ((CameraRendererable)localObject).a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.a(paramFloat2);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop. mHasDestroyElgContext:");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ARBaseRender)((Iterator)localObject).next()).f();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.g();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.a();
    this.e = false;
    this.jdField_d_of_type_Boolean = true;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore.a();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = null;
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop, mEglCore release: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("AREngine_UniformGLRenderManagerImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender != null))
    {
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.d(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c(), paramInt2);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c(), paramInt2);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c(), paramInt2);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.c(), paramInt2);
      return;
    }
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager.c = paramLong;
  }
  
  public boolean b()
  {
    CameraRendererable localCameraRendererable = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable;
    if (localCameraRendererable != null) {
      return localCameraRendererable.a();
    }
    return false;
  }
  
  public void c()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack = null;
  }
  
  public void d()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.3(this));
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
    int i;
    if ((localObject != null) && (((VideoRecordController)localObject).b())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(jdField_a_of_type_Int, jdField_b_of_type_Int, 33984);
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        i = jdField_a_of_type_Int;
        int j = jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore, i, j);
        this.jdField_b_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      if (localObject == null)
      {
        a(paramGL10);
        QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "onDrawFrame, mRecordFBO == null");
        return;
      }
      ((RenderBuffer)localObject).bind();
      a(paramGL10);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
      GLES20.glDisable(3042);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
    }
    else
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        if (localObject != null)
        {
          GLES20.glDeleteTextures(1, new int[] { ((RenderBuffer)localObject).getTexId() }, 0);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
        }
        localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
        if (localObject != null)
        {
          ((TextureRender)localObject).release();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
        if (localObject != null) {
          ((VideoRecordController)localObject).d();
        }
        this.jdField_b_of_type_Boolean = false;
      }
      GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
      if (this.jdField_c_of_type_Boolean)
      {
        localObject = new RenderBuffer(jdField_a_of_type_Int, jdField_b_of_type_Int, 33984);
        ((RenderBuffer)localObject).bind();
      }
      else
      {
        localObject = null;
      }
      a(paramGL10);
      if (this.jdField_c_of_type_Boolean)
      {
        ((RenderBuffer)localObject).unbind();
        TextureRender localTextureRender = new TextureRender();
        GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
        localTextureRender.drawTexture(3553, ((RenderBuffer)localObject).getTexId(), null, null);
        RenderBuffer localRenderBuffer = new RenderBuffer(540, 960, 33984);
        localRenderBuffer.bind();
        localTextureRender.drawTexture(3553, ((RenderBuffer)localObject).getTexId(), null, null);
        localRenderBuffer.unbind();
        paramGL10 = GlUtil.captureFrame(localRenderBuffer.getTexId(), 540, 960, 0);
        GLES20.glDeleteTextures(1, new int[] { localRenderBuffer.getTexId() }, 0);
        GLES20.glDeleteTextures(1, new int[] { ((RenderBuffer)localObject).getTexId() }, 0);
        localRenderBuffer.destroy();
        localTextureRender.release();
        ((RenderBuffer)localObject).destroy();
        localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
        if (localObject != null) {
          ((ARRenderManagerCallBack)localObject).a(null, 1001, 0, paramGL10);
        }
        this.jdField_c_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_b_of_type_Long += 1L;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_Int = paramInt1;
    jdField_b_of_type_Int = paramInt2;
    GLRenderStatusCallBack localGLRenderStatusCallBack = this.jdField_a_of_type_ComTencentMobileqqArViewGLRenderStatusCallBack;
    if (localGLRenderStatusCallBack != null) {
      localGLRenderStatusCallBack.a(paramGL10, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManagerCallBack;
    if (paramGL10 != null) {
      paramGL10.a();
    }
    this.e = true;
    this.jdField_a_of_type_Boolean = true;
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
    int i = 0;
    this.jdField_d_of_type_Boolean = false;
    if (VideoEncoderUtils.a()) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(EGL14.eglGetCurrentContext(), 1);
    }
    ARDeviceController.a().a(paramGL10.glGetString(7937));
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelCameraRendererable.onSurfaceCreated(paramGL10, paramEGLConfig);
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqArViewGLRenderStatusCallBack;
    if (paramEGLConfig != null) {
      paramEGLConfig.a(paramGL10);
    }
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.5F);
    paramEGLConfig = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL_RENDERER = ");
      ((StringBuilder)localObject).append(paramGL10.glGetString(7937));
      QLog.d("GPU_INFO", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL_RENDERER = ");
    ((StringBuilder)localObject).append(paramGL10.glGetString(7937));
    paramEGLConfig.append(((StringBuilder)localObject).toString());
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL_VENDOR = ");
      ((StringBuilder)localObject).append(paramGL10.glGetString(7936));
      QLog.d("GPU_INFO", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL_VENDOR = ");
    ((StringBuilder)localObject).append(paramGL10.glGetString(7936));
    paramEGLConfig.append(((StringBuilder)localObject).toString());
    paramEGLConfig.append('\n');
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL_VERSION = ");
      ((StringBuilder)localObject).append(paramGL10.glGetString(7938));
      QLog.d("GPU_INFO", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL_VERSION = ");
    ((StringBuilder)localObject).append(paramGL10.glGetString(7938));
    paramEGLConfig.append(((StringBuilder)localObject).toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36347, (IntBuffer)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_VERTEX_UNIFORM_VECTORS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(35661, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34076, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_CUBE_MAP_TEXTURE_SIZE = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34024, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_RENDERBUFFER_SIZE = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34930, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_TEXTURE_IMAGE_UNITS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(3379, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_TEXTURE_SIZE = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(34921, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_VERTEX_ATTRIBS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36348, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_VARYING_VECTORS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    localObject = IntBuffer.allocate(20);
    paramGL10.glGetIntegerv(36349, (IntBuffer)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_FRAGMENT_UNIFORM_VECTORS = ");
    localStringBuilder.append(((IntBuffer)localObject).get());
    paramEGLConfig.append(localStringBuilder.toString());
    paramEGLConfig.append('\n');
    paramEGLConfig = new StringBuilder();
    localObject = paramGL10.glGetString(7939).split(" ");
    while (i < localObject.length)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GL_EXTENSIONS = ");
        localStringBuilder.append(localObject[i]);
        QLog.d("GPU_INFO", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(" ");
        paramEGLConfig.append(localStringBuilder.toString());
      }
      i += 1;
    }
    ReportUtil.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl
 * JD-Core Version:    0.7.0.1
 */