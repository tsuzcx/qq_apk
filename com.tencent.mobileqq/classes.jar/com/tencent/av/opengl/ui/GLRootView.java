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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import jmb;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  final int jdField_a_of_type_Int = 20;
  final long jdField_a_of_type_Long = AudioHelper.a();
  private GLCanvas jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
  public GLView a;
  private SwitchFaceView jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jmb(this);
  private final String jdField_a_of_type_JavaLangString = "GLRootView_" + this.jdField_a_of_type_Long;
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.newCondition();
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
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
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "GLRootView, 构造");
    }
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
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "GLRootView e = " + localException);
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
    //   0: invokestatic 260	com/tencent/av/opengl/program/TextureProgramFactory:a	()V
    //   3: aload_0
    //   4: invokevirtual 262	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   7: aload_0
    //   8: invokespecial 264	android/opengl/GLSurfaceView:finalize	()V
    //   11: invokestatic 93	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   14: ifeq +14 -> 28
    //   17: aload_0
    //   18: getfield 87	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: iconst_1
    //   22: ldc_w 266
    //   25: invokestatic 99	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 262	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   34: aload_0
    //   35: invokespecial 264	android/opengl/GLSurfaceView:finalize	()V
    //   38: goto -27 -> 11
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 262	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   46: aload_0
    //   47: invokespecial 264	android/opengl/GLSurfaceView:finalize	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	GLRootView
    //   29	1	1	localException	Exception
    //   41	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	3	29	java/lang/Exception
    //   0	3	41	finally
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
        break label293;
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onDrawFrame e = " + paramGL10);
      StackTraceElement[] arrayOfStackTraceElement = paramGL10.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      paramGL10 = "";
      int i = 0;
      while (i < j)
      {
        paramGL10 = paramGL10 + "WL_DEBUG onDrawFrame ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, paramGL10);
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
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onDrawFrame cost = " + (this.jdField_b_of_type_Long - l));
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
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
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
    long l = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */