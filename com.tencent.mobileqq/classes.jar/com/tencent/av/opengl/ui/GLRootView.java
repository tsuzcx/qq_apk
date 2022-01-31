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
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import lsa;
import lsv;
import lsw;
import ltu;
import lty;
import lue;
import lui;
import luj;
import lum;
import lux;
import mcr;
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
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private lsv jdField_a_of_type_Lsv;
  public luj a;
  private mcr jdField_a_of_type_Mcr;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
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
        break label162;
      }
    }
    label162:
    for (bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
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
    setEGLContextClientVersion(lux.a(paramContext));
    if (this.jdField_a_of_type_Boolean)
    {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(-3);
    }
    for (;;)
    {
      setRenderer(this);
      if (!lsa.a()) {
        break;
      }
      this.jdField_a_of_type_Mcr = new mcr();
      return;
      if (lux.jdField_b_of_type_Boolean)
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
  
  private void b()
  {
    this.jdField_c_of_type_Int &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.jdField_a_of_type_Luj != null) && (i != 0) && (j != 0)) {
      this.jdField_a_of_type_Luj.b(0, 0, i, j);
    }
  }
  
  public mcr a()
  {
    return this.jdField_a_of_type_Mcr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_Luj != null)
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
    this.jdField_a_of_type_Lsv.d();
    lue.g();
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_c_of_type_Int & 0x2) != 0) {
      b();
    }
    if (this.jdField_a_of_type_Luj != null) {
      this.jdField_a_of_type_Luj.a(this.jdField_a_of_type_Lsv);
    }
    for (;;)
    {
      if (lue.e()) {
        requestRender();
      }
      return;
      this.jdField_a_of_type_Lsv.a();
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Luj != null) && ((this.jdField_a_of_type_Luj instanceof VideoLayerUI)) && (((VideoLayerUI)this.jdField_a_of_type_Luj).c(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  /* Error */
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 255	com/tencent/av/opengl/ui/GLRootView:isEnabled	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual 260	android/view/MotionEvent:getAction	()I
    //   13: istore_2
    //   14: iload_2
    //   15: iconst_3
    //   16: if_icmpeq +8 -> 24
    //   19: iload_2
    //   20: iconst_1
    //   21: if_icmpne +68 -> 89
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 262	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Boolean	Z
    //   29: aload_0
    //   30: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   33: ldc2_w 263
    //   36: getstatic 270	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   39: invokevirtual 274	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq +88 -> 132
    //   47: aload_0
    //   48: getfield 206	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Luj	Lluj;
    //   51: ifnull +51 -> 102
    //   54: aload_0
    //   55: getfield 206	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Luj	Lluj;
    //   58: aload_1
    //   59: invokevirtual 276	luj:b	(Landroid/view/MotionEvent;)Z
    //   62: ifeq +40 -> 102
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_2
    //   68: ifne +12 -> 80
    //   71: iload_3
    //   72: ifeq +8 -> 80
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 262	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Boolean	Z
    //   80: aload_0
    //   81: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   84: invokevirtual 218	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: iload_3
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 262	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Boolean	Z
    //   93: ifne -64 -> 29
    //   96: iload_2
    //   97: ifeq -68 -> 29
    //   100: iconst_0
    //   101: ireturn
    //   102: iconst_0
    //   103: istore_3
    //   104: goto -37 -> 67
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: invokevirtual 218	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 80	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: iconst_1
    //   123: ldc_w 278
    //   126: aload_1
    //   127: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_0
    //   133: getfield 80	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: iconst_1
    //   137: ldc_w 278
    //   140: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iconst_0
    //   144: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	GLRootView
    //   0	145	1	paramMotionEvent	MotionEvent
    //   13	84	2	i	int
    //   42	62	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   47	65	107	finally
    //   75	80	107	finally
    //   29	43	117	java/lang/InterruptedException
    //   80	87	117	java/lang/InterruptedException
    //   108	117	117	java/lang/InterruptedException
    //   132	143	117	java/lang/InterruptedException
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: invokestatic 285	ltu:a	()V
    //   3: aload_0
    //   4: invokespecial 287	android/opengl/GLSurfaceView:finalize	()V
    //   7: invokestatic 86	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   10: ifeq +14 -> 24
    //   13: aload_0
    //   14: getfield 80	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: iconst_1
    //   18: ldc_w 289
    //   21: invokestatic 92	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: invokespecial 287	android/opengl/GLSurfaceView:finalize	()V
    //   30: goto -23 -> 7
    //   33: astore_1
    //   34: aload_0
    //   35: invokespecial 287	android/opengl/GLSurfaceView:finalize	()V
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	GLRootView
    //   25	1	1	localException	Exception
    //   33	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	3	25	java/lang/Exception
    //   0	3	33	finally
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.e)
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
    lui.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f);
      GLES20.glClear(16640);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      label144:
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
          break label314;
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
        break label144;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Luj != null))
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Luj.e();
      }
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      a();
    }
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Luj instanceof lum)) {
      queueEvent(new GLRootView.2(this));
    }
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
    this.jdField_a_of_type_Lsv.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_Lsv = new lsw();
      lty.d();
      if (this.jdField_a_of_type_Mcr != null) {
        this.jdField_a_of_type_Mcr.a();
      }
      if ((this.jdField_a_of_type_Luj != null) && ((this.jdField_a_of_type_Luj instanceof lum))) {
        ((lum)this.jdField_a_of_type_Luj).j();
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      ltu.a();
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
  
  public void setContentPane(luj paramluj)
  {
    if (this.jdField_a_of_type_Luj == paramluj) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Luj != null)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.jdField_a_of_type_Luj.b(localMotionEvent);
          localMotionEvent.recycle();
          this.jdField_c_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Luj.a();
        lty.c();
      }
      this.jdField_a_of_type_Luj = paramluj;
    } while (paramluj == null);
    paramluj.a(this);
    a();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "STest. surfaceCreated. sCreatedSurfaceCnt = " + jdField_d_of_type_Int);
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_d_of_type_Int -= 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "STest. surfaceDestroyed. sCreatedSurfaceCnt = " + jdField_d_of_type_Int);
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */