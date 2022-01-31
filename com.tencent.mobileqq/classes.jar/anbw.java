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

public class anbw
  implements amqu, anbv
{
  public static float a;
  public static int a;
  public static int b;
  private long jdField_a_of_type_Long;
  public volatile amqs a;
  amqt jdField_a_of_type_Amqt;
  public amqz a;
  private amrf jdField_a_of_type_Amrf = new amrf(this);
  private andf jdField_a_of_type_Andf;
  private Context jdField_a_of_type_AndroidContentContext;
  GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private axqx jdField_a_of_type_Axqx;
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  public Map<String, amqs> a;
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
  
  public anbw()
  {
    this.jdField_a_of_type_Amqz = new amqz();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private amqs a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (amqs)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  private void a(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_Amqs != null) {
      this.jdField_a_of_type_Amqs.e();
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
    this.jdField_a_of_type_Amrf.onDrawFrame(paramGL10);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion())
    {
      this.jdField_d_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(l2 - l1 + this.jdField_c_of_type_Int));
      if (this.jdField_d_of_type_Int % 100 == 0) {
        Log.i("wing", "scan line anime cameraRenderer cost---- " + this.jdField_c_of_type_Int * 1.0F / Math.max(1, this.jdField_d_of_type_Int));
      }
    }
    paramGL10 = this.jdField_a_of_type_Amqs;
    if ((paramGL10 != null) && (paramGL10.d()))
    {
      System.currentTimeMillis();
      GLES20.glEnable(2929);
      amra localamra = this.jdField_a_of_type_Amqz.a(paramGL10.b(), paramGL10.c());
      if (localamra != null) {
        paramGL10.a(localamra);
      }
      GLES20.glDisable(2929);
      System.currentTimeMillis();
    }
    System.currentTimeMillis();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Amrf.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Amqz.jdField_a_of_type_Long;
  }
  
  public amqz a()
  {
    return this.jdField_a_of_type_Amqz;
  }
  
  public anbv a()
  {
    return this;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
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
    this.jdField_a_of_type_Amrf.b(paramInt);
  }
  
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startCameraPreviewRender. textureId = " + paramInt1 + ", surfaceTexture = " + paramSurfaceTexture);
    this.jdField_a_of_type_Amrf.a(paramInt1, paramSurfaceTexture);
    this.jdField_a_of_type_Amrf.a(paramInt2, paramInt3, paramInt4, paramInt5);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_Amqz.a(paramArrayOfFloat);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Amqz.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(amqs paramamqs, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.a()) && (this.jdField_a_of_type_Amqt != null)) {
      this.jdField_a_of_type_Amqt.a(paramArCloudConfigInfo, paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(amqt paramamqt)
  {
    this.jdField_a_of_type_Amqt = paramamqt;
  }
  
  public void a(amqx paramamqx)
  {
    this.jdField_a_of_type_Amqz.a(paramamqx);
  }
  
  public void a(andf paramandf)
  {
    this.jdField_a_of_type_Andf = paramandf;
  }
  
  public void a(VideoRecordController paramVideoRecordController)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = paramVideoRecordController;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, amqu paramamqu)
  {
    if (this.jdField_a_of_type_Amqt == null) {
      return;
    }
    this.jdField_a_of_type_Amqt.a(paramArVideoResourceInfo, paramamqu);
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
    this.jdField_a_of_type_Amrf.a(paramFloatBuffer, paramSize);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "start.");
    return true;
  }
  
  public boolean a(amqw paramamqw)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. resourceInfo.key = " + paramamqw.jdField_a_of_type_JavaLangString + ", resourceInfo.arType = " + paramamqw.jdField_a_of_type_Int + ", resourceInfo.trackMode = " + paramamqw.jdField_b_of_type_Int);
    if (!this.e)
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "startModelRender. fail because of render not ready");
      return false;
    }
    amqs localamqs2 = a(paramamqw.jdField_a_of_type_JavaLangString);
    amqs localamqs1 = localamqs2;
    if (localamqs2 == null)
    {
      localamqs1 = amqy.a(this, paramamqw, this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here 1" + localamqs1);
      this.jdField_a_of_type_JavaUtilMap.put(paramamqw.jdField_a_of_type_JavaLangString, localamqs1);
      QLog.d("AREngine_UniformGLRenderManagerImpl", 1, "crate new render here " + localamqs1);
    }
    if (localamqs1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HSRender", 1, "onARStateChanged, renderable == null");
      }
      paramamqw = this.jdField_a_of_type_Amqs;
      this.jdField_a_of_type_Amqs = null;
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.1(this, paramamqw));
      return false;
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new UniformGLRenderManagerImpl.2(this, localamqs1, paramamqw));
    return true;
  }
  
  public boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "init.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amqs = null;
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "enableCameraPreviewScanLine. isEnable = " + paramBoolean + ", endY = " + paramFloat2);
    if (this.jdField_a_of_type_Amrf != null)
    {
      this.jdField_a_of_type_Amrf.a(paramBoolean);
      this.jdField_a_of_type_Amrf.a(paramFloat2);
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
        ((amqs)localIterator.next()).f();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_Amqs = null;
      this.jdField_a_of_type_Amrf.g();
      this.jdField_a_of_type_Amqz.a();
      this.e = false;
      this.jdField_d_of_type_Boolean = true;
      try
      {
        if (this.jdField_a_of_type_Axqx != null)
        {
          this.jdField_a_of_type_Axqx.a();
          this.jdField_a_of_type_Axqx = null;
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
    if ((this.jdField_a_of_type_Amqt == null) || (this.jdField_a_of_type_Amqs == null))
    {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "notifyAnimationPlayStatusChange.mCurrentRenderable or mOutCallBack is null");
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Amqt.a(this.jdField_a_of_type_Amqs.c(), paramInt2);
      return;
    case 1: 
      this.jdField_a_of_type_Amqt.c(this.jdField_a_of_type_Amqs.c(), paramInt2);
      return;
    case 2: 
      this.jdField_a_of_type_Amqt.b(this.jdField_a_of_type_Amqs.c(), paramInt2);
      return;
    }
    this.jdField_a_of_type_Amqt.d(this.jdField_a_of_type_Amqs.c(), paramInt2);
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Amqz.c = paramLong;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amrf != null) {
      return this.jdField_a_of_type_Amrf.a();
    }
    return false;
  }
  
  public void c()
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "uninit.");
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Amqt = null;
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
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_Axqx, i, j);
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
      if (this.jdField_a_of_type_Amqt != null) {
        this.jdField_a_of_type_Amqt.a(null, 1001, 0, localBitmap);
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
    if (this.jdField_a_of_type_Andf != null) {
      this.jdField_a_of_type_Andf.a(paramGL10, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_Amrf.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Amqt != null) {
      this.jdField_a_of_type_Amqt.a();
    }
    this.e = true;
    this.jdField_a_of_type_Boolean = true;
    GLES20.glEnable(2884);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "onSurfaceCreated.");
    this.jdField_d_of_type_Boolean = false;
    if (amql.a()) {
      this.jdField_a_of_type_Axqx = new axqx(EGL14.eglGetCurrentContext(), 1);
    }
    amnr.a().a(paramGL10.glGetString(7937));
    this.jdField_a_of_type_Amrf.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (this.jdField_a_of_type_Andf != null) {
      this.jdField_a_of_type_Andf.a(paramGL10);
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
    amub.a(paramGL10.glGetString(7937), paramGL10.glGetString(7936), paramGL10.glGetString(7938), paramEGLConfig.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbw
 * JD-Core Version:    0.7.0.1
 */