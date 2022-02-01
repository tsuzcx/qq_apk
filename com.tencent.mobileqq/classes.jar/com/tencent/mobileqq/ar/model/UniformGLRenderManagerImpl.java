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
  public static int b;
  public static int c;
  GLSurfaceView d;
  public volatile ARBaseRender e;
  FramePerformanceMonitor f = new FramePerformanceMonitor();
  ARRenderManagerCallBack g;
  ARRenerArumentManager h = new ARRenerArumentManager();
  public boolean i = false;
  int j = 0;
  int k = 0;
  public Map<String, ARBaseRender> l = new ConcurrentHashMap();
  private CameraRendererable m = new CameraRendererable(this);
  private Context n;
  private Map<Integer, Object> o = new ConcurrentHashMap();
  private long p;
  private long q;
  private EglCore r;
  private boolean s;
  private RenderBuffer t;
  private TextureRender u;
  private VideoRecordController v;
  private boolean w = false;
  private boolean x = false;
  private GLRenderStatusCallBack y;
  private volatile boolean z = false;
  
  private void a(GL10 paramGL10)
  {
    if (this.e != null) {
      this.e.k();
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDepthMask(true);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDisable(2929);
    b(paramGL10);
    GLES20.glFinish();
  }
  
  private ARBaseRender b(String paramString)
  {
    if (this.l.containsKey(paramString)) {
      return (ARBaseRender)this.l.get(paramString);
    }
    return null;
  }
  
  private void b(GL10 paramGL10)
  {
    long l1 = System.currentTimeMillis();
    this.m.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion())
    {
      this.k += 1;
      this.j = ((int)(this.j + (l2 - l1)));
      if (this.k % 100 == 0)
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("scan line anime cameraRenderer cost---- ");
        paramGL10.append(this.j * 1.0F / Math.max(1, this.k));
        Log.i("wing", paramGL10.toString());
      }
    }
    paramGL10 = this.e;
    if ((paramGL10 != null) && (paramGL10.o()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      ARRenerArumentManager.DrawFrameParements localDrawFrameParements = this.h.a(paramGL10.m(), paramGL10.q());
      if (localDrawFrameParements != null) {
        paramGL10.a(localDrawFrameParements);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public Context a()
  {
    return this.n;
  }
  
  public Object a(int paramInt)
  {
    return this.o.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreviewRender. textureId = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", surfaceTexture = ");
    localStringBuilder.append(paramSurfaceTexture);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, localStringBuilder.toString());
    this.m.a(paramInt1, paramSurfaceTexture);
    this.m.a(paramInt2, paramInt3, paramInt4, paramInt5);
    this.p = 0L;
    this.q = 0L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.o.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.h.a(paramArrayOfFloat);
  }
  
  public void a(long paramLong)
  {
    this.h.a = paramLong;
  }
  
  public void a(VideoRecordController paramVideoRecordController)
  {
    this.v = paramVideoRecordController;
  }
  
  public void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.a()))
    {
      paramARBaseRender = this.g;
      if (paramARBaseRender != null) {
        paramARBaseRender.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
      }
    }
  }
  
  public void a(ARRenderManagerCallBack paramARRenderManagerCallBack)
  {
    this.g = paramARRenderManagerCallBack;
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo)
  {
    this.h.a(paramARRenderTrackInfo);
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    ARRenderManagerCallBack localARRenderManagerCallBack = this.g;
    if (localARRenderManagerCallBack == null) {
      return;
    }
    localARRenderManagerCallBack.a(paramArVideoResourceInfo, paramARRenderMangerInnerCallback);
  }
  
  public void a(GLRenderStatusCallBack paramGLRenderStatusCallBack)
  {
    this.y = paramGLRenderStatusCallBack;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLSurfaceView localGLSurfaceView = this.d;
    if (localGLSurfaceView != null) {
      localGLSurfaceView.queueEvent(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    this.l.remove(paramString);
  }
  
  public void a(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.m.a(paramFloatBuffer, paramSize);
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
    this.d = paramGLSurfaceView;
    this.n = paramContext;
    this.e = null;
    return true;
  }
  
  public boolean a(ARRenderResourceInfo paramARRenderResourceInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startModelRender. resourceInfo.key = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.a);
    ((StringBuilder)localObject1).append(", resourceInfo.arType = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.b);
    ((StringBuilder)localObject1).append(", resourceInfo.trackMode = ");
    ((StringBuilder)localObject1).append(paramARRenderResourceInfo.d);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject1).toString());
    if (!this.z)
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
      return false;
    }
    Object localObject2 = b(paramARRenderResourceInfo.a);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ARRenderableConstructorFactoty.a(this, paramARRenderResourceInfo, this.d);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("crate new render here 1");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject2).toString());
      this.l.put(paramARRenderResourceInfo.a, localObject1);
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
      paramARRenderResourceInfo = this.e;
      this.e = null;
      this.d.queueEvent(new UniformGLRenderManagerImpl.1(this, paramARRenderResourceInfo));
      return false;
    }
    this.d.queueEvent(new UniformGLRenderManagerImpl.2(this, (ARBaseRender)localObject1, paramARRenderResourceInfo));
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
    localObject = this.m;
    if (localObject != null)
    {
      ((CameraRendererable)localObject).a(paramBoolean);
      this.m.a(paramFloat2);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    GLSurfaceView localGLSurfaceView = this.d;
    if (localGLSurfaceView != null) {
      localGLSurfaceView.requestRender();
    }
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startARCorePreViewRender. textureId = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, localStringBuilder.toString());
    this.m.b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.g != null) && (this.e != null))
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
            this.g.d(this.e.n(), paramInt2);
            return;
          }
          this.g.b(this.e.n(), paramInt2);
          return;
        }
        this.g.c(this.e.n(), paramInt2);
        return;
      }
      this.g.a(this.e.n(), paramInt2);
      return;
    }
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
  }
  
  public void b(long paramLong)
  {
    this.h.c = paramLong;
  }
  
  public ARRenerArumentManager c()
  {
    return this.h;
  }
  
  public UniformGLRenderManager d()
  {
    return this;
  }
  
  public boolean e()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop. mHasDestroyElgContext:");
    ((StringBuilder)localObject).append(this.x);
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, ((StringBuilder)localObject).toString());
    this.i = false;
    if (this.x) {
      return;
    }
    localObject = this.l.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ARBaseRender)((Iterator)localObject).next()).l();
    }
    this.l.clear();
    this.e = null;
    this.m.i();
    this.h.a();
    this.z = false;
    this.x = true;
    try
    {
      if (this.r != null)
      {
        this.r.a();
        this.r = null;
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
  
  public void g()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
    this.d = null;
    this.n = null;
    this.g = null;
  }
  
  public boolean h()
  {
    CameraRendererable localCameraRendererable = this.m;
    if (localCameraRendererable != null) {
      return localCameraRendererable.a();
    }
    return false;
  }
  
  public int i()
  {
    return this.m.h();
  }
  
  public void j()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender.");
    this.d.queueEvent(new UniformGLRenderManagerImpl.3(this));
  }
  
  public long k()
  {
    return this.h.a;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.v;
    int i1;
    if ((localObject != null) && (((VideoRecordController)localObject).b())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (!this.s)
      {
        if (this.t == null) {
          this.t = new RenderBuffer(b, c, 33984);
        }
        if (this.u == null) {
          this.u = new TextureRender();
        }
        i1 = b;
        int i2 = c;
        this.v.a(this.r, i1, i2);
        this.s = true;
      }
      localObject = this.t;
      if (localObject == null)
      {
        a(paramGL10);
        QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "onDrawFrame, mRecordFBO == null");
        return;
      }
      ((RenderBuffer)localObject).bind();
      a(paramGL10);
      this.t.unbind();
      this.v.a(3553, this.t.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, b, c);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
      GLES20.glDisable(3042);
      this.u.drawTexture(3553, this.t.getTexId(), null, null);
    }
    else
    {
      if (this.s)
      {
        localObject = this.t;
        if (localObject != null)
        {
          GLES20.glDeleteTextures(1, new int[] { ((RenderBuffer)localObject).getTexId() }, 0);
          this.t.destroy();
          this.t = null;
        }
        localObject = this.u;
        if (localObject != null)
        {
          ((TextureRender)localObject).release();
          this.u = null;
        }
        localObject = this.v;
        if (localObject != null) {
          ((VideoRecordController)localObject).f();
        }
        this.s = false;
      }
      GLES20.glViewport(0, 0, b, c);
      if (this.w)
      {
        localObject = new RenderBuffer(b, c, 33984);
        ((RenderBuffer)localObject).bind();
      }
      else
      {
        localObject = null;
      }
      a(paramGL10);
      if (this.w)
      {
        ((RenderBuffer)localObject).unbind();
        TextureRender localTextureRender = new TextureRender();
        GLES20.glViewport(0, 0, b, c);
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
        localObject = this.g;
        if (localObject != null) {
          ((ARRenderManagerCallBack)localObject).a(null, 1001, 0, paramGL10);
        }
        this.w = false;
      }
    }
    if (this.p == 0L) {
      this.p = System.currentTimeMillis();
    }
    this.q += 1L;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    b = paramInt1;
    c = paramInt2;
    GLRenderStatusCallBack localGLRenderStatusCallBack = this.y;
    if (localGLRenderStatusCallBack != null) {
      localGLRenderStatusCallBack.a(paramGL10, paramInt1, paramInt2);
    }
    this.m.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    paramGL10 = this.g;
    if (paramGL10 != null) {
      paramGL10.a();
    }
    this.z = true;
    this.i = true;
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
    int i1 = 0;
    this.x = false;
    if (VideoEncoderUtils.a()) {
      this.r = new EglCore(EGL14.eglGetCurrentContext(), 1);
    }
    ARDeviceController.a().a(paramGL10.glGetString(7937));
    this.m.onSurfaceCreated(paramGL10, paramEGLConfig);
    paramEGLConfig = this.y;
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
    while (i1 < localObject.length)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GL_EXTENSIONS = ");
        localStringBuilder.append(localObject[i1]);
        QLog.d("GPU_INFO", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject[i1]);
        localStringBuilder.append(" ");
        paramEGLConfig.append(localStringBuilder.toString());
      }
      i1 += 1;
    }
    ReportUtil.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl
 * JD-Core Version:    0.7.0.1
 */