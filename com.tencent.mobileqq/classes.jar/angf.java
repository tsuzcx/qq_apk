import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.1;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
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

public class angf
  implements amvj, ange
{
  public static float a;
  public static int a;
  public static int b;
  private long jdField_a_of_type_Long;
  public volatile amvh a;
  amvi jdField_a_of_type_Amvi;
  public amvo a;
  private amvu jdField_a_of_type_Amvu = new amvu(this);
  private Context jdField_a_of_type_AndroidContentContext;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private anho jdField_a_of_type_Anho;
  private axvg jdField_a_of_type_Axvg;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  public Map<String, amvh> a;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Map<Integer, Object> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  public angf()
  {
    this.jdField_a_of_type_Amvo = new amvo();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private amvh a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (amvh)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  private void a(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_Amvh != null) {
      this.jdField_a_of_type_Amvh.e();
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
    this.jdField_a_of_type_Amvu.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion())
    {
      this.jdField_d_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(l2 - l1 + this.jdField_c_of_type_Int));
      if (this.jdField_d_of_type_Int % 100 == 0) {
        Log.i("wing", "scan line anime cameraRenderer cost---- " + this.jdField_c_of_type_Int * 1.0F / Math.max(1, this.jdField_d_of_type_Int));
      }
    }
    paramGL10 = this.jdField_a_of_type_Amvh;
    if ((paramGL10 != null) && (paramGL10.d()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      amvp localamvp = this.jdField_a_of_type_Amvo.a(paramGL10.b(), paramGL10.c());
      if (localamvp != null) {
        paramGL10.a(localamvp);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Amvu.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Amvo.jdField_a_of_type_Long;
  }
  
  public amvo a()
  {
    return this.jdField_a_of_type_Amvo;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public ange a()
  {
    return this;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startARCorePreViewRender. textureId = " + paramInt);
    this.jdField_a_of_type_Amvu.b(paramInt);
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startCameraPreviewRender. textureId = " + paramInt1 + ", surfaceTexture = " + paramSurfaceTexture);
    this.jdField_a_of_type_Amvu.a(paramInt1, paramSurfaceTexture);
    this.jdField_a_of_type_Amvu.a(paramInt2, paramInt3, paramInt4, paramInt5);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_Amvo.a(paramArrayOfFloat);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Amvo.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(amvh paramamvh, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.a()) && (this.jdField_a_of_type_Amvi != null)) {
      this.jdField_a_of_type_Amvi.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(amvi paramamvi)
  {
    this.jdField_a_of_type_Amvi = paramamvi;
  }
  
  public void a(amvm paramamvm)
  {
    this.jdField_a_of_type_Amvo.a(paramamvm);
  }
  
  public void a(anho paramanho)
  {
    this.jdField_a_of_type_Anho = paramanho;
  }
  
  public void a(VideoRecordController paramVideoRecordController)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = paramVideoRecordController;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, amvj paramamvj)
  {
    if (this.jdField_a_of_type_Amvi == null) {
      return;
    }
    this.jdField_a_of_type_Amvi.a(paramArVideoResourceInfo, paramamvj);
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
  
  public void a(FloatBuffer paramFloatBuffer, Size paramSize)
  {
    this.jdField_a_of_type_Amvu.a(paramFloatBuffer, paramSize);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public boolean a(amvl paramamvl)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. resourceInfo.key = " + paramamvl.jdField_a_of_type_JavaLangString + ", resourceInfo.arType = " + paramamvl.jdField_a_of_type_Int + ", resourceInfo.trackMode = " + paramamvl.jdField_b_of_type_Int);
    if (!this.e)
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
      return false;
    }
    amvh localamvh2 = a(paramamvl.jdField_a_of_type_JavaLangString);
    amvh localamvh1 = localamvh2;
    if (localamvh2 == null)
    {
      localamvh1 = amvn.a(this, paramamvl, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here 1" + localamvh1);
      this.jdField_a_of_type_JavaUtilMap.put(paramamvl.jdField_a_of_type_JavaLangString, localamvh1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here " + localamvh1);
    }
    if (localamvh1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
      }
      paramamvl = this.jdField_a_of_type_Amvh;
      this.jdField_a_of_type_Amvh = null;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.1(this, paramamvl));
      return false;
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.2(this, localamvh1, paramamvl));
    return true;
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amvh = null;
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "enableCameraPreviewScanLine. isEnable = " + paramBoolean + ", endY = " + paramFloat2);
    if (this.jdField_a_of_type_Amvu != null)
    {
      this.jdField_a_of_type_Amvu.a(paramBoolean);
      this.jdField_a_of_type_Amvu.a(paramFloat2);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stop. mHasDestroyElgContext:" + this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_d_of_type_Boolean) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((amvh)localIterator.next()).f();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_Amvh = null;
      this.jdField_a_of_type_Amvu.g();
      this.jdField_a_of_type_Amvo.a();
      this.e = false;
      this.jdField_d_of_type_Boolean = true;
      try
      {
        if (this.jdField_a_of_type_Axvg != null)
        {
          this.jdField_a_of_type_Axvg.a();
          this.jdField_a_of_type_Axvg = null;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_UniformGLRenderManagerImpl", 1, "stop, mEglCore release: " + localException.getMessage());
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Amvi == null) || (this.jdField_a_of_type_Amvh == null))
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Amvi.a(this.jdField_a_of_type_Amvh.c(), paramInt2);
      return;
    case 1: 
      this.jdField_a_of_type_Amvi.c(this.jdField_a_of_type_Amvh.c(), paramInt2);
      return;
    case 2: 
      this.jdField_a_of_type_Amvi.b(this.jdField_a_of_type_Amvh.c(), paramInt2);
      return;
    }
    this.jdField_a_of_type_Amvi.d(this.jdField_a_of_type_Amvh.c(), paramInt2);
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Amvo.c = paramLong;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amvu != null) {
      return this.jdField_a_of_type_Amvu.a();
    }
    return false;
  }
  
  public void c()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Amvi = null;
  }
  
  public void d()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.3(this));
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.b())) {
      i = 1;
    }
    while (i != 0)
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
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_Axvg, i, j);
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        a(paramGL10);
        QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "onDrawFrame, mRecordFBO == null");
        return;
        i = 0;
      }
      else
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        a(paramGL10);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
        if (this.jdField_a_of_type_Long == 0L) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_b_of_type_Long += 1L;
        return;
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
      {
        GLES20.glDeleteTextures(1, new int[] { this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId() }, 0);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.d();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
    RenderBuffer localRenderBuffer1;
    if (this.jdField_c_of_type_Boolean)
    {
      localRenderBuffer1 = new RenderBuffer(jdField_a_of_type_Int, jdField_b_of_type_Int, 33984);
      localRenderBuffer1.bind();
    }
    for (;;)
    {
      a(paramGL10);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      localRenderBuffer1.unbind();
      paramGL10 = new TextureRender();
      GLES20.glViewport(0, 0, jdField_a_of_type_Int, jdField_b_of_type_Int);
      paramGL10.drawTexture(3553, localRenderBuffer1.getTexId(), null, null);
      RenderBuffer localRenderBuffer2 = new RenderBuffer(540, 960, 33984);
      localRenderBuffer2.bind();
      paramGL10.drawTexture(3553, localRenderBuffer1.getTexId(), null, null);
      localRenderBuffer2.unbind();
      Bitmap localBitmap = GlUtil.captureFrame(localRenderBuffer2.getTexId(), 540, 960, 0);
      GLES20.glDeleteTextures(1, new int[] { localRenderBuffer2.getTexId() }, 0);
      GLES20.glDeleteTextures(1, new int[] { localRenderBuffer1.getTexId() }, 0);
      localRenderBuffer2.destroy();
      paramGL10.release();
      localRenderBuffer1.destroy();
      if (this.jdField_a_of_type_Amvi != null) {
        this.jdField_a_of_type_Amvi.a(null, 1001, 0, localBitmap);
      }
      this.jdField_c_of_type_Boolean = false;
      break;
      localRenderBuffer1 = null;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_Int = paramInt1;
    jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Anho != null) {
      this.jdField_a_of_type_Anho.a(paramGL10, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_Amvu.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Amvi != null) {
      this.jdField_a_of_type_Amvi.a();
    }
    this.e = true;
    this.jdField_a_of_type_Boolean = true;
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
    this.jdField_d_of_type_Boolean = false;
    if (amva.a()) {
      this.jdField_a_of_type_Axvg = new axvg(EGL14.eglGetCurrentContext(), 1);
    }
    amsg.a().a(paramGL10.glGetString(7937));
    this.jdField_a_of_type_Amvu.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (this.jdField_a_of_type_Anho != null) {
      this.jdField_a_of_type_Anho.a(paramGL10);
    }
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
    amyq.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angf
 * JD-Core Version:    0.7.0.1
 */