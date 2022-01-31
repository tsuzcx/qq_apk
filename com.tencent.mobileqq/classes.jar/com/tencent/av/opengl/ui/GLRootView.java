package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.UploadedTexture;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.switchface.SwitchFaceView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import jjy;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  final int jdField_a_of_type_Int = 20;
  long jdField_a_of_type_Long = 0L;
  private GLCanvas jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
  public GLView a;
  private SwitchFaceView jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jjy(this);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.newCondition();
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e = true;
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    CameraUtils.a(paramContext);
    GraphicRenderMgr.loadSo();
    if (isInEditMode()) {
      return;
    }
    this.jdField_c_of_type_Int |= 0x1;
    setBackgroundDrawable(null);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GLRootView, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(0, false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GLRootView", 2, "GLRootView e = " + localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    setEGLContextClientVersion(Utils.a(paramContext));
    if (this.jdField_a_of_type_Boolean)
    {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(-3);
    }
    for (;;)
    {
      setRenderer(this);
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView = new SwitchFaceView();
      return;
      if (Utils.jdField_b_of_type_Boolean)
      {
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        getHolder().setFormat(3);
      }
      else
      {
        setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        getHolder().setFormat(4);
      }
    }
  }
  
  private void c()
  {
    this.jdField_c_of_type_Int &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) && (i != 0) && (j != 0)) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(0, 0, i, j);
    }
  }
  
  public SwitchFaceView a()
  {
    return this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
      {
        i = this.jdField_c_of_type_Int;
        if ((i & 0x2) == 0) {}
      }
      else
      {
        return;
      }
      int i = this.jdField_c_of_type_Int;
      if ((i & 0x1) == 0) {
        return;
      }
      this.jdField_c_of_type_Int |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void a(GL10 paramGL10)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.d();
    UploadedTexture.g();
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_c_of_type_Int & 0x2) != 0) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.c(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
    }
    for (;;)
    {
      if (UploadedTexture.f()) {
        requestRender();
      }
      return;
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signalAll();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) && ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView instanceof VideoLayerUI)) && (((VideoLayerUI)this.jdField_a_of_type_ComTencentAvOpenglUiGLView).c(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.d = false;
    }
    do
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(paramMotionEvent)) {
            bool1 = true;
          }
        }
        if ((i == 0) && (bool1)) {
          this.d = true;
        }
        return bool1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    } while ((this.d) || (i == 0));
    return false;
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: invokestatic 238	com/tencent/av/opengl/program/TextureProgramFactory:a	()V
    //   3: aload_0
    //   4: invokevirtual 240	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   7: aload_0
    //   8: invokespecial 242	android/opengl/GLSurfaceView:finalize	()V
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual 240	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   17: aload_0
    //   18: invokespecial 242	android/opengl/GLSurfaceView:finalize	()V
    //   21: return
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 240	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   27: aload_0
    //   28: invokespecial 242	android/opengl/GLSurfaceView:finalize	()V
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	GLRootView
    //   12	1	1	localException	Exception
    //   22	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	3	12	java/lang/Exception
    //   0	3	22	finally
  }
  
  protected void onDetachedFromWindow()
  {
    b();
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    long l = SystemClock.elapsedRealtime();
    AnimationTime.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f);
      GLES20.glClear(16640);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      while (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.awaitUninterruptibly();
      }
    }
    label94:
    try
    {
      if (this.jdField_b_of_type_Int > 0) {
        this.jdField_b_of_type_Int -= 1;
      }
    }
    finally {}
    try
    {
      a(paramGL10);
    }
    catch (Exception paramGL10)
    {
      this.jdField_b_of_type_Boolean = false;
      if (!QLog.isColorLevel()) {
        break label287;
      }
      QLog.e("GLRootView", 2, "WL_DEBUG onDrawFrame e = " + paramGL10);
      StackTraceElement[] arrayOfStackTraceElement = paramGL10.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      paramGL10 = "";
      int i = 0;
      while (i < j)
      {
        paramGL10 = paramGL10 + "WL_DEBUG onDrawFrame ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.e("GLRootView", 2, paramGL10);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      break label94;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    if ((this.e) && (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null))
    {
      this.e = false;
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.d();
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    QLog.e("GLRootView", 2, "WL_DEBUG onDrawFrame cost = " + (this.jdField_a_of_type_Long - l));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      a();
    }
  }
  
  public void onPause()
  {
    b();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GLRootView", 2, "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
    }
    Process.setThreadPriority(-4);
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = new GLES20Canvas();
      BasicTexture.d();
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView.a();
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      TextureProgramFactory.a();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if ((l > 0L) && (l < 20L))
    {
      try
      {
        if (this.jdField_b_of_type_Int >= 2) {
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_Int += 1;
      super.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L - l);
      return;
    }
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setContentPane(GLView paramGLView)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView == paramGLView) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null)
      {
        if (this.d)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(localMotionEvent);
          localMotionEvent.recycle();
          this.d = false;
        }
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView.u();
        BasicTexture.c();
      }
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView = paramGLView;
    } while (paramGLView == null);
    paramGLView.a(this);
    a();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    b();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    b();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */