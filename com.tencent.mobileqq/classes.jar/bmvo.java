import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class bmvo
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String jdField_a_of_type_JavaLangString = bmvo.class.getSimpleName();
  int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bmvq jdField_a_of_type_Bmvq;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public bmvo(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    e();
    b();
    d();
  }
  
  private void a(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bmvq = new bmvq();
    this.jdField_a_of_type_Bmvq.a();
    if (this.jdField_b_of_type_Boolean) {
      Log.d(jdField_a_of_type_JavaLangString, "textureID=" + this.jdField_a_of_type_Bmvq.a());
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Bmvq.a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int * 4);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    int i = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    a("eglCreateContext");
    if (this.jdField_a_of_type_AndroidOpenglEGLContext == null) {
      throw new RuntimeException("null context");
    }
    i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
    a("eglCreatePbufferSurface");
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
  }
  
  public Bitmap a()
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_JavaNioByteBuffer.rewind();
      GLES20.glReadPixels(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_a_of_type_JavaNioByteBuffer.rewind();
      localBitmap.copyPixelsFromBuffer(this.jdField_a_of_type_JavaNioByteBuffer);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getFrameBitmap() OOM!");
    }
    return null;
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_Bmvq = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bmvq.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramBoolean);
  }
  
  public void b()
  {
    if (!EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(2500L);
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bmvq.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.d(jdField_a_of_type_JavaLangString, " new frame available");
    if (this.jdField_b_of_type_Boolean) {
      Log.d(jdField_a_of_type_JavaLangString, "new frame available");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvo
 * JD-Core Version:    0.7.0.1
 */