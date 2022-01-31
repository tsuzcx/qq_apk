package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import lpu;
import lqo;
import lqp;
import lrn;
import lrr;
import lrx;
import lsb;
import lsc;
import lsf;
import lsq;
import mac;
import mqq.os.MqqHandler;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static int jdField_d_of_type_Int;
  final int jdField_a_of_type_Int = 20;
  final long jdField_a_of_type_Long = AudioHelper.b();
  private Runnable jdField_a_of_type_JavaLangRunnable = new GLRootView.1(this);
  private final String jdField_a_of_type_JavaLangString = "GLRootView_" + this.jdField_a_of_type_Long;
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.newCondition();
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private lqo jdField_a_of_type_Lqo;
  public lsc a;
  private mac jdField_a_of_type_Mac;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f;
  
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
    boolean bool1 = bool2;
    if (!Build.MODEL.equalsIgnoreCase("MI 9")) {
      if (!Build.MODEL.equalsIgnoreCase("MI 9 Transparent Edition")) {
        break label173;
      }
    }
    label173:
    for (bool1 = bool2;; bool1 = false)
    {
      this.f = bool1;
      CameraUtils.a(paramContext);
      GraphicRenderMgr.loadSo();
      if (!isInEditMode()) {
        break;
      }
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
    setEGLContextClientVersion(lsq.a(paramContext));
    if (this.jdField_a_of_type_Boolean)
    {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(-3);
    }
    for (;;)
    {
      setRenderer(this);
      if (!lpu.a()) {
        break;
      }
      this.jdField_a_of_type_Mac = new mac();
      return;
      if (lsq.jdField_b_of_type_Boolean)
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
    if ((this.jdField_a_of_type_Lsc != null) && (i != 0) && (j != 0)) {
      this.jdField_a_of_type_Lsc.b(0, 0, i, j);
    }
  }
  
  public mac a()
  {
    return this.jdField_a_of_type_Mac;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_Lsc != null)
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
  
  protected void a(GL10 paramGL10)
  {
    this.jdField_a_of_type_Lqo.d();
    lrx.g();
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_c_of_type_Int & 0x2) != 0) {
      c();
    }
    if (this.jdField_a_of_type_Lsc != null) {
      this.jdField_a_of_type_Lsc.a(this.jdField_a_of_type_Lqo);
    }
    for (;;)
    {
      if (lrx.e()) {
        requestRender();
      }
      return;
      this.jdField_a_of_type_Lqo.a();
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
    if ((this.jdField_a_of_type_Lsc != null) && ((this.jdField_a_of_type_Lsc instanceof VideoLayerUI)) && (((VideoLayerUI)this.jdField_a_of_type_Lsc).c(paramMotionEvent))) {
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
      this.jdField_d_of_type_Boolean = false;
    }
    do
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this.jdField_a_of_type_Lsc != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Lsc.b(paramMotionEvent)) {
            bool1 = true;
          }
        }
        if ((i == 0) && (bool1)) {
          this.jdField_d_of_type_Boolean = true;
        }
        return bool1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    } while ((this.jdField_d_of_type_Boolean) || (i == 0));
    return false;
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: invokestatic 281	lrn:a	()V
    //   3: aload_0
    //   4: invokevirtual 283	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   7: aload_0
    //   8: invokespecial 285	android/opengl/GLSurfaceView:finalize	()V
    //   11: invokestatic 94	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   14: ifeq +14 -> 28
    //   17: aload_0
    //   18: getfield 88	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: iconst_1
    //   22: ldc_w 287
    //   25: invokestatic 100	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 283	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   34: aload_0
    //   35: invokespecial 285	android/opengl/GLSurfaceView:finalize	()V
    //   38: goto -27 -> 11
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 283	com/tencent/av/opengl/ui/GLRootView:b	()V
    //   46: aload_0
    //   47: invokespecial 285	android/opengl/GLSurfaceView:finalize	()V
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
    if (this.f)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      if (jdField_d_of_type_Int != 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "onDrawFrame failed. sCreatedSurfaceCnt = " + jdField_d_of_type_Int);
        this.jdField_b_of_type_Boolean = false;
        requestRender();
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    SystemClock.elapsedRealtime();
    lsb.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f1);
      GLES20.glClear(16640);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      while (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.awaitUninterruptibly();
      }
    }
    label168:
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
        break label333;
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
      break label168;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    if ((this.e) && (this.jdField_a_of_type_Lsc != null))
    {
      this.e = false;
      this.jdField_a_of_type_Lsc.e();
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      a();
    }
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Lsc instanceof lsf)) {
      queueEvent(new GLRootView.2(this));
    }
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
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceChanged: error system callback - width or height is Zero value");
    }
    Process.setThreadPriority(-4);
    this.jdField_a_of_type_Lqo.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_Lqo = new lqp();
      lrr.d();
      if (this.jdField_a_of_type_Mac != null) {
        this.jdField_a_of_type_Mac.a();
      }
      if ((this.jdField_a_of_type_Lsc != null) && ((this.jdField_a_of_type_Lsc instanceof lsf))) {
        ((lsf)this.jdField_a_of_type_Lsc).j();
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      lrn.a();
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
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setContentPane(lsc paramlsc)
  {
    if (this.jdField_a_of_type_Lsc == paramlsc) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Lsc != null)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.jdField_a_of_type_Lsc.b(localMotionEvent);
          localMotionEvent.recycle();
          this.jdField_d_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Lsc.a();
        lrr.c();
      }
      this.jdField_a_of_type_Lsc = paramlsc;
    } while (paramlsc == null);
    paramlsc.a(this);
    a();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.f)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "STest. surfaceCreated. sCreatedSurfaceCnt = " + jdField_d_of_type_Int);
    b();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.f)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_d_of_type_Int -= 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "STest. surfaceDestroyed. sCreatedSurfaceCnt = " + jdField_d_of_type_Int);
    b();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */