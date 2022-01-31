package com.tencent.TMG.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.texture.UploadedTexture;
import com.tencent.TMG.opengl.utils.Utils;
import com.tencent.TMG.utils.QLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final boolean DEBUG_DRAWING_STAT = false;
  private static final boolean DEBUG_FPS = false;
  private static final int FLAG_INITIALIZED = 1;
  private static final int FLAG_NEED_LAYOUT = 2;
  private static final String TAG = "GLRootView";
  private GLCanvas mCanvas;
  protected GLView mContentView;
  private boolean mFirstDraw = true;
  private int mFlags = 2;
  private int mFrameCount = 0;
  private long mFrameCountingStart = 0L;
  private boolean mFreeze;
  private final Condition mFreezeCondition = this.mRenderLock.newCondition();
  private GL11 mGL;
  private boolean mInDownState = false;
  long mLastRenderTime = 0L;
  private final ReentrantLock mRenderLock = new ReentrantLock();
  private volatile boolean mRenderRequested = false;
  private Runnable mRequestRenderOnAnimationFrame = new Runnable()
  {
    public void run()
    {
      GLRootView.this.superRequestRender();
    }
  };
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    this.mFlags |= 0x1;
    setBackgroundDrawable(null);
    setEGLContextClientVersion(Utils.getGLVersion(paramContext));
    if (Utils.USE_888_PIXEL_FORMAT) {
      setEGLConfigChooser(8, 8, 8, 0, 0, 0);
    }
    for (;;)
    {
      setRenderer(this);
      if (!Utils.USE_888_PIXEL_FORMAT) {
        break;
      }
      getHolder().setFormat(3);
      return;
      setEGLConfigChooser(5, 6, 5, 0, 0, 0);
    }
    getHolder().setFormat(4);
  }
  
  private void layoutContentPane()
  {
    this.mFlags &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.mContentView != null) && (i != 0) && (j != 0)) {
      this.mContentView.layout(0, 0, i, j);
    }
  }
  
  private void outputFps()
  {
    long l = System.nanoTime();
    if (this.mFrameCountingStart == 0L) {
      this.mFrameCountingStart = l;
    }
    for (;;)
    {
      this.mFrameCount += 1;
      return;
      if (l - this.mFrameCountingStart > 1000000000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GLRootView", 0, "fps: " + this.mFrameCount * 1000000000.0D / (l - this.mFrameCountingStart));
        }
        this.mFrameCountingStart = l;
        this.mFrameCount = 0;
      }
    }
  }
  
  private void superRequestRender()
  {
    super.requestRender();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1)) {
      this.mInDownState = false;
    }
    do
    {
      this.mRenderLock.lock();
      boolean bool1 = bool2;
      try
      {
        if (this.mContentView != null)
        {
          bool1 = bool2;
          if (this.mContentView.dispatchTouchEvent(paramMotionEvent)) {
            bool1 = true;
          }
        }
        if ((i == 0) && (bool1)) {
          this.mInDownState = true;
        }
        return bool1;
      }
      finally
      {
        this.mRenderLock.unlock();
      }
    } while ((this.mInDownState) || (i == 0));
    return false;
  }
  
  public void freeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = true;
    this.mRenderLock.unlock();
  }
  
  public void lockRenderThread()
  {
    this.mRenderLock.lock();
  }
  
  protected void onDetachedFromWindow()
  {
    unfreeze();
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    AnimationTime.update();
    this.mRenderLock.lock();
    while (this.mFreeze) {
      this.mFreezeCondition.awaitUninterruptibly();
    }
    try
    {
      onDrawFrameLocked(paramGL10);
      this.mRenderLock.unlock();
      if ((this.mFirstDraw) && (this.mContentView != null))
      {
        this.mFirstDraw = false;
        this.mContentView.onFirstDraw();
      }
      this.mLastRenderTime = SystemClock.elapsedRealtime();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  protected void onDrawFrameLocked(GL10 paramGL10)
  {
    this.mCanvas.deleteRecycledResources();
    UploadedTexture.resetUploadLimit();
    this.mRenderRequested = false;
    if ((this.mFlags & 0x2) != 0) {
      layoutContentPane();
    }
    if (this.mContentView != null) {
      this.mContentView.render(this.mCanvas);
    }
    for (;;)
    {
      if (UploadedTexture.uploadLimitReached()) {
        requestRender();
      }
      return;
      this.mCanvas.clearBuffer();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      requestLayoutContentPane();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    freeze();
  }
  
  public void onResume()
  {
    unfreeze();
    super.onResume();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GLRootView", 0, "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
    }
    Process.setThreadPriority(-4);
    this.mCanvas.setSize(paramInt1, paramInt2);
  }
  
  /* Error */
  public void onSurfaceCreated(GL10 paramGL10, javax.microedition.khronos.egl.EGLConfig paramEGLConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 297	javax/microedition/khronos/opengles/GL11
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 299	com/tencent/TMG/opengl/ui/GLRootView:mGL	Ljavax/microedition/khronos/opengles/GL11;
    //   9: ifnull +48 -> 57
    //   12: invokestatic 153	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   15: ifeq +42 -> 57
    //   18: ldc 21
    //   20: iconst_0
    //   21: new 155	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 301
    //   31: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 299	com/tencent/TMG/opengl/ui/GLRootView:mGL	Ljavax/microedition/khronos/opengles/GL11;
    //   38: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc_w 306
    //   44: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 175	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 64	com/tencent/TMG/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   61: invokevirtual 191	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   64: aload_0
    //   65: aload_1
    //   66: putfield 299	com/tencent/TMG/opengl/ui/GLRootView:mGL	Ljavax/microedition/khronos/opengles/GL11;
    //   69: aload_0
    //   70: invokevirtual 310	com/tencent/TMG/opengl/ui/GLRootView:getContext	()Landroid/content/Context;
    //   73: invokevirtual 315	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   76: invokestatic 95	com/tencent/TMG/opengl/utils/Utils:getGLVersion	(Landroid/content/Context;)I
    //   79: iconst_2
    //   80: if_icmplt +32 -> 112
    //   83: new 317	com/tencent/TMG/opengl/glrenderer/GLES20Canvas
    //   86: dup
    //   87: invokespecial 318	com/tencent/TMG/opengl/glrenderer/GLES20Canvas:<init>	()V
    //   90: astore_1
    //   91: aload_0
    //   92: aload_1
    //   93: putfield 231	com/tencent/TMG/opengl/ui/GLRootView:mCanvas	Lcom/tencent/TMG/opengl/glrenderer/GLCanvas;
    //   96: invokestatic 323	com/tencent/TMG/opengl/texture/BasicTexture:invalidateAllTextures	()V
    //   99: aload_0
    //   100: getfield 64	com/tencent/TMG/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   103: invokevirtual 196	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   106: aload_0
    //   107: iconst_0
    //   108: invokevirtual 326	com/tencent/TMG/opengl/ui/GLRootView:setRenderMode	(I)V
    //   111: return
    //   112: new 328	com/tencent/TMG/opengl/glrenderer/GLES11Canvas
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 331	com/tencent/TMG/opengl/glrenderer/GLES11Canvas:<init>	(Ljavax/microedition/khronos/opengles/GL11;)V
    //   120: astore_1
    //   121: goto -30 -> 91
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 64	com/tencent/TMG/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   129: invokevirtual 196	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	GLRootView
    //   0	134	1	paramGL10	GL10
    //   0	134	2	paramEGLConfig	javax.microedition.khronos.egl.EGLConfig
    // Exception table:
    //   from	to	target	type
    //   64	91	124	finally
    //   91	99	124	finally
    //   112	121	124	finally
  }
  
  public void requestLayoutContentPane()
  {
    this.mRenderLock.lock();
    try
    {
      if (this.mContentView != null)
      {
        i = this.mFlags;
        if ((i & 0x2) == 0) {}
      }
      else
      {
        return;
      }
      int i = this.mFlags;
      if ((i & 0x1) == 0) {
        return;
      }
      this.mFlags |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.mRenderRequested)
    {
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 30L);
      return;
    }
    this.mRenderRequested = true;
    long l = SystemClock.elapsedRealtime() - this.mLastRenderTime;
    if ((l > 0L) && (l < 33L))
    {
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 33L - l);
      return;
    }
    if (Utils.HAS_POST_ON_ANIMATION)
    {
      postOnAnimation(this.mRequestRenderOnAnimationFrame);
      return;
    }
    super.requestRender();
  }
  
  public void requestRenderForced()
  {
    superRequestRender();
  }
  
  public void setContentPane(GLView paramGLView)
  {
    if (this.mContentView == paramGLView) {}
    do
    {
      return;
      if (this.mContentView != null)
      {
        if (this.mInDownState)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.mContentView.dispatchTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
          this.mInDownState = false;
        }
        this.mContentView.detachFromRoot();
        BasicTexture.yieldAllTextures();
      }
      this.mContentView = paramGLView;
    } while (paramGLView == null);
    paramGLView.attachToRoot(this);
    requestLayoutContentPane();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    unfreeze();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public void unfreeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = false;
    this.mFreezeCondition.signalAll();
    this.mRenderLock.unlock();
  }
  
  public void unlockRenderThread()
  {
    this.mRenderLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */